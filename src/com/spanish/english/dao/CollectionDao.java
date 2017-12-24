package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.Collection;

public interface CollectionDao {
	boolean addOrUpdateCollection(Collection collection);
	Set<Collection> getCollectionList();
	Collection getCollectionById(long id);
	boolean deleteCollection(long Id);
	Set<Collection> getCollectionListByMachineId(long machineId);
}
