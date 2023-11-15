package edu.depaul.ProductCatalog;

import java.util.List;

import edu.depaul.ItemFactories.ProductInterface;

//contract for classes to implement
public interface ProductCatalogInterface {
    void addProduct(ProductInterface product);
    void removeProductByID(int productId);
    ProductInterface getProductById(int productId);
    List<ProductInterface> getAllProducts();
}
