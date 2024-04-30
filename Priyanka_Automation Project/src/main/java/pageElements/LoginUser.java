package pageElements;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.AbstractMethods;
import utilities.ReusableClass;
import utilities.ReusableFunctionalities;

public class LoginUser extends AbstractMethods
{
	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;

	public LoginUser(WebDriver driverhere) 
	{
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);

	}

	@FindBy (xpath= "//header/div[1]/div[1]/ul[1]/li[2]/a[1]") WebElement signIn;
	@FindBy (xpath= "//input[@id='email']") WebElement logEmail;
	@FindBy (xpath= "//input[@id='pass']") WebElement logPassword;
	@FindBy (xpath= "//button[@class='action login primary']") WebElement logSignIn;
	@FindBy (xpath= "//*[contains(text(),'Welcome')]") WebElement logWelcome;
	@FindBy (xpath= "//div[contains(text(),'The account sign-in was incorrect or your account ')]") WebElement logWithIncorrectCred;
	@FindBy (xpath= "//button[@class='action switch']") WebElement accDropdown;
	@FindBy (xpath= "//a[@href='https://magento.softwaretestingboard.com/customer/account/logout/']") WebElement signOut;
	@FindBy (xpath= "//span[text()='Forgot Your Password?']") WebElement forgotPass;
	@FindBy (xpath= "//input[@id='email_address']") WebElement forgotPassEmail;
	@FindBy (xpath= "//span[contains(text(),'Reset My Password')]") WebElement resetPass;
	@FindBy (xpath= "//div[contains(text(),'you will receive an email with a link to reset your password')]") WebElement resetMsg;
	
	
	public void loginWithCorrectCred() 
	{
		implicitlywaitmethod();
		try 
		{
			ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			rf.gotoHomepage();
			rf.login(true);

			ReusableClass rc = new ReusableClass(driver);
			rc.innerTextEquals(logWelcome, logWelcome.getText());

			System.out.println("Test case 5 executed successfully...");
		}
		catch (Exception e) 
		{
			System.out.println("Exception occured in testcase 5 execution");
			e.printStackTrace();
			Assert.fail();
		}

	}

	public void loginWithInCorrectCred() 
	{
		implicitlywaitmethod();
		try 
		{
			ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			rf.gotoHomepage();
			rf.login(false);

			ReusableClass rc = new ReusableClass(driver);
			rc.innerTextEquals(logWithIncorrectCred, logWithIncorrectCred.getText());

			System.out.println("Test case 6 executed successfully...");
		} 
		catch (Exception e) 
		{
			System.out.println("Exception occured in testcase 6 execution");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void logout() 
	{
		implicitlywaitmethod();
		try
		{
			ReusableClass rc = new ReusableClass(driver);
			clickLogout();
			//wait for homepage to appear after signout
			Thread.sleep(6000); 
			
			//Verify if we are at homepage
			rc.urlEquals("https://magento.softwaretestingboard.com/");
			System.out.println("Test case 2 executed successfully...");
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in testcase 2 execution");
			e.printStackTrace();
			Assert.fail();
		}
	}

	public void clickLogout() {
		waitTillLinkIsClickable(accDropdown);
		accDropdown.click();
		
		waitTillLinkIsClickable(signOut);
		signOut.click();
		System.out.println("logged out successfully");
	}
	
	public void forgotPassword() 
	{
		implicitlywaitmethod();
		try 
		{
			ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			rf.gotoHomepage();
			
			waitTillLinkIsClickable(signIn);
			signIn.click();
			
			waitTillLinkIsClickable(forgotPass);
			forgotPass.click();
			
			waitTillLinkIsClickable(forgotPassEmail);
			forgotPassEmail.click();
			
			String fpEmail = getForgotPassEmail();
			forgotPassEmail.sendKeys(fpEmail);
			
			waitTillLinkIsClickable(resetPass);
			resetPass.click();
			
			waitTillLinkIsClickable(resetMsg);
			boolean successMsg = driver.findElement(By.xpath("//div[contains(text(),'you will receive an email with a link to reset your password')]")).isDisplayed();
			System.out.println("success message = "+successMsg);
			if(successMsg==false) {
				Assert.fail();
			}
			
			System.out.println("Test case 7 executed successfully...");
		} 
		catch (Exception e) 
		{
			System.out.println("Exception occured in testcase 7 execution");
			e.printStackTrace();
			Assert.fail();
		}
	}

	private String getForgotPassEmail() throws IOException {
		FileInputStream fs = new FileInputStream("C:\\Users\\atamboli\\Desktop\\Excelr\\LumaProjectData.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);

		String emailid = sheet.getRow(4).getCell(1).toString();
		return emailid;		
	}
	
}
