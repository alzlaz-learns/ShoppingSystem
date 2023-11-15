package edu.depaul.ProductCatalog;

import java.util.List;

import edu.depaul.ItemFactories.ProductInterface;


//class that implements the CatalogHandlerInterface
//meant to handle the reading and writing of Catalog files. using the CatalogWriteInterface CatalogParseInterface
public class CatalogHandler implements CatalogHandlerInterface{
	private ProductCatalog catalog;
	private CatalogWriteInterface cw;
	private CatalogParseInterface cp;
	
	public CatalogHandler(ProductCatalog catalog, CatalogWriteInterface cw, CatalogParseInterface cp) {
		 this.catalog = catalog;
		 this.cw = cw;
		 this.cp = cp;
	}
	
	//Calls CatalogWriteInterface to write all the items in ProductCatalog to a filepath in this case CatalogInfo.txt
	@Override
	public void saveToFile(String filePath) {
		List<ProductInterface> catalogList = catalog.getAllProducts();
		for(ProductInterface p : catalogList) {
			cw.saveNewProductToFile(filePath, p);
		}
	}

	//Calls CatalogWriteInterface to load from a filepath in this case CatalogInfo.txt to the ProductCatalog
	@Override
	public void loadFromFile(String filePath) {
		List<ProductInterface> p = cp.parseFile(filePath);
		for (ProductInterface product : p) {
            catalog.addProduct(product);
        }
	}
}
