package qasolutions.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qasolutions.tests.BaseTest;

public class NavMenu extends BasePage {

	public NavMenu(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='leftPanel']/ul/li[1]/a")
	WebElement openNewAccountLnk;
	
	public void clickOpenNewAccount() {
		clickElement(openNewAccountLnk, WAIT_SHORT);
		BaseTest.sleep(SLEEP_SHORT);
	}
}
