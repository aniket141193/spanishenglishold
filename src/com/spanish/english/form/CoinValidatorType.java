package com.spanish.english.form;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name = "CoinValidatorType")
@Proxy(lazy=false)
public class CoinValidatorType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -333565824716187981L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	private long capacity;
	
	private String paymentType;

	/*@ManyToOne  
	private MachineType machineType;*/
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=InputMoneyCoinValidator.class,cascade=CascadeType.ALL, mappedBy="coinValidatorType")  
	private Set<InputMoneyCoinValidator> inputMoneyCoinValidator;
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=OutputMoneyCoinValidator.class,cascade=CascadeType.ALL, mappedBy="coinValidatorType")  
	private Set<OutputMoneyCoinValidator> outputMoneyCoinValidator;
	
	/*@OneToMany(fetch = FetchType.EAGER,targetEntity=CoinsType.class,cascade=CascadeType.ALL, mappedBy="coinValidatorType")  
	private Set<CoinsType> coinsType;*/
	
	
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=CoinValidator.class,cascade=CascadeType.ALL, mappedBy="coinValidatorType")  
	private Set<CoinValidator> coinValidator;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCapacity() {
		return capacity;
	}

	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}

	/*public MachineType getMachineType() {
		return machineType;
	}

	public void setMachineType(MachineType machineType) {
		this.machineType = machineType;
	}*/

	/*public Set<CoinsType> getCoinsType() {
		return coinsType;
	}

	public void setCoinsType(Set<CoinsType> coinsType) {
		this.coinsType = coinsType;
	}*/

	

	public Set<CoinValidator> getCoinValidator() {
		return coinValidator;
	}

	public void setCoinValidator(Set<CoinValidator> coinValidator) {
		this.coinValidator = coinValidator;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

}
