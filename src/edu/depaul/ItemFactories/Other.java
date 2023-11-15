package edu.depaul.ItemFactories;


//concrete implementation of ProductInterace
//generic product items non perishables
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
		System.out.println("Item ID: " + getId() + ", Item Name: " + getName() + ", Item Description: " + getDescription() + ", Item Price: " + getPrice());
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return getId() + "," + getName() + "," + getDescription() + "," + getPrice();
	}

}
