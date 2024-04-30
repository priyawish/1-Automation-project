package pageElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.AbstractMethods;
import utilities.ReusableClass;
import utilities.ReusableFunctionalities;


public class RegisterUser extends AbstractMethods
{

	WebDriver driver;	
	public RegisterUser(WebDriver driverhere) 
	{
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}

	@FindBy (xpath= "//header/div[1]/div[1]/ul[1]/li[2]/a[1]")WebElement signIn;
	@FindBy (xpath= "//body/div[2]/main[1]/div[3]/div[1]/div[3]/div[2]/div[2]/div[1]/div[1]/a[1]")WebElement createAnAccount;
	@FindBy (xpath= "//div[contains(text(),'Thank you for registering with Main Website Store.')]")WebElement accCreatedMsg;
	@FindBy (xpath= "//*[contains(text(),'There is already an account with this email address')]") WebElement accCreatedFailMsg;
	@FindBy (xpath= "//header/div[2]/a[1]/img[1]") WebElement homePageLogo;
	@FindBy (xpath= "//button[@class='action switch']") WebElement accDropdown;
	@FindBy (xpath= "//a[@href='https://magento.softwaretestingboard.com/customer/account/logout/']") WebElement signOut;
	@FindBy (xpath= "//div[@id='email_address-error']") WebElement invalidEmail;
	
	//@FindBy (xpath= "//header/div[1]/div[1]/ul[1]/li[2]/div[1]/ul[1]/li[3]/a[1]") WebElement signOut;
	

	public void homepagevisibility()
	{
		System.out.println("Starts homepagevisibiblity()...");
		implicitlywaitmethod();
		ReusableClass rc = new ReusableClass(driver);
		rc.urlEquals("https://magento.softwaretestingboard.com/");
		waitTillLinkIsClickable(signIn);
		signIn.click();
		System.out.println("homepagevisibiblity() Ends...");
	}

	public void userRegister()
	{
		implicitlywaitmethod();
		try
		{
			ReusableClass rc = new ReusableClass(driver);
			waitTillLinkIsClickable(signIn);
			signIn.click();
			System.out.println("Sign in clicked");

			waitTillLinkIsClickable(createAnAccount);
			createAnAccount.click();
			System.out.println("Create An Account clicked");

			ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			rf.registrationpage();

			rc.innerTextEquals(accCreatedMsg, "Thank you for registering with Main Website Store.");

			System.out.println("Testcase 1--> executed succesfully...");
		}
		catch (Exception e)
		{
			System.out.println("Exception occured in testcase 1 execution");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void userInvalidRegister()
	{
		implicitlywaitmethod();
		try
		{
			ReusableClass rc = new ReusableClass(driver);
			waitTillLinkIsClickable(signIn);
			signIn.click();
			System.out.println("Sign in clicked");

			waitTillLinkIsClickable(createAnAccount);
			createAnAccount.click();
			System.out.println("Create An Account clicked");

			ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			rf.registrationPageInvalid();

			waitTillLinkIsClickable(invalidEmail);
			rc.innerTextEquals(invalidEmail, "Please enter a valid email address (Ex: johndoe@domain.com).");

			System.out.println("Testcase 3--> executed succesfully...");
		}
		catch (Exception e)
		{
			System.out.println("Exception occured in testcase 3 execution");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	

	public void registerWithExistingEmail()
	{
		implicitlywaitmethod();
		try
		{	
			ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			rf.gotoHomepage();
//			waitTillLinkIsClickable(homePageLogo);
//			homePageLogo.click();

			ReusableClass rc = new ReusableClass(driver);
			waitTillLinkIsClickable(signIn);
			signIn.click();
			System.out.println("Sign in clicked");

			waitTillLinkIsClickable(createAnAccount);
			createAnAccount.click();
			System.out.println("Create An Account clicked");

			rf.registrationPageExistingUser();

			rc.innerTextEquals(accCreatedFailMsg, "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.");

			System.out.println("Testcase 4--> executed succesfully...");
		}
		catch (Exception e)
		{
			System.out.println("Exception occured in testcase 4 execution");
			e.printStackTrace();
			Assert.fail();
		}

	}

	public void existinguser() 
	{
		implicitlywaitmethod();

		try 
		{
			waitTillLinkIsClickable(signIn);
			signIn.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Assert.fail();
		}
	}

//	public void logout() 
//	{
//		implicitlywaitmethod();
//		try
//		{
//			ReusableClass rc = new ReusableClass(driver);
//			
//			waitTillLinkIsClickable(accDropdown);
//			accDropdown.click();
//			
//			waitTillLinkIsClickable(signOut);
//			signOut.click();
//			
//			Thread.sleep(6000); //wait for homepage to appear after signout\
//			
//			//Verify if we are at homepage
//			rc.urlEquals("https://magento.softwaretestingboard.com/");
//			System.out.println("Test case 2 executed successfully...");
//		}
//		catch(Exception e)
//		{
//			System.out.println("Exception occured in testcase 2 execution");
//			e.printStackTrace();
//			Assert.fail();
//		}
//
//	}

}
