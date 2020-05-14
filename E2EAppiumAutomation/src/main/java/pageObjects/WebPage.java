package pageObjects;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class WebPage {
	AndroidDriver<AndroidElement> driver;
	public WebPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}
	
	public void browseOnBrowser() {
		 //geting context handles
		 Set<String> contexts = driver.getContextHandles();
		 //switching to web browser
		 driver.context("WEBVIEW_com.androidsample.generalstore");
		 searchField().sendKeys("hello");
		 searchField().sendKeys(Keys.ENTER);
		 
	}
	public void navigateBackToApplication() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	//Object repository
	public AndroidElement searchField() {
		return driver.findElement(By.name("q"));
	}
}
