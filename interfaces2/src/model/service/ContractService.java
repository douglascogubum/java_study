package model.service;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private Calendar calendar = Calendar.getInstance();
	
	private OnlinePaymentService payment;
	
	public ContractService() {
	}
	
	public ContractService(OnlinePaymentService payment) {
		this.payment = payment;
	}
	
	public OnlinePaymentService getPayment() {
		return payment;
	}

	public void setPayment(OnlinePaymentService payment) {
		this.payment = payment;
	}

	public void processContract(Contract contract, Integer months) {
		
		double valuePayment = contract.getTotalValue() / months;
		
		Date dateOfBuy = contract.getDate();
		calendar.setTime(dateOfBuy);
		
		for(int i = 1; i <= months; i++) {
			double interest = payment.interest(valuePayment, i);
			double amount = payment.paymentFee(interest);
			
			calendar.add(Calendar.DAY_OF_YEAR, 31);
			Date dueDate = calendar.getTime();

			Installment installment = new Installment(dueDate, amount);
			contract.addInstallment(installment);
		}		
	}
}
