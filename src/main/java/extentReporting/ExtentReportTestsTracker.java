package extentReporting;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentReportTestsTracker {
	static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>(); // keep two things 1. unique identifier 2. Extenttest (test method)
	static ExtentReports extent = ExtentReportDefinition.getInstance();
	public static ExtentTest test;

	public static synchronized ExtentTest getStatus() {
		return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
	}


	public static synchronized void finishTest() {
		extent.flush();
	}

	public static synchronized ExtentTest startTest(String testName) {
		test = extent.createTest(testName);
		extentTestMap.put((int) (long) (Thread.currentThread().getId()), test);
		return test;
	}
}
