package com.spanish.english.services;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.PaymentDeviceTypeDao;
import com.spanish.english.form.PaymentDeviceType;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("paymentDeviceTypeServices")
public class PaymentDeviceTypeServicesImpl implements PaymentDeviceTypeServices{
	
	@Autowired
	PaymentDeviceTypeDao paymentDeviceTypeDao;
	
	@Override
	public boolean addOrUpdatePaymentDeviceType(PaymentDeviceType machineType) {
		return paymentDeviceTypeDao.addOrUpdatePaymentDeviceType(machineType);
	}

	@Override
	public Set<PaymentDeviceType> getPaymentDeviceTypeList() {
		return paymentDeviceTypeDao.getPaymentDeviceTypeList();
	}

	@Override
	public PaymentDeviceType getPaymentDeviceTypeById(long id) {
		return paymentDeviceTypeDao.getPaymentDeviceTypeById(id);
	}

	@Override
	public boolean deletePaymentDeviceType(long Id) {
		return paymentDeviceTypeDao.deletePaymentDeviceType(Id);
	}

	@Override
	public PaymentDeviceType getLastPaymentDeviceType() {
		return paymentDeviceTypeDao.getLastPaymentDeviceType();
	}

	@Override
	public Set<PaymentDeviceType> getPaymentDeviceTypeByMachineTypeId(long machineId) {
		return paymentDeviceTypeDao.getPaymentDeviceTypeByMachineTypeId(machineId);
	}

}
