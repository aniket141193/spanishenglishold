package com.spanish.english.utility;

import java.text.ParseException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.spanish.english.form.Machine;
import com.spanish.english.services.MachineServices;

public class LockMachineExe {

	@Autowired
	MachineServices machineServices;

	@Scheduled(cron = "0 15 4 * * SUN")
	public void machineSelfLock() throws ParseException {

		Set<Machine> mahines = machineServices.getMachineList();
		for (Machine machine : mahines) {
			if (!machine.getMachineStatus().equals("inStock")) {
				machine.setSelfLock(true);
				machineServices.machineUpdate(machine);
				System.out.println("done");
			}
		}

	}
}
