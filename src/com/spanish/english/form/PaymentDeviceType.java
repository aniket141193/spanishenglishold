package com.spanish.english.form;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "PaymentDeviceType")
@Proxy(lazy = false)
public class PaymentDeviceType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3991885341508682417L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "type")
	private String type;

	@Column(name = "model")
	private String model;

	@Column(name = "io")
	private String io;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = InputMoneyPaymentDevice.class, mappedBy = "paymentDeviceType")
	private Set<InputMoneyPaymentDevice> inputMoneyPaymentDevice;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = OutputMoneyPaymentDevice.class, mappedBy = "paymentDeviceType")
	private Set<OutputMoneyPaymentDevice> outputMoneyPaymentDevice;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getIo() {
		return io;
	}

	public void setIo(String io) {
		this.io = io;
	}

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
