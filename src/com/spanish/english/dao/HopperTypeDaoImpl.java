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

import com.spanish.english.form.HopperType;
import com.spanish.english.form.MachineType;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class HopperTypeDaoImpl implements HopperTypeDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdateHopperType(HopperType hopperType) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(hopperType);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<HopperType> getHopperTypeList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(HopperType.class);
		
		List<HopperType> list =  c.list();
		Set<HopperType> hopperTypeList = new HashSet<HopperType>(list);

		tx.commit();
		session.close();
		return hopperTypeList;
	}

	@Override
	public HopperType getHopperTypeById(long id) {
		Session session;
		HopperType  hopperType = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(HopperType.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 hopperType = (HopperType)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return hopperType;
	}

	@Override
	public boolean deleteHopperType(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(HopperType.class, Id);
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
	public HopperType getLastHopperType() {
		Session session=sessionFactory.openSession();
		HopperType result = (HopperType) session.createQuery("from HopperType ORDER BY id DESC")
                .setMaxResults(1)
                .uniqueResult();
		return result;
	}

	@Override
	public Set<HopperType> getHopperTypeByMachineId(long machineId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(HopperType.class);
		c.createAlias("machineType", "m");
		c.add(Restrictions.eq("m.id", machineId));
		
		List<HopperType> list =  c.list();
		Set<HopperType> hopperTypeList = new HashSet<HopperType>(list);

		tx.commit();
		session.close();
		return hopperTypeList;
	}

	
	

}
