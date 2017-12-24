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

import com.spanish.english.form.MachineHistory;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MachineHistoryDaoImpl implements MachineHistoryDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addMachineHistory(MachineHistory machineHistory) {
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(machineHistory);
			tx.commit();
			session.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Set<MachineHistory> getMachineHistoryByMachineId(long machineId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(MachineHistory.class);
		c.createAlias("machine", "m");
		c.add(Restrictions.eq("m.id", machineId));

		List<MachineHistory> list = c.list();
		Set<MachineHistory> machineList = new HashSet<MachineHistory>(list);
		tx.commit();
		session.close();
		return machineList;
	}

}
