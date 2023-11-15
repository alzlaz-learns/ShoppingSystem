package edu.depaul.Payment;

public class MockPaymentGateway  implements PaymentGateway{

	@Override
	public PaymentResult processPayment(PaymentDetails paymentDetails) {
		return new PaymentResult(true);
	}

}
