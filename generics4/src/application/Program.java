package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		/*
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(10);
		intList.add(5);
		
		List<? extends Number> list = intList;
		Number x = list.get(0);
		list.add(20); // erro de compilacao (covariância)
		
		List<Object> myObjs = new ArrayList<Object>();
		myObjs.add("Maria");
		myObjs.add("Alex");
		
		List<? super Number> myNums = myObjs;
		myNums.add(10);
		myNums.add(3.14);
		Number x = myNums.get(0); // erro de compilacao (contracovariância)
		*/
		
		List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
		List<Double> myDoubles = Arrays.asList(3.14, 6.28);
		List<Object> myObjs = new ArrayList<Object>();
		
		copy(myInts, myObjs);
		printList(myObjs);
		copy(myDoubles, myObjs);
		printList(myObjs);
	}
	
	public static void copy(List<? extends Number> originList, List<? super Number> destinationList) {
		for (Number number : originList) {
			destinationList.add(number);
		}
	}
	
	public static void printList(List<?> list) {
		for (Object obj : list) {
			System.out.print(obj + " ");
		}
		System.out.println();
	}
}
