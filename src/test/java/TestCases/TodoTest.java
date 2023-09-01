package TestCases;




import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Factory.DriverFactory;
import Pages.LoginPage;
import Pages.NewTodoPage;
import Pages.TodoPage;
import Utils.ConfigUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
@Feature("Add todo feature")
public class  TodoTest extends BaseTest {
	
	@Story("Adding a todo item")
	@Description("it will be able to  add a new todo item")
	@Test(description ="should be able to add a new todo correctly")
    public void ShouldBeAbleTodeleteTodo(){
		
LoginPage loginpage = new LoginPage(driver);
        
boolean NotoDoMessage= loginpage
.load()
.Login(ConfigUtil.getInstance().GetEmail(),ConfigUtil.getInstance().GetPassword())
.ClickOnplusButton()
.AddNewTodo("learn selenium")
.ClickOnDeleteButton()
.IsNoTodomessageIsDisplayed();
Assert.assertTrue(NotoDoMessage);
 
    
       

}
	/*@Test
    public void ShouldBeAbleToAddNewTodo(){
		
LoginPage loginpage = new LoginPage(driver);
        
String ActualResult = loginpage
.load()
.Login(ConfigUtil.getInstance().GetEmail(),ConfigUtil.getInstance().GetPassword())
.ClickOnplusButton()
.AddNewTodo("learn selenium")
.GetTodoText();

Assert.assertEquals(ActualResult,"learn selenium");    
        
     
       
       
    }*/
}
