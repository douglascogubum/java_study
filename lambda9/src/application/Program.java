package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

// c:\estudos_java\java_study\in-stream-ex.csv
public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> list = new ArrayList<>();
		
		System.out.print("Enter full file path: ");
		String path = sc.nextLine();
		
		System.out.print("Enter salary: ");
		double salaryLimit = sc.nextDouble();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(",");
				list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}
			
			List<String> filteredEmail = list.parallelStream()
										 .filter(s -> s.getSalary() > salaryLimit)
										 .map(e -> e.getEmail())
										 .sorted()
										 .collect(Collectors.toList());
			
			System.out.println("Email of people whose salary is more than " + String.format("%.2f", salaryLimit));
			filteredEmail.forEach(System.out::println);

			double avgSalary = list.stream()
							  .filter(n -> n.getName().charAt(0) == 'M')
							  .map(s -> s.getSalary())
							  .reduce(0.0, (x,y) -> x + y);
			
			System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", avgSalary));
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		sc.close();
	}
}
