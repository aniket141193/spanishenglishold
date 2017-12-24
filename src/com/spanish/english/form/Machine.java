package com.spanish.english.form;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.spanish.english.DTO.MachineDTO;

@Entity
@Table(name = "Machine")
@Proxy(lazy = false)
public class Machine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5250536209481159189L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	private Date manufacturingDate;
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
	private Boolean selfLock;
	private String inputLockKey;
	private String outputLockKey;

	public String getInputLockKey() {
		return inputLockKey;
	}

	public void setInputLockKey(String inputLockKey) {
		this.inputLockKey = inputLockKey;
	}

	public String getOutputLockKey() {
		return outputLockKey;
	}

	public void setOutputLockKey(String outputLockKey) {
		this.outputLockKey = outputLockKey;
	}

	// should be unique
	private String nickName;

	@Column(nullable = true)
	private String comments;

	// this value should be given/change when machine assign to any
	// operator/establishment

	// set if machineControl=YES. give at the time of machine assign task.
	private long simNumber;

	@ManyToOne
	private MachineType machineType;

	@ManyToOne
	private Admin admin;

	@ManyToOne
	private Operator operator;

	@ManyToOne
	private Establishment establishment;

	@ManyToOne
	private Technician technician;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = RepairHistory.class, mappedBy = "machine")
	private Set<RepairHistory> repairHistory;

	@OneToMany(targetEntity = MachineHistory.class, cascade = CascadeType.ALL, mappedBy = "machine")
	private Set<MachineHistory> machineHistory;

	@OneToMany(targetEntity = MachinePercentageMapping.class, cascade = CascadeType.ALL, mappedBy = "machine")
	private Set<MachinePercentageMapping> machinePercentageMapping;

	@OneToMany(targetEntity = MachineUserMapping.class, cascade = CascadeType.ALL, mappedBy = "machine")
	private Set<MachineUserMapping> machineUserMapping;

	@OneToMany(targetEntity = MachineCollection.class, cascade = CascadeType.ALL, mappedBy = "machine")
	private Set<MachineCollection> machineCollection;

	@OneToMany(targetEntity = CoinsCollection.class, cascade = CascadeType.ALL, mappedBy = "machine")
	private Set<CoinsCollection> coinsCollection;

	@OneToMany(targetEntity = TokensCollection.class, cascade = CascadeType.ALL, mappedBy = "machine")
	private Set<TokensCollection> tokensCollection;

	@OneToMany(targetEntity = NotesCollection.class, cascade = CascadeType.ALL, mappedBy = "machine")
	private Set<NotesCollection> notesCollection;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = AgreedPercentage.class, mappedBy = "machine")
	private Set<AgreedPercentage> agreedPercentage;

	@ManyToOne
	private StatusMachine statusMachine;

	private Double establishmentFund;

	private Double theoreticalCollection;

	private Double machineFund;

	public Machine() {

	}

	public Machine(MachineDTO machineDTO) {
		this.collectionLimits = machineDTO.getCollectionLimits();
		this.color = machineDTO.getColor();
		this.comments = machineDTO.getComments();
		this.controlNumber = machineDTO.getControlNumber();
		this.creditValue = machineDTO.getCreditValue();
		this.lockDays = machineDTO.getLockDays();
		this.machineControl = machineDTO.getMachineControl();
		this.machineFund = machineDTO.getMachineFund();
		this.machineIMEI = machineDTO.getMachineIMEI();
		this.machineInput = machineDTO.getMachineInput();
		this.machinelock = machineDTO.getMachinelock();
		this.machineOutput = machineDTO.getMachineOutput();
		this.machineStatus = machineDTO.getMachineStatus();
		this.nickName = machineDTO.getNickName();
		this.paymentKey = machineDTO.getPaymentKey();

	}

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

	public Date getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(Date manufacturingDate) {
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

	public StatusMachine getStatusMachine() {
		return statusMachine;
	}

	public void setStatusMachine(StatusMachine statusMachine) {
		this.statusMachine = statusMachine;
	}

	public Set<AgreedPercentage> getAgreedPercentage() {
		return agreedPercentage;
	}

	public void setAgreedPercentage(Set<AgreedPercentage> agreedPercentage) {
		this.agreedPercentage = agreedPercentage;
	}

	public Boolean getSelfLock() {
		return selfLock;
	}

	public void setSelfLock(Boolean selfLock) {
		this.selfLock = selfLock;
	}

	/*
	 * @OneToMany(targetEntity=MachineAccountingMovement.class,cascade=CascadeType
	 * .ALL, mappedBy="machine") private Set<MachineAccountingMovement>
	 * machineAccountingMovement;
	 * 
	 * @OneToMany(targetEntity=Hopper.class,cascade=CascadeType.ALL,
	 * mappedBy="machine") private Set<Hopper> hopper;
	 * 
	 * @OneToMany(targetEntity=CoinValidator.class,cascade=CascadeType.ALL,
	 * mappedBy="machine") private Set<CoinValidator> coinValidator;
	 * 
	 * @OneToMany(targetEntity=BillValidator.class,cascade=CascadeType.ALL,
	 * mappedBy="machine") private Set<BillValidator> billValidator;
	 * 
	 * @OneToMany(targetEntity=Collection.class,cascade=CascadeType.ALL,
	 * mappedBy="machine") private Set<Collection> collection;
	 */

}
