package edu.depaul.ProductCatalog;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import edu.depaul.ItemFactories.ProductInterface;
//implements the CatalogWriteInterface
public class CatalogFileWriter implements CatalogWriteInterface{
	
	//Writes a ProductInterface object(poorly named) to file 
	@Override
	public void saveNewProductToFile(String filePath, ProductInterface product) {
		String catalogInfo = product.toString() + System.lineSeparator();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true)))  {
			bw.write(catalogInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
