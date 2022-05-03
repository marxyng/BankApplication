package Revature.BankingApplicationTwo;

import java.util.Scanner;

import dao.UserDAO;
import model.User;

public class BankAdmin extends Employee {
	
	
	class BankAccount extends SavingsAccount
	{
		double balance;
		double previousTransaction;
		String customerName;
		String customerId;
		
		BankAccount(String cname, String cid)
		{
		customerName = cname;
		customerId = cid;
			
		}
	void deposit(double amount)
	{
		if(amount != 0 )
		{
			balance = balance + amount;
			previousTransaction = amount;
			
					}
	}
	
	void withdraw(double amount)
	{
		if(amount != 0)
		{
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	
	
	void getPreviousTransaction()
	{
		if(previousTransaction > 0)
		{
			System.out.println("Deposited: " + previousTransaction);
		}
		else if(previousTransaction < 0)
		{
		System.out.println("Withdrawn: "+Math.abs(previousTransaction));
		}
		else
		{
			System.out.println("No transaction occurred");
		}
}
	
	
	public void Register() {
		//String username = null;
		 
		Scanner scanner = new Scanner(System.in);
		System.out.print("What is your username? " );
		 String username = scanner.next().toString();
		 
	
		System.out.print("Your username is " + username );
	System.out.println("\n");
	Scanner scanMe = new Scanner(System.in);
	System.out.print("Type your password");
	String b = scanner.next().toString();
	System.out.println("Your password is saved!");
	customerName = username;
	User u = new User();
	u.password = b;
	u.username = username;
	UserDAO ud = new UserDAO();
	ud.create(u);
	
	}
	
	
public void transfer (double amount, double Savbalance ) {
		
		if(this.balance < amount) {
			System.out.println("Transfer failed");
		}
		else {
			this.balance -= amount;
			Savbalance += amount;
			System.out.println("Account of " + this.customerName  + " becomes $ " + this.balance);
			System.out.println("Account of " + SavcustomerName  + " becomes $ " + Savbalance);
		}
	}


public void Joint_Account() {
	Scanner scanner = new Scanner(System.in);
	System.out.println("What is your username?");
	String a = scanner.next().toString();
	System.out.println("Your username is " + a);
	System.out.println("\n");
	
	Scanner pw = new Scanner(System.in);
	System.out.println("Type your password!");
	String g = scanner.next().toString();
	System.out.println("Your password is saved!");
	System.out.println("\n");
	
	Scanner amicable = new Scanner(System.in);
	System.out.println("What is your partner username?");
	String t = scanner.next().toString();
	System.out.println("Your username is " + t);
	System.out.println("\n");
	
	Scanner pwTwo = new Scanner(System.in);
	System.out.println("Type person2's password!");
	String s = scanner.next().toString();
	System.out.println("Your password is saved!");
	System.out.println("\n");
	
	
	
	
}
	}

}
