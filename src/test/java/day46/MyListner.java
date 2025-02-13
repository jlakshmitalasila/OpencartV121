package day46;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class MyListner implements ITestListener  {
	
	public void onStart(ITestContext context) {
	    // not implemented
		System.out.println("Test Execution is started ......");
	  }
	  	
	public void onTestStart(ITestResult result) {
		System.out.println("Test started ......");
	    // not implemented
	  }
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed ......");
	    // not implemented
	  }
	public void onTestFailure(ITestResult result) {
	    // not implemented
		System.out.println("Test Execution is failed ......");
	  }
	public void onTestSkipped(ITestResult result) {
	    // not implemented
		System.out.println("Test Execution is skipped ......");
	  }
	

	public void onFinish(ITestContext context) {
	    // not implemented
		System.out.println("Test Execution is finished ......");
	  }

}
