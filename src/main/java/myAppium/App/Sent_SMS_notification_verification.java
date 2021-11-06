package myAppium.App;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Sent_SMS_notification_verification {
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("deviceName", "sekar");
		dc.setCapability("appPackage", "com.android.mms");
		dc.setCapability("appActivity", "com.android.mms.ui.MmsTabActivity");
		dc.setCapability("noReset", true);
		AppiumDriver<WebElement> driver = new AppiumDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		
		driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Compose\"]").click();
		driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Recipient: \"]").sendKeys("9994659780");
		driver.findElementById("com.android.mms:id/confirm_recipient").click();
		driver.findElementById("com.android.mms:id/embedded_text_editor").sendKeys("Hi");
		driver.findElementById("com.android.mms:id/send_button").click();
		driver.findElementById("com.android.mms:id/up").click();
		
		TouchAction<?> action = new TouchAction<>(driver);
		Dimension size = driver.manage().window().getSize();
		int maxY = size.getHeight();
		int maxX = size.getWidth();
		
		// Swipe down
				action.press(PointOption.point((int) (maxX * 0.5), (int) (maxY * 0.0)))
						.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
						.moveTo(PointOption.point((int) (maxX * 0.5), (int) (maxY * 0.8))).release().perform();
		
		List<WebElement> name = driver.findElementsById("com.android.mms:id/message_body");
		int length = name.size();
		String bodyContent = name.get(length-1).getText().toString();
		if (bodyContent.contains("Hi")) {
			System.out.println("Message present");
		} else {
			System.out.println("Message does not exist");
		}
		
	}
}