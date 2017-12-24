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

import com.spanish.english.form.BillValidator;
import com.spanish.english.form.BillValidatorType;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class BillValidatorDaoImpl implements BillValidatorDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdateBillValidator(BillValidator billValidator) {
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
	public Set<BillValidator> getBillValidatorList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(BillValidator.class);
		
		List<BillValidator> list =  c.list();
		Set<BillValidator> billValidatorList = new HashSet<BillValidator>(list);

		tx.commit();
		session.close();
		return billValidatorList;
	}

	@Override
	public BillValidator getBillValidatorById(long id) {
		Session session;
		BillValidator  billValidator = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(BillValidator.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 billValidator = (BillValidator)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return billValidator;
	}

	@Override
	public boolean deleteBillValidator(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(BillValidator.class, Id);
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
