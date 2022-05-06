package projects.bank;

import java.util.Scanner;

public class BankAccount {
	
	private int balance;
	private int previousTransaction;
	String name;
	String customerId;
	
	
	
	public BankAccount(String name, String customerId) {
		super();
		this.name = name;
		this.customerId = customerId;
	}

	public void deposit(int amount) {
		
		if (amount > 0) {
			
			balance = balance + amount;
			previousTransaction = amount;
			
//			System.out.println("\nYou Deposited " + amount + "\nYour New Balance Is: " + balance);
			System.out.printf("%nYou Deposited: %+,d%nYour New Balance Is: %+,d", amount, balance);
		}
	}
	
	public void withdraw(int amount) {
		
		if(amount > 0) {
			
			balance = balance - amount;
			previousTransaction = -amount;
			
//			System.out.println("\nYou Withdrew " + amount + "\nYour New Balance Is: " + balance);
			System.out.printf("%nYou Withdrew: %+,d%nYour New Balance Is: %+,d", -amount, balance);
		}
	}
	
	public void getTransactionHistory() {
		
		if(previousTransaction > 0) {
			System.out.printf("%nDeposit: %+,d%n", previousTransaction);
		}else if(previousTransaction < 0) {
			System.out.printf("%nWithdrawal: %+,d%n", previousTransaction);
		}else {
			System.out.println("No transaction");
		}
	}
	
	public void menu() {
		
		char option ='0' ;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome "+ name);
		System.out.println("Your ID Is: "+ customerId);
		System.out.println("\n");
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Transaction History");
		System.out.println("E. Exit");
		
		while(option != 'E') {
		
		System.out.println("========================");
		System.out.println("Please Choose An Option:");
		System.out.println("========================");
		option = scan.next().toUpperCase().charAt(0);
		System.out.println("\n");
		
		
		switch(option) {
		
			case 'A':
				if(balance == 0) {
					System.out.println("Your Balance is: " + balance);
				}else {
				System.out.println("---------------------");
				System.out.printf("Your Balance Is: %+,d%n", balance);
				System.out.println("---------------------");
				System.out.println("\n");
				}
				break;
				
			case 'B':
				System.out.println("---------------------");
				System.out.println("Enter Deposit Amount: ");
				System.out.println("---------------------");
				int deposit = scan.nextInt();
				deposit(deposit);
				System.out.println("\n");
				break;
				
			case 'C':
				System.out.println("---------------------");
				System.out.println("Enter Withdrawal Amount: ");
				System.out.println("---------------------");
				int withdrawal = scan.nextInt();
				withdraw(withdrawal);
				System.out.println("\n");
				break;
				
			case 'D':
				System.out.println("---------------------");
				System.out.println("Your Last Transaction Was: ");
				getTransactionHistory();
				System.out.println("---------------------");
				System.out.println("\n");
				break;
				
			case 'E':
				System.out.println("Thank you. Goodbye!");
				break;
				
		
			default:
				System.out.println("Invalid Input. Please Try Again\n");
		}
	}

}
}