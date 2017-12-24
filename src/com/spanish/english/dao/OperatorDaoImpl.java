package com.spanish.english.dao;

import java.util.ArrayList;
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

import com.spanish.english.form.Operator;
import com.spanish.english.form.Role;
import com.spanish.english.form.StatusOperator;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OperatorDaoImpl implements OperatorDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean addOrUpdateOperator(Operator operator) {
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(operator);
			tx.commit();
			session.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Set<Operator> getOperatorList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(Operator.class);

		List<Operator> list = c.list();
		Set<Operator> operatorList = new HashSet<Operator>(list);

		tx.commit();
		session.close();
		return operatorList;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Operator getOperatorById(long operatorId) {
		Session session;
		Operator operator = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Operator.class);
			criteria.add(Restrictions.eq("id", operatorId));
			Object result = criteria.uniqueResult();
			operator = (Operator) result;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return operator;
	}

	@Override
	public boolean deleteOperator(long operatorId) {

		boolean flag = true;
		try {
			session = sessionFactory.openSession();
			Object o = session.load(Operator.class, operatorId);
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
	public Operator getOperatorByUsername(String username) {
		Operator operator = null;
		try {
			session = sessionFactory.openSession();
			Criteria c = session.createCriteria(Operator.class);
			c.add(Restrictions.eq("operatorUsername", username));

			operator = (Operator) c.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		if (operator != null) {
			Role r = new Role();
			r.setName("ROLE_OPERATOR");
			List<Role> roles = new ArrayList<Role>();
			roles.add(r);
			operator.setAuthorities(roles);
		}
		return operator;
	}

	@Override
	public Operator getLastOperator() {
		Session session = sessionFactory.openSession();
		Operator result = (Operator) session
				.createQuery("from Operator ORDER BY id DESC").setMaxResults(1)
				.uniqueResult();
		session.close();
		return result;
	}

	@Override
	public boolean addOrUpdateStatusOperator(StatusOperator statusMachine) {
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(statusMachine);
			tx.commit();
			session.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Set<StatusOperator> getStatusOperator() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(StatusOperator.class);

		List<StatusOperator> list = c.list();
		Set<StatusOperator> operatorList = new HashSet<StatusOperator>(list);

		tx.commit();
		session.close();
		return operatorList;
	}

	@Override
	public boolean deleteStatusOperator(long Id) {
		boolean flag = true;
		try {
			session = sessionFactory.openSession();
			Object o = session.load(StatusOperator.class, Id);
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
	public StatusOperator getStatusOperatorById(long id) {
		Session session;
		StatusOperator operator = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(StatusOperator.class);
			criteria.add(Restrictions.eq("id", id));
			Object result = criteria.uniqueResult();
			operator = (StatusOperator) result;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return operator;
	}

}
