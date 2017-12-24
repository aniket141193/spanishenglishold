package com.spanish.english.DTO;

public class Money {

	private long id;
	private String moneyAdd;
	private String name;
	private String code;
	private double value;
	private String type;
	private String moneyType;
	private String getMoneyType;
	
	public Money(){
		
	}
	
	public Money(long id,String name, String code,double value,String type){
		this.id = id;
		this.name = name;
		this.code = code;
		this.value = value;
		this.type = type;
	}
	
	public Money(long id,String name, String code,double value,String type,String moneyType){
		this.id = id;
		this.name = name;
		this.code = code;
		this.value = value;
		this.type = type;
		this.moneyType = moneyType;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getMoneyType() {
		return moneyType;
	}

	public void setMoneyType(String moneyType) {
		this.moneyType = moneyType;
	}

	public String getMoneyAdd() {
		return moneyAdd;
	}

	public void setMoneyAdd(String moneyAdd) {
		this.moneyAdd = moneyAdd;
	}

	public String getGetMoneyType() {
		return getMoneyType;
	}

	public void setGetMoneyType(String getMoneyType) {
		this.getMoneyType = getMoneyType;
	}
	
}
