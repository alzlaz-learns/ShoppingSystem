package edu.depaul.ProductCatalog;

import java.util.HashMap;
import java.util.Map;

import edu.depaul.OrderingFactories.ProductInterface;

public class Cart implements CartInterface{
	private static Cart instance;
	private Map<ProductInterface, Integer> cartMap;
	private String user;
	
	private Cart() {
		cartMap = new HashMap<>();
	}
	
	public static Cart getInstance(){
		if(instance == null) {
			instance = new Cart();
		}
		return instance;
	}

	@Override
	public void addProduct(ProductInterface product, int quantity) {
	    if (cartMap.containsKey(product)) {
	    	cartMap.put(product, cartMap.get(product) + quantity);
	    } else {
	    	cartMap.put(product, quantity); 
	    }
	}

	@Override
	public void removeProduct(ProductInterface product, int quantity) {
		if(!cartMap.containsKey(product)) {
			throw new IllegalArgumentException("Product not found in cart.");
		}
		
		if (quantity <= 0) {
	        throw new IllegalArgumentException("Quantity must be greater than zero.");
	    }
		
		int currentQuantity = cartMap.get(product);
	    if (currentQuantity > quantity) {
	    	cartMap.put(product, currentQuantity - quantity);
	    } else {
	    	cartMap.remove(product);
	    }
	}

	@Override
	public void clear() {
		cartMap.clear(); 
	}

	@Override
	public double getTotalCost() {
		double totalCost = 0;
	    for (Map.Entry<ProductInterface, Integer> entry : cartMap.entrySet()) {
	        totalCost += entry.getKey().getPrice() * entry.getValue();
	    }
	    return totalCost;
	}

	@Override
	public Map<ProductInterface, Integer> getItems() {
		return new HashMap<>(cartMap);
	}

	@Override
	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public void displayCart() {
		for (Map.Entry<ProductInterface, Integer> entry : cartMap.entrySet()) {
	        String line = entry.getKey().getName() + " " + entry.getValue() + "*"+ entry.getKey().getPrice() * entry.getValue();
	        System.out.println(line);
		}
		
		System.out.print(getTotalCost());
		
	}
}
