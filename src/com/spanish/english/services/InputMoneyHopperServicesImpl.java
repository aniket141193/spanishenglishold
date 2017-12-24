package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.InputMoneyHopperDao;
import com.spanish.english.form.InputMoneyHopper;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Service("inputMoneyHopperServices")
public class InputMoneyHopperServicesImpl implements InputMoneyHopperServices {

	@Autowired
	InputMoneyHopperDao inputMoneyHopperDao;

	@Override
	public boolean addOrUpdateInputMoneyHopper(InputMoneyHopper inputMoneyHopper) {
		return inputMoneyHopperDao
				.addOrUpdateInputMoneyHopper(inputMoneyHopper);
	}

	@Override
	public Set<InputMoneyHopper> getInputMoneyHopperList() {
		return inputMoneyHopperDao.getInputMoneyHopperList();
	}

	@Override
	public Set<InputMoneyHopper> getInputMoneyHopperListByCoin(long coinId) {
		return inputMoneyHopperDao.getInputMoneyHopperListByCoin(coinId);
	}

	@Override
	public Set<InputMoneyHopper> getInputMoneyHopperListByNote(long noteId) {
		return inputMoneyHopperDao.getInputMoneyHopperListByNote(noteId);
	}

	@Override
	public Set<InputMoneyHopper> getInputMoneyHopperListByToken(long tokenId) {
		return inputMoneyHopperDao.getInputMoneyHopperListByToken(tokenId);
	}

	@Override
	public Set<InputMoneyHopper> getInputMoneyHopperListByBill(long billId) {
		return inputMoneyHopperDao.getInputMoneyHopperListByBill(billId);
	}

	@Override
	public Set<InputMoneyHopper> getInputMoneyHopperListByPaymentDevice(
			long paymentDeviceId) {
		// TODO Auto-generated method stub
		return null;
	}

}
