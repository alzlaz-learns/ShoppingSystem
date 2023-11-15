package edu.depaul.User;

import java.util.Map;

import edu.depaul.OrderingFactories.ProductInterface;
import edu.depaul.Payment.PaymentDetails;
import edu.depaul.ProductCatalog.Cart;

// Simple user object.
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

    public void addToCart(ProductInterface product, int quantity) {
        Cart.getInstance().addProduct(product, quantity);
    }

    public void removeFromCart(ProductInterface product, int quantity) {
    	Cart.getInstance().removeProduct(product, quantity);
    }

    public Map<ProductInterface, Integer> viewCartItems() {
        return Cart.getInstance().getItems();
    }
}
