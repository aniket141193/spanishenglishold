package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.UsersRole;

public interface UsersRoleServices {
	boolean addOrUpdateUsersRole(UsersRole users);
	Set<UsersRole> getUsersRoleList();
	UsersRole getUsersRoleById(long id);
	boolean deleteUsersRole(long Id);
	Set<UsersRole> getUsersRoleByAdminId(long adminId);
	Set<UsersRole> getUsersRoleByEstablishmentId(long establishmentId);
	Set<UsersRole> getUsersRoleByOperatorId(long operatorId);
}
