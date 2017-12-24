package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.Notes;
import com.spanish.english.form.NotesCollection;

public interface NotesServices {
	boolean addOrUpdateNotes(Notes notes);

	Set<Notes> getNotesList();

	Notes getNotesById(long id);

	boolean deleteNotes(long Id);

	Set<Notes> getNotesListByCountry(long countryId);

	boolean addOrUpdateNotesCollection(NotesCollection nc);
}
