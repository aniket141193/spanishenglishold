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

import com.spanish.english.form.Users;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UsersDaoImpl implements UsersDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdateUsers(Users users) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(users);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<Users> getUsersList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Users.class);
		
		List<Users> list =  c.list();
		Set<Users> usersList = new HashSet<Users>(list);

		tx.commit();
		session.close();
		return usersList;
	}

	@Override
	public Users getUsersById(long id) {
		Session session;
		Users  users = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Users.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 users = (Users)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public boolean deleteUsers(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(Users.class, Id);
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
	public Set<Users> getUsersByAdminId(long adminId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Users.class);
		c.createAlias("admin", "a");
		c.add(Restrictions.eq("a.id", adminId));
		
		List<Users> list =  c.list();
		Set<Users> usersList = new HashSet<Users>(list);
	

		tx.commit();
		session.close();
		return usersList;
	}

	@Override
	public Set<Users> getUsersByEstablishmentId(long establishmentId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Users.class);
		c.createAlias("establishment", "e");
		c.add(Restrictions.eq("e.id", establishmentId));
		
		List<Users> list =  c.list();
		Set<Users> usersList = new HashSet<Users>(list);

		tx.commit();
		session.close();
		return usersList;
	}

	@Override
	public Set<Users> getUsersByOperatorId(long operatorId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Users.class);
		c.createAlias("operator", "o");
		c.add(Restrictions.eq("o.id", operatorId));
		
		List<Users> list =  c.list();
		Set<Users> usersList = new HashSet<Users>(list);

		tx.commit();
		session.close();
		return usersList;
	}

}
