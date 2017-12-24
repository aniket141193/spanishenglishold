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

import com.spanish.english.form.Notes;
import com.spanish.english.form.NotesCollection;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class NotesDaoImpl implements NotesDao {

	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public boolean addOrUpdateNotes(Notes notes) {
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(notes);
			tx.commit();
			session.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Set<Notes> getNotesList() {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(Notes.class);

		List<Notes> list = c.list();
		Set<Notes> notesList = new HashSet<Notes>(list);

		tx.commit();
		session.close();
		return notesList;
	}

	@Override
	public Notes getNotesById(long id) {
		Session session;
		Notes notes = null;
		try {
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Notes.class);
			criteria.add(Restrictions.eq("id", id));
			Object result = criteria.uniqueResult();
			notes = (Notes) result;
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return notes;
	}

	@Override
	public boolean deleteNotes(long Id) {
		boolean flag = true;
		try {
			session = sessionFactory.openSession();
			Object o = session.load(Notes.class, Id);
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
	public Set<Notes> getNotesListByCountry(long countryId) {
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

		Criteria c = session.createCriteria(Notes.class);
		c.createAlias("country", "c");
		c.add(Restrictions.eq("c.id", countryId));

		List<Notes> list = c.list();
		Set<Notes> notesList = new HashSet<Notes>(list);

		tx.commit();
		session.close();
		return notesList;
	}

	@Override
	public boolean addOrUpdateNotesCollection(NotesCollection nc) {
		boolean flag = false;
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(nc);
			tx.commit();
			session.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
