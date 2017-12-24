package com.spanish.english.form;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "Technician")
@Proxy(lazy = false)
public class Technician implements Serializable, UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5359654333602010273L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "technicianName")
	private String technicianName;

	@Column(name = "address")
	private String address;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Machine.class, mappedBy = "technician")
	private Set<Machine> machine;

	@ManyToOne
	private Establishment establishment;

	@ManyToOne
	private Operator operator;

	@ManyToOne
	private Admin admin;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = RepairHistory.class, mappedBy = "reportedByTechnician")
	private Set<RepairHistory> repairHistory;

	@OneToMany(fetch = FetchType.EAGER, targetEntity = Phone.class, cascade = CascadeType.ALL, mappedBy = "technician")
	private Set<Phone> phones;

	/*
	 * @OneToMany(fetch = FetchType.EAGER, targetEntity = RepairHistory.class,
	 * mappedBy = "resolvedBy") private Set<RepairHistory> repairHistorySolved;
	 */

	public Set<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phone> phone) {
		this.phones = phone;
	}

	private boolean accountNonExpired = true;
	private boolean accountNonLocked = true;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;

	/* Spring Security related fields */
	@OneToMany(targetEntity = Role.class, cascade = CascadeType.ALL, mappedBy = "technician")
	private List<Role> authorities;

	@Column(name = "technicianUsername")
	private String technicianUsername;

	@Column(name = "technicianPassword")
	private String technicianPassword;

	@Column(name = "technicianRole")
	private String technicianRole;

	public long getId() {
		return id;
	}

	public String getTechnicianUsername() {
		return technicianUsername;
	}

	public void setTechnicianUsername(String technicianUsername) {
		this.technicianUsername = technicianUsername;
	}

	public String getTechnicianPassword() {
		return technicianPassword;
	}

	public void setTechnicianPassword(String technicianPassword) {
		this.technicianPassword = technicianPassword;
	}

	public String getTechnicianRole() {
		return technicianRole;
	}

	public void setTechnicianRole(String technicianRole) {
		this.technicianRole = technicianRole;
	}

	public void setAuthorities(List<Role> authorities) {
		this.authorities = authorities;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTechnicianName() {
		return technicianName;
	}

	public void setTechnicianName(String technicianName) {
		this.technicianName = technicianName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Machine> getMachine() {
		return machine;
	}

	public void setMachine(Set<Machine> machine) {
		this.machine = machine;
	}

	public Establishment getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.technicianPassword;
	}

	@Override
	public String getUsername() {
		return this.technicianUsername;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<RepairHistory> getRepairHistory() {
		return repairHistory;
	}

	public void setRepairHistory(Set<RepairHistory> repairHistory) {
		this.repairHistory = repairHistory;
	}

	/*
	 * public Set<RepairHistory> getRepairHistorySolved() { return
	 * repairHistorySolved; }
	 * 
	 * public void setRepairHistorySolved(Set<RepairHistory>
	 * repairHistorySolved) { this.repairHistorySolved = repairHistorySolved; }
	 */

}
