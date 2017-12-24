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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "Admin")
@JsonIgnoreProperties(ignoreUnknown = true)
@Proxy(lazy = false)
public class Admin implements Serializable, UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5685868652637033632L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	private String adminUsername;

	private String adminPassword;

	private String adminRole;

	private String countryName;

	@OneToMany(targetEntity = Operator.class, cascade = CascadeType.ALL, mappedBy = "admin")
	private Set<Operator> operators;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Establishment.class, mappedBy = "admin")
	private Set<Establishment> establishment;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Machine.class, mappedBy = "admin")
	private Set<Machine> machine;

	@OneToMany(targetEntity = MachineAccountingMovement.class, cascade = CascadeType.ALL, mappedBy = "admin")
	private Set<MachineAccountingMovement> machineAccountingMovement;

	@OneToMany(targetEntity = Users.class, cascade = CascadeType.ALL, mappedBy = "admin")
	private Set<Users> users;

	@OneToMany(targetEntity = UsersRole.class, cascade = CascadeType.ALL, mappedBy = "admin")
	private Set<UsersRole> usersRole;

	@OneToMany(targetEntity = Technician.class, cascade = CascadeType.ALL, mappedBy = "admin")
	private Set<Technician> technicians;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = RepairHistory.class, mappedBy = "reportedByAdmin")
	private Set<RepairHistory> repairHistory;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = RepairHistory.class, mappedBy = "resolvedByAdmin")
	private Set<RepairHistory> resovedHistory;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Phone.class, cascade = CascadeType.ALL, mappedBy = "admin")
	private Set<Phone> phones;

	@OneToMany(targetEntity = MachineHistory.class, cascade = CascadeType.ALL, mappedBy = "admin")
	private Set<MachineHistory> machineHistory;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = AgreedPercentage.class, mappedBy = "admin")
	private Set<AgreedPercentage> agreedPercentage;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = PlayersGift.class, mappedBy = "admin")
	private Set<PlayersGift> playersGift;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = OtherExpenses.class, mappedBy = "admin")
	private Set<OtherExpenses> otherExpenses;

	/* Spring Security related fields */
	@OneToMany(targetEntity = Role.class, cascade = CascadeType.ALL, mappedBy = "admin")
	private List<Role> authorities;

	private boolean accountNonExpired = true;
	private boolean accountNonLocked = true;
	private boolean credentialsNonExpired = true;
	private boolean enabled = true;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminRole(String adminRole) {
		this.adminRole = adminRole;
	}

	public void setAuthorities(List<Role> authorities) {
		this.authorities = authorities;
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

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public Set<Operator> getOperators() {
		return operators;
	}

	public Set<Establishment> getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Set<Establishment> establishment) {
		this.establishment = establishment;
	}

	public void setOperators(Set<Operator> operators) {
		this.operators = operators;
	}

	public String getAdminRole() {
		return adminRole;
	}

	@Override
	public String getPassword() {
		return this.adminPassword;
	}

	@Override
	public String getUsername() {
		return this.adminUsername;
	}

	public Set<Machine> getMachine() {
		return machine;
	}

	public void setMachine(Set<Machine> machine) {
		this.machine = machine;
	}

	public Set<MachineAccountingMovement> getMachineAccountingMovement() {
		return machineAccountingMovement;
	}

	public void setMachineAccountingMovement(
			Set<MachineAccountingMovement> machineAccountingMovement) {
		this.machineAccountingMovement = machineAccountingMovement;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}

	public Set<UsersRole> getUsersRole() {
		return usersRole;
	}

	public void setUsersRole(Set<UsersRole> usersRole) {
		this.usersRole = usersRole;
	}

	public Set<Technician> getTechnicians() {
		return technicians;
	}

	public void setTechnicians(Set<Technician> technicians) {
		this.technicians = technicians;
	}

	public Set<RepairHistory> getRepairHistory() {
		return repairHistory;
	}

	public void setRepairHistory(Set<RepairHistory> repairHistory) {
		this.repairHistory = repairHistory;
	}

	public Set<Phone> getPhones() {
		return phones;
	}

	public Set<MachineHistory> getMachineHistory() {
		return machineHistory;
	}

	public void setMachineHistory(Set<MachineHistory> machineHistory) {
		this.machineHistory = machineHistory;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
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

	public Set<RepairHistory> getResovedHistory() {
		return resovedHistory;
	}

	public void setResovedHistory(Set<RepairHistory> resovedHistory) {
		this.resovedHistory = resovedHistory;
	}

	public Set<AgreedPercentage> getAgreedPercentage() {
		return agreedPercentage;
	}

	public void setAgreedPercentage(Set<AgreedPercentage> agreedPercentage) {
		this.agreedPercentage = agreedPercentage;
	}

	public Set<PlayersGift> getPlayersGift() {
		return playersGift;
	}

	public void setPlayersGift(Set<PlayersGift> playersGift) {
		this.playersGift = playersGift;
	}

	public Set<OtherExpenses> getOtherExpenses() {
		return otherExpenses;
	}

	public void setOtherExpenses(Set<OtherExpenses> otherExpenses) {
		this.otherExpenses = otherExpenses;
	}

}
