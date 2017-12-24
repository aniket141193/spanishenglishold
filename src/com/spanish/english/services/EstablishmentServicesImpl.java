package com.spanish.english.services;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.EstablishmentDao;
import com.spanish.english.form.Establishment;
import com.spanish.english.form.StatusEstablishment;
import com.spanish.english.form.TypesEstablishment;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Service("establishmentServices")
public class EstablishmentServicesImpl implements EstablishmentServices {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Autowired
	EstablishmentDao establishmentDao;

	@Override
	public boolean addOrUpdateEstablishment(Establishment establishment) {
		return establishmentDao.addOrUpdateEstablishment(establishment);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Set<Establishment> getEstablishmentList() {
		return establishmentDao.getEstablishmentList();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Establishment getEstablishmentById(long id) {
		return establishmentDao.getEstablishmentById(id);
	}

	@Override
	public boolean deleteEstablishment(long Id) {

		return establishmentDao.deleteEstablishment(Id);
	}

	@Override
	public Establishment getEstablishmentByUsername(String username) {
		return establishmentDao.getEstablishmentByUsername(username);
	}

	@Override
	public Establishment getLastEstablishment() {
		return establishmentDao.getLastEstablishment();
	}

	@Override
	public boolean addOrUpdateStatusEstablishment(
			StatusEstablishment statusEstablisment) {
		return establishmentDao
				.addOrUpdateStatusEstablishment(statusEstablisment);
	}

	@Override
	public Set<StatusEstablishment> getStatusEstablishment() {
		return establishmentDao.getStatusEstablishment();
	}

	@Override
	public boolean deleteStatusEstablishment(long Id) {
		return establishmentDao.deleteStatusEstablishment(Id);
	}

	@Override
	public StatusEstablishment getStatusEstablishmentById(long id) {
		return establishmentDao.getStatusEstablishmentById(id);
	}

	@Override
	public boolean addOrUpdateTypesEstablishment(
			TypesEstablishment typesEstablisment) {
		return establishmentDao
				.addOrUpdateTypesEstablishment(typesEstablisment);
	}

	@Override
	public Set<TypesEstablishment> getTypesEstablishment() {
		return establishmentDao.getTypesEstablishment();
	}

	@Override
	public boolean deleteTypesEstablishment(long Id) {
		return establishmentDao.deleteTypesEstablishment(Id);
	}

	@Override
	public TypesEstablishment getTypesEstablishmentById(long id) {
		return establishmentDao.getTypesEstablishmentById(id);
	}
}
