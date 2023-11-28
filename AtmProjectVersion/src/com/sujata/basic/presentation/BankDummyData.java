package com.sujata.basic.presentation;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.sujata.basic.dao.MyConnection;
import com.sujata.basic.entity.Account;
import com.sujata.basic.entity.AtmCard;
import com.sujata.basic.entity.Bank;
import com.sujata.basic.entity.Customer;

public class BankDummyData {

	public static void main(String[] args) {
     
		Bank bank1 = new Bank();
		Bank bank2 = new Bank();
		
		Customer customer1 = new Customer();
		Customer customer2 = new Customer();
		Customer customer3 = new Customer();
        Customer customer4 = new Customer();
		
		Account account1 = new Account();
		Account account2 = new Account();
		
		AtmCard atmCard1 = new AtmCard();
		AtmCard atmCard2 = new AtmCard();

        List<Account> listAccount1 = List.of(account1, account2);
        
        List<AtmCard> listAtmCard1 = List.of(atmCard1,atmCard2);
        
        List<Customer> listCustomer1 = List.of(customer1, customer2, customer3,customer4);
        
        
        
        bank1.setIfscCode("ICIC0001234");
		bank1.setBankName("ICICI Bank");
		bank1.setBranchCode("001096");
		bank1.setCustomer(listCustomer1);

		bank2.setIfscCode("HDFC0004321");
		bank2.setBankName("HDFC Bank");
		bank2.setBranchCode("001784 ");
		bank2.setCustomer(listCustomer1);
		
		
		customer1.setCustomerId(123456789);
		customer1.setCustomerName("Suhana Shaha");
		customer1.setAddress("Beed 431123");
		customer1.setCutomerContact("7896543456");
		customer1.setDateOfBirth("01/02/1234");
		customer1.setGender('F');
		customer1.setEmailId("suhana@gmail.com");
		customer1.setPanNumber("ABCD0012A");
		customer1.setAddharNumber("123456789112");
		customer1.setBank(bank1);
		customer1.setAccount(listAccount1);
		
		customer2.setCustomerId(987654321);
		customer2.setCustomerName("Suhana Shaha");
		customer2.setAddress("Beed 431123");
		customer2.setCutomerContact("7896543456");
		customer2.setDateOfBirth("01/02/1234");
		customer2.setGender('F');
		customer2.setEmailId("suhana@gmail.com");
		customer2.setPanNumber("ABCD0012A");
		customer2.setAddharNumber("123456789112");
		customer2.setBank(bank2);
		customer2.setAccount(listAccount1);
		
		customer3.setCustomerId(234567891);
		customer3.setCustomerName("Suhana Shaha");
		customer3.setAddress("Beed 431123");
		customer3.setCutomerContact("7896543456");
		customer3.setDateOfBirth("01/02/1234");
		customer3.setGender('F');
		customer3.setEmailId("suhana@gmail.com");
		customer3.setPanNumber("ABCD0012A");
		customer3.setAddharNumber("123456789112");
		customer3.setBank(bank1);
		customer3.setAccount(listAccount1);
		
		customer4.setCustomerId(198765432);
		customer4.setCustomerName("Suhana Shaha");
		customer4.setAddress("Beed 431123");
		customer4.setCutomerContact("7896543456");
		customer4.setDateOfBirth("01/02/1234");
		customer4.setGender('F');
		customer4.setEmailId("suhana@gmail.com");
		customer4.setPanNumber("ABCD0012A");
		customer4.setAddharNumber("123456789112");
		customer4.setBank(bank1);
		customer4.setAccount(listAccount1);
		
		account1.setAccountNo("12345678911");
		account1.setAccountOpenningDate(LocalDate.now().toString());
		account1.setAccountStatus("Active");
		account1.setAccountType("Saving");
		account1.setBalance(45000);
		account1.setCustomer(customer1);
		account1.setAtmCard(atmCard1);
		account1.setTransaction(null);
		
		account2.setAccountNo("12345678911234");
		account2.setAccountOpenningDate(LocalDate.now().toString());
		account2.setAccountStatus("Active");
		account2.setAccountType("Current");
		account2.setBalance(65000);
		account2.setCustomer(customer2);
		account2.setAtmCard(atmCard2);
		account2.setTransaction(null);
		
		atmCard1.setCardNo("1234567891123456");
		atmCard1.setCardPin("1234");
		atmCard1.setCardStatus("Active");
		atmCard1.setCardType("Visa");
		atmCard1.setCvvNo("123");
		atmCard1.setIssueDate(LocalDate.now());
		atmCard1.setExpiryDate(LocalDate.of(2025, 11, 22));
		atmCard1.setAccount(account1);
		
		atmCard2.setCardNo("6543211987654321");
		atmCard2.setCardPin("4321");
		atmCard2.setCardStatus("Active");
		atmCard2.setCardType("Visa");
		atmCard2.setCvvNo("321");
		atmCard2.setIssueDate(LocalDate.now());
		atmCard2.setExpiryDate(LocalDate.of(2025, 11, 22));
		atmCard2.setAccount(account2);
		
		
		EntityManager entityManager = MyConnection.getEntityManagerObject();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		entityManager.persist(bank1);
		entityManager.persist(bank2);
       	entityTransaction.commit();
       	
        System.out.println("Object Saved Successfully !!!!");
		
		entityManager.close();
	
	}

}
