package Pages;



import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BasePage;
import Utils.ConfigUtil;
import Utils.PropertiesUtils;
import io.qameta.allure.Step;

public class LoginPage extends BasePage {
	

	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(css = "[data-testid=\"email\"]")
	WebElement emailInput ;
	@FindBy(css = "[data-testid=\"password\"]")
	WebElement passwordInput ;
	@FindBy(css = "[data-testid=\"submit\"]")
	WebElement submit ;
	@Step("load the login page")
	public  LoginPage load() {
		
		//driver.get("https://qacart-todo.herokuapp.com");
		driver.get(ConfigUtil.getInstance().GetBaseUrl());
		return this;
		
	}
	@Step
	public TodoPage Login(String email,String password) {
	emailInput.sendKeys(email);
	passwordInput.sendKeys(password);
	submit.click();
	return new TodoPage(driver);
	
		}
	

}
