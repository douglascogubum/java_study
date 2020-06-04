package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.Students;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Set<Students> students = new HashSet<>();
		
		System.out.print("How many students for course A? ");
		int courseA = sc.nextInt();
		
		for(int i = 0; i < courseA; i++) {
			int code = sc.nextInt();
			students.add(new Students(code));
		}
		
		System.out.print("How many students for course B? ");
		int courseB = sc.nextInt();
		
		for(int i = 0; i < courseB; i++) {
			int code = sc.nextInt();
			students.add(new Students(code));
		}
		
		System.out.print("How many students for course C? ");
		int courseC = sc.nextInt();
		
		for(int i = 0; i < courseC; i++) {
			int code = sc.nextInt();
			students.add(new Students(code));
		}
		
		System.out.println("Total students: " + students.size());
		
		sc.close();

	}

}
