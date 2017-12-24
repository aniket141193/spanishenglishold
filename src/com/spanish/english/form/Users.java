package com.spanish.english.form;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Users")
@Proxy(lazy=false)
public class Users implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1804166765734327160L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "username",nullable = true)
	private String username;
	
	@Column(name = "password",nullable = true)
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
	@JoinTable(name = "Users_UsersRole", joinColumns = { @JoinColumn(name = "Users_ID") }, inverseJoinColumns = { @JoinColumn(name = "UsersRole_ID") })
	private Set<UsersRole> usersRole = new HashSet<UsersRole>(0);

	@ManyToOne 
	private Admin admin;
	
	@ManyToOne 
	private Operator operator;
	
	@ManyToOne
	private Establishment establishment;
	
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

	public Set<UsersRole> getUsersRole() {
		return usersRole;
	}

	public void setUsersRole(Set<UsersRole> usersRole) {
		this.usersRole = usersRole;
	}
}
