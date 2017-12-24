package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.Establishment;
import com.spanish.english.form.StatusEstablishment;
import com.spanish.english.form.TypesEstablishment;

public interface EstablishmentDao {

	boolean addOrUpdateEstablishment(Establishment establishment);

	Set<Establishment> getEstablishmentList();

	Establishment getEstablishmentById(long id);

	boolean deleteEstablishment(long Id);

	Establishment getEstablishmentByUsername(String username);

	Establishment getLastEstablishment();

	boolean addOrUpdateStatusEstablishment(
			StatusEstablishment statusEstablisment);

	Set<StatusEstablishment> getStatusEstablishment();

	boolean deleteStatusEstablishment(long Id);

	StatusEstablishment getStatusEstablishmentById(long id);

	boolean addOrUpdateTypesEstablishment(TypesEstablishment typesEstablisment);

	Set<TypesEstablishment> getTypesEstablishment();

	boolean deleteTypesEstablishment(long Id);

	TypesEstablishment getTypesEstablishmentById(long id);
}
