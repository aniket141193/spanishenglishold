package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.MachineHistory;

public interface MachineHistoryDao {

	boolean addMachineHistory(MachineHistory machineHistory);

	Set<MachineHistory> getMachineHistoryByMachineId(long machineId);

}
