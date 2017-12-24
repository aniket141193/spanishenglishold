package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.PartialCounter;

public interface PartialCounterServices {
	boolean addOrUpdatePartialCounterr(PartialCounter partialCounter);
	Set<PartialCounter> getPartialCounterList();
	PartialCounter getPartialCounterById(long id);
	boolean deletePartialCounter(long Id);
	PartialCounter getPartialCounterByMachineId(long machineId);
}
