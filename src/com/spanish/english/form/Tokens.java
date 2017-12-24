package com.spanish.english.form;

import java.io.Serializable;
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
@Table(name = "Tokens")
@Proxy(lazy = false)
public class Tokens implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7613909220056765610L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "value")
	private double value;

	@Column(name = "code")
	private String code;

	@ManyToOne
	Country country;

	/*
	 * @OneToMany(fetch =
	 * FetchType.EAGER,targetEntity=InputMoneyHopper.class,cascade
	 * =CascadeType.ALL, mappedBy="tokens") private Set<InputMoneyHopper>
	 * inputMoneyHopper;
	 * 
	 * @OneToMany(fetch =
	 * FetchType.EAGER,targetEntity=InputMoneyCoinValidator.class
	 * ,cascade=CascadeType.ALL, mappedBy="tokens") private
	 * Set<InputMoneyCoinValidator> inputMoneyCoinValidator;
	 * 
	 * @OneToMany(fetch =
	 * FetchType.EAGER,targetEntity=InputMoneyBillValidator.class
	 * ,cascade=CascadeType.ALL, mappedBy="tokens") private
	 * Set<InputMoneyBillValidator> inputMoneyBillValidator;
	 * 
	 * @OneToMany(fetch =
	 * FetchType.EAGER,targetEntity=OutputMoneyHopper.class,cascade
	 * =CascadeType.ALL, mappedBy="tokens") private Set<OutputMoneyHopper>
	 * outputMoneyHopper;
	 * 
	 * @OneToMany(fetch =
	 * FetchType.EAGER,targetEntity=OutputMoneyCoinValidator.class
	 * ,cascade=CascadeType.ALL, mappedBy="tokens") private
	 * Set<OutputMoneyCoinValidator> outputMoneyCoinValidator;
	 * 
	 * @OneToMany(fetch =
	 * FetchType.EAGER,targetEntity=OutputMoneyBillValidator.class
	 * ,cascade=CascadeType.ALL, mappedBy="tokens") private
	 * Set<OutputMoneyBillValidator> outputMoneyBillValidator;
	 */

	@OneToMany(fetch = FetchType.LAZY, targetEntity = InputMoneyPaymentDevice.class, mappedBy = "tokens")
	private Set<InputMoneyPaymentDevice> inputMoneyPaymentDevice;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = OutputMoneyPaymentDevice.class, mappedBy = "tokens")
	private Set<OutputMoneyPaymentDevice> outputMoneyPaymentDevice;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = TokensCollection.class, mappedBy = "tokens")
	private Set<TokensCollection> tokensCollection;

	public Set<TokensCollection> getTokensCollection() {
		return tokensCollection;
	}

	public void setTokensCollection(Set<TokensCollection> tokensCollection) {
		this.tokensCollection = tokensCollection;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	/*
	 * public Set<InputMoneyHopper> getInputMoneyHopper() { return
	 * inputMoneyHopper; }
	 * 
	 * public void setInputMoneyHopper(Set<InputMoneyHopper> inputMoneyHopper) {
	 * this.inputMoneyHopper = inputMoneyHopper; }
	 * 
	 * public Set<InputMoneyCoinValidator> getInputMoneyCoinValidator() { return
	 * inputMoneyCoinValidator; }
	 * 
	 * public void setInputMoneyCoinValidator( Set<InputMoneyCoinValidator>
	 * inputMoneyCoinValidator) { this.inputMoneyCoinValidator =
	 * inputMoneyCoinValidator; }
	 * 
	 * public Set<InputMoneyBillValidator> getInputMoneyBillValidator() { return
	 * inputMoneyBillValidator; }
	 * 
	 * public void setInputMoneyBillValidator( Set<InputMoneyBillValidator>
	 * inputMoneyBillValidator) { this.inputMoneyBillValidator =
	 * inputMoneyBillValidator; }
	 * 
	 * public Set<OutputMoneyHopper> getOutputMoneyHopper() { return
	 * outputMoneyHopper; }
	 * 
	 * public void setOutputMoneyHopper(Set<OutputMoneyHopper>
	 * outputMoneyHopper) { this.outputMoneyHopper = outputMoneyHopper; }
	 * 
	 * public Set<OutputMoneyCoinValidator> getOutputMoneyCoinValidator() {
	 * return outputMoneyCoinValidator; }
	 * 
	 * public void setOutputMoneyCoinValidator( Set<OutputMoneyCoinValidator>
	 * outputMoneyCoinValidator) { this.outputMoneyCoinValidator =
	 * outputMoneyCoinValidator; }
	 * 
	 * public Set<OutputMoneyBillValidator> getOutputMoneyBillValidator() {
	 * return outputMoneyBillValidator; }
	 * 
	 * public void setOutputMoneyBillValidator( Set<OutputMoneyBillValidator>
	 * outputMoneyBillValidator) { this.outputMoneyBillValidator =
	 * outputMoneyBillValidator; }
	 */

	public Set<InputMoneyPaymentDevice> getInputMoneyPaymentDevice() {
		return inputMoneyPaymentDevice;
	}

	public void setInputMoneyPaymentDevice(
			Set<InputMoneyPaymentDevice> inputMoneyPaymentDevice) {
		this.inputMoneyPaymentDevice = inputMoneyPaymentDevice;
	}

	public Set<OutputMoneyPaymentDevice> getOutputMoneyPaymentDevice() {
		return outputMoneyPaymentDevice;
	}

	public void setOutputMoneyPaymentDevice(
			Set<OutputMoneyPaymentDevice> outputMoneyPaymentDevice) {
		this.outputMoneyPaymentDevice = outputMoneyPaymentDevice;
	}

}
