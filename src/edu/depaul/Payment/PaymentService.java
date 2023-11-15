package edu.depaul.Payment;

//responsible for processing "payment"
public class PaymentService {
	 private PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public PaymentResult processPayment(PaymentDetails paymentDetails) {
        return paymentGateway.processPayment(paymentDetails);
    }
}
