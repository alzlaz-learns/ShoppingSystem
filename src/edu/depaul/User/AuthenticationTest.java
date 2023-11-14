package edu.depaul.User;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AuthenticationTest {

	class URStub implements UserInterface{

		final List<User> users = new ArrayList<>();
		
		@Override
		public void save(User user) {
			// TODO Auto-generated method stub
			users.add(user);
		}

		@Override
		public User findUserByName(String username) {
			// TODO Auto-generated method stub
			for (User user : users) {
	            if (user.getUserName().equals(username)) {
	                return user;
	            }
	        }
	        return null;
		}
		
		@Override
		public boolean isUNameAvailable(String username) {
	        for (User user : users) {
	            if (user.getUserName().equals(username)) {
	                return false;
	            }
	        }
	        return true;
	    }
		
	}
	
    private Authentication authentication;
    private URStub userRepositoryStub;

    @BeforeEach
    void setUp() {
        userRepositoryStub = new URStub();
        authentication = new Authentication(userRepositoryStub);
    }
	
	@Test
	void registerSucceed() {
		String username = "newUser";
        String password = "newPass";
        
        assertTrue(userRepositoryStub.isUNameAvailable(username));
        authentication.register(username, password);
        
        User user = userRepositoryStub.findUserByName(username);
        assertNotNull(user);
        assertEquals(username, user.getUserName());
	}

	@Test
	void registerFailedUNtaken() {
        String username = "user";
        String password = "pass";
        authentication.register(username, password); 

        assertFalse(userRepositoryStub.isUNameAvailable(username));
        
        int before = userRepositoryStub.users.size();
        authentication.register(username, "newPass"); 
        int after = userRepositoryStub.users.size();
        
        assertEquals(before, after); 
	}
	@Test
	void loginSucceed() {
		String username = "user";
        String password = "pass";
        authentication.register(username, password);
        
        User user = authentication.login(username, password);
        
        assertNotNull(user);
        assertEquals(username, user.getUserName());
	}
	
	@Test
	void loginFailedUN() {
		String username = "user";
        String password = "pass";
        authentication.register(username, password);
        
        User user = authentication.login("wrong", password);
        
        assertNull(user);
	}
	
	@Test
	void loginFailedPW() {
		String username = "user";
        String password = "pass";
        authentication.register(username, password);
        
        User user = authentication.login(username, "wrong");
        
        assertNull(user);
	}
}
 