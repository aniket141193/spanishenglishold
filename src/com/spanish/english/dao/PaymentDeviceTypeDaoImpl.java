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

import com.spanish.english.form.PaymentDeviceType;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PaymentDeviceTypeDaoImpl implements PaymentDeviceTypeDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdatePaymentDeviceType(PaymentDeviceType machineType) {
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
	public Set<PaymentDeviceType> getPaymentDeviceTypeList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(PaymentDeviceType.class);
		
		List<PaymentDeviceType> list =  c.list();
		Set<PaymentDeviceType> hopperTypeList = new HashSet<PaymentDeviceType>(list);

		tx.commit();
		session.close();
		return hopperTypeList;
	}

	@Override
	public PaymentDeviceType getPaymentDeviceTypeById(long id) {
		Session session;
		PaymentDeviceType  hopperType = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(PaymentDeviceType.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 hopperType = (PaymentDeviceType)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return hopperType;
	}

	@Override
	public boolean deletePaymentDeviceType(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(PaymentDeviceType.class, Id);
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
	public PaymentDeviceType getLastPaymentDeviceType() {
		Session session=sessionFactory.openSession();
		PaymentDeviceType result = (PaymentDeviceType) session.createQuery("from PaymentDeviceType ORDER BY id DESC")
                .setMaxResults(1)
                .uniqueResult();
		return result;
	}

	@Override
	public Set<PaymentDeviceType> getPaymentDeviceTypeByMachineTypeId(long machineId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(PaymentDeviceType.class);
		c.createAlias("machineType", "m");
		c.add(Restrictions.eq("m.id", machineId));
		
		List<PaymentDeviceType> list =  c.list();
		Set<PaymentDeviceType> hopperTypeList = new HashSet<PaymentDeviceType>(list);

		tx.commit();
		session.close();
		return hopperTypeList;
	}

}
