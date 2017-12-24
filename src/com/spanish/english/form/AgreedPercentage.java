package com.spanish.english.form;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "AgreedPercentage")
public class AgreedPercentage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6321299264228943737L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "role")
	private String role;

	@Column(name = "value")
	private Double value;

	@ManyToOne
	private Admin admin;

	@ManyToOne
	private Establishment establishment;

	@ManyToOne
	private Operator operator;

	@ManyToOne
	private Machine machine;

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Establishment getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

}
