package com.sujata.basic.dao;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.sujata.basic.entity.Account;
import com.sujata.basic.entity.AtmCard;
import com.sujata.basic.entity.Customer;
import com.sujata.basic.entity.Transaction;

public class AtmDaoImpl implements AtmDao {
    EntityManager entityManager = MyConnection.getEntityManagerObject();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	Transaction transaction = new Transaction();
	
	@Override
	public String deposite(Customer customer, Integer depositAmount) {
		Account account = customer.getAccount().get(0);
		entityTransaction.begin();
		customer.getAccount().get(0).setBalance(customer.getAccount().get(0).getBalance()+depositAmount);
		transaction.setAccount(account);
		transaction.setTransactionAmount(depositAmount);
		transaction.setTransactionDate(LocalDate.now());
		transaction.setTransactionTime(LocalTime.now());
		transaction.setTransactionType("Cr");
		entityManager.persist(transaction);
		entityTransaction.commit();
		return "Amount Deposited successfully";
	}

	@Override
	public String withdraw(Customer customer, Integer withdrawAmount) {
		Account account = customer.getAccount().get(0);
		entityTransaction.begin();
		customer.getAccount().get(0).setBalance(customer.getAccount().get(0).getBalance()-withdrawAmount);
		transaction.setAccount(account);
		transaction.setTransactionAmount(withdrawAmount);
		transaction.setTransactionDate(LocalDate.now());
		transaction.setTransactionTime(LocalTime.now());
		transaction.setTransactionType("De");
		entityManager.persist(transaction);
		entityTransaction.commit();
		return "Amount withdrawal successfully";
	}

	@Override
	public Integer checkBalance(Customer customer) {
		Account account = customer.getAccount().get(0);
		return account.getBalance();
	}

	@Override
	public String changePin(Customer customer, String newPin) {
		Account account = customer.getAccount().get(0);
		AtmCard atmCard = account.getAtmCard();
		entityTransaction.begin();
        atmCard.setCardPin(newPin);
        entityManager.merge(atmCard);
        entityTransaction.commit();
		return "PIN changed successfully";
	}

}
