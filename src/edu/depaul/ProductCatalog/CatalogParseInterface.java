package edu.depaul.ProductCatalog;

import java.util.List;
import edu.depaul.ItemFactories.ProductInterface;

//contract for classes to implement
public interface CatalogParseInterface {
	List<ProductInterface> parseFile(String filePath);
}
