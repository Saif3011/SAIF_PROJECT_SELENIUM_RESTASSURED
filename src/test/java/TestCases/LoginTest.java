package TestCases;





import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Factory.DriverFactory;
import Pages.LoginPage;
import Pages.TodoPage;
import Utils.ConfigUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;


@Feature("Auth feature")
public class LoginTest extends BaseTest {
	@Story("Login functionnality ")
	@Description("it will login by filling the email and password and navigate to todo page")
	@Test(description=" test the login functionnality using email and password")
    public void ShouldBeAbleToLoginWithEmailAndPassword(){
		
        
        LoginPage loginpage = new LoginPage(driver);
        
        boolean isWelcomeMessageDisplayed= 
        loginpage
         .load()
         .Login(ConfigUtil.getInstance().GetEmail(),ConfigUtil.getInstance().GetPassword())
         .isWelcomeMessageDisplayed();
        


        Assert.assertTrue(isWelcomeMessageDisplayed);
       
     
          
    }

}
