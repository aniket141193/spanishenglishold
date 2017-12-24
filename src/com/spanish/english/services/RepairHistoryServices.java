package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.RepairHistory;

public interface RepairHistoryServices {
	boolean addOrUpdateRepairHistory(RepairHistory machineType);

	Set<RepairHistory> getRepairHistoryList();

	RepairHistory getRepairHistoryById(long id);

	boolean deleteRepairHistory(long Id);

	Set<RepairHistory> getRepairHistoryByMachineId(long machineId);

	RepairHistory getRepairHistoryByMachineProblem(long machineProblem);
}
