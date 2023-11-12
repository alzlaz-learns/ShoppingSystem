package edu.depaul;

public class Runner {

	public static void main(String[] args) {
		
		//testing area to see what works and doesnt.
		String filePath = "path/to/users.txt";
        FileHandler fileHandler = new FileHandler(); 
        UserRepository userRepository = new UserRepository(filePath, fileHandler, fileHandler);
	}
}
 