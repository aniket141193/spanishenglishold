package com.spanish.english.form;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "MachineCollection")
@Proxy(lazy = false)
public class MachineCollection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3931077686527048629L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "startDate")
	private Date startDate;

	@Column(name = "endDate")
	private Date endDate;

	@Column(name = "netTotal")
	private Double netTotal;

	@Column(name = "machineCollection")
	private Double machineCollection;

	@Column(name = "manualCollection")
	private Double manualCollection;

	@Column(name = "differentInMoney")
	private Double differentInMoney;

	@Column(name = "differentInPercentage")
	private Double differentInPercentage;

	@Column(name = "paymentKey")
	private Double paymentKey;

	@Column(name = "fails")
	private Double fails;

	@Column(name = "playersGift")
	private Double playersGift;

	@Column(name = "otherExpenses")
	private Double otherExpenses;

	@Column(name = "establishmentMoney")
	private Double establishmentMoney;

	@Column(name = "adminMoney")
	private Double adminMoney;

	public Double getEstablishmentMoney() {
		return establishmentMoney;
	}

	public void setEstablishmentMoney(Double establishmentMoney) {
		this.establishmentMoney = establishmentMoney;
	}

	public Double getAdminMoney() {
		return adminMoney;
	}

	public void setAdminMoney(Double adminMoney) {
		this.adminMoney = adminMoney;
	}

	public Double getOperatorMoney() {
		return operatorMoney;
	}

	public void setOperatorMoney(Double operatorMoney) {
		this.operatorMoney = operatorMoney;
	}

	@Column(name = "operatorMoney")
	private Double operatorMoney;

	@ManyToOne
	private Machine machine;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = CoinsCollection.class, mappedBy = "machineCollection")
	private Set<CoinsCollection> coinsCollection;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = TokensCollection.class, mappedBy = "machineCollection")
	private Set<TokensCollection> tokensCollection;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = NotesCollection.class, mappedBy = "machineCollection")
	private Set<NotesCollection> notesCollection;

	public Set<CoinsCollection> getCoinsCollection() {
		return coinsCollection;
	}

	public void setCoinsCollection(Set<CoinsCollection> coinsCollection) {
		this.coinsCollection = coinsCollection;
	}

	public Set<TokensCollection> getTokensCollection() {
		return tokensCollection;
	}

	public void setTokensCollection(Set<TokensCollection> tokensCollection) {
		this.tokensCollection = tokensCollection;
	}

	public Set<NotesCollection> getNotesCollection() {
		return notesCollection;
	}

	public void setNotesCollection(Set<NotesCollection> notesCollection) {
		this.notesCollection = notesCollection;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Double getNetTotal() {
		return netTotal;
	}

	public void setNetTotal(Double netTotal) {
		this.netTotal = netTotal;
	}

	public Double getMachineCollection() {
		return machineCollection;
	}

	public void setMachineCollection(Double machineCollection) {
		this.machineCollection = machineCollection;
	}

	public Double getManualCollection() {
		return manualCollection;
	}

	public void setManualCollection(Double manualCollection) {
		this.manualCollection = manualCollection;
	}

	public Double getDifferentInMoney() {
		return differentInMoney;
	}

	public void setDifferentInMoney(Double differentInMoney) {
		this.differentInMoney = differentInMoney;
	}

	public Double getDifferentInPercentage() {
		return differentInPercentage;
	}

	public void setDifferentInPercentage(Double differentInPercentage) {
		this.differentInPercentage = differentInPercentage;
	}

	public Double getPaymentKey() {
		return paymentKey;
	}

	public void setPaymentKey(Double paymentKey) {
		this.paymentKey = paymentKey;
	}

	public Double getFails() {
		return fails;
	}

	public void setFails(Double fails) {
		this.fails = fails;
	}

	public Double getPlayersGift() {
		return playersGift;
	}

	public void setPlayersGift(Double playersGift) {
		this.playersGift = playersGift;
	}

	public Double getOtherExpenses() {
		return otherExpenses;
	}

	public void setOtherExpenses(Double otherExpenses) {
		this.otherExpenses = otherExpenses;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

}
