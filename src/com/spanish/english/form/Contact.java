package com.spanish.english.form;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Contact")
@Proxy(lazy=false)
public class Contact implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6084668699493997800L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	private String firstname;
	private String lastname;
	private String email;
	private String telephone;
	private String contactUsername;
	private String contactPassword;
	
	
	public String getEmail() {
		return email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getContactUsername() {
		return contactUsername;
	}
	public void setContactUsername(String contactUsername) {
		this.contactUsername = contactUsername;
	}
	public String getContactPassword() {
		return contactPassword;
	}
	public void setContactPassword(String contactPassword) {
		this.contactPassword = contactPassword;
	}
	
	
}
