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
@Table(name = "Collection")
@Proxy(lazy=false)
public class Collection implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1347635942750498895L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	private String date;
	
	private String period;
	
	private double theoreticalCollection;
	
	private double manualCollection;
	
	private double diffrence;
	
	private double differenceInPercentage;
	
	private String currency;
	
	private double profitMargin;
	
	private double profitMarginInPercenatge;
	
	/*@ManyToOne
	private Machine machine;*/

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public double getTheoreticalCollection() {
		return theoreticalCollection;
	}

	public void setTheoreticalCollection(double theoreticalCollection) {
		this.theoreticalCollection = theoreticalCollection;
	}

	public double getManualCollection() {
		return manualCollection;
	}

	public void setManualCollection(double manualCollection) {
		this.manualCollection = manualCollection;
	}

	public double getDiffrence() {
		return diffrence;
	}

	public void setDiffrence(double diffrence) {
		this.diffrence = diffrence;
	}

	public double getDifferenceInPercentage() {
		return differenceInPercentage;
	}

	public void setDifferenceInPercentage(double differenceInPercentage) {
		this.differenceInPercentage = differenceInPercentage;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getProfitMargin() {
		return profitMargin;
	}

	public void setProfitMargin(double profitMargin) {
		this.profitMargin = profitMargin;
	}

	public double getProfitMarginInPercenatge() {
		return profitMarginInPercenatge;
	}

	public void setProfitMarginInPercenatge(double profitMarginInPercenatge) {
		this.profitMarginInPercenatge = profitMarginInPercenatge;
	}

	/*public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}*/
	
	

}
