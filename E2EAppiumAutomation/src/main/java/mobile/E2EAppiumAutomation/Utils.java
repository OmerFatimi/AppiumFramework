package mobile.E2EAppiumAutomation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utils {
	AndroidDriver<AndroidElement> driver;
	public Utils(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
	}
	
	public AndroidElement scrollToView(String text) {
		return driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))");
	}
}
