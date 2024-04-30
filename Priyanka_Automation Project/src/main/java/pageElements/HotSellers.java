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

public class HotSellers extends AbstractMethods 
{
	
	WebDriver driver;	
	public HotSellers(WebDriver driverhere) 
	{
		super(driverhere);
		this.driver = driverhere;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath= "//button[@class='action login primary']") WebElement logSignIn;
	@FindBy (xpath= "//p[contains(text(),'Here is what`s trending on Luma right now')]") WebElement trendingProd;
	@FindBy (xpath= "//body/div[2]/main[1]/div[3]/div[1]/div[3]/div[3]/div[1]/div[1]/ol[1]/li[1]/div[1]/a[1]/span[1]/span[1]/img[1]") WebElement firstProd;
	@FindBy (xpath= "//span[contains(text(),'Add to Cart')]") WebElement addToCart;
	@FindBy (xpath= "//div[@id='option-label-size-143-item-166']") WebElement teeSizeXS;
	@FindBy (xpath= "//div[@id='option-label-color-93-item-50']") WebElement teeColorBlue;
	@FindBy (xpath= "//div[contains(text(),'You added')]") WebElement addedToCartSuccessMsg;
	
	
	public void addProductFromHotSellers()
	{
		implicitlywaitmethod();
		try 
		{
			ReusableFunctionalities rf = new ReusableFunctionalities(driver);
			rf.gotoHomepage();
			//rf.login(true);
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", trendingProd);
			
			ReusableClass rc = new ReusableClass(driver);
			rc.innerTextEquals(trendingProd,"Here is what`s trending on Luma right now");
			
			waitTillLinkIsClickable(firstProd);
			firstProd.click();
			
			waitTillLinkIsClickable(teeSizeXS);
			teeSizeXS.click();
			
			waitTillLinkIsClickable(teeColorBlue);
			teeColorBlue.click();
			
			js.executeScript("arguments[0].scrollIntoView();", addToCart);
			waitTillLinkIsClickable(addToCart);
			addToCart.click();
			
			rc.innerTextEquals(addedToCartSuccessMsg,"You added Radiant Tee to your shopping cart.");
			
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
