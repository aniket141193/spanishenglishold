package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.OutputMoneyHopper;

public interface OutputMoneyHopperServices {
	boolean addOrUpdateOutputMoneyHopper(OutputMoneyHopper outputMoneyHopper);
	Set<OutputMoneyHopper> getOutputMoneyHopperList();
	Set<OutputMoneyHopper> getOutputMoneyHopperListByCoin(long coinId);
	Set<OutputMoneyHopper> getOutputMoneyHopperListByNote(long billId);
	Set<OutputMoneyHopper> getOutputMoneyHopperListByToken(long tokenId);
	Set<OutputMoneyHopper> getOutputMoneyHopperListByBill(long billId);
}
