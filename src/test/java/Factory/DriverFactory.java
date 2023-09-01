package Factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	 
	public static WebDriver InitializeDriver() {
		
		
		
		String browser =System.getProperty("browser","CHROME");
		WebDriver driver;
		switch(browser) {
		case "CHROME":
			WebDriverManager.chromedriver().setup();
	         driver = new ChromeDriver();
	        break;
		case"FIREFOX":
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
			break;
		case "EDGE":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
			default:
			throw new RuntimeException("no browser detected");	
		}
		
		
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
		
	}

}
