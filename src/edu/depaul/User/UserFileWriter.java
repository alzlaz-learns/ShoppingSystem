package edu.depaul.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UserFileWriter implements FileWriteInterface{

	// Write a new user to file in user,password format. 
		@Override
		public void saveNewUserToFile(String filePath, User user) {
			 String userInfo = user.getUserName() + "," + user.getPassword() + System.lineSeparator();
			 try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true)))  {
				bw.write(userInfo);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
