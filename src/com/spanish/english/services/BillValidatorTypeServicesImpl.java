package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.BillValidatorTypeDao;
import com.spanish.english.form.BillValidatorType;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("billValidatorTypeServices")
public class BillValidatorTypeServicesImpl implements BillValidatorTypeServices{

	@Autowired
	BillValidatorTypeDao billValidatorTypeDao;
	
	@Override
	public boolean addOrUpdateBillValidatorType(BillValidatorType machineType) {
		return billValidatorTypeDao.addOrUpdateBillValidatorType(machineType);
	}

	@Override
	public Set<BillValidatorType> getBillValidatorTypeList() {
		return billValidatorTypeDao.getBillValidatorTypeList();
	}

	@Override
	public BillValidatorType getBillValidatorTypeById(long id) {
		return billValidatorTypeDao.getBillValidatorTypeById(id);
	}

	@Override
	public boolean deleteBillValidatorType(long Id) {
		return billValidatorTypeDao.deleteBillValidatorType(Id);
	}

	@Override
	public BillValidatorType getLastBillValidatorType() {
		return billValidatorTypeDao.getLastBillValidatorType();
	}

	@Override
	public Set<BillValidatorType> getBillValidatorTypeByMachineType(long mtid) {
		return billValidatorTypeDao.getBillValidatorTypeByMachineType(mtid);
	}

}
