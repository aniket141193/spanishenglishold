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
@Table(name = "MachineUserMapping")
@Proxy(lazy = false)
public class MachineUserMapping implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8295735052094355560L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "userId")
	private Long userId;

	@Column(name = "mpmId")
	private Long mpmId;

	@ManyToOne
	private Machine machine;

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getMpmId() {
		return mpmId;
	}

	public void setMpmId(Long mpmId) {
		this.mpmId = mpmId;
	}

}
