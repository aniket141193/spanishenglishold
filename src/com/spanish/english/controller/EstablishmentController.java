package com.spanish.english.controller;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

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

import com.spanish.english.DTO.MachineProblemsDTO;
import com.spanish.english.form.Establishment;
import com.spanish.english.form.Machine;
import com.spanish.english.form.MachineHistory;
import com.spanish.english.form.MachineProblems;
import com.spanish.english.form.RepairHistory;
import com.spanish.english.form.Technician;
import com.spanish.english.services.CoinsServices;
import com.spanish.english.services.EstablishmentServices;
import com.spanish.english.services.InputMoneyPaymentDeviceServices;
import com.spanish.english.services.MachineHistoryServices;
import com.spanish.english.services.MachineProblemsServices;
import com.spanish.english.services.MachineServices;
import com.spanish.english.services.NotesServices;
import com.spanish.english.services.OutputMoneyPaymentDeviceServices;
import com.spanish.english.services.RepairHistoryServices;
import com.spanish.english.services.SparePartsServices;
import com.spanish.english.services.TechnicianServices;
import com.spanish.english.services.TokensServices;

@Controller
@RequestMapping("/establishment")
public class EstablishmentController {

	@Autowired
	EstablishmentServices establishmentServices;

	@Autowired
	MachineServices machineServices;

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

	@RequestMapping("/machine")
	public String machineHome(@ModelAttribute("machine") Machine machine,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();

		Establishment loggedEstablishment = establishmentServices
				.getEstablishmentByUsername(userName);

		Set<Machine> machineList = machineServices
				.getMachineListByEstablishmentId(loggedEstablishment.getId());

		model.addAttribute("machineActive", "machineActive");
		model.addAttribute(new Machine());
		model.addAttribute("machineList", machineList);
		model.addAttribute("userId", loggedEstablishment.getId());
		return "machineEstablishment";
	}

	@RequestMapping(value = "/technician")
	public String allestablishmentList(
			@ModelAttribute("technician") Technician technician,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		System.out.println("logged userName:" + userName);
		Establishment loggedEstablishment = establishmentServices
				.getEstablishmentByUsername(userName);

		String action = "action";
		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
		}

		System.out.println("Action: " + action);
		if (action != null) {
			if (action.equals("add")) {
				System.out.println("add technician");
				technician.setEstablishment(loggedEstablishment);
				technician.setTechnicianRole("ROLE_TECHNICIAN");

				if (technicianServices.addOrUpdateTechnician(technician)) {
					System.out.println("technician added");
				}
			} else if (action.equals("edit")) {
				Technician oldTechnician = technicianServices
						.getTechnicianById(technician.getId());
				oldTechnician.setAddress(technician.getAddress());

				oldTechnician.setTechnicianName(technician.getTechnicianName());
				if (technicianServices.addOrUpdateTechnician(oldTechnician)) {
					System.out.println("technician edited");
				}
			}
		}
		Set<Technician> technicianList = technicianServices
				.getTechnicianListByEstablishment(loggedEstablishment.getId());
		model.addAttribute("technicianActive", "technicianActive");
		model.addAttribute(new Technician());
		model.addAttribute("technicianList", technicianList);
		return "technicianList";
	}

	@RequestMapping(value = "/deleteTechnician")
	public String deleteMachines(@RequestParam("list") String str,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		Establishment loggedEstablishment = establishmentServices
				.getEstablishmentByUsername(userName);

		str = str.substring(0, str.length() - 1);
		System.out.println(str);
		String[] str1 = str.split(",");

		for (int i = 0; i < str1.length; i++) {

			int id = Integer.parseInt(str1[i]);
			technicianServices.deleteTechnician(id);

		}

		Set<Technician> technicianList = technicianServices
				.getTechnicianListByEstablishment(loggedEstablishment.getId());
		model.addAttribute("technicianActive", "technicianActive");
		model.addAttribute(new Technician());
		model.addAttribute("technicianList", technicianList);
		return "technicianList";
	}

	@RequestMapping("/assignMachines")
	public String assignMachines(@ModelAttribute("machine") Machine machine,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		System.out.println("logged userName:" + userName);
		Establishment loggedEstablishment = establishmentServices
				.getEstablishmentByUsername(userName);

		Set<Machine> machineList = machineServices
				.getMachineListByEstablishmentId(loggedEstablishment.getId());
		Set<Technician> technicianList = technicianServices
				.getTechnicianListByEstablishment(loggedEstablishment.getId());

		model.addAttribute("establishmentID", loggedEstablishment.getId());
		model.addAttribute("machineList", machineList);
		model.addAttribute("technicianList", technicianList);

		return "assignMachineTechnician";
	}

	@RequestMapping(value = "/assignMachined", method = RequestMethod.POST)
	public String assignMachined(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		String mID = request.getParameter("machineID");
		// String eID = request.getParameter("establishmentID");
		String tID = request.getParameter("technicianID");

		long machineID = Long.parseLong(mID);
		Machine machine = machineServices.getMachineById(machineID);

		// Establishment establishment =
		// establishmentServices.getEstablishmentById(Long.parseLong(eID));

		Technician technician = technicianServices.getTechnicianById(Long
				.parseLong(tID));

		machine.setTechnician(technician);
		machine.setMachineStatus("assignedToTechnician");

		machineServices.addOrUpdateMachine(machine);

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();

		Establishment loggedEstablishment = establishmentServices
				.getEstablishmentByUsername(userName);

		Set<Machine> machineList = machineServices
				.getMachineListByEstablishmentId(loggedEstablishment.getId());

		model.addAttribute("machineActive", "machineActive");
		model.addAttribute(new Machine());
		model.addAttribute("machineList", machineList);
		model.addAttribute("userId", loggedEstablishment.getId());
		return "machineEstablishment";
	}

	@RequestMapping(value = "/reportProblem")
	public String reportProblem(@RequestParam("machineId") String machineIdStr,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		Establishment loggedEstablishment = establishmentServices
				.getEstablishmentByUsername(userName);

		Machine machine = machineServices.getMachineById(Long
				.parseLong(machineIdStr));

		RepairHistory repairHistory = new RepairHistory();
		repairHistory.setReportedByEstablishment(loggedEstablishment);
		repairHistory.setMachine(machine);
		long currentTimestampLong = System.currentTimeMillis();
		repairHistory.setReportedTime(currentTimestampLong);
		String currentTimestampStr = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
				.format(currentTimestampLong);
		repairHistory.setStatus("pending");
		repairHistory.setReportedTimeStr(currentTimestampStr);
		repairHistoryServices.addOrUpdateRepairHistory(repairHistory);

		Set<Machine> machineList = machineServices
				.getMachineListByEstablishmentId(loggedEstablishment.getId());

		model.addAttribute("machineActive", "machineActive");
		model.addAttribute(new Machine());
		model.addAttribute("machineList", machineList);
		model.addAttribute("userId", loggedEstablishment.getId());
		return "machineEstablishment";
	}

	/*
	 * @RequestMapping(value = "/viewHistory") public String
	 * viewHistory(@RequestParam("machineId") String machineIdStr,
	 * HttpServletRequest request, HttpServletResponse response, ModelMap model)
	 * {
	 * 
	 * Set<RepairHistory> repairHistoryList = new HashSet<RepairHistory>();
	 * 
	 * Set<Machine> machineList = machineServices.getMachineList(); for (Machine
	 * machine : machineList) { Set<RepairHistory> repairHistorys =
	 * repairHistoryServices .getRepairHistoryByMachineId(machine.getId()); for
	 * (RepairHistory repairHistory2 : repairHistorys) {
	 * repairHistoryList.add(repairHistory2); } }
	 * 
	 * model.addAttribute("repairHistoryList", repairHistoryList); return
	 * "viewHistoryEstablishment"; }
	 */

	@RequestMapping(value = "/viewMachineHistory")
	public String viewMachineHistory(@RequestParam("machineId") long machineId,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		Set<MachineHistory> machineHistoryList = machineHistoryServices
				.getMachineHistoryByMachineId(machineId);

		model.addAttribute("machineHistoryList", machineHistoryList);
		return "viewMachineHistoryEstablishment";
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
		Establishment loggedEsatblishment = establishmentServices
				.getEstablishmentByUsername(userName);

		Set<MachineProblems> machineProblemsList = machineProblemsServices
				.getMachineProblemsList();

		model.addAttribute("repairHistoryList", repairHistoryList);
		model.addAttribute("machineId", machineIdStr);
		model.addAttribute("role", "establishment");
		model.addAttribute("userId", loggedEsatblishment.getId());
		model.addAttribute("machineProblemsList", machineProblemsList);
		return "viewMachineProblemEstablishment";
	}

}
