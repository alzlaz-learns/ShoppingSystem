package edu.depaul.ProductCatalog;

import edu.depaul.ItemFactories.ProductInterface;

//contract for classes to implement
public interface CatalogWriteInterface {
	void saveNewProductToFile(String filePath, ProductInterface product);
}
