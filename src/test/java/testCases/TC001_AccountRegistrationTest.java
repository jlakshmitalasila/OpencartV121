package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	@Test(groups = {"regression","master"})
	public void verify_account_registration()
	{
		logger.info("*************** Starting test case ***********************");
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyaccount();
		logger.info("*************** clicked on my account link**");
		hp.clickRegister();
		logger.info("*************** clicked on register link****************");
		
		AccountRegistrationPage arp = new AccountRegistrationPage(driver);
		logger.info("*************** Providing customer details ***********************");
		arp.inputFirstName("test05");
		arp.inputLaststName("test05");
		arp.inputEmail(randomString()+"@jmail.com");
		arp.inputTelePhone("8794562310");
		arp.inputPassword("test05@123");
		arp.inputPasswordConfirm("test05@123");
		arp.clickPrivacyPolicy();
		arp.clickContinue();
		
		logger.info("Validating expected message");
		String msgfromConfirmation = arp.getConfirmationMessage();
		System.out.println("Message from confirmation page is: "+msgfromConfirmation);
		Assert.assertEquals(msgfromConfirmation, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Test Failed....");
			logger.debug("Debug logs");
			Assert.fail();
		}
		
		logger.info("Finished TC001_AccountRegistrationTest testcase ");
	}
	
	

}
