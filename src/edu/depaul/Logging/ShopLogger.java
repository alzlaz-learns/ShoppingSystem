package edu.depaul.Logging;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
//simple logging class that writes to Application.log
public class ShopLogger {
	 private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	 private static FileHandler fileHandler;
	 
		//	 /https://www.vogella.com/tutorials/Logging/article.html
	    static {
	        
	        	logger.setLevel(Level.INFO);
	            try {
	            	
					fileHandler = new FileHandler("Application.log", true);
					logger.addHandler(fileHandler);
		            SimpleFormatter formatter = new SimpleFormatter();
		            fileHandler.setFormatter(formatter);
		            logger.setUseParentHandlers(false);
		            
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	          
	    }
	    public static Logger getLogger() {
	        return logger;
	    }
}
