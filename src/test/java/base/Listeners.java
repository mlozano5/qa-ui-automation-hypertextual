package base;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listeners extends BaseTest implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        Reporter.log("Test " + result.getName() + " has started.");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.log("Test " + result.getName() + " has passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.log("Test " + result.getName() + " has failed.");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Reporter.log("Test " + result.getName() + " has been skipped.");
    }

}