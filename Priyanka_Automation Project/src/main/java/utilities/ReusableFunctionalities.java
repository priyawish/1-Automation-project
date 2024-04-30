package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReusableFunctionalities extends AbstractMethods {
	
	WebDriver driver;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Properties prop;

	public ReusableFunctionalities(WebDriver driverhere) throws IOException 
	{
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
		
		loadPropertiesFile();
	}
	
	private void loadPropertiesFile() throws IOException {
		prop = new Properties();
		FileInputStream fs = new FileInputStream(
				System.getProperty("user.dir") + ("\\src\\main\\java\\testData\\GlobalInput.properties"));
		prop.load(fs);
		System.out.println("Properties file loaded");
	}

	@FindBy (xpath= "//header/div[1]/div[1]/ul[1]/li[2]/a[1]")WebElement signIn;
	@FindBy(xpath="//input[@id='firstname']") WebElement firstName;
	@FindBy(xpath="//input[@id='lastname']") WebElement lastName;
	@FindBy(xpath="//input[@id='email_address']") WebElement emailAdd;
	@FindBy(xpath="//input[@id='password']") WebElement password;
	@FindBy(xpath="//input[@id='password-confirmation']") WebElement confirmPassword;
	@FindBy(xpath="//body[1]/div[2]/main[1]/div[3]/div[1]/form[1]/div[1]/div[1]/button[1]/span[1]") WebElement createAnAccount;
	@FindBy (xpath= "//input[@id='email']")WebElement logEmail;
	@FindBy (xpath= "//input[@id='pass']")WebElement logPassword;
	@FindBy (xpath= "//button[@class='action login primary']")WebElement logSignIn;
	@FindBy (xpath= "//input[@id='RXWNKSU']")WebElement companyName;
	@FindBy (xpath= "//input[@id='KWAACCH']")WebElement streetAdd;
	@FindBy (xpath= "//span[contains(text(),'Next')]")WebElement nextBtn;
	@FindBy (xpath= "//input[@id='XY1014T']")WebElement city;
	@FindBy (xpath= "//input[@id='GXAC6NP']")WebElement zipCode;
	@FindBy (xpath= "//input[@id='IF1V6TH']")WebElement phoneNo;
	@FindBy (xpath= "//select[@id='X9HVHY7']")WebElement stateDropdown;
	@FindBy (xpath= "//select[@id='X2JGLSV']")WebElement countryUS;
	@FindBy (xpath= "//tbody/tr[1]/td[1]")WebElement bestShippingWay;
	@FindBy (xpath= "//tbody/tr[2]/td[1]/input[1]")WebElement flatRateShippingWay;
	
	public void gotoHomepage() throws IOException
	{
		System.out.println("Starts gotoHomepage()...");
		implicitlywaitmethod();
		
		String url = prop.getProperty("url");
		driver.get(url);
		System.out.println("gotoHomepage() Ends...");
	}
	
	public void login(boolean valid) throws IOException {
		
		FileInputStream fs = new FileInputStream("C:\\Users\\atamboli\\Desktop\\Excelr\\LumaProjectData.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheetAt(0);

		String emailid = sheet.getRow(2).getCell(1).toString();
		String password = sheet.getRow(3).getCell(1).toString();
		
		waitTillLinkIsClickable(signIn);
		signIn.click();
		
		waitTillLinkIsClickable(logEmail);
		logEmail.click();
		logEmail.sendKeys(emailid);
		
		waitTillLinkIsClickable(logPassword);
		logPassword.click();
		if(valid) {
			logPassword.sendKeys(password);
		}
		else {
			logPassword.sendKeys("dummy");
		}
		
		waitTillLinkIsClickable(logSignIn);
		logSignIn.click();
	}
	
	public void registrationPageInvalid() {
		try 
		{
			FileInputStream fs1 = new FileInputStream("C:\\Users\\atamboli\\Desktop\\Excelr\\LumaProjectData.xlsx");

			XSSFWorkbook workbook = new XSSFWorkbook(fs1);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			waitTillLinkIsClickable(firstName);
			firstName.click();
			firstName.sendKeys((sheet.getRow(0).getCell(1)).toString());
			
			waitTillLinkIsClickable(lastName);
			lastName.click();
			lastName.sendKeys((sheet.getRow(1).getCell(1)).toString());
			
			waitTillLinkIsClickable(emailAdd);
			emailAdd.click();
			emailAdd.sendKeys((sheet.getRow(5).getCell(1)).toString());
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", password);
			
			waitTillLinkIsClickable(password);
			password.click();
			password.sendKeys((sheet.getRow(3).getCell(1)).toString());
			
			waitTillLinkIsClickable(confirmPassword);
			confirmPassword.click();
			confirmPassword.sendKeys((sheet.getRow(3).getCell(1)).toString());

			waitTillLinkIsClickable(createAnAccount);
			createAnAccount.click();
		}

		catch (Exception e) 
		{
			System.out.println("Data retrival failing from excelsheet...");
			e.printStackTrace();
		}
	}
	
	public void registrationPageExistingUser() {
		try 
		{
			FileInputStream fs1 = new FileInputStream("C:\\Users\\atamboli\\Desktop\\Excelr\\LumaProjectData.xlsx");

			XSSFWorkbook workbook = new XSSFWorkbook(fs1);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			waitTillLinkIsClickable(firstName);
			firstName.click();
			firstName.sendKeys((sheet.getRow(0).getCell(1)).toString());
			
			waitTillLinkIsClickable(lastName);
			lastName.click();
			lastName.sendKeys((sheet.getRow(1).getCell(1)).toString());
			
			waitTillLinkIsClickable(emailAdd);
			emailAdd.click();
			emailAdd.sendKeys((sheet.getRow(6).getCell(1)).toString());
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", password);
			
			waitTillLinkIsClickable(password);
			password.click();
			password.sendKeys((sheet.getRow(3).getCell(1)).toString());
			
			waitTillLinkIsClickable(confirmPassword);
			confirmPassword.click();
			confirmPassword.sendKeys((sheet.getRow(3).getCell(1)).toString());

			waitTillLinkIsClickable(createAnAccount);
			createAnAccount.click();
		}

		catch (Exception e) 
		{
			System.out.println("Data retrival failing from excelsheet...");
			e.printStackTrace();
		}
	}
	
	public void registrationpage() 
	{
		try 
		{
			FileInputStream fs1 = new FileInputStream("C:\\Users\\atamboli\\Desktop\\Excelr\\LumaProjectData.xlsx");

			XSSFWorkbook workbook = new XSSFWorkbook(fs1);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			waitTillLinkIsClickable(firstName);
			firstName.click();
			firstName.sendKeys((sheet.getRow(0).getCell(1)).toString());
			
			waitTillLinkIsClickable(lastName);
			lastName.click();
			lastName.sendKeys((sheet.getRow(1).getCell(1)).toString());
			
			waitTillLinkIsClickable(emailAdd);
			emailAdd.click();
			emailAdd.sendKeys((sheet.getRow(2).getCell(1)).toString());
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", password);
			
			waitTillLinkIsClickable(password);
			password.click();
			password.sendKeys((sheet.getRow(3).getCell(1)).toString());
			
			waitTillLinkIsClickable(confirmPassword);
			confirmPassword.click();
			confirmPassword.sendKeys((sheet.getRow(3).getCell(1)).toString());

			waitTillLinkIsClickable(createAnAccount);
			createAnAccount.click();
		}

		catch (Exception e) 
		{
			System.out.println("Data retrival failing from excelsheet...");
			e.printStackTrace();
		}
	}
	
	public void checkOutPage() 
	{
		try 
		{
			FileInputStream fs1 = new FileInputStream("C:\\Users\\atamboli\\Desktop\\Excelr\\LumaProjectData.xlsx");

			XSSFWorkbook workbook = new XSSFWorkbook(fs1);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			waitTillLinkIsClickable(firstName);
			firstName.click();
			firstName.sendKeys((sheet.getRow(0).getCell(1)).toString());
			
			waitTillLinkIsClickable(lastName);
			lastName.click();
			lastName.sendKeys((sheet.getRow(1).getCell(1)).toString());
			
			waitTillLinkIsClickable(companyName);
			companyName.click();
			companyName.sendKeys((sheet.getRow(7).getCell(1)).toString());
			
			waitTillLinkIsClickable(streetAdd);
			streetAdd.click();
			streetAdd.sendKeys((sheet.getRow(8).getCell(1)).toString());
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", nextBtn);
			
			waitTillLinkIsClickable(city);
			city.click();
			city.sendKeys((sheet.getRow(3).getCell(1)).toString());
			
			waitTillLinkIsClickable(stateDropdown);
			stateDropdown.click();
			
			waitTillLinkIsClickable(zipCode);
			zipCode.click();
			zipCode.sendKeys((sheet.getRow(10).getCell(1)).toString());
			
			waitTillLinkIsClickable(countryUS);
			countryUS.click();
			
			waitTillLinkIsClickable(phoneNo);
			phoneNo.click();
			phoneNo.sendKeys((sheet.getRow(3).getCell(1)).toString());
			
			waitTillLinkIsClickable(bestShippingWay);
			bestShippingWay.click();

			waitTillLinkIsClickable(flatRateShippingWay);
			flatRateShippingWay.click();
			
			waitTillLinkIsClickable(nextBtn);
			nextBtn.click();
		}

		catch (Exception e) 
		{
			System.out.println("Data retrival failing from excelsheet...");
			e.printStackTrace();
		}
	}
	
	public void invalidZip() 
	{
		try 
		{
			FileInputStream fs1 = new FileInputStream("C:\\Users\\atamboli\\Desktop\\Excelr\\LumaProjectData.xlsx");

			XSSFWorkbook workbook = new XSSFWorkbook(fs1);
			XSSFSheet sheet = workbook.getSheetAt(0);
			
			waitTillLinkIsClickable(firstName);
			firstName.click();
			firstName.sendKeys((sheet.getRow(0).getCell(1)).toString());
			
			waitTillLinkIsClickable(lastName);
			lastName.click();
			lastName.sendKeys((sheet.getRow(1).getCell(1)).toString());
			
			waitTillLinkIsClickable(companyName);
			companyName.click();
			companyName.sendKeys((sheet.getRow(7).getCell(1)).toString());
			
			waitTillLinkIsClickable(streetAdd);
			streetAdd.click();
			streetAdd.sendKeys((sheet.getRow(8).getCell(1)).toString());
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", nextBtn);
			
			waitTillLinkIsClickable(city);
			city.click();
			city.sendKeys((sheet.getRow(3).getCell(1)).toString());
			
			waitTillLinkIsClickable(stateDropdown);
			stateDropdown.click();
			
			waitTillLinkIsClickable(zipCode);
			zipCode.click();
			zipCode.sendKeys((sheet.getRow(12).getCell(1)).toString());
			
			waitTillLinkIsClickable(countryUS);
			countryUS.click();
			
			waitTillLinkIsClickable(phoneNo);
			phoneNo.click();
			phoneNo.sendKeys((sheet.getRow(3).getCell(1)).toString());
			
			waitTillLinkIsClickable(bestShippingWay);
			bestShippingWay.click();

//			waitTillLinkIsClickable(flatRateShippingWay);
//			flatRateShippingWay.click();
			
			waitTillLinkIsClickable(nextBtn);
			nextBtn.click();
		}

		catch (Exception e) 
		{
			System.out.println("Data retrival failing from excelsheet...");
			e.printStackTrace();
		}
	}
	

}
