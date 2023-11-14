package edu.depaul.ProductCatalog;

import java.util.List;

import edu.depaul.OrderingFactories.ProductInterface;

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
		List<ProductInterface> catalogList = catalog.getAllProducts();
		for(ProductInterface p : catalogList) {
			cw.saveNewProductToFile(filePath, p);
		}
	}

	@Override
	public void loadFromFile(String filePath) {
		List<ProductInterface> p = cp.parseFile(filePath);
		for (ProductInterface product : p) {
            catalog.addProduct(product);
        }
	}
}
