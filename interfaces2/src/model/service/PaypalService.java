package model.service;

public class PaypalService implements OnlinePaymentService {
	
	private static final double feeRate = 1.0;
	private static final double monthlyRate = 1.02;
	private static final double totalMonth = 12.0;
	private static final double decimal = 100.0;
	private static final double rateFormula = 1.0;
	
	
	public Double paymentFee(Double amount) {
		return amount * monthlyRate;
	}

	public Double interest(Double amount, Integer months) {
		return amount * (rateFormula + ((feeRate * totalMonth) / decimal) * (double)(months / totalMonth));
	}
}
