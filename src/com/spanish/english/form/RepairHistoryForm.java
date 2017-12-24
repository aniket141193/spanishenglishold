package com.spanish.english.form;

public class RepairHistoryForm {

	private long id;
	private String description;
	private long[] spareParts;
	private long[] machineProblems;
	private String otherMachineProblems;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long[] getSpareParts() {
		return spareParts;
	}
	public void setSpareParts(long[] spareParts) {
		this.spareParts = spareParts;
	}
	public long[] getMachineProblems() {
		return machineProblems;
	}
	public void setMachineProblems(long[] machineProblems) {
		this.machineProblems = machineProblems;
	}
	public String getOtherMachineProblems() {
		return otherMachineProblems;
	}
	public void setOtherMachineProblems(String otherMachineProblems) {
		this.otherMachineProblems = otherMachineProblems;
	}
}
