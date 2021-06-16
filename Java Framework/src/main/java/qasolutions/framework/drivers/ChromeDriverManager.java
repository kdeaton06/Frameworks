package qasolutions.framework.drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {
	
	private final String DRIVER_PATH = "C:/Users/kdeat/Projects/drivers/chromedriver.exe";
	private ChromeOptions options = new ChromeOptions();

	@Override
	public void createWebDriver() {
		System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
		options.addArguments("--start-maximized");
    	this.driver = new ChromeDriver(options);
	}
	
	
	
}
