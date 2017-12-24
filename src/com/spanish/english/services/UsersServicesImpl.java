package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.UsersDao;
import com.spanish.english.form.Users;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("usersServices")
public class UsersServicesImpl implements UsersServices{

	@Autowired
	UsersDao usersDao;
	
	@Override
	public boolean addOrUpdateUsers(Users users) {
		return usersDao.addOrUpdateUsers(users);
	}

	@Override
	public Set<Users> getUsersList() {
		return usersDao.getUsersList();
	}

	@Override
	public Users getUsersById(long id) {
		return usersDao.getUsersById(id);
	}

	@Override
	public boolean deleteUsers(long Id) {
		return usersDao.deleteUsers(Id);
	}

	@Override
	public Set<Users> getUsersByAdminId(long adminId) {
		return usersDao.getUsersByAdminId(adminId);
	}

	@Override
	public Set<Users> getUsersByEstablishmentId(long establishmentId) {
		return usersDao.getUsersByEstablishmentId(establishmentId);
	}

	@Override
	public Set<Users> getUsersByOperatorId(long operatorId) {
		return usersDao.getUsersByOperatorId(operatorId);
	}

}
