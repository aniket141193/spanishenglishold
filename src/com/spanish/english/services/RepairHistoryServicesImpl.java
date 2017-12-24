package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.RepairHistoryDao;
import com.spanish.english.form.RepairHistory;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Service("repairHistoryServices")
public class RepairHistoryServicesImpl implements RepairHistoryServices {

	@Autowired
	RepairHistoryDao repairHistoryDao;

	@Override
	public boolean addOrUpdateRepairHistory(RepairHistory machineType) {
		return repairHistoryDao.addOrUpdateRepairHistory(machineType);
	}

	@Override
	public Set<RepairHistory> getRepairHistoryList() {
		return repairHistoryDao.getRepairHistoryList();
	}

	@Override
	public RepairHistory getRepairHistoryById(long id) {
		return repairHistoryDao.getRepairHistoryById(id);
	}

	@Override
	public boolean deleteRepairHistory(long Id) {
		return repairHistoryDao.deleteRepairHistory(Id);
	}

	@Override
	public Set<RepairHistory> getRepairHistoryByMachineId(long machineId) {
		return repairHistoryDao.getRepairHistoryByMachineId(machineId);
	}

	@Override
	public RepairHistory getRepairHistoryByMachineProblem(long machineProblem) {
		return repairHistoryDao
				.getRepairHistoryByMachineProblem(machineProblem);
	}

}
