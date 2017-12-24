package com.spanish.english.form;

public class MachineTypeForm {
	
	private long id;
	private String model;
	private String description;
	private long paymentDeviceType[];
	
	private String wirelessControl;
	private String gprsModem;
	private String lockCode;
	
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
	public long[] getPaymentDeviceType() {
		return paymentDeviceType;
	}
	public void setPaymentDeviceType(long[] paymentDeviceType) {
		this.paymentDeviceType = paymentDeviceType;
	}
	public String getWirelessControl() {
		return wirelessControl;
	}
	public void setWirelessControl(String wirelessControl) {
		this.wirelessControl = wirelessControl;
	}
	public String getGprsModem() {
		return gprsModem;
	}
	public void setGprsModem(String gprsModem) {
		this.gprsModem = gprsModem;
	}
	public String getLockCode() {
		return lockCode;
	}
	public void setLockCode(String lockCode) {
		this.lockCode = lockCode;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
