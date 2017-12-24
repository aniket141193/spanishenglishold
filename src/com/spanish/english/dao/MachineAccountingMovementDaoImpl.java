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

import com.spanish.english.form.MachineAccountingMovement;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MachineAccountingMovementDaoImpl implements
		MachineAccountingMovementDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean addOrUpdateMachineAccountingMovement(
			MachineAccountingMovement machine) {
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(machine);
			tx.commit();
			session.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Set<MachineAccountingMovement> getMachineAccountingMovementList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(MachineAccountingMovement.class);

		List<MachineAccountingMovement> list = c.list();
		Set<MachineAccountingMovement> machineList = new HashSet<MachineAccountingMovement>(
				list);

		tx.commit();
		session.close();
		return machineList;
	}

	@Override
	public MachineAccountingMovement getMachineAccountingMovementById(long id) {
		Session session;
		MachineAccountingMovement machine = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session
					.createCriteria(MachineAccountingMovement.class);
			criteria.add(Restrictions.eq("id", id));
			Object result = criteria.uniqueResult();
			machine = (MachineAccountingMovement) result;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return machine;
	}

	@Override
	public boolean deleteMachineAccountingMovement(long Id) {
		boolean flag = true;
		try {
			session = sessionFactory.openSession();
			Object o = session.load(MachineAccountingMovement.class, Id);
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
	public Set<MachineAccountingMovement> getMachineAccountingMovementByMachine(
			long machineId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(MachineAccountingMovement.class);
		c.createAlias("machine", "m");
		c.add(Restrictions.eq("m.id", machineId));

		List<MachineAccountingMovement> list = c.list();
		Set<MachineAccountingMovement> machineList = new HashSet<MachineAccountingMovement>(
				list);
		tx.commit();
		session.close();
		return machineList;
	}

}
