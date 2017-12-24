package com.spanish.english.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.ContactDao;


@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("contactServices")
public class ContactServicesImpl implements ContactServices{

	@Autowired
	ContactDao contactDao;
	
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@Override
	public boolean login(String username, String password) {
		return contactDao.login(username, password);
	}

}
