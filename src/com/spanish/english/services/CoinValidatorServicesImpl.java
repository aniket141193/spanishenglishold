package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.CoinValidatorDao;
import com.spanish.english.form.CoinValidator;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("coinValidatorServices")
public class CoinValidatorServicesImpl implements CoinValidatorServices{

	@Autowired
	CoinValidatorDao coinValidatorDao;
	
	@Override
	public boolean addOrUpdateCoinValidator(CoinValidator coinValidator) {
		return coinValidatorDao.addOrUpdateCoinValidator(coinValidator);
	}

	@Override
	public Set<CoinValidator> getCoinValidatorList() {
		return coinValidatorDao.getCoinValidatorList();
	}

	@Override
	public CoinValidator getCoinValidatorById(long id) {
		return coinValidatorDao.getCoinValidatorById(id);
	}

	@Override
	public boolean deleteCoinValidator(long Id) {
		return coinValidatorDao.deleteCoinValidator(Id);
	}

}
