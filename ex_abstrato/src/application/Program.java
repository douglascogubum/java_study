package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> list = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers: ");
		int numberOfTaxPayers = sc.nextInt();
		
		for(int i = 1 ; i <= numberOfTaxPayers; i++)
		{
			System.out.println("Tax payer #" + i + " data: ");
			System.out.printf("Individual or company (i/c)?");
			char ch = sc.next().charAt(0);
			System.out.printf("Name: ");
			sc.nextLine();
			String Name = sc.nextLine();
			System.out.printf("Anual Income: ");
			Double anualIncome = sc.nextDouble();
			if(ch == 'i')
			{
				System.out.printf("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				TaxPayer individual = new Individual(Name, anualIncome, healthExpenditures);
				list.add(individual);
			} else {
				System.out.printf("Number of employees: ");
				int numberOfEmployees = sc.nextInt();
				TaxPayer company = new Company(Name, anualIncome,numberOfEmployees);
				list.add(company);
			}
		}
		
		System.out.println();
		System.out.println("TAXES PAIND:");
		Double totalTaxes = 0.0;
		
		for(TaxPayer taxes : list)
		{
			System.out.println(taxes.getName() + ": $ " + String.format("%.2f", taxes.tax()));
			totalTaxes += taxes.tax();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $" + String.format("%.2f", totalTaxes));
		
		sc.close();

	}
}
