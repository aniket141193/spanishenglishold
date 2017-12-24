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
@Table(name = "BillValidatorType")
@Proxy(lazy=false)
public class BillValidatorType implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 454902235052100764L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	private long capacity;
	
	private String paymentType;
	
	//private boolean onlyInput;
	
	/*@ManyToOne  
	private MachineType machineType;*/
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=InputMoneyBillValidator.class,cascade=CascadeType.ALL, mappedBy="billValidatorType")  
	private Set<InputMoneyBillValidator> inputMoneyBillValidator;
	
	@OneToMany(fetch = FetchType.EAGER,targetEntity=OutputMoneyBillValidator.class,cascade=CascadeType.ALL, mappedBy="billValidatorType")  
	private Set<OutputMoneyBillValidator> outputMoneyBillValidator;

	/*@OneToMany(fetch = FetchType.EAGER,targetEntity=BillsType.class,cascade=CascadeType.ALL, mappedBy="billValidatorType")  
	private Set<BillsType> billsType;*/
	
	
	
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

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	/*public boolean isOnlyInput() {
		return onlyInput;
	}

	public void setOnlyInput(boolean onlyInput) {
		this.onlyInput = onlyInput;
	}*/

	/*public Set<BillsType> getBillsType() {
		return billsType;
	}

	public void setBillsType(Set<BillsType> billsType) {
		this.billsType = billsType;
	}*/

}
