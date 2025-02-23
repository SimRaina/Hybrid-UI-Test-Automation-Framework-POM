package listeners;

import org.testng.ITestResult;
import org.testng.IRetryAnalyzer;

public class CustomRetryListener implements IRetryAnalyzer {
    private int retryCount = 0;
    private static final int maxRetryCount = 2; // Retry up to 2 times

    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            System.out.println("Retrying test: " + result.getName() + " | Attempt: " + (retryCount + 1));
            return true; // Retry test
        }
        return false; // Stop retrying
    }
}