package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.MachineProblemsDao;
import com.spanish.english.form.MachineProblems;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("machineProblemsServices")
public class MachineProblemsServicesImpl implements MachineProblemsServices{
	
	@Autowired
	MachineProblemsDao machineProblemsDao;

	@Override
	public boolean addOrUpdateMachineProblems(MachineProblems machineProblems) {
		return machineProblemsDao.addOrUpdateMachineProblems(machineProblems);
	}

	@Override
	public Set<MachineProblems> getMachineProblemsList() {
		return machineProblemsDao.getMachineProblemsList();
	}

	@Override
	public MachineProblems getMachineProblemsById(long machineProblemsId) {
		return machineProblemsDao.getMachineProblemsById(machineProblemsId);
	}

	@Override
	public boolean deleteMachineProblems(long machineProblemsId) {
		return machineProblemsDao.deleteMachineProblems(machineProblemsId);
	}

	@Override
	public MachineProblems getLastMachineProblems() {
		return machineProblemsDao.getLastMachineProblems();
	}

}
