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
@Table(name = "StatusOperator")
@Proxy(lazy = false)
public class StatusOperator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2053902903240027510L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	private String name;

	@OneToMany(targetEntity = Operator.class, mappedBy = "statusOperator")
	private Set<Operator> operator;

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

	public Set<Operator> getOperator() {
		return operator;
	}

	public void setOperator(Set<Operator> operator) {
		this.operator = operator;
	}
}
