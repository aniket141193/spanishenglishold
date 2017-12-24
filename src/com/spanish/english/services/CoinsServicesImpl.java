package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.CoinsDao;
import com.spanish.english.dao.InputMoneyPaymentDeviceDao;
import com.spanish.english.dao.OutputMoneyPaymentDeviceDao;
import com.spanish.english.form.Coins;
import com.spanish.english.form.CoinsCollection;
import com.spanish.english.form.InputMoneyPaymentDevice;
import com.spanish.english.form.OutputMoneyPaymentDevice;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Service("coinsServices")
public class CoinsServicesImpl implements CoinsServices {

	@Autowired
	CoinsDao coinsDao;

	@Autowired
	InputMoneyPaymentDeviceDao inputMoneyPaymentDeviceDao;

	@Autowired
	OutputMoneyPaymentDeviceDao outputMoneyPaymentDeviceDao;

	@Override
	public boolean addOrUpdateCoins(Coins coins) {
		return coinsDao.addOrUpdateCoins(coins);
	}

	@Override
	public Set<Coins> getCoinsList() {
		return coinsDao.getCoinsList();
	}

	@Override
	public Coins getCoinsById(long id) {
		return coinsDao.getCoinsById(id);
	}

	@Override
	public boolean deleteCoins(long Id) {
		Set<InputMoneyPaymentDevice> impd = inputMoneyPaymentDeviceDao
				.getInputMoneyPaymentDeviceListByCoin(Id);
		for (InputMoneyPaymentDevice inputMoneyPaymentDevice : impd) {
			inputMoneyPaymentDeviceDao
					.deleteInputMoneyPaymentDevice(inputMoneyPaymentDevice
							.getId());
		}
		Set<OutputMoneyPaymentDevice> ompd = outputMoneyPaymentDeviceDao
				.getOutputMoneyPaymentDeviceListByCoin(Id);
		for (OutputMoneyPaymentDevice outputMoneyPaymentDevice : ompd) {
			outputMoneyPaymentDeviceDao
					.deleteOutputMoneyPaymentDevice(outputMoneyPaymentDevice
							.getId());
		}
		return coinsDao.deleteCoins(Id);
	}

	@Override
	public Set<Coins> getCoinsListByCountry(long countryId) {
		return coinsDao.getCoinsListByCountry(countryId);
	}

	@Override
	public boolean addOrUpdateCoinsCollection(CoinsCollection cc) {
		return coinsDao.addOrUpdateCoinsCollection(cc);
	}

}
