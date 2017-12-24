package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.Country;

public interface CountryDao {
	boolean addOrUpdateCountry(Country country);
	Set<Country> getCountryList();
	Country getCountryById(long id);
	boolean deleteCountry(long Id);
	Country getLastCountry();
	Country getCountryByName(String countryName);
}
