package edu.depaul.ProductCatalog;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.depaul.ItemFactories.ProductInterface;
import edu.depaul.User.User;

class OrderTest {

	private Order order;
    private Cart cart;
    private User user;
    private Map<ProductInterface, Integer> productsInCart;

    @BeforeEach
    void setUp() {

        cart = Cart.getInstance();
        user = new User("TestUser", "password123");
        
        productsInCart = new HashMap<>();
        ProductInterface product1 = new ProductInterface() {
            @Override
            public int getId() { return 1; }
            @Override
            public String getName() { return "TestProduct1"; }
            @Override
            public double getPrice() { return 10.0; }
            // Other methods if needed
			@Override
			public void display() {
				// TODO Auto-generated method stub
				
			}
			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return null;
			}
        };
        productsInCart.put(product1, 2);
        for (Map.Entry<ProductInterface, Integer> entry : productsInCart.entrySet()) {
        	ProductInterface p = entry.getKey();
        	int q = entry.getValue();
	        cart.addProduct(p,q );
		}
        
       
        
        order = new Order(cart, user);
        cart.clear();
    }

    @Test
    void orderNonNull() {
        assertNotNull(order.getOrderId());
        
    }
    
    @Test
    void orderEqualToList() {
    	assertEquals(productsInCart, order.getItems());
    }
    
    @Test
    void orderCostEqual() {
    	 assertEquals(20.0, order.getTotalCost());
         
    }
    
    @Test
    void usernameEqual(){
    	assertEquals("TestUser", order.getUsername());
    }


}
