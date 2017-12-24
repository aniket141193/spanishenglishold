package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.Hopper;

public interface HopperServices {
	boolean addOrUpdateHopper(Hopper hopper);
	Set<Hopper> getHopperList();
	Hopper getHopperById(long id);
	boolean deleteHopper(long Id);
}
