package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;//Log4j
import org.apache.logging.log4j.Logger;//Log4j

public class BaseClass {
	
public static WebDriver driver;
public Logger logger; //Log4j
public Properties properties;
	
	@BeforeClass(groups = {"sanity","regression","master"})
	@Parameters({"os","browser"})
	public void setUP(String os, String browser) throws IOException
	{
		FileReader file = new FileReader("./src/test/resources/config.properties");
		properties= new Properties();
		properties.load(file);
				
		logger = LogManager.getLogger(this.getClass()); //log4j
		
		if(properties.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capability = new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				capability.setPlatform(Platform.WIN11);
			}
			else if(os.equalsIgnoreCase("mac"))
			{
				capability.setPlatform(Platform.MAC);
			}
			else if(os.equalsIgnoreCase("linux"))
			{
				capability.setPlatform(Platform.LINUX);
			}
			else
			{
				System.out.println("no matching os");
				return;
			}				
			//browser
			switch(browser.toLowerCase())
			{
			case "chrome": capability.setBrowserName("chrome"); break;
			case "edge": capability.setBrowserName("MicrosoftEdge"); break;
			case "firefox": capability.setBrowserName("firefox"); break;
			default: System.out.println("No Matching browser");return;
			}		
			
			driver = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL(),capability);
		}
		
		if(properties.getProperty("execution_env").equalsIgnoreCase("local"))	
		{
		
			switch(browser.toLowerCase())
			{
			case "chrome": driver = new ChromeDriver(); break;
			case "edge": driver = new EdgeDriver(); break;
			case "firefox": driver = new FirefoxDriver(); break;
			default: System.out.println("Invalid Browser Name"); return;
			
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(properties.getProperty("appURL1")); //getting browser URL from properties file
		driver.manage().window().maximize();
		
		
		
	}
	
	@AfterClass(groups = {"sanity","regression","master"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String randomvalue = RandomStringUtils.randomAlphabetic(5);
		return randomvalue;
	}
	
	public String catureScreen(String testName) throws IOException
	{
		//capturing full screen
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	
		TakesScreenshot ts = (TakesScreenshot)driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testName+"_"+timeStamp;
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile); //this will copy sourcefile to target file
		return targetFilePath;
	}
	
	

}
