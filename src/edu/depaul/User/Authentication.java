package edu.depaul.User;

public class Authentication {

	private UserInterface userRepository;
	
	public Authentication(UserInterface userRepository) {
		this.userRepository = userRepository;
	}
	
	public void register(String username, String password) {
		
		//checks if the username is available if so creates a user then writes it to file. else lets user know to try a different name.
		if(userRepository.isUNameAvailable(username)) {
			User user = new User(username, password); 
	        userRepository.save(user); 
	        System.out.println("User registered successfully.");
		}else {
			System.out.println("Username unavailable.");
		}
	}
	
	public User login(String username, String password) {
		User user = userRepository.findUserByName(username);
		if(user != null && user.getPassword().equals(password)) {
			return user;
		}
		else {
			return null;
		}
	}
}
 