package edu.depaul.User;


//basic stuff think about the further options later.
public interface UserInterface {
	void save(User user);
	User findUserByName(String username);
	boolean isUNameAvailable(String username);
}