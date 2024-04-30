package pageElements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.AbstractMethods;
import utilities.ReusableClass;
import utilities.ReusableFunctionalities;

public class CheckoutFunctionality extends AbstractMethods 
{

	WebDriver driver;	
	public CheckoutFunctionality(WebDriver driverhere) 
	{
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath= "//button[@id='top-cart-btn-checkout']") WebElement proceedToCheckOutBtn;
	@FindBy (xpath= "//span[contains(text(),'Next')]")WebElement nextBtn;
	@FindBy (xpath= "//span[@id='tooltip']")WebElement clickQueMark;
	@FindBy (xpath= "//div[contains(text(),'For delivery questions.')]")WebElement deliveryQue;
	@FindBy (xpath= "//tbody/tr[1]/td[1]")WebElement bestShippingWay;
	@FindBy (xpath= "//tbody/tr[2]/td[1]/input[1]")WebElement flatRateShippingWay;
	@FindBy (xpath= "//span[contains(text(),'This is a required field.')]")WebElement requiredField;
	@FindBy (xpath= "//span[contains(text(),'This is a required field.')]")WebElement requiredFieldMsg;
	@FindBy (xpath= "//input[@id='GXAC6NP']")WebElement zipCode;
	@FindBy (xpath= "//span[contains(text(),'Provided Zip/Postal Code seems to be invalid.')]")WebElement zipInvalidMsg;
	@FindBy (xpath= "//body/div[2]/main[1]/div[2]/div[1]/div[3]/aside[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]")WebElement cartDropdown;
	@FindBy (xpath= "//strong[contains(text(),'Circe Hooded Ice Fleece')]")WebElement hoodieItem;
	@FindBy (xpath= "//body/div[2]/main[1]/div[2]/div[1]/div[3]/aside[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ol[1]/li[1]/div[1]/div[1]/div[2]/span[1]")WebElement detailsDropdown;
	@FindBy (xpath= "//strong[contains(text(),'Circe Hooded Ice Fleece')]")WebElement itemDisplayed;
	@FindBy (xpath= "//dt[contains(text(),'Size')]")WebElement sizeDisplayed;
	@FindBy (xpath= "//dt[contains(text(),'Color')]")WebElement colorDisplayed;
	@FindBy (xpath= "//body/div[3]/main[1]/div[2]/div[1]/div[3]/div[4]/ol[1]/li[3]/div[1]/form[1]/fieldset[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]")WebElement billingAddCheckbox;
	@FindBy (xpath= "//span[contains(text(),'Apply Discount Code')]")WebElement discountCodeClick;
	@FindBy (xpath= "//input[@id='discount-code']")WebElement discCode;
	@FindBy (xpath= "//span[contains(text(),'Place Order')]")WebElement placeOrder;
	@FindBy (xpath= "//span[contains(text(),'Thank you for your purchase!')]")WebElement orderSuccessMsg;
	@FindBy (xpath= "//a[contains(text(),'Print receipt')]")WebElement receipt;
	
	
	public void proceedToCheckout()
	{
		implicitlywaitmethod();
		try 
		{
			
			//ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			//rf.gotoHomepage();
			
			ProductPage pp = new ProductPage(driver);
			pp.addCirceHoodieToCart();
			
			waitTillLinkIsClickable(proceedToCheckOutBtn);
			proceedToCheckOutBtn.click();
			
			ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			rf.checkOutPage();
			
			waitTillLinkIsClickable(nextBtn);
			nextBtn.click();
			
			System.out.println("Testcase 17--> executed succesfully");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in testcase 17 execution");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void phoneNoQueMark()
	{
		implicitlywaitmethod();
		try 
		{
			
			ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			rf.gotoHomepage();
			
			ProductPage pp = new ProductPage(driver);
			pp.addCirceHoodieToCart();
			
			waitTillLinkIsClickable(proceedToCheckOutBtn);
			proceedToCheckOutBtn.click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", nextBtn);
			
			waitTillLinkIsClickable(clickQueMark);
			clickQueMark.click();
			
			ReusableClass rc = new ReusableClass(driver);
			rc.innerTextEquals(clickQueMark,"For delivery questions.");
			
			System.out.println("Testcase 18--> executed succesfully");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in testcase 18 execution");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void clickTableShippingWay()
	{
		implicitlywaitmethod();
		try 
		{
			
			ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			rf.gotoHomepage();
			
			ProductPage pp = new ProductPage(driver);
			pp.addCirceHoodieToCart();
			
			waitTillLinkIsClickable(proceedToCheckOutBtn);
			proceedToCheckOutBtn.click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", nextBtn);
			
			waitTillLinkIsClickable(bestShippingWay);
			bestShippingWay.click();
			
			waitTillLinkIsClickable(nextBtn);
			nextBtn.click();

			ReusableClass rc = new ReusableClass(driver);
			rc.innerTextEquals(requiredField, "This is a required field.");

			
			System.out.println("Testcase 19--> executed succesfully");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in testcase 19 execution");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void clickFixedShippingWay()
	{
		implicitlywaitmethod();
		try 
		{
			
			ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			rf.gotoHomepage();
			
			ProductPage pp = new ProductPage(driver);
			pp.addCirceHoodieToCart();
			
			waitTillLinkIsClickable(proceedToCheckOutBtn);
			proceedToCheckOutBtn.click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", nextBtn);
			
			waitTillLinkIsClickable(flatRateShippingWay);
			flatRateShippingWay.click();
			
			waitTillLinkIsClickable(nextBtn);
			nextBtn.click();

			ReusableClass rc = new ReusableClass(driver);
			rc.innerTextEquals(requiredFieldMsg, "This is a required field.");

			
			System.out.println("Testcase 20--> executed succesfully");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in testcase 20 execution");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void incorrectZip()
	{
		implicitlywaitmethod();
		try 
		{
			
			ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			rf.gotoHomepage();
			
			ProductPage pp = new ProductPage(driver);
			pp.addCirceHoodieToCart();
			
			waitTillLinkIsClickable(proceedToCheckOutBtn);
			proceedToCheckOutBtn.click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", nextBtn);
			
			waitTillLinkIsClickable(nextBtn);
			nextBtn.click();

			ReusableClass rc = new ReusableClass(driver);
			rc.innerTextEquals(zipInvalidMsg, "Provided Zip/Postal Code seems to be invalid.");

			
			System.out.println("Testcase 21--> executed succesfully");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in testcase 21 execution");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void orderSummary()
	{
		implicitlywaitmethod();
		try 
		{
			
			ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			rf.gotoHomepage();
			
			ProductPage pp = new ProductPage(driver);
			pp.addCirceHoodieToCart();
			
			waitTillLinkIsClickable(proceedToCheckOutBtn);
			proceedToCheckOutBtn.click();
			
			waitTillLinkIsClickable(cartDropdown);
			cartDropdown.click();
		
			ReusableClass rc = new ReusableClass(driver);
			rc.innerTextEquals(hoodieItem, "Circe Hooded Ice Fleece");
			
			waitTillLinkIsClickable(detailsDropdown);
			detailsDropdown.click();

			rc.innerTextEquals(sizeDisplayed, "Circe Hooded Ice Fleece");
			
			System.out.println("Testcase 22--> executed succesfully");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in testcase 22 execution");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void billingCheckBox()
	{
		implicitlywaitmethod();
		try 
		{
			
			ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			rf.gotoHomepage();
			
			ProductPage pp = new ProductPage(driver);
			pp.addCirceHoodieToCart();
			
			waitTillLinkIsClickable(proceedToCheckOutBtn);
			proceedToCheckOutBtn.click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", nextBtn);
			
			ReusableClass rc = new ReusableClass(driver);
			rc.innerTextEquals(billingAddCheckbox, "My billing and shipping address are the same");
			
			System.out.println("Testcase 23--> executed succesfully");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in testcase 23 execution");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void orderPlaced()
	{
		implicitlywaitmethod();
		try 
		{
			
			ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			rf.gotoHomepage();
			
			ProductPage pp = new ProductPage(driver);
			pp.addCirceHoodieToCart();
			
			waitTillLinkIsClickable(proceedToCheckOutBtn);
			proceedToCheckOutBtn.click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", nextBtn);
			
			ReusableClass rc = new ReusableClass(driver);
			rc.innerTextEquals(billingAddCheckbox, "My billing and shipping address are the same");
			
			waitTillLinkIsClickable(discountCodeClick);
			discountCodeClick.click();
			
			rc.innerTextEquals(discCode, "Enter discount code");
			
			System.out.println("Testcase 24--> executed succesfully");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in testcase 24 execution");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void discount()
	{
		implicitlywaitmethod();
		try 
		{
			
			ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			rf.gotoHomepage();
			
			ProductPage pp = new ProductPage(driver);
			pp.addCirceHoodieToCart();
			
			waitTillLinkIsClickable(proceedToCheckOutBtn);
			proceedToCheckOutBtn.click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", nextBtn);
			
			ReusableClass rc = new ReusableClass(driver);
			rc.innerTextEquals(billingAddCheckbox, "My billing and shipping address are the same");
			
			waitTillLinkIsClickable(placeOrder);
			placeOrder.click();
			
			rc.innerTextEquals(orderSuccessMsg, "Thank you for your purchase!");
			
			System.out.println("Testcase 25--> executed succesfully");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in testcase 25 execution");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void orderReceipt()
	{
		implicitlywaitmethod();
		try 
		{
			
			ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			rf.gotoHomepage();
			
			ProductPage pp = new ProductPage(driver);
			pp.addCirceHoodieToCart();
			
			waitTillLinkIsClickable(proceedToCheckOutBtn);
			proceedToCheckOutBtn.click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", nextBtn);
			
			ReusableClass rc = new ReusableClass(driver);
			rc.innerTextEquals(billingAddCheckbox, "My billing and shipping address are the same");
			
			waitTillLinkIsClickable(placeOrder);
			placeOrder.click();
			
			rc.innerTextEquals(orderSuccessMsg, "Thank you for your purchase!");
			
			waitTillLinkIsClickable(receipt);
			receipt.click();
			
			System.out.println("Testcase 26--> executed succesfully");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in testcase 26 execution");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
}
