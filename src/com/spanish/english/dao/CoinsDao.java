package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.Coins;
import com.spanish.english.form.CoinsCollection;

public interface CoinsDao {
	boolean addOrUpdateCoins(Coins coins);

	Set<Coins> getCoinsList();

	Coins getCoinsById(long id);

	boolean deleteCoins(long Id);

	Set<Coins> getCoinsListByCountry(long countryId);

	boolean addOrUpdateCoinsCollection(CoinsCollection cc);
}
