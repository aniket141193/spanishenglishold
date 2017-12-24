package com.spanish.english.services;

import com.spanish.english.form.Admin;

public interface AdminServices {
	boolean login(String username, String password);

	Admin getAdminByUsername(String username);

	Admin getUserByUsername(String username);

	boolean addOrUpdateAdmin(Admin admin);

	boolean isAdminEmpty();

	boolean checkUniqueUsername(String username);

	Admin getAdminById(long id);
}
