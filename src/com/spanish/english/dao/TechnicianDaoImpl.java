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

import com.spanish.english.form.Role;
import com.spanish.english.form.Technician;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TechnicianDaoImpl implements TechnicianDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addOrUpdateTechnician(Technician technician) {
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(technician);
			tx.commit();
			session.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Technician getTechnicianById(long id) {
		Session session;
		Technician technician = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Technician.class);
			criteria.add(Restrictions.eq("id", id));
			Object result = criteria.uniqueResult();
			technician = (Technician) result;
			session.clear();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return technician;
	}

	@Override
	public boolean deleteTechnician(long Id) {
		boolean flag = true;
		try {
			session = sessionFactory.openSession();
			Object o = session.load(Technician.class, Id);
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
	public Set<Technician> getTechnicianListByAdmin(long adminId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(Technician.class);
		c.createAlias("admin", "a");
		c.add(Restrictions.eq("a.id", adminId));

		List<Technician> list = c.list();
		Set<Technician> technicianList = new HashSet<Technician>(list);
		tx.commit();
		session.close();
		return technicianList;
	}

	@Override
	public Set<Technician> getTechnicianListByEstablishment(long establishmentId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(Technician.class);
		c.createAlias("establishment", "e");
		c.add(Restrictions.eq("e.id", establishmentId));

		List<Technician> list = c.list();
		Set<Technician> technicianList = new HashSet<Technician>(list);
		tx.commit();
		session.close();
		return technicianList;
	}

	@Override
	public Set<Technician> getTechnicianListByOperator(long operatorId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(Technician.class);
		c.createAlias("operator", "o");
		c.add(Restrictions.eq("o.id", operatorId));

		List<Technician> list = c.list();
		Set<Technician> technicianList = new HashSet<Technician>(list);
		tx.commit();
		session.close();
		return technicianList;
	}

	@Override
	public Technician getTechnicianByUsername(String username) {
		Technician technician = null;
		try {
			session = sessionFactory.openSession();
			Criteria c = session.createCriteria(Technician.class);
			c.add(Restrictions.eq("technicianUsername", username));

			technician = (Technician) c.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		if (technician != null) {
			Role r = new Role();
			r.setName("ROLE_TECHNICIAN");
			List<Role> roles = new ArrayList<Role>();
			roles.add(r);
			technician.setAuthorities(roles);
		}
		return technician;
	}

	@Override
	public Technician getLastTechnician() {
		Session session = sessionFactory.openSession();
		Technician result = (Technician) session
				.createQuery("from Technician ORDER BY id DESC")
				.setMaxResults(1).uniqueResult();
		session.close();
		return result;
	}

}
