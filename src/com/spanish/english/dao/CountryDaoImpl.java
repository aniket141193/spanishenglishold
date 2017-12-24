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

import com.spanish.english.form.Country;


@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CountryDaoImpl implements CountryDao{

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;
	
	
	@Override
	public boolean addOrUpdateCountry(Country country) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(country);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<Country> getCountryList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(Country.class);
		
		List<Country> list =  c.list();
		Set<Country> countryList = new HashSet<Country>(list);

		tx.commit();
		session.close();
		return countryList;
	}

	@Override
	public Country getCountryById(long id) {
		Session session;
		Country  country = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Country.class);
			 criteria.add(Restrictions.eq("id", id));
			 Object result=criteria.uniqueResult();
			 country = (Country)result;
			 session.clear();
			 session.close();
			 
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return country;
	}

	@Override
	public boolean deleteCountry(long Id) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(Country.class, Id);
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
	public Country getLastCountry() {
		Session session=sessionFactory.openSession();
		Country result = (Country) session.createQuery("from Country ORDER BY id DESC")
                .setMaxResults(1)
                .uniqueResult();
		return result;
	}

	@Override
	public Country getCountryByName(String countryName) {
		Session session;
		Country  country = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Country.class);
			 criteria.add(Restrictions.eq("country", countryName));
			 
			 Object result=criteria.uniqueResult();
			 country = (Country)result;
			 session.clear();
			 session.close();
			 
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return country;
	}

}
