package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.OutputMoneyPaymentDeviceDao;
import com.spanish.english.form.OutputMoneyPaymentDevice;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("outputMoneyPaymentDeviceServices")
public class OutputMoneyPaymentDeviceServicesImpl implements OutputMoneyPaymentDeviceServices{

	@Autowired
	OutputMoneyPaymentDeviceDao outputMoneyPaymentDeviceDao;
	
	@Override
	public boolean addOrUpdateOutputMoneyPaymentDevice(
			OutputMoneyPaymentDevice outputMoneyPaymentDevice) {
		return outputMoneyPaymentDeviceDao.addOrUpdateOutputMoneyPaymentDevice(outputMoneyPaymentDevice);
	}

	@Override
	public Set<OutputMoneyPaymentDevice> getOutputMoneyPaymentDeviceList() {
		return outputMoneyPaymentDeviceDao.getOutputMoneyPaymentDeviceList();
	}

	@Override
	public Set<OutputMoneyPaymentDevice> getOutputMoneyPaymentDeviceListByCoin(
			long coinId) {
		return outputMoneyPaymentDeviceDao.getOutputMoneyPaymentDeviceListByCoin(coinId);
	}

	@Override
	public Set<OutputMoneyPaymentDevice> getOutputMoneyPaymentDeviceListByNote(
			long noteId) {
		return outputMoneyPaymentDeviceDao.getOutputMoneyPaymentDeviceListByNote(noteId);
	}

	@Override
	public Set<OutputMoneyPaymentDevice> getOutputMoneyPaymentDeviceListByToken(
			long tokenId) {
		return outputMoneyPaymentDeviceDao.getOutputMoneyPaymentDeviceListByToken(tokenId);
	}

	@Override
	public Set<OutputMoneyPaymentDevice> getOutputMoneyPaymentDeviceListByBill(
			long billId) {
		return outputMoneyPaymentDeviceDao.getOutputMoneyPaymentDeviceListByBill(billId);
	}

	@Override
	public boolean deleteOutputMoneyPaymentDevice(long Id) {
		return outputMoneyPaymentDeviceDao.deleteOutputMoneyPaymentDevice(Id);
	}

	@Override
	public Set<OutputMoneyPaymentDevice> getOutputMoneyPaymentDeviceListByPaymentDeviceType(
			long paymentDeviceTypeId) {
		return outputMoneyPaymentDeviceDao.getOutputMoneyPaymentDeviceListByPaymentDeviceType(paymentDeviceTypeId);
	}

	@Override
	public OutputMoneyPaymentDevice getOutputMoneyPaymentDeviceByCoinByPaymentDeviceType(
			long coinId, long paymentDeviceTypeId) {
	return outputMoneyPaymentDeviceDao.getOutputMoneyPaymentDeviceByCoinByPaymentDeviceType(coinId, paymentDeviceTypeId);
	}

	@Override
	public OutputMoneyPaymentDevice getOutputMoneyPaymentDeviceByBillByPaymentDeviceType(
			long billId, long paymentDeviceTypeId) {
		return outputMoneyPaymentDeviceDao.getOutputMoneyPaymentDeviceByBillByPaymentDeviceType(billId, paymentDeviceTypeId);
	}

	@Override
	public OutputMoneyPaymentDevice getOutputMoneyPaymentDeviceByTokenByPaymentDeviceType(
			long tokenId, long paymentDeviceTypeId) {
	return outputMoneyPaymentDeviceDao.getOutputMoneyPaymentDeviceByTokenByPaymentDeviceType(tokenId, paymentDeviceTypeId);
	}

	@Override
	public OutputMoneyPaymentDevice getOutputMoneyPaymentDeviceByNoteByPaymentDeviceType(
			long noteId, long paymentDeviceTypeId) {
		return outputMoneyPaymentDeviceDao.getOutputMoneyPaymentDeviceByNoteByPaymentDeviceType(noteId, paymentDeviceTypeId);
	}

}
