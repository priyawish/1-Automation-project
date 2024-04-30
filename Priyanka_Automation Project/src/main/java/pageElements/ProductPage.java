package pageElements;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.AbstractMethods;
import utilities.ReusableClass;
import utilities.ReusableFunctionalities;

public class ProductPage extends AbstractMethods
{
	WebDriver driver;

	public ProductPage(WebDriver driverhere) 
	{
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath= "//span[contains(text(),'Women')]") WebElement womenDropdown;
	@FindBy (xpath= "//a[contains(text(),'Hoodies & Sweatshirts')]") WebElement topsOption;
	@FindBy (xpath= "//body/div[2]/main[1]/div[3]/div[1]/div[4]/ol[1]/li[1]/div[1]/a[1]/span[1]/span[1]/img[1]") WebElement circeHoodie;
	@FindBy (xpath= "//div[@id='option-label-size-143-item-166']") WebElement hoodieSizeXS;
	@FindBy (xpath= "//div[@id='option-label-color-93-item-52']") WebElement hoodieColorGrey;
	@FindBy (xpath= "//span[contains(text(),'Add to Cart')]") WebElement hoodieAddToCart;
	@FindBy (xpath= "//div[contains(text(),'You added')]") WebElement cartSuccessMsg;
	@FindBy (xpath= "//dt[contains(text(),'Category')]") WebElement prodCategory;
	@FindBy (xpath= "//input[@id='search']") WebElement searchButton;
	@FindBy (xpath= "//header/div[2]/div[2]/div[2]/form[1]/div[2]/button[1]") WebElement searchIcon;
	@FindBy (xpath= "//a[contains(text(),'Balboa Persistence Tee')]") WebElement mensTshirt;

	public void productDetailsPage() {
		implicitlywaitmethod();

		try 
		{
			ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			rf.gotoHomepage();
			rf.login(true);
			
			waitTillLinkIsClickable(womenDropdown);
			womenDropdown.click();
			
			ReusableClass rc = new ReusableClass(driver);
			rc.innerTextEquals(prodCategory,"Category");
			
			System.out.println("Testcase 8--> executed succesfully");
		}
		catch (Exception e)
		{
			System.out.println("Exception occured in testcase 8 execution");
			e.printStackTrace();
			Assert.fail();
		}

	}
	
	public void productSearch() {
		implicitlywaitmethod();

		try 
		{
			ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			rf.gotoHomepage();
			//rf.login(true);
			
			waitTillLinkIsClickable(searchButton);
			searchButton.click();
			System.out.println("Clicking on the search product textbox");
			
			searchButton.sendKeys("Balboa Persistence Tee");
			waitTillLinkIsClickable(searchIcon);
			searchIcon.click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", mensTshirt);
			
			ReusableClass rc = new ReusableClass(driver);
			rc.innerTextEquals(mensTshirt,"Balboa Persistence Tee");
			
			System.out.println("Testcase 9--> executed succesfully");
		}
		catch (Exception e)
		{
			System.out.println("Exception occured in testcase 9 execution");
			e.printStackTrace();
			Assert.fail();
		}

	}
	
	public void addProduct() {
		implicitlywaitmethod();

		try 
		{
			addCirceHoodieToCart();
			
			ReusableClass rc = new ReusableClass(driver);
			rc.innerTextEquals(cartSuccessMsg,"You added Circe Hooded Ice Fleece to your shopping cart.");
			
			System.out.println("Testcase 10--> executed succesfully");
		}
		catch (Exception e)
		{
			System.out.println("Exception occured in testcase 10 execution");
			e.printStackTrace();
			Assert.fail();
		}

	}
	
	public void addCirceHoodieToCart() throws IOException
	{
		implicitlywaitmethod();
		
		ReusableFunctionalities rf = new ReusableFunctionalities(driver);
		rf.gotoHomepage();
		//rf.login(true);
		
		waitTillLinkIsClickable(womenDropdown);
		womenDropdown.click();
		
		waitTillLinkIsClickable(topsOption);
		topsOption.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", circeHoodie);
		
		waitTillLinkIsClickable(circeHoodie);
		circeHoodie.click();
		
		waitTillLinkIsClickable(hoodieSizeXS);
		hoodieSizeXS.click();
		
		waitTillLinkIsClickable(hoodieColorGrey);
		hoodieColorGrey.click();
		
		waitTillLinkIsClickable(hoodieAddToCart);
		hoodieAddToCart.click();
	}
	
}
