package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.BasePage;
import io.qameta.allure.Step;

public class TodoPage extends BasePage {

	public TodoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(css="[data-testid=\"welcome\"]")
    private	WebElement WelcomeMessage;
	
	@FindBy(css="[data-testid=\"add\"]")
    private	WebElement addButton;
	
	@FindBy(css="[data-testid=\"todo-item\"]")
    private	WebElement TodoItem;
	@FindBy(css="[data-testid=\"delete\"]")
    private	WebElement deleteButton;
	@FindBy(css="[data-testid=\"no-todos\"]")
    private	WebElement NoTodoMessage;
	
	
	
	public boolean  isWelcomeMessageDisplayed() {
		
	return 	WelcomeMessage.isDisplayed();
		
	}
	@Step
	public NewTodoPage ClickOnplusButton() {
		
		addButton.click();
		
		return new NewTodoPage(driver);
		
	}
	@Step
	public String GetTodoText() {
		
	return 	TodoItem.getText();	
	}
	public TodoPage ClickOnDeleteButton() {
		
		deleteButton.click();
		
		return new TodoPage(driver);
	}
	@Step
	public boolean  IsNoTodomessageIsDisplayed() {
		
		return NoTodoMessage.isDisplayed();
	}
	

}
