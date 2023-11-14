package edu.depaul.User;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

class UserFileParserTest {
	private UserFileParser ufp;
	
	@TempDir
    Path tempDir;
	
	@BeforeEach
	void setUp() {
		ufp = new UserFileParser();
	}
	
	
	@Test
	void findUNPW() {
		Path filePath = tempDir.resolve("users.txt");
		
		try {
			Files.writeString(filePath, "u1,pass\nu2,pass");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<User> users = ufp.parseFile(filePath.toString());
		
		assertEquals(2, users.size());
        assertEquals("u1", users.get(0).getUserName());
        assertEquals("pass", users.get(0).getPassword());
        assertEquals("u2", users.get(1).getUserName());
        assertEquals("pass", users.get(1).getPassword());
	}

	@Test
	void emptyFile() {
		Path filePath = tempDir.resolve("users.txt");
		
		try {
			Files.createFile(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<User> users = ufp.parseFile(filePath.toString());
		
		assertTrue(users.isEmpty());
		
	}
}
