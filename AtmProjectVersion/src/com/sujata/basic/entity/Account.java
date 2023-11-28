package com.sujata.basic.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Account {
	@Id
	@Column(length = 14)
	private String accountNo;
	private String accountType;
	private String accountOpenningDate;
	private String accountStatus;
	private Integer balance;
	
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")
	private Customer customer;
	
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "account")
    private AtmCard atmCard;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private List<Transaction> transaction;

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountOpenningDate() {
		return accountOpenningDate;
	}

	public void setAccountOpenningDate(String accountOpenningDate) {
		this.accountOpenningDate = accountOpenningDate;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public AtmCard getAtmCard() {
		return atmCard;
	}

	public void setAtmCard(AtmCard atmCard) {
		this.atmCard = atmCard;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}

	public Object getCardPin() {
		// TODO Auto-generated method stub
		return null;
	}
	
    
}
