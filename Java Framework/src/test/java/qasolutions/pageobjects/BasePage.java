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
import org.openqa.selenium.support.ui.WebDriverWait;

import qasolutions.tests.BaseTest;

public class BasePage {
	
	protected WebDriver driver;
	
	protected final int WAIT_SHORT = 5;
	protected final int WAIT_MEDIUM = 10;
	protected final int WAIT_LONG = 15;
	
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
