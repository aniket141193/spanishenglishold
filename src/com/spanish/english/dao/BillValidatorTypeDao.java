package com.spanish.english.dao;

import java.util.Set;

import com.spanish.english.form.BillValidatorType;


public interface BillValidatorTypeDao {
	boolean addOrUpdateBillValidatorType(BillValidatorType machineType);
	Set<BillValidatorType> getBillValidatorTypeList();
	BillValidatorType getBillValidatorTypeById(long id);
	boolean deleteBillValidatorType(long Id);
	BillValidatorType getLastBillValidatorType();
	Set<BillValidatorType> getBillValidatorTypeByMachineType(long mtid);
}
