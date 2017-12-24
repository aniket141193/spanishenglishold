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
@Table(name = "CoinValidator")
@Proxy(lazy=false)
public class CoinValidator implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2909541913979481520L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	/*@ManyToOne
	private Machine machine;*/
	
	@ManyToOne
	CoinValidatorType coinValidatorType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/*public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}*/

	public CoinValidatorType getCoinValidatorType() {
		return coinValidatorType;
	}

	public void setCoinValidatorType(CoinValidatorType coinValidatorType) {
		this.coinValidatorType = coinValidatorType;
	}

}
