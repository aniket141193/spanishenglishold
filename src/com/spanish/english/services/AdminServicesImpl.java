package com.spanish.english.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.AdminDao;
import com.spanish.english.form.Admin;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Service("adminServices")
public class AdminServicesImpl implements AdminServices {

	@Autowired
	AdminDao adminDao;

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean login(String username, String password) {
		return adminDao.login(username, password);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Admin getAdminByUsername(String username) {
		return adminDao.getAdminByUsername(username);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Admin getUserByUsername(String username) {
		return adminDao.getUserByUsername(username);
	}

	@Override
	public boolean addOrUpdateAdmin(Admin admin) {
		return adminDao.addOrUpdateAdmin(admin);
	}

	@Override
	public boolean isAdminEmpty() {
		return adminDao.isAdminEmpty();
	}

	@Override
	public boolean checkUniqueUsername(String username) {
		return adminDao.checkUniqueUsername(username);
	}

	@Override
	public Admin getAdminById(long id) {
		return adminDao.getAdminById(id);
	}

}
