package edu.depaul.ProductCatalog;

import edu.depaul.OrderingFactories.ProductInterface;
import edu.depaul.User.User;

public class CartBuilder {
	private Cart cart;
	
	public CartBuilder() {
		this.cart = Cart.getInstance();
	}
	
	
	public CartBuilder addProduct(ProductInterface product, int quantity) {
	    cart.addProduct(product, quantity);
	    return this;
	}
	
	public CartBuilder removeProduct(ProductInterface product, int quantity) {
	    cart.removeProduct(product, quantity);
	    return this;
	}
	
	public CartBuilder setUser(User user) {
	    cart.setUser(user.getUserName());
	    return this;
	}
	
	
	
	public void finalize() {
	   /*TODO somehow this
	    * Payment Processing:
		Simulate a payment processing system (e.g., using a mock payment gateway).
		Keep this module separate from the core shopping functionality.

	    * 
	    */
	}
}
