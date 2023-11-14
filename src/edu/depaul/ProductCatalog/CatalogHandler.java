package edu.depaul.ProductCatalog;

import java.util.List;

public class CatalogHandler implements CatalogHandlerInterface{
	private ProductCatalog catalog;
	private CatalogWriteInterface cw;
	private CatalogParseInterface cp;
	
	public CatalogHandler(ProductCatalog catalog, CatalogWriteInterface cw, CatalogParseInterface cp) {
		 this.catalog = catalog;
		 this.cw = cw;
		 this.cp = cp;
	}
	
	@Override
	public void saveToFile(String filePath) {
		List<Product> catalogList = catalog.getAllProducts();
		for(Product p : catalogList) {
			cw.saveNewProductToFile(filePath, p);
		}
	}

	@Override
	public void loadFromFile(String filePath) {
		List<Product> p = cp.parseFile(filePath);
		for (Product product : p) {
            catalog.addProduct(product);
        }
	}

}
