package qasolutions.tests;

import org.testng.annotations.Test;

import qasolutions.pageobjects.AccountsOverviewPage;
import qasolutions.pageobjects.HomePage;

public class TestClass extends BaseTest {

	@Test
    public void successfulLogin() {
		AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(driver);
		HomePage homePage = new HomePage(driver);

		print("Opening Parabank");
    	driver.get("https://parabank.parasoft.com/parabank/index.htm");
    	
    	homePage.login("test", "password1");
    	asserts.assertTrue(accountsOverviewPage.isAccountOvberviewDisplayed(), 
    			"Verify the user logged in successfully");
        
        asserts.assertAll();
	}

	@Test
    public void failedLogin() {
		AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(driver);
		HomePage homePage = new HomePage(driver);

		print("Opening Parabank");
    	driver.get("https://parabank.parasoft.com/parabank/index.htm");
    	
    	homePage.login("test", "wrong");
    	asserts.assertTrue(accountsOverviewPage.isAccountOvberviewDisplayed(), 
    			"Verify the user logged in successfully");
        
        asserts.assertAll();
	}
}