package com.spanish.english.services;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.MachineDao;
import com.spanish.english.form.Machine;
import com.spanish.english.form.MachineCollection;
import com.spanish.english.form.MachinePercentageMapping;
import com.spanish.english.form.MachineUserMapping;
import com.spanish.english.form.StatusMachine;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Service("machineServices")
public class MachineServicesImpl implements MachineServices {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Autowired
	MachineDao machineDao;

	@Override
	public boolean addOrUpdateMachine(Machine machine) {
		return machineDao.addOrUpdateMachine(machine);
	}

	@Override
	public Set<Machine> getMachineList() {
		return machineDao.getMachineList();
	}

	@Override
	public Machine getMachineById(long id) {
		return machineDao.getMachineById(id);
	}

	@Override
	public boolean deleteMachine(long Id) {
		return machineDao.deleteMachine(Id);
	}

	@Override
	public Set<Machine> getMachineListByStatus(String status) {
		return machineDao.getMachineListByStatus(status);
	}

	@Override
	public Set<Machine> getMachineListByOperatorId(long id) {
		return machineDao.getMachineListByOperatorId(id);
	}

	@Override
	public boolean machineUpdate(Machine mahine) {
		return machineDao.machineUpdate(mahine);
	}

	@Override
	public Set<Machine> getMachineListByEstablishmentId(long id) {
		return machineDao.getMachineListByEstablishmentId(id);
	}

	@Override
	public Set<Machine> getMachineListByTechnicianId(long id) {
		return machineDao.getMachineListByTechnicianId(id);
	}

	@Override
	public Machine lastMachine() {
		return machineDao.lastMachine();
	}

	@Override
	public boolean addOrUpdateMachinePercentageMapping(
			MachinePercentageMapping mpm) {
		return machineDao.addOrUpdateMachinePercentageMapping(mpm);
	}

	@Override
	public MachinePercentageMapping lastMachinePercentageMapping() {
		return machineDao.lastMachinePercentageMapping();
	}

	@Override
	public boolean addOrUpdateMachineUserMapping(MachineUserMapping mum) {
		return machineDao.addOrUpdateMachineUserMapping(mum);
	}

	@Override
	public MachineUserMapping lastMachineUserMapping() {
		return machineDao.lastMachineUserMapping();
	}

	@Override
	public Set<MachineUserMapping> getMachineUserMappingListByMachine(
			long machineId) {
		return machineDao.getMachineUserMappingListByMachine(machineId);
	}

	@Override
	public boolean addOrUpdateMachineCollection(MachineCollection mc) {
		return machineDao.addOrUpdateMachineCollection(mc);
	}

	@Override
	public MachineCollection lastMachineCollection() {
		return machineDao.lastMachineCollection();
	}

	@Override
	public MachineCollection getMachineCollectionById(long id) {
		return machineDao.getMachineCollectionById(id);
	}

	@Override
	public Set<MachinePercentageMapping> getMachinePercentageMappingByMachineId(
			long machineId) {
		return machineDao.getMachinePercentageMappingByMachineId(machineId);
	}

	@Override
	public Set<MachineCollection> getMachineCollectionByMachineId(long machineId) {
		return machineDao.getMachineCollectionByMachineId(machineId);
	}

	@Override
	public boolean addOrUpdateStatusMachine(StatusMachine statusMachine) {
		return machineDao.addOrUpdateStatusMachine(statusMachine);
	}

	@Override
	public Set<StatusMachine> getStatusMachine() {
		return machineDao.getStatusMachine();
	}

	@Override
	public boolean deleteStatusMachine(long Id) {
		return machineDao.deleteStatusMachine(Id);
	}

	@Override
	public StatusMachine getStatusMachineById(long id) {
		return machineDao.getStatusMachineById(id);
	}

	@Override
	public boolean deleteMachineUserMapping(long id) {
		return machineDao.deleteMachineUserMapping(id);
	}

	@Override
	public boolean deleteMachinePercentageMapping(long id) {
		return machineDao.deleteMachinePercentageMapping(id);
	}

	@Override
	public MachineUserMapping getMachineUserMappingByMPMId(long id) {
		return machineDao.getMachineUserMappingByMPMId(id);
	}

}
