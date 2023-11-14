package edu.depaul;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import edu.depaul.ProductCatalog.ProductCatalog;
import edu.depaul.User.Authentication;
import edu.depaul.User.User;
import edu.depaul.User.UserFileParser;
import edu.depaul.User.UserFileWriter;
import edu.depaul.User.UserRepository;

public class Runner {

	public static void sampleGenerator(String catalogFile, ProductCatalog catalog ) {
		
	}
	public static void resourceCheck(String directory, String userFile, String catalogFile) {
		File dir = new File(directory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
		
        File usersInfoFile = new File(userFile);
		if (!usersInfoFile.exists()) {
            try {
                usersInfoFile.createNewFile();
            } catch (IOException e) {
                System.out.println("An error occurred while creating UsersInfo.txt.");
                e.printStackTrace();
            }
        }
		File catalogInfoFile = new File(catalogFile);
		if (!catalogInfoFile.exists()) {
            try {
            	catalogInfoFile.createNewFile();
            } catch (IOException e) {
                System.out.println("An error occurred while creating CatalogInfo.txt.");
                e.printStackTrace();
            }
        }
	}
	
	public static User startUp(Scanner sc, Authentication auth) {
		String input;
        while(true) {
            System.out.println("Enter command (type 'quit' to exit):");
            System.out.println("Enter command (type 'login' to exit):");
            System.out.println("Enter commands (type 'register' to exit):");
        	input = sc.nextLine();
            if ("quit".equals(input)) {
                break;
            }
            
            if ("login".equals(input)) {
            	System.out.print("Please enter username: ");
            	String username = sc.nextLine();
            	System.out.println("user name: " + username);
            	System.out.print("Please enter password: ");
            	String password = sc.nextLine();
            	System.out.println("password: " + password);
            	User u = auth.login(username, password);
            	if(u != null) {
            		return u;
            	}
            }
            
            else if ("register".equals(input)) {
            	System.out.print("Please enter username: ");
            	String username = sc.nextLine();
            	System.out.println("user name: " + username);
            	System.out.print("Please enter password: ");
            	String password = sc.nextLine();
            	System.out.println("password: " + password);
            	auth.register(username, password);
            }
           
            else {
            	System.out.println("invalid command");
            }
        }
		return null;
	}
	
	public static void main(String[] args) {
		
		String directory = "Resources";
		String catalogFile = directory + "/CatalogInfo.txt";
        String userFile = directory + "/UsersInfo.txt";
        UserFileParser ufp = new UserFileParser();
        UserFileWriter ufw = new UserFileWriter();
        UserRepository ur = new UserRepository(userFile, ufp, ufw);
        
        Authentication auth = new Authentication(ur);
        resourceCheck(directory, userFile, catalogFile);

        Scanner sc = new Scanner(System.in);
        
        User currentUser = startUp(sc, auth);
        if(currentUser != null) {
        	System.out.print("success");
        }
        else {
        	System.out.print("fail");
        }
    }
}
 