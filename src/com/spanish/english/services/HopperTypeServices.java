package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.HopperType;

public interface HopperTypeServices {
	boolean addOrUpdateHopperType(HopperType machineType);
	Set<HopperType> getHopperTypeList();
	HopperType getHopperTypeById(long id);
	boolean deleteHopperType(long Id);
	HopperType getLastHopperType();
	Set<HopperType> getHopperTypeByMachineId(long machineId);
}
