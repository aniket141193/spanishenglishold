package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.TotalCounter;

public interface TotalCounterServices {
	boolean addOrUpdateTotalCounter(TotalCounter totalCounter);
	Set<TotalCounter> getTotalCounterList();
	TotalCounter getTotalCounterById(long id);
	boolean deleteTotalCounter(long Id);
	TotalCounter getTotalCounterByMachineId(long machineId);
}
