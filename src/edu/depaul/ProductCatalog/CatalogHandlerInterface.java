package edu.depaul.ProductCatalog;


//contract for classes to implement
public interface CatalogHandlerInterface {
    void saveToFile(String filePath);
    void loadFromFile(String filePath);
}
