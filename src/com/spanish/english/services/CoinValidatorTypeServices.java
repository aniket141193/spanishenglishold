package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.CoinValidatorType;

public interface CoinValidatorTypeServices {
	boolean addOrUpdateCoinValidatorType(CoinValidatorType machineType);
	Set<CoinValidatorType> getCoinValidatorTypeList();
	CoinValidatorType getCoinValidatorTypeById(long id);
	boolean deleteCoinValidatorType(long Id);
	CoinValidatorType getLastCoinValidatorType();
	Set<CoinValidatorType> getCoinValidatorTypeByMachineType(long mtid);
}
