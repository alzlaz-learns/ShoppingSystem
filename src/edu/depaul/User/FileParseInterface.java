package edu.depaul.User;

import java.util.List;
//Contract for classes that implements this.
public interface FileParseInterface {
		List<User> parseFile(String filePath);
}
