package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.HopperDao;
import com.spanish.english.form.Hopper;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("hopperServices")
public class HopperServicesImpl implements HopperServices{

	@Autowired
	HopperDao hopperDao;
	
	@Override
	public boolean addOrUpdateHopper(Hopper hopper) {
		return hopperDao.addOrUpdateHopper(hopper);
	}

	@Override
	public Set<Hopper> getHopperList() {
		return hopperDao.getHopperList();
	}

	@Override
	public Hopper getHopperById(long id) {
		return hopperDao.getHopperById(id);
	}

	@Override
	public boolean deleteHopper(long Id) {
		return hopperDao.deleteHopper(Id);
	}

}
