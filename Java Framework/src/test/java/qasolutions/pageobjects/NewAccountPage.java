package qasolutions.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qasolutions.tests.BaseTest;

public class NewAccountPage extends BasePage {

	public NewAccountPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1")
	WebElement newAccountHeaderLbl;
	@FindBy(id = "type")
	WebElement accountTypeDdn;
	@FindBy(id = "fromAccountId")
	WebElement accountFromDdn;
	@FindBy(xpath = "//input[@value='Open New Account']")
	WebElement openAccountBtn;
	@FindBy(className = "button")
	WebElement newAccountIdLbl;
	
	public String getNewAccountHeader() {
		return getText(newAccountHeaderLbl, WAIT_SHORT);
	}
	
	public String getSelectedAccountType() {
		return getTextFromDropdown(accountTypeDdn, WAIT_SHORT);
	}
	
	public String getSelectedAccountNumber() {
		return getTextFromDropdown(accountFromDdn, WAIT_SHORT);
	}
	
	public String getNewAccountId() {
		return getText(newAccountIdLbl, WAIT_SHORT);
	}
	
	public void selectAccountType(String accountType) {
		clickOptionInDropdownByText(accountTypeDdn, accountType, WAIT_SHORT);
	}
	
	public void selectAccountToTransferFrom(String accountNumber) {
		clickOptionInDropdownByValue(accountFromDdn, accountNumber, WAIT_SHORT);
	}
	
	public void clickOpenAccountBtn() {
		clickElement(openAccountBtn, WAIT_SHORT);
		BaseTest.sleep(SLEEP_SHORT);
	}
}
