package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.CollectionDao;
import com.spanish.english.form.Collection;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("collectionServices")
public class CollectionServicesImpl implements CollectionServices{

	@Autowired
	CollectionDao collectionDao;
	
	@Override
	public boolean addOrUpdateCollection(Collection billValidator) {
		return collectionDao.addOrUpdateCollection(billValidator);
	}

	@Override
	public Set<Collection> getCollectionList() {
		return collectionDao.getCollectionList();
	}

	@Override
	public Collection getCollectionById(long id) {
		return collectionDao.getCollectionById(id);
	}

	@Override
	public boolean deleteCollection(long Id) {
		return collectionDao.deleteCollection(Id);
	}

	@Override
	public Set<Collection> getCollectionListByMachineId(long machineId) {
		return collectionDao.getCollectionListByMachineId(machineId);
	}

}
