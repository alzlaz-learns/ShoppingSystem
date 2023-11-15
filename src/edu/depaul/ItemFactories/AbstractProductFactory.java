package edu.depaul.ItemFactories;

//creator
//factory
public interface AbstractProductFactory {
	ProductInterface createProduct(int id, String name, String description, double price);
}
