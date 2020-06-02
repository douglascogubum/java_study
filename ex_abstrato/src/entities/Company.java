package entities;

public class Company extends TaxPayer{
	public int numberOfEmployees;

	public Company() {
	}

	public Company(String name, Double anualIncome, int numberOfEmployees) {
		super(name, anualIncome);
		this.numberOfEmployees = numberOfEmployees;
	}

	public int getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(int numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}

	@Override
	public Double tax() {
		Double taxes = 0.0;
		if(numberOfEmployees > 10) {
			taxes = anualIncome * 0.14;
		} 
		else {
			taxes = anualIncome * 0.16;
		}
		return taxes;
	}
	
	
}
