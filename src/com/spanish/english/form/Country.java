package com.spanish.english.form;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "Country")
@Proxy(lazy = false)
public class Country implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7826987608446327673L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	private String country;
	private String currency;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Coins.class, mappedBy = "country")
	private Set<Coins> coins;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Notes.class, mappedBy = "country")
	private Set<Notes> notes;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Tokens.class, mappedBy = "country")
	private Set<Tokens> tokens;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Bills.class, mappedBy = "country")
	private Set<Bills> bills;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Set<Coins> getCoins() {
		return coins;
	}

	public void setCoins(Set<Coins> coins) {
		this.coins = coins;
	}

	public Set<Notes> getNotes() {
		return notes;
	}

	public void setNotes(Set<Notes> notes) {
		this.notes = notes;
	}

	public Set<Tokens> getTokens() {
		return tokens;
	}

	public void setTokens(Set<Tokens> tokens) {
		this.tokens = tokens;
	}

	public Set<Bills> getBills() {
		return bills;
	}

	public void setBills(Set<Bills> bills) {
		this.bills = bills;
	}

}
