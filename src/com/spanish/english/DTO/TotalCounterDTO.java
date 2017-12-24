package com.spanish.english.DTO;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;

@JsonIgnoreProperties(ignoreUnknown = true)
@Proxy(lazy=false)
public class TotalCounterDTO {
	
	private long currentInput;
	
	private long currentOutput;
	
	private long previousInput;
	
	private long previousOutput;
	
	private long timestamp;
	
	private long machineId;

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

	public long getMachineId() {
		return machineId;
	}

	public void setMachineId(long machineId) {
		this.machineId = machineId;
	}


}
