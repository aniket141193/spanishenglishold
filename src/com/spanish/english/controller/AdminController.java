package com.spanish.english.controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spanish.english.DTO.MachineDTO;
import com.spanish.english.DTO.MachineProblemsDTO;
import com.spanish.english.DTO.Money;
import com.spanish.english.DTO.SettingsDTO;
import com.spanish.english.form.Admin;
import com.spanish.english.form.AgreedPercentage;
import com.spanish.english.form.Bills;
import com.spanish.english.form.Coins;
import com.spanish.english.form.Country;
import com.spanish.english.form.Establishment;
import com.spanish.english.form.HopperType;
import com.spanish.english.form.InputMoneyHopper;
import com.spanish.english.form.InputMoneyHopperForm;
import com.spanish.english.form.InputMoneyPaymentDevice;
import com.spanish.english.form.Machine;
import com.spanish.english.form.MachineAccountingMovement;
import com.spanish.english.form.MachineHistory;
import com.spanish.english.form.MachinePercentageMapping;
import com.spanish.english.form.MachineProblems;
import com.spanish.english.form.MachineType;
import com.spanish.english.form.MachineTypeForm;
import com.spanish.english.form.Notes;
import com.spanish.english.form.Operator;
import com.spanish.english.form.OtherExpenses;
import com.spanish.english.form.OutputMoneyHopper;
import com.spanish.english.form.OutputMoneyHopperForm;
import com.spanish.english.form.OutputMoneyPaymentDevice;
import com.spanish.english.form.PaymentDeviceType;
import com.spanish.english.form.PaymentDeviceTypeForm;
import com.spanish.english.form.Phone;
import com.spanish.english.form.PlayersGift;
import com.spanish.english.form.RepairHistory;
import com.spanish.english.form.RepairHistoryForm;
import com.spanish.english.form.SpareParts;
import com.spanish.english.form.StatusEstablishment;
import com.spanish.english.form.StatusMachine;
import com.spanish.english.form.StatusOperator;
import com.spanish.english.form.Technician;
import com.spanish.english.form.Tokens;
import com.spanish.english.form.TypesEstablishment;
import com.spanish.english.form.Users;
import com.spanish.english.form.UsersForm;
import com.spanish.english.form.UsersRole;
import com.spanish.english.services.AdminServices;
import com.spanish.english.services.BillValidatorServices;
import com.spanish.english.services.BillValidatorTypeServices;
import com.spanish.english.services.BillsServices;
import com.spanish.english.services.CoinValidatorServices;
import com.spanish.english.services.CoinValidatorTypeServices;
import com.spanish.english.services.CoinsServices;
import com.spanish.english.services.CountryServices;
import com.spanish.english.services.EstablishmentServices;
import com.spanish.english.services.HopperServices;
import com.spanish.english.services.HopperTypeServices;
import com.spanish.english.services.InputMoneyHopperServices;
import com.spanish.english.services.InputMoneyPaymentDeviceServices;
import com.spanish.english.services.MachineAccountingMovementServices;
import com.spanish.english.services.MachineHistoryServices;
import com.spanish.english.services.MachineProblemsServices;
import com.spanish.english.services.MachineServices;
import com.spanish.english.services.MachineTypeServices;
import com.spanish.english.services.NotesServices;
import com.spanish.english.services.OperatorServices;
import com.spanish.english.services.OutputMoneyHopperServices;
import com.spanish.english.services.OutputMoneyPaymentDeviceServices;
import com.spanish.english.services.PaymentDeviceTypeServices;
import com.spanish.english.services.PercentageDistributionServices;
import com.spanish.english.services.PhoneServices;
import com.spanish.english.services.RepairHistoryServices;
import com.spanish.english.services.SparePartsServices;
import com.spanish.english.services.TechnicianServices;
import com.spanish.english.services.TokensServices;
import com.spanish.english.services.UsersRoleServices;
import com.spanish.english.services.UsersServices;

@Controller
@RequestMapping("/admin")
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminController {

	@Autowired
	OperatorServices operatorServices;

	@Autowired
	EstablishmentServices establishmentServices;

	@Autowired
	AdminServices adminServices;

	@Autowired
	MachineServices machineServices;

	@Autowired
	CountryServices countryServices;

	@Autowired
	MachineTypeServices machineTypeServices;

	@Autowired
	HopperTypeServices hopperTypeServices;

	@Autowired
	CoinValidatorTypeServices coinValidatorTypeServices;

	@Autowired
	BillValidatorTypeServices billValidatorTypeServices;

	@Autowired
	MachineAccountingMovementServices machineAccountingMovementServices;

	@Autowired
	HopperServices hopperServices;

	@Autowired
	CoinValidatorServices coinValidatorServices;

	@Autowired
	BillValidatorServices billValidatorServices;

	@Autowired
	CoinsServices coinsServices;

	@Autowired
	NotesServices notesServices;

	@Autowired
	PercentageDistributionServices percentageDistributionServices;

	@Autowired
	TokensServices tokensServices;

	@Autowired
	BillsServices billsServices;

	@Autowired
	InputMoneyHopperServices inputMoneyHopperServices;

	@Autowired
	OutputMoneyHopperServices outputMoneyHopperServices;

	@Autowired
	PaymentDeviceTypeServices paymentDeviceTypeServices;

	@Autowired
	InputMoneyPaymentDeviceServices inputMoneyPaymentDeviceServices;

	@Autowired
	OutputMoneyPaymentDeviceServices outputMoneyPaymentDeviceServices;

	@Autowired
	UsersRoleServices usersRoleServices;

	@Autowired
	UsersServices usersServices;

	@Autowired
	TechnicianServices technicianServices;

	@Autowired
	RepairHistoryServices repairHistoryServices;

	@Autowired
	SparePartsServices sparePartsServices;

	@Autowired
	MachineProblemsServices machineProblemsServices;

	@Autowired
	PhoneServices phoneServices;

	@Autowired
	MachineHistoryServices machineHistoryServices;

	public static HashMap<String, Long> machineTypeMap = new HashMap<String, Long>();

	/*
	 * @RequestMapping(value = "/signupAdmin",method = RequestMethod.POST,
	 * headers = "content-type=application/json") public @ResponseBody void
	 * add(@RequestBody Admin admin,HttpServletRequest
	 * request,HttpServletResponse response) throws Exception {
	 * Map<String,Object> obj = new HashMap<String,Object>();
	 * 
	 * if(adminServices.addOrUpdateAdmin(admin)){ obj.put("admin", "added");
	 * }else{ obj.put("admin", "fail"); }
	 * 
	 * response.setContentType("application/json; charset=UTF-8");
	 * response.getWriter().print(new
	 * JSONSerializer().exclude("class","*.class",
	 * "authorities").deepSerialize(obj)); }
	 */

	@RequestMapping("/home")
	public String home() {
		return "dashboard";
	}

	@RequestMapping("/signup")
	public String adminSignup(@ModelAttribute("admin") Admin admin,
			ModelMap model) {

		model.addAttribute(new Admin());
		return "adminSignup";
	}

	@RequestMapping(value = "/signupAdmin")
	public String add(@ModelAttribute("admin") Admin admin,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		if (adminServices.isAdminEmpty()) {

			admin.setAdminRole("ROLE_ADMIN");
			if (adminServices.addOrUpdateAdmin(admin)) {
				model.addAttribute("message", "signup successful");
			} else {
				model.addAttribute("message", "signup fail");
			}
		} else {
			model.addAttribute("message", "signup fail. Admin already present.");
		}
		model.addAttribute(new Admin());
		return "adminSignup";
	}

	@RequestMapping(value = "/operatorStatus")
	public String operatorStatus(
			@ModelAttribute("statusOperator") StatusOperator statusOperator,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String action = "action";
		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
		}

		if (action != null) {
			if (action.equals("add")) {
				operatorServices.addOrUpdateStatusOperator(statusOperator);

			} else if (action.equals("edit")) {
				StatusOperator oldStatusEstablishment = operatorServices
						.getStatusOperatorById(statusOperator.getId());
				oldStatusEstablishment.setName(statusOperator.getName());
				operatorServices
						.addOrUpdateStatusOperator(oldStatusEstablishment);
			}
		}

		Set<StatusOperator> statusOperatorList = operatorServices
				.getStatusOperator();
		model.addAttribute("statusList", statusOperatorList);
		return "operatorStatus";
	}

	@RequestMapping(value = "/deleteOperatorStatus")
	public String deleteOperatorStatus(@RequestParam("list") String str,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		str = str.substring(0, str.length() - 1);

		String[] str1 = str.split(",");

		for (int i = 0; i < str1.length; i++) {
			int id = Integer.parseInt(str1[i]);
			operatorServices.deleteStatusOperator(id);
		}

		Set<StatusOperator> statusOperatorList = operatorServices
				.getStatusOperator();
		model.addAttribute("statusList", statusOperatorList);
		model.addAttribute(new StatusOperator());
		return "operatorStatus";
	}

	@RequestMapping("/operators")
	public String adminHome(@ModelAttribute("operator") Operator operator,
			ModelMap model) {
		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		System.out.println("logged userName:" + userName);

		Set<Operator> operatorList = operatorServices.getOperatorList();
		model.addAttribute("opratorActive", "operatorActive");
		model.addAttribute(new Operator());
		model.addAttribute("operatorList", operatorList);

		return "operatorsList";
	}

	@RequestMapping(value = "/operatorsList")
	public String allOperatorList(
			@ModelAttribute("operator") Operator operator,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		System.out.println("logged userName:" + userName);
		Admin loggedAdmin = adminServices.getAdminByUsername(userName);

		String action = "action";
		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
		}

		System.out.println("Action: " + action);
		if (action != null) {
			if (action.equals("add")) {
				System.out.println("add operator");
				operator.setAdmin(loggedAdmin);
				operator.setOperatorRole("ROLE_OPERATOR");

				String telephone[] = request.getParameterValues("telephone");
				String telephoneType[] = request
						.getParameterValues("telephoneType");

				if (operatorServices.addOrUpdateOperator(operator)) {
					System.out.println("operator added");
				}
				Operator lastOperator = operatorServices.getLastOperator();

				if (telephone != null && telephoneType != null) {
					for (int i = 0; i < telephoneType.length; i++) {
						Phone phone = new Phone();
						phone.setNo(telephone[i]);
						phone.setType(telephoneType[i]);
						phone.setOperator(lastOperator);
						phoneServices.addOrUpdatePhone(phone);
					}
				}
				model.addAttribute("added", "added");
			} else if (action.equals("edit")) {
				Operator op = operatorServices
						.getOperatorById(operator.getId());
				op.setAddress(operator.getAddress());
				op.setEmail(operator.getEmail());
				op.setBusiness(operator.getBusiness());
				op.setSector(operator.getSector());
				op.setIdentity_card(operator.getIdentity_card());
				op.setPopulation(operator.getPopulation());
				op.setProvince(operator.getProvince());
				op.setName(operator.getName());
				op.setOperatorPassword(operator.getPassword());
				op.setTelephone(operator.getTelephone());
				op.setOperatorUsername(operator.getUsername());
				if (operatorServices.addOrUpdateOperator(op)) {
					System.out.println("operator edited");
				}
				String telephone[] = request.getParameterValues("telephone");

				String telephoneType[] = request
						.getParameterValues("telephoneType");
				Set<Phone> phones = op.getPhones();

				if (telephone != null && telephoneType != null) {
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
				model.addAttribute("updated", "updated");
			}
		}
		Set<Operator> operatorList = operatorServices.getOperatorList();

		model.addAttribute("opratorActive", "operatorActive");
		model.addAttribute(new Operator());
		model.addAttribute("operatorList", operatorList);

		return "operatorsList";
	}

	@RequestMapping(value = "/deleteOperatorList")
	public String deleteEmployeeList(@RequestParam("list") String str,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		str = str.substring(0, str.length() - 1);
		System.out.println(str);
		String[] str1 = str.split(",");

		for (int i = 0; i < str1.length; i++) {

			int id = Integer.parseInt(str1[i]);

			Set<Phone> phones = phoneServices.getPhoneListByOperator(id);
			for (Phone phone : phones) {
				phoneServices.deletePhone(phone.getId());
			}

			Set<Machine> machineList = machineServices
					.getMachineListByOperatorId(id);
			for (Machine machine : machineList) {
				machine.setOperator(null);
				machine.setMachineStatus("inStock");
				machineServices.addOrUpdateMachine(machine);
			}
			operatorServices.deleteOperator(id);

		}
		Set<Operator> operatorList = operatorServices.getOperatorList();
		model.addAttribute("opratorActive", "operatorActive");
		model.addAttribute(new Operator());
		model.addAttribute("operatorList", operatorList);
		return "operatorsList";
	}

	@RequestMapping(value = "/checkUniqueNickName", method = RequestMethod.POST)
	public @ResponseBody String checkUniqueNickName(
			@RequestParam(value = "nickName") String nickName) {

		System.out.println("nickName: " + nickName);
		Set<Machine> machineList = machineServices.getMachineList();
		boolean flag = true;
		for (Machine machine : machineList) {
			if (machine.getNickName().equals(nickName)) {
				flag = false;
				break;
			}
		}
		if (flag) {
			return "yes";
		} else {
			return "false";
		}
	}

	@RequestMapping(value = "/checkUniqueUserName", method = RequestMethod.POST)
	public @ResponseBody String checkUniqueUserName(
			@RequestParam(value = "userName") String userName) {

		boolean flag = true;
		if (adminServices.getAdminByUsername(userName) != null) {
			flag = false;
		} else if (operatorServices.getOperatorByUsername(userName) != null) {
			flag = false;
		} else if (establishmentServices.getEstablishmentByUsername(userName) != null) {
			flag = false;
		}

		if (flag) {
			return "yes";
		} else {
			return "false";
		}
	}

	@RequestMapping(value = "/getMachineData", method = RequestMethod.POST)
	public @ResponseBody String getMachineData(
			@RequestParam("machineId") String machineId) {

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
		if (machine.getOperator() != null) {
			result = result + "."
					+ String.valueOf(machine.getOperator().getId());
			result = result + "," + machine.getOperator().getName();

		} else {
			result = result + "." + "0,not present";
		}
		return result;
	}

	@RequestMapping("/establishment")
	public String establishmentHome(
			@ModelAttribute("establishment") Establishment establishment,
			ModelMap model) {
		Set<Establishment> establishmentList = establishmentServices
				.getEstablishmentList();
		Set<StatusEstablishment> statusList = establishmentServices
				.getStatusEstablishment();

		model.addAttribute("establishmentActive", "establishmentActive");
		model.addAttribute(new Establishment());
		model.addAttribute("establishmentList", establishmentList);
		model.addAttribute("statusList", statusList);
		Set<TypesEstablishment> typeList = establishmentServices
				.getTypesEstablishment();
		model.addAttribute("typeList", typeList);
		return "establishmentList";
	}

	@RequestMapping(value = "/establishmentStatus")
	public String establishmentStatus(
			@ModelAttribute("statusEstablishment") StatusEstablishment statusEstablishment,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String action = "action";
		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
		}

		if (action != null) {
			if (action.equals("add")) {
				establishmentServices
						.addOrUpdateStatusEstablishment(statusEstablishment);
			} else if (action.equals("edit")) {
				StatusEstablishment oldStatusEstablishment = establishmentServices
						.getStatusEstablishmentById(statusEstablishment.getId());
				oldStatusEstablishment.setName(statusEstablishment.getName());
				establishmentServices
						.addOrUpdateStatusEstablishment(oldStatusEstablishment);
			}
		}

		Set<StatusEstablishment> statusEstablishmentList = establishmentServices
				.getStatusEstablishment();
		model.addAttribute("statusList", statusEstablishmentList);
		return "establishmentStatus";
	}

	@RequestMapping(value = "/deleteEstablishmentStatus")
	public String deleteEstablishmentStatus(@RequestParam("list") String str,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		str = str.substring(0, str.length() - 1);

		String[] str1 = str.split(",");

		for (int i = 0; i < str1.length; i++) {
			int id = Integer.parseInt(str1[i]);
			establishmentServices.deleteStatusEstablishment(id);
		}

		Set<StatusEstablishment> statusEstablishmentList = establishmentServices
				.getStatusEstablishment();
		model.addAttribute("statusList", statusEstablishmentList);
		model.addAttribute(new StatusEstablishment());
		return "establishmentStatus";
	}

	@RequestMapping(value = "/establishmentType")
	public String establishmentType(
			@ModelAttribute("typesEstablishment") TypesEstablishment typesEstablishment,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String action = "action";
		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
		}

		if (action != null) {
			if (action.equals("add")) {
				establishmentServices
						.addOrUpdateTypesEstablishment(typesEstablishment);
			} else if (action.equals("edit")) {
				TypesEstablishment oldTypesEstablishment = establishmentServices
						.getTypesEstablishmentById(typesEstablishment.getId());

				oldTypesEstablishment.setName(typesEstablishment.getName());
				establishmentServices
						.addOrUpdateTypesEstablishment(oldTypesEstablishment);
			}
		}

		Set<TypesEstablishment> typesEstablishmentList = establishmentServices
				.getTypesEstablishment();
		model.addAttribute("statusList", typesEstablishmentList);
		return "establishmentType";
	}

	@RequestMapping(value = "/deleteEstablishmentType")
	public String deleteEstablishmentType(@RequestParam("list") String str,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		str = str.substring(0, str.length() - 1);

		String[] str1 = str.split(",");

		for (int i = 0; i < str1.length; i++) {
			int id = Integer.parseInt(str1[i]);
			establishmentServices.deleteTypesEstablishment(id);
		}

		Set<TypesEstablishment> typesEstablishmentList = establishmentServices
				.getTypesEstablishment();
		model.addAttribute("statusList", typesEstablishmentList);
		model.addAttribute(new TypesEstablishment());
		return "establishmentType";
	}

	@RequestMapping(value = "/establishmentList")
	public String allestablishmentList(
			@ModelAttribute("establishment") Establishment establishment,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		// make true if establishment add to transfer page to establishment
		// assign
		boolean isEstablishmentAdd = false;
		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		Admin loggedAdmin = adminServices.getAdminByUsername(userName);

		String action = "action";
		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
		}

		if (action != null) {
			if (action.equals("add")) {
				System.out.println("add establishment");
				establishment.setAdmin(loggedAdmin);
				establishment.setEstablishmentRole("ROLE_ESTABLISHMENT");
				String openHours = request.getParameter("openingHours");
				String openMins = request.getParameter("openingMins");
				String openTime = openHours + ":" + openMins;
				String closeHours = request.getParameter("closeingHours");
				String closeMins = request.getParameter("closeingMins");
				String closeTime = closeHours + ":" + closeMins;
				establishment.setOpenTime(openTime);
				establishment.setCloseTime(closeTime);

				if (establishmentServices
						.addOrUpdateEstablishment(establishment)) {
					System.out.println("establishment added");
				}
				Establishment lastEstablishment = establishmentServices
						.getLastEstablishment();
				String telephone[] = request.getParameterValues("telephone");
				String telephoneType[] = request
						.getParameterValues("telephoneType");

				if (telephone != null && telephoneType != null) {
					for (int i = 0; i < telephoneType.length; i++) {
						Phone phone = new Phone();
						phone.setNo(telephone[i]);
						phone.setType(telephoneType[i]);
						phone.setEstablishment(lastEstablishment);
						phoneServices.addOrUpdatePhone(phone);
					}
				}
				model.addAttribute("added", "added");
				System.out.println("establishment:"
						+ lastEstablishment.getEstablishmentName());
				model.addAttribute("esta", lastEstablishment);
				model.addAttribute("adminId", loggedAdmin.getId());
				model.addAttribute("operatorList",
						operatorServices.getOperatorList());
				isEstablishmentAdd = true;
			} else if (action.equals("edit")) {
				Establishment est = establishmentServices
						.getEstablishmentById(establishment.getId());

				est.setAddress(establishment.getAddress());
				est.setFund(establishment.getFund());
				est.setEstablishmentsType(establishment.getEstablishmentsType());
				est.setSector(establishment.getSector());
				est.setDischargeDate(establishment.getDischargeDate());
				est.setEstablishmentOwner(establishment.getEstablishmentOwner());

				est.setLoans(establishment.getLoans());
				est.setPercentage(establishment.getPercentage());
				est.setPrepayments(establishment.getPrepayments());
				est.setPopulation(establishment.getPopulation());
				est.setProvince(establishment.getProvince());
				est.setEstablishmentName(establishment.getEstablishmentName());
				est.setEstablishmentPassword(establishment
						.getEstablishmentPassword());
				/* est.setTelephone(establishment.getTelephone()); */
				est.setStatus(establishment.getStatus());
				est.setWithdrawals(establishment.getWithdrawals());
				est.setEstablishmentUsername(establishment
						.getEstablishmentUsername());
				est.setGeolocation(establishment.getGeolocation());
				String openHours = request.getParameter("openingHourss");
				String openMins = request.getParameter("openingMinss");
				String openTime = openHours + ":" + openMins;
				String closeHours = request.getParameter("closeingHourss");
				String closeMins = request.getParameter("closeingMinss");
				String closeTime = closeHours + ":" + closeMins;
				est.setOpenTime(openTime);
				est.setCloseTime(closeTime);
				est.setTypesEstablishment(establishment.getTypesEstablishment());
				est.setStatusEstablishment(establishment
						.getStatusEstablishment());

				if (establishmentServices.addOrUpdateEstablishment(est)) {
					System.out.println("establishment edited");
				}
				String telephone[] = request.getParameterValues("telephone");
				String telephoneType[] = request
						.getParameterValues("telephoneType");

				Set<Phone> phones = est.getPhones();
				if (telephone != null && telephoneType != null) {
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
				model.addAttribute("updated", "updated");
			}
		}
		if (isEstablishmentAdd == false) {
			Set<Establishment> establishmentList = establishmentServices
					.getEstablishmentList();
			model.addAttribute("establishmentActive", "establishmentActive");
			model.addAttribute(new Establishment());
			model.addAttribute("establishmentList", establishmentList);
			Set<StatusEstablishment> statusList = establishmentServices
					.getStatusEstablishment();

			model.addAttribute("statusList", statusList);

			Set<TypesEstablishment> typeList = establishmentServices
					.getTypesEstablishment();
			model.addAttribute("typeList", typeList);

			return "establishmentList";
		} else {
			return "establishmentAssign";
		}
	}

	@RequestMapping(value = "/getPhone")
	public String getPhone(@RequestParam("id") long id,
			@RequestParam("type") String type, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		Set<Phone> phones = new HashSet<Phone>();
		if (type.equals("operator")) {
			phones = phoneServices.getPhoneListByOperator(id);
		}
		model.addAttribute("phones", phones);
		System.out.println(type);
		return "operatorsList";
	}

	@RequestMapping(value = "/deleteEstablishmentList")
	public String deleteEstablishments(@RequestParam("list") String str,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		str = str.substring(0, str.length() - 1);
		System.out.println(str);
		String[] str1 = str.split(",");

		for (int i = 0; i < str1.length; i++) {

			int id = Integer.parseInt(str1[i]);
			Set<Phone> phones = phoneServices.getPhoneListByEstablishment(id);
			for (Phone phone : phones) {
				phoneServices.deletePhone(phone.getId());
			}

			Set<Machine> machineList = machineServices
					.getMachineListByEstablishmentId(id);
			for (Machine machine : machineList) {
				machine.setEstablishment(null);
				machine.setMachineStatus("inStock");
				machineServices.addOrUpdateMachine(machine);
			}

			establishmentServices.deleteEstablishment(id);
		}
		Set<Establishment> establishmentList = establishmentServices
				.getEstablishmentList();
		model.addAttribute("establishmentActive", "establishmentActive");
		model.addAttribute(new Establishment());
		model.addAttribute("establishmentList", establishmentList);
		Set<StatusEstablishment> statusList = establishmentServices
				.getStatusEstablishment();

		model.addAttribute("statusList", statusList);

		Set<TypesEstablishment> typeList = establishmentServices
				.getTypesEstablishment();
		model.addAttribute("typeList", typeList);
		return "establishmentList";
	}

	@RequestMapping(value = "/machineStatus")
	public String machineStatus(
			@ModelAttribute("statusMachine") StatusMachine statusMachine,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String action = "action";
		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
		}

		if (action != null) {
			if (action.equals("add")) {
				machineServices.addOrUpdateStatusMachine(statusMachine);
			} else if (action.equals("edit")) {
				StatusMachine oldStatusMachine = machineServices
						.getStatusMachineById(statusMachine.getId());
				oldStatusMachine.setName(statusMachine.getName());
				machineServices.addOrUpdateStatusMachine(oldStatusMachine);
			}
		}

		Set<StatusMachine> statusMachineList = machineServices
				.getStatusMachine();
		model.addAttribute("statusList", statusMachineList);
		return "machineStatus";
	}

	@RequestMapping(value = "/deleteMachineStatus")
	public String deleteMachineStatus(@RequestParam("list") String str,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		str = str.substring(0, str.length() - 1);

		String[] str1 = str.split(",");

		for (int i = 0; i < str1.length; i++) {
			int id = Integer.parseInt(str1[i]);
			machineServices.deleteStatusMachine(id);
		}

		Set<StatusMachine> statusMachineList = machineServices
				.getStatusMachine();
		model.addAttribute("statusList", statusMachineList);
		model.addAttribute(new StatusMachine());
		return "machineStatus";
	}

	@RequestMapping("/establshmentExpense")
	public String establshmentExpense(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		Operator operator = operatorServices.getOperatorById(Long
				.valueOf(request.getParameter("operatorId")));

		Establishment establishment = establishmentServices
				.getEstablishmentById(Long.valueOf(request
						.getParameter("establishmentId")));

		model.addAttribute("op", operator);
		model.addAttribute("est", establishment);
		return "expenseEstablishment";
	}

	@RequestMapping("/assignestablishmentExpense")
	public String assignestablishmentExpense(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		Admin admin = adminServices.getAdminByUsername(userName);

		Operator operator = operatorServices.getOperatorById(Long
				.valueOf(request.getParameter("operatorID")));

		Establishment establishment = establishmentServices
				.getEstablishmentById(Long.valueOf(request
						.getParameter("establishmentID")));

		OtherExpenses oeAdmin = new OtherExpenses(admin, null, null, "admin",
				Double.valueOf(request.getParameter("otherExpensesAdmin")));
		OtherExpenses oeOperator = new OtherExpenses(null, operator, null,
				"op", Double.valueOf(request
						.getParameter("otherExpensesOperator")));
		OtherExpenses oeEstablishment = new OtherExpenses(null, null,
				establishment, "est", Double.valueOf(request
						.getParameter("otherExpensesEstablishment")));

		PlayersGift pgAdmin = new PlayersGift(admin, null, null, "admin",
				Double.valueOf(request.getParameter("otherExpensesAdmin")));
		PlayersGift pgOperator = new PlayersGift(null, operator, null, "op",
				Double.valueOf(request.getParameter("otherExpensesOperator")));
		PlayersGift pgEstablishment = new PlayersGift(null, null,
				establishment, "est", Double.valueOf(request
						.getParameter("otherExpensesEstablishment")));

		percentageDistributionServices.addOrUpdateOtherExpenses(oeAdmin);
		percentageDistributionServices.addOrUpdateOtherExpenses(oeOperator);
		percentageDistributionServices
				.addOrUpdateOtherExpenses(oeEstablishment);

		percentageDistributionServices.addOrUpdatePlayersGift(pgAdmin);
		percentageDistributionServices.addOrUpdatePlayersGift(pgOperator);
		percentageDistributionServices.addOrUpdatePlayersGift(pgEstablishment);

		Set<Establishment> establishmentList = establishmentServices
				.getEstablishmentList();
		model.addAttribute("establishmentActive", "establishmentActive");
		model.addAttribute(new Establishment());
		model.addAttribute("establishmentList", establishmentList);
		Set<StatusEstablishment> statusList = establishmentServices
				.getStatusEstablishment();

		model.addAttribute("statusList", statusList);

		Set<TypesEstablishment> typeList = establishmentServices
				.getTypesEstablishment();
		model.addAttribute("typeList", typeList);
		return "establishmentList";
	}

	@RequestMapping("/machine")
	public String machineHome(@ModelAttribute("machine") MachineDTO machineDTO,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws ParseException {
		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();

		Admin loggedAdmin = adminServices.getAdminByUsername(userName);

		String action = "action";

		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
		}

		SimpleDateFormat formatter = new SimpleDateFormat(
				"yyyy-MM-dd hh:mm:ss.S");
		SimpleDateFormat formatter1 = new SimpleDateFormat("MM/dd/yyyy");

		if (action != null) {
			if (action.equals("add")) {

				Machine machine = new Machine(machineDTO);
				Date date = formatter1.parse(machineDTO.getManufacturingDate());

				machine.setManufacturingDate(date);

				MachineType machineType = machineTypeServices
						.getMachineTypeById(machineDTO.getMachineType().getId());

				machine.setMachineType(machineType);
				machine.setAdmin(loggedAdmin);

				if (machineServices.addOrUpdateMachine(machine)) {

					Machine lastMachine = machineServices.lastMachine();

					// add machine distribution records

					AgreedPercentage apa = new AgreedPercentage();
					apa.setAdmin(loggedAdmin);
					apa.setRole("admin");
					apa.setMachine(lastMachine);
					percentageDistributionServices
							.addOrUpdateAgreedPercentge(apa);

					AgreedPercentage apo = new AgreedPercentage();
					apo.setRole("op");
					apo.setMachine(lastMachine);
					percentageDistributionServices
							.addOrUpdateAgreedPercentge(apo);

					AgreedPercentage ape = new AgreedPercentage();
					ape.setRole("est");
					ape.setMachine(lastMachine);
					percentageDistributionServices
							.addOrUpdateAgreedPercentge(ape);

					// PlayersGift pga = new PlayersGift();
					// pga.setAdmin(loggedAdmin);
					// pga.setRole("admin");
					// pga.setMachine(lastMachine);
					// percentageDistributionServices.addOrUpdatePlayersGift(pga);
					//
					// PlayersGift pgo = new PlayersGift();
					// pgo.setRole("op");
					// pgo.setMachine(lastMachine);
					// percentageDistributionServices.addOrUpdatePlayersGift(pgo);
					//
					// PlayersGift pge = new PlayersGift();
					// pge.setRole("est");
					// pge.setMachine(lastMachine);
					// percentageDistributionServices.addOrUpdatePlayersGift(pge);
					//
					// OtherExpenses oea = new OtherExpenses();
					// oea.setAdmin(loggedAdmin);
					// oea.setRole("admin");
					// oea.setMachine(lastMachine);
					// percentageDistributionServices
					// .addOrUpdateOtherExpenses(oea);
					//
					// OtherExpenses oeo = new OtherExpenses();
					// oeo.setRole("op");
					// oeo.setMachine(lastMachine);
					// percentageDistributionServices
					// .addOrUpdateOtherExpenses(oeo);
					//
					// OtherExpenses oee = new OtherExpenses();
					// oee.setRole("est");
					// oee.setMachine(lastMachine);
					// percentageDistributionServices
					// .addOrUpdateOtherExpenses(oee);

					// add machine history
					MachineHistory machineHistory = new MachineHistory();
					machineHistory.setMachine(lastMachine);
					machineHistory.setMovementDate(new Date());
					machineHistory.setAdmin(loggedAdmin);
					machineHistoryServices.addMachineHistory(machineHistory);

				}
			} else if (action.equals("edit")) {
				Machine mch = machineServices
						.getMachineById(machineDTO.getId());

				mch.setMachineControl(machineDTO.getMachineControl());
				mch.setAdmin(loggedAdmin);
				mch.setCollectionLimits(machineDTO.getCollectionLimits());
				mch.setColor(machineDTO.getColor());
				mch.setMachineControl(machineDTO.getMachineControl());
				mch.setNickName(machineDTO.getNickName());
				if (machineDTO.getMachineControl().equals("yes")) {
					mch.setControlNumber(machineDTO.getControlNumber());
				} else {
					mch.setControlNumber(0);
				}
				mch.setMachineIMEI(machineDTO.getMachineIMEI());

				mch.setMachineInput(machineDTO.getMachineInput());
				mch.setCreditValue(machineDTO.getCreditValue());
				mch.setMachineOutput(machineDTO.getMachineOutput());

				mch.setMachinelock(machineDTO.getMachinelock());
				if (mch.getMachinelock().equals("yes")) {
					mch.setLockDays(machineDTO.getLockDays());
				} else {
					mch.setLockDays(0);
				}
				mch.setMachineType(machineDTO.getMachineType());
				Date date = formatter.parse(machineDTO.getManufacturingDate());

				mch.setManufacturingDate(date);
				mch.setComments(machineDTO.getComments());
				if (machineServices.addOrUpdateMachine(mch)) {
					System.out.println("machine edited");
				}
			}
		}

		Set<MachineType> machineTypeList = machineTypeServices
				.getMachineTypeList();

		Set<Machine> machineList = machineServices.getMachineList();
		model.addAttribute("machineActive", "machineActive");
		model.addAttribute(new Machine());
		model.addAttribute("machineList", machineList);
		model.addAttribute("machineTypeList", machineTypeList);
		model.addAttribute("userId", loggedAdmin.getId());
		return "machineList";
	}

	@RequestMapping(value = "/deleteMachine")
	public String deleteMachines(@RequestParam("list") String str,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		str = str.substring(0, str.length() - 1);
		System.out.println(str);
		String[] str1 = str.split(",");

		for (int i = 0; i < str1.length; i++) {

			int id = Integer.parseInt(str1[i]);
			Set<RepairHistory> repairHistoryList = repairHistoryServices
					.getRepairHistoryByMachineId(id);
			for (RepairHistory repairHistory : repairHistoryList) {
				repairHistoryServices
						.deleteRepairHistory(repairHistory.getId());

			}

			Set<MachineAccountingMovement> machineAccountingMovement = machineAccountingMovementServices
					.getMachineAccountingMovementByMachine(id);
			for (MachineAccountingMovement machineAccountingMovement2 : machineAccountingMovement) {
				machineAccountingMovementServices
						.deleteMachineAccountingMovement(machineAccountingMovement2
								.getId());
			}

			Set<AgreedPercentage> apList = percentageDistributionServices
					.getAgreedPercentageByMachine(id);
			for (AgreedPercentage agreedPercentage : apList) {
				percentageDistributionServices
						.deleteAgreedPercentage(agreedPercentage.getId());
			}

			Set<PlayersGift> pgList = percentageDistributionServices
					.getPlayersGiftByMachine(id);
			for (PlayersGift playersGift : pgList) {
				percentageDistributionServices.deletePlayersGift(playersGift
						.getId());
			}

			Set<OtherExpenses> oeList = percentageDistributionServices
					.getOtherExpensesByMachine(id);
			for (OtherExpenses otherExpenses : oeList) {
				percentageDistributionServices
						.deleteOtherExpenses(otherExpenses.getId());
			}
			machineServices.deleteMachine(id);

		}

		Set<MachineType> machineTypeList = machineTypeServices
				.getMachineTypeList();
		Set<Machine> machineList = machineServices.getMachineList();
		model.addAttribute("machineActive", "machineActive");
		model.addAttribute(new Machine());
		model.addAttribute("machineList", machineList);
		model.addAttribute("machineTypeList", machineTypeList);
		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();

		Admin loggedAdmin = adminServices.getAdminByUsername(userName);
		model.addAttribute("userId", loggedAdmin.getId());
		return "machineList";
	}

	@RequestMapping(value = "/unassignMachined", method = RequestMethod.POST)
	public String unassignMachined(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		String machineIdStr = request.getParameter("machineId");
		String operatorIdStr = request.getParameter("operatorId");
		String establishmentIdStr = request.getParameter("establishmentId");

		boolean isOperator = false;
		boolean isEstablishment = false;

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();

		Admin loggedAdmin = adminServices.getAdminByUsername(userName);
		Machine machine = machineServices.getMachineById(Long
				.parseLong(machineIdStr));

		Set<AgreedPercentage> apList = percentageDistributionServices
				.getAgreedPercentageByMachine(machine.getId());

		Set<PlayersGift> pgList = percentageDistributionServices
				.getPlayersGiftByMachine(machine.getId());

		Set<OtherExpenses> oeList = percentageDistributionServices
				.getOtherExpensesByMachine(machine.getId());

		if (operatorIdStr.equals("0")) {

			if (machine.getOperator() != null) {
				isOperator = true;
				machine.setOperator(null);
				machine.setMachineFund(0.0);
				machine.setEstablishmentFund(0.0);
				machineServices.addOrUpdateMachine(machine);
				/*
				 * Set<MachinePercentageMapping> mmpList = machineServices
				 * .getMachinePercentageMappingByMachineId(machine.getId()); for
				 * (MachinePercentageMapping machinePercentageMapping : mmpList)
				 * { if (machinePercentageMapping.getOperator() != null) {
				 * 
				 * MachineUserMapping mum = machineServices
				 * .getMachineUserMappingByMPMId(machinePercentageMapping
				 * .getId());
				 * machineServices.deleteMachineUserMapping(mum.getId());
				 * machineServices
				 * .deleteMachinePercentageMapping(machinePercentageMapping
				 * .getId()); } }
				 */

				// new code start here

				for (AgreedPercentage agreedPercentage : apList) {
					if (agreedPercentage.getRole().equals("op")) {
						agreedPercentage.setOperator(null);
						agreedPercentage.setValue(null);
						percentageDistributionServices
								.addOrUpdateAgreedPercentge(agreedPercentage);
					}
				}

				for (PlayersGift playersGift : pgList) {
					if (playersGift.getRole().equals("op")) {
						playersGift.setOperator(null);
						playersGift.setValue(null);
						percentageDistributionServices
								.addOrUpdatePlayersGift(playersGift);
					}
				}

				for (OtherExpenses otherExpenses : oeList) {
					if (otherExpenses.getRole().equals("op")) {
						otherExpenses.setOperator(null);
						otherExpenses.setValue(null);
						percentageDistributionServices
								.addOrUpdateOtherExpenses(otherExpenses);
					}
				}
				// new code end here

			}

		}

		if (establishmentIdStr.equals("0")) {
			if (machine.getEstablishment() != null) {
				isEstablishment = true;
				machine.setEstablishment(null);
				machine.setMachineFund(0.0);
				machine.setEstablishmentFund(0.0);
				machineServices.addOrUpdateMachine(machine);
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
				// new code start here

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
				// new code end here
			}
		}

		if (isOperator && isEstablishment) {
			machine.setMachineStatus("inStock");

			// add machine history
			MachineHistory machineHistory = new MachineHistory();
			machineHistory.setMovementDate(new Date());
			machineHistory.setAdmin(loggedAdmin);
			machineHistory.setMachine(machine);
			machineHistoryServices.addMachineHistory(machineHistory);
		} else if (isOperator && machine.getEstablishment() == null) {
			machine.setMachineStatus("inStock");

			// add machine history
			MachineHistory machineHistory = new MachineHistory();
			machineHistory.setMovementDate(new Date());
			machineHistory.setAdmin(loggedAdmin);
			machineHistory.setMachine(machine);
			machineHistoryServices.addMachineHistory(machineHistory);
		} else if (isEstablishment && machine.getOperator() == null) {
			machine.setMachineStatus("inStock");

			// add machine history
			MachineHistory machineHistory = new MachineHistory();
			machineHistory.setMovementDate(new Date());
			machineHistory.setAdmin(loggedAdmin);
			machineHistory.setMachine(machine);
			machineHistoryServices.addMachineHistory(machineHistory);
		} else if (isEstablishment && machine.getOperator() != null) {
			machine.setMachineStatus("assignedToOperator");

			// add machine history
			MachineHistory machineHistory = new MachineHistory();
			machineHistory.setMovementDate(new Date());
			machineHistory.setOperator(machine.getOperator());
			machineHistory.setMachine(machine);
			machineHistoryServices.addMachineHistory(machineHistory);
		} else if (isOperator && machine.getEstablishment() != null) {
			machine.setMachineStatus("assignedToEstablishment");
			// add machine history
			MachineHistory machineHistory = new MachineHistory();
			machineHistory.setMovementDate(new Date());
			machineHistory.setEstablishment(machine.getEstablishment());
			machineHistory.setMachine(machine);
			machineHistoryServices.addMachineHistory(machineHistory);
		}

		machineServices.addOrUpdateMachine(machine);
		Set<Machine> machineList = machineServices.getMachineList();
		model.addAttribute("machineActive", "machineActive");
		model.addAttribute(new Machine());
		model.addAttribute("machineList", machineList);
		model.addAttribute("userId", loggedAdmin.getId());
		return "machineList";
	}

	@RequestMapping("/assignMachines")
	public String assignMachines(@ModelAttribute("machine") Machine machine,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		Set<Machine> machineList = new HashSet<Machine>();
		Set<Machine> allMachine = machineServices.getMachineList();
		for (Machine machinetemp : allMachine) {
			if (machinetemp.getEstablishment() == null
					|| machinetemp.getOperator() == null) {
				machineList.add(machinetemp);
			}
		}

		Set<Operator> operatorList = operatorServices.getOperatorList();
		Set<Establishment> establishmentList = establishmentServices
				.getEstablishmentList();

		model.addAttribute("machineList", machineList);
		model.addAttribute("operatorList", operatorList);
		model.addAttribute("establishmentList", establishmentList);

		/*
		 * Set<Machine> machineSetOp = machineServices
		 * .getMachineListByStatus("assignedToOperator"); Set<Machine>
		 * machineSetEst = machineServices
		 * .getMachineListByStatus("assignedToEstablishment");
		 */

		/*
		 * Set<Machine> machineSet = new HashSet<Machine>(machineSetOp); for
		 * (Machine machines : machineSetEst) { machineSet.add(machines); }
		 */
		Set<Machine> machineSet = new HashSet<Machine>();
		for (Machine machinetemp : allMachine) {
			if (machinetemp.getEstablishment() != null
					|| machinetemp.getOperator() != null) {
				machineSet.add(machinetemp);
			}
		}

		model.addAttribute("machineSet", machineSet);

		return "assignMachine";
	}

	@RequestMapping(value = "/assignMachined", method = RequestMethod.POST)
	public String assignMachined(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		String mID = request.getParameter("machineID");
		String oID = request.getParameter("operatorID");
		String eID = request.getParameter("establishmentID");
		boolean isOperator = false;
		boolean isEstablishment = false;

		long machineID = Long.parseLong(mID);
		Machine machine = machineServices.getMachineById(machineID);
		Operator operator = new Operator();
		Establishment establishment = new Establishment();

		if (oID != null) {
			long operatorID = Long.parseLong(oID);
			operator = operatorServices.getOperatorById(operatorID);
			machine.setOperator(operator);
			machine.setMachineStatus("assignedToOperator");

			isOperator = true;
		}
		if (eID != null) {
			long establishmentID = Long.parseLong(eID);
			establishment = establishmentServices
					.getEstablishmentById(establishmentID);
			machine.setEstablishment(establishment);
			machine.setMachineStatus("assignedToEstablishment");

			isEstablishment = true;
		}

		machineServices.addOrUpdateMachine(machine);

		model.addAttribute("machineID", machineID);

		model.addAttribute("machineControl", machine.getMachineControl());

		if (isOperator) {
			// add machine history
			MachineHistory machineHistory = new MachineHistory();
			machineHistory.setMovementDate(new Date());
			machineHistory.setOperator(operator);
			machineHistory.setMachine(machine);
			machineHistoryServices.addMachineHistory(machineHistory);

			Set<Country> countrySet = countryServices.getCountryList();
			List<Country> countryList = new ArrayList<Country>(countrySet);
			Country country = countryList.get(0);
			model.addAttribute("currency", country.getCurrency());
			model.addAttribute("operatorID", operator.getId());
		}
		if (isEstablishment) {
			// add machine history
			MachineHistory machineHistory = new MachineHistory();
			machineHistory.setMovementDate(new Date());
			machineHistory.setEstablishment(establishment);
			machineHistory.setMachine(machine);
			machineHistoryServices.addMachineHistory(machineHistory);
			Set<Country> countrySet = countryServices.getCountryList();
			List<Country> countryList = new ArrayList<Country>(countrySet);
			Country country = countryList.get(0);
			model.addAttribute("currency", country.getCurrency());
			model.addAttribute("establishmentID", establishment.getId());
		}
		return "assignFunds";
	}

	@RequestMapping(value = "/assignFunds", method = RequestMethod.POST)
	public String assignFunds(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		String machineID = request.getParameter("machineID");
		String currency = request.getParameter("currency");
		String operatorID = request.getParameter("operatorID");
		String establishmentID = request.getParameter("establishmentID");

		String machineFund = request.getParameter("machineFund");
		String establishmentFund = request.getParameter("establishmentFund");

		long simNo = 0;
		if (request.getParameter("simNumber") != null) {
			simNo = Long.parseLong(request.getParameter("simNumber"));
		}

		java.util.Date date = new java.util.Date();

		Timestamp currentTimeStamp = new Timestamp(date.getTime());
		String timeStamp = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
				.format(currentTimeStamp);
		Machine machine = machineServices.getMachineById(Long
				.parseLong(machineID));
		machine.setSimNumber(simNo);
		machine.setMachineFund(Double.parseDouble(machineFund));
		machine.setEstablishmentFund(Double.parseDouble(establishmentFund));
		machineServices.addOrUpdateMachine(machine);

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		Admin loggedAdmin = adminServices.getAdminByUsername(userName);

		MachineAccountingMovement mav = new MachineAccountingMovement();
		mav.setAdmin(loggedAdmin);
		mav.setCurrency(currency);
		mav.setMachine(machine);
		mav.setMoney(Double.parseDouble(establishmentFund));
		mav.setTimestamp(timeStamp);

		machineAccountingMovementServices
				.addOrUpdateMachineAccountingMovement(mav);

		model.addAttribute("machineID", machineID);
		model.addAttribute("operatorID", operatorID);
		model.addAttribute("establishmentID", establishmentID);

		return "percentageTable";
	}

	@RequestMapping(value = "/assignPercentage", method = RequestMethod.POST)
	public String assignPercentage(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		String machineID = request.getParameter("machineID");
		String operatorIDStr = request.getParameter("operatorID");
		String establishmentIDStr = request.getParameter("establishmentID");

		long operatorID = 0L;
		long establishmentID = 0L;
		if (!establishmentIDStr.equals(null) && !establishmentIDStr.equals("")) {
			establishmentID = Long.parseLong(establishmentIDStr);
		}
		if (!operatorIDStr.equals(null) && !operatorIDStr.equals("")) {
			operatorID = Long.parseLong(operatorIDStr);
		}

		Establishment establishment = establishmentServices
				.getEstablishmentById(establishmentID);
		Operator operator = operatorServices.getOperatorById(operatorID);

		Machine machine = machineServices.getMachineById(Long
				.parseLong(machineID));
		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		Admin loggedAdmin = adminServices.getAdminByUsername(userName);

		String agreedPercentageAdmin = request
				.getParameter("agreedPercentageAdmin");
		String agreedPercentageOperator = request
				.getParameter("agreedPercentageOperator");
		String agreedPercentageEstablishment = request
				.getParameter("agreedPercentageEstablishment");
		// String playersGiftAdmin = request.getParameter("playersGiftAdmin");
		// String playersGiftOperator = request
		// .getParameter("playersGiftOperator");
		// String playersGiftEstablishment = request
		// .getParameter("playersGiftEstablishment");
		// String otherExpensesAdmin =
		// request.getParameter("otherExpensesAdmin");
		// String otherExpensesOperator = request
		// .getParameter("otherExpensesOperator");
		// String otherExpensesEstablishment = request
		// .getParameter("otherExpensesEstablishment");

		Set<MachinePercentageMapping> mpmList = machineServices
				.getMachinePercentageMappingByMachineId(machine.getId());

		// this is new code

		Set<AgreedPercentage> apList = percentageDistributionServices
				.getAgreedPercentageByMachine(machine.getId());
		for (AgreedPercentage agreedPercentage : apList) {
			if (agreedPercentage.getRole().equals("admin")) {
				agreedPercentage.setValue(Double
						.parseDouble(agreedPercentageAdmin));
			} else if (agreedPercentage.getRole().equals("op")) {
				if (operator != null) {
					agreedPercentage.setOperator(operator);
				}
				agreedPercentage.setValue(Double
						.parseDouble(agreedPercentageOperator));
			} else if (agreedPercentage.getRole().equals("est")) {
				if (establishment != null) {
					agreedPercentage.setEstablishment(establishment);
				}
				agreedPercentage.setValue(Double
						.parseDouble(agreedPercentageEstablishment));
			}
			percentageDistributionServices
					.addOrUpdateAgreedPercentge(agreedPercentage);
		}

		// Set<PlayersGift> pgList = percentageDistributionServices
		// .getPlayersGiftByMachine(machine.getId());
		// for (PlayersGift playersGift : pgList) {
		// if (playersGift.getRole().equals("admin")) {
		// playersGift.setValue(Double.parseDouble(playersGiftAdmin));
		// } else if (playersGift.getRole().equals("op")) {
		// if (operator != null) {
		// playersGift.setOperator(operator);
		// }
		// playersGift.setValue(Double.parseDouble(playersGiftOperator));
		// } else if (playersGift.getRole().equals("est")) {
		// if (establishment != null) {
		// playersGift.setEstablishment(establishment);
		// }
		// playersGift.setValue(Double
		// .parseDouble(playersGiftEstablishment));
		// }
		// percentageDistributionServices.addOrUpdatePlayersGift(playersGift);
		// }

		// Set<OtherExpenses> oeList = percentageDistributionServices
		// .getOtherExpensesByMachine(machine.getId());
		// for (OtherExpenses otherExpenses : oeList) {
		// if (otherExpenses.getRole().equals("admin")) {
		// otherExpenses.setValue(Double.parseDouble(otherExpensesAdmin));
		// } else if (otherExpenses.getRole().equals("op")) {
		// if (operator != null) {
		// otherExpenses.setOperator(operator);
		// }
		// otherExpenses.setValue(Double
		// .parseDouble(otherExpensesOperator));
		// } else if (otherExpenses.getRole().equals("est")) {
		// if (establishment != null) {
		// otherExpenses.setEstablishment(establishment);
		// }
		// otherExpenses.setValue(Double
		// .parseDouble(otherExpensesEstablishment));
		// }
		// percentageDistributionServices
		// .addOrUpdateOtherExpenses(otherExpenses);
		// }

		// new code end here

		// boolean adminPercentage = false;
		// boolean establishmentPercentage = false;
		// boolean operatorPercentage = false;
		// boolean adminPlayerGift = false;
		// boolean establishmentPlayerGift = false;
		// boolean operatorPlayerGift = false;
		// boolean adminOtherExpenses = false;
		// boolean establishmentOtherExpenses = false;
		// boolean operatorOtherExpenses = false;
		// if (mpmList.size() != 0) {
		// for (MachinePercentageMapping machinePercentageMapping : mpmList) {
		// // Admin percentage
		// if (machinePercentageMapping.getAdmin() != null
		// && machinePercentageMapping.getPercentagetype()
		// .longValue() == 1) {
		// machinePercentageMapping.setAdmin(Long
		// .parseLong(agreedPercentageAdmin));
		// machineServices
		// .addOrUpdateMachinePercentageMapping(machinePercentageMapping);
		//
		// adminPercentage = true;
		// }
		//
		// // Establishment percentage
		// if (machinePercentageMapping.getEstablishment() != null
		// && machinePercentageMapping.getPercentagetype()
		// .longValue() == 1) {
		// machinePercentageMapping.setEstablishment(Long
		// .parseLong(agreedPercentageEstablishment));
		// machineServices
		// .addOrUpdateMachinePercentageMapping(machinePercentageMapping);
		// establishmentPercentage = true;
		// }
		//
		// // Operator percentage
		// if (machinePercentageMapping.getOperator() != null
		// && machinePercentageMapping.getPercentagetype()
		// .longValue() == 1) {
		// machinePercentageMapping.setOperator(Long
		// .parseLong(agreedPercentageOperator));
		// machineServices
		// .addOrUpdateMachinePercentageMapping(machinePercentageMapping);
		// operatorPercentage = true;
		// }
		//
		// // Admin player gift
		// if (machinePercentageMapping.getAdmin() != null
		// && machinePercentageMapping.getPercentagetype()
		// .longValue() == 2) {
		// machinePercentageMapping.setAdmin(Long
		// .parseLong(agreedPercentageAdmin));
		// machineServices
		// .addOrUpdateMachinePercentageMapping(machinePercentageMapping);
		//
		// adminPlayerGift = true;
		// }
		//
		// // Establishment player gift
		// if (machinePercentageMapping.getEstablishment() != null
		// && machinePercentageMapping.getPercentagetype()
		// .longValue() == 2) {
		// machinePercentageMapping.setEstablishment(Long
		// .parseLong(agreedPercentageEstablishment));
		// machineServices
		// .addOrUpdateMachinePercentageMapping(machinePercentageMapping);
		// establishmentPlayerGift = true;
		// }
		//
		// // Operator player gift
		// if (machinePercentageMapping.getOperator() != null
		// && machinePercentageMapping.getPercentagetype()
		// .longValue() == 2) {
		// machinePercentageMapping.setOperator(Long
		// .parseLong(agreedPercentageOperator));
		// machineServices
		// .addOrUpdateMachinePercentageMapping(machinePercentageMapping);
		// operatorPlayerGift = true;
		// }
		//
		// // Admin Other expenses
		// if (machinePercentageMapping.getAdmin() != null
		// && machinePercentageMapping.getPercentagetype()
		// .longValue() == 3) {
		// machinePercentageMapping.setAdmin(Long
		// .parseLong(agreedPercentageAdmin));
		// machineServices
		// .addOrUpdateMachinePercentageMapping(machinePercentageMapping);
		//
		// adminOtherExpenses = true;
		// }
		//
		// // Establishment Other expenses
		// if (machinePercentageMapping.getEstablishment() != null
		// && machinePercentageMapping.getPercentagetype()
		// .longValue() == 3) {
		// machinePercentageMapping.setEstablishment(Long
		// .parseLong(agreedPercentageEstablishment));
		// machineServices
		// .addOrUpdateMachinePercentageMapping(machinePercentageMapping);
		// establishmentOtherExpenses = true;
		// }
		//
		// // Operator Other expenses
		// if (machinePercentageMapping.getOperator() != null
		// && machinePercentageMapping.getPercentagetype()
		// .longValue() == 3) {
		// machinePercentageMapping.setOperator(Long
		// .parseLong(agreedPercentageOperator));
		// machineServices
		// .addOrUpdateMachinePercentageMapping(machinePercentageMapping);
		// operatorOtherExpenses = true;
		// }
		// }
		// }
		//
		// // Admin percentage
		//
		// if (!adminPercentage) {
		// MachinePercentageMapping mpm1 = new MachinePercentageMapping();
		// mpm1.setMachine(machine);
		// mpm1.setPercentagetype(1L);
		// mpm1.setAdmin(Long.parseLong(agreedPercentageAdmin));
		//
		// machineServices.addOrUpdateMachinePercentageMapping(mpm1);
		// MachinePercentageMapping oldmpm1 = machineServices
		// .lastMachinePercentageMapping();
		//
		// MachineUserMapping mum1 = new MachineUserMapping();
		// mum1.setMachine(machine);
		// mum1.setUserId(loggedAdmin.getId());
		// mum1.setMpmId(oldmpm1.getId());
		//
		// machineServices.addOrUpdateMachineUserMapping(mum1);
		// }
		//
		// // Establishment percentage
		//
		// if (!establishmentPercentage) {
		// MachinePercentageMapping mpm2 = new MachinePercentageMapping();
		// mpm2.setMachine(machine);
		// mpm2.setPercentagetype(1L);
		// mpm2.setEstablishment(Long.parseLong(agreedPercentageEstablishment));
		//
		// machineServices.addOrUpdateMachinePercentageMapping(mpm2);
		// MachinePercentageMapping oldmpm2 = machineServices
		// .lastMachinePercentageMapping();
		//
		// MachineUserMapping mum2 = new MachineUserMapping();
		// mum2.setMachine(machine);
		// mum2.setMpmId(oldmpm2.getId());
		// if (establishmentIDStr.equals(null)) {
		// mum2.setUserId(establishmentID);
		// }
		// machineServices.addOrUpdateMachineUserMapping(mum2);
		// }
		//
		// // Operator percentage
		//
		// if (!operatorPercentage) {
		// MachinePercentageMapping mpm3 = new MachinePercentageMapping();
		// mpm3.setMachine(machine);
		// mpm3.setPercentagetype(1L);
		// mpm3.setOperator(Long.parseLong(agreedPercentageOperator));
		//
		// machineServices.addOrUpdateMachinePercentageMapping(mpm3);
		// MachinePercentageMapping oldmpm3 = machineServices
		// .lastMachinePercentageMapping();
		//
		// MachineUserMapping mum3 = new MachineUserMapping();
		// mum3.setMachine(machine);
		// mum3.setUserId(operatorID);
		// mum3.setMpmId(oldmpm3.getId());
		// machineServices.addOrUpdateMachineUserMapping(mum3);
		// }
		//
		// // Admin player gift
		//
		// if (!adminPlayerGift) {
		// MachinePercentageMapping mpm4 = new MachinePercentageMapping();
		// mpm4.setMachine(machine);
		// mpm4.setPercentagetype(2L);
		// mpm4.setAdmin(Long.parseLong(playersGiftAdmin));
		//
		// machineServices.addOrUpdateMachinePercentageMapping(mpm4);
		// MachinePercentageMapping oldmpm4 = machineServices
		// .lastMachinePercentageMapping();
		//
		// MachineUserMapping mum4 = new MachineUserMapping();
		// mum4.setMachine(machine);
		// mum4.setUserId(loggedAdmin.getId());
		// mum4.setMpmId(oldmpm4.getId());
		//
		// machineServices.addOrUpdateMachineUserMapping(mum4);
		// }
		//
		// // Establishment player gift
		//
		// if (!establishmentPlayerGift) {
		// MachinePercentageMapping mpm5 = new MachinePercentageMapping();
		// mpm5.setMachine(machine);
		// mpm5.setPercentagetype(2L);
		// mpm5.setEstablishment(Long.parseLong(playersGiftEstablishment));
		//
		// machineServices.addOrUpdateMachinePercentageMapping(mpm5);
		// MachinePercentageMapping oldmpm5 = machineServices
		// .lastMachinePercentageMapping();
		//
		// MachineUserMapping mum5 = new MachineUserMapping();
		// mum5.setMachine(machine);
		// mum5.setMpmId(oldmpm5.getId());
		// if (establishmentIDStr.equals(null)) {
		// mum5.setUserId(establishmentID);
		// }
		//
		// machineServices.addOrUpdateMachineUserMapping(mum5);
		// }
		//
		// // Operator player gift
		//
		// if (!operatorPlayerGift) {
		// MachinePercentageMapping mpm6 = new MachinePercentageMapping();
		// mpm6.setMachine(machine);
		// mpm6.setPercentagetype(2L);
		// mpm6.setOperator(Long.parseLong(playersGiftOperator));
		//
		// machineServices.addOrUpdateMachinePercentageMapping(mpm6);
		// MachinePercentageMapping oldmpm6 = machineServices
		// .lastMachinePercentageMapping();
		//
		// MachineUserMapping mum6 = new MachineUserMapping();
		// mum6.setMachine(machine);
		// mum6.setUserId(operatorID);
		// mum6.setMpmId(oldmpm6.getId());
		//
		// machineServices.addOrUpdateMachineUserMapping(mum6);
		// }
		//
		// // Admin Other expenses
		//
		// if (!adminOtherExpenses) {
		// MachinePercentageMapping mpm7 = new MachinePercentageMapping();
		// mpm7.setMachine(machine);
		// mpm7.setPercentagetype(3L);
		// mpm7.setAdmin(Long.parseLong(otherExpensesAdmin));
		//
		// machineServices.addOrUpdateMachinePercentageMapping(mpm7);
		// MachinePercentageMapping oldmpm7 = machineServices
		// .lastMachinePercentageMapping();
		//
		// MachineUserMapping mum7 = new MachineUserMapping();
		// mum7.setMachine(machine);
		// mum7.setUserId(loggedAdmin.getId());
		// mum7.setMpmId(oldmpm7.getId());
		//
		// machineServices.addOrUpdateMachineUserMapping(mum7);
		// }
		//
		// // Establishment Other expanses
		//
		// if (!establishmentOtherExpenses) {
		// MachinePercentageMapping mpm8 = new MachinePercentageMapping();
		// mpm8.setMachine(machine);
		// mpm8.setPercentagetype(3L);
		// mpm8.setEstablishment(Long.parseLong(otherExpensesEstablishment));
		//
		// machineServices.addOrUpdateMachinePercentageMapping(mpm8);
		// MachinePercentageMapping oldmpm8 = machineServices
		// .lastMachinePercentageMapping();
		//
		// MachineUserMapping mum8 = new MachineUserMapping();
		// mum8.setMachine(machine);
		// mum8.setMpmId(oldmpm8.getId());
		// if (establishmentIDStr.equals(null)) {
		// mum8.setUserId(establishmentID);
		// }
		// machineServices.addOrUpdateMachineUserMapping(mum8);
		// }
		//
		// // Operator Other Expanses
		//
		// if (!operatorOtherExpenses) {
		// MachinePercentageMapping mpm9 = new MachinePercentageMapping();
		// mpm9.setMachine(machine);
		// mpm9.setPercentagetype(3L);
		// mpm9.setOperator(Long.parseLong(otherExpensesOperator));
		//
		// machineServices.addOrUpdateMachinePercentageMapping(mpm9);
		// MachinePercentageMapping oldmpm9 = machineServices
		// .lastMachinePercentageMapping();
		//
		// MachineUserMapping mum9 = new MachineUserMapping();
		// mum9.setMachine(machine);
		// mum9.setUserId(operatorID);
		// mum9.setMpmId(oldmpm9.getId());
		//
		// machineServices.addOrUpdateMachineUserMapping(mum9);
		// }

		Set<Machine> machineList = machineServices.getMachineList();
		model.addAttribute("machineActive", "machineActive");
		model.addAttribute(new Machine());
		model.addAttribute("machineList", machineList);

		model.addAttribute("userId", loggedAdmin.getId());
		return "machineList";
	}

	@RequestMapping("/country")
	public String countyHome(@ModelAttribute("country") Country country,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String action = "action";

		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
		}

		boolean isAdd = false;
		boolean countryPresent = false;
		if (action != null) {
			if (action.equals("add")) {
				System.out.println("add country");

				Set<Country> countryList = countryServices.getCountryList();
				if (countryList.size() == 0) {
					if (countryServices.addOrUpdateCountry(country)) {
						System.out.println("country added");
						isAdd = true;

					}
				} else {
					countryPresent = true;
				}

			} else if (action.equals("edit")) {
				Country cutry = countryServices.getCountryById(country.getId());

				cutry.setCountry(country.getCountry());
				cutry.setCurrency(country.getCurrency());

				if (countryServices.addOrUpdateCountry(cutry)) {
					System.out.println("country edited");
				}
			}
		}

		if (isAdd) {
			Country lastCountry = countryServices.getLastCountry();
			model.addAttribute("countryID", lastCountry.getId());
			return "addCoinsName";
		} else {

			System.out.println("countryPresent: " + countryPresent);
			if (countryPresent) {
				model.addAttribute("countryPresent", "already");
			} else {
				model.addAttribute("countryPresent", "notalready");
			}
			Set<Country> countryList = countryServices.getCountryList();
			model.addAttribute("countryActive", "countryActive");
			model.addAttribute(new Country());
			model.addAttribute("countryList", countryList);
			return "countryList";
		}
	}

	@RequestMapping(value = "/addCoinsNameMore", method = RequestMethod.POST)
	public String addCoinsNameMore(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		String countryID = request.getParameter("countryID");

		int cID = 0;
		Country country = null;
		if ((!countryID.equals(""))) {
			cID = Integer.parseInt(countryID);
			country = countryServices.getCountryById(cID);
		}
		String code = request.getParameter("code");
		String value = request.getParameter("value");
		String name = request.getParameter("name");
		if (country != null && (!code.equals("")) && (!value.equals(""))
				&& (!name.equals(""))) {
			double val = Double.parseDouble(value);
			Coins coins = new Coins();
			coins.setCode(code);
			coins.setValue(val);
			coins.setCountry(country);
			coins.setName(name);
			coinsServices.addOrUpdateCoins(coins);
		}
		model.addAttribute("countryID", cID);
		return "addCoinsName";
	}

	@RequestMapping(value = "/addCoinsNameDone")
	public String addCoinsNameDone(@RequestParam("countryId") String str,
			@RequestParam("code") String code,
			@RequestParam("value") String value,
			@RequestParam("name") String name, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		int cID = 0;
		Country country = null;
		if ((!str.equals(""))) {
			cID = Integer.parseInt(str);
			country = countryServices.getCountryById(cID);
		}

		if (country != null && (!code.equals("")) && (!value.equals(""))
				&& (!name.equals(""))) {
			Coins coins = new Coins();
			coins.setCode(code);
			coins.setCountry(country);
			coins.setName(name);
			double val = Double.parseDouble(value);
			coins.setValue(val);

			coinsServices.addOrUpdateCoins(coins);
		}
		model.addAttribute("countryID", cID);
		return "addNotesName";
	}

	@RequestMapping(value = "/addNotesNameMore", method = RequestMethod.POST)
	public String addNotesNameMore(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		String countryID = request.getParameter("countryID");

		int cID = 0;
		Country country = null;
		if ((!countryID.equals(""))) {
			cID = Integer.parseInt(countryID);
			country = countryServices.getCountryById(cID);
		}
		String code = request.getParameter("code");
		String value = request.getParameter("value");
		String name = request.getParameter("name");
		if (country != null && (!code.equals("")) && (!value.equals(""))
				&& (!name.equals(""))) {
			double val = Double.parseDouble(value);
			Notes notes = new Notes();
			notes.setCode(code);
			notes.setValue(val);
			notes.setCountry(country);
			notes.setName(name);
			notesServices.addOrUpdateNotes(notes);
		}
		model.addAttribute("countryID", cID);
		return "addNotesName";
	}

	@RequestMapping(value = "/addNotesNameDone")
	public String addNotesNameDone(@RequestParam("countryId") String str,
			@RequestParam("code") String code,
			@RequestParam("value") String value,
			@RequestParam("name") String name, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		int cID = 0;
		Country country = null;
		if ((!str.equals(""))) {
			cID = Integer.parseInt(str);
			country = countryServices.getCountryById(cID);
		}

		if (country != null && (!code.equals("")) && (!value.equals(""))
				&& (!name.equals(""))) {
			Notes notes = new Notes();
			notes.setCode(code);
			notes.setCountry(country);
			double val = Double.parseDouble(value);
			notes.setValue(val);
			notes.setName(name);
			notesServices.addOrUpdateNotes(notes);

			model.addAttribute("countryID", cID);
		}
		return "addTokens";

	}

	@RequestMapping(value = "/addTokensMore", method = RequestMethod.POST)
	public String addTokensMore(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		String countryID = request.getParameter("countryID");

		int cID = 0;
		Country country = null;
		if ((!countryID.equals(""))) {
			cID = Integer.parseInt(countryID);
			country = countryServices.getCountryById(cID);
		}
		String code = request.getParameter("code");
		String value = request.getParameter("value");
		String name = request.getParameter("name");
		if (country != null && (!code.equals("")) && (!value.equals(""))
				&& (!name.equals(""))) {
			double val = Double.parseDouble(value);
			Tokens tokens = new Tokens();
			tokens.setCode(code);
			tokens.setValue(val);
			tokens.setCountry(country);
			tokens.setName(name);
			tokensServices.addOrUpdateTokens(tokens);
		}
		model.addAttribute("countryID", cID);
		return "addTokens";
	}

	@RequestMapping(value = "/addTokensDone")
	public String addTokenDone(@RequestParam("countryId") String str,
			@RequestParam("code") String code,
			@RequestParam("value") String value,
			@RequestParam("name") String name, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		int cID = 0;
		Country country = null;
		if ((!str.equals(""))) {
			cID = Integer.parseInt(str);
			country = countryServices.getCountryById(cID);
		}

		if (country != null && (!code.equals("")) && (!value.equals(""))
				&& (!name.equals(""))) {
			Tokens tokens = new Tokens();
			tokens.setCode(code);
			tokens.setCountry(country);
			tokens.setName(name);
			double val = Double.parseDouble(value);
			tokens.setValue(val);

			tokensServices.addOrUpdateTokens(tokens);
		}
		model.addAttribute("countryID", cID);
		Set<Country> countryList = countryServices.getCountryList();
		model.addAttribute("countryActive", "countryActive");
		model.addAttribute(new Country());
		model.addAttribute("countryList", countryList);
		return "countryList";
	}

	/*
	 * @RequestMapping(value = "/addBillsMore", method = RequestMethod.POST)
	 * public String addBillsMore(HttpServletRequest request,
	 * HttpServletResponse response, ModelMap model) {
	 * 
	 * String countryID = request.getParameter("countryID");
	 * 
	 * int cID = 0; Country country = null; if ((!countryID.equals(""))) { cID =
	 * Integer.parseInt(countryID); country =
	 * countryServices.getCountryById(cID); } String code =
	 * request.getParameter("code"); String value =
	 * request.getParameter("value"); String name =
	 * request.getParameter("name"); if (country != null && (!code.equals(""))
	 * && (!value.equals("")) && (!name.equals(""))) { double val =
	 * Double.parseDouble(value); Bills bills = new Bills();
	 * bills.setCode(code); bills.setValue(val); bills.setCountry(country);
	 * bills.setName(name); billsServices.addOrUpdateBills(bills); }
	 * model.addAttribute("countryID", cID); return "addBills"; }
	 * 
	 * @RequestMapping(value = "/addBillsDone") public String
	 * addBillsDone(@RequestParam("countryId") String str,
	 * 
	 * @RequestParam("code") String code,
	 * 
	 * @RequestParam("value") String value,
	 * 
	 * @RequestParam("name") String name, HttpServletRequest request,
	 * HttpServletResponse response, ModelMap model) {
	 * 
	 * int cID = 0; Country country = null; if ((!str.equals(""))) { cID =
	 * Integer.parseInt(str); country = countryServices.getCountryById(cID); }
	 * 
	 * if (country != null && (!code.equals("")) && (!value.equals("")) &&
	 * (!name.equals(""))) { Bills bills = new Bills(); bills.setCode(code);
	 * bills.setCountry(country); bills.setName(name); double val =
	 * Double.parseDouble(value); bills.setValue(val);
	 * 
	 * billsServices.addOrUpdateBills(bills); } Set<Country> countryList =
	 * countryServices.getCountryList(); model.addAttribute("countryActive",
	 * "countryActive"); model.addAttribute(new Country());
	 * model.addAttribute("countryList", countryList); return "countryList"; }
	 */
	/*
	 * @RequestMapping("/tokensNameValue") public String
	 * tokensNameValueList(HttpServletRequest request,HttpServletResponse
	 * response,ModelMap model){
	 * 
	 * String[] codes = request.getParameterValues("code"); String[] values =
	 * request.getParameterValues("value"); String[] tokensNameIds =
	 * request.getParameterValues("tokensNameId"); String countryID =
	 * request.getParameter("countryID");
	 * 
	 * //double[] valueDouble = null;
	 * 
	 * //TokensName[] tnList = null;
	 * 
	 * List<Double> valueDouble = new ArrayList<Double>(); List<TokensName>
	 * tnList = new ArrayList<TokensName>(); for (String string : codes) {
	 * System.out.println("code:"+string); } for (int i = 0; i < values.length;
	 * i++) { System.out.println("values[i]:"+values[i]); double val =
	 * Double.parseDouble(values[i]); valueDouble.add(val); } for (int i = 0; i
	 * < tokensNameIds.length; i++) { long id =
	 * Long.parseLong(tokensNameIds[i]); TokensName tn =
	 * tokensNameServices.getTokensNameById(id); tnList.add(tn); }
	 * 
	 * for (String string : tokensNameIds) {
	 * System.out.println("tokensNameId:"+string); }
	 * System.out.println("countryID:"+countryID); long cID =
	 * Long.parseLong(countryID); Country country =
	 * countryServices.getCountryById(cID);
	 * 
	 * for (int i = 0; i < tnList.size(); i++) { TokensNameValue tnv = new
	 * TokensNameValue(); tnv.setCode(codes[i]); tnv.setCountry(country);
	 * tnv.setTokensName(tnList.get(i)); tnv.setValue(valueDouble.get(i));
	 * tokensNameValueServices.addOrUpdateTokensNameValue(tnv); }
	 * 
	 * Set<BillsName> billsNameList= billsNameServices.getBillsNameList();
	 * model.addAttribute("billsNameList", billsNameList);
	 * model.addAttribute("countryID", cID); model.addAttribute("currency",
	 * country.getCurrency()); return "billsNameValueList"; }
	 */

	/*
	 * @RequestMapping("/billsNameValue") public String
	 * billsNameValueList(HttpServletRequest request,HttpServletResponse
	 * response,ModelMap model){
	 * 
	 * String[] codes = request.getParameterValues("code"); String[] values =
	 * request.getParameterValues("value"); String[] tokensNameIds =
	 * request.getParameterValues("billsNameId"); String countryID =
	 * request.getParameter("countryID");
	 * 
	 * 
	 * List<Double> valueDouble = new ArrayList<Double>(); List<BillsName>
	 * bnList = new ArrayList<BillsName>(); for (String string : codes) {
	 * System.out.println("code:"+string); } for (int i = 0; i < values.length;
	 * i++) { System.out.println("values[i]:"+values[i]); double val =
	 * Double.parseDouble(values[i]); valueDouble.add(val); } for (int i = 0; i
	 * < tokensNameIds.length; i++) { long id =
	 * Long.parseLong(tokensNameIds[i]); BillsName tn =
	 * billsNameServices.getBillsNameById(id); bnList.add(tn); }
	 * 
	 * for (String string : tokensNameIds) {
	 * System.out.println("tokensNameId:"+string); }
	 * System.out.println("countryID:"+countryID); long cID =
	 * Long.parseLong(countryID); Country country =
	 * countryServices.getCountryById(cID);
	 * 
	 * for (int i = 0; i < bnList.size(); i++) { BillsNameValue bnv = new
	 * BillsNameValue(); bnv.setCode(codes[i]); bnv.setCountry(country);
	 * bnv.setBillsName(bnList.get(i)); bnv.setValue(valueDouble.get(i));
	 * billsNameValueServices.addOrUpdateBillsNameValue(bnv); }
	 * 
	 * Set<Country> countryList= countryServices.getCountryList();
	 * model.addAttribute("countryActive", "countryActive");
	 * model.addAttribute(new Country()); model.addAttribute("countryList",
	 * countryList); return "countryList"; }
	 */

	@RequestMapping(value = "/deleteCountryList")
	public String deleteCountry(@RequestParam("list") String str,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		str = str.substring(0, str.length() - 1);
		System.out.println(str);
		String[] str1 = str.split(",");

		for (int i = 0; i < str1.length; i++) {

			int id = Integer.parseInt(str1[i]);

			System.out.println("countryId:" + id);
			Set<Notes> notes = notesServices.getNotesListByCountry(id);
			for (Notes notes2 : notes) {
				System.out.println("notes: " + notes2.getId());
				notesServices.deleteNotes(notes2.getId());
			}

			Set<Coins> coins = coinsServices.getCoinsListByCountry(id);
			for (Coins coins2 : coins) {
				coinsServices.deleteCoins(coins2.getId());
			}

			Set<Tokens> tokens = tokensServices.getTokensListByCountry(id);
			for (Tokens tokens2 : tokens) {
				tokensServices.deleteTokens(tokens2.getId());
			}
			countryServices.deleteCountry(id);

		}

		Set<Country> countryList = countryServices.getCountryList();
		model.addAttribute("countryActive", "countryActive");
		model.addAttribute(new Country());
		model.addAttribute("countryList", countryList);
		return "countryList";
	}

	@RequestMapping("/machineType")
	public String machineType(
			@ModelAttribute("machineTypeForm") MachineTypeForm machineTypeForm,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		Admin loggedAdmin = adminServices.getAdminByUsername(userName);

		String action = "action";

		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
		}

		if (action != null) {
			if (action.equals("add")) {

				long[] paymentDevices = machineTypeForm.getPaymentDeviceType();
				List<PaymentDeviceType> paymentDeviceTypes = new ArrayList<PaymentDeviceType>();
				for (int i = 0; i < paymentDevices.length; i++) {
					PaymentDeviceType paymentDeviceType = new PaymentDeviceType();
					System.out.println("Id:" + paymentDevices[i]);
					paymentDeviceType = paymentDeviceTypeServices
							.getPaymentDeviceTypeById(paymentDevices[i]);
					System.out.println("after:" + paymentDeviceType.getId()
							+ paymentDeviceType.getModel());
					paymentDeviceTypes.add(paymentDeviceType);
				}
				Set<PaymentDeviceType> paymentDeviceTypeSet = new HashSet<PaymentDeviceType>(
						paymentDeviceTypes);

				MachineType machineType = new MachineType(machineTypeForm);
				machineType.setPaymentDeviceType(paymentDeviceTypeSet);
				if (machineTypeServices.addOrUpdateMachineType(machineType)) {
					System.out.println("machineType added");

				}

			} else if (action.equals("edit")) {
				long[] paymentDevices = machineTypeForm.getPaymentDeviceType();
				List<PaymentDeviceType> paymentDeviceTypes = new ArrayList<PaymentDeviceType>();
				for (int i = 0; i < paymentDevices.length; i++) {
					PaymentDeviceType paymentDeviceType = new PaymentDeviceType();
					paymentDeviceType = paymentDeviceTypeServices
							.getPaymentDeviceTypeById(paymentDevices[i]);
					paymentDeviceTypes.add(paymentDeviceType);
				}
				Set<PaymentDeviceType> paymentDeviceTypeSet = new HashSet<PaymentDeviceType>(
						paymentDeviceTypes);

				MachineType oldMachineType = machineTypeServices
						.getMachineTypeById(machineTypeForm.getId());
				oldMachineType.setDescription(machineTypeForm.getDescription());
				if (machineTypeForm.getGprsModem().equals("YES")) {
					oldMachineType.setGprsModem(true);
				} else {
					oldMachineType.setGprsModem(true);
				}
				if (machineTypeForm.getLockCode().equals("YES")) {
					oldMachineType.setLockCode(true);
				} else {
					oldMachineType.setLockCode(false);
				}
				if (machineTypeForm.getWirelessControl().equals("YES")) {
					oldMachineType.setWirelessControl(true);
				} else {
					oldMachineType.setWirelessControl(false);
				}
				oldMachineType.setModel(machineTypeForm.getModel());
				oldMachineType.setPaymentDeviceType(paymentDeviceTypeSet);
				if (machineTypeServices.addOrUpdateMachineType(oldMachineType)) {
					System.out.println("machineType edited");
				}
			}
		}

		Set<MachineType> machineTypeList = machineTypeServices
				.getMachineTypeList();

		Set<PaymentDeviceType> paymentDeviceTypeList = paymentDeviceTypeServices
				.getPaymentDeviceTypeList();
		model.addAttribute("machineTypeActive", "machineTypeActive");
		model.addAttribute(new MachineTypeForm());
		model.addAttribute("machineTypeList", machineTypeList);
		model.addAttribute("paymentDeviceTypeList", paymentDeviceTypeList);
		return "machineTypeList";

	}

	@RequestMapping(value = "/deleteMachineTypesList")
	public String deleteTokensList(@RequestParam("list") String str,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		str = str.substring(0, str.length() - 1);
		System.out.println(str);
		String[] str1 = str.split(",");
		boolean isError = true;

		for (int i = 0; i < str1.length; i++) {

			long id = Integer.parseInt(str1[i]);
			System.out.println("ID:" + id);

			// return false if fails
			isError = machineTypeServices.deleteMachineType(id);

		}

		Set<MachineType> machineTypeList = machineTypeServices
				.getMachineTypeList();

		if (!isError) {
			Set<PaymentDeviceType> paymentDeviceTypeList = paymentDeviceTypeServices
					.getPaymentDeviceTypeList();
			model.addAttribute("machineTypeActive", "machineTypeActive");
			model.addAttribute(new MachineTypeForm());
			model.addAttribute("machineTypeList", machineTypeList);
			model.addAttribute("paymentDeviceTypeList", paymentDeviceTypeList);
			model.addAttribute("error", "1");
			return "machineTypeList";
		} else {
			Set<PaymentDeviceType> paymentDeviceTypeList = paymentDeviceTypeServices
					.getPaymentDeviceTypeList();
			model.addAttribute("machineTypeActive", "machineTypeActive");
			model.addAttribute(new MachineTypeForm());
			model.addAttribute("machineTypeList", machineTypeList);
			model.addAttribute("paymentDeviceTypeList", paymentDeviceTypeList);
			return "machineTypeList";
		}
	}

	@RequestMapping("/users")
	public String users(@ModelAttribute("usersForm") UsersForm usersForm,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		Admin loggedAdmin = adminServices.getAdminByUsername(userName);

		String action = "action";

		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
		}

		if (action != null) {
			if (action.equals("add")) {
				Users users = new Users();
				users.setName(usersForm.getName());
				users.setPassword(usersForm.getPassword());
				users.setUsername(usersForm.getUsername());
				Set<UsersRole> usersRoleList = new HashSet<UsersRole>();
				long[] usersRoleIds = usersForm.getUsersRole();
				for (int i = 0; i < usersRoleIds.length; i++) {
					UsersRole usersRole = usersRoleServices
							.getUsersRoleById(usersRoleIds[i]);
					usersRoleList.add(usersRole);
				}
				users.setUsersRole(usersRoleList);
				usersServices.addOrUpdateUsers(users);
			}
		}

		Set<Users> usersList = usersServices.getUsersByAdminId(loggedAdmin
				.getId());
		Set<UsersRole> usersRoleList = usersRoleServices
				.getUsersRoleByAdminId(loggedAdmin.getId());
		model.addAttribute("usersRoleList", usersRoleList);
		model.addAttribute("usersList", usersList);
		return "usersList";
	}

	@RequestMapping("/usersRole")
	public String usersRole(@ModelAttribute("usersRole") UsersRole usersRole,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		Admin loggedAdmin = adminServices.getAdminByUsername(userName);

		String action = "action";

		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
		}

		if (action != null) {
			if (action.equals("add")) {
				usersRole.setAdmin(loggedAdmin);
				usersRoleServices.addOrUpdateUsersRole(usersRole);
			}
		}

		Set<UsersRole> usersRoleList = usersRoleServices
				.getUsersRoleByAdminId(loggedAdmin.getId());
		model.addAttribute(new UsersRole());
		model.addAttribute("usersRoleList", usersRoleList);
		return "usersRoleList";
	}

	/*
	 * @RequestMapping(value="/paymentDevices", method=RequestMethod.POST)
	 * public String paymentDevices(HttpServletRequest
	 * request,HttpServletResponse response,ModelMap model){ String action =
	 * null; if(request.getParameter("action")!=null){
	 * action=request.getParameter("action"); } boolean isHopper = false;
	 * boolean isCS = false; boolean isBV = false; long mvId = 0;
	 * if(action.equals("addHopper")){ String noOfHopperstr =
	 * request.getParameter("noOfHopper"); String mvIdStr =
	 * request.getParameter("mvid"); int noOfHopper =
	 * Integer.parseInt(noOfHopperstr); mvId = Long.parseLong(mvIdStr);
	 * MachineType mt = machineTypeServices.getMachineTypeById(mvId); for (int i
	 * = 0; i < noOfHopper; i++) { HopperType ht = new HopperType();
	 * ht.setMachineType(mt); hopperTypeServices.addOrUpdateHopperType(ht); }
	 * isHopper = true; }else if(action.equals("addCoinSelector")){ String
	 * noOfHopperstr = request.getParameter("noOfCoinSelector"); String mvIdStr
	 * = request.getParameter("mvid"); int noOfHopper =
	 * Integer.parseInt(noOfHopperstr); mvId = Long.parseLong(mvIdStr);
	 * MachineType mt = machineTypeServices.getMachineTypeById(mvId); for (int i
	 * = 0; i < noOfHopper; i++) { CoinValidatorType cvt = new
	 * CoinValidatorType(); cvt.setMachineType(mt);
	 * coinValidatorTypeServices.addOrUpdateCoinValidatorType(cvt); CoinsType ct
	 * = new CoinsType(); //ct.setCoinValidatorType(cvt);
	 * coinsTypeServices.addOrUpdateCoinsType(ct);
	 * 
	 * } isCS = true; }else if(action.equals("addBillValidator")){ String
	 * noOfHopperstr = request.getParameter("noOfBillValidator"); String mvIdStr
	 * = request.getParameter("mvid"); int noOfHopper =
	 * Integer.parseInt(noOfHopperstr); mvId = Long.parseLong(mvIdStr);
	 * MachineType mt = machineTypeServices.getMachineTypeById(mvId); for (int i
	 * = 0; i < noOfHopper; i++) { BillValidatorType bvt = new
	 * BillValidatorType(); bvt.setMachineType(mt);
	 * billValidatorTypeServices.addOrUpdateBillValidatorType(bvt); BillsType bt
	 * = new BillsType(); // bt.setBillValidatorType(bvt);
	 * billsTypeServices.addOrUpdateBillsType(bt); } isBV = true; }
	 * if(isHopper){ model.addAttribute("mvid",mvId); return "hopperTypeInfo";
	 * }else if(isCS){ model.addAttribute("mvid",mvId); CoinsType ct = new
	 * CoinsType(); ct = coinsTypeServices.getLastCoinsType();
	 * model.addAttribute("ctid",ct.getId()); return "coinsValueInfo"; }else
	 * if(isBV){ model.addAttribute("mvid",mvId); BillsType bt = new
	 * BillsType(); bt = billsTypeServices.getLastBillsType();
	 * model.addAttribute("btid",bt.getId()); return "billsValueInfo"; }else{
	 * return null; } }
	 */

	/*
	 * @RequestMapping(value="/hopperTypeConfig", method=RequestMethod.POST)
	 * public String hopperTypeConfig(HttpServletRequest
	 * request,HttpServletResponse response,ModelMap model){ String action =
	 * null; long mvId = 0; boolean isSingle = false; boolean isMulti = false;
	 * HopperType ht = null; if(request.getParameter("action")!=null){
	 * action=request.getParameter("action"); }
	 * if(action.equals("addHopperAccept")){ String[]
	 * valueType=request.getParameterValues("valueType");
	 * 
	 * if(valueType[0] != null){ if(valueType[0].equals("singleCoin")){ String
	 * mvIdStr = request.getParameter("mvid");
	 * 
	 * mvId = Long.parseLong(mvIdStr); MachineType mt =
	 * machineTypeServices.getMachineTypeById(mvId); Set<HopperType> htSet =
	 * hopperTypeServices.getHopperTypeByMachineId(mt.getId());
	 * System.out.println("singleCoin");
	 * 
	 * for (HopperType hopperType : htSet) { //check if hopper capacity is zero,
	 * means other details are remaining. if(hopperType.getCapacity() == 0){ ht
	 * = hopperType; } } CoinsType ct = new CoinsType(); //ct.setHopperType(ht);
	 * coinsTypeServices.addOrUpdateCoinsType(ct); if(valueType.length >1){
	 * if(valueType[1] != null){ if(valueType[1].equals("token")){ // add token
	 * for hopper TokensType tt = new TokensType(); // tt.setHopperType(ht);
	 * tokensTypeServices.addOrUpdateTokensType(tt); } } }
	 * 
	 * isSingle = true; }else if(valueType[0].equals("multiCoin")){ String
	 * mvIdStr = request.getParameter("mvid");
	 * 
	 * mvId = Long.parseLong(mvIdStr); MachineType mt =
	 * machineTypeServices.getMachineTypeById(mvId); Set<HopperType> htSet =
	 * hopperTypeServices.getHopperTypeByMachineId(mt.getId());
	 * System.out.println("singleCoin");
	 * 
	 * for (HopperType hopperType : htSet) { //check if hopper capacity is zero,
	 * means other details are remaining. if(hopperType.getCapacity() == 0){ ht
	 * = hopperType; } } Set<HopperType> htSet =
	 * hopperTypeServices.getHopperTypeByMachineId(mt.getId()); HopperType ht
	 * =null; for (HopperType hopperType : htSet) { //check if hopper capacity
	 * is zero, means other details are remaining. if(hopperType.getCapacity()
	 * == 0){ ht = hopperType; } } TokensType tt = new TokensType();
	 * //tt.setHopperType(ht); tokensTypeServices.addOrUpdateTokensType(tt);
	 * isMulti= true; } }
	 * 
	 * 
	 * } if(isSingle){ Set<Country> countrySet =
	 * countryServices.getCountryList(); List<Country> countryList = new
	 * ArrayList<Country>(countrySet);
	 * 
	 * 
	 * 
	 * Country firstCountry = null; Set<CoinsName> coinsNameSet = new
	 * HashSet<CoinsName>();
	 * 
	 * for (Country country : countryList) {
	 * 
	 * coinsNameSet = coinsNameServices.getCoinsNameByCountry(country.getId());
	 * //country.setDone(true); countryServices.addOrUpdateCountry(country);
	 * if(coinsNameSet != null){ firstCountry = country; break; } }
	 * 
	 * for (CoinsName coinsName : coinsNameSet) {
	 * System.out.println("coinsName:"+coinsName.getCode() +
	 * "\t"+coinsName.getValue()); }
	 * 
	 * List<CoinsName> coinsNameList = new ArrayList<CoinsName>(coinsNameSet);
	 * Map< String, String > coins = new HashMap<String, String>(); for
	 * (CoinsName coinssName : coinsNameList) {
	 * coins.put(String.valueOf(coinssName.getId()) ,
	 * String.valueOf(coinssName.getValue())); } model.addAttribute("country",
	 * firstCountry); model.addAttribute("coinsNameSet", coins);
	 * model.addAttribute("hopperType", ht); model.addAttribute("isSingle",
	 * "yes"); model.addAttribute(new CoinsNameForm()); ht.setSingleCoin(true);
	 * hopperTypeServices.addOrUpdateHopperType(ht); return
	 * "addCountryCoinsValue"; }else if(isMulti){ Set<Country> countrySet =
	 * countryServices.getCountryList(); List<Country> countryList = new
	 * ArrayList<Country>(countrySet);
	 * 
	 * 
	 * 
	 * Country firstCountry = null; Set<CoinsName> coinsNameSet = new
	 * HashSet<CoinsName>();
	 * 
	 * for (Country country : countryList) {
	 * 
	 * coinsNameSet = coinsNameServices.getCoinsNameByCountry(country.getId());
	 * //country.setDone(true); countryServices.addOrUpdateCountry(country);
	 * if(coinsNameSet != null){ firstCountry = country; break; } }
	 * 
	 * for (CoinsName coinsName : coinsNameSet) {
	 * System.out.println("coinsName:"+coinsName.getCode() +
	 * "\t"+coinsName.getValue()); } List<CoinsName> coinsNameList = new
	 * ArrayList<CoinsName>(coinsNameSet); Map< String, String > coins = new
	 * HashMap<String, String>(); for (CoinsName coinssName : coinsNameList) {
	 * coins.put(String.valueOf(coinssName.getId()) ,
	 * String.valueOf(coinssName.getValue())); } model.addAttribute("country",
	 * firstCountry); model.addAttribute("coinsNameSet", coins);
	 * model.addAttribute("hopperType", ht); model.addAttribute("isSingle",
	 * "no"); model.addAttribute(new CoinsNameForm()); ht.setSingleCoin(false);
	 * hopperTypeServices.addOrUpdateHopperType(ht); return
	 * "addCountryCoinsValue"; }else{ return null; }
	 * 
	 * }
	 */

	/*
	 * @RequestMapping(value="/addCountryCoinsValue", method=RequestMethod.POST)
	 * public String addCountryCoinsValue(@ModelAttribute("coinsNameForm")
	 * CoinsNameForm coinsNameForm,HttpServletRequest
	 * request,HttpServletResponse response,ModelMap model){
	 * 
	 * String action = request.getParameter("action");
	 * if(action.equals("addHopper")){
	 * 
	 * System.out.println("htid:"+request.getParameter("htid")); String[]
	 * coinsNameSet=request.getParameterValues("ids"); for (String string :
	 * coinsNameSet) { System.out.println("coinsName:"+string); }
	 * 
	 * 
	 * HopperType ht =
	 * hopperTypeServices.getHopperTypeById(Long.parseLong(request
	 * .getParameter("htid"))); Country country =
	 * countryServices.getCountryById(
	 * Long.parseLong(request.getParameter("countryID")));
	 * 
	 * for (int i = 0; i < coinsNameSet.length; i++) { CountryCoinsValue ccv =
	 * new CountryCoinsValue(); CoinsName cn =
	 * coinsNameServices.getCoinsNameById(Long.parseLong(coinsNameSet[i]));
	 * ccv.setCoinsName(cn); ccv.setHopperType(ht);
	 * countryCoinsValueServices.addOrUpdateCountryCoinsValue(ccv);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * Set<Country> countrySet = countryServices.getCountryList();
	 * Set<CoinsName> coinsNames = new HashSet<CoinsName>(); Country
	 * firstCountry = null; for (Country country2 : countrySet) {
	 * //if(!country2.isDone()){
	 * 
	 * coinsNames = coinsNameServices.getCoinsNameByCountry(country2.getId());
	 * //country2.setDone(true); countryServices.addOrUpdateCountry(country2);
	 * if(coinsNames != null){
	 * 
	 * firstCountry = country2; break; } //} }
	 * 
	 * if(firstCountry != null){ model.addAttribute("country", firstCountry);
	 * 
	 * List<CoinsName> coinsNameList = new ArrayList<CoinsName>(coinsNames);
	 * Map< String, String > coins = new HashMap<String, String>(); for
	 * (CoinsName coinssName : coinsNameList) {
	 * coins.put(String.valueOf(coinssName.getId()) ,
	 * String.valueOf(coinssName.getValue())); }
	 * 
	 * model.addAttribute("coinsNameSet", coins);
	 * 
	 * model.addAttribute("hopperType", ht); boolean isSingle =
	 * ht.isSingleCoin(); if(isSingle){ model.addAttribute("isSingle", "yes");
	 * }else{ model.addAttribute("isSingle", "no"); } model.addAttribute(new
	 * CoinsNameForm()); return "addCountryCoinsValue"; }else{
	 * 
	 * Set<Country> cSet = countryServices.getCountryList(); for (Country
	 * country2 : cSet) { //country2.setDone(false);
	 * countryServices.addOrUpdateCountry(country2); }
	 * 
	 * Country countryFirst = null; Set<NotesName> notesNameSet = new
	 * HashSet<NotesName>();
	 * 
	 * for (Country c : cSet) {
	 * 
	 * notesNameSet = notesNameServices.getNotesNameByCountry(c.getId());
	 * //c.setDone(true); countryServices.addOrUpdateCountry(country);
	 * if(notesNameSet != null){ countryFirst = country; break; } }
	 * 
	 * List<NotesName> notesNameList = new ArrayList<NotesName>(notesNameSet);
	 * 
	 * Map< String, String > notes = new HashMap<String, String>(); for
	 * (NotesName notesName : notesNameList) {
	 * notes.put(String.valueOf(notesName.getId()) ,
	 * String.valueOf(notesName.getValue())); }
	 * 
	 * 
	 * model.addAttribute("country", countryFirst);
	 * model.addAttribute("notesNameSet", notes);
	 * model.addAttribute("hopperType", ht);
	 * 
	 * 
	 * model.addAttribute(new NotesNameForm()); return "addCountryNotesValue"; }
	 * }else if(action.equals("addCoinValidator")){
	 * System.out.println("cvtid:"+request.getParameter("cvtid")); String[]
	 * coinsNameSet=request.getParameterValues("ids"); for (String string :
	 * coinsNameSet) { System.out.println("coinsName:"+string); }
	 * 
	 * 
	 * 
	 * CoinValidatorType cvt =
	 * coinValidatorTypeServices.getCoinValidatorTypeById
	 * (Long.parseLong(request.getParameter("cvtid"))); Country country =
	 * countryServices
	 * .getCountryById(Long.parseLong(request.getParameter("countryID")));
	 * 
	 * for (int i = 0; i < coinsNameSet.length; i++) { CountryCoinsValue ccv =
	 * new CountryCoinsValue(); CoinsName cn =
	 * coinsNameServices.getCoinsNameById(Long.parseLong(coinsNameSet[i]));
	 * ccv.setCoinsName(cn); ccv.setCoinValidatorType(cvt);
	 * countryCoinsValueServices.addOrUpdateCountryCoinsValue(ccv);
	 * 
	 * }
	 * 
	 * Set<Country> countrySet = countryServices.getCountryList();
	 * Set<CoinsName> coinsNames = new HashSet<CoinsName>(); Country
	 * firstCountry = null; for (Country country2 : countrySet) { //
	 * if(!country2.isDone()){
	 * 
	 * coinsNames = coinsNameServices.getCoinsNameByCountry(country2.getId());
	 * //country2.setDone(true); countryServices.addOrUpdateCountry(country2);
	 * if(coinsNames != null){
	 * 
	 * firstCountry = country2; break; } //} }
	 * 
	 * if(firstCountry != null){ model.addAttribute("country", firstCountry);
	 * 
	 * List<CoinsName> coinsNameList = new ArrayList<CoinsName>(coinsNames);
	 * Map< String, String > coins = new HashMap<String, String>(); for
	 * (CoinsName coinssName : coinsNameList) {
	 * coins.put(String.valueOf(coinssName.getId()) ,
	 * String.valueOf(coinssName.getValue())); }
	 * 
	 * model.addAttribute("coinsNameSet", coins);
	 * 
	 * model.addAttribute("coinValidatorType", cvt);
	 * 
	 * model.addAttribute("isCoinValidator", "yes"); model.addAttribute(new
	 * CoinsNameForm()); return "addCountryCoinsValue"; }else{ Set<Country> cSet
	 * = countryServices.getCountryList(); for (Country country2 : cSet) {
	 * //country2.setDone(false); countryServices.addOrUpdateCountry(country2);
	 * } model.addAttribute("coinValidatorTypeId", cvt.getId()); return
	 * "addCoinValidatorCapacity"; } }else{ return null; }
	 * 
	 * }
	 */

	/*
	 * @RequestMapping(value="/addCountryNotesValue", method=RequestMethod.POST)
	 * public String addCountryNotesValue(@ModelAttribute("notesNameForm")
	 * NotesNameForm notesNameForm,HttpServletRequest
	 * request,HttpServletResponse response,ModelMap model){
	 * 
	 * System.out.println("htid:"+request.getParameter("htid")); String[]
	 * notesIds=request.getParameterValues("ids");
	 * 
	 * 
	 * for (String string : notesIds) { System.out.println("notesName:"+string);
	 * }
	 * 
	 * 
	 * HopperType ht =
	 * hopperTypeServices.getHopperTypeById(Long.parseLong(request
	 * .getParameter("htid"))); Country country =
	 * countryServices.getCountryById(
	 * Long.parseLong(request.getParameter("countryID")));
	 * 
	 * for (int i = 0; i < notesIds.length; i++) { CountryNotesValue cnv = new
	 * CountryNotesValue(); NotesName nn =
	 * notesNameServices.getNotesNameById(Long.parseLong(notesIds[i]));
	 * cnv.setNotesName(nn); cnv.setHopperType(ht);
	 * countryNotesValueServices.addOrUpdateCountryNotesValue(cnv); }
	 * 
	 * Set<Country> countrySet = countryServices.getCountryList();
	 * Set<NotesName> notesNames = new HashSet<NotesName>();; Country
	 * firstCountry = null; for (Country country2 : countrySet) {
	 * //if(!country2.isDone()){
	 * 
	 * notesNames = notesNameServices.getNotesNameByCountry(country2.getId());
	 * //country2.setDone(true); countryServices.addOrUpdateCountry(country2);
	 * if(notesNames != null){
	 * 
	 * firstCountry = country2; break; } //} }
	 * 
	 * if(firstCountry != null){ model.addAttribute("country", firstCountry);
	 * 
	 * model.addAttribute("hopperType", ht); List<NotesName> notesNameList = new
	 * ArrayList<NotesName>(notesNames);
	 * 
	 * Map< String, String > notes = new HashMap<String, String>(); for
	 * (NotesName notesName : notesNameList) {
	 * notes.put(String.valueOf(notesName.getId()) ,
	 * String.valueOf(notesName.getValue())); } model.addAttribute(new
	 * NotesName()); model.addAttribute("notesNameSet", notes); return
	 * "addCountryNotesValue"; }else{ Set<Country> cSet =
	 * countryServices.getCountryList(); for (Country country2 : cSet) {
	 * //country2.setDone(false); countryServices.addOrUpdateCountry(country2);
	 * } Country countryFirst = null; Set<TokensNameValue> tokensNameValueSet =
	 * new HashSet<TokensNameValue>();
	 * 
	 * 
	 * 
	 * for (Country c : cSet) {
	 * 
	 * tokensNameValueSet =
	 * tokensNameValueServices.getTokensNameValueByCountry(c.getId());
	 * 
	 * //c.setDone(true); countryServices.addOrUpdateCountry(country);
	 * if(tokensNameValueSet != null){ countryFirst = country; break; } }
	 * List<TokensNameValue> tokensNameValueList = new
	 * ArrayList<TokensNameValue>(tokensNameValueSet); List<TokensName>
	 * tokensNameList = new ArrayList<TokensName>(); for (int i = 0; i <
	 * tokensNameValueList.size(); i++) {
	 * System.out.println("token name:"+tokensNameValueList
	 * .get(i).getTokensName().getName());
	 * tokensNameList.add(tokensNameValueList.get(i).getTokensName()); } Map<
	 * String, String > tokens = new HashMap<String, String>(); for (TokensName
	 * tokensName : tokensNameList) {
	 * tokens.put(String.valueOf(tokensName.getId()) ,
	 * String.valueOf(tokensName.getName())); } model.addAttribute("country",
	 * countryFirst); model.addAttribute("tokensNameList", tokens);
	 * model.addAttribute("hopperType", ht);
	 * 
	 * model.addAttribute(new TokensNameForm());
	 * 
	 * return "addCountryTokensValue"; }
	 * 
	 * 
	 * 
	 * }
	 */

	/*
	 * @RequestMapping(value="/addCountryTokensValue",
	 * method=RequestMethod.POST) public String
	 * addCountryTokensValue(@ModelAttribute("tokensNameForm") TokensNameForm
	 * tokensNameForm,HttpServletRequest request,HttpServletResponse
	 * response,ModelMap model){
	 * 
	 * System.out.println("htid:"+request.getParameter("htid")); String[]
	 * tokensNameSet=request.getParameterValues("ids"); for (String string :
	 * tokensNameSet) { System.out.println("tokensName:"+string); }
	 * 
	 * 
	 * HopperType ht =
	 * hopperTypeServices.getHopperTypeById(Long.parseLong(request
	 * .getParameter("htid"))); Country country =
	 * countryServices.getCountryById(
	 * Long.parseLong(request.getParameter("countryID")));
	 * 
	 * for (int i = 0; i < tokensNameSet.length; i++) { CountryTokensValue ctv =
	 * new CountryTokensValue(); TokensName tn =
	 * tokensNameServices.getTokensNameById(Long.parseLong(tokensNameSet[i]));
	 * TokensNameValue tnv =
	 * tokensNameValueServices.getTokensNameValueByCountryAndTokensName
	 * (country.getId(), tn.getId()); ctv.setHopperType(ht);
	 * ctv.setTokensNameValue(tnv);
	 * countryTokensValueServices.addOrUpdateCountryTokensValue(ctv); }
	 * 
	 * Set<Country> countrySet = countryServices.getCountryList();
	 * Set<TokensNameValue> tokensNameValue = new HashSet<TokensNameValue>();
	 * Country firstCountry = null; for (Country country2 : countrySet) {
	 * //if(!country2.isDone()){
	 * 
	 * tokensNameValue =
	 * tokensNameValueServices.getTokensNameValueByCountry(country2.getId());
	 * //country2.setDone(true); countryServices.addOrUpdateCountry(country2);
	 * if(tokensNameValue != null){
	 * 
	 * firstCountry = country2; break; } //} } List<TokensName> tokensNameList =
	 * new ArrayList<TokensName>(); List<TokensNameValue> tokensNameValueList =
	 * new ArrayList<TokensNameValue>(tokensNameValue); for (int i = 0; i <
	 * tokensNameValue.size(); i++) {
	 * tokensNameList.add(tokensNameValueList.get(i).getTokensName()); }
	 * if(firstCountry != null){ Map< String, String > tokens = new
	 * HashMap<String, String>(); for (TokensName tokensName : tokensNameList) {
	 * tokens.put(String.valueOf(tokensName.getId()) ,
	 * String.valueOf(tokensName.getName())); } model.addAttribute("country",
	 * firstCountry); model.addAttribute("tokensNameList", tokens);
	 * model.addAttribute("hopperType", ht);
	 * 
	 * model.addAttribute(new TokensNameForm());
	 * 
	 * return "addCountryTokensValue"; }else{ for (Country country2 :
	 * countrySet) { //country2.setDone(false);
	 * countryServices.addOrUpdateCountry(country2); }
	 * model.addAttribute("hopperTypeId", ht.getId()); return
	 * "addHopperCapacity"; }
	 * 
	 * 
	 * }
	 */

	/*
	 * @RequestMapping(value="/billValidatorTypeConfig",
	 * method=RequestMethod.POST) public String
	 * billValidatorTypeConfig(HttpServletRequest request,HttpServletResponse
	 * response,ModelMap model){
	 * 
	 * Set<Country> countryList=countryServices.getCountryList(); for (Country
	 * country2 : countryList) { //country2.setDone(false);
	 * countryServices.addOrUpdateCountry(country2); }
	 * 
	 * Country firstCountry = null; Set<BillsNameValue> billsNameValueSet = new
	 * HashSet<BillsNameValue>();
	 * 
	 * for (Country country : countryList) {
	 * 
	 * billsNameValueSet =
	 * billsNameValueServices.getBillsNameValueByCountry(country.getId());
	 * //country.setDone(true); countryServices.addOrUpdateCountry(country);
	 * if(billsNameValueSet != null){ firstCountry = country; break; } }
	 * 
	 * List<BillsName> billsNameList = new ArrayList<BillsName>();
	 * List<BillsNameValue> billsNameValueList = new
	 * ArrayList<BillsNameValue>(billsNameValueSet); for (int i = 0; i <
	 * billsNameValueList.size(); i++) {
	 * billsNameList.add(billsNameValueList.get(i).getBillsName()); }
	 * 
	 * Map< String, String > bills = new HashMap<String, String>(); for
	 * (BillsName billsName : billsNameList) {
	 * bills.put(String.valueOf(billsName.getId()) ,
	 * String.valueOf(billsName.getName())); }
	 * 
	 * 
	 * 
	 * MachineType mt =
	 * machineTypeServices.getMachineTypeById(Long.parseLong(request
	 * .getParameter("mvid")));
	 * 
	 * BillValidatorType bvt = new BillValidatorType(); bvt.setMachineType(mt);
	 * 
	 * if(request.getParameter("mvid").equals("input")){ bvt.setOnlyInput(true);
	 * }else{ bvt.setOnlyInput(false); }
	 * billValidatorTypeServices.addOrUpdateBillValidatorType(bvt);
	 * 
	 * BillValidatorType bvtLast =
	 * billValidatorTypeServices.getLastBillValidatorType();
	 * 
	 * model.addAttribute("country", firstCountry);
	 * model.addAttribute("billsNameList", bills);
	 * model.addAttribute("billValidatorType", bvtLast);
	 * 
	 * model.addAttribute(new BillsNameForm());
	 * 
	 * return "addCountryBillsValue"; }
	 */

	/*
	 * @RequestMapping(value="/addCountryBillsValue", method=RequestMethod.POST)
	 * public String addCountryBillsValue(@ModelAttribute("billsNameForm")
	 * BillsNameForm billsNameForm,HttpServletRequest
	 * request,HttpServletResponse response,ModelMap model){
	 * 
	 * System.out.println("bvtid:"+request.getParameter("bvtid")); String[]
	 * billsNameSet=request.getParameterValues("ids"); for (String string :
	 * billsNameSet) { System.out.println("billsName:"+string); }
	 * 
	 * 
	 * 
	 * BillValidatorType bvt =
	 * billValidatorTypeServices.getBillValidatorTypeById
	 * (Long.parseLong(request.getParameter("bvtid"))); Country country =
	 * countryServices
	 * .getCountryById(Long.parseLong(request.getParameter("countryID")));
	 * 
	 * for (int i = 0; i < billsNameSet.length; i++) { CountryBillsValue cbv =
	 * new CountryBillsValue(); BillsName bn =
	 * billsNameServices.getBillsNameById(Long.parseLong(billsNameSet[i]));
	 * BillsNameValue bnv =
	 * billsNameValueServices.getBillsNameValueByCountryAndBillsName
	 * (country.getId(), bn.getId());
	 * 
	 * cbv.setBillValidatorType(bvt); cbv.setBillsNameValue(bnv);
	 * countryBillsValueServices.addOrUpdateCountryBillsValue(cbv);
	 * 
	 * }
	 * 
	 * Set<Country> countrySet = countryServices.getCountryList();
	 * Set<BillsNameValue> billsNameValue = new HashSet<BillsNameValue>();
	 * Country firstCountry = null; for (Country country2 : countrySet) {
	 * //if(!country2.isDone()){
	 * 
	 * billsNameValue =
	 * billsNameValueServices.getBillsNameValueByCountry(country2.getId());
	 * //country2.setDone(true); countryServices.addOrUpdateCountry(country2);
	 * if(billsNameValue != null){
	 * 
	 * firstCountry = country2; break; } //} } List<BillsName> billsNameList =
	 * new ArrayList<BillsName>(); List<BillsNameValue> billsNameValueList = new
	 * ArrayList<BillsNameValue>(billsNameValue); for (int i = 0; i <
	 * billsNameValueList.size(); i++) {
	 * billsNameList.add(billsNameValueList.get(i).getBillsName()); }
	 * if(firstCountry != null){ Map< String, String > bills = new
	 * HashMap<String, String>(); for (BillsName billsName : billsNameList) {
	 * bills.put(String.valueOf(billsName.getId()) ,
	 * String.valueOf(billsName.getName())); } model.addAttribute("country",
	 * firstCountry); model.addAttribute("billsNameList", bills);
	 * model.addAttribute("billValidatorType", bvt);
	 * 
	 * model.addAttribute(new BillsNameForm());
	 * 
	 * return "addCountryBillsValue"; }else{
	 * model.addAttribute("billValidatorTypeId", bvt.getId()); return
	 * "addBillValidatorCapacity"; } }
	 * 
	 * @RequestMapping(value="/coinsValueInfo", method=RequestMethod.POST)
	 * public String coinsValueInfo(HttpServletRequest
	 * request,HttpServletResponse response,ModelMap model){ String action =
	 * null; if(request.getParameter("action")!=null){
	 * action=request.getParameter("action"); } long ctid = 0;
	 * if(action.equals("addCoinValue")){ String[]
	 * coinValueType=request.getParameterValues("coinValueType"); String ctidStr
	 * = request.getParameter("ctid");
	 * 
	 * ctid = Long.parseLong(ctidStr); CoinsType ct =
	 * coinsTypeServices.getCoinsTypeById(ctid);
	 * System.out.println("ctid:"+ct.getId()); long cvValue = 0 ; for (int i =
	 * 0; i < coinValueType.length; i++) { System.out.println(coinValueType[i]);
	 * CoinsValue cv = new CoinsValue(); cvValue =
	 * Long.parseLong(coinValueType[i]); cv.setValue(cvValue);
	 * cv.setCoinsType(ct); coinsValueServices.addOrUpdateCoinsValue(cv); }
	 * 
	 * 
	 * }
	 * 
	 * Set<Country> countryList = countryServices.getCountryList();
	 * Set<CoinsValue> cvSet =
	 * coinsValueServices.getCoinsValueListByCoinsType(ctid); List<CoinsValue>
	 * cvList = new ArrayList<CoinsValue>(cvSet);
	 * 
	 * model.addAttribute("ctid", ctid); model.addAttribute("coinValue",
	 * cvList.get(0)); model.addAttribute("countryList", countryList); return
	 * "countryCoinValueInfo"; }
	 * 
	 * 
	 * @RequestMapping(value="/countryCoinValueConfig",
	 * method=RequestMethod.POST) public String
	 * countryCoinValueConfig(HttpServletRequest request,HttpServletResponse
	 * response,ModelMap model){
	 * 
	 * String cvidStr = request.getParameter("coinValueID"); long cvid =
	 * Long.parseLong(cvidStr); System.out.println("cvid:"+cvid); CoinsValue
	 * coinsValue = coinsValueServices.getCoinsValueById(cvid); String ctidStr =
	 * request.getParameter("coinTypeID"); long ctid = Long.parseLong(ctidStr);
	 * System.out.println("ctid:"+ctid);
	 * 
	 * String[] countryCoinValuesID =
	 * request.getParameterValues("countryValuesID"); long[] countryIds = new
	 * long[countryCoinValuesID.length]; int i = 0; for (String string :
	 * countryCoinValuesID) { System.out.println("countryCoinValuesID:"+string);
	 * countryIds[i] = Long.parseLong(string); i++; }
	 * 
	 * String[] countryCoinValues = request.getParameterValues("countryValues");
	 * double[] countryValuesForCoin = new double[countryCoinValues.length]; int
	 * j = 0; for (String string : countryCoinValues) {
	 * System.out.println("countryCoinValues:"+string); countryValuesForCoin[j]
	 * = Long.parseLong(string); j++; }
	 * 
	 * for (int j2 = 0; j2 < countryValuesForCoin.length; j2++) {
	 * CountryCoinsValue ccv = new CountryCoinsValue();
	 * //ccv.setCoinsValue(coinsValue); Country country =
	 * countryServices.getCountryById(countryIds[j2]);
	 * //ccv.setCountry(country); //ccv.setValue(countryValuesForCoin[j2]);
	 * countryCoinsValueServices.addOrUpdateCountryCoinsValue(ccv); }
	 * coinsValue.setDone(true);
	 * coinsValueServices.addOrUpdateCoinsValue(coinsValue); Set<CoinsValue>
	 * cvSet = coinsValueServices.getCoinsValueListByCoinsType(ctid); CoinsValue
	 * cv = null; for (CoinsValue coinsValue2 : cvSet) { if(coinsValue2.isDone()
	 * == false){ cv = coinsValue2; } } if(cv != null){ Set<Country> countryList
	 * = countryServices.getCountryList();
	 * 
	 * model.addAttribute("ctid", ctid); model.addAttribute("coinValue", cv);
	 * model.addAttribute("countryList", countryList); return
	 * "countryCoinValueInfo"; }else{ //check if there any token for the same
	 * hopper Id System.out.println("coin Type ID:"+ctid); CoinsType ct =
	 * coinsTypeServices.getCoinsTypeById(ctid);
	 * System.out.println("coin Type:"+ct.getId());
	 * 
	 * if(ct.getHopperType() != null){
	 * System.out.println("hopper typr in coin type:"+
	 * ct.getHopperType().getId()); TokensType tt =
	 * tokensTypeServices.getTokensTypeByHopperType(ct.getHopperType().getId());
	 * 
	 * if(tt != null){ System.out.println("token Type ID:"+tt.getId());
	 * model.addAttribute("ttid",tt.getId()); return "tokensValueInfo"; } else{
	 * 
	 * model.addAttribute("hopperTypeId",ct.getHopperType().getId()); return
	 * "addHopperCapacity"; } }else{ model.addAttribute("coinValidatorTypeId",
	 * ct.getCoinValidatorType().getId()); return "addCoinValidatorCapacity"; }
	 * return null; } }
	 * 
	 * @RequestMapping(value="/tokensValueInfo", method=RequestMethod.POST)
	 * public String tokensValueInfo(HttpServletRequest
	 * request,HttpServletResponse response,ModelMap model){ String action =
	 * null; if(request.getParameter("action")!=null){
	 * action=request.getParameter("action"); } long ttid = 0;
	 * if(action.equals("addTokenValue")){ String[]
	 * tokenValueType=request.getParameterValues("tokenValueType"); String
	 * ttidStr = request.getParameter("ttid");
	 * 
	 * ttid = Long.parseLong(ttidStr);
	 * 
	 * TokensType tt = tokensTypeServices.getTokensTypeById(ttid);
	 * System.out.println("ttid:"+tt.getId()); long tvValue = 0 ; for (int i =
	 * 0; i < tokenValueType.length; i++) {
	 * System.out.println(tokenValueType[i]); TokensValue tv = new
	 * TokensValue(); tvValue = Long.parseLong(tokenValueType[i]);
	 * tv.setValue(tvValue); tv.setTokensType(tt);
	 * tokensValueServices.addOrUpdateTokensValue(tv); }
	 * 
	 * 
	 * }
	 * 
	 * Set<Country> countryList = countryServices.getCountryList();
	 * 
	 * Set<TokensValue> tvSet =
	 * tokensValueServices.getTokensValueListByTokensType(ttid);
	 * List<TokensValue> tvList = new ArrayList<TokensValue>(tvSet);
	 * 
	 * model.addAttribute("ttid", ttid); model.addAttribute("tokenValue",
	 * tvList.get(0)); model.addAttribute("countryList", countryList); return
	 * "countryTokenValueInfo"; }
	 * 
	 * 
	 * @RequestMapping(value="/countryTokenValueConfig",
	 * method=RequestMethod.POST) public String
	 * countryTokenValueConfig(HttpServletRequest request,HttpServletResponse
	 * response,ModelMap model){
	 * 
	 * 
	 * String tvidStr = request.getParameter("tokenValueID"); long tvid =
	 * Long.parseLong(tvidStr); System.out.println("tvid:"+tvid); TokensValue
	 * tokensValue = tokensValueServices.getTokensValueById(tvid); String
	 * ttidStr = request.getParameter("tokenTypeID"); long ttid =
	 * Long.parseLong(ttidStr); System.out.println("ttid:"+ttid);
	 * 
	 * String[] countryCoinValuesID =
	 * request.getParameterValues("countryValuesID"); long[] countryIds = new
	 * long[countryCoinValuesID.length]; int i = 0; for (String string :
	 * countryCoinValuesID) { System.out.println("countryCoinValuesID:"+string);
	 * countryIds[i] = Long.parseLong(string); i++; }
	 * 
	 * String[] countryCoinValues = request.getParameterValues("countryValues");
	 * double[] countryValuesForCoin = new double[countryCoinValues.length]; int
	 * j = 0; for (String string : countryCoinValues) {
	 * System.out.println("countryCoinValues:"+string); countryValuesForCoin[j]
	 * = Long.parseLong(string); j++; }
	 * 
	 * for (int j2 = 0; j2 < countryValuesForCoin.length; j2++) {
	 * 
	 * CountryTokensValue ctv = new CountryTokensValue(); //
	 * ctv.setTokensValue(tokensValue); Country country =
	 * countryServices.getCountryById(countryIds[j2]);
	 * //ctv.setCountry(country); //ctv.setValue(countryValuesForCoin[j2]);
	 * countryTokensValueServices.addOrUpdateCountryTokensValue(ctv); }
	 * tokensValue.setDone(true);
	 * tokensValueServices.addOrUpdateTokensValue(tokensValue);
	 * 
	 * Set<TokensValue> tvSet =
	 * tokensValueServices.getTokensValueListByTokensType(ttid);
	 * 
	 * 
	 * TokensValue tv = null; for (TokensValue tokensValue2 : tvSet) {
	 * if(tokensValue2.isDone() == false){ tv = tokensValue2; } } if(tv !=
	 * null){ Set<Country> countryList = countryServices.getCountryList();
	 * 
	 * model.addAttribute("ttid", ttid); model.addAttribute("tokenValue", tv);
	 * model.addAttribute("countryList", countryList); return
	 * "countryTokenValueInfo"; }else{ TokensType tt =
	 * tokensTypeServices.getTokensTypeById(ttid);
	 * //model.addAttribute("hopperTypeId", tt.getHopperType().getId()); return
	 * "addHopperCapacity"; } }
	 */

	/*
	 * @RequestMapping(value="/hopperCapacity", method=RequestMethod.POST)
	 * public String hopperCapacity(HttpServletRequest
	 * request,HttpServletResponse response,ModelMap model){ String csv = null;
	 * String bv = null; String hopper = null; String hopperTypeIdStr =
	 * request.getParameter("hopperTypeId"); long hopperTypeId =
	 * Long.parseLong(hopperTypeIdStr);
	 * System.out.println("hopperTypeId:"+hopperTypeId);
	 * 
	 * String hopperTypeCapacityStr =
	 * request.getParameter("hopperTypeCapacity"); long hopperTypeCapacity =
	 * Long.parseLong(hopperTypeCapacityStr);
	 * System.out.println("hopperTypeCapacity:"+hopperTypeCapacity);
	 * 
	 * HopperType ht = hopperTypeServices.getHopperTypeById(hopperTypeId);
	 * ht.setCapacity(hopperTypeCapacity);;
	 * hopperTypeServices.addOrUpdateHopperType(ht); long mvId =
	 * ht.getMachineType().getId(); Set<HopperType> htSet =
	 * hopperTypeServices.getHopperTypeByMachineId(mvId); List<HopperType>
	 * htList = new ArrayList<HopperType>(htSet); HopperType htNew = null; for
	 * (HopperType hopperType : htList) { if(hopperType.getCapacity() == 0){
	 * htNew = hopperType; } } if(htNew != null){
	 * model.addAttribute("mvid",mvId); return "hopperTypeInfo"; }else{ for (int
	 * i = 0; i < ht.getMachineType().getPaymentDevices().length; i++) {
	 * if(ht.getMachineType().getPaymentDevices()[i].equals("CoinSelector")){
	 * csv = "coinSelector"; }
	 * if(ht.getMachineType().getPaymentDevices()[i].equals("BillValidator")){
	 * bv = "billValidator"; } }
	 * 
	 * 
	 * if(csv != null){ Set<Country>
	 * countryList=countryServices.getCountryList();
	 * 
	 * Country firstCountry = null; Set<CoinsName> coinsNameSet = new
	 * HashSet<CoinsName>();
	 * 
	 * for (Country country : countryList) {
	 * 
	 * coinsNameSet = coinsNameServices.getCoinsNameByCountry(country.getId());
	 * //country.setDone(true); countryServices.addOrUpdateCountry(country);
	 * if(coinsNameSet != null){ firstCountry = country; break; } } MachineType
	 * mt = ht.getMachineType(); CoinValidatorType cvt = new
	 * CoinValidatorType(); cvt.setMachineType(mt);
	 * coinValidatorTypeServices.addOrUpdateCoinValidatorType(cvt);
	 * 
	 * 
	 * List<CoinsName> coinsNameList = new ArrayList<CoinsName>(coinsNameSet);
	 * Map< String, String > coins = new HashMap<String, String>(); for
	 * (CoinsName coinssName : coinsNameList) {
	 * coins.put(String.valueOf(coinssName.getId()) ,
	 * String.valueOf(coinssName.getValue())); }
	 * 
	 * CoinValidatorType cvtLast =
	 * coinValidatorTypeServices.getLastCoinValidatorType();
	 * 
	 * model.addAttribute("country", firstCountry);
	 * model.addAttribute("coinsNameSet", coins);
	 * model.addAttribute("coinValidatorType", cvtLast); model.addAttribute(new
	 * CoinsNameForm()); model.addAttribute("isCoinValidator", "yes");
	 * 
	 * return "addCountryCoinsValue";
	 * 
	 * }else if(bv!=null){ return null; }else{ return null; } }
	 * 
	 * }
	 */

	/*
	 * @RequestMapping(value="/coinValidatorInfo", method=RequestMethod.POST)
	 * public String coinValidatorInfo(HttpServletRequest
	 * request,HttpServletResponse response,ModelMap model){
	 * 
	 * }
	 */

	/*
	 * @RequestMapping(value="/coinValidatorTypeCapacity",
	 * method=RequestMethod.POST) public String
	 * coinValidatorTypeCapacity(HttpServletRequest request,HttpServletResponse
	 * response,ModelMap model){ String csv = null; String bv = null; String
	 * hopper = null; String coinValidatorTypeIdStr =
	 * request.getParameter("coinValidatorTypeId"); long coinValidatorTypeId =
	 * Long.parseLong(coinValidatorTypeIdStr);
	 * System.out.println("coinValidatorTypeId:"+coinValidatorTypeId);
	 * 
	 * String coinValidatorTypeCapacityStr =
	 * request.getParameter("coinValidatorTypeCapacity"); long
	 * coinValidatorTypeCapacity = Long.parseLong(coinValidatorTypeCapacityStr);
	 * System
	 * .out.println("coinValidatorTypeCapacity:"+coinValidatorTypeCapacity);
	 * 
	 * 
	 * CoinValidatorType cvt =
	 * coinValidatorTypeServices.getCoinValidatorTypeById(coinValidatorTypeId);
	 * cvt.setCapacity(coinValidatorTypeCapacity);
	 * 
	 * coinValidatorTypeServices.addOrUpdateCoinValidatorType(cvt); long mvId =
	 * cvt.getMachineType().getId();
	 * 
	 * Set<CoinValidatorType> cvtSet =
	 * coinValidatorTypeServices.getCoinValidatorTypeByMachineType(mvId);
	 * 
	 * List<CoinValidatorType> cvtList = new
	 * ArrayList<CoinValidatorType>(cvtSet); CoinValidatorType cvtNew = null;
	 * for (CoinValidatorType coinValidatorType : cvtList) {
	 * if(coinValidatorType.getCapacity() == 0){ cvtNew = coinValidatorType; } }
	 * if(cvtNew != null){ model.addAttribute("mvid",mvId); CoinsType ct = new
	 * CoinsType(); ct =
	 * coinsTypeServices.getCoinsTypeByCoinValidatorType(cvtNew.getId());
	 * model.addAttribute("ctid",ct.getId()); return "coinsValueInfo"; }else{
	 * for (int i = 0; i < cvt.getMachineType().getPaymentDevices().length; i++)
	 * {
	 * 
	 * if(cvt.getMachineType().getPaymentDevices()[i].equals("BillValidator")){
	 * bv = "billValidator"; } } model.addAttribute("mvid",mvId);
	 * model.addAttribute("hopper", hopper); model.addAttribute("csv", csv);
	 * model.addAttribute("bv", bv); return "paymentDevice";
	 * 
	 * model.addAttribute("mvid", mvId); return "billValidatorTypeInfo"; } }
	 */

	/*
	 * @RequestMapping(value="/billsValueInfo", method=RequestMethod.POST)
	 * public String billsValueInfo(HttpServletRequest
	 * request,HttpServletResponse response,ModelMap model){ String action =
	 * null; if(request.getParameter("action")!=null){
	 * action=request.getParameter("action"); } long btid = 0;
	 * if(action.equals("addBillValue")){ String[]
	 * billValueType=request.getParameterValues("billValueType"); String btidStr
	 * = request.getParameter("btid");
	 * 
	 * btid = Long.parseLong(btidStr);
	 * 
	 * BillsType bt = billsTypeServices.getBillsTypeById(btid);
	 * System.out.println("btid:"+bt.getId()); long bvValue = 0 ; for (int i =
	 * 0; i < billValueType.length; i++) { System.out.println(billValueType[i]);
	 * BillsValue bv = new BillsValue(); bvValue =
	 * Long.parseLong(billValueType[i]); bv.setValue(bvValue);
	 * bv.setBillsType(bt); billsValueServices.addOrUpdateBillsValue(bv); }
	 * 
	 * 
	 * }
	 * 
	 * Set<Country> countryList = countryServices.getCountryList();
	 * Set<BillsValue> bvSet =
	 * billsValueServices.getBillsValueListByBillsType(btid); List<BillsValue>
	 * bvList = new ArrayList<BillsValue>(bvSet);
	 * 
	 * model.addAttribute("btid", btid); model.addAttribute("billValue",
	 * bvList.get(0)); model.addAttribute("countryList", countryList); return
	 * "countryBillValueInfo"; }
	 */

	/*
	 * @RequestMapping(value="/countryBillValueConfig",
	 * method=RequestMethod.POST) public String
	 * countryBillValueConfig(HttpServletRequest request,HttpServletResponse
	 * response,ModelMap model){
	 * 
	 * String bvidStr = request.getParameter("billValueID"); long bvid =
	 * Long.parseLong(bvidStr); System.out.println("bvid:"+bvid); BillsValue
	 * billsValue = billsValueServices.getBillsValueById(bvid); String btidStr =
	 * request.getParameter("billTypeID"); long btid = Long.parseLong(btidStr);
	 * System.out.println("btid:"+btid);
	 * 
	 * String[] countryCoinValuesID =
	 * request.getParameterValues("countryValuesID"); long[] countryIds = new
	 * long[countryCoinValuesID.length]; int i = 0; for (String string :
	 * countryCoinValuesID) { System.out.println("countryCoinValuesID:"+string);
	 * countryIds[i] = Long.parseLong(string); i++; }
	 * 
	 * String[] countryCoinValues = request.getParameterValues("countryValues");
	 * double[] countryValuesForCoin = new double[countryCoinValues.length]; int
	 * j = 0; for (String string : countryCoinValues) {
	 * System.out.println("countryCoinValues:"+string); countryValuesForCoin[j]
	 * = Long.parseLong(string); j++; }
	 * 
	 * for (int j2 = 0; j2 < countryValuesForCoin.length; j2++) {
	 * 
	 * CountryBillsValue cbv = new CountryBillsValue();
	 * 
	 * // cbv.setBillsValue(billsValue); Country country =
	 * countryServices.getCountryById(countryIds[j2]);
	 * //cbv.setCountry(country); //cbv.setValue(countryValuesForCoin[j2]);
	 * 
	 * countryBillsValueServices.addOrUpdateCountryBillsValue(cbv); }
	 * billsValue.setDone(true);
	 * billsValueServices.addOrUpdateBillsValue(billsValue); Set<BillsValue>
	 * bvSet = billsValueServices.getBillsValueListByBillsType(btid); BillsValue
	 * bv = null; for (BillsValue billsValue2 : bvSet) { if(billsValue2.isDone()
	 * == false){ bv = billsValue2; } } if(bv != null){ Set<Country> countryList
	 * = countryServices.getCountryList();
	 * 
	 * model.addAttribute("btid", btid); model.addAttribute("billValue", bv);
	 * model.addAttribute("countryList", countryList); return
	 * "countryBillValueInfo"; }else{
	 * 
	 * BillsType bt = billsTypeServices.getBillsTypeById(btid);
	 * //model.addAttribute("billValidatorTypeId",
	 * bt.getBillValidatorType().getId()); return "addBillValidatorCapacity"; }
	 * }
	 */

	/*
	 * @RequestMapping(value="/billValidatorTypeCapacity",
	 * method=RequestMethod.POST) public String
	 * billValidatorTypeCapacity(HttpServletRequest request,HttpServletResponse
	 * response,ModelMap model){ String csv = null; String bv = null; String
	 * hopper = null; String billValidatorTypeIdStr =
	 * request.getParameter("billValidatorTypeId"); long billValidatorTypeId =
	 * Long.parseLong(billValidatorTypeIdStr);
	 * System.out.println("billValidatorTypeId:"+billValidatorTypeId);
	 * 
	 * String billValidatorTypeCapacityStr =
	 * request.getParameter("billValidatorTypeCapacity"); long
	 * billValidatorTypeCapacity = Long.parseLong(billValidatorTypeCapacityStr);
	 * System
	 * .out.println("billValidatorTypeCapacity:"+billValidatorTypeCapacity);
	 * 
	 * 
	 * 
	 * BillValidatorType bvt =
	 * billValidatorTypeServices.getBillValidatorTypeById(billValidatorTypeId);
	 * bvt.setCapacity(billValidatorTypeCapacity);
	 * 
	 * 
	 * billValidatorTypeServices.addOrUpdateBillValidatorType(bvt); Set<Country>
	 * countrySet = countryServices.getCountryList(); for (Country country :
	 * countrySet) { //country.setDone(false);
	 * countryServices.addOrUpdateCountry(country); }
	 * 
	 * long mvId = bvt.getMachineType().getId();
	 * 
	 * 
	 * Set<BillValidatorType> bvtSet =
	 * billValidatorTypeServices.getBillValidatorTypeByMachineType(mvId);
	 * List<BillValidatorType> bvtList = new
	 * ArrayList<BillValidatorType>(bvtSet); BillValidatorType bvtNew = null;
	 * for (BillValidatorType billValidatorType : bvtList) {
	 * if(billValidatorType.getCapacity() == 0){ bvtNew = billValidatorType; } }
	 * if(bvtNew != null){ model.addAttribute("mvid",mvId); BillsType bt = new
	 * BillsType(); bt =
	 * billsTypeServices.getBillsTypeByBillValidatorType(bvtNew.getId());
	 * model.addAttribute("btid",bt.getId()); return "billsValueInfo"; }else{
	 * 
	 * model.addAttribute("machineTypeId", mvId); return "machineTypeControl"; }
	 * }
	 */

	@RequestMapping(value = "/machineTypeControl", method = RequestMethod.POST)
	public String machineTypeControl(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		String machineTypeIdStr = request.getParameter("machineTypeId");
		long machineTypeId = Long.parseLong(machineTypeIdStr);
		System.out.println("machineTypeId:" + machineTypeId);

		MachineType mt = machineTypeServices.getMachineTypeById(machineTypeId);
		String wirelessType = request.getParameter("machineTypeId");

		if (wirelessType.equals("true")) {
			mt.setWirelessControl(true);
		} else {
			mt.setWirelessControl(false);
		}
		machineTypeServices.addOrUpdateMachineType(mt);

		Set<MachineType> machineTypeList = machineTypeServices
				.getMachineTypeList();
		model.addAttribute("machineTypeActive", "machineTypeActive");
		model.addAttribute(new MachineTypeForm());
		model.addAttribute("machineTypeList", machineTypeList);
		return "machineTypeList";

	}

	/*
	 * @RequestMapping("/tokens") public String
	 * tokens(@ModelAttribute("tokensName") TokensName
	 * tokensName,HttpServletRequest request,HttpServletResponse
	 * response,ModelMap model){
	 * 
	 * String action="action";
	 * 
	 * if(request.getParameter("action")!=null){
	 * action=request.getParameter("action"); }
	 * 
	 * System.out.println("Action: "+action); if(action!=null){
	 * if(action.equals("add")){
	 * if(tokensNameServices.addOrUpdateTokensName(tokensName)){
	 * System.out.println("add tokens name"); } }else if(action.equals("edit")){
	 * TokensName tn= tokensNameServices.getTokensNameById(tokensName.getId());
	 * 
	 * tn.setName(tokensName.getName());
	 * 
	 * if(tokensNameServices.addOrUpdateTokensName(tn)){
	 * System.out.println("tokens edited"); } } }
	 * 
	 * Set<TokensName> tokensNameList= tokensNameServices.getTokensNameList();
	 * 
	 * model.addAttribute(new TokensName());
	 * model.addAttribute("tokensNameList", tokensNameList);
	 * 
	 * return "tokenList"; }
	 */

	/*
	 * @RequestMapping(value = "/deleteTokensList") public String
	 * deleteTokensList(@RequestParam("list") String str,HttpServletRequest
	 * request,HttpServletResponse response,ModelMap model){ str =
	 * str.substring(0, str.length()-1); System.out.println(str); String[] str1
	 * = str.split(",");
	 * 
	 * for (int i = 0; i < str1.length; i++) {
	 * 
	 * int id = Integer.parseInt(str1[i]);
	 * tokensNameServices.deleteTokensName(id);
	 * 
	 * }
	 * 
	 * Set<TokensName> tokensNameList= tokensNameServices.getTokensNameList();
	 * model.addAttribute(new TokensName());
	 * model.addAttribute("tokensNameList", tokensNameList); return "tokenList";
	 * }
	 */

	/*
	 * @RequestMapping("/bills") public String
	 * bills(@ModelAttribute("billsName") BillsName billsName,HttpServletRequest
	 * request,HttpServletResponse response,ModelMap model){
	 * 
	 * String action="action";
	 * 
	 * if(request.getParameter("action")!=null){
	 * action=request.getParameter("action"); }
	 * 
	 * System.out.println("Action: "+action); if(action!=null){
	 * if(action.equals("add")){
	 * if(billsNameServices.addOrUpdateBillsName(billsName)){
	 * System.out.println("add bills name"); } }else if(action.equals("edit")){
	 * BillsName bn = billsNameServices.getBillsNameById(billsName.getId());
	 * 
	 * bn.setName(billsName.getName());
	 * 
	 * if(billsNameServices.addOrUpdateBillsName(bn)){
	 * System.out.println("bills edited"); } } }
	 * 
	 * Set<BillsName> billsNameList= billsNameServices.getBillsNameList();
	 * 
	 * model.addAttribute(new BillsName()); model.addAttribute("billsNameList",
	 * billsNameList);
	 * 
	 * return "billList"; }
	 * 
	 * @RequestMapping(value = "/deleteBillsList") public String
	 * deleteBillsList(@RequestParam("list") String str,HttpServletRequest
	 * request,HttpServletResponse response,ModelMap model){ str =
	 * str.substring(0, str.length()-1); System.out.println(str); String[] str1
	 * = str.split(",");
	 * 
	 * for (int i = 0; i < str1.length; i++) {
	 * 
	 * int id = Integer.parseInt(str1[i]);
	 * billsNameServices.deleteBillsName(id);
	 * 
	 * }
	 * 
	 * Set<BillsName> billsNameList= billsNameServices.getBillsNameList();
	 * model.addAttribute(new BillsName()); model.addAttribute("billsNameList",
	 * billsNameList); return "billList"; }
	 */

	@RequestMapping(value = "/hopperType", method = RequestMethod.GET)
	public String hopperType(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		Set<HopperType> hopperTypeList = hopperTypeServices.getHopperTypeList();
		model.addAttribute("hopperTypeList", hopperTypeList);
		return "hopperTypeList";
	}

	@RequestMapping(value = "/addHopperType", method = RequestMethod.GET)
	public String addHopperType(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		String action = "action";

		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
		}

		if (action != null) {
			if (action.equals("addBasic")) {
				String hopperTypeName = request.getParameter("name");
				String paymentType = request.getParameter("paymentType");
				System.out.println("hopperTypeName:" + hopperTypeName
						+ "\tpaymentType:" + paymentType);
				HopperType hopperType = new HopperType(hopperTypeName,
						paymentType);
				hopperTypeServices.addOrUpdateHopperType(hopperType);
			}
		}

		return "addHopperType";
	}

	@RequestMapping(value = "/addHopperType", method = RequestMethod.POST)
	public String addHopperTypePost(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		String action = "action";
		String paymentType = "paymentType";
		long hopperTypeId = 0;

		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
		}

		if (action != null) {
			if (action.equals("addBasic")) {
				String hopperTypeName = request.getParameter("name");
				paymentType = request.getParameter("paymentType");
				System.out.println("hopperTypeName:" + hopperTypeName
						+ "\tpaymentType:" + paymentType);
				HopperType hopperType = new HopperType(hopperTypeName,
						paymentType);
				hopperTypeServices.addOrUpdateHopperType(hopperType);
				HopperType lastHopperType = hopperTypeServices
						.getLastHopperType();
				hopperTypeId = lastHopperType.getId();
			}
		}

		if (paymentType.equals("input") || paymentType.equals("inputoutput")) {
			Set<Coins> coins = coinsServices.getCoinsList();
			Set<Notes> notes = notesServices.getNotesList();
			Set<Tokens> tokens = tokensServices.getTokensList();
			Set<Bills> bills = billsServices.getBillsList();

			model.addAttribute("coins", coins);
			model.addAttribute("notes", notes);
			model.addAttribute("tokens", tokens);
			model.addAttribute("bills", bills);
			model.addAttribute("hopperTypeId", hopperTypeId);
			model.addAttribute(new InputMoneyHopperForm());
			return "addHopperTypeInput";
		} else {
			Set<Coins> coins = coinsServices.getCoinsList();
			Set<Notes> notes = notesServices.getNotesList();
			Set<Tokens> tokens = tokensServices.getTokensList();
			Set<Bills> bills = billsServices.getBillsList();

			model.addAttribute("coins", coins);
			model.addAttribute("notes", notes);
			model.addAttribute("tokens", tokens);
			model.addAttribute("bills", bills);
			model.addAttribute("hopperTypeId", hopperTypeId);
			model.addAttribute(new OutputMoneyHopperForm());
			return "addHopperTypeOutput";
		}

	}

	@RequestMapping(value = "/addHopperTypeInput", method = RequestMethod.POST)
	public String addHopperTypeInput(
			@ModelAttribute("inputMoneyHopperForm") InputMoneyHopperForm inputMoneyHopperForm,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		long[] coinsIds = inputMoneyHopperForm.getCoins();
		long[] notesIds = inputMoneyHopperForm.getNotes();
		long[] tokensIds = inputMoneyHopperForm.getTokens();
		long[] billsIds = inputMoneyHopperForm.getBills();
		System.out.println("hopperTypeId:"
				+ request.getParameter("hopperTypeId"));
		HopperType hopperType = hopperTypeServices.getHopperTypeById(Long
				.parseLong(request.getParameter("hopperTypeId")));

		if (coinsIds != null) {
			for (int i = 0; i < coinsIds.length; i++) {
				System.out.println("coins:" + coinsIds[i]);
				Coins coins = coinsServices.getCoinsById(coinsIds[i]);
				InputMoneyHopper imh = new InputMoneyHopper();
				imh.setCoins(coins);
				imh.setHopperType(hopperType);
				inputMoneyHopperServices.addOrUpdateInputMoneyHopper(imh);
			}
		}

		if (notesIds != null) {
			for (int i = 0; i < notesIds.length; i++) {
				System.out.println("notes:" + notesIds[i]);
				Notes notes = notesServices.getNotesById(notesIds[i]);
				InputMoneyHopper imh = new InputMoneyHopper();
				imh.setNotes(notes);
				imh.setHopperType(hopperType);
				inputMoneyHopperServices.addOrUpdateInputMoneyHopper(imh);
			}
		}

		if (tokensIds != null) {
			for (int i = 0; i < tokensIds.length; i++) {
				System.out.println("tokens:" + tokensIds[i]);
				Tokens tokens = tokensServices.getTokensById(tokensIds[i]);
				InputMoneyHopper imh = new InputMoneyHopper();
				imh.setTokens(tokens);
				imh.setHopperType(hopperType);
				inputMoneyHopperServices.addOrUpdateInputMoneyHopper(imh);
			}
		}

		if (billsIds != null) {
			for (int i = 0; i < billsIds.length; i++) {
				System.out.println("bills:" + billsIds[i]);
				Bills bills = billsServices.getBillsById(billsIds[i]);
				InputMoneyHopper imh = new InputMoneyHopper();
				imh.setBills(bills);
				imh.setHopperType(hopperType);
				inputMoneyHopperServices.addOrUpdateInputMoneyHopper(imh);
			}
		}
		System.out.println("coinsIds:" + coinsIds + "\nnotesIds:" + notesIds
				+ "\ntokensIds:" + tokensIds + "\nbillsIds:" + billsIds);

		if (hopperType.getPaymentType().equals("inputoutput")) {
			Set<Coins> coins = coinsServices.getCoinsList();
			Set<Notes> notes = notesServices.getNotesList();
			Set<Tokens> tokens = tokensServices.getTokensList();
			Set<Bills> bills = billsServices.getBillsList();

			model.addAttribute("coins", coins);
			model.addAttribute("notes", notes);
			model.addAttribute("tokens", tokens);
			model.addAttribute("bills", bills);
			model.addAttribute("hopperTypeId", hopperType.getId());
			model.addAttribute(new OutputMoneyHopperForm());
			return "addHopperTypeOutput";
		} else {
			model.addAttribute("hopperTypeId", hopperType.getId());
			return "addHopperCapacity";
		}
	}

	@RequestMapping(value = "/addHopperTypeOutput", method = RequestMethod.POST)
	public String addHopperTypeOutput(
			@ModelAttribute("outputMoneyHopperForm") OutputMoneyHopperForm outputMoneyHopperForm,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		long[] coinsIds = outputMoneyHopperForm.getCoins();
		long[] notesIds = outputMoneyHopperForm.getNotes();
		long[] tokensIds = outputMoneyHopperForm.getTokens();
		long[] billsIds = outputMoneyHopperForm.getBills();
		System.out.println("hopperTypeId:"
				+ request.getParameter("hopperTypeId"));
		HopperType hopperType = hopperTypeServices.getHopperTypeById(Long
				.parseLong(request.getParameter("hopperTypeId")));

		if (coinsIds != null) {
			for (int i = 0; i < coinsIds.length; i++) {
				System.out.println("coins:" + coinsIds[i]);
				Coins coins = coinsServices.getCoinsById(coinsIds[i]);
				OutputMoneyHopper imh = new OutputMoneyHopper();
				imh.setCoins(coins);
				imh.setHopperType(hopperType);
				outputMoneyHopperServices.addOrUpdateOutputMoneyHopper(imh);
			}
		}

		if (notesIds != null) {
			for (int i = 0; i < notesIds.length; i++) {
				System.out.println("notes:" + notesIds[i]);
				Notes notes = notesServices.getNotesById(notesIds[i]);
				OutputMoneyHopper imh = new OutputMoneyHopper();
				imh.setNotes(notes);
				imh.setHopperType(hopperType);
				outputMoneyHopperServices.addOrUpdateOutputMoneyHopper(imh);
			}
		}

		if (tokensIds != null) {
			for (int i = 0; i < tokensIds.length; i++) {
				System.out.println("tokens:" + tokensIds[i]);
				Tokens tokens = tokensServices.getTokensById(tokensIds[i]);
				OutputMoneyHopper imh = new OutputMoneyHopper();
				imh.setTokens(tokens);
				imh.setHopperType(hopperType);
				outputMoneyHopperServices.addOrUpdateOutputMoneyHopper(imh);
			}
		}

		if (billsIds != null) {
			for (int i = 0; i < billsIds.length; i++) {
				System.out.println("bills:" + billsIds[i]);
				Bills bills = billsServices.getBillsById(billsIds[i]);
				OutputMoneyHopper imh = new OutputMoneyHopper();
				imh.setBills(bills);
				imh.setHopperType(hopperType);
				outputMoneyHopperServices.addOrUpdateOutputMoneyHopper(imh);
			}
		}
		System.out.println("coinsIds:" + coinsIds + "\nnotesIds:" + notesIds
				+ "\ntokensIds:" + tokensIds + "\nbillsIds:" + billsIds);
		model.addAttribute("hopperTypeId", hopperType.getId());
		return "addHopperCapacity";
	}

	@RequestMapping(value = "/hopperCapacity", method = RequestMethod.POST)
	public String hopperCapacity(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		String hopperTypeIdStr = request.getParameter("hopperTypeId");
		long hopperTypeId = Long.parseLong(hopperTypeIdStr);
		System.out.println("hopperTypeId:" + hopperTypeId);

		String hopperTypeCapacityStr = request
				.getParameter("hopperTypeCapacity");
		long hopperTypeCapacity = Long.parseLong(hopperTypeCapacityStr);
		System.out.println("hopperTypeCapacity:" + hopperTypeCapacity);

		HopperType ht = hopperTypeServices.getHopperTypeById(hopperTypeId);
		ht.setCapacity(hopperTypeCapacity);
		;
		hopperTypeServices.addOrUpdateHopperType(ht);

		Set<HopperType> hopperTypeList = hopperTypeServices.getHopperTypeList();
		model.addAttribute("hopperTypeList", hopperTypeList);
		return "hopperTypeList";
	}

	@RequestMapping(value = "/paymentDevices", method = RequestMethod.GET)
	public String paymentDevices(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		Set<PaymentDeviceType> paymentDeviceTypeList = paymentDeviceTypeServices
				.getPaymentDeviceTypeList();
		Set<Coins> coins = coinsServices.getCoinsList();
		Set<Notes> notes = notesServices.getNotesList();
		Set<Tokens> tokens = tokensServices.getTokensList();
		Set<Bills> bills = billsServices.getBillsList();

		model.addAttribute("paymentDeviceTypeList", paymentDeviceTypeList);
		model.addAttribute(new PaymentDeviceTypeForm());
		model.addAttribute("coins", coins);
		model.addAttribute("notes", notes);
		model.addAttribute("tokens", tokens);
		model.addAttribute("bills", bills);
		return "paymentDeviceList";
	}

	@RequestMapping(value = "/editPaymentDevice", method = RequestMethod.POST)
	public String editPaymentDevice(
			@ModelAttribute("paymentDeviceTypeForm") PaymentDeviceTypeForm paymentDeviceTypeForm,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		PaymentDeviceType paymentDeviceType = paymentDeviceTypeServices
				.getPaymentDeviceTypeById(paymentDeviceTypeForm.getId());
		if (paymentDeviceTypeForm.getIo().equals("input")) {
			Set<OutputMoneyPaymentDevice> ompd = outputMoneyPaymentDeviceServices
					.getOutputMoneyPaymentDeviceListByPaymentDeviceType(paymentDeviceType
							.getId());
			for (OutputMoneyPaymentDevice outputMoneyPaymentDevice : ompd) {
				outputMoneyPaymentDeviceServices
						.deleteOutputMoneyPaymentDevice(outputMoneyPaymentDevice
								.getId());
			}
		} else if (paymentDeviceTypeForm.getIo().equals("output")) {
			Set<InputMoneyPaymentDevice> impd = inputMoneyPaymentDeviceServices
					.getInputMoneyPaymentDeviceListByPaymentDeviceType(paymentDeviceType
							.getId());
			for (InputMoneyPaymentDevice inputMoneyPaymentDevice : impd) {
				inputMoneyPaymentDeviceServices
						.deleteInputMoneyPaymentDevice(inputMoneyPaymentDevice
								.getId());
			}
		}
		paymentDeviceType.setType(paymentDeviceTypeForm.getType());
		paymentDeviceType.setModel(paymentDeviceTypeForm.getModel());
		paymentDeviceType.setIo(paymentDeviceTypeForm.getIo());
		paymentDeviceTypeServices
				.addOrUpdatePaymentDeviceType(paymentDeviceType);
		Set<PaymentDeviceType> paymentDeviceTypeList = paymentDeviceTypeServices
				.getPaymentDeviceTypeList();
		Set<Coins> coins = coinsServices.getCoinsList();
		Set<Notes> notes = notesServices.getNotesList();
		Set<Tokens> tokens = tokensServices.getTokensList();
		Set<Bills> bills = billsServices.getBillsList();

		model.addAttribute("paymentDeviceTypeList", paymentDeviceTypeList);
		model.addAttribute(new PaymentDeviceTypeForm());
		model.addAttribute("coins", coins);
		model.addAttribute("notes", notes);
		model.addAttribute("tokens", tokens);
		model.addAttribute("bills", bills);
		return "paymentDeviceList";
	}

	@RequestMapping(value = "/addPaymentDevice", method = RequestMethod.POST)
	public String addPaymentDevice(
			@ModelAttribute("paymentDeviceTypeForm") PaymentDeviceTypeForm paymentDeviceTypeForm,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		long[] coinsIds = paymentDeviceTypeForm.getInputCoins();
		long[] notesIds = paymentDeviceTypeForm.getInputNotes();
		long[] tokensIds = paymentDeviceTypeForm.getInputTokens();
		long[] billsIds = paymentDeviceTypeForm.getInputBills();

		long[] outputCoinsIds = paymentDeviceTypeForm.getOutputCoins();
		long[] outputNotesIds = paymentDeviceTypeForm.getOutputNotes();
		long[] outputTokensIds = paymentDeviceTypeForm.getOutputTokens();
		long[] outputBillsIds = paymentDeviceTypeForm.getOutputBills();

		PaymentDeviceType paymentDeviceType = new PaymentDeviceType();
		paymentDeviceType.setType(paymentDeviceTypeForm.getType());
		paymentDeviceType.setModel(paymentDeviceTypeForm.getModel());
		paymentDeviceType.setIo(paymentDeviceTypeForm.getIo());
		paymentDeviceTypeServices
				.addOrUpdatePaymentDeviceType(paymentDeviceType);
		PaymentDeviceType lastPaymentDeviceType = paymentDeviceTypeServices
				.getLastPaymentDeviceType();

		if (coinsIds != null) {
			for (int i = 0; i < coinsIds.length; i++) {
				System.out.println("coins:" + coinsIds[i]);
				Coins coins = coinsServices.getCoinsById(coinsIds[i]);
				InputMoneyPaymentDevice imh = new InputMoneyPaymentDevice();
				imh.setCoins(coins);
				imh.setPaymentDeviceType(lastPaymentDeviceType);
				inputMoneyPaymentDeviceServices
						.addOrUpdateInputMoneyPaymentDevice(imh);

			}
		}

		if (notesIds != null) {
			for (int i = 0; i < notesIds.length; i++) {
				System.out.println("notes:" + notesIds[i]);
				Notes notes = notesServices.getNotesById(notesIds[i]);
				InputMoneyPaymentDevice imh = new InputMoneyPaymentDevice();
				imh.setNotes(notes);
				imh.setPaymentDeviceType(lastPaymentDeviceType);
				inputMoneyPaymentDeviceServices
						.addOrUpdateInputMoneyPaymentDevice(imh);
			}
		}

		if (tokensIds != null) {
			for (int i = 0; i < tokensIds.length; i++) {
				System.out.println("tokens:" + tokensIds[i]);
				Tokens tokens = tokensServices.getTokensById(tokensIds[i]);
				InputMoneyPaymentDevice imh = new InputMoneyPaymentDevice();
				imh.setTokens(tokens);
				imh.setPaymentDeviceType(lastPaymentDeviceType);
				inputMoneyPaymentDeviceServices
						.addOrUpdateInputMoneyPaymentDevice(imh);
			}
		}

		if (billsIds != null) {
			for (int i = 0; i < billsIds.length; i++) {
				System.out.println("bills:" + billsIds[i]);
				Bills bills = billsServices.getBillsById(billsIds[i]);
				InputMoneyPaymentDevice imh = new InputMoneyPaymentDevice();
				imh.setBills(bills);
				imh.setPaymentDeviceType(lastPaymentDeviceType);
				inputMoneyPaymentDeviceServices
						.addOrUpdateInputMoneyPaymentDevice(imh);
			}
		}

		if (outputCoinsIds != null) {
			for (int i = 0; i < coinsIds.length; i++) {
				System.out.println("coins:" + coinsIds[i]);
				Coins coins = coinsServices.getCoinsById(coinsIds[i]);
				OutputMoneyPaymentDevice imh = new OutputMoneyPaymentDevice();
				imh.setCoins(coins);
				imh.setPaymentDeviceType(lastPaymentDeviceType);
				outputMoneyPaymentDeviceServices
						.addOrUpdateOutputMoneyPaymentDevice(imh);
			}
		}

		if (outputNotesIds != null) {
			for (int i = 0; i < notesIds.length; i++) {
				System.out.println("notes:" + notesIds[i]);
				Notes notes = notesServices.getNotesById(notesIds[i]);
				OutputMoneyPaymentDevice imh = new OutputMoneyPaymentDevice();
				imh.setNotes(notes);
				imh.setPaymentDeviceType(lastPaymentDeviceType);
				outputMoneyPaymentDeviceServices
						.addOrUpdateOutputMoneyPaymentDevice(imh);
			}
		}

		if (outputTokensIds != null) {
			for (int i = 0; i < tokensIds.length; i++) {
				System.out.println("tokens:" + tokensIds[i]);
				Tokens tokens = tokensServices.getTokensById(tokensIds[i]);
				OutputMoneyPaymentDevice imh = new OutputMoneyPaymentDevice();
				imh.setTokens(tokens);
				imh.setPaymentDeviceType(lastPaymentDeviceType);
				outputMoneyPaymentDeviceServices
						.addOrUpdateOutputMoneyPaymentDevice(imh);
			}
		}

		if (outputBillsIds != null) {
			for (int i = 0; i < billsIds.length; i++) {
				System.out.println("bills:" + billsIds[i]);
				Bills bills = billsServices.getBillsById(billsIds[i]);
				OutputMoneyPaymentDevice imh = new OutputMoneyPaymentDevice();
				imh.setBills(bills);
				imh.setPaymentDeviceType(lastPaymentDeviceType);
				outputMoneyPaymentDeviceServices
						.addOrUpdateOutputMoneyPaymentDevice(imh);
			}
		}

		Set<PaymentDeviceType> paymentDeviceTypeList = paymentDeviceTypeServices
				.getPaymentDeviceTypeList();
		model.addAttribute("paymentDeviceTypeList", paymentDeviceTypeList);
		model.addAttribute(new PaymentDeviceTypeForm());
		Set<Coins> coins = coinsServices.getCoinsList();
		Set<Notes> notes = notesServices.getNotesList();
		Set<Tokens> tokens = tokensServices.getTokensList();
		Set<Bills> bills = billsServices.getBillsList();

		model.addAttribute("coins", coins);
		model.addAttribute("notes", notes);
		model.addAttribute("tokens", tokens);
		model.addAttribute("bills", bills);
		return "paymentDeviceList";
	}

	@RequestMapping(value = "/deletePaymentDevices")
	public String deletePaymentDeviceList(@RequestParam("list") String str,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		str = str.substring(0, str.length() - 1);
		System.out.println(str);
		String[] str1 = str.split(",");

		for (int i = 0; i < str1.length; i++) {

			int id = Integer.parseInt(str1[i]);
			Set<InputMoneyPaymentDevice> impd = inputMoneyPaymentDeviceServices
					.getInputMoneyPaymentDeviceListByPaymentDeviceType(id);
			for (InputMoneyPaymentDevice inputMoneyPaymentDevice : impd) {
				inputMoneyPaymentDeviceServices
						.deleteInputMoneyPaymentDevice(inputMoneyPaymentDevice
								.getId());
			}
			Set<OutputMoneyPaymentDevice> ompd = outputMoneyPaymentDeviceServices
					.getOutputMoneyPaymentDeviceListByPaymentDeviceType(id);
			for (OutputMoneyPaymentDevice outputMoneyPaymentDevice : ompd) {
				outputMoneyPaymentDeviceServices
						.deleteOutputMoneyPaymentDevice(outputMoneyPaymentDevice
								.getId());
			}

			paymentDeviceTypeServices.deletePaymentDeviceType(id);

		}

		Set<PaymentDeviceType> paymentDeviceTypeList = paymentDeviceTypeServices
				.getPaymentDeviceTypeList();
		Set<Coins> coins = coinsServices.getCoinsList();
		Set<Notes> notes = notesServices.getNotesList();
		Set<Tokens> tokens = tokensServices.getTokensList();
		Set<Bills> bills = billsServices.getBillsList();

		model.addAttribute("paymentDeviceTypeList", paymentDeviceTypeList);
		model.addAttribute(new PaymentDeviceTypeForm());
		model.addAttribute("coins", coins);
		model.addAttribute("notes", notes);
		model.addAttribute("tokens", tokens);
		model.addAttribute("bills", bills);
		return "paymentDeviceList";
	}

	@RequestMapping(value = "/technician")
	public String allestablishmentList(
			@ModelAttribute("technician") Technician technician,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		Admin loggedAdmin = adminServices.getAdminByUsername(userName);

		String action = "action";
		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
		}

		System.out.println("Action: " + action);
		if (action != null) {
			if (action.equals("add")) {
				System.out.println("add technician");
				technician.setAdmin(loggedAdmin);
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
				model.addAttribute("added", "added");
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
				model.addAttribute("updated", "updated");
			}
		}
		Set<Technician> technicianList = technicianServices
				.getTechnicianListByAdmin(loggedAdmin.getId());
		model.addAttribute("technicianActive", "technicianActive");
		model.addAttribute(new Technician());
		model.addAttribute("technicianList", technicianList);

		return "technicianAdminList";
	}

	@RequestMapping("/assignMachinesTechnician")
	public String assignMachinesTechnician(
			@ModelAttribute("machine") Machine machine,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		System.out.println("logged userName:" + userName);
		Admin loggedAdmin = adminServices.getAdminByUsername(userName);

		Set<Machine> machineList = machineServices.getMachineList();
		Set<Technician> technicianList = technicianServices
				.getTechnicianListByAdmin(loggedAdmin.getId());

		model.addAttribute("machineList", machineList);
		model.addAttribute("technicianList", technicianList);

		return "assignMachineTechnicianAdmin";
	}

	@RequestMapping(value = "/assignMachinedTechnician", method = RequestMethod.POST)
	public String assignMachinedTechnician(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		Admin loggedAdmin = adminServices.getAdminByUsername(userName);

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
				.getTechnicianListByAdmin(loggedAdmin.getId());
		model.addAttribute("technicianActive", "technicianActive");
		model.addAttribute(new Technician());
		model.addAttribute("technicianList", technicianList);
		return "technicianAdminList";
	}

	@RequestMapping(value = "/reportProblem")
	public String reportProblem(@RequestParam("machineId") String machineIdStr,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		Admin loggedAdmin = adminServices.getAdminByUsername(userName);

		Machine machine = machineServices.getMachineById(Long
				.parseLong(machineIdStr));

		RepairHistory repairHistory = new RepairHistory();
		repairHistory.setReportedByAdmin(loggedAdmin);
		repairHistory.setMachine(machine);
		long currentTimestampLong = System.currentTimeMillis();
		repairHistory.setReportedTime(currentTimestampLong);
		String currentTimestampStr = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
				.format(currentTimestampLong);
		repairHistory.setStatus("pending");
		repairHistory.setReportedTimeStr(currentTimestampStr);
		repairHistoryServices.addOrUpdateRepairHistory(repairHistory);

		Set<MachineType> machineTypeList = machineTypeServices
				.getMachineTypeList();
		Set<Machine> machineList = machineServices.getMachineList();
		model.addAttribute("machineActive", "machineActive");
		model.addAttribute(new Machine());
		model.addAttribute("machineList", machineList);
		model.addAttribute("machineTypeList", machineTypeList);
		model.addAttribute("userId", loggedAdmin.getId());
		return "machineList";
	}

	@RequestMapping(value = "/viewMachineHistory")
	public String viewMachineHistory(@RequestParam("machineId") long machineId,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		Set<MachineHistory> machineHistoryList = machineHistoryServices
				.getMachineHistoryByMachineId(machineId);

		model.addAttribute("machineHistoryList", machineHistoryList);
		model.addAttribute("", machineId);
		return "viewMachineHistory";
	}

	@RequestMapping(value = "/viewHistory")
	public String viewHistory(
			@RequestParam("machineId") String machineIdStr,
			@ModelAttribute("machineProblemsDTO") MachineProblemsDTO machineProblemsDTO,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		Set<RepairHistory> repairHistoryList = new HashSet<RepairHistory>();
		repairHistoryList = repairHistoryServices
				.getRepairHistoryByMachineId(Long.parseLong(machineIdStr));

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		Admin loggedAdmin = adminServices.getAdminByUsername(userName);

		Set<MachineProblems> machineProblemsList = machineProblemsServices
				.getMachineProblemsList();

		model.addAttribute("repairHistoryList", repairHistoryList);
		model.addAttribute("machineId", machineIdStr);
		model.addAttribute("role", "admin");
		model.addAttribute("userId", loggedAdmin.getId());
		model.addAttribute("machineProblemsList", machineProblemsList);
		model.addAttribute(new MachineProblemsDTO());
		return "viewHistoryAdmin";
	}

	@RequestMapping(value = "/spareParts")
	public String sparePartsList(
			@ModelAttribute("spareParts") SpareParts spareParts,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String action = "action";
		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
		}

		if (action != null) {
			if (action.equals("add")) {

				if (sparePartsServices.addOrUpdateSpareParts(spareParts)) {
					System.out.println("spareParts added");
				}
			} else if (action.equals("edit")) {
				SpareParts oldSpareParts = sparePartsServices
						.getSparePartsById(spareParts.getId());
				oldSpareParts.setDescription(spareParts.getDescription());
				if (sparePartsServices.addOrUpdateSpareParts(spareParts)) {
					System.out.println("spareParts edited");
				}
			}
		}
		Set<SpareParts> sparePartsList = sparePartsServices.getSparePartsList();
		model.addAttribute("technicianActive", "technicianActive");
		model.addAttribute(new SpareParts());
		model.addAttribute("sparePartsList", sparePartsList);

		return "sparePartsList";
	}

	@RequestMapping(value = "/deleteSpareParts")
	public String deleteSpareParts(@RequestParam("list") String str,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		str = str.substring(0, str.length() - 1);
		boolean isError = true;
		String[] str1 = str.split(",");

		for (int i = 0; i < str1.length; i++) {

			int id = Integer.parseInt(str1[i]);

			isError = sparePartsServices.deleteSpareParts(id);

		}

		Set<SpareParts> sparePartsList = sparePartsServices.getSparePartsList();

		model.addAttribute(new SpareParts());
		model.addAttribute("sparePartsList", sparePartsList);
		if (!isError) {
			model.addAttribute("error", "1");
		}

		return "sparePartsList";
	}

	@RequestMapping(value = "/machineProblems")
	public String machineProblemsList(
			@ModelAttribute("machineProblemsDTO") MachineProblemsDTO machineProblemsDTO,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String machineIdStr = request.getParameter("machineID");
		Machine machine = machineServices.getMachineById(Long
				.parseLong(machineIdStr));

		String action = "action";
		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
		}

		String role = "role";
		if (request.getParameter("role") != null) {
			role = request.getParameter("role");
		}

		if (action != null) {
			if (action.equals("add")) {

				/*
				 * if (machineProblemsServices
				 * .addOrUpdateMachineProblems(machineProblems)) {
				 * System.out.println("machineProblems added"); }
				 */
				/*
				 * MachineProblems mp = machineProblemsServices
				 * .getLastMachineProblems();
				 */
				MachineProblems mp = null;
				if (machineProblemsDTO.getMachineProbleId().longValue() != 0) {
					mp = machineProblemsServices
							.getMachineProblemsById(machineProblemsDTO
									.getMachineProbleId());
				} else {
					mp = new MachineProblems();
					mp.setDescription(request.getParameter("description"));
					machineProblemsServices.addOrUpdateMachineProblems(mp);
				}
				RepairHistory repairHistory = new RepairHistory();
				if (role.equals("admin")) {
					Admin admin = adminServices.getAdminById(Long
							.parseLong(request.getParameter("userId")));
					repairHistory.setReportedByAdmin(admin);
				} else if (role.equals("operator")) {
					Operator operator = operatorServices.getOperatorById(Long
							.parseLong(request.getParameter("userId")));
					repairHistory.setReportedByOperator(operator);
				} else if (role.equals("establishment")) {
					Establishment establishment = establishmentServices
							.getEstablishmentById(Long.parseLong(request
									.getParameter("userId")));
					repairHistory.setReportedByEstablishment(establishment);
				}

				repairHistory.setMachine(machine);
				long currentTimestampLong = System.currentTimeMillis();
				repairHistory.setReportedTime(currentTimestampLong);
				String currentTimestampStr = new SimpleDateFormat(
						"MM/dd/yyyy HH:mm:ss").format(currentTimestampLong);
				repairHistory.setStatus("pending");
				repairHistory.setReportedTimeStr(currentTimestampStr);
				repairHistory.setMachineProblems(mp);

				repairHistoryServices.addOrUpdateRepairHistory(repairHistory);
			} else if (action.equals("edit")) {

				/*
				 * MachineProblems oldMachineProblems = machineProblemsServices
				 * .getMachineProblemsById(Long.parseLong(request
				 * .getParameter("Idd")));
				 * oldMachineProblems.setDescription(machineProblems
				 * .getDescription()); if (machineProblemsServices
				 * .addOrUpdateMachineProblems(machineProblems)) {
				 * System.out.println("machineProblems edited"); }
				 */
				MachineProblems mp = null;
				if (machineProblemsDTO.getMachineProbleId().longValue() != 0) {
					mp = machineProblemsServices
							.getMachineProblemsById(machineProblemsDTO
									.getMachineProbleId());
				} else {
					mp = new MachineProblems();
					mp.setDescription(request.getParameter("description"));
					machineProblemsServices.addOrUpdateMachineProblems(mp);
				}
				RepairHistory rh = repairHistoryServices
						.getRepairHistoryById(Long.parseLong(request
								.getParameter("Idd")));

				long currentTimestampLong = System.currentTimeMillis();
				rh.setReportedTime(currentTimestampLong);
				String currentTimestampStr = new SimpleDateFormat(
						"MM/dd/yyyy HH:mm:ss").format(currentTimestampLong);
				rh.setStatus("pending");
				rh.setReportedTimeStr(currentTimestampStr);
				rh.setMachineProblems(mp);

				if (role.equals("admin")) {
					Admin admin = adminServices.getAdminById(Long
							.parseLong(request.getParameter("userId")));
					rh.setReportedByAdmin(admin);
					rh.setReportedByEstablishment(null);
					rh.setReportedByOperator(null);
					rh.setReportedByTechnician(null);
				} else if (role.equals("operator")) {
					Operator operator = operatorServices.getOperatorById(Long
							.parseLong(request.getParameter("userId")));
					rh.setReportedByOperator(operator);
					rh.setReportedByAdmin(null);
					rh.setReportedByEstablishment(null);
					rh.setReportedByTechnician(null);
				} else if (role.equals("establishment")) {
					Establishment establishment = establishmentServices
							.getEstablishmentById(Long.parseLong(request
									.getParameter("userId")));
					rh.setReportedByEstablishment(establishment);
					rh.setReportedByOperator(null);
					rh.setReportedByAdmin(null);
					rh.setReportedByTechnician(null);
				}
				repairHistoryServices.addOrUpdateRepairHistory(rh);
			}
		}

		Set<MachineProblems> machineProblemsList = machineProblemsServices
				.getMachineProblemsList();

		model.addAttribute(new MachineProblemsDTO());
		model.addAttribute("machineProblemsList", machineProblemsList);

		Set<RepairHistory> repairHistoryList = new HashSet<RepairHistory>();
		repairHistoryList = repairHistoryServices
				.getRepairHistoryByMachineId(Long.parseLong(machineIdStr));
		model.addAttribute("repairHistoryList", repairHistoryList);
		model.addAttribute("machineId", machineIdStr);
		model.addAttribute("role", role);
		model.addAttribute("userId", request.getParameter("userId"));
		if (role.equals("admin")) {
			return "viewHistoryAdmin";
		} else if (role.equals("operator")) {
			return "viewMachineProblemOperator";
		} else if (role.equals("establishment")) {
			return "viewMachineProblemEstablishment";
		} else {
			return null;
		}

	}

	@RequestMapping(value = "/percentageDistribution")
	public String percentageDistribution(
			@RequestParam("machineId") long machineId,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		double apAdmin = 0.0;
		double apOp = 0.0;
		double apEst = 0.0;

		double pgAdmin = 0.0;
		double pgOp = 0.0;
		double pgEst = 0.0;

		double oeAdmin = 0.0;
		double oeOp = 0.0;
		double oeEst = 0.0;

		Admin admin = null;
		Operator op = null;
		Establishment est = null;

		Set<AgreedPercentage> apList = percentageDistributionServices
				.getAgreedPercentageByMachine(machineId);
		for (AgreedPercentage agreedPercentage : apList) {
			if (agreedPercentage.getRole().equals("admin")) {
				apAdmin = agreedPercentage.getValue();
				admin = agreedPercentage.getAdmin();
			}
			if (agreedPercentage.getRole().equals("op")) {
				apOp = agreedPercentage.getValue();
				op = agreedPercentage.getOperator();
			}
			if (agreedPercentage.getRole().equals("est")) {
				apEst = agreedPercentage.getValue();
				est = agreedPercentage.getEstablishment();
			}
		}

		// Set<PlayersGift> pgList = percentageDistributionServices
		// .getPlayersGiftByMachine(machineId);
		// for (PlayersGift playersGift : pgList) {
		// if (playersGift.getRole().equals("admin")) {
		// pgAdmin = playersGift.getValue();
		// }
		// if (playersGift.getRole().equals("op")) {
		// pgOp = playersGift.getValue();
		// }
		// if (playersGift.getRole().equals("est")) {
		// pgEst = playersGift.getValue();
		// }
		// }

		// Set<OtherExpenses> oeList = percentageDistributionServices
		// .getOtherExpensesByMachine(machineId);
		// for (OtherExpenses otherExpenses : oeList) {
		// if (otherExpenses.getRole().equals("admin")) {
		// oeAdmin = otherExpenses.getValue();
		// }
		// if (otherExpenses.getRole().equals("op")) {
		// oeOp = otherExpenses.getValue();
		// }
		// if (otherExpenses.getRole().equals("est")) {
		// oeEst = otherExpenses.getValue();
		// }
		// }

		model.addAttribute("apAdmin", apAdmin);
		model.addAttribute("apOp", apOp);
		model.addAttribute("apEst", apEst);

		// model.addAttribute("pgAdmin", pgAdmin);
		// model.addAttribute("pgOp", pgOp);
		// model.addAttribute("pgEst", pgEst);
		//
		// model.addAttribute("oeAdmin", oeAdmin);
		// model.addAttribute("oeOp", oeOp);
		// model.addAttribute("oeEst", oeEst);

		model.addAttribute("admin", admin);
		model.addAttribute("op", op);
		model.addAttribute("est", est);
		model.addAttribute("machineID", machineId);
		return "percentageDistribution";
	}

	@RequestMapping("/changePercentage")
	public String changePercentage(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		Operator op = null;
		if (!request.getParameter("operatorID").equals("")) {
			op = operatorServices.getOperatorById(Long.parseLong(request
					.getParameter("operatorID")));
		}
		Establishment est = null;
		if (!request.getParameter("establishmentID").equals("")) {
			est = establishmentServices.getEstablishmentById(Long
					.parseLong(request.getParameter("establishmentID")));
		}

		boolean flag = false;
		Set<AgreedPercentage> apList = percentageDistributionServices
				.getAgreedPercentageByMachine(Long.parseLong(request
						.getParameter("machineID")));
		for (AgreedPercentage agreedPercentage : apList) {
			if (agreedPercentage.getRole().equals("admin")) {
				agreedPercentage.setValue(Double.parseDouble(request
						.getParameter("agreedPercentageAdmin")));
				flag = true;
			}

			if (!request.getParameter("agreedPercentageOperator").equals("")) {
				if (agreedPercentage.getRole().equals("op")) {
					agreedPercentage.setValue(Double.parseDouble(request
							.getParameter("agreedPercentageOperator")));
					flag = true;
				}

			}

			if (!request.getParameter("agreedPercentageEstablishment").equals(
					"")) {
				if (agreedPercentage.getRole().equals("est")) {
					agreedPercentage.setValue(Double.parseDouble(request
							.getParameter("agreedPercentageEstablishment")));
					flag = true;
				}
			}

			if (flag) {
				percentageDistributionServices
						.addOrUpdateAgreedPercentge(agreedPercentage);
			}
			flag = false;
		}

		// Set<PlayersGift> pgList = percentageDistributionServices
		// .getPlayersGiftByMachine(Long.parseLong(request
		// .getParameter("machineID")));
		// flag = false;
		// for (PlayersGift playersGift : pgList) {
		// if (playersGift.getRole().equals("admin")) {
		// playersGift.setValue(Double.parseDouble(request
		// .getParameter("playersGiftAdmin")));
		// flag = true;
		// }
		//
		// if (!request.getParameter("playersGiftOperator").equals("")) {
		// if (playersGift.getRole().equals("op")) {
		// playersGift.setValue(Double.parseDouble(request
		// .getParameter("playersGiftOperator")));
		// flag = true;
		// }
		// }
		//
		// if (request.getParameter("playersGiftEstablishment").equals("")) {
		// if (playersGift.getRole().equals("est")) {
		// playersGift.setValue(Double.parseDouble(request
		// .getParameter("playersGiftEstablishment")));
		// flag = true;
		// }
		// }
		//
		// if (flag) {
		// percentageDistributionServices
		// .addOrUpdatePlayersGift(playersGift);
		// }
		// flag = false;
		// }

		// Set<OtherExpenses> oeList = percentageDistributionServices
		// .getOtherExpensesByMachine(Long.parseLong(request
		// .getParameter("machineID")));
		// flag = false;
		// for (OtherExpenses otherExpenses : oeList) {
		// if (otherExpenses.getRole().equals("admin")) {
		// otherExpenses.setValue(Double.parseDouble(request
		// .getParameter("otherExpensesAdmin")));
		// flag = true;
		// }
		//
		// if (otherExpenses.getRole().equals("op")) {
		// otherExpenses.setValue(Double.parseDouble(request
		// .getParameter("otherExpensesOperator")));
		// flag = true;
		// }
		//
		// if (otherExpenses.getRole().equals("est")) {
		// otherExpenses.setValue(Double.parseDouble(request
		// .getParameter("otherExpensesEstablishment")));
		// flag = true;
		// }
		//
		// if (flag) {
		// percentageDistributionServices
		// .addOrUpdateOtherExpenses(otherExpenses);
		// }
		// flag = false;
		// }

		Set<MachineType> machineTypeList = machineTypeServices
				.getMachineTypeList();

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();

		Admin loggedAdmin = adminServices.getAdminByUsername(userName);
		Set<Machine> machineList = machineServices.getMachineList();
		model.addAttribute("machineActive", "machineActive");
		model.addAttribute(new Machine());
		model.addAttribute("machineList", machineList);
		model.addAttribute("machineTypeList", machineTypeList);
		model.addAttribute("userId", loggedAdmin.getId());
		return "machineList";
	}

	@RequestMapping("/repairs")
	public String repairs(
			@ModelAttribute("repairHistoryForm") RepairHistoryForm repairHistoryForm,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String action = "action";
		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
		}

		String role = "role";
		if (request.getParameter("role") != null) {
			role = request.getParameter("role");
		}

		Long userId = null;
		if (request.getParameter("userId") != null) {
			userId = Long.parseLong(request.getParameter("userId"));
		}

		if (action != null) {
			if (action.equals("add")) {
				RepairHistory lastReportHistory = repairHistoryServices
						.getRepairHistoryById(Long.parseLong(request
								.getParameter("Idd")));
				long currentTimestampLong = System.currentTimeMillis();
				String currentTimestampStr = new SimpleDateFormat(
						"MM/dd/yyyy HH:mm:ss").format(currentTimestampLong);
				lastReportHistory.setStatus("done");
				if (role.equals("admin")) {
					lastReportHistory.setResolvedByAdmin(adminServices
							.getAdminById(userId));
				} else if (role.equals("operator")) {
					lastReportHistory.setResolvedByOperator(operatorServices
							.getOperatorById(userId));
				} else if (role.equals("establishment")) {
					lastReportHistory
							.setResolvedByEstablishment(establishmentServices
									.getEstablishmentById(userId));
				}
				lastReportHistory.setResolvedTime(currentTimestampLong);
				lastReportHistory.setResolvedTimeStr(currentTimestampStr);
				lastReportHistory.setDescription(repairHistoryForm
						.getDescription());

				MachineProblems machineProblems = lastReportHistory
						.getMachineProblems();
				machineProblems.setDescription(repairHistoryForm
						.getDescription());
				machineProblemsServices
						.addOrUpdateMachineProblems(machineProblems);
				long sparePartsIds[] = repairHistoryForm.getSpareParts();

				Set<SpareParts> sparePartsList = new HashSet<SpareParts>(0);
				if (sparePartsIds.length != 0) {
					for (int i = 0; i < sparePartsIds.length; i++) {

						if (sparePartsIds[i] != 0) {
							SpareParts spareParts = sparePartsServices
									.getSparePartsById(sparePartsIds[i]);
							sparePartsList.add(spareParts);
						} else {
							SpareParts spareParts = new SpareParts();
							System.out.println(request
									.getParameter("sparePartdescription"));
							spareParts.setDescription(request
									.getParameter("sparePartdescription"));
							sparePartsServices
									.addOrUpdateSpareParts(spareParts);
							SpareParts sparePartsOld = sparePartsServices
									.lastSpareParts();
							sparePartsList.add(sparePartsOld);
						}
					}
				}
				/*
				 * long machineProblemsIds = 0; Set<MachineProblems>
				 * machineProblemsList = new HashSet<MachineProblems>( 0);
				 * MachineProblems lastAddedMP = new MachineProblems();
				 * machineProblemsIds = Long.parseLong(request
				 * .getParameter("machineProblems")); if (machineProblemsIds !=
				 * 1) {
				 * 
				 * MachineProblems machineProblems = machineProblemsServices
				 * .getMachineProblemsById(machineProblemsIds);
				 * machineProblemsList.add(machineProblems);
				 * 
				 * } else { MachineProblems newMachineProblems = new
				 * MachineProblems();
				 * newMachineProblems.setDescription(repairHistoryForm
				 * .getOtherMachineProblems()); machineProblemsServices
				 * .addOrUpdateMachineProblems(newMachineProblems); lastAddedMP
				 * = machineProblemsServices .getLastMachineProblems();
				 * machineProblemsList.add(lastAddedMP); }
				 */
				lastReportHistory.setSpareParts(sparePartsList);
				// lastReportHistory.setMachineProblems(machineProblemsList);
				repairHistoryServices
						.addOrUpdateRepairHistory(lastReportHistory);
			}
		}

		Set<RepairHistory> repairHistoryList = new HashSet<RepairHistory>();

		Set<Machine> machineList = machineServices.getMachineList();
		for (Machine machine : machineList) {
			Set<RepairHistory> repairHistorys = repairHistoryServices
					.getRepairHistoryByMachineId(machine.getId());
			for (RepairHistory repairHistory2 : repairHistorys) {
				repairHistoryList.add(repairHistory2);
			}
		}
		Set<RepairHistory> repairHistoryPending = new HashSet<RepairHistory>();
		for (RepairHistory repairHis : repairHistoryList) {
			if (repairHis.getStatus().equals("pending")) {
				repairHistoryPending.add(repairHis);
			}
		}
		model.addAttribute(new RepairHistoryForm());
		model.addAttribute("repairHistoryList", repairHistoryPending);
		Set<SpareParts> sparePartsList = sparePartsServices.getSparePartsList();
		model.addAttribute(new SpareParts());
		model.addAttribute("sparePartsList", sparePartsList);
		Set<MachineProblems> machineProblemsList = machineProblemsServices
				.getMachineProblemsList();

		model.addAttribute(new MachineProblemsDTO());
		model.addAttribute("machineProblemsList", machineProblemsList);
		model.addAttribute("role", role);
		model.addAttribute("userId", userId);
		if (role.equals("admin")) {
			return "repairHistoryTechnician";
		} else if (role.equals("operator")) {
			return "resolvedHistoryOperator";
		} else if (role.equals("establishment")) {
			return "resolvedHistoryEstablishment";
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/machineProblemsList")
	public String machineProblemsList(
			@ModelAttribute("machineProblems") MachineProblems machineProblems,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String action = "action";
		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
		}

		if (action != null) {
			if (action.equals("add")) {
				machineProblemsServices
						.addOrUpdateMachineProblems(machineProblems);
			} else if (action.equals("edit")) {
				MachineProblems oldMachineProblems = machineProblemsServices
						.getMachineProblemsById(machineProblems.getId());
				oldMachineProblems.setDescription(machineProblems
						.getDescription());
				machineProblemsServices
						.addOrUpdateMachineProblems(oldMachineProblems);
			}
		}
		Set<MachineProblems> machineProblemsList = machineProblemsServices
				.getMachineProblemsList();
		model.addAttribute(new MachineProblems());
		model.addAttribute("machineProblemsList", machineProblemsList);
		return "machineProblemsList";

	}

	@RequestMapping(value = "/deleteMachineProblemsList")
	public String deletemachineProblemsList(@RequestParam("list") String str,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		str = str.substring(0, str.length() - 1);
		String[] str1 = str.split(",");
		boolean isError = true;
		for (int i = 0; i < str1.length; i++) {

			long id = Long.parseLong(str1[i]);
			isError = machineProblemsServices.deleteMachineProblems(id);

		}

		Set<MachineProblems> machineProblemsList = machineProblemsServices
				.getMachineProblemsList();
		model.addAttribute("technicianActive", "technicianActive");
		model.addAttribute(new MachineProblems());
		model.addAttribute("machineProblemsList", machineProblemsList);
		if (!isError) {
			model.addAttribute("error", "1");
		}

		return "machineProblemsList";
	}

	public HashMap<String, Long> getMachineTypeMap() {
		return machineTypeMap;
	}

	@RequestMapping(value = "/viewMoney")
	public String viewMoney(@RequestParam("country") long countryId,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		Set<Money> moneyList = new LinkedHashSet<Money>();

		Set<Coins> coinsList = coinsServices.getCoinsListByCountry(countryId);
		for (Coins coins : coinsList) {
			Money money = new Money(coins.getId(), coins.getName(),
					coins.getCode(), coins.getValue(), "coin");
			moneyList.add(money);
		}

		Set<Bills> billsList = billsServices.getBillsListByCountry(countryId);
		for (Bills bills : billsList) {
			Money money = new Money(bills.getId(), bills.getName(),
					bills.getCode(), bills.getValue(), "bill");
			moneyList.add(money);
		}

		Set<Notes> notesList = notesServices.getNotesListByCountry(countryId);
		for (Notes notes : notesList) {
			Money money = new Money(notes.getId(), notes.getName(),
					notes.getCode(), notes.getValue(), "note");
			moneyList.add(money);
		}

		Set<Tokens> tokensList = tokensServices
				.getTokensListByCountry(countryId);
		for (Tokens tokens : tokensList) {
			Money money = new Money(tokens.getId(), tokens.getName(),
					tokens.getCode(), tokens.getValue(), "token");
			moneyList.add(money);
		}
		model.addAttribute("countryId", countryId);
		model.addAttribute("moneyList", moneyList);
		model.addAttribute(new Money());
		return "viewMoney";
	}

	@RequestMapping(value = "/addMoney")
	public String addMoney(@ModelAttribute("money") Money money,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String action = "action";
		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
		}

		Country country = countryServices.getCountryById(Long.parseLong(request
				.getParameter("countryId")));
		if (action != null) {
			if (action.equals("add")) {
				if (money.getType().equals("coin")) {
					Coins coin = new Coins();
					coin.setCode(money.getCode());
					coin.setCountry(country);
					coin.setName(money.getName());
					coin.setValue(money.getValue());
					coinsServices.addOrUpdateCoins(coin);
				} else if (money.getType().equals("note")) {
					Notes notes = new Notes();
					notes.setCode(money.getCode());
					notes.setCountry(country);
					notes.setName(money.getName());
					notes.setValue(money.getValue());
					notesServices.addOrUpdateNotes(notes);
				} else if (money.getType().equals("token")) {
					Tokens token = new Tokens();
					token.setCode(money.getCode());
					token.setCountry(country);
					token.setName(money.getName());
					token.setValue(money.getValue());
					tokensServices.addOrUpdateTokens(token);
				} else if (money.getType().equals("bill")) {
					Bills bill = new Bills();
					bill.setCode(money.getCode());
					bill.setCountry(country);
					bill.setName(money.getName());
					bill.setValue(money.getValue());
					billsServices.addOrUpdateBills(bill);
				}
			} else if (action.equals("edit")) {
				if (money.getType().equals("coin")) {
					Coins coin = coinsServices.getCoinsById(money.getId());
					coin.setCode(money.getCode());
					coin.setCountry(country);
					coin.setName(money.getName());
					coin.setValue(money.getValue());
					coinsServices.addOrUpdateCoins(coin);
				} else if (money.getType().equals("note")) {
					Notes notes = notesServices.getNotesById(money.getId());
					notes.setCode(money.getCode());
					notes.setCountry(country);
					notes.setName(money.getName());
					notes.setValue(money.getValue());
					notesServices.addOrUpdateNotes(notes);
				} else if (money.getType().equals("token")) {
					Tokens token = tokensServices.getTokensById(money.getId());
					token.setCode(money.getCode());
					token.setCountry(country);
					token.setName(money.getName());
					token.setValue(money.getValue());
					tokensServices.addOrUpdateTokens(token);
				} else if (money.getType().equals("bill")) {
					Bills bill = billsServices.getBillsById(money.getId());
					bill.setCode(money.getCode());
					bill.setCountry(country);
					bill.setName(money.getName());
					bill.setValue(money.getValue());
					billsServices.addOrUpdateBills(bill);
				}
			}
		}

		Set<Money> moneyList = new LinkedHashSet<Money>();

		Set<Coins> coinsList = coinsServices.getCoinsListByCountry(Long
				.parseLong(request.getParameter("countryId")));
		for (Coins coins : coinsList) {
			Money money1 = new Money(coins.getId(), coins.getName(),
					coins.getCode(), coins.getValue(), "coin");
			moneyList.add(money1);
		}

		Set<Bills> billsList = billsServices.getBillsListByCountry(Long
				.parseLong(request.getParameter("countryId")));
		for (Bills bills : billsList) {
			Money money1 = new Money(bills.getId(), bills.getName(),
					bills.getCode(), bills.getValue(), "bill");
			moneyList.add(money1);
		}

		Set<Notes> notesList = notesServices.getNotesListByCountry(Long
				.parseLong(request.getParameter("countryId")));
		for (Notes notes : notesList) {
			Money money1 = new Money(notes.getId(), notes.getName(),
					notes.getCode(), notes.getValue(), "note");
			moneyList.add(money1);
		}

		Set<Tokens> tokensList = tokensServices.getTokensListByCountry(Long
				.parseLong(request.getParameter("countryId")));
		for (Tokens tokens : tokensList) {
			Money money1 = new Money(tokens.getId(), tokens.getName(),
					tokens.getCode(), tokens.getValue(), "token");
			moneyList.add(money1);
		}
		model.addAttribute("countryId",
				Long.parseLong(request.getParameter("countryId")));
		model.addAttribute("moneyList", moneyList);
		model.addAttribute(new Money());
		return "viewMoney";
	}

	@RequestMapping(value = "/deleteMoney")
	public String deleteMoney(@RequestParam("list") String str,
			@RequestParam("countryId") long countryId,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		str = str.substring(0, str.length() - 1);
		String[] str1 = str.split(",");

		for (int i = 0; i < str1.length; i++) {

			long id = Long.parseLong(str1[i]);
			Coins coins = coinsServices.getCoinsById(id);
			if (coins != null) {

				Set<InputMoneyPaymentDevice> inputPaymentDevices = inputMoneyPaymentDeviceServices
						.getInputMoneyPaymentDeviceListByCoin(id);
				for (InputMoneyPaymentDevice inputMoneyPaymentDevice : inputPaymentDevices) {
					inputMoneyPaymentDeviceServices
							.deleteInputMoneyPaymentDevice(inputMoneyPaymentDevice
									.getId());
				}
				Set<OutputMoneyPaymentDevice> outputMoneyPaymentDevices = outputMoneyPaymentDeviceServices
						.getOutputMoneyPaymentDeviceListByCoin(id);
				for (OutputMoneyPaymentDevice outputMoneyPaymentDevice : outputMoneyPaymentDevices) {
					outputMoneyPaymentDeviceServices
							.deleteOutputMoneyPaymentDevice(outputMoneyPaymentDevice
									.getId());
				}
				coinsServices.deleteCoins(id);

			}
			Notes notes = notesServices.getNotesById(id);
			if (notes != null) {

				Set<InputMoneyPaymentDevice> inputPaymentDevices = inputMoneyPaymentDeviceServices
						.getInputMoneyPaymentDeviceListByNote(id);
				for (InputMoneyPaymentDevice inputMoneyPaymentDevice : inputPaymentDevices) {
					inputMoneyPaymentDeviceServices
							.deleteInputMoneyPaymentDevice(inputMoneyPaymentDevice
									.getId());
				}
				Set<OutputMoneyPaymentDevice> outputMoneyPaymentDevices = outputMoneyPaymentDeviceServices
						.getOutputMoneyPaymentDeviceListByNote(id);
				for (OutputMoneyPaymentDevice outputMoneyPaymentDevice : outputMoneyPaymentDevices) {
					outputMoneyPaymentDeviceServices
							.deleteOutputMoneyPaymentDevice(outputMoneyPaymentDevice
									.getId());
				}
				notesServices.deleteNotes(id);
			}
			Tokens tokens = tokensServices.getTokensById(id);
			if (tokens != null) {

				Set<InputMoneyPaymentDevice> inputPaymentDevices = inputMoneyPaymentDeviceServices
						.getInputMoneyPaymentDeviceListByToken(id);
				for (InputMoneyPaymentDevice inputMoneyPaymentDevice : inputPaymentDevices) {
					inputMoneyPaymentDeviceServices
							.deleteInputMoneyPaymentDevice(inputMoneyPaymentDevice
									.getId());
				}
				Set<OutputMoneyPaymentDevice> outputMoneyPaymentDevices = outputMoneyPaymentDeviceServices
						.getOutputMoneyPaymentDeviceListByToken(id);
				for (OutputMoneyPaymentDevice outputMoneyPaymentDevice : outputMoneyPaymentDevices) {
					outputMoneyPaymentDeviceServices
							.deleteOutputMoneyPaymentDevice(outputMoneyPaymentDevice
									.getId());
				}
				tokensServices.deleteTokens(id);
			}
			Bills bills = billsServices.getBillsById(id);
			if (bills != null) {

				Set<InputMoneyPaymentDevice> inputPaymentDevices = inputMoneyPaymentDeviceServices
						.getInputMoneyPaymentDeviceListByBill(id);
				for (InputMoneyPaymentDevice inputMoneyPaymentDevice : inputPaymentDevices) {
					inputMoneyPaymentDeviceServices
							.deleteInputMoneyPaymentDevice(inputMoneyPaymentDevice
									.getId());
				}
				Set<OutputMoneyPaymentDevice> outputMoneyPaymentDevices = outputMoneyPaymentDeviceServices
						.getOutputMoneyPaymentDeviceListByBill(id);
				for (OutputMoneyPaymentDevice outputMoneyPaymentDevice : outputMoneyPaymentDevices) {
					outputMoneyPaymentDeviceServices
							.deleteOutputMoneyPaymentDevice(outputMoneyPaymentDevice
									.getId());
				}
				billsServices.deleteBills(id);
			}

		}

		Set<Money> moneyList = new LinkedHashSet<Money>();

		Set<Coins> coinsList = coinsServices.getCoinsListByCountry(countryId);
		for (Coins coins : coinsList) {
			Money money1 = new Money(coins.getId(), coins.getName(),
					coins.getCode(), coins.getValue(), "coin");
			moneyList.add(money1);
		}

		Set<Bills> billsList = billsServices.getBillsListByCountry(countryId);
		for (Bills bills : billsList) {
			Money money1 = new Money(bills.getId(), bills.getName(),
					bills.getCode(), bills.getValue(), "bill");
			moneyList.add(money1);
		}

		Set<Notes> notesList = notesServices.getNotesListByCountry(countryId);
		for (Notes notes : notesList) {
			Money money1 = new Money(notes.getId(), notes.getName(),
					notes.getCode(), notes.getValue(), "note");
			moneyList.add(money1);
		}

		Set<Tokens> tokensList = tokensServices
				.getTokensListByCountry(countryId);
		for (Tokens tokens : tokensList) {
			Money money1 = new Money(tokens.getId(), tokens.getName(),
					tokens.getCode(), tokens.getValue(), "token");
			moneyList.add(money1);
		}
		model.addAttribute("countryId", countryId);
		model.addAttribute("moneyList", moneyList);
		model.addAttribute(new Money());
		return "viewMoney";
	}

	@RequestMapping(value = "/viewPaymentDeviceMoney")
	public String viewPaymentDeviceMoney(
			@RequestParam("paymentDeviceId") long paymentDeviceId,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		List<Money> moneyList = new ArrayList<Money>();

		PaymentDeviceType pdt = paymentDeviceTypeServices
				.getPaymentDeviceTypeById(paymentDeviceId);

		Set<InputMoneyPaymentDevice> inputMoneyPaymentDeviceList = inputMoneyPaymentDeviceServices
				.getInputMoneyPaymentDeviceListByPaymentDeviceType(paymentDeviceId);
		Set<Coins> inputCoins = coinsServices.getCoinsList();

		Set<Notes> inputNotes = notesServices.getNotesList();

		Set<Tokens> inputTokens = tokensServices.getTokensList();

		Set<Bills> inputBills = billsServices.getBillsList();

		if (pdt.getIo().equals("input") || pdt.getIo().equals("inputoutput")) {

			for (InputMoneyPaymentDevice inputMoneyPaymentDevice : inputMoneyPaymentDeviceList) {
				if (inputMoneyPaymentDevice.getBills() != null) {
					Bills bill = billsServices
							.getBillsById(inputMoneyPaymentDevice.getBills()
									.getId());
					Money money = new Money(bill.getId(), bill.getName(),
							bill.getCode(), bill.getValue(), "bill", "INPUT");
					moneyList.add(money);
					for (Iterator<Bills> i = inputBills.iterator(); i.hasNext();) {
						Bills element = i.next();
						if (element.getId() == bill.getId()) {
							i.remove();
						}
					}

				} else if (inputMoneyPaymentDevice.getCoins() != null) {
					Coins coin = coinsServices
							.getCoinsById(inputMoneyPaymentDevice.getCoins()
									.getId());
					Money money = new Money(coin.getId(), coin.getName(),
							coin.getCode(), coin.getValue(), "coin", "INPUT");
					moneyList.add(money);
					for (Iterator<Coins> i = inputCoins.iterator(); i.hasNext();) {
						Coins element = i.next();
						if (element.getId() == coin.getId()) {
							i.remove();
						}
					}
				} else if (inputMoneyPaymentDevice.getNotes() != null) {
					Notes note = notesServices
							.getNotesById(inputMoneyPaymentDevice.getNotes()
									.getId());
					Money money = new Money(note.getId(), note.getName(),
							note.getCode(), note.getValue(), "note", "INPUT");
					moneyList.add(money);
					for (Iterator<Notes> i = inputNotes.iterator(); i.hasNext();) {
						Notes element = i.next();
						if (element.getId() == note.getId()) {
							i.remove();
						}
					}
				} else if (inputMoneyPaymentDevice.getTokens() != null) {
					Tokens token = tokensServices
							.getTokensById(inputMoneyPaymentDevice.getTokens()
									.getId());
					Money money = new Money(token.getId(), token.getName(),
							token.getCode(), token.getValue(), "token", "INPUT");
					moneyList.add(money);
					for (Iterator<Tokens> i = inputTokens.iterator(); i
							.hasNext();) {
						Tokens element = i.next();
						if (element.getId() == token.getId()) {
							i.remove();
						}
					}
				}
			}

		}

		Set<OutputMoneyPaymentDevice> outputMoneyPaymentDeviceList = outputMoneyPaymentDeviceServices
				.getOutputMoneyPaymentDeviceListByPaymentDeviceType(paymentDeviceId);
		Set<Coins> outputCoins = coinsServices.getCoinsList();
		Set<Notes> outputNotes = notesServices.getNotesList();
		Set<Tokens> outputTokens = tokensServices.getTokensList();
		Set<Bills> outputBills = billsServices.getBillsList();

		if (pdt.getIo().equals("output") || pdt.getIo().equals("inputoutput")) {
			for (OutputMoneyPaymentDevice outputMoneyPaymentDevice : outputMoneyPaymentDeviceList) {
				if (outputMoneyPaymentDevice.getBills() != null) {
					Bills bill = billsServices
							.getBillsById(outputMoneyPaymentDevice.getBills()
									.getId());
					Money money = new Money(bill.getId(), bill.getName(),
							bill.getCode(), bill.getValue(), "bill", "OUTPUT");
					moneyList.add(money);
					for (Iterator<Bills> i = outputBills.iterator(); i
							.hasNext();) {
						Bills element = i.next();
						if (element.getId() == bill.getId()) {
							i.remove();
						}
					}
				} else if (outputMoneyPaymentDevice.getCoins() != null) {
					Coins coin = coinsServices
							.getCoinsById(outputMoneyPaymentDevice.getCoins()
									.getId());
					Money money = new Money(coin.getId(), coin.getName(),
							coin.getCode(), coin.getValue(), "coin", "OUTPUT");
					moneyList.add(money);
					for (Iterator<Coins> i = outputCoins.iterator(); i
							.hasNext();) {
						Coins element = i.next();
						if (element.getId() == coin.getId()) {
							i.remove();
						}
					}
				} else if (outputMoneyPaymentDevice.getNotes() != null) {
					Notes note = notesServices
							.getNotesById(outputMoneyPaymentDevice.getNotes()
									.getId());
					Money money = new Money(note.getId(), note.getName(),
							note.getCode(), note.getValue(), "note", "OUTPUT");
					moneyList.add(money);
					for (Iterator<Notes> i = outputNotes.iterator(); i
							.hasNext();) {
						Notes element = i.next();
						if (element.getId() == note.getId()) {
							i.remove();
						}
					}
				} else if (outputMoneyPaymentDevice.getTokens() != null) {
					Tokens token = tokensServices
							.getTokensById(outputMoneyPaymentDevice.getTokens()
									.getId());
					Money money = new Money(token.getId(), token.getName(),
							token.getCode(), token.getValue(), "token",
							"OUTPUT");
					moneyList.add(money);
					for (Iterator<Tokens> i = outputTokens.iterator(); i
							.hasNext();) {
						Tokens element = i.next();
						if (element.getId() == token.getId()) {
							i.remove();
						}
					}
				}
			}
		}

		List<Money> moneySet = new ArrayList<Money>();

		for (Coins coin : inputCoins) {
			Money money2 = new Money(coin.getId(), coin.getName(),
					coin.getCode(), coin.getValue(), "coin", "INPUT");
			moneySet.add(money2);
		}
		for (Bills coin : inputBills) {
			Money money2 = new Money(coin.getId(), coin.getName(),
					coin.getCode(), coin.getValue(), "bill", "INPUT");
			moneySet.add(money2);
		}
		for (Notes coin : inputNotes) {
			Money money2 = new Money(coin.getId(), coin.getName(),
					coin.getCode(), coin.getValue(), "note", "INPUT");
			moneySet.add(money2);
		}
		for (Tokens coin : inputTokens) {
			Money money2 = new Money(coin.getId(), coin.getName(),
					coin.getCode(), coin.getValue(), "token", "INPUT");
			moneySet.add(money2);
		}
		for (Coins coin : outputCoins) {
			Money money2 = new Money(coin.getId(), coin.getName(),
					coin.getCode(), coin.getValue(), "coin", "OUTPUT");
			moneySet.add(money2);
		}
		for (Bills coin : outputBills) {
			Money money2 = new Money(coin.getId(), coin.getName(),
					coin.getCode(), coin.getValue(), "bill", "OUTPUT");
			moneySet.add(money2);
		}
		for (Notes coin : outputNotes) {
			Money money2 = new Money(coin.getId(), coin.getName(),
					coin.getCode(), coin.getValue(), "note", "OUTPUT");
			moneySet.add(money2);
		}
		for (Tokens coin : outputTokens) {
			Money money2 = new Money(coin.getId(), coin.getName(),
					coin.getCode(), coin.getValue(), "token", "OUTPUT");
			moneySet.add(money2);
		}

		model.addAttribute("moneyList", moneyList);
		model.addAttribute(new Money());
		model.addAttribute("modelSet", moneySet);
		model.addAttribute("paymentDeviceTypeId", paymentDeviceId);

		return "viewPaymentDeviceMoney";
	}

	@RequestMapping(value = "/addPaymentDeviceMoney")
	public String addPaymentDeviceMoney(@ModelAttribute("money") Money money3,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String moneyInfo = money3.getMoneyAdd();
		String str[] = moneyInfo.split(",");
		long id = Long.parseLong(str[0]);
		String type = str[1];
		String moneyType = str[2];
		Coins coins = null;
		Bills bills = null;
		Tokens tokens = null;
		Notes notes = null;

		if (type.equals("coin")) {
			coins = coinsServices.getCoinsById(id);
		} else if (type.equals("note")) {
			notes = notesServices.getNotesById(id);
		} else if (type.equals("token")) {
			tokens = tokensServices.getTokensById(id);
		} else if (type.equals("bill")) {
			bills = billsServices.getBillsById(id);
		}

		PaymentDeviceType paymentDeviceType = paymentDeviceTypeServices
				.getPaymentDeviceTypeById(Long.parseLong(request
						.getParameter("paymentDeviceTypeId")));

		if (moneyType.equals("INPUT")) {
			if (coins != null) {
				InputMoneyPaymentDevice inputMoneyPaymentDevice = new InputMoneyPaymentDevice();
				inputMoneyPaymentDevice.setCoins(coins);
				inputMoneyPaymentDevice.setPaymentDeviceType(paymentDeviceType);
				inputMoneyPaymentDeviceServices
						.addOrUpdateInputMoneyPaymentDevice(inputMoneyPaymentDevice);
			} else if (notes != null) {
				InputMoneyPaymentDevice inputMoneyPaymentDevice = new InputMoneyPaymentDevice();
				inputMoneyPaymentDevice.setNotes(notes);
				inputMoneyPaymentDevice.setPaymentDeviceType(paymentDeviceType);
				inputMoneyPaymentDeviceServices
						.addOrUpdateInputMoneyPaymentDevice(inputMoneyPaymentDevice);
			} else if (tokens != null) {
				InputMoneyPaymentDevice inputMoneyPaymentDevice = new InputMoneyPaymentDevice();
				inputMoneyPaymentDevice.setTokens(tokens);
				inputMoneyPaymentDevice.setPaymentDeviceType(paymentDeviceType);
				inputMoneyPaymentDeviceServices
						.addOrUpdateInputMoneyPaymentDevice(inputMoneyPaymentDevice);
			} else if (bills != null) {
				InputMoneyPaymentDevice inputMoneyPaymentDevice = new InputMoneyPaymentDevice();
				inputMoneyPaymentDevice.setBills(bills);
				inputMoneyPaymentDevice.setPaymentDeviceType(paymentDeviceType);
				inputMoneyPaymentDeviceServices
						.addOrUpdateInputMoneyPaymentDevice(inputMoneyPaymentDevice);
			}
			if (paymentDeviceType.getIo().equals("output")) {
				paymentDeviceType.setIo("inputoutput");
				paymentDeviceTypeServices
						.addOrUpdatePaymentDeviceType(paymentDeviceType);
			}
		} else if (moneyType.equals("OUTPUT")) {
			if (coins != null) {
				OutputMoneyPaymentDevice outputMoneyPaymentDevice = new OutputMoneyPaymentDevice();
				outputMoneyPaymentDevice.setCoins(coins);
				outputMoneyPaymentDevice
						.setPaymentDeviceType(paymentDeviceType);
				outputMoneyPaymentDeviceServices
						.addOrUpdateOutputMoneyPaymentDevice(outputMoneyPaymentDevice);
			} else if (notes != null) {
				OutputMoneyPaymentDevice outputMoneyPaymentDevice = new OutputMoneyPaymentDevice();
				outputMoneyPaymentDevice.setNotes(notes);
				outputMoneyPaymentDevice
						.setPaymentDeviceType(paymentDeviceType);
				outputMoneyPaymentDeviceServices
						.addOrUpdateOutputMoneyPaymentDevice(outputMoneyPaymentDevice);
			} else if (tokens != null) {
				OutputMoneyPaymentDevice outputMoneyPaymentDevice = new OutputMoneyPaymentDevice();
				outputMoneyPaymentDevice.setTokens(tokens);
				outputMoneyPaymentDevice
						.setPaymentDeviceType(paymentDeviceType);
				outputMoneyPaymentDeviceServices
						.addOrUpdateOutputMoneyPaymentDevice(outputMoneyPaymentDevice);
			} else if (bills != null) {
				OutputMoneyPaymentDevice outputMoneyPaymentDevice = new OutputMoneyPaymentDevice();
				outputMoneyPaymentDevice.setBills(bills);
				outputMoneyPaymentDevice
						.setPaymentDeviceType(paymentDeviceType);
				outputMoneyPaymentDeviceServices
						.addOrUpdateOutputMoneyPaymentDevice(outputMoneyPaymentDevice);
			}
			if (paymentDeviceType.getIo().equals("input")) {
				paymentDeviceType.setIo("inputoutput");
				paymentDeviceTypeServices
						.addOrUpdatePaymentDeviceType(paymentDeviceType);
			}
		}

		List<Money> moneyList = new ArrayList<Money>();

		Set<InputMoneyPaymentDevice> inputMoneyPaymentDeviceList = inputMoneyPaymentDeviceServices
				.getInputMoneyPaymentDeviceListByPaymentDeviceType(paymentDeviceType
						.getId());
		Set<Coins> inputCoins = coinsServices.getCoinsList();
		Set<Notes> inputNotes = notesServices.getNotesList();
		Set<Tokens> inputTokens = tokensServices.getTokensList();
		Set<Bills> inputBills = billsServices.getBillsList();

		for (InputMoneyPaymentDevice inputMoneyPaymentDevice : inputMoneyPaymentDeviceList) {
			if (inputMoneyPaymentDevice.getBills() != null) {
				Bills bill = billsServices.getBillsById(inputMoneyPaymentDevice
						.getBills().getId());
				Money money = new Money(bill.getId(), bill.getName(),
						bill.getCode(), bill.getValue(), "bill", "INPUT");
				moneyList.add(money);
				inputBills.remove(bill);
			} else if (inputMoneyPaymentDevice.getCoins() != null) {
				Coins coin = coinsServices.getCoinsById(inputMoneyPaymentDevice
						.getCoins().getId());
				Money money = new Money(coin.getId(), coin.getName(),
						coin.getCode(), coin.getValue(), "coin", "INPUT");
				moneyList.add(money);
				inputCoins.remove(coin);
			} else if (inputMoneyPaymentDevice.getNotes() != null) {
				Notes note = notesServices.getNotesById(inputMoneyPaymentDevice
						.getNotes().getId());
				Money money = new Money(note.getId(), note.getName(),
						note.getCode(), note.getValue(), "note", "INPUT");
				moneyList.add(money);
				inputNotes.remove(note);
			} else if (inputMoneyPaymentDevice.getTokens() != null) {
				Tokens token = tokensServices
						.getTokensById(inputMoneyPaymentDevice.getTokens()
								.getId());
				Money money = new Money(token.getId(), token.getName(),
						token.getCode(), token.getValue(), "token", "INPUT");
				moneyList.add(money);
				inputTokens.remove(token);
			}
		}

		Set<OutputMoneyPaymentDevice> outputMoneyPaymentDeviceList = outputMoneyPaymentDeviceServices
				.getOutputMoneyPaymentDeviceListByPaymentDeviceType(paymentDeviceType
						.getId());
		Set<Coins> outputCoins = coinsServices.getCoinsList();
		Set<Notes> outputNotes = notesServices.getNotesList();
		Set<Tokens> outputTokens = tokensServices.getTokensList();
		Set<Bills> outputBills = billsServices.getBillsList();

		for (OutputMoneyPaymentDevice outputMoneyPaymentDevice : outputMoneyPaymentDeviceList) {
			if (outputMoneyPaymentDevice.getBills() != null) {
				Bills bill = billsServices
						.getBillsById(outputMoneyPaymentDevice.getBills()
								.getId());
				Money money = new Money(bill.getId(), bill.getName(),
						bill.getCode(), bill.getValue(), "bill", "OUTPUT");
				moneyList.add(money);
				outputBills.remove(bill);
			} else if (outputMoneyPaymentDevice.getCoins() != null) {
				Coins coin = coinsServices
						.getCoinsById(outputMoneyPaymentDevice.getCoins()
								.getId());
				Money money = new Money(coin.getId(), coin.getName(),
						coin.getCode(), coin.getValue(), "coin", "OUTPUT");
				moneyList.add(money);
				outputCoins.remove(coin);
			} else if (outputMoneyPaymentDevice.getNotes() != null) {
				Notes note = notesServices
						.getNotesById(outputMoneyPaymentDevice.getNotes()
								.getId());
				Money money = new Money(note.getId(), note.getName(),
						note.getCode(), note.getValue(), "note", "OUTPUT");
				moneyList.add(money);
				outputNotes.remove(note);
			} else if (outputMoneyPaymentDevice.getTokens() != null) {
				Tokens token = tokensServices
						.getTokensById(outputMoneyPaymentDevice.getTokens()
								.getId());
				Money money = new Money(token.getId(), token.getName(),
						token.getCode(), token.getValue(), "token", "OUTPUT");
				moneyList.add(money);
				outputTokens.remove(token);
			}
		}

		List<Money> moneySet = new ArrayList<Money>();

		for (Coins coin : inputCoins) {
			Money money2 = new Money(coin.getId(), coin.getName(),
					coin.getCode(), coin.getValue(), "coin", "INPUT");
			moneySet.add(money2);
		}
		for (Bills coin : inputBills) {
			Money money2 = new Money(coin.getId(), coin.getName(),
					coin.getCode(), coin.getValue(), "bill", "INPUT");
			moneySet.add(money2);
		}
		for (Notes coin : inputNotes) {
			Money money2 = new Money(coin.getId(), coin.getName(),
					coin.getCode(), coin.getValue(), "note", "INPUT");
			moneySet.add(money2);
		}
		for (Tokens coin : inputTokens) {
			Money money2 = new Money(coin.getId(), coin.getName(),
					coin.getCode(), coin.getValue(), "token", "INPUT");
			moneySet.add(money2);
		}
		for (Coins coin : outputCoins) {
			Money money2 = new Money(coin.getId(), coin.getName(),
					coin.getCode(), coin.getValue(), "coin", "OUTPUT");
			moneySet.add(money2);
		}
		for (Bills coin : outputBills) {
			Money money2 = new Money(coin.getId(), coin.getName(),
					coin.getCode(), coin.getValue(), "bill", "OUTPUT");
			moneySet.add(money2);
		}
		for (Notes coin : outputNotes) {
			Money money2 = new Money(coin.getId(), coin.getName(),
					coin.getCode(), coin.getValue(), "note", "OUTPUT");
			moneySet.add(money2);
		}
		for (Tokens coin : outputTokens) {
			Money money2 = new Money(coin.getId(), coin.getName(),
					coin.getCode(), coin.getValue(), "token", "OUTPUT");
			moneySet.add(money2);
		}

		model.addAttribute("moneyList", moneyList);
		model.addAttribute(new Money());
		model.addAttribute("modelSet", moneySet);
		model.addAttribute("paymentDeviceTypeId", paymentDeviceType.getId());

		return "viewPaymentDeviceMoney";
	}

	@RequestMapping(value = "/deletePaymentDeviceMoney")
	public String deletePaymentDeviceMoney(@RequestParam("list") String str,
			@RequestParam("paymentDeviceTypeId") long paymentDeviceTypeId,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		str = str.substring(0, str.length() - 1);
		String[] str1 = str.split(",");
		for (int i = 0; i < str1.length; i++) {

			String moneyInfo[] = str1[i].split("-");
			if (moneyInfo[2].equals("INPUT")) {
				if (moneyInfo[1].equals("coin")) {
					InputMoneyPaymentDevice impd = inputMoneyPaymentDeviceServices
							.getInputMoneyPaymentDeviceByCoinByPaymentDeviceType(
									Long.parseLong(moneyInfo[0]),
									paymentDeviceTypeId);
					inputMoneyPaymentDeviceServices
							.deleteInputMoneyPaymentDevice(impd.getId());
				} else if (moneyInfo[1].equals("note")) {
					InputMoneyPaymentDevice impd = inputMoneyPaymentDeviceServices
							.getInputMoneyPaymentDeviceByNoteByPaymentDeviceType(
									Long.parseLong(moneyInfo[0]),
									paymentDeviceTypeId);
					inputMoneyPaymentDeviceServices
							.deleteInputMoneyPaymentDevice(impd.getId());
				} else if (moneyInfo[1].equals("bill")) {
					InputMoneyPaymentDevice impd = inputMoneyPaymentDeviceServices
							.getInputMoneyPaymentDeviceByBillByPaymentDeviceType(
									Long.parseLong(moneyInfo[0]),
									paymentDeviceTypeId);
					inputMoneyPaymentDeviceServices
							.deleteInputMoneyPaymentDevice(impd.getId());
				} else if (moneyInfo[1].equals("token")) {
					InputMoneyPaymentDevice impd = inputMoneyPaymentDeviceServices
							.getInputMoneyPaymentDeviceByTokenByPaymentDeviceType(
									Long.parseLong(moneyInfo[0]),
									paymentDeviceTypeId);
					inputMoneyPaymentDeviceServices
							.deleteInputMoneyPaymentDevice(impd.getId());
				}
			} else if (moneyInfo[2].equals("OUTPUT")) {
				if (moneyInfo[1].equals("coin")) {
					OutputMoneyPaymentDevice ompd = outputMoneyPaymentDeviceServices
							.getOutputMoneyPaymentDeviceByCoinByPaymentDeviceType(
									Long.parseLong(moneyInfo[0]),
									paymentDeviceTypeId);
					outputMoneyPaymentDeviceServices
							.deleteOutputMoneyPaymentDevice(ompd.getId());
				} else if (moneyInfo[1].equals("note")) {
					OutputMoneyPaymentDevice ompd = outputMoneyPaymentDeviceServices
							.getOutputMoneyPaymentDeviceByNoteByPaymentDeviceType(
									Long.parseLong(moneyInfo[0]),
									paymentDeviceTypeId);
					outputMoneyPaymentDeviceServices
							.deleteOutputMoneyPaymentDevice(ompd.getId());
				} else if (moneyInfo[1].equals("bill")) {
					OutputMoneyPaymentDevice ompd = outputMoneyPaymentDeviceServices
							.getOutputMoneyPaymentDeviceByBillByPaymentDeviceType(
									Long.parseLong(moneyInfo[0]),
									paymentDeviceTypeId);
					outputMoneyPaymentDeviceServices
							.deleteOutputMoneyPaymentDevice(ompd.getId());
				} else if (moneyInfo[1].equals("token")) {
					OutputMoneyPaymentDevice ompd = outputMoneyPaymentDeviceServices
							.getOutputMoneyPaymentDeviceByTokenByPaymentDeviceType(
									Long.parseLong(moneyInfo[0]),
									paymentDeviceTypeId);
					outputMoneyPaymentDeviceServices
							.deleteOutputMoneyPaymentDevice(ompd.getId());
				}
			}
		}

		List<Money> moneyList = new ArrayList<Money>();

		Set<InputMoneyPaymentDevice> inputMoneyPaymentDeviceList = inputMoneyPaymentDeviceServices
				.getInputMoneyPaymentDeviceListByPaymentDeviceType(paymentDeviceTypeId);
		Set<Coins> inputCoins = coinsServices.getCoinsList();
		for (Coins coins : inputCoins) {
			System.out.println("before coin: " + coins.getCode());
		}
		Set<Notes> inputNotes = notesServices.getNotesList();
		for (Notes notes : inputNotes) {
			System.out.println("before Note: " + notes.getCode());
		}
		Set<Tokens> inputTokens = tokensServices.getTokensList();
		for (Tokens tokens : inputTokens) {
			System.out.println("before token: " + tokens.getCode());
		}
		Set<Bills> inputBills = billsServices.getBillsList();
		for (Bills bills : inputBills) {
			System.out.println("before bill: " + bills.getCode());
		}

		for (InputMoneyPaymentDevice inputMoneyPaymentDevice : inputMoneyPaymentDeviceList) {
			if (inputMoneyPaymentDevice.getBills() != null) {
				Bills bill = billsServices.getBillsById(inputMoneyPaymentDevice
						.getBills().getId());
				Money money = new Money(bill.getId(), bill.getName(),
						bill.getCode(), bill.getValue(), "bill", "INPUT");
				moneyList.add(money);
				for (Iterator<Bills> i = inputBills.iterator(); i.hasNext();) {
					Bills element = i.next();
					if (element.getId() == bill.getId()) {
						i.remove();
					}
				}

			} else if (inputMoneyPaymentDevice.getCoins() != null) {
				Coins coin = coinsServices.getCoinsById(inputMoneyPaymentDevice
						.getCoins().getId());
				Money money = new Money(coin.getId(), coin.getName(),
						coin.getCode(), coin.getValue(), "coin", "INPUT");
				moneyList.add(money);
				for (Iterator<Coins> i = inputCoins.iterator(); i.hasNext();) {
					Coins element = i.next();
					if (element.getId() == coin.getId()) {
						i.remove();
					}
				}
			} else if (inputMoneyPaymentDevice.getNotes() != null) {
				Notes note = notesServices.getNotesById(inputMoneyPaymentDevice
						.getNotes().getId());
				Money money = new Money(note.getId(), note.getName(),
						note.getCode(), note.getValue(), "note", "INPUT");
				moneyList.add(money);
				for (Iterator<Notes> i = inputNotes.iterator(); i.hasNext();) {
					Notes element = i.next();
					if (element.getId() == note.getId()) {
						i.remove();
					}
				}
			} else if (inputMoneyPaymentDevice.getTokens() != null) {
				Tokens token = tokensServices
						.getTokensById(inputMoneyPaymentDevice.getTokens()
								.getId());
				Money money = new Money(token.getId(), token.getName(),
						token.getCode(), token.getValue(), "token", "INPUT");
				moneyList.add(money);
				for (Iterator<Tokens> i = inputTokens.iterator(); i.hasNext();) {
					Tokens element = i.next();
					if (element.getId() == token.getId()) {
						i.remove();
					}
				}
			}
		}

		Set<OutputMoneyPaymentDevice> outputMoneyPaymentDeviceList = outputMoneyPaymentDeviceServices
				.getOutputMoneyPaymentDeviceListByPaymentDeviceType(paymentDeviceTypeId);
		Set<Coins> outputCoins = coinsServices.getCoinsList();
		Set<Notes> outputNotes = notesServices.getNotesList();
		Set<Tokens> outputTokens = tokensServices.getTokensList();
		Set<Bills> outputBills = billsServices.getBillsList();

		for (OutputMoneyPaymentDevice outputMoneyPaymentDevice : outputMoneyPaymentDeviceList) {
			if (outputMoneyPaymentDevice.getBills() != null) {
				Bills bill = billsServices
						.getBillsById(outputMoneyPaymentDevice.getBills()
								.getId());
				Money money = new Money(bill.getId(), bill.getName(),
						bill.getCode(), bill.getValue(), "bill", "OUTPUT");
				moneyList.add(money);
				for (Iterator<Bills> i = inputBills.iterator(); i.hasNext();) {
					Bills element = i.next();
					if (element.getId() == bill.getId()) {
						i.remove();
					}
				}
			} else if (outputMoneyPaymentDevice.getCoins() != null) {
				Coins coin = coinsServices
						.getCoinsById(outputMoneyPaymentDevice.getCoins()
								.getId());
				Money money = new Money(coin.getId(), coin.getName(),
						coin.getCode(), coin.getValue(), "coin", "OUTPUT");
				moneyList.add(money);
				for (Iterator<Coins> i = inputCoins.iterator(); i.hasNext();) {
					Coins element = i.next();
					if (element.getId() == coin.getId()) {
						i.remove();
					}
				}
			} else if (outputMoneyPaymentDevice.getNotes() != null) {
				Notes note = notesServices
						.getNotesById(outputMoneyPaymentDevice.getNotes()
								.getId());
				Money money = new Money(note.getId(), note.getName(),
						note.getCode(), note.getValue(), "note", "OUTPUT");
				moneyList.add(money);
				for (Iterator<Notes> i = inputNotes.iterator(); i.hasNext();) {
					Notes element = i.next();
					if (element.getId() == note.getId()) {
						i.remove();
					}
				}
			} else if (outputMoneyPaymentDevice.getTokens() != null) {
				Tokens token = tokensServices
						.getTokensById(outputMoneyPaymentDevice.getTokens()
								.getId());
				Money money = new Money(token.getId(), token.getName(),
						token.getCode(), token.getValue(), "token", "OUTPUT");
				moneyList.add(money);
				for (Iterator<Tokens> i = inputTokens.iterator(); i.hasNext();) {
					Tokens element = i.next();
					if (element.getId() == token.getId()) {
						i.remove();
					}
				}
			}
		}

		List<Money> moneySet = new ArrayList<Money>();

		for (Coins coin : inputCoins) {
			Money money2 = new Money(coin.getId(), coin.getName(),
					coin.getCode(), coin.getValue(), "coin", "INPUT");
			moneySet.add(money2);
		}
		for (Bills coin : inputBills) {
			Money money2 = new Money(coin.getId(), coin.getName(),
					coin.getCode(), coin.getValue(), "bill", "INPUT");
			moneySet.add(money2);
		}
		for (Notes coin : inputNotes) {
			Money money2 = new Money(coin.getId(), coin.getName(),
					coin.getCode(), coin.getValue(), "note", "INPUT");
			moneySet.add(money2);
		}
		for (Tokens coin : inputTokens) {
			Money money2 = new Money(coin.getId(), coin.getName(),
					coin.getCode(), coin.getValue(), "token", "INPUT");
			moneySet.add(money2);
		}
		for (Coins coin : outputCoins) {
			Money money2 = new Money(coin.getId(), coin.getName(),
					coin.getCode(), coin.getValue(), "coin", "OUTPUT");
			moneySet.add(money2);
		}
		for (Bills coin : outputBills) {
			Money money2 = new Money(coin.getId(), coin.getName(),
					coin.getCode(), coin.getValue(), "bill", "OUTPUT");
			moneySet.add(money2);
		}
		for (Notes coin : outputNotes) {
			Money money2 = new Money(coin.getId(), coin.getName(),
					coin.getCode(), coin.getValue(), "note", "OUTPUT");
			moneySet.add(money2);
		}
		for (Tokens coin : outputTokens) {
			Money money2 = new Money(coin.getId(), coin.getName(),
					coin.getCode(), coin.getValue(), "token", "OUTPUT");
			moneySet.add(money2);
		}

		model.addAttribute("moneyList", moneyList);
		model.addAttribute(new Money());
		model.addAttribute("modelSet", moneySet);
		model.addAttribute("paymentDeviceTypeId", paymentDeviceTypeId);

		return "viewPaymentDeviceMoney";
	}

	@RequestMapping(value = "/editOperator")
	public String editOperator(@RequestParam("id") long id,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		Operator operator = operatorServices.getOperatorById(id);

		model.addAttribute("operator", operator);

		return "editOperator";
	}

	@RequestMapping(value = "/editEstablishment")
	public String editEstablishment(@RequestParam("id") long id,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		Establishment establishment = establishmentServices
				.getEstablishmentById(id);
		String openTime = establishment.getOpenTime();
		String openTimeArr[] = openTime.split(":");
		String closeTime = establishment.getCloseTime();
		String closeTimeArr[] = closeTime.split(":");
		model.addAttribute("openHours", openTimeArr[0]);
		model.addAttribute("openMins", openTimeArr[1]);
		model.addAttribute("closeHours", closeTimeArr[0]);
		model.addAttribute("closeMins", closeTimeArr[1]);
		model.addAttribute("establishment", establishment);

		Set<StatusEstablishment> statusList = establishmentServices
				.getStatusEstablishment();
		Set<StatusEstablishment> list = new HashSet<StatusEstablishment>();
		for (StatusEstablishment statusEstablishment : statusList) {
			if (statusEstablishment.getId() != establishment
					.getStatusEstablishment().getId()) {
				list.add(statusEstablishment);
			}
		}

		model.addAttribute("statusList", list);

		Set<TypesEstablishment> typeList = establishmentServices
				.getTypesEstablishment();
		Set<TypesEstablishment> list1 = new HashSet<TypesEstablishment>();
		for (TypesEstablishment typeEstablishment : typeList) {
			if (typeEstablishment.getId() != establishment
					.getTypesEstablishment().getId()) {
				list1.add(typeEstablishment);
			}
		}

		model.addAttribute("statusList", list);
		model.addAttribute("typeList", list1);

		return "editEstablishment";
	}

	@RequestMapping(value = "/editTechnician")
	public String editTechnician(@RequestParam("id") long id,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		Technician technician = technicianServices.getTechnicianById(id);
		model.addAttribute("technician", technician);

		return "editTechnician";
	}

	@RequestMapping(value = "/deleteTechnician")
	public String deleteTechnician(@RequestParam("list") String str,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();

		Admin loggedAdmin = adminServices.getAdminByUsername(userName);

		str = str.substring(0, str.length() - 1);
		System.out.println(str);
		String[] str1 = str.split(",");

		for (int i = 0; i < str1.length; i++) {

			int id = Integer.parseInt(str1[i]);

			Set<Phone> phones = phoneServices.getPhoneListByTechnician(id);
			for (Phone phone : phones) {
				phoneServices.deletePhone(phone.getId());
			}
			technicianServices.deleteTechnician(id);

		}
		Set<Technician> technicianList = technicianServices
				.getTechnicianListByAdmin(loggedAdmin.getId());
		model.addAttribute("technicianActive", "technicianActive");
		model.addAttribute(new Technician());
		model.addAttribute("technicianList", technicianList);

		return "technicianAdminList";
	}

	@RequestMapping("/settings")
	public String settings(@ModelAttribute("settings") SettingsDTO settingsDTO,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) throws ParseException {

		String action = "action";

		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
		}

		return "settings";
	}

}
