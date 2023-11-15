package edu.depaul.ProductCatalog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.depaul.ItemFactories.AbstractProductFactory;
import edu.depaul.ItemFactories.Food;
import edu.depaul.ItemFactories.ProductInterface;

//implements CatalogParseInterface to and AbstractProductFactoy to determine type of Item.
public class CatalogFileParser implements CatalogParseInterface {

	private AbstractProductFactory foodFactory;
	private AbstractProductFactory otherFactory;
	public CatalogFileParser(AbstractProductFactory foodFactory, AbstractProductFactory otherFactory) {
		this.foodFactory = foodFactory;
		this.otherFactory = otherFactory;
	}
	
	//reads file then splits line if length of 4 it would be an Other item if 5 that means it include expiration 
	//date then it would be a food item. Uses Factory pattern to create an object of that type and then adds it to a list of ProductInterfaces.
	//when completed returns them.
	@Override
	public List<ProductInterface> parseFile(String filePath)  {
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
					if (exp.matches("(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])")) {
				        f.setExp(exp);
				        products.add(f);
				    } else {
				        throw new Exception("Invalid date");
				    }
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
}
