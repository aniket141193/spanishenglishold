package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.MachineType;

public interface MachineTypeDao {
	boolean addOrUpdateMachineType(MachineType machineType);
	Set<MachineType> getMachineTypeList();
	MachineType getMachineTypeById(long id);
	boolean deleteMachineType(long Id);
	MachineType getLastMachineType();
}
