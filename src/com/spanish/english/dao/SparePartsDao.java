package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.SpareParts;

public interface SparePartsDao {
	boolean addOrUpdateSpareParts(SpareParts spareParts);

	Set<SpareParts> getSparePartsList();

	SpareParts getSparePartsById(long sparePartsId);

	boolean deleteSpareParts(long spareartsId);

	SpareParts lastSpareParts();
}
