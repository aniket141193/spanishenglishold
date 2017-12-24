package com.spanish.english.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spanish.english.DTO.MachineCollectionComparatorDESC;
import com.spanish.english.DTO.MachineHistoryComparatorDESC;
import com.spanish.english.DTO.MachineProblemsDTO;
import com.spanish.english.form.AgreedPercentage;
import com.spanish.english.form.Coins;
import com.spanish.english.form.CoinsCollection;
import com.spanish.english.form.Establishment;
import com.spanish.english.form.InputMoneyPaymentDevice;
import com.spanish.english.form.Machine;
import com.spanish.english.form.MachineCollection;
import com.spanish.english.form.MachineHistory;
import com.spanish.english.form.MachineProblems;
import com.spanish.english.form.Notes;
import com.spanish.english.form.NotesCollection;
import com.spanish.english.form.Operator;
import com.spanish.english.form.OtherExpenses;
import com.spanish.english.form.PaymentDeviceType;
import com.spanish.english.form.Phone;
import com.spanish.english.form.PlayersGift;
import com.spanish.english.form.RepairHistory;
import com.spanish.english.form.Technician;
import com.spanish.english.form.TempMachine;
import com.spanish.english.form.Tokens;
import com.spanish.english.form.TokensCollection;
import com.spanish.english.services.CoinsServices;
import com.spanish.english.services.CollectionServices;
import com.spanish.english.services.CountryServices;
import com.spanish.english.services.EstablishmentServices;
import com.spanish.english.services.InputMoneyPaymentDeviceServices;
import com.spanish.english.services.MachineHistoryServices;
import com.spanish.english.services.MachineProblemsServices;
import com.spanish.english.services.MachineServices;
import com.spanish.english.services.NotesServices;
import com.spanish.english.services.OperatorServices;
import com.spanish.english.services.OutputMoneyPaymentDeviceServices;
import com.spanish.english.services.PartialCounterServices;
import com.spanish.english.services.PercentageDistributionServices;
import com.spanish.english.services.PhoneServices;
import com.spanish.english.services.RepairHistoryServices;
import com.spanish.english.services.SparePartsServices;
import com.spanish.english.services.TechnicianServices;
import com.spanish.english.services.TempMachineServices;
import com.spanish.english.services.TokensServices;
import com.spanish.english.services.TotalCounterServices;

@Controller
@RequestMapping("/operator")
public class OperatorController {

	@Autowired
	MachineServices machineServices;

	@Autowired
	OperatorServices operatorServices;

	@Autowired
	EstablishmentServices establishmentServices;

	@Autowired
	TotalCounterServices totalCounterServices;

	@Autowired
	PartialCounterServices partialCounterServices;

	@Autowired
	CountryServices countryServices;

	@Autowired
	CollectionServices collectionServices;

	@Autowired
	TechnicianServices technicianServices;

	@Autowired
	RepairHistoryServices repairHistoryServices;

	@Autowired
	InputMoneyPaymentDeviceServices inputMoneyPaymentDeviceServices;

	@Autowired
	OutputMoneyPaymentDeviceServices outputMoneyPaymentDeviceServices;

	@Autowired
	CoinsServices coinsServices;

	@Autowired
	TokensServices tokensServices;

	@Autowired
	NotesServices notesServices;

	@Autowired
	MachineHistoryServices machineHistoryServices;

	@Autowired
	SparePartsServices sparePartsServices;

	@Autowired
	MachineProblemsServices machineProblemsServices;

	@Autowired
	PercentageDistributionServices percentageDistributionServices;

	@Autowired
	PhoneServices phoneServices;

	@Autowired
	TempMachineServices tempMachineServices;

	private static byte[] key;
	private static SecretKeySpec secretKey;

	@RequestMapping("/establishments")
	public String establishmentOperator(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();

		Operator loggedOperator = operatorServices
				.getOperatorByUsername(userName);

		Set<Machine> machineList = machineServices
				.getMachineListByOperatorId(loggedOperator.getId());

		Set<Establishment> establishmentList = new HashSet<Establishment>();

		for (Machine machine : machineList) {

			establishmentList.add(machine.getEstablishment());
		}

		model.addAttribute(new Establishment());
		model.addAttribute("establishmentList", establishmentList);
		return "establishmentOperator";
	}

	@RequestMapping("/machine")
	public String machineHome(@ModelAttribute("machine") Machine machine,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();

		Operator loggedOperator = operatorServices
				.getOperatorByUsername(userName);

		Set<Machine> machineList = machineServices
				.getMachineListByOperatorId(loggedOperator.getId());

		model.addAttribute("machineActive", "machineActive");
		model.addAttribute(new Machine());
		model.addAttribute("machineList", machineList);
		model.addAttribute("userId", loggedOperator.getId());
		return "machineOperator";
	}

	@RequestMapping(value = "/unassignMachined", method = RequestMethod.POST)
	public String unassignMachined(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		String machineIdStr = request.getParameter("machineId");
		String establishmentIdStr = request.getParameter("establishmentId");

		boolean isEstablishment = false;

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();

		Machine machine = machineServices.getMachineById(Long
				.parseLong(machineIdStr));

		Set<AgreedPercentage> apList = percentageDistributionServices
				.getAgreedPercentageByMachine(machine.getId());

		Set<PlayersGift> pgList = percentageDistributionServices
				.getPlayersGiftByMachine(machine.getId());

		Set<OtherExpenses> oeList = percentageDistributionServices
				.getOtherExpensesByMachine(machine.getId());

		if (establishmentIdStr.equals("0")) {

			if (machine.getEstablishment() != null) {
				isEstablishment = true;
				machine.setEstablishment(null);
				machine.setMachineFund(0.0);
				machine.setEstablishmentFund(0.0);
				machineServices.addOrUpdateMachine(machine);
				for (AgreedPercentage agreedPercentage : apList) {
					if (agreedPercentage.getRole().equals("est")) {
						agreedPercentage.setEstablishment(null);
						agreedPercentage.setValue(null);
						percentageDistributionServices
								.addOrUpdateAgreedPercentge(agreedPercentage);
					}
				}

				for (PlayersGift playersGift : pgList) {
					if (playersGift.getRole().equals("est")) {
						playersGift.setEstablishment(null);
						playersGift.setValue(null);
						percentageDistributionServices
								.addOrUpdatePlayersGift(playersGift);
					}
				}

				for (OtherExpenses otherExpenses : oeList) {
					if (otherExpenses.getRole().equals("est")) {
						otherExpenses.setEstablishment(null);
						otherExpenses.setValue(null);
						percentageDistributionServices
								.addOrUpdateOtherExpenses(otherExpenses);
					}
				}
				/*
				 * Set<MachinePercentageMapping> mmpList = machineServices
				 * .getMachinePercentageMappingByMachineId(machine.getId()); for
				 * (MachinePercentageMapping machinePercentageMapping : mmpList)
				 * { if (machinePercentageMapping.getEstablishment() != null) {
				 * 
				 * MachineUserMapping mum = machineServices
				 * .getMachineUserMappingByMPMId(machinePercentageMapping
				 * .getId());
				 * machineServices.deleteMachineUserMapping(mum.getId());
				 * machineServices
				 * .deleteMachinePercentageMapping(machinePercentageMapping
				 * .getId()); } }
				 */
			}
		}

		if (isEstablishment && machine.getOperator() != null) {
			machine.setMachineStatus("assignedToOperator");

			// add machine history
			MachineHistory machineHistory = new MachineHistory();
			machineHistory.setMovementDate(new Date());
			machineHistory.setOperator(machine.getOperator());
			machineHistory.setMachine(machine);
			machineHistoryServices.addMachineHistory(machineHistory);
		} else if (machine.getOperator() != null
				&& machine.getEstablishment() != null) {
			machine.setMachineStatus("assignedToEstablishment");
			// add machine history
			MachineHistory machineHistory = new MachineHistory();
			machineHistory.setMovementDate(new Date());
			machineHistory.setEstablishment(machine.getEstablishment());
			machineHistory.setMachine(machine);
			machineHistoryServices.addMachineHistory(machineHistory);
		}

		machineServices.addOrUpdateMachine(machine);

		Operator loggedOperator = operatorServices
				.getOperatorByUsername(userName);

		Set<Machine> machineList = machineServices
				.getMachineListByOperatorId(loggedOperator.getId());

		model.addAttribute("machineActive", "machineActive");
		model.addAttribute(new Machine());
		model.addAttribute("machineList", machineList);
		model.addAttribute("userId", loggedOperator.getId());
		return "machineOperator";

	}

	@RequestMapping(value = "/getMachineData", method = RequestMethod.POST)
	public @ResponseBody String getMachineData(
			@RequestParam("machineId") String machineId) {

		System.out.println("machineId: " + machineId);
		Machine machine = machineServices.getMachineById(Long
				.parseLong(machineId));
		String result;

		if (machine.getEstablishment() != null) {
			result = String.valueOf(machine.getEstablishment().getId());
			result = result + ","
					+ machine.getEstablishment().getEstablishmentName();
		} else {
			result = "0,not present";
		}

		return result;
	}

	@RequestMapping("/assignMachines")
	public String assignMachines(@ModelAttribute("machine") Machine machine,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		System.out.println("logged userName:" + userName);
		Operator loggedOperator = operatorServices
				.getOperatorByUsername(userName);

		Set<Machine> machineList = machineServices
				.getMachineListByOperatorId(loggedOperator.getId());
		Set<Establishment> establishmentList = establishmentServices
				.getEstablishmentList();

		model.addAttribute("machineList", machineList);
		model.addAttribute("establishmentList", establishmentList);

		Set<Machine> machineSetEst = machineServices
				.getMachineListByStatus("assignedToEstablishment");

		Set<Machine> machineSet = new HashSet<Machine>(machineSetEst);

		model.addAttribute("machineSet", machineSet);

		return "assignMachineOperator";
	}

	@RequestMapping(value = "/assignMachined", method = RequestMethod.POST)
	public String assignMachined(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();

		Operator loggedOperator = operatorServices
				.getOperatorByUsername(userName);

		String mID = request.getParameter("machineID");
		String eID = request.getParameter("establishmentID");

		long machineID = Long.parseLong(mID);
		long establishmentID = Long.parseLong(eID);
		Machine machine = machineServices.getMachineById(machineID);
		Establishment establishment = establishmentServices
				.getEstablishmentById(establishmentID);

		machine.setEstablishment(establishment);
		machine.setMachineStatus("assignedToEstablishment");
		machineServices.addOrUpdateMachine(machine);

		// add machine history
		MachineHistory machineHistory = new MachineHistory();
		machineHistory.setMovementDate(new Date());
		machineHistory.setEstablishment(establishment);
		machineHistory.setMachine(machine);
		machineHistoryServices.addMachineHistory(machineHistory);

		Set<AgreedPercentage> agList = percentageDistributionServices
				.getAgreedPercentageByMachine(machineID);
		for (AgreedPercentage agreedPercentage : agList) {
			if (agreedPercentage.getRole().equals("est")) {
				agreedPercentage.setEstablishment(establishment);
				percentageDistributionServices
						.addOrUpdateAgreedPercentge(agreedPercentage);
				break;
			}
		}

		Set<PlayersGift> pgList = percentageDistributionServices
				.getPlayersGiftByMachine(machineID);
		for (PlayersGift playersGift : pgList) {
			if (playersGift.getRole().equals("est")) {
				playersGift.setEstablishment(establishment);
				percentageDistributionServices
						.addOrUpdatePlayersGift(playersGift);
				break;
			}
		}

		Set<OtherExpenses> oeList = percentageDistributionServices
				.getOtherExpensesByMachine(machineID);
		for (OtherExpenses otherExpenses : oeList) {
			if (otherExpenses.getRole().equals("est")) {
				otherExpenses.setEstablishment(establishment);
				percentageDistributionServices
						.addOrUpdateOtherExpenses(otherExpenses);
				break;
			}
		}
		/*
		 * Set<MachineUserMapping> mumSet = machineServices
		 * .getMachineUserMappingListByMachine(machineID);
		 * List<MachineUserMapping> mumList = new ArrayList<MachineUserMapping>(
		 * mumSet); for (MachineUserMapping machineUserMapping : mumList) { if
		 * (machineUserMapping.getUserId() == null) {
		 * machineUserMapping.setUserId(establishmentID); machineServices
		 * .addOrUpdateMachineUserMapping(machineUserMapping); } }
		 */
		Set<Machine> machineList = machineServices
				.getMachineListByOperatorId(loggedOperator.getId());
		model.addAttribute("machineActive", "machineActive");
		model.addAttribute(new Machine());
		model.addAttribute("machineList", machineList);
		model.addAttribute("userId", loggedOperator.getId());
		return "machineOperator";
	}

	/*
	 * @RequestMapping("/collection") public String collection(
	 * 
	 * @ModelAttribute("collection") Collection collection, HttpServletRequest
	 * request, HttpServletResponse response, ModelMap model) {
	 * 
	 * String userName = SecurityContextHolder.getContext()
	 * .getAuthentication().getName(); System.out.println("logged userName:" +
	 * userName); Operator loggedOperator = operatorServices
	 * .getOperatorByUsername(userName);
	 * 
	 * Set<Machine> machineList = machineServices
	 * .getMachineListByOperatorId(loggedOperator.getId());
	 * 
	 * model.addAttribute("machineActive", "machineActive");
	 * model.addAttribute(new Machine()); model.addAttribute("machineList",
	 * machineList);
	 * 
	 * return "collection"; }
	 */

	/*
	 * @RequestMapping("/collectionList") public String collectionList(
	 * 
	 * @ModelAttribute("collection") Collection collection, HttpServletRequest
	 * request, HttpServletResponse response, ModelMap model) {
	 * 
	 * System.out.println("machineID:" + request.getParameter("machineID"));
	 * 
	 * String action = "action"; action = request.getParameter("action"); if
	 * (action.equals("edit")) {
	 * collectionServices.addOrUpdateCollection(collection); }
	 * 
	 * model.addAttribute("machineID", request.getParameter("machineID"));
	 * 
	 * Set<Collection> collectionList = collectionServices
	 * .getCollectionListByMachineId(Long.parseLong(request
	 * .getParameter("machineID")));
	 * 
	 * model.addAttribute("collectionList", collectionList);
	 * model.addAttribute(new Collection()); return "collectionList"; }
	 */
	/*
	 * @RequestMapping("/addCollection") public String
	 * addCollection(@RequestParam("machineID") String machineID,
	 * HttpServletRequest request, HttpServletResponse response, ModelMap model)
	 * {
	 * 
	 * String userName = SecurityContextHolder.getContext()
	 * .getAuthentication().getName(); System.out.println("logged userName:" +
	 * userName); Operator loggedOperator = operatorServices
	 * .getOperatorByUsername(userName); Country country =
	 * countryServices.getCountryByName("USA");
	 * 
	 * System.out.println("machineID:" + machineID); Machine machine =
	 * machineServices.getMachineById(Long .parseLong(machineID));
	 * 
	 * TotalCounter totalCounter = totalCounterServices
	 * .getTotalCounterByMachineId(machine.getId());
	 * 
	 * long previousInput = totalCounter.getPreviousInput(); long previousOutput
	 * = totalCounter.getPreviousOutput();
	 * 
	 * long currentInput = totalCounter.getCurrentInput(); long currentOutput =
	 * totalCounter.getCurrentOutput();
	 * 
	 * long lastTimestampLong = totalCounter.getTimestamp();
	 * 
	 * PartialCounter partialCounter = partialCounterServices
	 * .getPartialCounterByMachineId(machine.getId());
	 * 
	 * long partialInput = partialCounter.getInput(); long partialOutput =
	 * partialCounter.getOutput();
	 * 
	 * long currentTimestampLong = System.currentTimeMillis() / 1000;
	 * 
	 * Timestamp currentTimestamp = new Timestamp(currentTimestampLong * 1000);
	 * Timestamp lastTimestamp = new Timestamp(lastTimestampLong * 1000);
	 * 
	 * // Date currentDate = new Date(currentTimestamp.getTime());
	 * 
	 * String currentTimestampStr = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
	 * .format(currentTimestamp); String lastTimestampStr = new
	 * SimpleDateFormat("MM/dd/yyyy HH:mm:ss") .format(lastTimestamp); String
	 * period = lastTimestampStr + " To " + currentTimestampStr;
	 * 
	 * double profitMarginInPercentage = 0.0;
	 * 
	 * double theoreticalCollection = 0.0;
	 * 
	 * double diffrence = 0.0; double differenceInPercentage = 0.0;
	 * 
	 * if (((currentInput - previousInput) == partialInput) && ((currentOutput -
	 * previousOutput) == partialOutput)) { // theoreticalCollection =
	 * ((partialInput - partialOutput) * // machine.getBaseValue())/100;
	 * profitMarginInPercentage = ((partialInput - partialOutput) * 100) /
	 * partialInput; } Collection collection = new Collection();
	 * collection.setDate(currentTimestampStr); //
	 * collection.setMachine(machine);
	 * collection.setProfitMarginInPercenatge(profitMarginInPercentage);
	 * collection.setPeriod(period);
	 * collection.setCurrency(country.getCurrency());
	 * collection.setTheoreticalCollection(theoreticalCollection);
	 * collection.setDiffrence(diffrence);
	 * collection.setDifferenceInPercentage(differenceInPercentage);
	 * 
	 * collectionServices.addOrUpdateCollection(collection);
	 * 
	 * Set<Collection> collectionList = collectionServices
	 * .getCollectionListByMachineId(Long.parseLong(machineID));
	 * 
	 * model.addAttribute("collectionList", collectionList);
	 * model.addAttribute(new Collection()); return "collectionList";
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/addTotalCounter/", method = RequestMethod.POST,
	 * headers = "content-type=application/json") public @ResponseBody void
	 * updateRestaurant(
	 * 
	 * @RequestBody TotalCounterDTO totalCounterDTO, HttpServletRequest request,
	 * HttpServletResponse response) throws Exception {
	 * 
	 * Map<String, Object> obj = new HashMap<String, Object>();
	 * 
	 * response.setContentType("application/json; charset=UTF-8");
	 * response.getWriter().print( new JSONSerializer().exclude("class",
	 * "*.class", "authorities") .deepSerialize(obj)); }
	 */
	@RequestMapping(value = "/technician")
	public String allestablishmentList(
			@ModelAttribute("technician") Technician technician,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		Operator loggedOperator = operatorServices
				.getOperatorByUsername(userName);

		String action = "action";
		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
		}

		if (action != null) {
			if (action.equals("add")) {
				technician.setOperator(loggedOperator);
				technician.setTechnicianRole("ROLE_TECHNICIAN");
				if (technicianServices.addOrUpdateTechnician(technician)) {
					System.out.println("technician added");
				}
				Technician lastTechnician = technicianServices
						.getLastTechnician();

				String telephone[] = request.getParameterValues("telephone");
				String telephoneType[] = request
						.getParameterValues("telephoneType");

				if (telephone != null && telephoneType != null) {
					for (int i = 0; i < telephoneType.length; i++) {
						Phone phone = new Phone();
						phone.setNo(telephone[i]);
						phone.setType(telephoneType[i]);
						phone.setTechnician(lastTechnician);
						phoneServices.addOrUpdatePhone(phone);
					}
				}
			} else if (action.equals("edit")) {
				Technician oldTechnician = technicianServices
						.getTechnicianById(technician.getId());
				oldTechnician.setAddress(technician.getAddress());

				oldTechnician.setTechnicianName(technician.getTechnicianName());
				if (technicianServices.addOrUpdateTechnician(oldTechnician)) {
					System.out.println("technician edited");
				}
				String telephone[] = request.getParameterValues("telephone");
				String telephoneType[] = request
						.getParameterValues("telephoneType");

				Set<Phone> phones = oldTechnician.getPhones();
				for (int i = 0; i < telephoneType.length; i++) {
					for (Phone phone : phones) {
						if (telephoneType[i].equals(phone.getType())) {
							phone.setNo(telephone[i]);
							phoneServices.addOrUpdatePhone(phone);
							break;
						}
					}
				}
			}
		}
		Set<Technician> technicianList = technicianServices
				.getTechnicianListByOperator(loggedOperator.getId());
		for (Technician technician2 : technicianList) {
			System.out.println(technician2.getTechnicianName());
			Set<Phone> phs = technician2.getPhones();
			for (Phone phone : phs) {
				System.out.println("phone:" + phone.getNo());
			}
		}
		model.addAttribute("technicianActive", "technicianActive");
		model.addAttribute(new Technician());
		model.addAttribute("technicianList", technicianList);

		return "technicianOperatorList";
	}

	@RequestMapping("/assignMachinesTechnician")
	public String assignMachinesTechnician(
			@ModelAttribute("machine") Machine machine,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		Operator loggedOperator = operatorServices
				.getOperatorByUsername(userName);

		Set<Machine> machineList = machineServices
				.getMachineListByOperatorId(loggedOperator.getId());
		Set<Technician> technicianList = technicianServices
				.getTechnicianListByOperator(loggedOperator.getId());

		model.addAttribute("machineList", machineList);
		model.addAttribute("technicianList", technicianList);

		return "assignMachineTechnicianOperator";
	}

	@RequestMapping(value = "/assignMachinedTechnician", method = RequestMethod.POST)
	public String assignMachinedTechnician(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		Operator loggedOperator = operatorServices
				.getOperatorByUsername(userName);

		String mID = request.getParameter("machineID");
		String tID = request.getParameter("technicianID");

		long machineID = Long.parseLong(mID);
		Machine machine = machineServices.getMachineById(machineID);

		Technician technician = technicianServices.getTechnicianById(Long
				.parseLong(tID));

		machine.setTechnician(technician);
		machine.setMachineStatus("assignedToTechnician");

		machineServices.addOrUpdateMachine(machine);

		Set<Technician> technicianList = technicianServices
				.getTechnicianListByOperator(loggedOperator.getId());
		model.addAttribute("technicianActive", "technicianActive");
		model.addAttribute(new Technician());
		model.addAttribute("technicianList", technicianList);
		return "technicianOperatorList";
	}

	@RequestMapping(value = "/reportProblem")
	public String reportProblem(@RequestParam("machineId") String machineIdStr,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		Operator loggedOperator = operatorServices
				.getOperatorByUsername(userName);

		Machine machine = machineServices.getMachineById(Long
				.parseLong(machineIdStr));

		RepairHistory repairHistory = new RepairHistory();
		repairHistory.setReportedByOperator(loggedOperator);
		repairHistory.setMachine(machine);
		long currentTimestampLong = System.currentTimeMillis();
		repairHistory.setReportedTime(currentTimestampLong);
		String currentTimestampStr = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
				.format(currentTimestampLong);
		repairHistory.setStatus("pending");
		repairHistory.setReportedTimeStr(currentTimestampStr);
		repairHistoryServices.addOrUpdateRepairHistory(repairHistory);

		Set<Machine> machineList = machineServices
				.getMachineListByOperatorId(loggedOperator.getId());

		model.addAttribute("machineActive", "machineActive");
		model.addAttribute(new Machine());
		model.addAttribute("machineList", machineList);
		model.addAttribute("userId", loggedOperator.getId());
		return "machineOperator";
	}

	@RequestMapping(value = "/viewMachineHistory")
	public String viewMachineHistory(@RequestParam("machineId") long machineId,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		Set<MachineHistory> machineHistoryList = machineHistoryServices
				.getMachineHistoryByMachineId(machineId);

		model.addAttribute("machineHistoryList", machineHistoryList);
		return "viewHistoryOperator";
	}

	@RequestMapping(value = "/viewHistory")
	public String viewHistory(
			@RequestParam("machineId") String machineIdStr,
			@ModelAttribute("machineProblemsDTO") MachineProblemsDTO machineProblems,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		Set<RepairHistory> repairHistoryList = new HashSet<RepairHistory>();
		repairHistoryList = repairHistoryServices
				.getRepairHistoryByMachineId(Long.parseLong(machineIdStr));

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		Operator loggedOperator = operatorServices
				.getOperatorByUsername(userName);

		Set<MachineProblems> machineProblemsList = machineProblemsServices
				.getMachineProblemsList();

		model.addAttribute("repairHistoryList", repairHistoryList);
		model.addAttribute("machineId", machineIdStr);
		model.addAttribute("role", "operator");
		model.addAttribute("userId", loggedOperator.getId());
		model.addAttribute("machineProblemsList", machineProblemsList);
		return "viewMachineProblemOperator";
	}

	@RequestMapping(value = "/checkEstablishmentAssignment", method = RequestMethod.GET)
	public @ResponseBody String checkEstablishmentAssignment(
			@RequestParam("machineId") String machineIdStr) {

		// boolean flag = false;
		/*
		 * Set<MachineUserMapping> mumList = machineServices
		 * .getMachineUserMappingListByMachine(Long .parseLong(machineIdStr));
		 * if (mumList.size() != 0) { for (MachineUserMapping machineUserMapping
		 * : mumList) { if (machineUserMapping.getUserId() == null) { flag =
		 * false; break; } } } else { flag = false; }
		 */
		Machine machine = machineServices.getMachineById(Long
				.parseLong(machineIdStr));
		if (machine.getEstablishment() != null) {
			return "1";
		} else {
			return "0";
		}
	}

	@RequestMapping(value = "/collection")
	public String collection(@RequestParam("machineId") String machineIdStr,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		model.addAttribute("machineID", machineIdStr);
		Set<MachineCollection> mcList = machineServices
				.getMachineCollectionByMachineId(Long.parseLong(machineIdStr));
		model.addAttribute("mcList", mcList);
		return "collectionEstablishment";
	}

	// @RequestMapping(value = "/newcollection")
	// public String newcollection(@RequestParam("machineId") String
	// machineIdStr,
	// HttpServletRequest request, HttpServletResponse response,
	// ModelMap model) {
	//
	// model.addAttribute("machineID", machineIdStr);
	// return "collectionEstablishmentDate";
	// }

	@RequestMapping(value = "/newcollection")
	public String newcollection(
			@RequestParam("establishmentId") String establishmentIdStr,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		Establishment establishment = establishmentServices
				.getEstablishmentById(Long.parseLong(establishmentIdStr));

		for (Machine machine : establishment.getMachine()) {
			TempMachine tempMachine = new TempMachine(machine,
					machine.getOperator(), machine.getEstablishment(), false);
			tempMachineServices.saveTempMachine(tempMachine);
		}

		model.addAttribute("establishmentId", establishmentIdStr);
		return "collectionEstablishmentDate";
	}

	// @RequestMapping(value = "/machinecollection")
	// public String machinecollection(HttpServletRequest request,
	// HttpServletResponse response, ModelMap model) {
	//
	// Machine machine = machineServices.getMachineById(Long.parseLong(request
	// .getParameter("machineID")));
	// model.addAttribute("machineID", machine.getId());
	//
	// Date startDate = null;
	// Date endDate;
	// // get start date
	// Set<MachineCollection> mcSet = machineServices
	// .getMachineCollectionByMachineId(machine.getId());
	//
	// if (mcSet.size() != 0) {
	// List<MachineCollection> mcList = new ArrayList<MachineCollection>(
	// mcSet);
	// Collections.sort(mcList, new MachineCollectionComparatorDESC());
	// startDate = mcList.get(0).getEndDate();
	// } else {
	// Set<MachineHistory> machineHistorySet = machineHistoryServices
	// .getMachineHistoryByMachineId(machine.getId());
	// if (machineHistorySet.size() != 0) {
	// List<MachineHistory> machineHistoryList = new ArrayList<MachineHistory>(
	// machineHistorySet);
	// Collections.sort(machineHistoryList,
	// new MachineHistoryComparatorDESC());
	// startDate = machineHistoryList.get(0).getMovementDate();
	// }
	// }
	//
	// MachineCollection mc = new MachineCollection();
	// mc.setMachine(machine);
	//
	// // String startDateString = request.getParameter("startDate");
	// String endDateString = request.getParameter("endDate");
	// DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
	//
	// try {
	// // startDate = df.parse(startDateString);
	// endDate = df.parse(endDateString);
	// mc.setStartDate(startDate);
	// mc.setEndDate(endDate);
	//
	// } catch (ParseException e) {
	// e.printStackTrace();
	// }
	//
	// machineServices.addOrUpdateMachineCollection(mc);
	//
	// MachineCollection oldmc = machineServices.lastMachineCollection();
	//
	// Set<PaymentDeviceType> paymentDeviceTypeSet = machine.getMachineType()
	// .getPaymentDeviceType();
	//
	// List<PaymentDeviceType> paymentDeviceTypeList = new
	// ArrayList<PaymentDeviceType>(
	// paymentDeviceTypeSet);
	//
	// Set<Coins> coins = new HashSet<Coins>();
	// Set<Tokens> tokens = new HashSet<Tokens>();
	// Set<Notes> notes = new HashSet<Notes>();
	//
	// for (PaymentDeviceType paymentDeviceType : paymentDeviceTypeList) {
	// Set<InputMoneyPaymentDevice> impdSet = inputMoneyPaymentDeviceServices
	// .getInputMoneyPaymentDeviceListByPaymentDeviceType(paymentDeviceType
	// .getId());
	// for (InputMoneyPaymentDevice inputMoneyPaymentDevice : impdSet) {
	// if (inputMoneyPaymentDevice.getCoins() != null) {
	// coins.add(inputMoneyPaymentDevice.getCoins());
	// } else if (inputMoneyPaymentDevice.getTokens() != null) {
	// tokens.add(inputMoneyPaymentDevice.getTokens());
	// } else if (inputMoneyPaymentDevice.getNotes() != null) {
	// notes.add(inputMoneyPaymentDevice.getNotes());
	// }
	// }
	//
	// /*
	// * Set<OutputMoneyPaymentDevice> ompd =
	// * outputMoneyPaymentDeviceServices
	// * .getOutputMoneyPaymentDeviceListByPaymentDeviceType
	// * (paymentDeviceType .getId()); for (OutputMoneyPaymentDevice
	// * outputMoneyPaymentDevice : ompd) { if
	// * (outputMoneyPaymentDevice.getCoins() != null) {
	// * coins.add(outputMoneyPaymentDevice.getCoins()); } else if
	// * (outputMoneyPaymentDevice.getTokens() != null) {
	// * tokens.add(outputMoneyPaymentDevice.getTokens()); } else if
	// * (outputMoneyPaymentDevice.getNotes() != null) {
	// * notes.add(outputMoneyPaymentDevice.getNotes()); } }
	// */
	// }
	//
	// model.addAttribute("machineID", machine.getId());
	// model.addAttribute("coins", coins);
	// model.addAttribute("tokens", tokens);
	// model.addAttribute("notes", notes);
	// model.addAttribute("machineCollectionId", oldmc.getId());
	// return "machinecollectionestablishment";
	// }

	@RequestMapping(value = "/machinecollection")
	public String machinecollection(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		Establishment establishment = establishmentServices
				.getEstablishmentById(Long.parseLong(request
						.getParameter("establishmentId")));

		Set<TempMachine> tempMachineList = tempMachineServices
				.getTempMachineListByEstablishment(establishment);
		boolean isDone = true;
		Machine machine = null;
		for (TempMachine tempMachine : tempMachineList) {
			if (!tempMachine.isDone()) {
				machine = tempMachine.getMachine();
				isDone = false;
				break;
			}
		}

		if (!isDone) {
			Date startDate = null;
			Date endDate;
			// get start date
			Set<MachineCollection> mcSet = machineServices
					.getMachineCollectionByMachineId(machine.getId());

			if (mcSet.size() != 0) {
				List<MachineCollection> mcList = new ArrayList<MachineCollection>(
						mcSet);
				Collections.sort(mcList, new MachineCollectionComparatorDESC());
				startDate = mcList.get(0).getEndDate();
			} else {
				Set<MachineHistory> machineHistorySet = machineHistoryServices
						.getMachineHistoryByMachineId(machine.getId());
				if (machineHistorySet.size() != 0) {
					List<MachineHistory> machineHistoryList = new ArrayList<MachineHistory>(
							machineHistorySet);
					Collections.sort(machineHistoryList,
							new MachineHistoryComparatorDESC());
					startDate = machineHistoryList.get(0).getMovementDate();
				}
			}

			MachineCollection mc = new MachineCollection();
			mc.setMachine(machine);

			// String startDateString = request.getParameter("startDate");
			String endDateString = request.getParameter("endDate");
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

			try {
				// startDate = df.parse(startDateString);
				endDate = df.parse(endDateString);
				mc.setStartDate(startDate);
				mc.setEndDate(endDate);

			} catch (ParseException e) {
				e.printStackTrace();
			}

			machineServices.addOrUpdateMachineCollection(mc);

			MachineCollection oldmc = machineServices.lastMachineCollection();

			Set<PaymentDeviceType> paymentDeviceTypeSet = machine
					.getMachineType().getPaymentDeviceType();

			List<PaymentDeviceType> paymentDeviceTypeList = new ArrayList<PaymentDeviceType>(
					paymentDeviceTypeSet);

			Set<Coins> coins = new HashSet<Coins>();
			Set<Tokens> tokens = new HashSet<Tokens>();
			Set<Notes> notes = new HashSet<Notes>();

			for (PaymentDeviceType paymentDeviceType : paymentDeviceTypeList) {
				Set<InputMoneyPaymentDevice> impdSet = inputMoneyPaymentDeviceServices
						.getInputMoneyPaymentDeviceListByPaymentDeviceType(paymentDeviceType
								.getId());
				for (InputMoneyPaymentDevice inputMoneyPaymentDevice : impdSet) {
					if (inputMoneyPaymentDevice.getCoins() != null) {
						coins.add(inputMoneyPaymentDevice.getCoins());
					} else if (inputMoneyPaymentDevice.getTokens() != null) {
						tokens.add(inputMoneyPaymentDevice.getTokens());
					} else if (inputMoneyPaymentDevice.getNotes() != null) {
						notes.add(inputMoneyPaymentDevice.getNotes());
					}
				}

			}

			model.addAttribute("machineID", machine.getId());
			model.addAttribute("machineID", machine.getId());
			model.addAttribute("coins", coins);
			model.addAttribute("tokens", tokens);
			model.addAttribute("notes", notes);
			model.addAttribute("machineCollectionId", oldmc.getId());
			return "machinecollectionestablishment";
		} else {
			String userName = SecurityContextHolder.getContext()
					.getAuthentication().getName();

			Operator loggedOperator = operatorServices
					.getOperatorByUsername(userName);

			Set<Machine> machineList = machineServices
					.getMachineListByOperatorId(loggedOperator.getId());

			Set<Establishment> establishmentList = new HashSet<Establishment>();

			for (Machine m : machineList) {

				establishmentList.add(m.getEstablishment());
			}

			model.addAttribute(new Establishment());
			model.addAttribute("establishmentList", establishmentList);
			return "establishmentOperator";
		}

	}

	@RequestMapping(value = "/machinecollectionestablishment")
	public String machinecollectionestablishment(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		Machine machine = machineServices.getMachineById(Long.parseLong(request
				.getParameter("machineID")));

		MachineCollection mc = machineServices.getMachineCollectionById(Long
				.parseLong(request.getParameter("machineCollectionID")));

		double machineCollection = 0.0;

		String coinId[] = request.getParameterValues("coinId");

		String coinNo[] = request.getParameterValues("coinNo");
		for (int i = 0; i < coinNo.length; i++) {
			CoinsCollection cc = new CoinsCollection();
			Coins coin = coinsServices.getCoinsById(Long.parseLong(coinId[i]));
			cc.setCollectionType("machine");
			cc.setNumberOfCount(Long.parseLong(coinNo[i]));
			cc.setCoins(coin);
			double value = coin.getValue() * Long.parseLong(coinNo[i]);
			cc.setValue(value);
			cc.setMachine(machine);
			cc.setMachineCollection(mc);
			coinsServices.addOrUpdateCoinsCollection(cc);
			machineCollection = machineCollection + value;
		}

		String tokenId[] = request.getParameterValues("tokenId");
		String tokenNo[] = request.getParameterValues("tokenNo");
		for (int i = 0; i < tokenNo.length; i++) {
			TokensCollection tc = new TokensCollection();
			Tokens token = tokensServices.getTokensById(Long
					.parseLong(tokenId[i]));
			tc.setCollectionType("machine");
			tc.setNumberOfCount(Long.parseLong(tokenNo[i]));
			tc.setTokens(token);
			double value = token.getValue() * Long.parseLong(tokenNo[i]);
			tc.setValue(value);
			tc.setMachine(machine);
			tc.setMachineCollection(mc);
			tokensServices.addOrUpdateTokensCollection(tc);
			machineCollection = machineCollection + value;
		}

		String noteId[] = request.getParameterValues("noteId");
		String noteNo[] = request.getParameterValues("noteNo");
		for (int i = 0; i < noteNo.length; i++) {
			NotesCollection nc = new NotesCollection();
			Notes notes = notesServices.getNotesById(Long.parseLong(noteId[i]));
			nc.setCollectionType("machine");
			nc.setNumberOfCount(Long.parseLong(noteNo[i]));
			nc.setNotes(notes);
			double value = notes.getValue() * Long.parseLong(noteNo[i]);
			nc.setValue(value);
			nc.setMachine(machine);
			nc.setMachineCollection(mc);
			notesServices.addOrUpdateNotesCollection(nc);
			machineCollection = machineCollection + value;
		}

		mc.setMachineCollection(machineCollection);
		machineServices.addOrUpdateMachineCollection(mc);

		Set<PaymentDeviceType> paymentDeviceTypeSet = machine.getMachineType()
				.getPaymentDeviceType();

		List<PaymentDeviceType> paymentDeviceTypeList = new ArrayList<PaymentDeviceType>(
				paymentDeviceTypeSet);

		Set<Coins> coins = new HashSet<Coins>();
		Set<Tokens> tokens = new HashSet<Tokens>();
		Set<Notes> notes = new HashSet<Notes>();

		for (PaymentDeviceType paymentDeviceType : paymentDeviceTypeList) {
			Set<InputMoneyPaymentDevice> impdSet = inputMoneyPaymentDeviceServices
					.getInputMoneyPaymentDeviceListByPaymentDeviceType(paymentDeviceType
							.getId());
			for (InputMoneyPaymentDevice inputMoneyPaymentDevice : impdSet) {
				if (inputMoneyPaymentDevice.getCoins() != null) {
					coins.add(inputMoneyPaymentDevice.getCoins());
				} else if (inputMoneyPaymentDevice.getTokens() != null) {
					tokens.add(inputMoneyPaymentDevice.getTokens());
				} else if (inputMoneyPaymentDevice.getNotes() != null) {
					notes.add(inputMoneyPaymentDevice.getNotes());
				}
			}
		}

		model.addAttribute("machineID", machine.getId());
		model.addAttribute("coins", coins);
		model.addAttribute("tokens", tokens);
		model.addAttribute("notes", notes);
		model.addAttribute("machineCollectionId", mc.getId());

		return "manualcollectionestablishment";
	}

	@RequestMapping(value = "/manualcollectionestablishment")
	public String manualcollectionestablishment(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		Machine machine = machineServices.getMachineById(Long.parseLong(request
				.getParameter("machineID")));

		MachineCollection mc = machineServices.getMachineCollectionById(Long
				.parseLong(request.getParameter("machineCollectionID")));

		double manualCollection = 0.0;

		String coinId[] = request.getParameterValues("coinId");

		String coinNo[] = request.getParameterValues("coinNo");
		for (int i = 0; i < coinNo.length; i++) {
			CoinsCollection cc = new CoinsCollection();
			Coins coin = coinsServices.getCoinsById(Long.parseLong(coinId[i]));
			cc.setCollectionType("manual");
			cc.setNumberOfCount(Long.parseLong(coinNo[i]));
			cc.setCoins(coin);
			double value = coin.getValue() * Long.parseLong(coinNo[i]);
			cc.setValue(value);
			cc.setMachine(machine);
			cc.setMachineCollection(mc);
			coinsServices.addOrUpdateCoinsCollection(cc);
			manualCollection = manualCollection + value;
		}

		String tokenId[] = request.getParameterValues("tokenId");
		String tokenNo[] = request.getParameterValues("tokenNo");
		for (int i = 0; i < tokenNo.length; i++) {
			TokensCollection tc = new TokensCollection();
			Tokens token = tokensServices.getTokensById(Long
					.parseLong(tokenId[i]));
			tc.setCollectionType("manual");
			tc.setNumberOfCount(Long.parseLong(tokenNo[i]));
			tc.setTokens(token);
			double value = token.getValue() * Long.parseLong(tokenNo[i]);
			tc.setValue(value);
			tc.setMachine(machine);
			tc.setMachineCollection(mc);
			tokensServices.addOrUpdateTokensCollection(tc);
			manualCollection = manualCollection + value;
		}

		String noteId[] = request.getParameterValues("noteId");
		String noteNo[] = request.getParameterValues("noteNo");
		for (int i = 0; i < noteNo.length; i++) {
			NotesCollection nc = new NotesCollection();
			Notes notes = notesServices.getNotesById(Long.parseLong(noteId[i]));
			nc.setCollectionType("manual");
			nc.setNumberOfCount(Long.parseLong(noteNo[i]));
			nc.setNotes(notes);
			double value = notes.getValue() * Long.parseLong(noteNo[i]);
			nc.setValue(value);
			nc.setMachine(machine);
			nc.setMachineCollection(mc);
			notesServices.addOrUpdateNotesCollection(nc);
			manualCollection = manualCollection + value;
		}

		mc.setManualCollection(manualCollection);
		machineServices.addOrUpdateMachineCollection(mc);

		Set<PaymentDeviceType> paymentDeviceTypeSet = machine.getMachineType()
				.getPaymentDeviceType();

		List<PaymentDeviceType> paymentDeviceTypeList = new ArrayList<PaymentDeviceType>(
				paymentDeviceTypeSet);

		Set<Coins> coins = new HashSet<Coins>();
		Set<Tokens> tokens = new HashSet<Tokens>();
		Set<Notes> notes = new HashSet<Notes>();

		for (PaymentDeviceType paymentDeviceType : paymentDeviceTypeList) {
			Set<InputMoneyPaymentDevice> impdSet = inputMoneyPaymentDeviceServices
					.getInputMoneyPaymentDeviceListByPaymentDeviceType(paymentDeviceType
							.getId());
			for (InputMoneyPaymentDevice inputMoneyPaymentDevice : impdSet) {
				if (inputMoneyPaymentDevice.getCoins() != null) {
					coins.add(inputMoneyPaymentDevice.getCoins());
				} else if (inputMoneyPaymentDevice.getTokens() != null) {
					tokens.add(inputMoneyPaymentDevice.getTokens());
				} else if (inputMoneyPaymentDevice.getNotes() != null) {
					notes.add(inputMoneyPaymentDevice.getNotes());
				}
			}
		}

		model.addAttribute("machineID", machine.getId());
		model.addAttribute("coins", coins);
		model.addAttribute("tokens", tokens);
		model.addAttribute("notes", notes);
		model.addAttribute("machineCollectionId", mc.getId());

		return "collectionestablishmentdata";
	}

	@RequestMapping(value = "/unlockMachines")
	public String unlockMachines(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();

		Operator loggedOperator = operatorServices
				.getOperatorByUsername(userName);

		Set<Machine> machineList = new HashSet<Machine>();

		for (Machine machine : machineServices
				.getMachineListByOperatorId(loggedOperator.getId())) {
			if (machine.getSelfLock()) {
				machineList.add(machine);
			}

		}

		model.addAttribute(new Machine());
		model.addAttribute("machineList", machineList);
		model.addAttribute("userId", loggedOperator.getId());
		return "unlockMachines";
	}

	@RequestMapping(value = "/generateOutputKey")
	public String generateOutputKey(@RequestParam("machineId") long machineId,
			@RequestParam("inputKey") String inputKey,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();

		Operator loggedOperator = operatorServices
				.getOperatorByUsername(userName);

		final String secretKey = "alfredospain";

		String encryptedString = encrypt(inputKey, secretKey);

		Machine oldMachine = machineServices.getMachineById(machineId);
		oldMachine.setOutputLockKey(encryptedString);
		oldMachine.setInputLockKey(inputKey);
		machineServices.addOrUpdateMachine(oldMachine);

		Set<Machine> machineList = new HashSet<Machine>();

		machineList.add(oldMachine);

		model.addAttribute(new Machine());
		model.addAttribute("machineList", machineList);
		model.addAttribute("userId", loggedOperator.getId());
		model.addAttribute("machine", oldMachine);
		return "unlockedMachines";
	}

	@RequestMapping(value = "/submitOutputKey")
	public String submitOutputKey(@RequestParam("machineId") long machineId,
			@RequestParam("outputLockKey") String outputLockKey,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();

		Operator loggedOperator = operatorServices
				.getOperatorByUsername(userName);

		final String secretKey = "alfredospain";

		Machine oldMachine = machineServices.getMachineById(machineId);

		String decryptedString = decrypt(outputLockKey, secretKey);

		if (oldMachine.getInputLockKey().equals(decryptedString)) {
			oldMachine.setSelfLock(false);
		}

		oldMachine.setInputLockKey(null);
		oldMachine.setOutputLockKey(null);
		machineServices.addOrUpdateMachine(oldMachine);

		Set<Machine> machineList = machineServices
				.getMachineListByOperatorId(loggedOperator.getId());

		model.addAttribute("machineActive", "machineActive");
		model.addAttribute(new Machine());
		model.addAttribute("machineList", machineList);
		model.addAttribute("userId", loggedOperator.getId());
		model.addAttribute("machineUnlock", "yes");
		return "machineOperator";
	}

	@RequestMapping(value = "/collectionfinal")
	public String collectionfinal(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		Machine machine = machineServices.getMachineById(Long.parseLong(request
				.getParameter("machineID")));

		MachineCollection mc = machineServices.getMachineCollectionById(Long
				.parseLong(request.getParameter("machineCollectionID")));

		String paymentKeyStr = request.getParameter("paymentKey");
		String playerGiftStr = request.getParameter("playerGift");
		String otherExpensesStr = request.getParameter("otherExpenses");
		String failsStr = request.getParameter("fails");

		double paymentKey = Double.parseDouble(paymentKeyStr);
		double playerGift = Double.parseDouble(playerGiftStr);
		double otherExpenses = Double.parseDouble(otherExpensesStr);
		double fails = Double.parseDouble(failsStr);

		mc.setPlayersGift(playerGift);
		mc.setOtherExpenses(otherExpenses);
		mc.setFails(fails);
		mc.setPaymentKey(paymentKey);

		double machineCollection = mc.getMachineCollection() - paymentKey;
		mc.setMachineCollection(machineCollection);

		double manualCollection = mc.getManualCollection() - paymentKey;
		mc.setManualCollection(manualCollection);

		if (mc.getMachineCollection() > mc.getManualCollection()) {
			mc.setDifferentInPercentage(((mc.getMachineCollection() - mc
					.getManualCollection()) / mc.getMachineCollection()) * 100);

			mc.setDifferentInMoney(mc.getMachineCollection()
					- mc.getManualCollection());
		} else {
			mc.setDifferentInPercentage(((mc.getManualCollection() - mc
					.getMachineCollection()) / mc.getManualCollection()) * 100);
			mc.setDifferentInMoney(mc.getManualCollection()
					- mc.getMachineCollection());
		}

		mc.setNetTotal(mc.getManualCollection() - fails);
		/*
		 * Set<MachinePercentageMapping> mpmSet = machineServices
		 * .getMachinePercentageMappingByMachineId(machine.getId());
		 */

		Set<AgreedPercentage> apList = percentageDistributionServices
				.getAgreedPercentageByMachine(machine.getId());
		for (AgreedPercentage agreedPercentage : apList) {
			if (agreedPercentage.getRole().equals("est")) {
				double est = agreedPercentage.getValue();
				double netT = mc.getNetTotal();
				est = est / 100;
				double subtotal = est * netT;
				if (mc.getEstablishmentMoney() != null) {
					double emoney = mc.getEstablishmentMoney() + subtotal;
					mc.setEstablishmentMoney(emoney);
				} else {
					mc.setEstablishmentMoney(subtotal);
				}
				break;
			}
		}

		Set<PlayersGift> pgList = percentageDistributionServices
				.getPlayersGiftByMachine(machine.getId());
		for (PlayersGift playersGift : pgList) {
			if (playersGift.getRole().equals("est")) {
				double est = playersGift.getValue();
				double playerG = mc.getPlayersGift();
				est = est / 100;
				double playerGiftt = est * playerG;
				if (mc.getEstablishmentMoney() != null) {
					double emoney = mc.getEstablishmentMoney() + playerGiftt;
					mc.setEstablishmentMoney(emoney);
				} else {
					mc.setEstablishmentMoney(playerGiftt);
				}
				break;
			}
		}

		Set<OtherExpenses> oeList = percentageDistributionServices
				.getOtherExpensesByMachine(machine.getId());
		for (OtherExpenses otherExpenses2 : oeList) {
			if (otherExpenses2.getRole().equals("est")) {
				double est = otherExpenses2.getValue();
				double otherE = mc.getOtherExpenses();
				est = est / 100;
				double otherexp = est * otherE;
				if (mc.getEstablishmentMoney() != null) {
					double emoney = mc.getEstablishmentMoney() + otherexp;
					mc.setEstablishmentMoney(emoney);
				} else {
					mc.setEstablishmentMoney(otherexp);
				}
			}
		}

		/*
		 * for (MachinePercentageMapping machinePercentageMapping : mpmSet) { if
		 * (machinePercentageMapping.getEstablishment() != null) { if
		 * (machinePercentageMapping.getPercentagetype().longValue() == 1) {
		 * double est = machinePercentageMapping.getEstablishment(); double netT
		 * = mc.getNetTotal(); est = est / 100; double subtotal = est * netT; if
		 * (mc.getEstablishmentMoney() != null) { double emoney =
		 * mc.getEstablishmentMoney() + subtotal;
		 * mc.setEstablishmentMoney(emoney); } else {
		 * mc.setEstablishmentMoney(subtotal); } } else if
		 * (machinePercentageMapping.getPercentagetype() .longValue() == 2) {
		 * double est = machinePercentageMapping.getEstablishment(); double
		 * playerG = mc.getPlayersGift(); est = est / 100; double playerGiftt =
		 * est * playerG; if (mc.getEstablishmentMoney() != null) { double
		 * emoney = mc.getEstablishmentMoney() + playerGiftt;
		 * mc.setEstablishmentMoney(emoney); } else {
		 * mc.setEstablishmentMoney(playerGiftt); } } else if
		 * (machinePercentageMapping.getPercentagetype() .longValue() == 3) {
		 * double est = machinePercentageMapping.getEstablishment(); double
		 * otherE = mc.getOtherExpenses(); est = est / 100; double otherexp =
		 * est * otherE; if (mc.getEstablishmentMoney() != null) { double emoney
		 * = mc.getEstablishmentMoney() + otherexp;
		 * mc.setEstablishmentMoney(emoney); } else {
		 * mc.setEstablishmentMoney(otherexp); } }
		 * 
		 * } }
		 */
		double estaMoney = mc.getEstablishmentMoney() + fails;
		mc.setEstablishmentMoney(estaMoney);

		machineServices.addOrUpdateMachineCollection(mc);
		model.addAttribute("machineID", machine.getId());
		Set<MachineCollection> mcList = machineServices
				.getMachineCollectionByMachineId(machine.getId());
		model.addAttribute("mcList", mcList);
		return "collectionEstablishment";
	}

	public static void setKey(String myKey) {
		MessageDigest sha = null;
		try {
			key = myKey.getBytes("UTF-8");
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public static String encrypt(String strToEncrypt, String secret) {
		try {
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);

			return Base64.getEncoder().encodeToString(
					cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
		} catch (Exception e) {
			System.out.println("Error while encrypting: " + e.toString());
		}
		return null;
	}

	public static String decrypt(String strToDecrypt, String secret) {
		try {
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(
					strToDecrypt)));
		} catch (Exception e) {
			System.out.println("Error while decrypting: " + e.toString());
		}
		return null;
	}
}
