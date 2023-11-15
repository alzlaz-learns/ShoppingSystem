package edu.depaul.User;

import edu.depaul.Payment.PaymentDetails;

// User object that represents a basic User
public class User {
	private String username; 
	private String password;
	private PaymentDetails paymentDetails;
	
	public User(String userName, String password) {
		this.setUserName(userName);
		this.setPassword(password);
	}

    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }
	
	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
}
