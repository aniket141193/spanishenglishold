package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.BillValidatorDao;
import com.spanish.english.form.BillValidator;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("billValidatorServices")
public class BillValidatorServicesImpl implements BillValidatorServices{

	@Autowired
	BillValidatorDao billValidatorDao;
	
	@Override
	public boolean addOrUpdateBillValidator(BillValidator billValidator) {
		return billValidatorDao.addOrUpdateBillValidator(billValidator);
	}

	@Override
	public Set<BillValidator> getBillValidatorList() {
		return billValidatorDao.getBillValidatorList();
	}

	@Override
	public BillValidator getBillValidatorById(long id) {
		return billValidatorDao.getBillValidatorById(id);
	}

	@Override
	public boolean deleteBillValidator(long Id) {
		return billValidatorDao.deleteBillValidator(Id);
	}

}
