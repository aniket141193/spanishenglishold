package com.spanish.english.form;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "NotesCollection")
@Proxy(lazy = false)
public class NotesCollection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8365170422681572842L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "numberOfCount")
	private Long numberOfCount;

	public Long getNumberOfCount() {
		return numberOfCount;
	}

	public void setNumberOfCount(Long numberOfCount) {
		this.numberOfCount = numberOfCount;
	}

	@Column(name = "value")
	private Double value;

	@Column(name = "collectionType")
	private String collectionType;

	@ManyToOne
	private Machine machine;

	@ManyToOne
	private MachineCollection machineCollection;

	@ManyToOne
	private Notes notes;

	public Notes getNotes() {
		return notes;
	}

	public void setNotes(Notes notes) {
		this.notes = notes;
	}

	public MachineCollection getMachineCollection() {
		return machineCollection;
	}

	public void setMachineCollection(MachineCollection machineCollection) {
		this.machineCollection = machineCollection;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public String getCollectionType() {
		return collectionType;
	}

	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}

}
