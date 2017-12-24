package com.spanish.english.form;

public class UsersForm {
	private long id;
	private String name;
	private String username;
	private String password;
	private long[] usersRole;
	private String giveLogin;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long[] getUsersRole() {
		return usersRole;
	}
	public void setUsersRole(long[] usersRole) {
		this.usersRole = usersRole;
	}
	public String getGiveLogin() {
		return giveLogin;
	}
	public void setGiveLogin(String giveLogin) {
		this.giveLogin = giveLogin;
	}
}
