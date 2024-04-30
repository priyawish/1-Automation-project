package pageElements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.AbstractMethods;
import utilities.ReusableClass;
import utilities.ReusableFunctionalities;

public class EditCart extends AbstractMethods
{
	
	WebDriver driver;	
	public EditCart(WebDriver driverhere) 
	{
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath= "//header/div[2]/div[1]/a[1]") WebElement cartButton;
	@FindBy (xpath= "//span[contains(text(),'View and Edit Cart')]") WebElement viewAndEditCart;
	@FindBy (xpath= "//body/div[2]/main[1]/div[1]/h1[1]/span[1]") WebElement shoppingCart;
	@FindBy (xpath= "//span[contains(text(),'Move to Wishlist')]") WebElement moveToWish;
	@FindBy (xpath= "//div[contains(text(),'has been moved to your wish list')]") WebElement wishlistSuccessMsg;
	@FindBy (xpath= "//a[contains(text(),'here')]") WebElement clickHere;
	@FindBy (xpath= "//span[contains(text(),'Men')]") WebElement menDropdown;
	@FindBy (xpath= "//a[contains(text(),'Jackets')]") WebElement menJackets;
	@FindBy (xpath= "//body/div[2]/main[1]/div[3]/div[1]/div[3]/p[1]") WebElement itemsFound;
	@FindBy (xpath= "//a[@class='action delete']") WebElement deleteItem;
	@FindBy (xpath= "//div[contains(text(),'Are you sure you would like to remove this item fr')]") WebElement deleteItemConfirmMsg;
	@FindBy (xpath= "//span[contains(text(),'Cancel')]") WebElement clickOnCancel;
	@FindBy (xpath= "//span[contains(text(),'OK')]") WebElement clickOnOk;
	@FindBy (xpath= "//strong[contains(text(),'You have no items in your shopping cart.')]") WebElement productDeleted;
	
	public void verifyCart()
	{
		implicitlywaitmethod();
		try 
		{
			ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			rf.gotoHomepage();
			
			waitTillLinkIsClickable(cartButton);
			cartButton.click();
			
			waitTillLinkIsClickable(viewAndEditCart);
			viewAndEditCart.click();
			
			ReusableClass rc = new ReusableClass(driver);
			rc.innerTextEquals(shoppingCart,"Shopping Cart");
			
			System.out.println("Testcase 11--> executed succesfully");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in testcase 11 execution");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void moveToWishList()
	{
		implicitlywaitmethod();
		try 
		{
			ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			rf.gotoHomepage();
			
			waitTillLinkIsClickable(cartButton);
			cartButton.click();
			
			waitTillLinkIsClickable(viewAndEditCart);
			viewAndEditCart.click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", moveToWish);
			
			waitTillLinkIsClickable(moveToWish);
			moveToWish.click();
			
			ReusableClass rc = new ReusableClass(driver);
			rc.innerTextEquals(wishlistSuccessMsg,"has been moved to your wish list");
			
			System.out.println("Testcase 12--> executed succesfully");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in testcase 12 execution");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void continueShopping()
	{
		implicitlywaitmethod();
		try 
		{
			//ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			//rf.gotoHomepage();
			
			waitTillLinkIsClickable(cartButton);
			cartButton.click();
			
			waitTillLinkIsClickable(viewAndEditCart);
			viewAndEditCart.click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", moveToWish);
			
			waitTillLinkIsClickable(moveToWish);
			moveToWish.click();
			
			ReusableClass rc = new ReusableClass(driver);
			rc.innerTextEquals(wishlistSuccessMsg,"Circe Hooded Ice Fleece has been moved to your wis");
			
			waitTillLinkIsClickable(clickHere);
			clickHere.click();
			
			implicitlywaitmethod();
			rc.urlEquals("https://magento.softwaretestingboard.com/");
			//rf.gotoHomepage();
			
//			waitTillLinkIsClickable(menDropdown);
//			menDropdown.click();
//			
//			waitTillLinkIsClickable(menJackets);
//			menJackets.click();
//			
//			rc.innerTextEquals(itemsFound,"11 Items");
			
			System.out.println("Testcase 13--> executed succesfully");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in testcase 13 execution");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void removeItemCancel()
	{
		implicitlywaitmethod();
		try 
		{
			ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			rf.gotoHomepage();
			
			waitTillLinkIsClickable(cartButton);
			cartButton.click();
			
			waitTillLinkIsClickable(deleteItem);
			deleteItem.click();
			
			ReusableClass rc = new ReusableClass(driver);
			rc.innerTextEquals(deleteItemConfirmMsg,"Are you sure you would like to remove this item fr");
			
			waitTillLinkIsClickable(clickOnCancel);
			clickOnCancel.click();
			
			System.out.println("Testcase 14--> executed succesfully");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in testcase 14 execution");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	public void removeItem()
	{
		implicitlywaitmethod();
		try 
		{
			ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			rf.gotoHomepage();
			
			waitTillLinkIsClickable(cartButton);
			cartButton.click();
			
			waitTillLinkIsClickable(deleteItem);
			deleteItem.click();
			
			ReusableClass rc = new ReusableClass(driver);
			rc.innerTextEquals(deleteItemConfirmMsg,"Are you sure you would like to remove this item fr");
			
			waitTillLinkIsClickable(clickOnOk);
			clickOnOk.click();
			
			rc.innerTextEquals(productDeleted,"You have no items in your shopping cart.");
			boolean successMsg = driver.findElement(By.xpath("//strong[contains(text(),'You have no items in your shopping cart.')]")).isDisplayed();
			System.out.println("success message = "+successMsg);
			if(successMsg==false) {
				Assert.fail();
			}
			
			System.out.println("Testcase 15--> executed succesfully");
			
		}
		catch(Exception e)
		{
			System.out.println("Exception occured in testcase 15 execution");
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	
	
}
