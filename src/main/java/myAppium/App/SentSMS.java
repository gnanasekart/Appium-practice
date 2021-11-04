package myAppium.App;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SentSMS {
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("deviceName", "sekar");
		dc.setCapability("appPackage", "com.android.mms");
		dc.setCapability("appActivity", "com.android.mms.ui.MmsTabActivity");
		dc.setCapability("noReset", true);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), dc);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByXPath("//android.widget.ImageView[@content-desc=\"Compose\"]").click();
		driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Recipient: \"]").sendKeys("9790375500");
		driver.findElementById("com.android.mms:id/confirm_recipient").click();
		driver.findElementById("com.android.mms:id/embedded_text_editor").sendKeys("Hi");
		driver.findElementById("com.android.mms:id/send_button").click();
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