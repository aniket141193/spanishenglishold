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

import com.spanish.english.form.Tokens;
import com.spanish.english.form.TokensCollection;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TokensDaoImpl implements TokensDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addOrUpdateTokens(Tokens tokens) {
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(tokens);
			tx.commit();
			session.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Set<Tokens> getTokensList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(Tokens.class);

		List<Tokens> list = c.list();
		Set<Tokens> tokensList = new HashSet<Tokens>(list);

		tx.commit();
		session.close();
		return tokensList;
	}

	@Override
	public Tokens getTokensById(long id) {
		Session session;
		Tokens tokens = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Tokens.class);
			criteria.add(Restrictions.eq("id", id));
			Object result = criteria.uniqueResult();
			tokens = (Tokens) result;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tokens;
	}

	@Override
	public boolean deleteTokens(long Id) {
		boolean flag = true;
		try {
			session = sessionFactory.openSession();
			Object o = session.load(Tokens.class, Id);
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
	public Set<Tokens> getTokensListByCountry(long countryId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(Tokens.class);
		c.createAlias("country", "c");
		c.add(Restrictions.eq("c.id", countryId));

		List<Tokens> list = c.list();
		Set<Tokens> tokensList = new HashSet<Tokens>(list);

		tx.commit();
		session.close();
		return tokensList;
	}

	@Override
	public boolean addOrUpdateTokensCollection(TokensCollection tc) {
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(tc);
			tx.commit();
			session.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
