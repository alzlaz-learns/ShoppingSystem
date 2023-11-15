package edu.depaul.ItemFactories;

//concrete implementation of ProductInterace
//food items perishables.
public class Food implements ProductInterface
{
	private int id;
	private String name;
	private String description;
	private double price;
	private String exp;
	
	public Food(int id, String name, String description, double price) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	@Override
	public void display() {
		System.out.println("Food ID: " + getId() + ", Food Name: " + getName() + ", Food Description: " + getDescription() + ", Food Price: " + getPrice() + ", Expiration: " + getExp());
	}

	public void setExp(String exp) {
		
		this.exp = exp;
	}
	
	public String getExp() {
		return exp;
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
		return getId() + "," + getName() + "," + getDescription() + "," + getPrice() + "," + getExp();
	}
}

//TODO next finish converting things to deal with Factory stuff. 1047 video