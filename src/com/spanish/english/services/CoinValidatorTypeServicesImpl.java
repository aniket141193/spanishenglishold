package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.CoinValidatorTypeDao;
import com.spanish.english.form.CoinValidatorType;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("coinValidatorTypeServices")
public class CoinValidatorTypeServicesImpl implements CoinValidatorTypeServices{

	@Autowired
	CoinValidatorTypeDao coinValidatorTypeDao;
	
	@Override
	public boolean addOrUpdateCoinValidatorType(CoinValidatorType machineType) {
		return coinValidatorTypeDao.addOrUpdateCoinValidatorType(machineType);
	}

	@Override
	public Set<CoinValidatorType> getCoinValidatorTypeList() {
		return coinValidatorTypeDao.getCoinValidatorTypeList();
	}

	@Override
	public CoinValidatorType getCoinValidatorTypeById(long id) {
		return coinValidatorTypeDao.getCoinValidatorTypeById(id);
	}

	@Override
	public boolean deleteCoinValidatorType(long Id) {
		return coinValidatorTypeDao.deleteCoinValidatorType(Id);
	}

	@Override
	public CoinValidatorType getLastCoinValidatorType() {
		return coinValidatorTypeDao.getLastCoinValidatorType();
	}

	@Override
	public Set<CoinValidatorType> getCoinValidatorTypeByMachineType(long mtid) {
		return coinValidatorTypeDao.getCoinValidatorTypeByMachineType(mtid);
	}

}
