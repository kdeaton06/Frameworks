package qasolutions.tests;

import org.testng.annotations.Test;

import qasolutions.pageobjects.AccountsOverviewPage;
import qasolutions.pageobjects.HomePage;
import qasolutions.pageobjects.NavMenu;
import qasolutions.pageobjects.NewAccountPage;

public class TestClass extends BaseTest {

	@Test(priority=0)
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
	
	@Test(priority=1)
	public void verifyOpeningNewAccount() {
		NavMenu navMenu = new NavMenu(driver);
		NewAccountPage newAccountPage = new NewAccountPage(driver);
		
		String accountType = "CHECKING";
		String accountNumber = "17562"; // this might change from minute to minute. the site is finicky, update to get actual account # from page
		String newAccountId = "";

		print("Opening Parabank");
    	driver.get("https://parabank.parasoft.com/parabank/index.htm");
    	
    	navMenu.clickOpenNewAccount();
    	asserts.assertEquals(newAccountPage.getNewAccountHeader(), "Open New Account", 
    			"Verify the 'Open New Account' Page loads");
    	
    	newAccountPage.selectAccountType(accountType);
    	asserts.assertEquals(newAccountPage.getSelectedAccountType(), accountType, 
    			"Verify the correct account type is selected");
    	
    	newAccountPage.selectAccountToTransferFrom(accountNumber);
    	asserts.assertEquals(newAccountPage.getSelectedAccountNumber(), accountNumber, 
    			"Verify the account to transfer from is correct");
    	
    	newAccountPage.clickOpenAccountBtn();
    	asserts.assertEquals(newAccountPage.getNewAccountHeader(), "Account Opened!", 
    			"Verify the 'Open New Account' Page loads");
    	
    	newAccountId = newAccountPage.getNewAccountId();
        
        asserts.assertAll();
	}
}