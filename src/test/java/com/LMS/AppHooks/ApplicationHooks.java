package com.LMS.AppHooks;
import java.io.ByteArrayInputStream;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Utils.ConfigReader;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

public class ApplicationHooks {

	private static DriverFactory driverFactory;
	private static WebDriver driver;
	private static ConfigReader configReader;
	static Properties prop;
	
	@BeforeAll
	public static void setup() {
		// To get browser value from config.properties
		configReader = new ConfigReader();
                prop = configReader.init_prop();
		String browser = ConfigReader.getBrowser();

		// Driver is initialized from Driver Factory
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browser);
	}
	
	@AfterStep
	public static void take_screenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
			Allure.addAttachment("Myscreenshot",
					new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
		}
	}


	@AfterAll
	public static void tearDown() {
		System.out.println("Closing Driver");
		driverFactory.closeallDriver();
	}
}