package utilities;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenShots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//capturing full screen
		/*TakesScreenshot ts = (TakesScreenshot)driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File targetFile = new File("./screenshots/fullpage.png");
		sourceFile.renameTo(targetFile); //this will copy sourcefile to target file*/
		
		//screen shot of specific section
		/*WebElement featuredProducts = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		
		File sourceFile = featuredProducts.getScreenshotAs(OutputType.FILE);
		File targetFile = new File("./screenshots/specificsection.png");
		sourceFile.renameTo(targetFile);*/
		
		//Screenshot of webelement
		WebElement logo = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File sourceFile = logo.getScreenshotAs(OutputType.FILE);
		File targetFile = new File("./screenshots/logo.png");
		sourceFile.renameTo(targetFile);
		
		driver.quit();

	}

}
