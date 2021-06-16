package qasolutions.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import qasolutions.assertions.Asserts;
import qasolutions.framework.drivers.DriverManager;
import qasolutions.framework.drivers.DriverManagerFactory;

@Listeners(qasolutions.assertions.TestListener.class)
public abstract class BaseTest {
	
	protected DriverManager driverManager;
	public static WebDriver driver;
	protected Asserts asserts;
	
	
	@BeforeClass
	protected void instantiateDriver() {
		driverManager = DriverManagerFactory.getDriverManager();
    	driver = driverManager.getWebDriver();
	}
	
	@BeforeMethod
	protected void startTest() {
    	asserts = new Asserts();
	}
	
	@AfterMethod
	protected void endTest() {
		asserts = null;
	}

	@AfterClass
	protected void quitDriver() {
        driverManager.quitWebDriver();
	}
	
	public static void print(String message) {
		Reporter.log(message);
		System.out.println(message);
	}

	public static void sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {}
	}
}
