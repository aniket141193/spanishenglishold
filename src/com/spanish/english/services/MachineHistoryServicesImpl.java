package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.MachineHistoryDao;
import com.spanish.english.form.MachineHistory;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Service("machineHistoryServices")
public class MachineHistoryServicesImpl implements MachineHistoryServices {

	@Autowired
	MachineHistoryDao machineHistoryDao;

	@Override
	public boolean addMachineHistory(MachineHistory machineHistory) {
		return machineHistoryDao.addMachineHistory(machineHistory);
	}

	@Override
	public Set<MachineHistory> getMachineHistoryByMachineId(long machineId) {
		return machineHistoryDao.getMachineHistoryByMachineId(machineId);
	}

}
