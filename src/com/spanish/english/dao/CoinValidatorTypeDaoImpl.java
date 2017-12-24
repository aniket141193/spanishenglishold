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

import com.spanish.english.form.CoinValidatorType;
import com.spanish.english.form.HopperType;


@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CoinValidatorTypeDaoImpl implements CoinValidatorTypeDao{


	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdateCoinValidatorType(CoinValidatorType coinValidatorType) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(coinValidatorType);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<CoinValidatorType> getCoinValidatorTypeList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(CoinValidatorType.class);
		
		List<CoinValidatorType> list =  c.list();
		Set<CoinValidatorType> hopperTypeList = new HashSet<CoinValidatorType>(list);

		tx.commit();
		session.close();
		return hopperTypeList;
	}

	@Override
	public CoinValidatorType getCoinValidatorTypeById(long id) {
		Session session;
		CoinValidatorType  hopperType = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(CoinValidatorType.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 hopperType = (CoinValidatorType)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return hopperType;
	}

	@Override
	public boolean deleteCoinValidatorType(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(CoinValidatorType.class, Id);
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
	public CoinValidatorType getLastCoinValidatorType() {
		Session session=sessionFactory.openSession();
		CoinValidatorType result = (CoinValidatorType) session.createQuery("from CoinValidatorType ORDER BY id DESC")
                .setMaxResults(1)
                .uniqueResult();
		return result;
	}

	@Override
	public Set<CoinValidatorType> getCoinValidatorTypeByMachineType(long mtid) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(CoinValidatorType.class);
		c.createAlias("machineType", "m");
		c.add(Restrictions.eq("m.id", mtid));
		
		List<CoinValidatorType> list =  c.list();
		Set<CoinValidatorType> hopperTypeList = new HashSet<CoinValidatorType>(list);

		tx.commit();
		session.close();
		return hopperTypeList;
	}

}
