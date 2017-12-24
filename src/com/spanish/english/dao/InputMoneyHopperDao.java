package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.InputMoneyHopper;

public interface InputMoneyHopperDao {
	boolean addOrUpdateInputMoneyHopper(InputMoneyHopper inputMoneyHopper);

	Set<InputMoneyHopper> getInputMoneyHopperList();

	Set<InputMoneyHopper> getInputMoneyHopperListByCoin(long coinId);

	Set<InputMoneyHopper> getInputMoneyHopperListByNote(long noteId);

	Set<InputMoneyHopper> getInputMoneyHopperListByToken(long tokenId);

	Set<InputMoneyHopper> getInputMoneyHopperListByBill(long billId);

	Set<InputMoneyHopper> getInputMoneyHopperListByPaymentDevice(
			long paymentDeviceId);
}
