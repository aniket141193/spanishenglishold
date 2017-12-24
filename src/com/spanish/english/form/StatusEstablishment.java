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
@Table(name = "StatusEstablishment")
@Proxy(lazy = false)
public class StatusEstablishment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8064848243385264454L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	private String name;

	@OneToMany(targetEntity = Establishment.class, mappedBy = "statusEstablishment")
	private Set<Establishment> establishment;

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

	public Set<Establishment> getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Set<Establishment> establishment) {
		this.establishment = establishment;
	}
}
