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

import com.spanish.english.form.SpareParts;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SparePartsDaoImpl implements SparePartsDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addOrUpdateSpareParts(SpareParts spareParts) {
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(spareParts);
			tx.commit();
			session.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Set<SpareParts> getSparePartsList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(SpareParts.class);

		List<SpareParts> list = c.list();
		Set<SpareParts> sparePartsList = new HashSet<SpareParts>(list);

		tx.commit();
		session.close();
		return sparePartsList;
	}

	@Override
	public SpareParts getSparePartsById(long sparePartsId) {
		Session session;
		SpareParts spareParts = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(SpareParts.class);
			criteria.add(Restrictions.eq("id", sparePartsId));
			Object result = criteria.uniqueResult();
			spareParts = (SpareParts) result;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return spareParts;
	}

	@Override
	public boolean deleteSpareParts(long spareartsId) {
		boolean flag = true;
		try {
			session = sessionFactory.openSession();
			Object o = session.load(SpareParts.class, spareartsId);
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
	public SpareParts lastSpareParts() {
		Session session = sessionFactory.openSession();
		SpareParts result = (SpareParts) session
				.createQuery("from SpareParts ORDER BY id DESC")
				.setMaxResults(1).uniqueResult();
		session.close();
		return result;
	}

}
