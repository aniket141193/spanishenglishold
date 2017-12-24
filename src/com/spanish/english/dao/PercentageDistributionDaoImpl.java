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

import com.spanish.english.form.AgreedPercentage;
import com.spanish.english.form.OtherExpenses;
import com.spanish.english.form.PlayersGift;

public class PercentageDistributionDaoImpl implements PercentageDistributionDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public void addOrUpdateAgreedPercentge(AgreedPercentage agreedPercentage) {
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(agreedPercentage);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void addOrUpdatePlayersGift(PlayersGift playersGift) {
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(playersGift);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addOrUpdateOtherExpenses(OtherExpenses otherExpenses) {
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(otherExpenses);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Set<AgreedPercentage> getAgreedPercentageByMachine(long machineId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(AgreedPercentage.class);
		c.createAlias("machine", "m");
		c.add(Restrictions.eq("m.id", machineId));

		List<AgreedPercentage> list = c.list();
		Set<AgreedPercentage> repairHistoryList = new HashSet<AgreedPercentage>(
				list);
		tx.commit();
		session.close();
		return repairHistoryList;
	}

	@Override
	public Set<PlayersGift> getPlayersGiftByMachine(long machineId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(PlayersGift.class);
		c.createAlias("machine", "m");
		c.add(Restrictions.eq("m.id", machineId));

		List<PlayersGift> list = c.list();
		Set<PlayersGift> repairHistoryList = new HashSet<PlayersGift>(list);
		tx.commit();
		session.close();
		return repairHistoryList;
	}

	@Override
	public Set<OtherExpenses> getOtherExpensesByMachine(long machineId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(OtherExpenses.class);
		c.createAlias("machine", "m");
		c.add(Restrictions.eq("m.id", machineId));

		List<OtherExpenses> list = c.list();
		Set<OtherExpenses> repairHistoryList = new HashSet<OtherExpenses>(list);
		tx.commit();
		session.close();
		return repairHistoryList;
	}

	@Override
	public AgreedPercentage getAgreedPercentageById(long id) {
		Session session;
		AgreedPercentage repairHistory = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(AgreedPercentage.class);
			criteria.add(Restrictions.eq("id", id));
			Object result = criteria.uniqueResult();
			repairHistory = (AgreedPercentage) result;
			session.clear();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return repairHistory;
	}

	@Override
	public PlayersGift getPlayersGiftById(long id) {
		Session session;
		PlayersGift repairHistory = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(PlayersGift.class);
			criteria.add(Restrictions.eq("id", id));
			Object result = criteria.uniqueResult();
			repairHistory = (PlayersGift) result;
			session.clear();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return repairHistory;
	}

	@Override
	public OtherExpenses getOtherExpensesById(long id) {
		Session session;
		OtherExpenses repairHistory = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(OtherExpenses.class);
			criteria.add(Restrictions.eq("id", id));
			Object result = criteria.uniqueResult();
			repairHistory = (OtherExpenses) result;
			session.clear();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return repairHistory;
	}

	@Override
	public boolean deleteAgreedPercentage(long id) {
		boolean flag = true;
		try {
			session = sessionFactory.openSession();
			Object o = session.load(AgreedPercentage.class, id);
			tx = session.getTransaction();
			session.beginTransaction();
			session.delete(o);
			tx.commit();
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deletePlayersGift(long id) {
		boolean flag = true;
		try {
			session = sessionFactory.openSession();
			Object o = session.load(PlayersGift.class, id);
			tx = session.getTransaction();
			session.beginTransaction();
			session.delete(o);
			tx.commit();
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean deleteOtherExpenses(long id) {
		boolean flag = true;
		try {
			session = sessionFactory.openSession();
			Object o = session.load(OtherExpenses.class, id);
			tx = session.getTransaction();
			session.beginTransaction();
			session.delete(o);
			tx.commit();
		} catch (Exception e) {
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

}
