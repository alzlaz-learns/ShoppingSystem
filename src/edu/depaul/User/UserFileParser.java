package edu.depaul.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//class that implements FileParseInterface
//used to load user information from file
public class UserFileParser implements FileParseInterface{

	/*
	 * read through file which is going to be in the format of username,password
	 * Makes a list of user for UserRepository to find User.
	*/
	 @Override		
	 public List<User> parseFile(String filePath) {
	    List<User> users = new ArrayList<>();
	    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	        String line;
	        while ((line = br.readLine()) != null) {
	            String[] userDetails = line.split(",");
	            if (userDetails.length == 2) {
	                String username = userDetails[0].trim();
	                String password = userDetails[1].trim();
	                users.add(new User(username, password));
	            }
	        } 
	    } catch (IOException e) {
	        e.printStackTrace(); 
	    }
	    return users;
	}
}
