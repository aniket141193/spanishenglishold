package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.CoinValidator;

public interface CoinValidatorServices {
	boolean addOrUpdateCoinValidator(CoinValidator coinValidator);
	Set<CoinValidator> getCoinValidatorList();
	CoinValidator getCoinValidatorById(long id);
	boolean deleteCoinValidator(long Id);
}
