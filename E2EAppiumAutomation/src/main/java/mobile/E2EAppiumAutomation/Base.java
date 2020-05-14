package mobile.E2EAppiumAutomation;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Base {
	public static AppiumDriverLocalService service;
	public static AndroidDriver<AndroidElement> driver;
	public static AndroidDriver<AndroidElement> capabilities(String appName) throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/global.properties");
		Properties prop = new Properties();
		prop.load(fis);
	
		DesiredCapabilities cap = new DesiredCapabilities();
		 File f = new File("src");
		 File fs = new File(f, (String) prop.get(appName));
		 
		String deviceName = (String) prop.get("device");
		String appiumVersion = (String) prop.get("appiumVersion");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		cap.setCapability(MobileCapabilityType.APPIUM_VERSION, appiumVersion);
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		return driver;
	}
	
	//Start appium server
	public AppiumDriverLocalService startServer() {
		boolean flag = checkIfServerIsRunning(4723);
		if (!flag) {
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;
	}
	
	//checking the status of server
	public static boolean checkIfServerIsRunning(int port) {
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch(IOException e) {
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public void KillAllNodes() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}
	
	//Close appium server
	public void closeServer() {
		service.stop();
	}
	
	public static void getScreenShot(String testName) throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"/screenshot⁩/"+testName+".png"));
	}

} 
