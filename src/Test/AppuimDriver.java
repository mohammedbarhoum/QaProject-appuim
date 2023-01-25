package Test;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AppuimDriver {

	@Test
	public void myfirstTest() throws MalformedURLException {

		DesiredCapabilities caps = new DesiredCapabilities();
		SoftAssert MyAssert = new SoftAssert();
		caps.setCapability("platformName", "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Mohammed");
		
		caps.setCapability("chromedriverExecutable", "D:\\Downloads\\chromedriver.exe");


		File app = new File("src/Test/calculator.apk");

		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

		//driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();

	//	driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();

	//	driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();

		String result = driver.findElement(By.id("com.google.android.calculator:id/result_preview")).getText();
		System.out.print(result);

		List<WebElement> myList = driver.findElements(By.className("android.widget.ImageButton"));
		for (int i = 0; i < myList.size(); i++) {

			// System.out.print(myList.get(i).getAttribute("resource-id"));

			if (myList.get(i).getAttribute("resource-id").contains("digit")) {

				myList.get(i).click();
			}

		}

		WebElement myResult = driver.findElement(By.id("com.google.android.calculator:id/result_preview"));
		String MyStringResult = myResult.getText();
		System.out.print(MyStringResult);

		assertEquals(MyStringResult, " 7894561230");
		MyAssert.assertAll();

	}
}
