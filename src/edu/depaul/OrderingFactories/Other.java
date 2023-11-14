package edu.depaul.OrderingFactories;

public class Other implements ProductInterface{
	private int id;
	private String name;
	private String description;
	private double price;
	
	public Other(int id, String name, String description, double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
}
