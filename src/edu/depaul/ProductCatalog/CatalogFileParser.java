package edu.depaul.ProductCatalog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CatalogFileParser implements CatalogParseInterface {

	@Override
	public List<Product> parseFile(String filePath) {
		List<Product> products = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String line;
			while((line = br.readLine()) != null){
				String[] productInfo = line.split(",");
				if(productInfo.length == 4) {
					int id = Integer.parseInt(productInfo[0].trim());
					String name = productInfo[1].trim();
					String description = productInfo[2].trim();
					double price = Double.parseDouble(productInfo[3].trim());
					products.add(new Product(id, name, description, price));
				}
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return products;
	}
}
