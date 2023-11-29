package com.sujata.basic.presentation;

import java.util.Scanner;

import com.sujata.basic.entity.Customer;
import com.sujata.basic.service.AtmService;
import com.sujata.basic.service.AtmServiceImpl;

public class AtmAppImpl implements AtmApp {

	AtmService atmService = new AtmServiceImpl();
	Scanner scanner = new Scanner(System.in);
	
	@Override
	public void deposit(Customer customer) {
     System.out.println("Enter Amount :: ");
     Integer amount = scanner.nextInt();
     System.out.println(atmService.deposite(customer, amount));
	}

	@Override
	public void withdraw(Customer customer) {
		System.out.println("Enter Amount :: ");
	     Integer amount = scanner.nextInt();
	     System.out.println(atmService.withdraw(customer, amount));
	}

	@Override
	public void checkBalance(Customer customer) {
         Integer balance = atmService.checkBalance(customer);
         System.err.println("Your current Balance :: "+balance);
	}

	@Override
	public void changePin(Customer customer) {
		System.out.println("Enter new Pin :: ");
	     String newPin = scanner.next();
	     System.out.println(atmService.changePin(customer, newPin)); 		
	}

}
