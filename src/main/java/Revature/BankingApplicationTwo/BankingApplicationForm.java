package Revature.BankingApplicationTwo;

import java.util.Scanner;

import javax.swing.JFrame;

import dao.UserDAO;
import model.User;

//import com.revature.app.BankAccount;

public class BankingApplicationForm {
	
	public static void main(String[] args) {
	
		Driver.logger.info("This is a user creating a transaction");
		
		
		BankAccount obj1 = new BankAccount("customer", "no Id");
		//obj1.Register(firstName, lastName);
		System.out.println("\n");
		System.out.println("----------------------------------------------------");
		System.out.println("\n");
		obj1.showMenu();
		
	}

}


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
		Driver.logger.info("This is a user creating a deposit");
	}
	
	void withdraw(double amount)
	{
		if(amount != 0)
		{
			balance = balance - amount;
			previousTransaction = -amount;
		}
		Driver.logger.info("This is a user creating a withdraw");
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
		Driver.logger.info("This is a user creating a previousTransaction");
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
	Driver.logger.info("This is a user registering");
	
	
	
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
		Driver.logger.info("This is a user creating a transfer");
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
		
		
		
		Driver.logger.info("This is a user creating a joint account");		
	}
	
	void showMenu() 
	{
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Welcome ");
		System.out.println("Thanks for trusting AppleChase Bank");
		//\n is a line break
		System.out.println("\n");
		System.out.println("A. Register");
		System.out.println("B. Check Balance");
		System.out.println("C. Deposit");
		System.out.println("D. Withdrew");
		System.out.println("E. Previous transaction");
		System.out.println("F. Open a joint account");
		System.out.println("G. Tranfer");
		System.out.println("H. Exit");
		
		do
		{
			System.out.println("===========================================");
			System.out.println("Enter an option");
			System.out.println("===========================================");
			option = scanner.next().charAt(0);
			System.out.println("\n");
			
			switch(option)
			{
			case 'A':
				//String name;
			System.out.println("------------------------------------");
			Register();
			System.out.println("------------------------------------");
		//System.out.println("What is your name");
		 //String lastName = scanner.toString();
			//System.out.println("\n");
			
		
			break;
			
			case 'B':
			System.out.println("=========================================");
			System.out.println("Balance "+ balance);
			System.out.println("=========================================");
			System.out.println("\n");
			break;
			
			case 'C':
				System.out.println("------------------------------------");
				System.out.println("Enter an amount to deposit: ");
				System.out.println("-------------------------------------");
				double amount = scanner.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;
				
			case 'D':
				System.out.println("-------------------------------------");
				System.out.println("Enter an amount to withdraw: ");
				System.out.println("--------------------------------------");
				double amount2 = scanner.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
				
			case 'E':
				System.out.println("------------------------------------");
				getPreviousTransaction();
				System.out.println("---------------------------------------");
				System.out.println("\n");
				break;
				
			case 'F':
				System.out.println("-------------------------------------------");
				Joint_Account();
				break;
				
			case 'G':
				System.out.println("------------------------------------");
				System.out.println("Enter an amount to Transfer: ");
				System.out.println("-------------------------------------");
				double amount3 = scanner.nextInt();
				transfer(amount3, Savbalance);
				System.out.println("\n");
				break;
				
			case 'H':
				System.out.println("************************************");
				break;

				
				default:
					System.out.println("Invalid Option!! Please enter again");
					break;
					
					
			
			}
			
		}while(option != 'E');
		
		System.out.println("Thank You for using our services");
	}
}