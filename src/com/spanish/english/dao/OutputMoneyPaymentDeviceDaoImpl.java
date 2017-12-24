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

import com.spanish.english.form.InputMoneyHopper;
import com.spanish.english.form.InputMoneyPaymentDevice;
import com.spanish.english.form.OutputMoneyPaymentDevice;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class OutputMoneyPaymentDeviceDaoImpl implements OutputMoneyPaymentDeviceDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addOrUpdateOutputMoneyPaymentDevice(
			OutputMoneyPaymentDevice outputMoneyPaymentDevice) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(outputMoneyPaymentDevice);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<OutputMoneyPaymentDevice> getOutputMoneyPaymentDeviceList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(OutputMoneyPaymentDevice.class);
		
		List<OutputMoneyPaymentDevice> list =  c.list();
		Set<OutputMoneyPaymentDevice> outputMoneyPaymentDeviceList = new HashSet<OutputMoneyPaymentDevice>(list);

		tx.commit();
		session.close();
		return outputMoneyPaymentDeviceList;
	}

	@Override
	public Set<OutputMoneyPaymentDevice> getOutputMoneyPaymentDeviceListByCoin(
			long coinId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(OutputMoneyPaymentDevice.class);
		c.createAlias("coins", "c");
		c.add(Restrictions.eq("c.id", coinId));
		
		List<OutputMoneyPaymentDevice> list =  c.list();
		Set<OutputMoneyPaymentDevice> outputMoneyPaymentDeviceList = new HashSet<OutputMoneyPaymentDevice>(list);

		tx.commit();
		session.close();
		return outputMoneyPaymentDeviceList;
	}

	@Override
	public Set<OutputMoneyPaymentDevice> getOutputMoneyPaymentDeviceListByNote(
			long noteId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(OutputMoneyPaymentDevice.class);
		c.createAlias("notes", "c");
		c.add(Restrictions.eq("c.id", noteId));
		
		List<OutputMoneyPaymentDevice> list =  c.list();
		Set<OutputMoneyPaymentDevice> outputMoneyPaymentDeviceList = new HashSet<OutputMoneyPaymentDevice>(list);

		tx.commit();
		session.close();
		return outputMoneyPaymentDeviceList;
	}

	@Override
	public Set<OutputMoneyPaymentDevice> getOutputMoneyPaymentDeviceListByToken(
			long tokenId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(OutputMoneyPaymentDevice.class);
		c.createAlias("tokens", "c");
		c.add(Restrictions.eq("c.id", tokenId));
		
		List<OutputMoneyPaymentDevice> list =  c.list();
		Set<OutputMoneyPaymentDevice> outputMoneyPaymentDeviceList = new HashSet<OutputMoneyPaymentDevice>(list);

		tx.commit();
		session.close();
		return outputMoneyPaymentDeviceList;
	}

	@Override
	public Set<OutputMoneyPaymentDevice> getOutputMoneyPaymentDeviceListByBill(
			long billId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(OutputMoneyPaymentDevice.class);
		c.createAlias("bills", "c");
		c.add(Restrictions.eq("c.id", billId));
		
		List<OutputMoneyPaymentDevice> list =  c.list();
		Set<OutputMoneyPaymentDevice> outputMoneyPaymentDeviceList = new HashSet<OutputMoneyPaymentDevice>(list);

		tx.commit();
		session.close();
		return outputMoneyPaymentDeviceList;
	}

	@Override
	public boolean deleteOutputMoneyPaymentDevice(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(OutputMoneyPaymentDevice.class, Id);
		tx = session.getTransaction();
		session.beginTransaction();
		session.delete(o);
		tx.commit();
		}catch(Exception e){
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Set<OutputMoneyPaymentDevice> getOutputMoneyPaymentDeviceListByPaymentDeviceType(
			long paymentDeviceTypeId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(OutputMoneyPaymentDevice.class);
		c.createAlias("paymentDeviceType", "p");
		c.add(Restrictions.eq("p.id", paymentDeviceTypeId));
		
		List<OutputMoneyPaymentDevice> list =  c.list();
		Set<OutputMoneyPaymentDevice> outputMoneyPaymentDeviceList = new HashSet<OutputMoneyPaymentDevice>(list);

		tx.commit();
		session.close();
		return outputMoneyPaymentDeviceList;
	}

	@Override
	public OutputMoneyPaymentDevice getOutputMoneyPaymentDeviceByCoinByPaymentDeviceType(
			long coinId, long paymentDeviceTypeId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(OutputMoneyPaymentDevice.class);
		c.createAlias("paymentDeviceType", "p");
		c.add(Restrictions.eq("p.id", paymentDeviceTypeId));
		c.createAlias("coins", "c");
		c.add(Restrictions.eq("c.id", coinId));
		
		OutputMoneyPaymentDevice list =  (OutputMoneyPaymentDevice) c.uniqueResult();
		
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public OutputMoneyPaymentDevice getOutputMoneyPaymentDeviceByBillByPaymentDeviceType(
			long billId, long paymentDeviceTypeId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(OutputMoneyPaymentDevice.class);
		c.createAlias("paymentDeviceType", "p");
		c.add(Restrictions.eq("p.id", paymentDeviceTypeId));
		c.createAlias("bills", "c");
		c.add(Restrictions.eq("c.id", billId));
		
		OutputMoneyPaymentDevice list =  (OutputMoneyPaymentDevice) c.uniqueResult();
		
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public OutputMoneyPaymentDevice getOutputMoneyPaymentDeviceByTokenByPaymentDeviceType(
			long tokenId, long paymentDeviceTypeId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(OutputMoneyPaymentDevice.class);
		c.createAlias("paymentDeviceType", "p");
		c.add(Restrictions.eq("p.id", paymentDeviceTypeId));
		c.createAlias("tokens", "c");
		c.add(Restrictions.eq("c.id", tokenId));
		
		OutputMoneyPaymentDevice list =  (OutputMoneyPaymentDevice) c.uniqueResult();
		
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public OutputMoneyPaymentDevice getOutputMoneyPaymentDeviceByNoteByPaymentDeviceType(
			long noteId, long paymentDeviceTypeId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(OutputMoneyPaymentDevice.class);
		c.createAlias("paymentDeviceType", "p");
		c.add(Restrictions.eq("p.id", paymentDeviceTypeId));
		c.createAlias("notes", "c");
		c.add(Restrictions.eq("c.id", noteId));
		
		OutputMoneyPaymentDevice list =  (OutputMoneyPaymentDevice) c.uniqueResult();
		
		tx.commit();
		session.close();
		return list;
	}

}
