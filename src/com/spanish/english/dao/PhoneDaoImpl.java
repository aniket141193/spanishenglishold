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

import com.spanish.english.form.BillValidatorType;
import com.spanish.english.form.Phone;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PhoneDaoImpl implements PhoneDao{
	
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdatePhone(Phone phone) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(phone);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}
	
	@Override
	public boolean deletePhone(long phoneId) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(Phone.class, phoneId);
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
	public Phone getPhonebyId(long phoneId) {
		Session session;
		Phone  machine = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Phone.class);
			 criteria.add(Restrictions.eq("id", phoneId));
			 Object result=criteria.uniqueResult();
			 machine = (Phone)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return machine;
	}
	
	@Override
	public Set<Phone> getPhoneListByAdmin(long adminId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Phone.class);
		c.createAlias("admin", "a");
		c.add(Restrictions.eq("a.id", adminId));
		
		List<Phone> list = c.list();
		Set<Phone> phoneList = new HashSet<Phone>(list);
		tx.commit();
		session.close();
		return phoneList;
	}
	
	@Override
	public Set<Phone> getPhoneListByOperator(long operatorId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Phone.class);
		c.createAlias("operator", "o");
		c.add(Restrictions.eq("o.id", operatorId));
		
		List<Phone> list = c.list();
		Set<Phone> phoneList = new HashSet<Phone>(list);
		tx.commit();
		session.close();
		return phoneList;
	}
	@Override
	public Set<Phone> getPhoneListByEstablishment(long establishmentId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Phone.class);
		c.createAlias("establishment", "e");
		c.add(Restrictions.eq("e.id", establishmentId));
		
		List<Phone> list = c.list();
		Set<Phone> phoneList = new HashSet<Phone>(list);
		tx.commit();
		session.close();
		return phoneList;
	}
	
	@Override
	public Set<Phone> getPhoneListByTechnician(long technicianId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Phone.class);
		c.createAlias("technician", "t");
		c.add(Restrictions.eq("t.id", technicianId));
		
		List<Phone> list = c.list();
		Set<Phone> phoneList = new HashSet<Phone>(list);
		tx.commit();
		session.close();
		return phoneList;
	}

	@Override
	public Phone getLastPhone() {
		Session session=sessionFactory.openSession();
		Phone result = (Phone) session.createQuery("from Phone ORDER BY id DESC")
                .setMaxResults(1)
                .uniqueResult();
		session.close();
		return result;
	}

	

}
