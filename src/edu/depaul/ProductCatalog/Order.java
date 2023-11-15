package edu.depaul.ProductCatalog;

import java.util.Map;
import java.util.Map.Entry;

import edu.depaul.ItemFactories.ProductInterface;
import edu.depaul.User.User;
//Order Object representing the finalize result of Users cart
public class Order {
	private String orderId;
	private Map<ProductInterface, Integer> items;
	private double totalCost;
	private String username;
	
	   public Order(Cart cart, User user) {
	        this.orderId = generateOrderId();
	        this.items = cart.getItems();
	        this.totalCost = cart.getTotalCost();
	        this.username = user.getUserName();

	    }
	   
	   //bs order id generator
	    private String generateOrderId() {
	        
	        return "" + System.currentTimeMillis();
	    }

	    public String getOrderId() {
	        return orderId;
	    }
	    
	    public Map<ProductInterface, Integer> getItems() {
	        return items;
	    }

	    public double getTotalCost() {
	        return totalCost;
	    }

	    public String getUsername() {
	        return username;
	    }
	    
	    //generates a string representation once completed to display to a user.
	    public String reciept() {
	    	String r = "Order #: " + getOrderId() + System.lineSeparator() +  "User: " + getUsername() +  System.lineSeparator() + "Items: " +  System.lineSeparator();
	    	
	    	
	    	for (Entry<ProductInterface, Integer> entry : getItems().entrySet()) {
	            ProductInterface product = entry.getKey();
	            Integer quantity = entry.getValue();
	    		r += "\t" + quantity + " - " + product.getName() + " - " + String.format("%.2f", product.getPrice()) +  System.lineSeparator();
	    	}
	    	
	    	r += "Total cost: " +  String.format("%.2f", getTotalCost())+  System.lineSeparator();
	    	return r;
	    }
}
