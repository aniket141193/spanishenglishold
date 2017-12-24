package com.spanish.english.DTO;

import java.util.Comparator;

import com.spanish.english.form.MachineHistory;

public class MachineHistoryComparatorDESC implements Comparator<MachineHistory> {

	@Override
	public int compare(MachineHistory o1, MachineHistory o2) {
		long t1 = o1.getMovementDate().getTime();
		long t2 = o2.getMovementDate().getTime();
		if (t2 > t1) {
			return 1;
		} else {
			return -1;
		}
	}

}
