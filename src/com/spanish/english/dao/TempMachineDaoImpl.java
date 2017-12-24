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

import com.spanish.english.form.Establishment;
import com.spanish.english.form.Machine;
import com.spanish.english.form.TempMachine;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TempMachineDaoImpl implements TempMachineDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void saveTempMachine(TempMachine tempMachine) {
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(tempMachine);
			tx.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public TempMachine getTempMachineByMachine(Machine machine) {
		Session session;
		TempMachine tempmachine = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(TempMachine.class);
			criteria.add(Restrictions.eq("machine.id", machine.getId()));
			Object result = criteria.uniqueResult();
			tempmachine = (TempMachine) result;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempmachine;
	}

	@Override
	public void deleteTempMachine(TempMachine tempMachine) {

		try {
			session = sessionFactory.openSession();
			Object o = session.load(TempMachine.class, tempMachine.getId());
			tx = session.getTransaction();
			session.beginTransaction();
			session.delete(o);
			tx.commit();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@Override
	public TempMachine getTempMachine(long id) {
		Session session;
		TempMachine machine = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Machine.class);
			criteria.add(Restrictions.eq("id", id));
			Object result = criteria.uniqueResult();
			machine = (TempMachine) result;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return machine;
	}

	@Override
	public Set<TempMachine> getTempMachineListByEstablishment(
			Establishment establishment) {
		Session session;
		Set<TempMachine> tempmachineList = null;
		List<TempMachine> list = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(TempMachine.class);
			criteria.add(Restrictions.eq("establishment.id",
					establishment.getId()));
			list = criteria.list();
			tempmachineList = new HashSet<TempMachine>(list);
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempmachineList;
	}

}
