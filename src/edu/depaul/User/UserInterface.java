package edu.depaul.User;


//Contract for classes that implements this.
public interface UserInterface {
	void save(User user);
	User findUserByName(String username);
	boolean isUNameAvailable(String username);
}
