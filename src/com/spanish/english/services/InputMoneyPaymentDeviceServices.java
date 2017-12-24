package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.InputMoneyPaymentDevice;

public interface InputMoneyPaymentDeviceServices {
	boolean addOrUpdateInputMoneyPaymentDevice(InputMoneyPaymentDevice inputMoneyHopper);
	Set<InputMoneyPaymentDevice> getInputMoneyPaymentDeviceList();
	Set<InputMoneyPaymentDevice> getInputMoneyPaymentDeviceListByCoin(long coinId);
	Set<InputMoneyPaymentDevice> getInputMoneyPaymentDeviceListByNote(long noteId);
	Set<InputMoneyPaymentDevice> getInputMoneyPaymentDeviceListByToken(long tokenId);
	Set<InputMoneyPaymentDevice> getInputMoneyPaymentDeviceListByBill(long billId);
	Set<InputMoneyPaymentDevice> getInputMoneyPaymentDeviceListByPaymentDeviceType(long paymentDeviceId);
	boolean deleteInputMoneyPaymentDevice(long id);
	InputMoneyPaymentDevice getInputMoneyPaymentDeviceByCoinByPaymentDeviceType(long coinId,long paymentDeviceTypeId);
	InputMoneyPaymentDevice getInputMoneyPaymentDeviceByNoteByPaymentDeviceType(long noteId,long paymentDeviceTypeId);
	InputMoneyPaymentDevice getInputMoneyPaymentDeviceByTokenByPaymentDeviceType(long tokenId,long paymentDeviceTypeId);
	InputMoneyPaymentDevice getInputMoneyPaymentDeviceByBillByPaymentDeviceType(long billId,long paymentDeviceTypeId);

}
