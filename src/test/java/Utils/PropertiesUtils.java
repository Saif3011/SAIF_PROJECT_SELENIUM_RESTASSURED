package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public  class PropertiesUtils {
	
	public static Properties loadProperties(String filepath) {
		
		File file = new File(filepath);
		try {
			InputStream inputstream =new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(inputstream);
			inputstream.close();
			return properties;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("File is not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("error while loading properties");
		}
		
	}

}
