package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Base.BasePage;
import io.qameta.allure.Step;

public class NewTodoPage extends BasePage {

	public NewTodoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="[data-testid=\"new-todo\"]")
    private	WebElement NewTodoInput;
	
	@FindBy(css="[data-testid=\"submit-newTask\"]")
    private	WebElement NewTodoSubmit;
	
	@Step
	public TodoPage AddNewTodo(String item) {
		
		NewTodoInput.sendKeys(item);
		NewTodoSubmit.click();
		return new TodoPage(driver);
		
	}
	
	
	
	

}
