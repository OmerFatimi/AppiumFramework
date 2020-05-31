package mobile.E2EAppiumAutomation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import DataProvider.TestData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.CartPage;
import pageObjects.FormPage;
import pageObjects.ProductsPage;
import pageObjects.WebPage;

public class ecom_t2 extends Base{
	
	@Test(dataProvider="TillCheckout", dataProviderClass=TestData.class)
	public void totalValidation(String name, String country, String gender, String productName) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
 		//AppiumDriverLocalService service = startServer();
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		FormPage formPage = new FormPage(driver);
		ProductsPage productsPage = new ProductsPage(driver);
		CartPage cartPage = new CartPage(driver);
		WebPage webPage = new WebPage(driver);
		
		formPage.selectCountry(country);
		formPage.enterName(name);
		formPage.selectGender(gender);
		formPage.clickLetsShopButton();

		productsPage.selectProduct(productName);
		productsPage.navigateToCart();
		cartPage.navigateToCart(productName);
		Thread.sleep(3000);
		webPage.browseOnBrowser();
		Thread.sleep(3000);
		webPage.navigateBackToApplication();
//		//service.stop();
	}
}
