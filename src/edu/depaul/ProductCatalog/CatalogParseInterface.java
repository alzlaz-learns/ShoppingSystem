package edu.depaul.ProductCatalog;

import java.util.List;

import edu.depaul.OrderingFactories.ProductInterface;

public interface CatalogParseInterface {
	List<ProductInterface> parseFile(String filePath);
}
