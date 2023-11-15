package edu.depaul.Payment;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MockPaymentGatewayTest {

	   @Test
	    void processPaymentSuccess() {
	        
	        PaymentGateway paymentGateway = new MockPaymentGateway();
	        PaymentDetails paymentDetails = new PaymentDetails();
	        paymentDetails.setCardNumber("1234566");
	        paymentDetails.setEXPDate("12/25");
	        paymentDetails.setCvv("123");
	        PaymentResult result = paymentGateway.processPayment(paymentDetails);
	        assertTrue(result.isSuccess());
	    }

}
