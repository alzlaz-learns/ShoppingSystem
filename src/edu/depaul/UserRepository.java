package edu.depaul;

import java.util.List;

public class UserRepository implements UserInterface{
	
	private FileParseInterface  fileParser;
	private FileWriteInterface  fileWriter;
	private String filePath;
	
	public UserRepository(String filePath, FileParseInterface fileParser, FileWriteInterface fileWriter) {
		 this.filePath = filePath;
	        this.fileParser = fileParser;
	        this.fileWriter = fileWriter;
	}
	
	//call file writer interface
	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		fileWriter.saveNewUserToFile(filePath, user);
	}

	//call file parser interface
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
}
