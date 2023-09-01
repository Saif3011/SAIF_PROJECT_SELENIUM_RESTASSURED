package TestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DummyPropertiesFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		File file = new File("src/test/java/config/production.properties");
		
		InputStream inputstream = new FileInputStream(file);
		
		Properties properties = new Properties();
		properties.load(inputstream);
	String baseurl=	properties.getProperty("baseurl");
	//System.out.println(baseurl);
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get(baseurl);
	

	}

}

