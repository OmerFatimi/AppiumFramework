package mobile.E2EAppiumAutomation;


import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DataProvider.TestData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import pageObjects.CartPage;
import pageObjects.FormPage;
import pageObjects.ProductsPage;
import pageObjects.WebPage;

import java.io.IOException;

public class ecom_t1 extends Base{
	
	@Test(dataProvider="InputData", dataProviderClass=TestData.class)
	public void totalValidation(String input) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
 		//AppiumDriverLocalService service = startServer();
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		FormPage formPage = new FormPage(driver);
		ProductsPage productsPage = new ProductsPage(driver);
		CartPage cartPage = new CartPage(driver);
		WebPage webPage = new WebPage(driver);
		String productName = "Jordan 6 Rings";
		
		formPage.selectCountry("Argentina");
		formPage.enterName(input);
		formPage.selectGender("Male");
		formPage.clickLetsShopButton();

		productsPage.selectProduct(productName);
		productsPage.navigateToCart();
		cartPage.navigateToCart(productName);
//		Thread.sleep(3000);
//		webPage.browseOnBrowser();
//		Thread.sleep(3000);
//		webPage.navigateBackToApplication();
//		//service.stop();
	}
}

