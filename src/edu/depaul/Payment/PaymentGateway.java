package edu.depaul.Payment;

public interface PaymentGateway {
	PaymentResult processPayment(PaymentDetails paymentDetails);
}
