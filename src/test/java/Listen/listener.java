package Listen;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class listener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("started"+ result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("failed"+ result.getName());
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("exe started"+ context.getName());
	}

	
	
	
	
	
}
