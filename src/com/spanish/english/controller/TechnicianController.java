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
import org.springframework.web.bind.annotation.RequestParam;

import com.spanish.english.form.Machine;
import com.spanish.english.form.MachineProblems;
import com.spanish.english.form.RepairHistory;
import com.spanish.english.form.RepairHistoryForm;
import com.spanish.english.form.SpareParts;
import com.spanish.english.form.Technician;
import com.spanish.english.services.MachineProblemsServices;
import com.spanish.english.services.MachineServices;
import com.spanish.english.services.RepairHistoryServices;
import com.spanish.english.services.SparePartsServices;
import com.spanish.english.services.TechnicianServices;

@Controller
@RequestMapping("/technician")
public class TechnicianController {

	@Autowired
	MachineServices machineServices;

	@Autowired
	TechnicianServices technicianServices;

	@Autowired
	RepairHistoryServices repairHistoryServices;

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
		System.out.println("logged userName:" + userName);

		Technician loggedTechnician = technicianServices
				.getTechnicianByUsername(userName);

		Set<Machine> machineList = machineServices
				.getMachineListByTechnicianId(loggedTechnician.getId());

		model.addAttribute("machineActive", "machineActive");
		model.addAttribute(new Machine());
		model.addAttribute("machineList", machineList);

		return "machineTechnician";
	}

	@RequestMapping("/repairs")
	public String repairs(
			@ModelAttribute("repairHistoryForm") RepairHistoryForm repairHistoryForm,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {
		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		Technician loggedTechnician = technicianServices
				.getTechnicianByUsername(userName);

		String action = "action";
		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
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
				// lastReportHistory.setResolvedBy(loggedTechnician);
				lastReportHistory.setResolvedTime(currentTimestampLong);
				lastReportHistory.setResolvedTimeStr(currentTimestampStr);
				lastReportHistory.setDescription(repairHistoryForm
						.getDescription());

				long sparePartsIds[] = repairHistoryForm.getSpareParts();

				Set<SpareParts> sparePartsList = new HashSet<SpareParts>(0);
				if (sparePartsIds.length != 0) {
					for (int i = 0; i < sparePartsIds.length; i++) {

						SpareParts spareParts = sparePartsServices
								.getSparePartsById(sparePartsIds[i]);
						sparePartsList.add(spareParts);
					}
				}
				long machineProblemsIds = 0;
				Set<MachineProblems> machineProblemsList = new HashSet<MachineProblems>(
						0);
				MachineProblems lastAddedMP = new MachineProblems();
				machineProblemsIds = Long.parseLong(request
						.getParameter("machineProblems"));
				if (machineProblemsIds != 1) {

					MachineProblems machineProblems = machineProblemsServices
							.getMachineProblemsById(machineProblemsIds);
					machineProblemsList.add(machineProblems);

				} else {
					MachineProblems newMachineProblems = new MachineProblems();
					newMachineProblems.setDescription(repairHistoryForm
							.getOtherMachineProblems());
					machineProblemsServices
							.addOrUpdateMachineProblems(newMachineProblems);
					lastAddedMP = machineProblemsServices
							.getLastMachineProblems();
					machineProblemsList.add(lastAddedMP);
				}
				lastReportHistory.setSpareParts(sparePartsList);
				// lastReportHistory.setMachineProblems(machineProblemsList);
				repairHistoryServices
						.addOrUpdateRepairHistory(lastReportHistory);
			}
		}

		Set<RepairHistory> repairHistoryList = new HashSet<RepairHistory>();

		Set<Machine> machineList = machineServices
				.getMachineListByTechnicianId(loggedTechnician.getId());
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
		MachineProblems temporary = new MachineProblems();
		temporary.setId(1);
		temporary.setDescription("other");
		machineProblemsList.add(temporary);
		model.addAttribute(new MachineProblems());
		model.addAttribute("machineProblemsList", machineProblemsList);
		return "repairHistoryTechnician";
	}

	@RequestMapping(value = "/reportProblem")
	public String reportProblem(@RequestParam("machineId") String machineIdStr,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		String userName = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		Technician loggedTechnician = technicianServices
				.getTechnicianByUsername(userName);

		Machine machine = machineServices.getMachineById(Long
				.parseLong(machineIdStr));

		RepairHistory repairHistory = new RepairHistory();
		repairHistory.setReportedByTechnician(loggedTechnician);
		repairHistory.setMachine(machine);
		long currentTimestampLong = System.currentTimeMillis();
		repairHistory.setReportedTime(currentTimestampLong);
		String currentTimestampStr = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss")
				.format(currentTimestampLong);
		repairHistory.setStatus("pending");
		repairHistory.setReportedTimeStr(currentTimestampStr);
		repairHistoryServices.addOrUpdateRepairHistory(repairHistory);

		Set<Machine> machineList = machineServices
				.getMachineListByTechnicianId(loggedTechnician.getId());

		model.addAttribute("machineActive", "machineActive");
		model.addAttribute(new Machine());
		model.addAttribute("machineList", machineList);

		return "machineTechnician";
	}

	@RequestMapping(value = "/viewHistory")
	public String viewHistory(@RequestParam("machineId") String machineIdStr,
			HttpServletRequest request, HttpServletResponse response,
			ModelMap model) {

		Set<RepairHistory> repairHistoryList = new HashSet<RepairHistory>();

		Set<Machine> machineList = machineServices.getMachineList();
		for (Machine machine : machineList) {
			Set<RepairHistory> repairHistorys = repairHistoryServices
					.getRepairHistoryByMachineId(machine.getId());
			for (RepairHistory repairHistory2 : repairHistorys) {
				repairHistoryList.add(repairHistory2);
			}
		}

		model.addAttribute("repairHistoryList", repairHistoryList);
		return "viewHistoryTechnician";
	}
}
