package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.println("Enter file path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				String [] lineSplit = line.split(",");
				
				String productName = lineSplit[0];
				Double price = Double.parseDouble(lineSplit[1]);
				Integer quantity = Integer.parseInt(lineSplit[2]);

				Product product = new Product(productName,price,quantity);
				list.add(product);
				line = br.readLine();
			}
			
			File writePath = new File(path);
			String writeParent = writePath.getParent();
			
			new File(writeParent + "/out").mkdir();			
			String writePathFile = writeParent + "/out/summary.csv";
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(writePathFile))) {
				for (Product product : list) {
					String lineWrite = product.getProduct() + "," + String.format("%.2f", product.totalValue());
					bw.write(lineWrite);
					bw.newLine();
				}
				
				System.out.println(writePathFile + " CREATED!");
			}
			catch (IOException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		finally {
			sc.close();
		}
	}
}
