package edu.depaul.ProductCatalog;

import java.util.HashMap;
import java.util.Map;

public class Cart implements CartInterface{
	private Map<Product, Integer> cartMap;
	
	public Cart() {
		this.cartMap = new HashMap<>();
	}

	@Override
	public void addProduct(Product product, int quantity) {
		// TODO Auto-generated method stub

	    if (cartMap.containsKey(product)) {
	    	cartMap.put(product, cartMap.get(product) + quantity);
	    } else {
	    	cartMap.put(product, quantity); 
	    }
	}

	@Override
	public void removeProduct(Product product, int quantity) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		cartMap.clear(); 
	}

	@Override
	public double getTotalCost() {
		// TODO Auto-generated method stub
		double totalCost = 0;
	    for (Map.Entry<Product, Integer> entry : cartMap.entrySet()) {
	        totalCost += entry.getKey().getPrice() * entry.getValue();
	    }
	    return totalCost;
	}

	@Override
	public Map<Product, Integer> getItems() {
		// TODO Auto-generated method stub
		return new HashMap<>(cartMap);
	}
}
