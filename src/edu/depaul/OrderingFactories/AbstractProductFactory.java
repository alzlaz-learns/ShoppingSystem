package edu.depaul.OrderingFactories;

//creator
public interface AbstractProductFactory {
	ProductInterface createProduct(int id, String name, String description, double price);
}
