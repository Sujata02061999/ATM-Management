package com.sujata.basic.presentation;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sujata.basic.entity.Customer;
import com.sujata.basic.service.CustomerService;
import com.sujata.basic.service.CustomerServiceImpl;

public class Login {

	public static void main(String[] args) {

		boolean flagCardNo = true;
		boolean flagCardPin = true;
		
		Scanner scanner =new Scanner(System.in);
		CustomerService customerService = new CustomerServiceImpl();
		
		Integer remainingAttempts = 3;
		
		while(flagCardNo && remainingAttempts>0) {
			System.out.println("Enter your ATM card number :: ");
			String cardNo = scanner.next();
			
			Integer remainingAttempt = 3;
			 Customer customer2 = customerService.findCardNumber(cardNo);
			 
			 if(customer2 != null && isValidCardNumber(cardNo)) {
				flagCardNo= false;
				while(flagCardPin && remainingAttempt>0) {
					System.out.println("Enter your PIN ::");
					String pinNo = scanner.next();
					
					if(isValidPin(pinNo) && pinNo.equals(customer2.getAccount().get(0).getAtmCard().getCardPin())) {
						flagCardPin = false;
						
						MainApp.displayMenu(customer2);
						break;
					}
					else {
						remainingAttempt--;
						
						if(remainingAttempt>0) {
							System.out.println();
							System.out.println("Invalid PIN Number. Please try again. ");
						}
						else {
							System.out.println();
							System.out.println("Too many unsuccessfull attempts. Sorry try next time. ");
							break;
						}
					}
				}
			 }
			 else {
				 remainingAttempts--;
					
					if(remainingAttempts>0) {
						System.out.println();
						System.out.println("Invalid ATM cardNumber. Please try again. ");
						System.out.println();
					}
					else {
						System.out.println();
						System.out.println("Too many unsuccessfull attempts. Sorry try next time. ");
						break;
					     }
			 }
		}

	}

	private static boolean isValidPin(String pinNo) {
		 String cardNumber = "\\d{4}";
		 if(pinNo.matches(cardNumber)) {
			 return true;
		 }
		 else {
		     return false;
	}

	}
	private static boolean isValidCardNumber(String cardNo) {
		 String cardNumber = "\\d{16}";
		 if(cardNo.matches(cardNumber)) {
			 return true;
		 }
		 else {
		     return false;
		 }
	}

}
