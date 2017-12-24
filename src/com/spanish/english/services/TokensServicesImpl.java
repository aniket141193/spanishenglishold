package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.InputMoneyPaymentDeviceDao;
import com.spanish.english.dao.OutputMoneyPaymentDeviceDao;
import com.spanish.english.dao.TokensDao;
import com.spanish.english.form.InputMoneyPaymentDevice;
import com.spanish.english.form.OutputMoneyPaymentDevice;
import com.spanish.english.form.Tokens;
import com.spanish.english.form.TokensCollection;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Service("tokensServices")
public class TokensServicesImpl implements TokensServices {

	@Autowired
	TokensDao tokensDao;

	@Autowired
	InputMoneyPaymentDeviceDao inputMoneyPaymentDeviceDao;

	@Autowired
	OutputMoneyPaymentDeviceDao outputMoneyPaymentDeviceDao;

	@Override
	public boolean addOrUpdateTokens(Tokens tokens) {
		return tokensDao.addOrUpdateTokens(tokens);
	}

	@Override
	public Set<Tokens> getTokensList() {
		return tokensDao.getTokensList();
	}

	@Override
	public Tokens getTokensById(long id) {
		return tokensDao.getTokensById(id);
	}

	@Override
	public boolean deleteTokens(long Id) {
		Set<InputMoneyPaymentDevice> impd = inputMoneyPaymentDeviceDao
				.getInputMoneyPaymentDeviceListByToken(Id);
		for (InputMoneyPaymentDevice inputMoneyPaymentDevice : impd) {
			inputMoneyPaymentDeviceDao
					.deleteInputMoneyPaymentDevice(inputMoneyPaymentDevice
							.getId());
		}
		Set<OutputMoneyPaymentDevice> ompd = outputMoneyPaymentDeviceDao
				.getOutputMoneyPaymentDeviceListByToken(Id);
		for (OutputMoneyPaymentDevice outputMoneyPaymentDevice : ompd) {
			outputMoneyPaymentDeviceDao
					.deleteOutputMoneyPaymentDevice(outputMoneyPaymentDevice
							.getId());
		}
		return tokensDao.deleteTokens(Id);
	}

	@Override
	public Set<Tokens> getTokensListByCountry(long countryId) {
		return tokensDao.getTokensListByCountry(countryId);
	}

	@Override
	public boolean addOrUpdateTokensCollection(TokensCollection tc) {
		return tokensDao.addOrUpdateTokensCollection(tc);
	}

}
