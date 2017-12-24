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
@Table(name = "MachinePercentageMapping")
@Proxy(lazy = false)
public class MachinePercentageMapping implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1684288972398305039L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	private Long percentagetype;

	private Long admin;

	@ManyToOne
	private Machine machine;

	private Long operator;

	private Long establishment;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getPercentagetype() {
		return percentagetype;
	}

	public void setPercentagetype(Long percentagetype) {
		this.percentagetype = percentagetype;
	}

	public Long getAdmin() {
		return admin;
	}

	public void setAdmin(Long admin) {
		this.admin = admin;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public Long getOperator() {
		return operator;
	}

	public void setOperator(Long operator) {
		this.operator = operator;
	}

	public Long getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Long establishment) {
		this.establishment = establishment;
	}

}
