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

import com.spanish.english.form.Machine;
import com.spanish.english.form.MachineCollection;
import com.spanish.english.form.MachinePercentageMapping;
import com.spanish.english.form.MachineUserMapping;
import com.spanish.english.form.StatusMachine;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MachineDaoImpl implements MachineDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean addOrUpdateMachine(Machine machine) {
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

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Set<Machine> getMachineList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(Machine.class);

		List<Machine> list = c.list();
		Set<Machine> machineList = new HashSet<Machine>(list);

		tx.commit();
		session.close();
		return machineList;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public Machine getMachineById(long id) {
		Session session;
		Machine machine = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Machine.class);
			criteria.add(Restrictions.eq("id", id));
			Object result = criteria.uniqueResult();
			machine = (Machine) result;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return machine;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean deleteMachine(long Id) {
		boolean flag = true;
		try {
			session = sessionFactory.openSession();
			Object o = session.load(Machine.class, Id);
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
	public Set<Machine> getMachineListByStatus(String status) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(Machine.class);
		c.add(Restrictions.eq("machineStatus", status));

		List<Machine> list = c.list();
		Set<Machine> machineList = new HashSet<Machine>(list);

		tx.commit();
		session.close();
		return machineList;
	}

	@Override
	public Set<Machine> getMachineListByOperatorId(long id) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(Machine.class);
		c.createAlias("operator", "o");
		c.add(Restrictions.eq("o.id", id));

		List<Machine> list = c.list();
		Set<Machine> machineList = new HashSet<Machine>(list);
		tx.commit();
		session.close();
		return machineList;
	}

	@Override
	public boolean machineUpdate(Machine mahine) {
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.merge(mahine);
			tx.commit();
			session.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Set<Machine> getMachineListByEstablishmentId(long id) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(Machine.class);
		c.createAlias("establishment", "e");
		c.add(Restrictions.eq("e.id", id));

		List<Machine> list = c.list();
		Set<Machine> machineList = new HashSet<Machine>(list);
		tx.commit();
		session.close();
		return machineList;
	}

	@Override
	public Set<Machine> getMachineListByTechnicianId(long id) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(Machine.class);
		c.createAlias("technician", "t");
		c.add(Restrictions.eq("t.id", id));

		List<Machine> list = c.list();
		Set<Machine> machineList = new HashSet<Machine>(list);
		tx.commit();
		session.close();
		return machineList;
	}

	@Override
	public Machine lastMachine() {
		Session session = sessionFactory.openSession();
		Machine result = (Machine) session
				.createQuery("from Machine ORDER BY id DESC").setMaxResults(1)
				.uniqueResult();
		session.close();
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean addOrUpdateMachinePercentageMapping(
			MachinePercentageMapping mpm) {
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(mpm);
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
	public MachinePercentageMapping lastMachinePercentageMapping() {
		Session session = sessionFactory.openSession();
		MachinePercentageMapping result = (MachinePercentageMapping) session
				.createQuery("from MachinePercentageMapping ORDER BY id DESC")
				.setMaxResults(1).uniqueResult();
		session.close();
		return result;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean addOrUpdateMachineUserMapping(MachineUserMapping mum) {
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(mum);
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
	public MachineUserMapping lastMachineUserMapping() {
		Session session = sessionFactory.openSession();
		MachineUserMapping result = (MachineUserMapping) session
				.createQuery("from MachineUserMapping ORDER BY id DESC")
				.setMaxResults(1).uniqueResult();
		session.close();
		return result;
	}

	@Override
	public Set<MachineUserMapping> getMachineUserMappingListByMachine(
			long machineId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(MachineUserMapping.class);
		c.createAlias("machine", "m");
		c.add(Restrictions.eq("m.id", machineId));

		List<MachineUserMapping> list = c.list();
		Set<MachineUserMapping> machineList = new HashSet<MachineUserMapping>(
				list);
		tx.commit();
		session.close();
		return machineList;
	}

	@Override
	public boolean addOrUpdateMachineCollection(MachineCollection mc) {
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(mc);
			tx.commit();
			session.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public MachineCollection getMachineCollectionById(long id) {
		Session session;
		MachineCollection machine = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(MachineCollection.class);
			criteria.add(Restrictions.eq("id", id));
			Object result = criteria.uniqueResult();
			machine = (MachineCollection) result;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return machine;
	}

	@Override
	public MachineCollection lastMachineCollection() {
		Session session = sessionFactory.openSession();
		MachineCollection result = (MachineCollection) session
				.createQuery("from MachineCollection ORDER BY id DESC")
				.setMaxResults(1).uniqueResult();
		session.close();
		return result;
	}

	@Override
	public Set<MachinePercentageMapping> getMachinePercentageMappingByMachineId(
			long machineId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(MachinePercentageMapping.class);
		c.createAlias("machine", "m");
		c.add(Restrictions.eq("m.id", machineId));

		List<MachinePercentageMapping> list = c.list();
		Set<MachinePercentageMapping> machineList = new HashSet<MachinePercentageMapping>(
				list);
		tx.commit();
		session.close();
		return machineList;
	}

	@Override
	public Set<MachineCollection> getMachineCollectionByMachineId(long machineId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(MachineCollection.class);
		c.createAlias("machine", "m");
		c.add(Restrictions.eq("m.id", machineId));

		List<MachineCollection> list = c.list();
		Set<MachineCollection> machineList = new HashSet<MachineCollection>(
				list);
		tx.commit();
		session.close();
		return machineList;
	}

	@Override
	public boolean addOrUpdateStatusMachine(StatusMachine statusMachine) {
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
	public Set<StatusMachine> getStatusMachine() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(StatusMachine.class);

		List<StatusMachine> list = c.list();
		Set<StatusMachine> machineList = new HashSet<StatusMachine>(list);

		tx.commit();
		session.close();
		return machineList;
	}

	@Override
	public boolean deleteStatusMachine(long Id) {
		boolean flag = true;
		try {
			session = sessionFactory.openSession();
			Object o = session.load(StatusMachine.class, Id);
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
	public StatusMachine getStatusMachineById(long id) {
		Session session;
		StatusMachine machine = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(StatusMachine.class);
			criteria.add(Restrictions.eq("id", id));
			Object result = criteria.uniqueResult();
			machine = (StatusMachine) result;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return machine;
	}

	@Override
	public boolean deleteMachineUserMapping(long id) {
		boolean flag = true;
		try {
			session = sessionFactory.openSession();
			Object o = session.load(MachineUserMapping.class, id);
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
	public boolean deleteMachinePercentageMapping(long id) {
		boolean flag = true;
		try {
			session = sessionFactory.openSession();
			Object o = session.load(MachinePercentageMapping.class, id);
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
	public MachineUserMapping getMachineUserMappingByMPMId(long id) {
		Session session;
		MachineUserMapping machine = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session
					.createCriteria(MachineUserMapping.class);
			criteria.add(Restrictions.eq("mpmId", id));
			Object result = criteria.uniqueResult();
			machine = (MachineUserMapping) result;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return machine;
	}

}
