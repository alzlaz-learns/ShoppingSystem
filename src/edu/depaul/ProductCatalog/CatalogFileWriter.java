package edu.depaul.ProductCatalog;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CatalogFileWriter implements CatalogWriteInterface{
	@Override
	public void saveNewProductToFile(String filePath, Product product) {
		String catalogInfo = product.toString()+ System.lineSeparator();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true)))  {
			bw.write(catalogInfo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
