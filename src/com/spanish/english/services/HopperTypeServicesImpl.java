package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.HopperTypeDao;
import com.spanish.english.form.HopperType;
import com.spanish.english.form.MachineType;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("hopperTypeServices")
public class HopperTypeServicesImpl implements HopperTypeServices{

	@Autowired
	HopperTypeDao hopperTypeDao; 
	
	@Override
	public boolean addOrUpdateHopperType(HopperType machineType) {
		return hopperTypeDao.addOrUpdateHopperType(machineType);
	}

	@Override
	public Set<HopperType> getHopperTypeList() {
		return hopperTypeDao.getHopperTypeList();
	}

	@Override
	public HopperType getHopperTypeById(long id) {
		return hopperTypeDao.getHopperTypeById(id);
	}

	@Override
	public boolean deleteHopperType(long Id) {
		return hopperTypeDao.deleteHopperType(Id);
	}

	@Override
	public HopperType getLastHopperType() {
		return hopperTypeDao.getLastHopperType();
	}

	@Override
	public Set<HopperType> getHopperTypeByMachineId(long machineId) {
		return hopperTypeDao.getHopperTypeByMachineId(machineId);
	}

	
	

}
