package qasolutions.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsOverviewPage extends BasePage {

	public AccountsOverviewPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//h1[text()='Accounts Overview']")
	WebElement accountOverviewLbl;
	
	public boolean isAccountOvberviewDisplayed() {
		return isElementVisible(accountOverviewLbl, WAIT_LONG);
	}
}
