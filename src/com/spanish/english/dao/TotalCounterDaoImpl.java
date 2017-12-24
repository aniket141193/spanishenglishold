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

import com.spanish.english.form.Collection;
import com.spanish.english.form.HopperType;
import com.spanish.english.form.TotalCounter;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TotalCounterDaoImpl implements TotalCounterDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdateTotalCounter(TotalCounter totalCounter) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(totalCounter);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<TotalCounter> getTotalCounterList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(TotalCounter.class);
		
		List<TotalCounter> list =  c.list();
		Set<TotalCounter> hopperTypeList = new HashSet<TotalCounter>(list);

		tx.commit();
		session.close();
		return hopperTypeList;
	}

	@Override
	public TotalCounter getTotalCounterById(long id) {
		Session session;
		TotalCounter  hopperType = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(TotalCounter.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 hopperType = (TotalCounter)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return hopperType;
	}

	@Override
	public boolean deleteTotalCounter(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(TotalCounter.class, Id);
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
	public TotalCounter getTotalCounterByMachineId(long machineId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(TotalCounter.class);
		c.createAlias("machine", "m");
		c.add(Restrictions.eq("m.id", machineId));
		
		 Object result=c.uniqueResult();
		 TotalCounter hopperType = (TotalCounter)result;

		tx.commit();
		session.close();
		return hopperType;
	}

}
