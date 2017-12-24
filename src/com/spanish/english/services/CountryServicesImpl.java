package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.CountryDao;
import com.spanish.english.form.Country;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("countryServices")
public class CountryServicesImpl implements CountryServices{

	@Autowired
	CountryDao countryDao;
	
	@Override
	public boolean addOrUpdateCountry(Country country) {
		return countryDao.addOrUpdateCountry(country);
	}

	@Override
	public Set<Country> getCountryList() {
		return countryDao.getCountryList();
	}

	@Override
	public Country getCountryById(long id) {
		return countryDao.getCountryById(id);
	}

	@Override
	public boolean deleteCountry(long Id) {
		return countryDao.deleteCountry(Id);
	}

	@Override
	public Country getLastCountry() {
		return countryDao.getLastCountry();
	}

	@Override
	public Country getCountryByName(String countryName) {
		return countryDao.getCountryByName(countryName);
	}

}
