package edu.depaul.ProductCatalog;

import java.util.List;

import edu.depaul.OrderingFactories.ProductInterface;

public interface ProductCatalogInterface {
    void addProduct(ProductInterface product);
    void removeProductByID(int productId);
    ProductInterface getProductById(int productId);
    List<ProductInterface> getAllProducts();
    //same deal add  more stuff if there is time.
}
