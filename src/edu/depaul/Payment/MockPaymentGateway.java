package edu.depaul.Payment;

//#2
//processes payment details and then if it passes it returns a boolean always will return true for the mock.
public class MockPaymentGateway  implements PaymentGateway{

	@Override
	public PaymentResult processPayment(PaymentDetails paymentDetails) {
		return new PaymentResult(true);
	}

}
