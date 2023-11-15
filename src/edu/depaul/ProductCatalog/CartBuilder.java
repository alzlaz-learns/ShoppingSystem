package edu.depaul.ProductCatalog;

import java.util.Map;


import edu.depaul.OrderingFactories.ProductInterface;
import edu.depaul.Payment.MockPaymentGateway;
import edu.depaul.Payment.PaymentResult;
import edu.depaul.Payment.PaymentService;
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
	
	
	public Map<ProductInterface, Integer> viewCartContents() {
        return cart.getItems();
    }
	
	public void displayCartContents() {
        Map<ProductInterface, Integer> items = cart.getItems();
        if (items.isEmpty()) {
            System.out.println("The cart is empty.");
        } else {
            System.out.println("Cart Contents:");
            for (Map.Entry<ProductInterface, Integer> entry : items.entrySet()) {
                ProductInterface product = entry.getKey();
                Integer quantity = entry.getValue();
                System.out.println(quantity + "x " + product.getName() + " - $" + String.format("%.2f", product.getPrice()));
            }
            System.out.println("Total Cost: $" + cart.getTotalCost());
        }
    }
	
	public Order finalize(User user) {
	   /*TODO somehow this
	    * Payment Processing:
		Simulate a payment processing system (e.g., using a mock payment gateway).
		Keep this module separate from the core shopping functionality.

	    * 
	    */
		PaymentService paymentService = new PaymentService(new MockPaymentGateway());
        PaymentResult paymentResult = paymentService.processPayment(user.getPaymentDetails());

        //technically always an success 
        if (paymentResult.isSuccess()) {
            Order order = new Order(cart, user);
            Cart.getInstance().clear();
            return order;
        } else{
        	System.out.println("submitting order failed");
        	return null;
        }
	}
}
