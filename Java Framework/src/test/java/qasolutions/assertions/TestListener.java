package qasolutions.assertions;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import qasolutions.framework.utilities.Screenshots;
import qasolutions.tests.BaseTest;

public class TestListener implements ITestListener {

	/**
	   * Invoked each time before a test will be invoked. The <code>ITestResult</code> is only partially
	   * filled with the references to class, method, start millis and status.
	   *
	   * @param result the partially filled <code>ITestResult</code>
	   */
	@Override
	public void onTestStart(ITestResult result) {
		BaseTest.print("");
		BaseTest.print("============= STARTING TEST CASE " + result.getName() + " =============");
		BaseTest.print("");
	}

	/**
	   * Invoked each time a test succeeds.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   */
	@Override
	public void onTestSuccess(ITestResult result) {
		BaseTest.print("");
		BaseTest.print("============== TEST CASE PASSED " + result.getName() + " ==============");
	}

	/**
	   * Invoked each time a test fails.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   */
	@Override
	public void onTestFailure(ITestResult result) {
		String fileName = Screenshots.takeScreenshot(BaseTest.driver);
	    Reporter.log("<a href='" + fileName + "' target='_blank'>FINAL SCREENSHOT</a>");
		BaseTest.print("");
		BaseTest.print("============== TEST CASE FAILED " + result.getName() + " ==============");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		BaseTest.print("");
		BaseTest.print("=============  TEST CASE SKIPPED " + result.getName() + " =============");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {}

	@Override
	public void onStart(ITestContext context) {}

	@Override
	public void onFinish(ITestContext context) {}
	
}
