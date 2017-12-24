package com.spanish.english.form;

public class PaymentDeviceTypeForm {

	private long[] inputCoins;
	private long[] inputNotes;
	private long[] inputTokens;	
	private long[] inputBills;
	
	private long[] outputCoins;
	private long[] outputNotes;
	private long[] outputTokens;	
	private long[] outputBills;
	
	private String type;
	private String model;
	private String io;

	private long id;

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

	public long[] getInputCoins() {
		return inputCoins;
	}

	public void setInputCoins(long[] inputCoins) {
		this.inputCoins = inputCoins;
	}

	public long[] getInputNotes() {
		return inputNotes;
	}

	public void setInputNotes(long[] inputNotes) {
		this.inputNotes = inputNotes;
	}

	public long[] getInputTokens() {
		return inputTokens;
	}

	public void setInputTokens(long[] inputTokens) {
		this.inputTokens = inputTokens;
	}

	public long[] getInputBills() {
		return inputBills;
	}

	public void setInputBills(long[] inputBills) {
		this.inputBills = inputBills;
	}

	public long[] getOutputCoins() {
		return outputCoins;
	}

	public void setOutputCoins(long[] outputCoins) {
		this.outputCoins = outputCoins;
	}

	public long[] getOutputNotes() {
		return outputNotes;
	}

	public void setOutputNotes(long[] outputNotes) {
		this.outputNotes = outputNotes;
	}

	public long[] getOutputTokens() {
		return outputTokens;
	}

	public void setOutputTokens(long[] outputTokens) {
		this.outputTokens = outputTokens;
	}

	public long[] getOutputBills() {
		return outputBills;
	}

	public void setOutputBills(long[] outputBills) {
		this.outputBills = outputBills;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
