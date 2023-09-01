package TestCases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Api.RegisterApi;
import Utils.ConfigUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;

public class DummyCookiesSelenium {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(ConfigUtil.getInstance().GetBaseUrl());
		driver.manage().window().maximize();
		
		RegisterApi registerApi = new RegisterApi();
		registerApi.Register();
		
		//la liste va nous donner 3 cookies
		List<Cookie> RestAssuredcookies =  registerApi.GetCookies();
		// transformer les restAssuredCookies  vers Selenium cookies
		for(Cookie Cookie :RestAssuredcookies ) {
			
			org.openqa.selenium.Cookie SeleniumCookie = new org.openqa.selenium.Cookie(Cookie.getName(), Cookie.getValue());
			driver.manage().addCookie(SeleniumCookie);
		}
		
		driver.get(ConfigUtil.getInstance().GetBaseUrl());
		
		Thread.sleep(30000);
		
		
		driver.quit();
		
		

	}

}

