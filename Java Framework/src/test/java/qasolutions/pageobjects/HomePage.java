package qasolutions.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	WebElement usernameTxt;
	@FindBy(name = "password")
	WebElement passwordTxt;
	@FindBy(xpath = "//input[@value='Log In']")
	WebElement loginBtn;
	
	public void login(String username, String password) {
		inputText(usernameTxt, username, WAIT_SHORT);
		inputText(passwordTxt, password, WAIT_SHORT);
		clickElement(loginBtn, WAIT_SHORT);
	}
}
