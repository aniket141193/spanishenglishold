package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.InputMoneyPaymentDeviceDao;
import com.spanish.english.dao.NotesDao;
import com.spanish.english.dao.OutputMoneyPaymentDeviceDao;
import com.spanish.english.form.InputMoneyPaymentDevice;
import com.spanish.english.form.Notes;
import com.spanish.english.form.NotesCollection;
import com.spanish.english.form.OutputMoneyPaymentDevice;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Service("notesServices")
public class NotesServicesImpl implements NotesServices {

	@Autowired
	NotesDao notesDao;

	@Autowired
	InputMoneyPaymentDeviceDao inputMoneyPaymentDeviceDao;

	@Autowired
	OutputMoneyPaymentDeviceDao outputMoneyPaymentDeviceDao;

	@Override
	public boolean addOrUpdateNotes(Notes notes) {
		return notesDao.addOrUpdateNotes(notes);
	}

	@Override
	public Set<Notes> getNotesList() {
		return notesDao.getNotesList();
	}

	@Override
	public Notes getNotesById(long id) {
		return notesDao.getNotesById(id);
	}

	@Override
	public boolean deleteNotes(long Id) {
		Set<InputMoneyPaymentDevice> impd = inputMoneyPaymentDeviceDao
				.getInputMoneyPaymentDeviceListByNote(Id);
		for (InputMoneyPaymentDevice inputMoneyPaymentDevice : impd) {
			inputMoneyPaymentDeviceDao
					.deleteInputMoneyPaymentDevice(inputMoneyPaymentDevice
							.getId());
		}
		Set<OutputMoneyPaymentDevice> ompd = outputMoneyPaymentDeviceDao
				.getOutputMoneyPaymentDeviceListByNote(Id);
		for (OutputMoneyPaymentDevice outputMoneyPaymentDevice : ompd) {
			outputMoneyPaymentDeviceDao
					.deleteOutputMoneyPaymentDevice(outputMoneyPaymentDevice
							.getId());
		}
		return notesDao.deleteNotes(Id);
	}

	@Override
	public Set<Notes> getNotesListByCountry(long countryId) {
		return notesDao.getNotesListByCountry(countryId);
	}

	@Override
	public boolean addOrUpdateNotesCollection(NotesCollection nc) {
		return notesDao.addOrUpdateNotesCollection(nc);
	}

}
