package pageObjects;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ProductsPage {
	AndroidDriver<AndroidElement> driver;
	public ProductsPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}
	public void selectProduct(String productName) {
		item(productName);
	    int count = product().size();
		 
		for (int i = 0; i < count; i++) {
			 String text = product().get(i).getText();
			 if (text.equalsIgnoreCase(productName)) {
				 addToCartLink().get(i).click();
				 break;
			 }
		 }
	}
	public void navigateToCart() {
		cartIcon().click();
	}
	
	//Object repository
	public AndroidElement item(String product) {
		return driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))");
	}
	public List<AndroidElement> addToCartLink() {
		return driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart"));
	}
	public List<AndroidElement> product() {
		return driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
	}
	public AndroidElement cartIcon() {
		return driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart"));
	}
	
}
