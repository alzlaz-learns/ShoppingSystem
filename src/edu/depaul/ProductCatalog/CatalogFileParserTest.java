package edu.depaul.ProductCatalog;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import edu.depaul.ItemFactories.AbstractProductFactory;
import edu.depaul.ItemFactories.Food;
import edu.depaul.ItemFactories.Other;
import edu.depaul.ItemFactories.ProductInterface;

class CatalogFileParserTest {

	 private CatalogFileParser parser;
	    private AbstractProductFactory foodFactory;
	    private AbstractProductFactory otherFactory;

	    @TempDir
	    Path tempDir; 

	    @BeforeEach
	    void setUp() {

	        foodFactory = new AbstractProductFactory() {
	            public ProductInterface createProduct(int id, String name, String description, double price) {
	                return new Food(id, name, description, price); 
	            }
	        };

	        otherFactory = new AbstractProductFactory() {
	            public ProductInterface createProduct(int id, String name, String description, double price) {
	                return new Other(id, name, description, price);
	            }
	        };

	        parser = new CatalogFileParser(foodFactory, otherFactory);
	    }
	    
	    @Test
	    void validFood() {
	    	Path file = tempDir.resolve("test.txt");
	    	try (BufferedWriter writer = Files.newBufferedWriter(file)) {
	            writer.write("1,Cereal,dummy yummy,4.99,11/22");
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	List<ProductInterface> products = parser.parseFile(file.toString());
	    	assertEquals(1, products.size());
	        assertTrue(products.get(0) instanceof Food);
	    }
	    
	    @Test
	    void validOther() {
	    	Path file = tempDir.resolve("test.txt");
	    	try (BufferedWriter writer = Files.newBufferedWriter(file)) {
	            writer.write("1,Cereal,dummy yummy,4.99\n");
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	List<ProductInterface> products = parser.parseFile(file.toString());
	    	assertEquals(1, products.size());
	        assertTrue(products.get(0) instanceof Other);
	    }


}
