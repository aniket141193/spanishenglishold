package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.MachineProblems;

public interface MachineProblemsServices {
	boolean addOrUpdateMachineProblems(MachineProblems machineProblems);
	Set<MachineProblems> getMachineProblemsList();
	MachineProblems getMachineProblemsById(long machineProblemsId);
	boolean deleteMachineProblems(long machineProblemsId);
	MachineProblems getLastMachineProblems();
}
