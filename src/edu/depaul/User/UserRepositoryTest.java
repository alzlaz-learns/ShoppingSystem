package edu.depaul.User;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserRepositoryTest {

	class FPStub implements FileParseInterface {
	    private List<User> users;

	    public FPStub(List<User> users) {
	        this.users = users;
	    }

	    @Override
	    public List<User> parseFile(String filePath) {
	        return new ArrayList<>(users);
	    }
	}

	class FWStub implements FileWriteInterface {
	    private List<User> users;

	    public FWStub(List<User> users) {
	        this.users = users;
	    }

	    @Override
	    public void saveNewUserToFile(String filePath, User user) {
	        users.add(user);
	    }
	}
	private UserRepository userRepository;
    private FileParseInterface fpStub;
    private FileWriteInterface fwStub;
    private List<User> users;
    
    @BeforeEach
    void setUp() {
    	users = new ArrayList<User>();
    	fpStub = new FPStub(users);
    	fwStub = new FWStub(users);
    
    	 userRepository = new UserRepository("nope", fpStub, fwStub);
    }
	@Test
	void saveSucceed() {
		User u1 = new User("u1", "pass");
		userRepository.save(u1);
		assertEquals(1, users.size());
        assertEquals(u1, users.get(0));
	}
	
	@Test
	void save2Succeed() {
		User u1 = new User("u1", "pass");
		userRepository.save(u1);
		
		User u2 = new User("u2", "pass");
		userRepository.save(u2);
		assertEquals(2, users.size());
        assertEquals(u1, users.get(0));
        assertEquals(u2, users.get(1));
	}

	@Test
	void findUserSucceed() {
		User u1 = new User("u1", "pass");
		userRepository.save(u1);
		
		User res = userRepository.findUserByName("u1");
		assertNotNull(res);
		assertEquals(u1, res);
	}
	
}
