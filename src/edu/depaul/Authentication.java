package edu.depaul;

public class Authentication {

	private UserRepository userRepository;
	
	public Authentication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void register(String username, String password) {
		User user = new User(username, password);
        userRepository.save(user);
	}
	
	public boolean login(String username, String password) {
		User user = userRepository.findUserByName(username);
		if(user != null && user.getPassword().equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}
}
 