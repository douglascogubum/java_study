package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

// c:\estudos_java\java_study\in-generics-ex.txt
public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> election = new LinkedHashMap<>();
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(",");
				String candidate = fields[0];
				int votes = Integer.parseInt(fields[1]);
				int currentVotes = election.containsKey(candidate) ? election.get(candidate) : 0;
				election.put(candidate, currentVotes + votes);
				line = br.readLine();
			}
			
			for (String cand : election.keySet()) {
				System.out.println(cand + ": " + election.get(cand));
			}
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();

	}

}
