package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.CoinValidator;

public interface CoinValidatorDao {
	boolean addOrUpdateCoinValidator(CoinValidator coinValidator);
	Set<CoinValidator> getCoinValidatorList();
	CoinValidator getCoinValidatorById(long id);
	boolean deleteCoinValidator(long Id);
}
