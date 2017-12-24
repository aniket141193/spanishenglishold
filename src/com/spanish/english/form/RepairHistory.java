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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "RepairHistory")
@Proxy(lazy = false)
public class RepairHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8270758111388559796L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "description")
	private String description;

	@Column(name = "reportedTime")
	private long reportedTime;

	@Column(name = "resolvedTime")
	private long resolvedTime;

	@Column(name = "reportedTimeStr")
	private String reportedTimeStr;

	@Column(name = "resolvedTimeStr")
	private String resolvedTimeStr;

	@Column(name = "status")
	private String status;

	@ManyToOne
	private Machine machine;

	@ManyToOne
	private Admin reportedByAdmin;

	@ManyToOne
	private Operator reportedByOperator;

	@ManyToOne
	private Establishment reportedByEstablishment;

	@ManyToOne
	private Technician reportedByTechnician;

	@ManyToOne
	private Admin resolvedByAdmin;

	@ManyToOne
	private Operator resolvedByOperator;

	@ManyToOne
	private Establishment resolvedByEstablishment;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinTable(name = "RepairHistory_SpareParts", joinColumns = { @JoinColumn(name = "RepairHistory_ID") }, inverseJoinColumns = { @JoinColumn(name = "SpareParts_ID") })
	@Column(nullable = true)
	private Set<SpareParts> spareParts = new HashSet<SpareParts>(0);

	@OneToOne(cascade = CascadeType.ALL)
	private MachineProblems machineProblems;

	/*
	 * @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
	 * 
	 * @JoinTable(name = "RepairHistory_MachineProblems", joinColumns = {
	 * 
	 * @JoinColumn(name = "RepairHistory_ID") }, inverseJoinColumns = {
	 * 
	 * @JoinColumn(name = "MachineProblems_ID") })
	 * 
	 * @Column(nullable = true) private Set<MachineProblems> machineProblems =
	 * new HashSet<MachineProblems>(0);
	 */

	public MachineProblems getMachineProblems() {
		return machineProblems;
	}

	public void setMachineProblems(MachineProblems machineProblems) {
		this.machineProblems = machineProblems;
	}

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

	public long getReportedTime() {
		return reportedTime;
	}

	public void setReportedTime(long reportedTime) {
		this.reportedTime = reportedTime;
	}

	public long getResolvedTime() {
		return resolvedTime;
	}

	public void setResolvedTime(long resolvedTime) {
		this.resolvedTime = resolvedTime;
	}

	public String getReportedTimeStr() {
		return reportedTimeStr;
	}

	public void setReportedTimeStr(String reportedTimeStr) {
		this.reportedTimeStr = reportedTimeStr;
	}

	public String getResolvedTimeStr() {
		return resolvedTimeStr;
	}

	public void setResolvedTimeStr(String resolvedTimeStr) {
		this.resolvedTimeStr = resolvedTimeStr;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public Admin getReportedByAdmin() {
		return reportedByAdmin;
	}

	public void setReportedByAdmin(Admin reportedByAdmin) {
		this.reportedByAdmin = reportedByAdmin;
	}

	public Operator getReportedByOperator() {
		return reportedByOperator;
	}

	public void setReportedByOperator(Operator reportedByOperator) {
		this.reportedByOperator = reportedByOperator;
	}

	public Establishment getReportedByEstablishment() {
		return reportedByEstablishment;
	}

	public void setReportedByEstablishment(Establishment reportedByEstablishment) {
		this.reportedByEstablishment = reportedByEstablishment;
	}

	public Technician getReportedByTechnician() {
		return reportedByTechnician;
	}

	public void setReportedByTechnician(Technician reportedByTechnician) {
		this.reportedByTechnician = reportedByTechnician;
	}

	public Set<SpareParts> getSpareParts() {
		return spareParts;
	}

	public Admin getResolvedByAdmin() {
		return resolvedByAdmin;
	}

	public void setResolvedByAdmin(Admin resolvedByAdmin) {
		this.resolvedByAdmin = resolvedByAdmin;
	}

	public Operator getResolvedByOperator() {
		return resolvedByOperator;
	}

	public void setResolvedByOperator(Operator resolvedByOperator) {
		this.resolvedByOperator = resolvedByOperator;
	}

	public Establishment getResolvedByEstablishment() {
		return resolvedByEstablishment;
	}

	public void setResolvedByEstablishment(Establishment resolvedByEstablishment) {
		this.resolvedByEstablishment = resolvedByEstablishment;
	}

	public void setSpareParts(Set<SpareParts> spareParts) {
		this.spareParts = spareParts;
	}

}
