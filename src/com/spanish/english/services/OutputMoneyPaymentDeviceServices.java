package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.OutputMoneyPaymentDevice;

public interface OutputMoneyPaymentDeviceServices {
	boolean addOrUpdateOutputMoneyPaymentDevice(OutputMoneyPaymentDevice outputMoneyPaymentDevice);
	Set<OutputMoneyPaymentDevice> getOutputMoneyPaymentDeviceList();
	Set<OutputMoneyPaymentDevice> getOutputMoneyPaymentDeviceListByCoin(long coinId);
	Set<OutputMoneyPaymentDevice> getOutputMoneyPaymentDeviceListByNote(long noteId);
	Set<OutputMoneyPaymentDevice> getOutputMoneyPaymentDeviceListByToken(long tokenId);
	Set<OutputMoneyPaymentDevice> getOutputMoneyPaymentDeviceListByBill(long billId);
	Set<OutputMoneyPaymentDevice> getOutputMoneyPaymentDeviceListByPaymentDeviceType(long paymentDeviceTypeId);
	boolean deleteOutputMoneyPaymentDevice(long Id);
	OutputMoneyPaymentDevice getOutputMoneyPaymentDeviceByCoinByPaymentDeviceType(long coinId,long paymentDeviceTypeId);
	OutputMoneyPaymentDevice getOutputMoneyPaymentDeviceByBillByPaymentDeviceType(long billId,long paymentDeviceTypeId);
	OutputMoneyPaymentDevice getOutputMoneyPaymentDeviceByTokenByPaymentDeviceType(long tokenId,long paymentDeviceTypeId);
	OutputMoneyPaymentDevice getOutputMoneyPaymentDeviceByNoteByPaymentDeviceType(long noteId,long paymentDeviceTypeId);
}
