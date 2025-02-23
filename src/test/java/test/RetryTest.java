package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import listeners.CustomRetryListener;

public class RetryTest {
    
    @Test(retryAnalyzer = CustomRetryListener.class)
    public void testMethod() {
        System.out.println("Executing test...");
        Assert.fail("Intentionally failing to test retries.");
    }
}
