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

import com.spanish.english.form.Coins;
import com.spanish.english.form.CoinsCollection;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CoinsDaoImpl implements CoinsDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addOrUpdateCoins(Coins coins) {
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(coins);
			tx.commit();
			session.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Set<Coins> getCoinsList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(Coins.class);

		List<Coins> list = c.list();
		Set<Coins> coinsList = new HashSet<Coins>(list);

		tx.commit();
		session.close();
		return coinsList;
	}

	@Override
	public Coins getCoinsById(long id) {
		Session session;
		Coins coins = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Coins.class);
			criteria.add(Restrictions.eq("id", id));
			Object result = criteria.uniqueResult();
			coins = (Coins) result;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return coins;
	}

	@Override
	public boolean deleteCoins(long Id) {
		boolean flag = true;
		try {
			session = sessionFactory.openSession();
			Object o = session.load(Coins.class, Id);
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
	public Set<Coins> getCoinsListByCountry(long countryId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(Coins.class);
		c.createAlias("country", "c");
		c.add(Restrictions.eq("c.id", countryId));

		List<Coins> list = c.list();
		Set<Coins> coinsList = new HashSet<Coins>(list);

		tx.commit();
		session.close();
		return coinsList;
	}

	@Override
	public boolean addOrUpdateCoinsCollection(CoinsCollection cc) {
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(cc);
			tx.commit();
			session.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
