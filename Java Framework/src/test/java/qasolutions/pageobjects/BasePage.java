package qasolutions.pageobjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import qasolutions.tests.BaseTest;

public class BasePage {
	
	protected WebDriver driver;
	
	protected final int WAIT_SHORT = 5;
	protected final int WAIT_MEDIUM = 10;
	protected final int WAIT_LONG = 15;
	
	protected final int SLEEP_SHORT = 500;
	protected final int SLEEP_MEDIUM = 2000;
	protected final int SLEEP_LONG = 5000;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Waits for the given element to be visible on the page
	 * 
	 * @param element
	 * @param seconds
	 * @return element if its found, NULL if not
	 */
	public WebElement waitForElementToBeVisible(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			return element;
		} catch (TimeoutException e) {
			BaseTest.print("ERROR: Element was not found");
			return element;
		}
	}
	
	/**
	 * Waits up to 30 seconds for the page to load 
	 * 
	 * @param driver
	 */
	public void waitForLoad() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        wait.until(pageLoadCondition);
	}
	
	/**
	 * Inputs the text into the given element
	 * 
	 * @param element
	 * @param text
	 * @param seconds
	 */
	public void inputText(WebElement element, String text, int seconds) {
		waitForElementToBeVisible(element, seconds).sendKeys(text);
	}
	
	/**
	 * Clicks on the given element
	 * 
	 * @param element
	 * @param seconds
	 */
	public void clickElement(WebElement element, int seconds) {
		try {
			waitForElementToBeVisible(element, seconds).click();
		} catch (StaleElementReferenceException e) {
			BaseTest.print("ERROR: Unable to click element");
		}
	}
	
	/**
	 * Selects an option in the given Dropdown menu based on the visible text
	 * 
	 * @param element
	 * @param option
	 * @param seconds
	 */
	public void clickOptionInDropdownByText(WebElement element, String option, int seconds) {
		Select select = new Select(waitForElementToBeVisible(element, seconds));
		select.selectByVisibleText(option);
	}
	
	/**
	 * Selects an option in the given Dropdown menu based on the value of the option
	 * 
	 * @param element
	 * @param option
	 * @param seconds
	 */
	public void clickOptionInDropdownByValue(WebElement element, String value, int seconds) {
		Select select = new Select(waitForElementToBeVisible(element, seconds));
		select.selectByValue(value);
		
	}
	
	/**
	 *  Selects an option in the given Dropdown menu based on the index of option
	 *  0 is the first option, 1 the second option and so on
	 * 
	 * @param element
	 * @param index
	 * @param seconds
	 */
	public void clickOptionInDropdownByIndex(WebElement element, int index, int seconds) {
		Select select = new Select(waitForElementToBeVisible(element, seconds));
		select.selectByIndex(index);
	}
	
	/**
	 * Gets the visible text for the given element
	 * 
	 * @param element
	 * @param seconds
	 * @return
	 */
	public String getText(WebElement element, int seconds) {
		return waitForElementToBeVisible(element, seconds).getText();
	}
	
	/**
	 * Gets the text of the currently selected option in a Dropdown 
	 * 
	 * @param element
	 * @param seconds
	 * @return
	 */
	public String getTextFromDropdown(WebElement element, int seconds) {
		Select select = new Select(waitForElementToBeVisible(element, seconds));
		return select.getFirstSelectedOption().getText();
	}
	
	/**
	 * Checks to see if an element is present on the page
	 * 
	 * @param element
	 * @param seconds
	 * @return TRUE if element is present, FALSE otherwise
	 */
	public boolean isElementVisible(WebElement element, int seconds) {
		try {
			return waitForElementToBeVisible(element, seconds).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
