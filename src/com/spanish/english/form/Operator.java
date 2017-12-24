package com.spanish.english.form;

import java.io.Serializable;
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
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "Operator")
@Proxy(lazy = false)
public class Operator implements Serializable, UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5250536209481159189L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	private String business;
	private String name;
	private String sector;
	private String population;
	private String province;
	private String identity_card;
	private String email;
	private String telephone;
	private String operatorUsername;
	private String operatorPassword;
	private String address;
	private String operatorRole;

	/* private String countryName; */

	@OneToMany(targetEntity = TempMachine.class, mappedBy = "operator")
	private Set<TempMachine> tempMachine;

	public Set<TempMachine> getTempMachine() {
		return tempMachine;
	}

	public void setTempMachine(Set<TempMachine> tempMachine) {
		this.tempMachine = tempMachine;
	}

	@ManyToOne
	private Admin admin;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Machine.class, mappedBy = "operator")
	private Set<Machine> machine;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = MachineAccountingMovement.class, cascade = CascadeType.ALL, mappedBy = "operator")
	private Set<MachineAccountingMovement> machineAccountingMovement;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Users.class, cascade = CascadeType.ALL, mappedBy = "operator")
	private Set<Users> users;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = UsersRole.class, cascade = CascadeType.ALL, mappedBy = "operator")
	private Set<UsersRole> usersRole;

	@OneToMany(targetEntity = Technician.class, cascade = CascadeType.ALL, mappedBy = "operator")
	private Set<Technician> technicians;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = RepairHistory.class, mappedBy = "reportedByOperator")
	private Set<RepairHistory> repairHistory;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = RepairHistory.class, mappedBy = "resolvedByOperator")
	private Set<RepairHistory> resolvedHistory;

	@OneToMany(fetch = FetchType.EAGER, targetEntity = Phone.class, cascade = CascadeType.ALL, mappedBy = "operator")
	private Set<Phone> phones;

	@OneToMany(targetEntity = MachineHistory.class, cascade = CascadeType.ALL, mappedBy = "operator")
	private Set<MachineHistory> machineHistory;

	@ManyToOne
	private StatusOperator statusOperator;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = AgreedPercentage.class, mappedBy = "operator")
	private Set<AgreedPercentage> agreedPercentage;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = PlayersGift.class, mappedBy = "operator")
	private Set<PlayersGift> playersGift;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = OtherExpenses.class, mappedBy = "operator")
	private Set<OtherExpenses> otherExpenses;

	/* Spring Security related fields */
	@OneToMany(targetEntity = Role.class, cascade = CascadeType.ALL, mappedBy = "operator")
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

	public String getBusiness() {
		return business;
	}

	public void setBusiness(String business) {
		this.business = business;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getIdentity_card() {
		return identity_card;
	}

	public void setIdentity_card(String identity_card) {
		this.identity_card = identity_card;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getOperatorUsername() {
		return operatorUsername;
	}

	public void setOperatorUsername(String username) {
		this.operatorUsername = username;
	}

	public String getOperatorPassword() {
		return operatorPassword;
	}

	public void setOperatorPassword(String password) {
		this.operatorPassword = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Set<Machine> getMachine() {
		return machine;
	}

	public void setMachine(Set<Machine> machine) {
		this.machine = machine;
	}

	@Override
	public List<Role> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Role> authorities) {
		this.authorities = authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String getPassword() {
		return this.operatorPassword;
	}

	@Override
	public String getUsername() {
		return this.operatorUsername;
	}

	public String getOperatorRole() {
		return operatorRole;
	}

	public void setOperatorRole(String operatorRole) {
		this.operatorRole = operatorRole;
	}

	public Set<MachineAccountingMovement> getMachineAccountingMovement() {
		return machineAccountingMovement;
	}

	public void setMachineAccountingMovement(
			Set<MachineAccountingMovement> machineAccountingMovement) {
		this.machineAccountingMovement = machineAccountingMovement;
	}

	/*
	 * public String getCountryName() { return countryName; } public void
	 * setCountryName(String countryName) { this.countryName = countryName; }
	 */
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

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

	public Set<MachineHistory> getMachineHistory() {
		return machineHistory;
	}

	public void setMachineHistory(Set<MachineHistory> machineHistory) {
		this.machineHistory = machineHistory;
	}

	public Set<RepairHistory> getResolvedHistory() {
		return resolvedHistory;
	}

	public void setResolvedHistory(Set<RepairHistory> resolvedHistory) {
		this.resolvedHistory = resolvedHistory;
	}

	public StatusOperator getStatusOperator() {
		return statusOperator;
	}

	public void setStatusOperator(StatusOperator statusOperator) {
		this.statusOperator = statusOperator;
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
