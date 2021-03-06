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
	public void letsShop(String name, String country, String gender) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		FormPage formPage = new FormPage(driver);
		
		formPage.selectCountry(country);
		formPage.enterName(name);
		formPage.selectGender(gender);
		formPage.clickLetsShopButton();
	}
}

