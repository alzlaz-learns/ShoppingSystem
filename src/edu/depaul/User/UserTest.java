package edu.depaul.User;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.depaul.Payment.PaymentDetails;

class UserTest {

    private User user;
    private final String username = "testUser";
    private final String password = "testPass";
    private PaymentDetails paymentDetails;

    @BeforeEach
    void setUp() {
        user = new User(username, password);
        paymentDetails = new PaymentDetails(); 
        user.setPaymentDetails(paymentDetails);
    }

    @Test
    void testGetUserName() {
        assertEquals(username, user.getUserName());
    }

    @Test
    void testGetPassword() {
        assertEquals(password, user.getPassword());
    }

    @Test
    void testSetUserName() {
        String newUsername = "newTestUser";
        user.setUserName(newUsername);
        assertEquals(newUsername, user.getUserName());
    }

    @Test
    void testSetPassword() {
        String newPassword = "newTestPass";
        user.setPassword(newPassword);
        assertEquals(newPassword, user.getPassword());
    }
}
