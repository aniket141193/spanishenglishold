package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.BillValidator;

public interface BillValidatorServices {
	boolean addOrUpdateBillValidator(BillValidator billValidator);
	Set<BillValidator> getBillValidatorList();
	BillValidator getBillValidatorById(long id);
	boolean deleteBillValidator(long Id);
}
