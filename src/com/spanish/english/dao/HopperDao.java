package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.Hopper;

public interface HopperDao {
	boolean addOrUpdateHopper(Hopper hopper);
	Set<Hopper> getHopperList();
	Hopper getHopperById(long id);
	boolean deleteHopper(long Id);
}
