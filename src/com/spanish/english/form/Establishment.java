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
@Table(name = "Establishment")
@Proxy(lazy = false)
public class Establishment implements Serializable, UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 738660264056920949L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@Column(name = "telephone")
	private String telephone;

	@Column(name = "establishmentName")
	private String establishmentName;

	@Column(name = "establishmentOwner")
	private String establishmentOwner;

	@Column(name = "address")
	private String address;

	/*
	 * @Column(name = "phone") private String phone;
	 */

	@Column(name = "sector")
	private String Sector;

	@Column(name = "geolocation")
	private String geolocation;

	@Column(name = "dischargeDate")
	private String dischargeDate;

	@Column(name = "fund")
	private String fund;

	@Column(name = "percentage")
	private String percentage;

	@Column(name = "establishmentsType")
	private String establishmentsType;

	@Column(name = "status")
	private String status;

	@Column(name = "prepayments")
	private String prepayments;

	@Column(name = "openTime")
	private String openTime;

	@Column(name = "closeTime")
	private String closeTime;

	@Column(name = "loans")
	private String loans;

	@Column(name = "withdrawals")
	private String withdrawals;

	@Column(name = "province")
	private String province;

	@Column(name = "population")
	private String population;

	@Column(name = "establishmentUsername")
	private String establishmentUsername;

	@Column(name = "establishmentPassword")
	private String establishmentPassword;

	@Column(name = "establishmentRole")
	private String establishmentRole;

	/* private String countryName; */

	@OneToMany(targetEntity = TempMachine.class, mappedBy = "establishment")
	private Set<TempMachine> tempMachine;

	public Set<TempMachine> getTempMachine() {
		return tempMachine;
	}

	public void setTempMachine(Set<TempMachine> tempMachine) {
		this.tempMachine = tempMachine;
	}

	@ManyToOne
	private Admin admin;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Machine.class, mappedBy = "establishment")
	private Set<Machine> machine;

	@OneToMany(targetEntity = Technician.class, mappedBy = "establishment")
	private Set<Technician> technicians;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = MachineAccountingMovement.class, mappedBy = "establishment")
	private Set<MachineAccountingMovement> machineAccountingMovement;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = Users.class, mappedBy = "establishment")
	private Set<Users> users;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = UsersRole.class, mappedBy = "establishment")
	private Set<UsersRole> usersRole;

	@OneToMany(fetch = FetchType.EAGER, targetEntity = Phone.class, mappedBy = "establishment")
	private Set<Phone> phones;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = RepairHistory.class, mappedBy = "reportedByEstablishment")
	private Set<RepairHistory> repairHistory;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = RepairHistory.class, mappedBy = "resolvedByEstablishment")
	private Set<RepairHistory> resolvedHistory;

	@OneToMany(targetEntity = MachineHistory.class, cascade = CascadeType.ALL, mappedBy = "establishment")
	private Set<MachineHistory> machineHistory;

	@ManyToOne
	private TypesEstablishment typesEstablishment;

	@ManyToOne
	private StatusEstablishment statusEstablishment;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = AgreedPercentage.class, mappedBy = "establishment")
	private Set<AgreedPercentage> agreedPercentage;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = PlayersGift.class, mappedBy = "establishment")
	private Set<PlayersGift> playersGift;

	@OneToMany(fetch = FetchType.LAZY, targetEntity = OtherExpenses.class, mappedBy = "establishment")
	private Set<OtherExpenses> otherExpenses;

	/* Spring Security related fields */
	@OneToMany(targetEntity = Role.class, mappedBy = "establishment")
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

	public String getEstablishmentName() {
		return establishmentName;
	}

	public void setEstablishmentName(String establishmentName) {
		this.establishmentName = establishmentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/*
	 * public String getPhone() { return phone; }
	 * 
	 * public void setPhone(String phone) { this.phone = phone; }
	 */

	public String getSector() {
		return Sector;
	}

	public void setSector(String sector) {
		Sector = sector;
	}

	public String getGeolocation() {
		return geolocation;
	}

	public void setGeolocation(String geolocation) {
		this.geolocation = geolocation;
	}

	public String getDischargeDate() {
		return dischargeDate;
	}

	public void setDischargeDate(String dischargeDate) {
		this.dischargeDate = dischargeDate;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFund() {
		return fund;
	}

	public void setFund(String fund) {
		this.fund = fund;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getEstablishmentsType() {
		return establishmentsType;
	}

	public void setEstablishmentsType(String establishmentsType) {
		this.establishmentsType = establishmentsType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPrepayments() {
		return prepayments;
	}

	public void setPrepayments(String prepayments) {
		this.prepayments = prepayments;
	}

	public String getLoans() {
		return loans;
	}

	public String getOpenTime() {
		return openTime;
	}

	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}

	public String getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(String closeTime) {
		this.closeTime = closeTime;
	}

	public void setLoans(String loans) {
		this.loans = loans;
	}

	public String getWithdrawals() {
		return withdrawals;
	}

	public void setWithdrawals(String withdrawals) {
		this.withdrawals = withdrawals;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
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

	public String getEstablishmentUsername() {
		return establishmentUsername;
	}

	public void setEstablishmentUsername(String establishmentUsername) {
		this.establishmentUsername = establishmentUsername;
	}

	public String getEstablishmentOwner() {
		return establishmentOwner;
	}

	public void setEstablishmentOwner(String establishmentOwner) {
		this.establishmentOwner = establishmentOwner;
	}

	public String getEstablishmentPassword() {
		return establishmentPassword;
	}

	public void setEstablishmentPassword(String establishmentPassword) {
		this.establishmentPassword = establishmentPassword;
	}

	public String getEstablishmentRole() {
		return establishmentRole;
	}

	public void setEstablishmentRole(String establishmentRole) {
		this.establishmentRole = establishmentRole;
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
		return this.establishmentPassword;
	}

	@Override
	public String getUsername() {
		return this.establishmentUsername;
	}

	public Set<Technician> getTechnicians() {
		return technicians;
	}

	public void setTechnicians(Set<Technician> technicians) {
		this.technicians = technicians;
	}

	public Set<MachineAccountingMovement> getMachineAccountingMovement() {
		return machineAccountingMovement;
	}

	public void setMachineAccountingMovement(
			Set<MachineAccountingMovement> machineAccountingMovement) {
		this.machineAccountingMovement = machineAccountingMovement;
	}

	/*
	 * public String getCountryName() { return countryName; }
	 * 
	 * public void setCountryName(String countryName) { this.countryName =
	 * countryName; }
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

	public Set<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Set<Phone> phones) {
		this.phones = phones;
	}

	public Set<RepairHistory> getRepairHistory() {
		return repairHistory;
	}

	public void setRepairHistory(Set<RepairHistory> repairHistory) {
		this.repairHistory = repairHistory;
	}

	public Set<MachineHistory> getMachineHistory() {
		return machineHistory;
	}

	public void setMachineHistory(Set<MachineHistory> machineHistory) {
		this.machineHistory = machineHistory;
	}

	public TypesEstablishment getTypesEstablishment() {
		return typesEstablishment;
	}

	public void setTypesEstablishment(TypesEstablishment typesEstablishment) {
		this.typesEstablishment = typesEstablishment;
	}

	public StatusEstablishment getStatusEstablishment() {
		return statusEstablishment;
	}

	public void setStatusEstablishment(StatusEstablishment statusEstablishment) {
		this.statusEstablishment = statusEstablishment;
	}

	public Set<RepairHistory> getResolvedHistory() {
		return resolvedHistory;
	}

	public void setResolvedHistory(Set<RepairHistory> resolvedHistory) {
		this.resolvedHistory = resolvedHistory;
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