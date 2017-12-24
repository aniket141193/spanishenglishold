package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.Bills;

public interface BillsServices {
	boolean addOrUpdateBills(Bills bills);
	Set<Bills> getBillsList();
	Bills getBillsById(long id);
	boolean deleteBills(long Id);
	Set<Bills> getBillsListByCountry(long countryId);
}
