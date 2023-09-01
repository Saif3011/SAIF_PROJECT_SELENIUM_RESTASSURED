package Utils;

import java.util.ArrayList;
import java.util.List;

import io.restassured.http.Cookie;

public class UtilCookie {
	
	public List<org.openqa.selenium.Cookie> ConvertRestAssuredCookiesToSeleniumCookies(List<Cookie> RestAssuredcookies) {
		
	List <org.openqa.selenium.Cookie> SeleniumCookies = new ArrayList<>();	 
		
for(Cookie Cookie :RestAssuredcookies ) {
			
			
	org.openqa.selenium.Cookie SeleniumCookie = new org.openqa.selenium.Cookie(Cookie.getName(), Cookie.getValue());
	SeleniumCookies.add(SeleniumCookie);
	
		}
		
		return SeleniumCookies;
		
	}

}
