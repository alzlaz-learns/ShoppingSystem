package edu.depaul.User;

import java.util.List;


//class that implements Userinterface
//meant to write and load user information from file.
public class UserRepository implements UserInterface{
	
	private FileParseInterface  fileParser;
	private FileWriteInterface  fileWriter;
	private String filePath;
	
	public UserRepository(String filePath, FileParseInterface fileParser, FileWriteInterface fileWriter) {
		this.filePath = filePath;
		this.fileParser = fileParser;
		this.fileWriter = fileWriter;
	}
	
	//call file writer interface saves new user to filepath file (UserInfo.txt)
	@Override
	public void save(User user) {
		fileWriter.saveNewUserToFile(filePath, user);
	}

	//call file parser interface loads users into a list from filepath file (UserInfo.txt) if string username is found return user 
	@Override
	public User findUserByName(String username) {
		
		List<User> users = fileParser.parseFile(filePath);
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                return user;
            }
        }
        return null;
	}
	
	//checks if a userName is available.
	//call file parser interface loads users into a list from filepath file (UserInfo.txt) if string username is found false or true if name is available.
	@Override
	public boolean isUNameAvailable(String username) {
		List<User> users = fileParser.parseFile(filePath);
        for (User user : users) {
            if (user.getUserName().equals(username)) {
                return false;
            }
        }
        return true;
    }
}
