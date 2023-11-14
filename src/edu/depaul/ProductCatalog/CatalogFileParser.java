package edu.depaul.ProductCatalog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.depaul.OrderingFactories.AbstractProductFactory;
import edu.depaul.OrderingFactories.Food;
import edu.depaul.OrderingFactories.ProductInterface;

public class CatalogFileParser implements CatalogParseInterface {

	private AbstractProductFactory foodFactory;
	private AbstractProductFactory otherFactory;
	public CatalogFileParser(AbstractProductFactory foodFactory, AbstractProductFactory otherFactory) {
		this.foodFactory = foodFactory;
		this.otherFactory = otherFactory;
	}
	
	
	@Override
	public List<ProductInterface> parseFile(String filePath) {
		 List<ProductInterface> products = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String line;
			while((line = br.readLine()) != null){
				String[] productInfo = line.split(",");
				int id = Integer.parseInt(productInfo[0].trim());
				String name = productInfo[1].trim();
				String description = productInfo[2].trim();
				double price = Double.parseDouble(productInfo[3].trim());

				if(productInfo.length == 4) {
					products.add(otherFactory.createProduct(id, name, description, price));
				}
				if(productInfo.length == 5) {
					String exp = productInfo[4].trim();
					Food f = (Food) foodFactory.createProduct(id, name, description, price);
					f.setExp(exp);
					products.add(f);
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return products;
	}
}
