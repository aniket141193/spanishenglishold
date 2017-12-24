package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.MachineTypeDao;
import com.spanish.english.form.MachineType;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("machineTypeServices")
public class MachineTypeServicesImpl implements MachineTypeServices{

	@Autowired
	MachineTypeDao machineTypeDao;

	@Override
	public boolean addOrUpdateMachineType(MachineType machineType) {
		return machineTypeDao.addOrUpdateMachineType(machineType);
	}

	@Override
	public Set<MachineType> getMachineTypeList() {
		return machineTypeDao.getMachineTypeList();
	}

	@Override
	public MachineType getMachineTypeById(long id) {
		return machineTypeDao.getMachineTypeById(id);
	}

	@Override
	public boolean deleteMachineType(long Id) {
		return machineTypeDao.deleteMachineType(Id);
	}

	@Override
	public MachineType getLastMachineType() {
		return machineTypeDao.getLastMachineType();
	} 
}
