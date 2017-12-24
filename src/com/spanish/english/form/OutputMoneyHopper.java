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
@Table(name = "OutputMoneyHopper")
@Proxy(lazy=false)
public class OutputMoneyHopper implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2136844097031508372L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@ManyToOne
	private Coins coins;
	
	@ManyToOne
	private Notes notes;
	
	@ManyToOne
	private Bills bills;
	
	@ManyToOne
	private Tokens tokens;
	
	@ManyToOne
	private HopperType hopperType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Coins getCoins() {
		return coins;
	}

	public void setCoins(Coins coins) {
		this.coins = coins;
	}

	public Notes getNotes() {
		return notes;
	}

	public void setNotes(Notes notes) {
		this.notes = notes;
	}

	public Bills getBills() {
		return bills;
	}

	public void setBills(Bills bills) {
		this.bills = bills;
	}

	public Tokens getTokens() {
		return tokens;
	}

	public void setTokens(Tokens tokens) {
		this.tokens = tokens;
	}

	public HopperType getHopperType() {
		return hopperType;
	}

	public void setHopperType(HopperType hopperType) {
		this.hopperType = hopperType;
	}

}
