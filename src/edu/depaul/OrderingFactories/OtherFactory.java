package edu.depaul.OrderingFactories;

public class OtherFactory implements AbstractProductFactory{

	@Override
	public ProductInterface createProduct(int id, String name, String description, double price) {
		// TODO Auto-generated method stub
		return new Other(id,name,description,price);
	}
}
