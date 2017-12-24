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


import com.spanish.english.form.MachineType;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MachineTypeDaoImpl implements MachineTypeDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdateMachineType(MachineType machineType) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(machineType);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}
	
	@Override
	public Set<MachineType> getMachineTypeList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(MachineType.class);
		
		List<MachineType> list =  c.list();
		Set<MachineType> machineTypeList = new HashSet<MachineType>(list);

		tx.commit();
		session.close();
		return machineTypeList;
	}
	
	@Override
	public MachineType getMachineTypeById(long id) {
		Session session;
		MachineType  machineType = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(MachineType.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 machineType = (MachineType)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return machineType;
	}
	
	@Override
	public boolean deleteMachineType(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(MachineType.class, Id);
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
	public MachineType getLastMachineType() {
		Session session=sessionFactory.openSession();
		MachineType result = (MachineType) session.createQuery("from MachineType ORDER BY id DESC")
                .setMaxResults(1)
                .uniqueResult();
		return result;
	}
}
