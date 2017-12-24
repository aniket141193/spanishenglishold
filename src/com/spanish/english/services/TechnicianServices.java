package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.Technician;

public interface TechnicianServices {
	boolean addOrUpdateTechnician(Technician establishment);

	Set<Technician> getTechnicianListByAdmin(long adminId);

	Set<Technician> getTechnicianListByEstablishment(long establishmentId);

	Set<Technician> getTechnicianListByOperator(long operatorId);

	Technician getTechnicianById(long id);

	boolean deleteTechnician(long Id);

	Technician getTechnicianByUsername(String username);

	Technician getLastTechnician();
}
