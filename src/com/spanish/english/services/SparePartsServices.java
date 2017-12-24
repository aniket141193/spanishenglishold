package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.SpareParts;

public interface SparePartsServices {
	boolean addOrUpdateSpareParts(SpareParts spareParts);

	Set<SpareParts> getSparePartsList();

	SpareParts getSparePartsById(long sparePartsId);

	boolean deleteSpareParts(long spareartsId);

	SpareParts lastSpareParts();
}
