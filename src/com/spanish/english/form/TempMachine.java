package com.spanish.english.form;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "temp_machine")
@Proxy(lazy = false)
public class TempMachine implements Serializable {

	private static final long serialVersionUID = -6635963526989315223L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@OneToOne
	private Machine machine;

	@ManyToOne
	private Operator operator;

	@ManyToOne
	private Establishment establishment;

	@Column(name = "is_done")
	private boolean done;

	public TempMachine() {

	}

	public TempMachine(Machine machine, Operator operator,
			Establishment establishment, boolean done) {
		this.machine = machine;
		this.operator = operator;
		this.establishment = establishment;
		this.done = done;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Machine getMachine() {
		return machine;
	}

	public void setMachine(Machine machine) {
		this.machine = machine;
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

}
