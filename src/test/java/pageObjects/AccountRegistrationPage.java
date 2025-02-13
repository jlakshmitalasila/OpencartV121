package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//input[@id='input-firstname']") WebElement  firstName;
	@FindBy(xpath = "//input[@id='input-lastname']") WebElement lastName;
	@FindBy(xpath = "//input[@id='input-email']") WebElement eMail;
	@FindBy(xpath = "//input[@id='input-telephone']") WebElement telePhone;
	@FindBy(xpath = "//input[@id='input-password']") WebElement password;
	@FindBy(xpath = "//input[@id='input-confirm']") WebElement passwordConfirm;
	@FindBy(xpath = "//input[@name='agree']") WebElement privacyPolicy;
	@FindBy(xpath = "//input[@value='Continue']") WebElement btnContinue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgAccountCreated;
	
	public void inputFirstName(String name)
	{
		firstName.sendKeys(name);
	}
	
	public void inputLaststName(String name)
	{
		lastName.sendKeys(name);
	}
	
	public void inputEmail(String name)
	{
		eMail.sendKeys(name);
	}
	
	public void inputTelePhone(String name)
	{
		telePhone.sendKeys(name);
	}
	
	public void inputPassword(String name)
	{
		password.sendKeys(name);
	}
	
	public void inputPasswordConfirm(String name)
	{
		passwordConfirm.sendKeys(name);
	}
	
	public void clickPrivacyPolicy()
	{
		privacyPolicy.click();
	}
	
	public void clickContinue() {
		btnContinue.click();
		
		//there are other solutions too if the above click doesnt work.
		
	}
	
	public String getConfirmationMessage()
	{
		try
		{
			return msgAccountCreated.getText();
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
	}
 

}
