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
import com.spanish.english.form.UsersRole;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UsersRoleDaoImpl implements UsersRoleDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	@Override
	public boolean addOrUpdateUsersRole(UsersRole users) {
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
	public Set<UsersRole> getUsersRoleList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(UsersRole.class);
		
		List<UsersRole> list =  c.list();
		Set<UsersRole> usersList = new HashSet<UsersRole>(list);

		tx.commit();
		session.close();
		return usersList;
	}

	@Override
	public UsersRole getUsersRoleById(long id) {
		Session session;
		UsersRole  users = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(UsersRole.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 users = (UsersRole)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public boolean deleteUsersRole(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(UsersRole.class, Id);
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
	public Set<UsersRole> getUsersRoleByAdminId(long adminId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(UsersRole.class);
		c.createAlias("admin", "a");
		c.add(Restrictions.eq("a.id", adminId));
		
		List<UsersRole> list =  c.list();
		Set<UsersRole> usersList = new HashSet<UsersRole>(list);
	

		tx.commit();
		session.close();
		return usersList;
	}

	@Override
	public Set<UsersRole> getUsersRoleByEstablishmentId(long establishmentId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(UsersRole.class);
		c.createAlias("establishment", "e");
		c.add(Restrictions.eq("e.id", establishmentId));
		
		List<UsersRole> list =  c.list();
		Set<UsersRole> usersList = new HashSet<UsersRole>(list);

		tx.commit();
		session.close();
		return usersList;
	}

	@Override
	public Set<UsersRole> getUsersRoleByOperatorId(long operatorId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(UsersRole.class);
		c.createAlias("operator", "o");
		c.add(Restrictions.eq("o.id", operatorId));
		
		List<UsersRole> list =  c.list();
		Set<UsersRole> usersList = new HashSet<UsersRole>(list);

		tx.commit();
		session.close();
		return usersList;
	}

}
