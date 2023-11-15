package edu.depaul.Payment;

//#1
public interface PaymentGateway {
	PaymentResult processPayment(PaymentDetails paymentDetails);
}
