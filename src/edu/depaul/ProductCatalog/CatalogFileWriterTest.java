package edu.depaul.ProductCatalog;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import edu.depaul.ItemFactories.ProductInterface;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class CatalogFileWriterTest {

    @TempDir
    Path tempDir; 

    @Test
    void testSaveNewProductToFile() {
        CatalogFileWriter writer = new CatalogFileWriter();
        Path file = tempDir.resolve("catalog.txt");
        ProductInterface product = new ProductInterface() {
            @Override
            public String toString() {
                return "Product{id=1, name='TestProduct', price=9.99}";
            }


			@Override
			public void display() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public int getId() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public double getPrice() {
				// TODO Auto-generated method stub
				return 0;
			}
        };

        writer.saveNewProductToFile(file.toString(), product);


        String writtenText;
        try (BufferedReader br = new BufferedReader(new FileReader(file.toFile()))) {
            writtenText = br.readLine();
        } catch (IOException e) {
            fail("Failed to read from the file: " + e.getMessage());
            return;
        }

        assertNotNull(writtenText);
        assertEquals(product.toString(), writtenText.trim());
    }
}
