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
@Table(name = "MachineAccountingMovement")
@Proxy(lazy = false)
public class MachineAccountingMovement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2733682036446802936L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "money")
	private double money;

	@Column(name = "currency")
	private String currency;

	@Column(name = "timestamp")
	private String timestamp;

	@ManyToOne
	private Admin admin;

	@ManyToOne
	private Operator operator;

	@ManyToOne
	private Establishment establishment;

	@ManyToOne
	private Machine machine;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getTimestamp() {
		return timestamp;
	}

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

	public Establishment getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

}
