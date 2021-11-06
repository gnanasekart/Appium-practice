package myAppium.App;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.AbstractOptionCombinedWithPosition;
import io.appium.java_client.touch.offset.ElementOption;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class Delete_SMS {
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("deviceName", "sekar");
		dc.setCapability("appPackage", "com.android.mms");
		dc.setCapability("appActivity", "com.android.mms.ui.MmsTabActivity");
		dc.setCapability("noReset", true);
		AppiumDriver<WebElement> driver = new AppiumDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), dc);

		driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Compose\"]").click();
		driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Recipient: \"]").sendKeys("9790375500");
		driver.findElementById("com.android.mms:id/confirm_recipient").click();
		driver.findElementById("com.android.mms:id/embedded_text_editor").sendKeys("Hi");
		driver.findElementById("com.android.mms:id/send_button").click();
		WebElement name = driver.findElementById("com.android.mms:id/message_body");
		
		TouchAction action = new TouchAction(driver).longPress(longPressOptions()
				.withElement(element(name)).withDuration(Duration.ofMillis(10000))).release().perform();
        //Thread.sleep(5000);

		List<WebElement> option = driver.findElementsByClassName("android.widget.TextView");
		for(int i=0; i<=option.size()-1;i++) {
			if (option.get(i).getText().contains("Delete")) {
				option.get(i).click();
			}
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementById("android:id/button1").click();
	}

	private static ElementOption element(WebElement name) {
		// TODO Auto-generated method stub
		return null;
	}

	private static AbstractOptionCombinedWithPosition<LongPressOptions> longPressOptions() {
		// TODO Auto-generated method stub
		return null;
	}
}