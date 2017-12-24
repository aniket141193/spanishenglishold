package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.Establishment;
import com.spanish.english.form.Machine;
import com.spanish.english.form.TempMachine;

public interface TempMachineServices {
	void saveTempMachine(TempMachine tempMachine);

	TempMachine getTempMachineByMachine(Machine machine);

	void deleteTempMachine(TempMachine tempMachine);

	TempMachine getTempMachine(long id);

	Set<TempMachine> getTempMachineListByEstablishment(
			Establishment establishment);
}
