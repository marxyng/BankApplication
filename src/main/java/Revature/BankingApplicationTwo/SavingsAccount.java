package Revature.BankingApplicationTwo;

import java.util.Scanner;

public class SavingsAccount {
	
	
	double	Savbalance;
	double SavpreviousTransaction;
	String SavcustomerName;
	String SavcustomerId;
	
	void BankAccount(String Savcname, String Savcid)
	{
	SavcustomerName = Savcname;
	SavcustomerId = Savcid;
		
	}
	
	void deposit(double amount)
	{
		if(amount != 0 )
		{
			Savbalance = Savbalance + amount;
			SavpreviousTransaction = amount;
			
					}
	}
	
	void withdraw(double amount)
	{
		if(amount != 0)
		{
			Savbalance -= amount;
			SavpreviousTransaction = -amount;
		}
	}
	
	void getPreviousTransaction()
	{
		if(SavpreviousTransaction > 0)
		{
			System.out.println("Deposited: " + SavpreviousTransaction);
		}
		else if(SavpreviousTransaction < 0)
		{
		System.out.println("Withdrawn: "+Math.abs(SavpreviousTransaction));
		}
		else
		{
			System.out.println("No transaction occurred");
		}
}
	
	public void Register() {
		
		 
		Scanner scanner = new Scanner(System.in);
		System.out.print("What is your username? "  );
		 String c = scanner.next().toString();
	
		System.out.print("Your username is " + c);
	System.out.println("\n");
	Scanner scanMe = new Scanner(System.in);
	System.out.print("Type your password");
	String b = scanner.next().toString();
	System.out.println("Your password is saved!");
	SavcustomerName = c;
	
	
	
	}
	
	public void transfer(double amount, BankAccount acc) {
		if(this.Savbalance < amount) {
			System.out.println("Transfer failed");
		}
		else {
			this.Savbalance -= amount;
			acc.balance += amount;
			System.out.println("Account of " + this.SavcustomerName + "becomes $" + this.Savbalance);
			System.out.println("Account of " + acc.customerName + "becomes $" + acc.balance);
		}
	}

}
