package edu.depaul.User;

//Contract for classes that implements this.
public interface FileWriteInterface {
	void saveNewUserToFile(String filePath, User user);
}
