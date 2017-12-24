package com.spanish.english.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spanish.english.dao.UsersRoleDao;
import com.spanish.english.form.UsersRole;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
@Service("usersRoleServices")
public class UsersRoleServicesImpl implements UsersRoleServices{

	@Autowired
	UsersRoleDao usersRoleDao;
	
	@Override
	public boolean addOrUpdateUsersRole(UsersRole users) {
		return usersRoleDao.addOrUpdateUsersRole(users);
	}

	@Override
	public Set<UsersRole> getUsersRoleList() {
		return usersRoleDao.getUsersRoleList();
	}

	@Override
	public UsersRole getUsersRoleById(long id) {
		return usersRoleDao.getUsersRoleById(id);
	}

	@Override
	public boolean deleteUsersRole(long Id) {
		return usersRoleDao.deleteUsersRole(Id);
	}

	@Override
	public Set<UsersRole> getUsersRoleByAdminId(long adminId) {
		return usersRoleDao.getUsersRoleByAdminId(adminId);
	}

	@Override
	public Set<UsersRole> getUsersRoleByEstablishmentId(long establishmentId) {
		return usersRoleDao.getUsersRoleByEstablishmentId(establishmentId);
	}

	@Override
	public Set<UsersRole> getUsersRoleByOperatorId(long operatorId) {
		return usersRoleDao.getUsersRoleByOperatorId(operatorId);
	}

}
