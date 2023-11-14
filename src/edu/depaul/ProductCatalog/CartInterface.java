package edu.depaul.ProductCatalog;

import java.util.Map;

public interface CartInterface {
	void addProduct(Product product, int quantity);
	void removeProduct(Product product, int quantity);
	void clear();
	double getTotalCost();
	Map<Product, Integer> getItems();
	//maybe consider a break cost down if i have time.
}
