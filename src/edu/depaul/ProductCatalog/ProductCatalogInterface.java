package edu.depaul.ProductCatalog;

import java.util.List;

public interface ProductCatalogInterface {
    void addProduct(Product product);
    void removeProductByID(int productId);
    Product getProductById(int productId);
    List<Product> getAllProducts();
    //same deal add  more stuff if there is time.
}
