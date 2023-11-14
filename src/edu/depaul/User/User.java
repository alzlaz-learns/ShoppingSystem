package edu.depaul.User;

import java.util.Map;

import edu.depaul.ProductCatalog.Cart;
import edu.depaul.ProductCatalog.CartInterface;
import edu.depaul.ProductCatalog.Product;

// Simple user object.
public class User {
	private String username;
	private String password;
	
	//add a cart 
	private CartInterface cart;
	
	public User(String userName, String password) {
		this.setUserName(userName);
		this.setPassword(password);
		this.cart = new Cart();
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

    public void addToCart(Product product, int quantity) {
        cart.addProduct(product, quantity);
    }

    public void removeFromCart(Product product, int quantity) {
        cart.removeProduct(product, quantity);
    }

    public Map<Product, Integer> viewCartItems() {
        return cart.getItems();
    }
}
