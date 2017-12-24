package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.PhoneDao;
import com.spanish.english.form.Phone;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("phoneServices")
public class PhoneServicesImpl implements PhoneServices{
	
	@Autowired
	PhoneDao phoneDao;
	
	@Override
	public boolean addOrUpdatePhone(Phone phone) {
		return phoneDao.addOrUpdatePhone(phone);
	}

	@Override
	public boolean deletePhone(long phoneId) {
		return phoneDao.deletePhone(phoneId);
	}

	@Override
	public Phone getPhonebyId(long phoneId) {
		return phoneDao.getPhonebyId(phoneId);
	}

	@Override
	public Set<Phone> getPhoneListByAdmin(long adminId) {
		return phoneDao.getPhoneListByAdmin(adminId);
	}

	@Override
	public Set<Phone> getPhoneListByOperator(long operatorId) {
		return phoneDao.getPhoneListByOperator(operatorId);
	}

	@Override
	public Set<Phone> getPhoneListByEstablishment(long establishmentId) {
		return phoneDao.getPhoneListByEstablishment(establishmentId);
	}

	@Override
	public Set<Phone> getPhoneListByTechnician(long technicianId) {
		return phoneDao.getPhoneListByTechnician(technicianId);
	}

	@Override
	public Phone getLastPhone() {
		return phoneDao.getLastPhone();
	}

}
