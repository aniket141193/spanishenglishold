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

import com.spanish.english.form.BillValidatorType;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BillValidatorTypeDaoImpl implements BillValidatorTypeDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	
	@Override
	public boolean addOrUpdateBillValidatorType(BillValidatorType machineType) {
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
	public Set<BillValidatorType> getBillValidatorTypeList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(BillValidatorType.class);
		
		List<BillValidatorType> list =  c.list();
		Set<BillValidatorType> hopperTypeList = new HashSet<BillValidatorType>(list);

		tx.commit();
		session.close();
		return hopperTypeList;
	}

	@Override
	public BillValidatorType getBillValidatorTypeById(long id) {
		Session session;
		BillValidatorType  hopperType = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(BillValidatorType.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 hopperType = (BillValidatorType)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return hopperType;
	}

	@Override
	public boolean deleteBillValidatorType(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(BillValidatorType.class, Id);
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
	public BillValidatorType getLastBillValidatorType() {
		Session session=sessionFactory.openSession();
		BillValidatorType result = (BillValidatorType) session.createQuery("from BillValidatorType ORDER BY id DESC")
                .setMaxResults(1)
                .uniqueResult();
		session.close();
		return result;
	}

	@Override
	public Set<BillValidatorType> getBillValidatorTypeByMachineType(long mtid) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(BillValidatorType.class);
		c.createAlias("machineType", "m");
		c.add(Restrictions.eq("m.id", mtid));
		
		List<BillValidatorType> list =  c.list();
		Set<BillValidatorType> hopperTypeList = new HashSet<BillValidatorType>(list);

		tx.commit();
		session.close();
		return hopperTypeList;
	}

}
