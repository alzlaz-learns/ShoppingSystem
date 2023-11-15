package edu.depaul;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.depaul.Logging.ShopLogger;
import edu.depaul.OrderingFactories.AbstractProductFactory;
import edu.depaul.OrderingFactories.Food;
import edu.depaul.OrderingFactories.FoodFactory;
import edu.depaul.OrderingFactories.OtherFactory;
import edu.depaul.OrderingFactories.ProductInterface;
import edu.depaul.Payment.PaymentDetails;
import edu.depaul.ProductCatalog.CartBuilder;
import edu.depaul.ProductCatalog.CatalogFileParser;
import edu.depaul.ProductCatalog.CatalogFileWriter;
import edu.depaul.ProductCatalog.CatalogHandler;
import edu.depaul.ProductCatalog.Order;
import edu.depaul.ProductCatalog.ProductCatalog;
import edu.depaul.User.Authentication;
import edu.depaul.User.User;
import edu.depaul.User.UserFileParser;
import edu.depaul.User.UserFileWriter;
import edu.depaul.User.UserRepository;

public class Runner {

	public static void sampleChecker(String catalogFile) {
		try (BufferedReader br = new BufferedReader(new FileReader(catalogFile))) {
			if(br.readLine() == null) {
				System.out.println("generating sample content.");
				sampleGenerator(catalogFile);
			}
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
	}
	
	private static void sampleGenerator(String catalogFile) {
		Logger logger = ShopLogger.getLogger();
		AbstractProductFactory foodFactory = new FoodFactory();
		AbstractProductFactory otherFactory = new OtherFactory();
		ProductCatalog pc = new ProductCatalog();
        CatalogFileParser cfp = new CatalogFileParser(foodFactory, otherFactory);
        CatalogFileWriter cfw = new CatalogFileWriter();
        CatalogHandler ch = new CatalogHandler(pc, cfw, cfp);
	
		String sample = 
				"1,Cereal, dummy yummy,4.99,11/22\n" +
			    "2,Bread,Fresh when made,3.49,11/22\n" +
			    "3,Apples,yum only a coupe of worms,5.99,11/22\n" +
			    "4,Cheese,Milk aged for your pleasure,7.99,11/22\n" +
			    "5,Coffee,Good ol cuppa joe,8.99,11/22\n" +
			    "6,Almond Milk,Use it for your coffee,2.99,11/22\n" +
			    "7,Eggs,eggs,3.99,11/22\n" +
			    "8,Spaghetti,great with meathballs,1.99,11/22\n" +
			    "9,Oil,Food or car works great with both,10.99\n" +
			    "10,Blue,it taste toxic,2.49\n" +
			    "11,Chocolate,mwa chefs kiss,1.99,11/22\n" +
			    "12,Jam,strawberry,3.99,11/22\n" +
			    "13,Batteries,How shocking,5.49\n" +
			    "14,stake,the wooden kind for vampires,2.99\n" +
			    "15,raw garbage,Maybe its good,4.49";
		
	    String[] productEntries = sample.split("\n");
	    for (String entry : productEntries) {
	        String[] productData = entry.split(",");
	        int id = Integer.parseInt(productData[0].trim());
	        String name = productData[1].trim();
	        String description = productData[2].trim();
	        double price = Double.parseDouble(productData[3].trim());
	        
	        try {
	            if (productData.length == 5) {
	                String exp = productData[4].trim();
	                Food f = (Food) foodFactory.createProduct(id, name, description, price);
	                f.setExp(exp);
	                pc.addProduct(f);
	                logger.log(Level.INFO, "Added Food item: " + entry);
	            } else if (productData.length == 4) {
	                ProductInterface product = otherFactory.createProduct(id, name, description, price);
	                pc.addProduct(product);
	                logger.log(Level.INFO, "Added other item: " + entry);
	            }
	        } catch (NumberFormatException e) {
	            System.err.println("Error parsing product entry: " + entry);
	            logger.log(Level.INFO, "Error parsing product entry: " + entry);
	        }
	    }
	    ch.saveToFile(catalogFile);
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
            System.out.println("Enter command (type 'quit'):");
            System.out.println("Enter command (type 'login'):");
            System.out.println("Enter commands (type 'register'):");
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
            	User u = auth.register(username, password);
            	if(u != null) {
            		return u;
            	}
            }
           
            else {
            	System.out.println("invalid command");
            }
        }
		return null;
	}
	
	//passing reference of CatalogHandler
	public static void loop(Scanner sc, CatalogHandler ch, ProductCatalog pc, CartBuilder cb, User u) {
		Logger logger = ShopLogger.getLogger();
		
		String input;
		while(true) {
            System.out.println("Enter command (type 'quit' to exit):");
            System.out.println("Enter command (type 'shop' to see whats in the shop):");
            System.out.println("Enter commands (type 'add' to add to cart):");
            System.out.println("Enter commands (type 'cart' to view cart contents):");
            System.out.println("Enter commands (type 'order' to finalize order):");
            input = sc.nextLine();
            if ("quit".equals(input.trim())) {
                System.out.println("Goodbye");
            	break;
            }
            
            if ("shop".equals(input.trim())) {
            	for(ProductInterface p : pc.getAllProducts()) { //test code
            		p.display();
            	}
            }
            else if("order".equals(input.trim())){
            	PaymentDetails pd;
            	if(u.getPaymentDetails() == null) {
            		pd = new PaymentDetails();
            		System.out.println("We dont currently have your Card information please fill out to finalize order.");
            		System.out.print("Please enter credit card or debit card number: ");
            		String cardNumber = sc.nextLine();
            		System.out.print("Please enter ccv number: ");
            		String ccv = sc.nextLine();
            		System.out.print("Please enter expiration date: ");
            		String exp = sc.nextLine();
            		
            		pd.setCardNumber(cardNumber);
            		pd.setCvv(ccv);
            		pd.setEXPDate(exp);
            		u.setPaymentDetails(pd);
            		
            		
            	}
            	Order o = cb.finalize(u);
            	if (o != null) {
                    logger.log(Level.INFO, "Order successful: " + u.getUserName());
                    System.out.println(o.reciept());
                } else {
                    logger.log(Level.INFO, "Order failed: " + u.getUserName());
                }
            	System.out.println(o.reciept());
            	
            }
            
            else if("cart".equals(input.trim())) {
            	cb.displayCartContents();
            }
            
            else if("add".equals(input.trim())) {
            	System.out.print("Enter the product ID to add to cart: ");
                String productIdInput = sc.nextLine().trim();
                System.out.print("Enter the quantity: ");
                String quantityInput = sc.nextLine().trim();

                try {
                    int productId = Integer.parseInt(productIdInput);
                    int quantity = Integer.parseInt(quantityInput);
                    ProductInterface productToAdd = pc.getProductById(productId);
                    if (productToAdd == null) {
                        System.out.println("Product not found.");
                        logger.log(Level.INFO, "unable to fine productID: " + productId);
                        break;
                    }
                    if (quantity <= 0) {
                        System.out.println("Quantity must be greater than zero.");
                        logger.log(Level.INFO, "invalid amount: " + quantity);
                        break;
                    }
                    cb.addProduct(productToAdd, quantity);
                    logger.log(Level.INFO, "Successfully add : " + quantity + "-" + productToAdd.getName());
                    System.out.println("Added " + quantity + " of " + productToAdd.getName() + " to the cart.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid product ID or quantity. Please enter numeric values.");
                    logger.log(Level.INFO, "invalid input for productId or quantity" );
                }
            } else {
            	System.out.print("IInvalid option ");
            }
		}
	}
	
	public static void main(String[] args) {
		Logger logger = ShopLogger.getLogger();
		logger.log(Level.INFO, "Application starting");
		String directory = "Resources";
		String catalogFile = directory + "/CatalogInfo.txt";
        String userFile = directory + "/UsersInfo.txt";
        UserFileParser ufp = new UserFileParser();
        UserFileWriter ufw = new UserFileWriter();
        UserRepository ur = new UserRepository(userFile, ufp, ufw);
        
        ProductCatalog pc = new ProductCatalog();
		AbstractProductFactory foodFactory = new FoodFactory();
		AbstractProductFactory otherFactory = new OtherFactory();
        CatalogFileParser cfp = new CatalogFileParser(foodFactory, otherFactory);
        CatalogFileWriter cfw = new CatalogFileWriter();
        CatalogHandler ch = new CatalogHandler(pc, cfw, cfp);
        
        Authentication auth = new Authentication(ur);
        
        resourceCheck(directory, userFile, catalogFile);

        Scanner sc = new Scanner(System.in);
        
        sampleChecker(catalogFile);
        User currentUser = startUp(sc, auth);
        
        ch.loadFromFile(catalogFile);
        if(currentUser != null) {
        	System.out.print("success");
        	CartBuilder cb = new CartBuilder();
        	loop(sc, ch, pc, cb, currentUser);
        	
        }
        else {
        	System.out.print("fail");
        }
    }
}
 