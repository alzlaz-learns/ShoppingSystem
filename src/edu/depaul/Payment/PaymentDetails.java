package edu.depaul.Payment;

//Object representing PaymentDatails gets cc string representation exp string representation and cvv string representation
public class PaymentDetails {
    private String cardNumber;
    private String exp;
    private String cvv;

	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getExpiryDate() {
		return exp;
	}
	public void setEXPDate(String exp) {
		this.exp = exp;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}   
    
}