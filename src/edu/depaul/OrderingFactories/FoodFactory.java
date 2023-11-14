package edu.depaul.OrderingFactories;

import edu.depaul.ProductCatalog.Product;

public class FoodFactory implements AbstractProductFactory{

	@Override
	public ProductInterface createProduct(int id, String name, String description, double price) {
		return new Food(id,name,description,price);
	}
}
