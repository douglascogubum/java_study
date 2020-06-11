package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();
		
		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));
		
//		List<String> name = list.stream().map(new UpperCaseName()).collect(Collectors.toList());
//		List<String> name = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());
//		List<String> name = list.stream().map(Product::nonStaticUpperCaseName).collect(Collectors.toList());
		
		/*
		Function<Product, String> func = p -> p.getName().toUpperCase();
		List<String> name = list.stream().map(func).collect(Collectors.toList()); */

		List<String> name = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
		name.forEach(System.out::println);		
	}
}
