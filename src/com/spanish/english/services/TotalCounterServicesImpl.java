package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.TotalCounterDao;
import com.spanish.english.form.TotalCounter;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("totalCounterServices")
public class TotalCounterServicesImpl implements TotalCounterServices{

	@Autowired
	TotalCounterDao totalCounterDao;
	
	@Override
	public boolean addOrUpdateTotalCounter(TotalCounter totalCounter) {
		return totalCounterDao.addOrUpdateTotalCounter(totalCounter);
	}

	@Override
	public Set<TotalCounter> getTotalCounterList() {
		return totalCounterDao.getTotalCounterList();
	}

	@Override
	public TotalCounter getTotalCounterById(long id) {
		return totalCounterDao.getTotalCounterById(id);
	}

	@Override
	public boolean deleteTotalCounter(long Id) {
		return totalCounterDao.deleteTotalCounter(Id);
	}

	@Override
	public TotalCounter getTotalCounterByMachineId(long machineId) {
		return totalCounterDao.getTotalCounterByMachineId(machineId);
	}

}
