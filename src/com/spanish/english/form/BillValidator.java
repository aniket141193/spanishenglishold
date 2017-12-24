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
@Table(name = "BillValidator")
@Proxy(lazy=false)
public class BillValidator implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4990142511554342171L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	/*@ManyToOne
	private Machine machine;*/
	
	@ManyToOne
	private BillValidatorType billValidatorType;

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

	public BillValidatorType getBillValidatorType() {
		return billValidatorType;
	}

	public void setBillValidatorType(BillValidatorType billValidatorType) {
		this.billValidatorType = billValidatorType;
	}

}
