package com.spanish.english.form;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Phone")
@Proxy(lazy = false)
public class Phone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8813459030833254291L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "type")
	private String type;

	@Column(name = "no")
	private String no;

	@ManyToOne
	private Admin admin;

	@ManyToOne
	private Operator operator;

	@ManyToOne
	private Establishment establishment;

	@ManyToOne
	private Technician technician;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Technician getTechnician() {
		return technician;
	}

	public void setTechnician(Technician technician) {
		this.technician = technician;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Establishment getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}
}
