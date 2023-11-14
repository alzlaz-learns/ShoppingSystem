package edu.depaul.OrderingFactories;

public class Food implements ProductInterface
{
	private int id;
	private String name;
	private String description;
	private double price;
	
	public Food(int id, String name, String description, double price) {
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

//TODO next finish converting things to deal with Factory stuff. 1047 video