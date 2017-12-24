package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.PaymentDeviceType;

public interface PaymentDeviceTypeServices {
	boolean addOrUpdatePaymentDeviceType(PaymentDeviceType machineType);
	Set<PaymentDeviceType> getPaymentDeviceTypeList();
	PaymentDeviceType getPaymentDeviceTypeById(long id);
	boolean deletePaymentDeviceType(long Id);
	PaymentDeviceType getLastPaymentDeviceType();
	Set<PaymentDeviceType> getPaymentDeviceTypeByMachineTypeId(long machineId);
}
