package myAppium.App;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Calculator {
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("deviceName", "sekar");
		dc.setCapability("appPackage", "com.miui.calculator");
		dc.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		dc.setCapability("noReset", true);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		
		driver.findElementById("com.miui.calculator:id/btn_5_s").click();
		driver.findElementById("com.miui.calculator:id/btn_plus_s").click();
		driver.findElementById("com.miui.calculator:id/btn_3_s").click();
		driver.findElementById("com.miui.calculator:id/btn_equal_s").click();
		String value = driver.findElementById("com.miui.calculator:id/result").getText();
		String[] result = value.split(" ");
		int answer = Integer.parseInt(result[1]);
		
		driver.findElementById("com.miui.calculator:id/btn_c_s").click();
		driver.findElementById("com.miui.calculator:id/btn_"+answer+"_s").click();
		driver.findElementById("com.miui.calculator:id/btn_mul_s").click();
		driver.findElementById("com.miui.calculator:id/btn_1_s").click();
		driver.findElementById("com.miui.calculator:id/btn_5_s").click();
		driver.findElementById("com.miui.calculator:id/btn_equal_s").click();
		String secondValue = driver.findElementById("com.miui.calculator:id/result").getText();
		String[] finalResult = secondValue.split(" ");
		int display = Integer.parseInt(finalResult[1]);
		System.out.println(display);
	}
}