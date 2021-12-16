package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import extentReporting.ExtentReportDefinition;
import extentReporting.ExtentReportTestsTracker;

public class ListenerTest implements ITestListener{

	public void onTestStart(ITestResult result) {
		
		System.out.println("Test Started " + result.getName()); 
		ExtentReportTestsTracker.startTest(result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Test Passed " + result.getName()); 
		ExtentReportTestsTracker.getStatus().log(Status.PASS, "Test Passed");
		
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("Test Failed " + result.getName());
		ExtentReportTestsTracker.getStatus().log(Status.FAIL, "Test Failed");
		
	}

	public void onTestSkipped(ITestResult result) {

		System.out.println("Test Skipped " + result.getName()); 
		ExtentReportTestsTracker.getStatus().log(Status.SKIP, "Test Skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		ExtentReportTestsTracker.finishTest();
		ExtentReportDefinition.getInstance().flush();
		
	}

}
