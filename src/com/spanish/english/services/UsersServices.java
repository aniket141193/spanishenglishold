package com.spanish.english.services;

import java.util.Set;

import com.spanish.english.form.Users;

public interface UsersServices {
	boolean addOrUpdateUsers(Users users);
	Set<Users> getUsersList();
	Users getUsersById(long id);
	boolean deleteUsers(long Id);
	Set<Users> getUsersByAdminId(long adminId);
	Set<Users> getUsersByEstablishmentId(long establishmentId);
	Set<Users> getUsersByOperatorId(long operatorId);
}
