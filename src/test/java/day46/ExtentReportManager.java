package day46;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkReporter; //UI of the report
	public ExtentReports extent;//populate common info on the report
	public ExtentTest test; //creating test case entries into the report and update status of the methods.
	
	public void onStart(ITestContext context)
	{
		//location of the report file where report is created
		sparkReporter = new ExtentSparkReporter("./reports/myReport.html");
		
		//Title of the report
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Functional Testing");//name of the report
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer Name", "LocalHost");
		extent.setSystemInfo("Environme3nt", "QA");
		extent.setSystemInfo("Tester name", "Jaya");
		extent.setSystemInfo("OS Name", "Windows11");
		extent.setSystemInfo("Browser Name", "chrome");		
		
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test = extent.createTest(result.getName()); //create a new entry in the report
		test.log(Status.PASS, "Test case passed is : "+result.getName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		test = extent.createTest(result.getName()); //create a new entry in the report
		test.log(Status.FAIL, "Test case passed is : "+result.getName());
		test.log(Status.FAIL, "Test case failed cause is : "+result.getThrowable());
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test = extent.createTest(result.getName()); //create a new entry in the report
		test.log(Status.SKIP, "Test case Skipped is : "+result.getName());
	}
	
	public void onFinish(ITestContext context)
			{

		extent.flush();
			}
	

}
