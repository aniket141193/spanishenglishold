package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.PartialCounter;

public interface PartialCounterDao {
	boolean addOrUpdatePartialCounterr(PartialCounter partialCounter);
	Set<PartialCounter> getPartialCounterList();
	PartialCounter getPartialCounterById(long id);
	boolean deletePartialCounter(long Id);
	PartialCounter getPartialCounterByMachineId(long machineId);
}
