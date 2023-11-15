package edu.depaul.ProductCatalog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.depaul.ItemFactories.ProductInterface;

//class that implements ProductCatalogInterface
//meant to be the representation of the items in shop.
//other than using it to do initial population it isnt much used.
public class ProductCatalog implements ProductCatalogInterface{

	private Map<Integer, ProductInterface> products = new HashMap<>();
	
	@Override
	public void addProduct(ProductInterface product) {
		products.put(product.getId(), product);
	}

	@Override
	public void removeProductByID(int productId) {
		products.remove(productId);
	}

	@Override
	public ProductInterface getProductById(int productId) {
		return products.get(productId);
	}

	@Override
	public List<ProductInterface> getAllProducts() {
		List<ProductInterface> catalogList = new ArrayList<>();
		for (Map.Entry<Integer, ProductInterface> entry: products.entrySet() ) {
			ProductInterface product = entry.getValue();
			catalogList.add(product);
		}
		return catalogList;
	}
}
