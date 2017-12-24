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

import com.spanish.english.form.CoinValidator;
import com.spanish.english.form.CoinValidatorType;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CoinValidatorDaoImpl implements CoinValidatorDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addOrUpdateCoinValidator(CoinValidator coinValidator) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(coinValidator);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<CoinValidator> getCoinValidatorList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(CoinValidator.class);
		
		List<CoinValidator> list =  c.list();
		Set<CoinValidator> coinValidatorList = new HashSet<CoinValidator>(list);

		tx.commit();
		session.close();
		return coinValidatorList;
	}

	@Override
	public CoinValidator getCoinValidatorById(long id) {
		Session session;
		CoinValidator  coinValidator = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(CoinValidator.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 coinValidator = (CoinValidator)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return coinValidator;
	}

	@Override
	public boolean deleteCoinValidator(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(CoinValidator.class, Id);
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
