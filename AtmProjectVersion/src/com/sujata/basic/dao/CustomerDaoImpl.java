package com.sujata.basic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.sujata.basic.entity.Account;
import com.sujata.basic.entity.AtmCard;
import com.sujata.basic.entity.Customer;

public class CustomerDaoImpl implements CustomerDao {
    
	EntityManager entityManager = MyConnection.getEntityManagerObject();
	@Override
	public Customer findCardNumber(String cardNo) {
		Customer customer1 = null;
		Account account1 = null;
		
		String jpql = "select a from Account a";
		Query query = entityManager.createQuery(jpql);
		List<Account> accounts = query.getResultList();
		
		for(Account account : accounts) {
			AtmCard atmCard = account.getAtmCard();
			if(atmCard.getCardNo().equals(cardNo)) 
			{
				account = atmCard.getAccount();
				if(atmCard.getCardNo().equals(cardNo))
				{
				account1 = atmCard.getAccount();
				customer1 = account.getCustomer();
				break;
			}
		}
	}
		if(customer1 != null)
		{
			customer1 = entityManager.find(Customer.class, customer1.getCustomerId());
		}
		return customer1;
	}

}
