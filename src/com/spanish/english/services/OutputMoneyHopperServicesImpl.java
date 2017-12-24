package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.OutputMoneyHopperDao;
import com.spanish.english.form.OutputMoneyHopper;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("outputMoneyHopperServices")
public class OutputMoneyHopperServicesImpl implements OutputMoneyHopperServices{
	
	@Autowired
	OutputMoneyHopperDao outputMoneyHopperDao;

	@Override
	public boolean addOrUpdateOutputMoneyHopper(
			OutputMoneyHopper outputMoneyHopper) {
		return outputMoneyHopperDao.addOrUpdateOutputMoneyHopper(outputMoneyHopper);
	}

	@Override
	public Set<OutputMoneyHopper> getOutputMoneyHopperList() {
		return outputMoneyHopperDao.getOutputMoneyHopperList();
	}

	@Override
	public Set<OutputMoneyHopper> getOutputMoneyHopperListByCoin(long coinId) {
		return outputMoneyHopperDao.getOutputMoneyHopperListByCoin(coinId);
	}

	@Override
	public Set<OutputMoneyHopper> getOutputMoneyHopperListByNote(long billId) {
		return outputMoneyHopperDao.getOutputMoneyHopperListByNote(billId);
	}

	@Override
	public Set<OutputMoneyHopper> getOutputMoneyHopperListByToken(long tokenId) {
		return outputMoneyHopperDao.getOutputMoneyHopperListByToken(tokenId);
	}

	@Override
	public Set<OutputMoneyHopper> getOutputMoneyHopperListByBill(long billId) {
		return outputMoneyHopperDao.getOutputMoneyHopperListByBill(billId);
	}

}
