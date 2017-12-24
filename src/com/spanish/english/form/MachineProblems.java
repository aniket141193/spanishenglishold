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
@Table(name = "MachineProblems")
@Proxy(lazy = false)
public class MachineProblems implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6600041223143235678L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	private String description;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = RepairHistory.class, mappedBy = "machineProblems")
	private Set<RepairHistory> repairHistory;

	public Set<RepairHistory> getRepairHistory() {
		return repairHistory;
	}

	public void setRepairHistory(Set<RepairHistory> repairHistory) {
		this.repairHistory = repairHistory;
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

}
