package com.spanish.english.form;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PlayersGift")
public class PlayersGift implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3428128720358078909L;

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

	public PlayersGift() {

	}

	public PlayersGift(Admin admin, Operator operator,
			Establishment establishment, String role, Double value) {
		if (admin != null)
			this.admin = admin;
		if (operator != null)
			this.operator = operator;
		if (establishment != null)
			this.establishment = establishment;
		this.role = role;
		this.value = value;
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
