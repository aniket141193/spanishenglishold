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

import com.spanish.english.form.Establishment;
import com.spanish.english.form.Role;
import com.spanish.english.form.StatusEstablishment;
import com.spanish.english.form.TypesEstablishment;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EstablishmentDaoImpl implements EstablishmentDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean addOrUpdateEstablishment(Establishment establishment) {
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			session.clear();
			tx = session.beginTransaction();
			session.saveOrUpdate(establishment);
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
	public Set<Establishment> getEstablishmentList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(Establishment.class);

		List<Establishment> list = c.list();
		Set<Establishment> establishmentList = new HashSet<Establishment>(list);

		tx.commit();
		session.close();
		return establishmentList;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Establishment getEstablishmentById(long id) {
		Session session;
		Establishment establishment = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Establishment.class);
			criteria.add(Restrictions.eq("id", id));
			Object result = criteria.uniqueResult();
			establishment = (Establishment) result;
			session.clear();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return establishment;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean deleteEstablishment(long Id) {
		boolean flag = true;
		try {
			session = sessionFactory.openSession();
			Object o = session.load(Establishment.class, Id);
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
	public Establishment getEstablishmentByUsername(String username) {
		Establishment establishment = null;
		try {
			session = sessionFactory.openSession();
			Criteria c = session.createCriteria(Establishment.class);
			c.add(Restrictions.eq("establishmentUsername", username));

			establishment = (Establishment) c.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		if (establishment != null) {
			Role r = new Role();
			r.setName("ROLE_ESTABLISHMENT");
			List<Role> roles = new ArrayList<Role>();
			roles.add(r);
			establishment.setAuthorities(roles);
		}
		return establishment;
	}

	@Override
	public Establishment getLastEstablishment() {
		Session session = sessionFactory.openSession();
		Establishment result = (Establishment) session
				.createQuery("from Establishment ORDER BY id DESC")
				.setMaxResults(1).uniqueResult();
		session.close();
		return result;
	}

	@Override
	public boolean addOrUpdateStatusEstablishment(
			StatusEstablishment statusEstablisment) {
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			session.clear();
			tx = session.beginTransaction();
			session.saveOrUpdate(statusEstablisment);
			tx.commit();
			session.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Set<StatusEstablishment> getStatusEstablishment() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(StatusEstablishment.class);

		List<StatusEstablishment> list = c.list();
		Set<StatusEstablishment> establishmentList = new HashSet<StatusEstablishment>(
				list);

		tx.commit();
		session.close();
		return establishmentList;
	}

	@Override
	public boolean deleteStatusEstablishment(long Id) {
		boolean flag = true;
		try {
			session = sessionFactory.openSession();
			Object o = session.load(StatusEstablishment.class, Id);
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
	public StatusEstablishment getStatusEstablishmentById(long id) {
		Session session;
		StatusEstablishment establishment = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session
					.createCriteria(StatusEstablishment.class);
			criteria.add(Restrictions.eq("id", id));
			Object result = criteria.uniqueResult();
			establishment = (StatusEstablishment) result;
			session.clear();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return establishment;
	}

	@Override
	public boolean addOrUpdateTypesEstablishment(
			TypesEstablishment typesEstablisment) {
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			session.clear();
			tx = session.beginTransaction();
			session.saveOrUpdate(typesEstablisment);
			tx.commit();
			session.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Set<TypesEstablishment> getTypesEstablishment() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(TypesEstablishment.class);

		List<TypesEstablishment> list = c.list();
		Set<TypesEstablishment> establishmentList = new HashSet<TypesEstablishment>(
				list);

		tx.commit();
		session.close();
		return establishmentList;
	}

	@Override
	public boolean deleteTypesEstablishment(long Id) {
		boolean flag = true;
		try {
			session = sessionFactory.openSession();
			Object o = session.load(TypesEstablishment.class, Id);
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
	public TypesEstablishment getTypesEstablishmentById(long id) {
		Session session;
		TypesEstablishment establishment = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session
					.createCriteria(TypesEstablishment.class);
			criteria.add(Restrictions.eq("id", id));
			Object result = criteria.uniqueResult();
			establishment = (TypesEstablishment) result;
			session.clear();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return establishment;
	}
}
