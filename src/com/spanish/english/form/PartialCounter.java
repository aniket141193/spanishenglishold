package com.spanish.english.form;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "PartialCounter")
@Proxy(lazy=false)
public class PartialCounter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4366411923466693844L;
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	private long input;
	
	private long output;
	
	@OneToOne
	private Machine machine;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getInput() {
		return input;
	}

	public void setInput(long input) {
		this.input = input;
	}

	public long getOutput() {
		return output;
	}

	public void setOutput(long output) {
		this.output = output;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}
	
}
