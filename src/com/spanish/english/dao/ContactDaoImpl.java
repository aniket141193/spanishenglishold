package com.spanish.english.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.form.Contact;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ContactDaoImpl implements ContactDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false) 
	@Override
	public boolean login(String username, String password) {
		boolean flag=true;
	    try{  	
	    session = sessionFactory.openSession();
		Criteria c = session.createCriteria(Contact.class);
		c.add(Restrictions.eq("contactUsername",username));
		c.add(Restrictions.eq("contactPassword", password));
		Object o = c.uniqueResult();
			if(o==null){
				flag=false;
			}
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    session.close();
		return flag;	
	}

}
