package com.revature;

import java.util.Scanner;   // we need this to process user inputs

public class BankAccount {
	
	public static void main (String[] args) {
		Scanner Input = new Scanner(System.in);
		int userInt;
		boolean quit = false;   // this needs to be false for as long as we are in the program. Changes to true when we want to quit/exit.
		float myBalance = 0f;
		
		do{
			System.out.println("= = = = = = = = = = = = = = = = = = = = = = = = = = = =");
			System.out.println("Welcome to Gringott's Wizarding Bank.");
			System.out.println("Please select from the following options.");
			System.out.println("1. Deposit into My Vault");
			System.out.println("2. Withdraw from My Vault");
			System.out.println("3. Count my gold");
			System.out.println("Remember, you can always tap 0 to exit.");
			System.out.println("=======================================================");
			
			
			userInt = Input.nextInt();
			
			
			// The switch statements are basically the Account Services that the Customer class has access to - ALL PUBLIC.
			switch (userInt) {
			
			case 1: // Deposit - instantiate a positive amount to deposit. Add that to float myBalance.
				float amount;
				System.out.println("How much would you like to deposit today?");
				amount = Input.nextFloat();
				if (amount <= 0) {
					System.out.println("We are unable to process this nonpositive amount.");
					
				} else {
					myBalance += amount;
					System.out.println("$" + amount + " has been deposited into your account.");
				}
				break;
				
			case 2: // Withdraw - instantiate a positive amount to withdraw (LESS than your balance). Subtract that from float myBalance.
				System.out.println("How much would you like to withdraw today?");
				amount = Input.nextFloat();
				if (amount <= 0 || amount > myBalance) {
					System.out.println("Our apologies. This transaction cannot be completed.");
				} else {
					myBalance -= amount;
					System.out.println("$" + amount+ " has been withdrawn from your account.");
				}
				break;
				
			case 3: // Check Balance - display float myBalance in dollars and cents.
				System.out.println("You currently have " + myBalance + " in your account.");
				break;
				
			case 0:
				quit = true;
				break;
				
			default: // Please make another selection.
				System.out.println("Please make another selection.");
				break;
				
			}
						
		} while(!quit);
		
		System.out.println("Goodbye!");
	}

}

// TO-DO - make a customer, employee, and admin classes with different privileges... use inheritance?
// public class Customer, protected class Employee, and default or private class Admin???
// Move this code over to your local repository, then push it to GitHub.
// refer to this site for the Big Picture: https://projectsgeek.com/2016/02/complete-banking-system-java-project.html
// This site gives you more trees, less forest: https://stackoverflow.com/questions/30066881/bank-account-java-program



/*I needed to see this happening in real-live Java code, so I used the following sites for reference:
 * https://www.javaforstudents.co.uk/Practice/Bank_account
 * https://www.javatpoint.com/post/java-scanner-nextint-method - my nextInt method was being weird.
 */