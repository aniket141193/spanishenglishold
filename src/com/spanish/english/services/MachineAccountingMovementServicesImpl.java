package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.MachineAccountingMovementDao;
import com.spanish.english.form.MachineAccountingMovement;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Service("machineAccountingMovementServices")
public class MachineAccountingMovementServicesImpl implements
		MachineAccountingMovementServices {

	@Autowired
	MachineAccountingMovementDao machineAccountingMovementDao;

	@Override
	public boolean addOrUpdateMachineAccountingMovement(
			MachineAccountingMovement machine) {
		return machineAccountingMovementDao
				.addOrUpdateMachineAccountingMovement(machine);
	}

	@Override
	public Set<MachineAccountingMovement> getMachineAccountingMovementList() {
		return machineAccountingMovementDao.getMachineAccountingMovementList();
	}

	@Override
	public MachineAccountingMovement getMachineAccountingMovementById(long id) {
		return machineAccountingMovementDao
				.getMachineAccountingMovementById(id);
	}

	@Override
	public boolean deleteMachineAccountingMovement(long Id) {
		return machineAccountingMovementDao.deleteMachineAccountingMovement(Id);
	}

	@Override
	public Set<MachineAccountingMovement> getMachineAccountingMovementByMachine(
			long machineId) {
		return machineAccountingMovementDao
				.getMachineAccountingMovementByMachine(machineId);
	}

}
