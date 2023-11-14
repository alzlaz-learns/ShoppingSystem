package edu.depaul.User;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class UserFileWriterTest {

	private UserFileWriter ufw;
	@TempDir
    Path tempDir;
	
	@BeforeEach
	void setUp() {
		ufw = new UserFileWriter();
	}
	
	@Test
	void writeFirstU() {
		Path filePath = tempDir.resolve("users.txt");
		
        User user = new User("u1", "pass");
        
        ufw.saveNewUserToFile(filePath.toString(), user);
        List<String> lines = null;
		try {
			lines = Files.readAllLines(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        assertEquals(1, lines.size());
        assertEquals("u1,pass", lines.get(0));
	}
	
	@Test
	void write2U() {
		Path filePath = tempDir.resolve("users.txt");
		
		User u1 = new User("u1", "pass");
		User u2 = new User("u2", "pass");
		
		ufw.saveNewUserToFile(filePath.toString(), u1);
		ufw.saveNewUserToFile(filePath.toString(), u2);
		
		List<String> uInfo = null;
		try {
			uInfo = Files.readAllLines(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(2, uInfo.size());
	}

}
