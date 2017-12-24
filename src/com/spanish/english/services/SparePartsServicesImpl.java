package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.SparePartsDao;
import com.spanish.english.form.SpareParts;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@Service("sparePartsServices")
public class SparePartsServicesImpl implements SparePartsServices {

	@Autowired
	SparePartsDao sparePartsDao;

	@Override
	public boolean addOrUpdateSpareParts(SpareParts spareParts) {
		return sparePartsDao.addOrUpdateSpareParts(spareParts);
	}

	@Override
	public Set<SpareParts> getSparePartsList() {
		return sparePartsDao.getSparePartsList();
	}

	@Override
	public SpareParts getSparePartsById(long sparePartsId) {
		return sparePartsDao.getSparePartsById(sparePartsId);
	}

	@Override
	public boolean deleteSpareParts(long spareartsId) {
		return sparePartsDao.deleteSpareParts(spareartsId);
	}

	@Override
	public SpareParts lastSpareParts() {
		return sparePartsDao.lastSpareParts();
	}

}
