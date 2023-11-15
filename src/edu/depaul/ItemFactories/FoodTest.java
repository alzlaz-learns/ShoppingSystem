package edu.depaul.ItemFactories;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FoodTest {
	private ProductInterface food;
	private AbstractProductFactory factory;
	@BeforeEach
	void setUp() {
		factory = new FoodFactory();
		food = factory.createProduct(1, "Apple", "Fresh apple", 0.99);
	}
	
	 @Test
    void testCreateFood() {

        assertNotNull(food);
        assertTrue(food instanceof Food);
        assertEquals(1, food.getId());
        assertEquals("Apple", food.getName());
        assertEquals("Fresh apple", food.getDescription());
        assertEquals(0.99, food.getPrice());

        if (food instanceof Food) {
            ((Food) food).setExp("12/31");
            assertEquals("12/31", ((Food) food).getExp());
        }
    }
	
}
