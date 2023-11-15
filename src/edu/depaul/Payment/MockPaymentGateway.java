package edu.depaul.Payment;

//#2
public class MockPaymentGateway  implements PaymentGateway{

	@Override
	public PaymentResult processPayment(PaymentDetails paymentDetails) {
		return new PaymentResult(true);
	}

}
