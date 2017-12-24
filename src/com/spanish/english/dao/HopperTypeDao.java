package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.HopperType;
import com.spanish.english.form.MachineType;

public interface HopperTypeDao {
	boolean addOrUpdateHopperType(HopperType machineType);
	Set<HopperType> getHopperTypeList();
	HopperType getHopperTypeById(long id);
	boolean deleteHopperType(long Id);
	HopperType getLastHopperType();
	Set<HopperType> getHopperTypeByMachineId(long machineId);
}
