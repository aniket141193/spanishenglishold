package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.MachineAccountingMovement;

public interface MachineAccountingMovementDao {
	boolean addOrUpdateMachineAccountingMovement(
			MachineAccountingMovement machine);

	Set<MachineAccountingMovement> getMachineAccountingMovementList();

	MachineAccountingMovement getMachineAccountingMovementById(long id);

	boolean deleteMachineAccountingMovement(long Id);

	Set<MachineAccountingMovement> getMachineAccountingMovementByMachine(
			long machineId);
}
