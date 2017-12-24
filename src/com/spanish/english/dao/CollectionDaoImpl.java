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
import com.spanish.english.form.PartialCounter;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CollectionDaoImpl implements CollectionDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdateCollection(Collection billValidator) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(billValidator);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<Collection> getCollectionList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Collection.class);
		
		List<Collection> list =  c.list();
		Set<Collection> hopperTypeList = new HashSet<Collection>(list);

		tx.commit();
		session.close();
		return hopperTypeList;
	}

	@Override
	public Collection getCollectionById(long id) {
		Session session;
		Collection  hopperType = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Collection.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 hopperType = (Collection)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return hopperType;
	}

	@Override
	public boolean deleteCollection(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(Collection.class, Id);
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
	public Set<Collection> getCollectionListByMachineId(long machineId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Collection.class);
		c.createAlias("machine", "m");
		c.add(Restrictions.eq("m.id", machineId));
		
		List<Collection> list =  c.list();
		 Set<Collection> hopperType = new HashSet<Collection>(list);

		tx.commit();
		session.close();
		return hopperType;
	}

}
