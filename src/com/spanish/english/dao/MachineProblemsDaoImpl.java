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
import com.spanish.english.form.MachineProblems;
import com.spanish.english.form.SpareParts;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MachineProblemsDaoImpl implements MachineProblemsDao{
	
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addOrUpdateMachineProblems(MachineProblems machineProblems) {
		boolean flag = false;
	    try{    
	    	session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(machineProblems);
			tx.commit();
			session.close();
			flag = true;
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
		return flag;
	}

	@Override
	public Set<MachineProblems> getMachineProblemsList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		
		Criteria c = session.createCriteria(MachineProblems.class);
		
		List<MachineProblems> list =  c.list();
		Set<MachineProblems> sparePartsList = new HashSet<MachineProblems>(list);

		tx.commit();
		session.close();
		return sparePartsList;
	}

	@Override
	public MachineProblems getMachineProblemsById(long machineProblemsId) {
		Session session;
		MachineProblems  spareParts = null;
		try{
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(MachineProblems.class);
			 criteria.add(Restrictions.eq("id", machineProblemsId));
			 Object result=criteria.uniqueResult();
			 spareParts = (MachineProblems)result;
			 session.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return spareParts;
	}

	@Override
	public boolean deleteMachineProblems(long machineProblemsId) {
		boolean flag = true;
		try{
		session = sessionFactory.openSession();
		Object o = session.load(MachineProblems.class, machineProblemsId);
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
	public MachineProblems getLastMachineProblems() {
		Session session=sessionFactory.openSession();
		MachineProblems result = (MachineProblems) session.createQuery("from MachineProblems ORDER BY id DESC")
                .setMaxResults(1)
                .uniqueResult();
		return result;
	}

}
