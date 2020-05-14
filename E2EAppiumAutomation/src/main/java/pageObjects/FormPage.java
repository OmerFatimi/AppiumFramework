package pageObjects;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;
import mobile.E2EAppiumAutomation.Utils;

public class FormPage {
	AndroidDriver<AndroidElement> driver;
	public FormPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}
	
	public void selectCountry(String country) {
		Utils utils = new Utils(driver);
		countryField().click();
		utils.scrollToView(country).click();;
	}
	public void enterName(String name) {
		nameField().click();
		nameField().sendKeys(name);
		driver.hideKeyboard();
	}
	public void selectGender(String gender) {
		selectRadioGender(gender).click();
	}
	public void verifyToastMessage(String message) {
		String toastMessage=toastMessage().getAttribute("name");
		toastMessage = "Toast messasge is: " + toastMessage; 
		Assert.assertEquals(message, toastMessage);
	}
	public void clickLetsShopButton() {
		letsShopButton().click();
	}
	
	//Object repository
	public AndroidElement countryField() {
		return driver.findElement(By.id("android:id/text1"));
	}
	public AndroidElement nameField() {
		return driver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
	}
	public AndroidElement selectRadioGender(String gender) {
		return driver.findElement(By.xpath("//android.widget.RadioButton[@text='"+gender+"']"));
	}
	public AndroidElement toastMessage() {
		return driver.findElement(By.xpath("//android.widget.Toast[1]"));
	}
	public AndroidElement letsShopButton() {
		return driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
	}
}
