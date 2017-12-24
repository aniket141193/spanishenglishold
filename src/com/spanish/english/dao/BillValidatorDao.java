package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.BillValidator;

public interface BillValidatorDao {
	boolean addOrUpdateBillValidator(BillValidator billValidator);
	Set<BillValidator> getBillValidatorList();
	BillValidator getBillValidatorById(long id);
	boolean deleteBillValidator(long Id);
}
