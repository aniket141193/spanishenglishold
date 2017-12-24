package com.spanish.english.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.form.Bills;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BillsDaoImpl implements BillsDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdateBills(Bills bills) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(bills);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<Bills> getBillsList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Bills.class);
		
		List<Bills> list =  c.list();
		Set<Bills> billsList = new HashSet<Bills>(list);

		tx.commit();
		session.close();
		return billsList;
	}

	@Override
	public Bills getBillsById(long id) {
		Session session;
		Bills  bills = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Bills.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 bills = (Bills)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return bills;
	}

	@Override
	public boolean deleteBills(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(Bills.class, Id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		}catch(Exception e){
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Set<Bills> getBillsListByCountry(long countryId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Bills.class);
		c.createAlias("country", "c");
		c.add(Restrictions.eq("c.id", countryId));
		
		List<Bills> list =  c.list();
		Set<Bills> billsList = new HashSet<Bills>(list);

		tx.commit();
		session.close();
		return billsList;
	}

}
