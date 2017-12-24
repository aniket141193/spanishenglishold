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

import com.spanish.english.form.InputMoneyHopper;
import com.spanish.english.form.OutputMoneyHopper;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OutputMoneyHopperDaoImpl implements OutputMoneyHopperDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addOrUpdateOutputMoneyHopper(
			OutputMoneyHopper outputMoneyHopper) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(outputMoneyHopper);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;

	}

	@Override
	public Set<OutputMoneyHopper> getOutputMoneyHopperList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(OutputMoneyHopper.class);
		
		List<OutputMoneyHopper> list =  c.list();
		Set<OutputMoneyHopper> inputMoneyHopperList = new HashSet<OutputMoneyHopper>(list);

		tx.commit();
		session.close();
		return inputMoneyHopperList;
	}

	@Override
	public Set<OutputMoneyHopper> getOutputMoneyHopperListByCoin(long coinId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(OutputMoneyHopper.class);
		c.createAlias("coins", "c");
		c.add(Restrictions.eq("c.id", coinId));
		
		List<OutputMoneyHopper> list =  c.list();
		Set<OutputMoneyHopper> inputMoneyHopperList = new HashSet<OutputMoneyHopper>(list);

		tx.commit();
		session.close();
		return inputMoneyHopperList;
	}

	@Override
	public Set<OutputMoneyHopper> getOutputMoneyHopperListByNote(long billId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(OutputMoneyHopper.class);
		c.createAlias("notes", "n");
		c.add(Restrictions.eq("n.id", billId));
		
		List<OutputMoneyHopper> list =  c.list();
		Set<OutputMoneyHopper> inputMoneyHopperList = new HashSet<OutputMoneyHopper>(list);

		tx.commit();
		session.close();
		return inputMoneyHopperList;
	}

	@Override
	public Set<OutputMoneyHopper> getOutputMoneyHopperListByToken(long tokenId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(OutputMoneyHopper.class);
		c.createAlias("tokens", "t");
		c.add(Restrictions.eq("t.id", tokenId));
		
		List<OutputMoneyHopper> list =  c.list();
		Set<OutputMoneyHopper> inputMoneyHopperList = new HashSet<OutputMoneyHopper>(list);

		tx.commit();
		session.close();
		return inputMoneyHopperList;
	}

	@Override
	public Set<OutputMoneyHopper> getOutputMoneyHopperListByBill(long billId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(OutputMoneyHopper.class);
		c.createAlias("bills", "b");
		c.add(Restrictions.eq("b.id", billId));
		
		List<OutputMoneyHopper> list =  c.list();
		Set<OutputMoneyHopper> inputMoneyHopperList = new HashSet<OutputMoneyHopper>(list);

		tx.commit();
		session.close();
		return inputMoneyHopperList;
	}

}
