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
@Table(name = "Hopper")
@Proxy(lazy=false)
public class Hopper implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6673851794767104906L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	/*@ManyToOne  
	private Machine machine;*/
	
	@ManyToOne
	private HopperType hopperType;

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

	public HopperType getHopperType() {
		return hopperType;
	}

	public void setHopperType(HopperType hopperType) {
		this.hopperType = hopperType;
	}
	
}
