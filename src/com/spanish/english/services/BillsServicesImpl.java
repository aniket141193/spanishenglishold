package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.BillsDao;
import com.spanish.english.form.Bills;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("billsServices")
public class BillsServicesImpl implements BillsServices{
	
	@Autowired
	BillsDao billsDao;

	@Override
	public boolean addOrUpdateBills(Bills bills) {
		return billsDao.addOrUpdateBills(bills);
	}

	@Override
	public Set<Bills> getBillsList() {
		return billsDao.getBillsList();
	}

	@Override
	public Bills getBillsById(long id) {
		return billsDao.getBillsById(id);
	}

	@Override
	public boolean deleteBills(long Id) {
		return billsDao.deleteBills(Id);
	}

	@Override
	public Set<Bills> getBillsListByCountry(long countryId) {
		return billsDao.getBillsListByCountry(countryId);
	}

}
