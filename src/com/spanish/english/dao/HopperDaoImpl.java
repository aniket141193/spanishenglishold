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

import com.spanish.english.form.Hopper;
import com.spanish.english.form.HopperType;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class HopperDaoImpl implements HopperDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdateHopper(Hopper hopper) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(hopper);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<Hopper> getHopperList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Hopper.class);
		
		List<Hopper> list =  c.list();
		Set<Hopper> hopperList = new HashSet<Hopper>(list);

		tx.commit();
		session.close();
		return hopperList;
	}

	@Override
	public Hopper getHopperById(long id) {
		Session session;
		Hopper  hopper = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Hopper.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 hopper = (Hopper)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return hopper;
	}

	@Override
	public boolean deleteHopper(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(Hopper.class, Id);
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

}
