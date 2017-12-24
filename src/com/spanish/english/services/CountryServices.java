package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.Country;

public interface CountryServices {
	boolean addOrUpdateCountry(Country country);
	Set<Country> getCountryList();
	Country getCountryById(long id);
	boolean deleteCountry(long Id);
	Country getLastCountry();
	Country getCountryByName(String countryName);
}
