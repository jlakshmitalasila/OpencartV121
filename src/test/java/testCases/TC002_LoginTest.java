package testCases;

import java.util.RandomAccess;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"sanity","master"})
	
	public void verify_login()
	{
		logger.info("*******Starting TC002_LoginTest**************");
		
		try {
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickMyaccount();
		hp.clickLogin();
		
		//Login
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(properties.getProperty("email"));
		loginPage.setPassword(properties.getProperty("password"));
		loginPage.clickLogin();
		
		//MyAccount
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = macc.isMyAccountPageExists();
		
		Assert.assertEquals(targetPage, true, "Login Failed");
		macc.clickLogout();
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
		logger.info("*******Finished TC002_LoginTest**************");
		
	}
	

}
