package com.spanish.english.DTO;

import java.util.Comparator;

import com.spanish.english.form.MachineCollection;

public class MachineCollectionComparatorDESC implements
		Comparator<MachineCollection> {

	@Override
	public int compare(MachineCollection o1, MachineCollection o2) {
		long t1 = o1.getEndDate().getTime();
		long t2 = o2.getEndDate().getTime();
		if (t2 > t1) {
			return 1;
		} else {
			return -1;
		}
	}
}
