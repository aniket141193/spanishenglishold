package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.Establishment;
import com.spanish.english.form.Machine;
import com.spanish.english.form.TempMachine;

public interface TempMachineDao {

	void saveTempMachine(TempMachine tempMachine);

	TempMachine getTempMachineByMachine(Machine machine);

	void deleteTempMachine(TempMachine tempMachine);

	TempMachine getTempMachine(long id);

	Set<TempMachine> getTempMachineListByEstablishment(
			Establishment establishment);
}
