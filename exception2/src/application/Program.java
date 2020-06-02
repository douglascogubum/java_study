package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.WithdrawException;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = Integer.parseInt(sc.nextLine());
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			
			Account acc = new Account(number, holder, balance, withdrawLimit);
			
			System.out.println("");
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			acc.withdraw(amount);
			System.out.println("New balance: " + String.format("%.02f", acc.getBalance()));
		}
		catch(InputMismatchException input) {
			System.out.println("Is not a number!");
		}
		
		catch(WithdrawException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}
		
		sc.close();
	}

}