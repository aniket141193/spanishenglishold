package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.Machine;
import com.spanish.english.form.MachineCollection;
import com.spanish.english.form.MachinePercentageMapping;
import com.spanish.english.form.MachineUserMapping;
import com.spanish.english.form.StatusMachine;

public interface MachineDao {

	boolean addOrUpdateMachine(Machine machine);

	Set<Machine> getMachineList();

	Machine getMachineById(long id);

	boolean deleteMachine(long Id);

	Set<Machine> getMachineListByStatus(String status);

	Set<Machine> getMachineListByOperatorId(long id);

	Set<Machine> getMachineListByEstablishmentId(long id);

	Set<Machine> getMachineListByTechnicianId(long id);

	boolean machineUpdate(Machine mahine);

	Machine lastMachine();

	boolean addOrUpdateMachinePercentageMapping(MachinePercentageMapping mpm);

	MachinePercentageMapping lastMachinePercentageMapping();

	Set<MachinePercentageMapping> getMachinePercentageMappingByMachineId(
			long machineId);

	boolean deleteMachineUserMapping(long id);

	boolean deleteMachinePercentageMapping(long id);

	boolean addOrUpdateMachineUserMapping(MachineUserMapping mum);

	MachineUserMapping lastMachineUserMapping();

	MachineUserMapping getMachineUserMappingByMPMId(long id);

	Set<MachineUserMapping> getMachineUserMappingListByMachine(long machineId);

	boolean addOrUpdateMachineCollection(MachineCollection mc);

	MachineCollection lastMachineCollection();

	MachineCollection getMachineCollectionById(long id);

	Set<MachineCollection> getMachineCollectionByMachineId(long machineId);

	boolean addOrUpdateStatusMachine(StatusMachine statusMachine);

	Set<StatusMachine> getStatusMachine();

	boolean deleteStatusMachine(long Id);

	StatusMachine getStatusMachineById(long id);
}
