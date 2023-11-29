package com.sujata.basic.presentation;

import java.util.Scanner;

import com.sujata.basic.entity.Customer;

public class MainApp {
	public static void displayMenu(Customer customer2)
	{   
		AtmApp atmApp = new AtmAppImpl();
		Scanner sc = new Scanner(System.in);
		
		Integer choice=0;
		
		while(choice!=6)
		{
		
			System.out.println("                 *****************************");
			System.out.println("                     Well-Come To ATM System                          ");
			System.out.println("                 *****************************");
			
			System.out.println();
			System.out.println("Welcome "+ customer2.getCustomerName() +  "                                 AccountNumber : "  + customer2.getAccount().get(0).getAccountNo());
			System.out.println("1. Check Balance");
			System.out.println("2. Withdraw");
			System.out.println("3. Deposit");
			System.out.println("4. Mini Statement");
			System.out.println("5. Change Pin");
			System.out.println("6. Exit");
			
			System.out.println(" What would like to do ? ");
			
			choice=sc.nextInt();
			
			switch (choice) {
			case 1:
				atmApp.checkBalance(customer2);
				break;
				
			case 2:
				atmApp.withdraw(customer2);
				break;
				
			case 3:				
				atmApp.deposit(customer2);
				break;
				
			case 4:
				System.out.println("");
				
				break;
				
			case 5:
				atmApp.changePin(customer2);
				
				break;
				
			case 6:
				System.out.println("------------------Exit--------------------");
				System.exit(0);
			   

			default:
				System.out.println("Invalid choice...");
				break;
			}
		}
	}
}
