package com.spanish.english.services;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.TempMachineDao;
import com.spanish.english.form.Establishment;
import com.spanish.english.form.Machine;
import com.spanish.english.form.TempMachine;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Service("tempMachineServices")
public class TempMachineServicesImpl implements TempMachineServices {

	@Autowired
	TempMachineDao tempMachineDao;

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void saveTempMachine(TempMachine tempMachine) {
		tempMachineDao.saveTempMachine(tempMachine);

	}

	@Override
	public TempMachine getTempMachineByMachine(Machine machine) {
		return tempMachineDao.getTempMachineByMachine(machine);
	}

	@Override
	public void deleteTempMachine(TempMachine tempMachine) {
		tempMachineDao.deleteTempMachine(tempMachine);

	}

	@Override
	public TempMachine getTempMachine(long id) {
		return tempMachineDao.getTempMachine(id);
	}

	@Override
	public Set<TempMachine> getTempMachineListByEstablishment(
			Establishment establishment) {
		return tempMachineDao.getTempMachineListByEstablishment(establishment);
	}

}
