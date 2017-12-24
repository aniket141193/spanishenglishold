package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.MachineHistory;

public interface MachineHistoryServices {
	boolean addMachineHistory(MachineHistory machineHistory);

	Set<MachineHistory> getMachineHistoryByMachineId(long machineId);
}
