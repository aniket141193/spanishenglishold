package com.spanish.english.form;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "MachineType")
@Proxy(lazy = false)
public class MachineType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1632889406648099436L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	private String model;
	private String description;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinTable(name = "MachineType_PaymentDeviceType", joinColumns = { @JoinColumn(name = "MachineType_ID") }, inverseJoinColumns = { @JoinColumn(name = "PaymentDeviceType_ID") })
	private Set<PaymentDeviceType> paymentDeviceType = new HashSet<PaymentDeviceType>(
			0);

	private boolean wirelessControl;
	private boolean gprsModem;
	private boolean lockCode;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Machine.class, mappedBy = "machineType")
	private Set<Machine> machines;

	public MachineType(MachineTypeForm machineTypeForm) {
		this.model = machineTypeForm.getModel();
		this.description = machineTypeForm.getDescription();
		if (machineTypeForm.getGprsModem().equals("true")) {
			this.gprsModem = true;
		} else {
			this.gprsModem = false;
		}
		if (machineTypeForm.getWirelessControl().equals("true")) {
			this.wirelessControl = true;
		} else {
			this.wirelessControl = false;
		}
		if (machineTypeForm.getLockCode().equals("true")) {
			this.lockCode = true;
		} else {
			this.lockCode = false;
		}
	}

	public MachineType() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isWirelessControl() {
		return wirelessControl;
	}

	public void setWirelessControl(boolean wirelessControl) {
		this.wirelessControl = wirelessControl;
	}

	public Set<Machine> getMachines() {
		return machines;
	}

	public void setMachines(Set<Machine> machines) {
		this.machines = machines;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isGprsModem() {
		return gprsModem;
	}

	public void setGprsModem(boolean gprsModem) {
		this.gprsModem = gprsModem;
	}

	public boolean isLockCode() {
		return lockCode;
	}

	public void setLockCode(boolean lockCode) {
		this.lockCode = lockCode;
	}

	public Set<PaymentDeviceType> getPaymentDeviceType() {
		return paymentDeviceType;
	}

	public void setPaymentDeviceType(Set<PaymentDeviceType> paymentDeviceType) {
		this.paymentDeviceType = paymentDeviceType;
	}
}
