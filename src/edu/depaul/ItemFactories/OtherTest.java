package edu.depaul.ItemFactories;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OtherTest {

	private ProductInterface other;
	private AbstractProductFactory factory;
	@BeforeEach
	void setUp() {
		factory = new OtherFactory();
		other = factory.createProduct(1, "Apple", "Fresh apple", 0.99);
	}
	
	 @Test
    void testCreateFood() {

        assertNotNull(other);
        assertTrue(other instanceof Other);
        assertEquals(1, other.getId());
        assertEquals("Apple", other.getName());
        assertEquals("Fresh apple", other.getDescription());
        assertEquals(0.99, other.getPrice());

    }

}
