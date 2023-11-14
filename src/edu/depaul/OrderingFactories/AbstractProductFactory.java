package edu.depaul.OrderingFactories;

import edu.depaul.ProductCatalog.Product;

//creator
public interface AbstractProductFactory {
	ProductInterface createProduct(int id, String name, String description, double price);
}
