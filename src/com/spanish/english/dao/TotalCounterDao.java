package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.HopperType;
import com.spanish.english.form.TotalCounter;

public interface TotalCounterDao {
	boolean addOrUpdateTotalCounter(TotalCounter totalCounter);
	Set<TotalCounter> getTotalCounterList();
	TotalCounter getTotalCounterById(long id);
	boolean deleteTotalCounter(long Id);
	TotalCounter getTotalCounterByMachineId(long machineId);
}
