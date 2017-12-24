package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.PartialCounterDao;
import com.spanish.english.form.PartialCounter;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("partialCounterServices")
public class PartialCounterServicesImpl implements PartialCounterServices{

	@Autowired
	PartialCounterDao partialCounterDao;
	
	@Override
	public boolean addOrUpdatePartialCounterr(PartialCounter partialCounter) {
		return partialCounterDao.addOrUpdatePartialCounterr(partialCounter);
	}

	@Override
	public Set<PartialCounter> getPartialCounterList() {
		return partialCounterDao.getPartialCounterList();
	}

	@Override
	public PartialCounter getPartialCounterById(long id) {
		return partialCounterDao.getPartialCounterById(id);
	}

	@Override
	public boolean deletePartialCounter(long Id) {
		return partialCounterDao.deletePartialCounter(Id);
	}

	@Override
	public PartialCounter getPartialCounterByMachineId(long machineId) {
		return partialCounterDao.getPartialCounterByMachineId(machineId);
	}

}
