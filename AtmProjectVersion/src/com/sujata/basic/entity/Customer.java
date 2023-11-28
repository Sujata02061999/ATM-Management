package com.sujata.basic.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	private Integer customerId;
	@Column(length = 15)
	private String customerName;
	private String dateOfBirth;
	private Character gender;
	@Column(length = 30)
	private String emailId;
	@Column(length = 10)
	private String cutomerContact;
	private String address;
	@Column(length = 12)
	private String addharNumber;
	@Column(length = 10)
	private String panNumber;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ifscCode")
	private Bank bank;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
	private List<Account> account;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getCutomerContact() {
		return cutomerContact;
	}

	public void setCutomerContact(String cutomerContact) {
		this.cutomerContact = cutomerContact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddharNumber() {
		return addharNumber;
	}

	public void setAddharNumber(String addharNumber) {
		this.addharNumber = addharNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}
	
	
	
}
