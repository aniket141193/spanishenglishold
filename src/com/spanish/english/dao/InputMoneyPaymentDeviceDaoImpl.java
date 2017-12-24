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

import com.spanish.english.form.InputMoneyPaymentDevice;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class InputMoneyPaymentDeviceDaoImpl implements
		InputMoneyPaymentDeviceDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addOrUpdateInputMoneyPaymentDevice(
			InputMoneyPaymentDevice inputMoneyHopper) {
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(inputMoneyHopper);
			tx.commit();
			session.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Set<InputMoneyPaymentDevice> getInputMoneyPaymentDeviceList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(InputMoneyPaymentDevice.class);

		List<InputMoneyPaymentDevice> list = c.list();
		Set<InputMoneyPaymentDevice> inputMoneyHopperList = new HashSet<InputMoneyPaymentDevice>(
				list);

		tx.commit();
		session.close();
		return inputMoneyHopperList;
	}

	@Override
	public Set<InputMoneyPaymentDevice> getInputMoneyPaymentDeviceListByCoin(
			long coinId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(InputMoneyPaymentDevice.class);
		c.createAlias("coins", "c");
		c.add(Restrictions.eq("c.id", coinId));

		List<InputMoneyPaymentDevice> list = c.list();
		Set<InputMoneyPaymentDevice> inputMoneyHopperList = new HashSet<InputMoneyPaymentDevice>(
				list);

		tx.commit();
		session.close();
		return inputMoneyHopperList;
	}

	@Override
	public Set<InputMoneyPaymentDevice> getInputMoneyPaymentDeviceListByNote(
			long noteId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(InputMoneyPaymentDevice.class);
		c.createAlias("notes", "c");
		c.add(Restrictions.eq("c.id", noteId));

		List<InputMoneyPaymentDevice> list = c.list();
		Set<InputMoneyPaymentDevice> inputMoneyHopperList = new HashSet<InputMoneyPaymentDevice>(
				list);

		tx.commit();
		session.close();
		return inputMoneyHopperList;
	}

	@Override
	public Set<InputMoneyPaymentDevice> getInputMoneyPaymentDeviceListByToken(
			long tokenId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(InputMoneyPaymentDevice.class);
		c.createAlias("tokens", "c");
		c.add(Restrictions.eq("c.id", tokenId));

		List<InputMoneyPaymentDevice> list = c.list();
		Set<InputMoneyPaymentDevice> inputMoneyHopperList = new HashSet<InputMoneyPaymentDevice>(
				list);

		tx.commit();
		session.close();
		return inputMoneyHopperList;
	}

	@Override
	public Set<InputMoneyPaymentDevice> getInputMoneyPaymentDeviceListByBill(
			long billId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(InputMoneyPaymentDevice.class);
		c.createAlias("bills", "c");
		c.add(Restrictions.eq("c.id", billId));

		List<InputMoneyPaymentDevice> list = c.list();
		Set<InputMoneyPaymentDevice> inputMoneyHopperList = new HashSet<InputMoneyPaymentDevice>(
				list);

		tx.commit();
		session.close();
		return inputMoneyHopperList;
	}

	@Override
	public boolean deleteInputMoneyPaymentDevice(long id) {
		boolean flag = true;
		try {
			session = sessionFactory.openSession();
			Object o = session.load(InputMoneyPaymentDevice.class, id);
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
	public Set<InputMoneyPaymentDevice> getInputMoneyPaymentDeviceListByPaymentDeviceType(
			long paymentDeviceId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(InputMoneyPaymentDevice.class);
		c.createAlias("paymentDeviceType", "p");
		c.add(Restrictions.eq("p.id", paymentDeviceId));

		List<InputMoneyPaymentDevice> list = c.list();
		Set<InputMoneyPaymentDevice> inputMoneyHopperList = new HashSet<InputMoneyPaymentDevice>(
				list);

		tx.commit();
		session.close();
		return inputMoneyHopperList;
	}

	@Override
	public InputMoneyPaymentDevice getInputMoneyPaymentDeviceByCoinByPaymentDeviceType(
			long coinId, long paymentDeviceTypeId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(InputMoneyPaymentDevice.class);
		c.createAlias("coins", "c");
		c.add(Restrictions.eq("c.id", coinId));
		c.createAlias("paymentDeviceType", "p");
		c.add(Restrictions.eq("p.id", paymentDeviceTypeId));

		InputMoneyPaymentDevice list = (InputMoneyPaymentDevice) c
				.uniqueResult();

		tx.commit();
		session.close();
		return list;
	}

	@Override
	public InputMoneyPaymentDevice getInputMoneyPaymentDeviceByNoteByPaymentDeviceType(
			long noteId, long paymentDeviceTypeId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(InputMoneyPaymentDevice.class);
		c.createAlias("notes", "c");
		c.add(Restrictions.eq("c.id", noteId));
		c.createAlias("paymentDeviceType", "p");
		c.add(Restrictions.eq("p.id", paymentDeviceTypeId));

		InputMoneyPaymentDevice list = (InputMoneyPaymentDevice) c
				.uniqueResult();

		tx.commit();
		session.close();
		return list;
	}

	@Override
	public InputMoneyPaymentDevice getInputMoneyPaymentDeviceByTokenByPaymentDeviceType(
			long tokenId, long paymentDeviceTypeId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(InputMoneyPaymentDevice.class);
		c.createAlias("tokens", "c");
		c.add(Restrictions.eq("c.id", tokenId));
		c.createAlias("paymentDeviceType", "p");
		c.add(Restrictions.eq("p.id", paymentDeviceTypeId));

		InputMoneyPaymentDevice list = (InputMoneyPaymentDevice) c
				.uniqueResult();

		tx.commit();
		session.close();
		return list;
	}

	@Override
	public InputMoneyPaymentDevice getInputMoneyPaymentDeviceByBillByPaymentDeviceType(
			long billId, long paymentDeviceTypeId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(InputMoneyPaymentDevice.class);
		c.createAlias("bills", "c");
		c.add(Restrictions.eq("c.id", billId));
		c.createAlias("paymentDeviceType", "p");
		c.add(Restrictions.eq("p.id", paymentDeviceTypeId));

		InputMoneyPaymentDevice list = (InputMoneyPaymentDevice) c
				.uniqueResult();

		tx.commit();
		session.close();
		return list;
	}

}
