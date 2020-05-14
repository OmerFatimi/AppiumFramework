package pageObjects;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class CartPage {
	AndroidDriver<AndroidElement> driver;
	public CartPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}
	 
	public void navigateToCart(String productName) {
		//Page 3 starts ////////////////////
		products().size();
		 for (int i = 0; i < products().size(); i++) {
			 String act1 = products().get(i).getText();
			 if (act1.equals(productName))
				 System.out.println("True");
		 }
		 
		 int size = productPrice().size();
		 for (int i = 0; i < size; i++) {
			 String amt = productPrice().get(i).getText();
			 amt = amt.substring(1);
			 double amount = Double.parseDouble(amt);
		 }
		 selectCheckBox();
		 viewTOU();
		 proceedButton().click();
	}
	public void selectCheckBox() {
		 //tapping on checkbox
		TouchAction t = new TouchAction(driver);
		 WebElement checkbox = checkBox();
		 t.tap(tapOptions().withElement(element(checkbox))).perform();
	}
	
	public void viewTOU() {
		 //Long press on an object
		TouchAction t = new TouchAction(driver);
		 WebElement toc = TOC();
		 t.longPress(longPressOptions().withElement(element(toc)).withDuration(ofSeconds(2))).release().perform();
		 
		 button1().click();
	}
	
	//Object repository
	public List<AndroidElement> products() {
		return driver.findElements(By.id("com.androidsample.generalstore:id/productName"));
	}
	public List<AndroidElement> productPrice() {
		return driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
	}
	public AndroidElement checkBox() {
		return driver.findElement(By.className("android.widget.CheckBox"));
	}
	public AndroidElement TOC() {
		return driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
	}
	public AndroidElement button1() {
		return driver.findElement(By.id("android:id/button1"));
	}
	public AndroidElement proceedButton() {
		return driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed"));
	}
}
