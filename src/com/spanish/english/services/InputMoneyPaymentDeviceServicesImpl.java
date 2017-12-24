package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.InputMoneyPaymentDeviceDao;
import com.spanish.english.form.InputMoneyPaymentDevice;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("inputMoneyPaymentDeviceServices")
public class InputMoneyPaymentDeviceServicesImpl implements InputMoneyPaymentDeviceServices{
	
	@Autowired
	InputMoneyPaymentDeviceDao inputMoneyPaymentDeviceDao;

	@Override
	public boolean addOrUpdateInputMoneyPaymentDevice(
			InputMoneyPaymentDevice inputMoneyHopper) {
		return inputMoneyPaymentDeviceDao.addOrUpdateInputMoneyPaymentDevice(inputMoneyHopper);
	}

	@Override
	public Set<InputMoneyPaymentDevice> getInputMoneyPaymentDeviceList() {
		return inputMoneyPaymentDeviceDao.getInputMoneyPaymentDeviceList();
	}

	@Override
	public Set<InputMoneyPaymentDevice> getInputMoneyPaymentDeviceListByCoin(
			long coinId) {
		return inputMoneyPaymentDeviceDao.getInputMoneyPaymentDeviceListByCoin(coinId);
	}

	@Override
	public Set<InputMoneyPaymentDevice> getInputMoneyPaymentDeviceListByNote(
			long noteId) {
		return inputMoneyPaymentDeviceDao.getInputMoneyPaymentDeviceListByNote(noteId);
	}

	@Override
	public Set<InputMoneyPaymentDevice> getInputMoneyPaymentDeviceListByToken(
			long tokenId) {
		return inputMoneyPaymentDeviceDao.getInputMoneyPaymentDeviceListByToken(tokenId);
	}

	@Override
	public Set<InputMoneyPaymentDevice> getInputMoneyPaymentDeviceListByBill(
			long billId) {
		return inputMoneyPaymentDeviceDao.getInputMoneyPaymentDeviceListByBill(billId);
	}

	@Override
	public boolean deleteInputMoneyPaymentDevice(long id) {
		return inputMoneyPaymentDeviceDao.deleteInputMoneyPaymentDevice(id);
	}

	@Override
	public Set<InputMoneyPaymentDevice> getInputMoneyPaymentDeviceListByPaymentDeviceType(
			long paymentDeviceId) {
		return inputMoneyPaymentDeviceDao.getInputMoneyPaymentDeviceListByPaymentDeviceType(paymentDeviceId);
	}

	@Override
	public InputMoneyPaymentDevice getInputMoneyPaymentDeviceByCoinByPaymentDeviceType(
			long coinId, long paymentDeviceTypeId) {
		return inputMoneyPaymentDeviceDao.getInputMoneyPaymentDeviceByCoinByPaymentDeviceType(coinId, paymentDeviceTypeId);
	}

	@Override
	public InputMoneyPaymentDevice getInputMoneyPaymentDeviceByNoteByPaymentDeviceType(
			long noteId, long paymentDeviceTypeId) {
		return inputMoneyPaymentDeviceDao.getInputMoneyPaymentDeviceByNoteByPaymentDeviceType(noteId, paymentDeviceTypeId);
	}

	@Override
	public InputMoneyPaymentDevice getInputMoneyPaymentDeviceByTokenByPaymentDeviceType(
			long tokenId, long paymentDeviceTypeId) {
		return inputMoneyPaymentDeviceDao.getInputMoneyPaymentDeviceByTokenByPaymentDeviceType(tokenId, paymentDeviceTypeId);
	}

	@Override
	public InputMoneyPaymentDevice getInputMoneyPaymentDeviceByBillByPaymentDeviceType(
			long billId, long paymentDeviceTypeId) {
		return inputMoneyPaymentDeviceDao.getInputMoneyPaymentDeviceByBillByPaymentDeviceType(billId, paymentDeviceTypeId);
	}

}
