package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.Bills;

public interface BillsDao {
	boolean addOrUpdateBills(Bills bills);
	Set<Bills> getBillsList();
	Bills getBillsById(long id);
	boolean deleteBills(long Id);
	Set<Bills> getBillsListByCountry(long countryId);
}
