package com.sujata.basic.service;

import com.sujata.basic.entity.Customer;

public interface AtmService {
	   String deposite(Customer customer, Integer depositAmount);
	   String withdraw(Customer customer, Integer withdrawAmount);
	   Integer checkBalance(Customer customer);
	   String changePin(Customer customer,String newPin);
}
