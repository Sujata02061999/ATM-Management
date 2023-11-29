package com.sujata.basic.presentation;

import com.sujata.basic.entity.Customer;

public interface AtmApp {
   void deposit(Customer customer);
   void withdraw(Customer customer);
   void checkBalance(Customer customer);
   void changePin(Customer customer);
}
