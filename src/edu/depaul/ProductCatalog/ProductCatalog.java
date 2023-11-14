package edu.depaul.ProductCatalog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductCatalog implements ProductCatalogInterface{

	 private Map<Integer, Product> products = new HashMap<>();
	 
	@Override
	public void addProduct(Product product) {
		products.put(product.getId(), product);
	}

	@Override
	public void removeProductByID(int productId) {
		products.remove(productId);
	}

	@Override
	public Product getProductById(int productId) {
		return products.get(productId);
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> catalogList = new ArrayList<>();
		for (Map.Entry<Integer, Product> entry: products.entrySet() ) {
			Product product = entry.getValue();
			catalogList.add(product);
		}
		return catalogList;
	}
}
