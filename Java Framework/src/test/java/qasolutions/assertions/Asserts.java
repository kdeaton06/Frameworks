package qasolutions.assertions;

import java.util.List;

import org.testng.Reporter;
import org.testng.asserts.IAssert;
import org.testng.asserts.SoftAssert;
import org.testng.collections.Lists;

import qasolutions.framework.utilities.Screenshots;
import qasolutions.tests.BaseTest;

public class Asserts extends SoftAssert {

	private List<String> assertMessages = Lists.newArrayList();
    
	/** Invoked after an assert is run. */
    @Override
    public void onAfterAssert(IAssert<?> assertCommand) {
      assertMessages.add(assertCommand.getMessage());
    }
    
    /** Invoked when an assert succeeds. */
    @Override
    public void onAssertSuccess(IAssert<?> assertCommand) {
      BaseTest.print("Step " + (assertMessages.size()+1) + ": PASSED - " + assertCommand.getMessage());
    }
    
    /** Invoked when an assert fails. */
    @Override
    public void onAssertFailure(IAssert<?> assertCommand, AssertionError error) {
      String fileName = Screenshots.takeScreenshot(BaseTest.driver);
      Reporter.log("Step " + (assertMessages.size()+1) + ": FAILED - <a href='" + fileName + "' target='_blank'>" + error.getMessage()+"</a>");
      System.out.println("Step " + (assertMessages.size()+1) +": FAILED - " +  error.getMessage());
    }
}