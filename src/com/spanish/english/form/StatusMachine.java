package com.spanish.english.form;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "StatusMachine")
@Proxy(lazy = false)
public class StatusMachine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7975844193439686666L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	private String name;

	@OneToMany(targetEntity = Machine.class, mappedBy = "statusMachine")
	private Set<Machine> machine;

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

	public Set<Machine> getMachine() {
		return machine;
	}

	public void setMachine(Set<Machine> machine) {
		this.machine = machine;
	}

}
