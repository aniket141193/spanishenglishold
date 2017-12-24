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
@Table(name = "TotalCounter")
@Proxy(lazy = false)
public class TotalCounter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1107970489052441864L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	private long currentInput;

	private long currentOutput;

	private long previousInput;

	private long previousOutput;

	private long timestamp;

	@OneToOne
	private Machine machine;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCurrentInput() {
		return currentInput;
	}

	public void setCurrentInput(long currentInput) {
		this.currentInput = currentInput;
	}

	public long getCurrentOutput() {
		return currentOutput;
	}

	public void setCurrentOutput(long currentOutput) {
		this.currentOutput = currentOutput;
	}

	public long getPreviousInput() {
		return previousInput;
	}

	public void setPreviousInput(long previousInput) {
		this.previousInput = previousInput;
	}

	public long getPreviousOutput() {
		return previousOutput;
	}

	public void setPreviousOutput(long previousOutput) {
		this.previousOutput = previousOutput;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

}
