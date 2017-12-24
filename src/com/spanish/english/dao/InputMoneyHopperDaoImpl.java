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

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class InputMoneyHopperDaoImpl implements InputMoneyHopperDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addOrUpdateInputMoneyHopper(InputMoneyHopper inputMoneyHopper) {
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(inputMoneyHopper);
			tx.commit();
			session.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Set<InputMoneyHopper> getInputMoneyHopperList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(InputMoneyHopper.class);

		List<InputMoneyHopper> list = c.list();
		Set<InputMoneyHopper> inputMoneyHopperList = new HashSet<InputMoneyHopper>(
				list);

		tx.commit();
		session.close();
		return inputMoneyHopperList;
	}

	@Override
	public Set<InputMoneyHopper> getInputMoneyHopperListByCoin(long coinId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(InputMoneyHopper.class);
		c.createAlias("coins", "c");
		c.add(Restrictions.eq("c.id", coinId));

		List<InputMoneyHopper> list = c.list();
		Set<InputMoneyHopper> inputMoneyHopperList = new HashSet<InputMoneyHopper>(
				list);

		tx.commit();
		session.close();
		return inputMoneyHopperList;
	}

	@Override
	public Set<InputMoneyHopper> getInputMoneyHopperListByNote(long noteId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(InputMoneyHopper.class);
		c.createAlias("notes", "n");
		c.add(Restrictions.eq("n.id", noteId));

		List<InputMoneyHopper> list = c.list();
		Set<InputMoneyHopper> inputMoneyHopperList = new HashSet<InputMoneyHopper>(
				list);

		tx.commit();
		session.close();
		return inputMoneyHopperList;
	}

	@Override
	public Set<InputMoneyHopper> getInputMoneyHopperListByToken(long tokenId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(InputMoneyHopper.class);
		c.createAlias("tokens", "t");
		c.add(Restrictions.eq("t.id", tokenId));

		List<InputMoneyHopper> list = c.list();
		Set<InputMoneyHopper> inputMoneyHopperList = new HashSet<InputMoneyHopper>(
				list);

		tx.commit();
		session.close();
		return inputMoneyHopperList;
	}

	@Override
	public Set<InputMoneyHopper> getInputMoneyHopperListByBill(long billId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(InputMoneyHopper.class);
		c.createAlias("bills", "b");
		c.add(Restrictions.eq("b.id", billId));

		List<InputMoneyHopper> list = c.list();
		Set<InputMoneyHopper> inputMoneyHopperList = new HashSet<InputMoneyHopper>(
				list);

		tx.commit();
		session.close();
		return inputMoneyHopperList;
	}

	@Override
	public Set<InputMoneyHopper> getInputMoneyHopperListByPaymentDevice(
			long paymentDeviceId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(InputMoneyHopper.class);
		c.createAlias("bills", "b");
		c.add(Restrictions.eq("b.id", paymentDeviceId));

		List<InputMoneyHopper> list = c.list();
		Set<InputMoneyHopper> inputMoneyHopperList = new HashSet<InputMoneyHopper>(
				list);

		tx.commit();
		session.close();
		return inputMoneyHopperList;
	}

}
