package com.spanish.english.form;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "Role")
@Proxy(lazy=false)
public class Role implements GrantedAuthority{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4915994965621823583L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	 private String name;

	 @ManyToOne(cascade=CascadeType.ALL)  
	 private Admin admin;
	 
	 @ManyToOne(cascade=CascadeType.ALL)  
	 private Operator operator;
	 
	 @ManyToOne(cascade=CascadeType.ALL)  
	 private Establishment establishment;
	 
	 @ManyToOne(cascade=CascadeType.ALL)  
	 private Technician technician;
	 
	public Admin getAdmin() {
		return admin;
	}



	public void setAdmin(Admin admin) {
		this.admin = admin;
	}



	public Operator getOperator() {
		return operator;
	}



	public void setOperator(Operator operator) {
		this.operator = operator;
	}



	@Override
	public String getAuthority() {
		return this.name;
	}
	
	
	
	public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Establishment getEstablishment() {
		return establishment;
	}



	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}



	public Technician getTechnician() {
		return technician;
	}



	public void setTechnician(Technician technician) {
		this.technician = technician;
	}
}
