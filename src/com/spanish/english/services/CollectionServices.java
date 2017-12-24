package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.Collection;

public interface CollectionServices {
	boolean addOrUpdateCollection(Collection billValidator);
	Set<Collection> getCollectionList();
	Collection getCollectionById(long id);
	boolean deleteCollection(long Id);
	Set<Collection> getCollectionListByMachineId(long machineId);
}
