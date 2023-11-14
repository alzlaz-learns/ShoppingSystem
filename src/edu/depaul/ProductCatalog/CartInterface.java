package edu.depaul.ProductCatalog;

import java.util.Map;

import edu.depaul.OrderingFactories.ProductInterface;

public interface CartInterface {
	void addProduct(ProductInterface product, int quantity);
	void removeProduct(ProductInterface product, int quantity);
	void clear();
	double getTotalCost();
	void setUser(String user);
	Map<ProductInterface, Integer> getItems();
	void displayCart();
	//maybe consider a break cost down if i have time.
}
