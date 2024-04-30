package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageElements.CheckoutFunctionality;
import pageElements.EditCart;
import pageElements.HotSellers;
import pageElements.LoginUser;
import pageElements.ProductPage;
import pageElements.RegisterUser;

public class AutomationTestCases 
{
	
	WebDriver driver;
	RegisterUser ru;
	LoginUser lu;
	HotSellers ht;
	EditCart ec;
	
	@BeforeTest
	public void setup() throws IOException {
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir") + ("\\src\\main\\java\\testData\\GlobalInput.properties"));
		prop.load(fs);

		String browser = prop.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {

			ChromeOptions options = new ChromeOptions();
			options.addExtensions(new File("./Extensions/AdBlock.crx"));
			
			driver = new ChromeDriver(options); // intializing
		} 
		String url = prop.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test (priority=1)
	public void resgisterWithValidCred()
	{
		System.out.println("Excuting Test Case 1...");
		RegisterUser ru = new RegisterUser(driver);
		ru.userRegister();
	}
	
	@Test (priority=2)
	public void logoutFunction()
	{
		System.out.println("Excuting Test Case 2...");
		LoginUser lu = new LoginUser(driver);
		lu.logout();
	}
	
	@Test (priority=3)
	public void resgisterWithInvalidCred()
	{
		System.out.println("Excuting Test Case 3...");
		RegisterUser ru = new RegisterUser(driver);
		ru.userInvalidRegister();
	}
	
	@Test (priority=4)
	public void resgisterWithAlreadyExistingUser()
	{
		System.out.println("Excuting Test Case 4...");
		RegisterUser ru = new RegisterUser(driver);
		ru.registerWithExistingEmail();
	}
	
	@Test(priority = 5) 
	public void loginWithCorrectCred()
	{
		System.out.println("Excuting Test Case 5..."); 
		LoginUser lu = new LoginUser(driver);
		lu.loginWithCorrectCred();
		lu.clickLogout();
	}

	@Test(priority = 6) 
	public void loginWithIncorrectCrend()
	{ 
		System.out.println("Excuting Test Case 6..."); 
		LoginUser lu = new LoginUser(driver);
		lu.loginWithInCorrectCred();
	}
	
	@Test(priority = 7) 
	public void forgotPassword()
	{ 
		System.out.println("Excuting Test Case 7..."); 
		LoginUser lu = new LoginUser(driver);
		lu.forgotPassword();
	}
	
	@Test(priority = 8) 
	public void verifyProductDetailsPage()
	{ 
		System.out.println("Excuting Test Case 8..."); 
		ProductPage pp = new ProductPage(driver);
		pp.productDetailsPage();
	}
	
	@Test(priority = 9) 
	public void searchProduct()
	{ 
		System.out.println("Excuting Test Case 9..."); 
		ProductPage pp = new ProductPage(driver);
		pp.productSearch();
	}
	
	@Test(priority = 10) 
	public void addProductsInCart()
	{ 
		System.out.println("Excuting Test Case 10..."); 
		ProductPage pp = new ProductPage(driver);
		pp.addProduct();
	}
	
	@Test(priority = 11) 
	public void productQuantityInCart()
	{ 
		System.out.println("Excuting Test Case 11..."); 
		EditCart ec = new EditCart(driver);
		ec.verifyCart();
	}
	
	@Test(priority = 12) 
	public void productMovedtoWishList()
	{ 
		System.out.println("Excuting Test Case 12..."); 
		EditCart ec = new EditCart(driver);
		ec.moveToWishList();
	}
	
	@Test(priority = 13) 
	public void clickHereFunction() throws IOException
	{ 
		System.out.println("Excuting Test Case 13...");
		ProductPage pp = new ProductPage(driver);
		pp.addCirceHoodieToCart();
		EditCart ec = new EditCart(driver);
		ec.continueShopping();
	}
	
	@Test(priority = 14) 
	public void removeProductCancel() throws IOException
	{ 
		System.out.println("Excuting Test Case 14..."); 
		ProductPage pp = new ProductPage(driver);
		pp.addCirceHoodieToCart();
		EditCart ec = new EditCart(driver);
		ec.removeItemCancel();
	}
	
	@Test(priority = 15) 
	public void removedProduct()
	{ 
		System.out.println("Excuting Test Case 15..."); 
		EditCart ec = new EditCart(driver);
		ec.removeItem();
	}
	
	@Test(priority = 16) 
	public void testHotSellers()
	{ 
		System.out.println("Excuting Test Case 16..."); 
		ht = new HotSellers(driver);
		ht.addProductFromHotSellers();
	}
	
	@Test(priority = 17) 
	public void checkout() throws IOException
	{ 
		System.out.println("Excuting Test Case 17...");
		ProductPage pp = new ProductPage(driver);
		pp.addCirceHoodieToCart();
		CheckoutFunctionality cf = new CheckoutFunctionality(driver);
		cf.proceedToCheckout();
	}
	
	@Test(priority = 18) 
	public void phoneNoQueMark() throws IOException
	{ 
		System.out.println("Excuting Test Case 18...");
		ProductPage pp = new ProductPage(driver);
		pp.addCirceHoodieToCart();
		CheckoutFunctionality cf = new CheckoutFunctionality(driver);
		cf.phoneNoQueMark();
	}
	
	@Test(priority = 19) 
	public void bestShippingWay() throws IOException
	{ 
		System.out.println("Excuting Test Case 19...");
		ProductPage pp = new ProductPage(driver);
		pp.addCirceHoodieToCart();
		CheckoutFunctionality cf = new CheckoutFunctionality(driver);
		cf.clickTableShippingWay();
	}
	
	@Test(priority = 20) 
	public void flatShippingWay() throws IOException
	{ 
		System.out.println("Excuting Test Case 20...");
		ProductPage pp = new ProductPage(driver);
		pp.addCirceHoodieToCart();
		CheckoutFunctionality cf = new CheckoutFunctionality(driver);
		cf.clickFixedShippingWay();
	}
	
	@Test(priority = 21) 
	public void invalidPostCode() throws IOException
	{ 
		System.out.println("Excuting Test Case 21...");
		ProductPage pp = new ProductPage(driver);
		pp.addCirceHoodieToCart();
		CheckoutFunctionality cf = new CheckoutFunctionality(driver);
		cf.incorrectZip();
	}
	
	@Test(priority = 22) 
	public void summary() throws IOException
	{ 
		System.out.println("Excuting Test Case 22...");
		ProductPage pp = new ProductPage(driver);
		pp.addCirceHoodieToCart();
		CheckoutFunctionality cf = new CheckoutFunctionality(driver);
		cf.orderSummary();
	}
	
	@Test(priority = 23) 
	public void billingCheckBoxChecked() throws IOException
	{ 
		System.out.println("Excuting Test Case 23...");
		ProductPage pp = new ProductPage(driver);
		pp.addCirceHoodieToCart();
		CheckoutFunctionality cf = new CheckoutFunctionality(driver);
		cf.billingCheckBox();
	}
	
	@Test(priority = 24) 
	public void placeTheOrder() throws IOException
	{ 
		System.out.println("Excuting Test Case 24...");
		ProductPage pp = new ProductPage(driver);
		pp.addCirceHoodieToCart();
		CheckoutFunctionality cf = new CheckoutFunctionality(driver);
		cf.orderPlaced();
	}
	
	@Test(priority = 25) 
	public void applyDiscout() throws IOException
	{ 
		System.out.println("Excuting Test Case 25...");
		ProductPage pp = new ProductPage(driver);
		pp.addCirceHoodieToCart();
		CheckoutFunctionality cf = new CheckoutFunctionality(driver);
		cf.discount();
	}
	
	@Test(priority = 26) 
	public void downloadOrderReceipt() throws IOException
	{ 
		System.out.println("Excuting Test Case 26...");
		ProductPage pp = new ProductPage(driver);
		pp.addCirceHoodieToCart();
		CheckoutFunctionality cf = new CheckoutFunctionality(driver);
		cf.orderReceipt();
	}
	
	
	
//	@AfterSuite
//	public void closeBrowser() throws IOException {
//		driver.quit();
//	}

}
