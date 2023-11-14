package edu.depaul.ProductCatalog;

import edu.depaul.OrderingFactories.ProductInterface;

public interface CatalogWriteInterface {
	void saveNewProductToFile(String filePath, ProductInterface product);
}
