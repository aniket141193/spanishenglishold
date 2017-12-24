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
@Table(name = "HopperType")
@Proxy(lazy=false)
public class HopperType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -634216735148853248L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	private long capacity;
	
	private String hopperTypeName;
	
	private String paymentType;

	/*@ManyToOne  
	private MachineType machineType;*/
	
	//private boolean singleCoin;
	
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=InputMoneyHopper.class,cascade=CascadeType.ALL, mappedBy="hopperType")  
	private Set<InputMoneyHopper> inputMoneyHopper;
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=OutputMoneyHopper.class,cascade=CascadeType.ALL, mappedBy="hopperType")  
	private Set<OutputMoneyHopper> outputMoneyHopper;
	
	/*@OneToMany(fetch = FetchType.EAGER,targetEntity=CoinsType.class,cascade=CascadeType.ALL, mappedBy="hopperType")  
	private Set<CoinsType> coinsType;
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=TokensType.class,cascade=CascadeType.ALL, mappedBy="hopperType")  
	private Set<TokensType> tokensType;*/
	
	
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=Hopper.class,cascade=CascadeType.ALL, mappedBy="hopperType")  
	private Set<Hopper> hoppers;
	
	public HopperType(){
		
	}
	
	public HopperType(String hopperTypeName,String paymentType){
		this.hopperTypeName = hopperTypeName;
		this.paymentType = paymentType;
	}
	
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
	}
*/
	/*public boolean isSingleCoin() {
		return singleCoin;
	}

	public void setSingleCoin(boolean singleCoin) {
		this.singleCoin = singleCoin;
	}*/

	
	public Set<Hopper> getHoppers() {
		return hoppers;
	}

	public void setHoppers(Set<Hopper> hoppers) {
		this.hoppers = hoppers;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getHopperTypeName() {
		return hopperTypeName;
	}

	public void setHopperTypeName(String hopperTypeName) {
		this.hopperTypeName = hopperTypeName;
	}

	/*public Set<CoinsType> getCoinsType() {
		return coinsType;
	}

	public void setCoinsType(Set<CoinsType> coinsType) {
		this.coinsType = coinsType;
	}

	public Set<TokensType> getTokensType() {
		return tokensType;
	}

	public void setTokensType(Set<TokensType> tokensType) {
		this.tokensType = tokensType;
	}*/
}
