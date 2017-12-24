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

import com.spanish.english.form.RepairHistory;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class RepairHistoryDaoImpl implements RepairHistoryDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addOrUpdateRepairHistory(RepairHistory repaireHistory) {
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(repaireHistory);
			tx.commit();
			session.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Set<RepairHistory> getRepairHistoryList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(RepairHistory.class);

		List<RepairHistory> list = c.list();
		Set<RepairHistory> repairHistoryList = new HashSet<RepairHistory>(list);

		tx.commit();
		session.close();
		return repairHistoryList;
	}

	@Override
	public RepairHistory getRepairHistoryById(long id) {
		Session session;
		RepairHistory repairHistory = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(RepairHistory.class);
			criteria.add(Restrictions.eq("id", id));
			Object result = criteria.uniqueResult();
			repairHistory = (RepairHistory) result;
			session.clear();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return repairHistory;
	}

	@Override
	public boolean deleteRepairHistory(long Id) {
		boolean flag = true;
		try {
			session = sessionFactory.openSession();
			Object o = session.load(RepairHistory.class, Id);
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
	public Set<RepairHistory> getRepairHistoryByMachineId(long machineId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(RepairHistory.class);
		c.createAlias("machine", "m");
		c.add(Restrictions.eq("m.id", machineId));

		List<RepairHistory> list = c.list();
		Set<RepairHistory> repairHistoryList = new HashSet<RepairHistory>(list);
		tx.commit();
		session.close();
		return repairHistoryList;
	}

	@Override
	public RepairHistory getRepairHistoryByMachineProblem(long machineProblem) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(RepairHistory.class);
		c.createAlias("machineProblems", "m");
		c.add(Restrictions.eq("m.id", machineProblem));

		RepairHistory rh = (RepairHistory) c.uniqueResult();
		tx.commit();
		session.close();
		return rh;
	}
}
