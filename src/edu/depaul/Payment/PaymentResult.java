package edu.depaul.Payment;

//#3 
//returns the results of a payment.
public class PaymentResult {
	private boolean success;
   
    public PaymentResult(boolean success) {
        this.setSuccess(success);
       
    }

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
