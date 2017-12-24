package com.spanish.english.DTO;

import java.util.Set;

import com.spanish.english.form.Admin;
import com.spanish.english.form.CoinsCollection;
import com.spanish.english.form.Establishment;
import com.spanish.english.form.MachineCollection;
import com.spanish.english.form.MachineHistory;
import com.spanish.english.form.MachinePercentageMapping;
import com.spanish.english.form.MachineType;
import com.spanish.english.form.MachineUserMapping;
import com.spanish.english.form.NotesCollection;
import com.spanish.english.form.Operator;
import com.spanish.english.form.RepairHistory;
import com.spanish.english.form.Technician;
import com.spanish.english.form.TokensCollection;

public class MachineDTO {
	private long id;

	private String manufacturingDate;
	private String machineIMEI;
	private long machineInput;
	private String machineStatus;
	private long machineOutput;
	private String machineControl;
	private long controlNumber;
	private String machinelock;
	private long lockDays;
	private long collectionLimits;
	private String color;
	private double creditValue;
	private String paymentKey;

	private String comments;

	private long simNumber;

	private MachineType machineType;

	private Admin admin;

	private Operator operator;

	private Establishment establishment;

	private Technician technician;

	private Set<RepairHistory> repairHistory;

	private Set<MachineHistory> machineHistory;

	private Set<MachinePercentageMapping> machinePercentageMapping;

	private Set<MachineUserMapping> machineUserMapping;

	private Set<MachineCollection> machineCollection;

	private Set<CoinsCollection> coinsCollection;

	private Set<TokensCollection> tokensCollection;

	private Set<NotesCollection> notesCollection;

	private Double establishmentFund;

	private Double theoreticalCollection;

	private Double machineFund;

	private String nickName;

	public long getId() {
		return id;
	}

	public Double getEstablishmentFund() {
		return establishmentFund;
	}

	public void setEstablishmentFund(Double establishmentFund) {
		this.establishmentFund = establishmentFund;
	}

	public Double getTheoreticalCollection() {
		return theoreticalCollection;
	}

	public void setTheoreticalCollection(Double theoreticalCollection) {
		this.theoreticalCollection = theoreticalCollection;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(String manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public String getMachineIMEI() {
		return machineIMEI;
	}

	public void setMachineIMEI(String machineIMEI) {
		this.machineIMEI = machineIMEI;
	}

	public String getMachineStatus() {
		return machineStatus;
	}

	public void setMachineStatus(String machineStatus) {
		this.machineStatus = machineStatus;
	}

	public String getMachineControl() {
		return machineControl;
	}

	public void setMachineControl(String machineControl) {
		this.machineControl = machineControl;
	}

	public long getControlNumber() {
		return controlNumber;
	}

	public void setControlNumber(long controlNumber) {
		this.controlNumber = controlNumber;
	}

	public String getMachinelock() {
		return machinelock;
	}

	public void setMachinelock(String machinelock) {
		this.machinelock = machinelock;
	}

	public long getLockDays() {
		return lockDays;
	}

	public void setLockDays(long lockDays) {
		this.lockDays = lockDays;
	}

	public long getCollectionLimits() {
		return collectionLimits;
	}

	public void setCollectionLimits(long collectionLimits) {
		this.collectionLimits = collectionLimits;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getCreditValue() {
		return creditValue;
	}

	public void setCreditValue(double creditValue) {
		this.creditValue = creditValue;
	}

	public MachineType getMachineType() {
		return machineType;
	}

	public void setMachineType(MachineType machineType) {
		this.machineType = machineType;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Establishment getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}

	public Technician getTechnician() {
		return technician;
	}

	public void setTechnician(Technician technician) {
		this.technician = technician;
	}

	public long getMachineInput() {
		return machineInput;
	}

	public void setMachineInput(long machineInput) {
		this.machineInput = machineInput;
	}

	public long getMachineOutput() {
		return machineOutput;
	}

	public void setMachineOutput(long machineOutput) {
		this.machineOutput = machineOutput;
	}

	public long getSimNumber() {
		return simNumber;
	}

	public void setSimNumber(long simNumber) {
		this.simNumber = simNumber;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Set<RepairHistory> getRepairHistory() {
		return repairHistory;
	}

	public void setRepairHistory(Set<RepairHistory> repairHistory) {
		this.repairHistory = repairHistory;
	}

	public String getPaymentKey() {
		return paymentKey;
	}

	public void setPaymentKey(String paymentKey) {
		this.paymentKey = paymentKey;
	}

	public Set<MachineHistory> getMachineHistory() {
		return machineHistory;
	}

	public void setMachineHistory(Set<MachineHistory> machineHistory) {
		this.machineHistory = machineHistory;
	}

	public Double getMachineFund() {
		return machineFund;
	}

	public void setMachineFund(Double machineFund) {
		this.machineFund = machineFund;
	}

	public Set<MachinePercentageMapping> getMachinePercentageMapping() {
		return machinePercentageMapping;
	}

	public void setMachinePercentageMapping(
			Set<MachinePercentageMapping> machinePercentageMapping) {
		this.machinePercentageMapping = machinePercentageMapping;
	}

	public Set<MachineUserMapping> getMachineUserMapping() {
		return machineUserMapping;
	}

	public void setMachineUserMapping(Set<MachineUserMapping> machineUserMapping) {
		this.machineUserMapping = machineUserMapping;
	}

	public Set<MachineCollection> getMachineCollection() {
		return machineCollection;
	}

	public void setMachineCollection(Set<MachineCollection> machineCollection) {
		this.machineCollection = machineCollection;
	}

	public Set<CoinsCollection> getCoinsCollection() {
		return coinsCollection;
	}

	public void setCoinsCollection(Set<CoinsCollection> coinsCollection) {
		this.coinsCollection = coinsCollection;
	}

	public Set<TokensCollection> getTokensCollection() {
		return tokensCollection;
	}

	public void setTokensCollection(Set<TokensCollection> tokensCollection) {
		this.tokensCollection = tokensCollection;
	}

	public Set<NotesCollection> getNotesCollection() {
		return notesCollection;
	}

	public void setNotesCollection(Set<NotesCollection> notesCollection) {
		this.notesCollection = notesCollection;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
