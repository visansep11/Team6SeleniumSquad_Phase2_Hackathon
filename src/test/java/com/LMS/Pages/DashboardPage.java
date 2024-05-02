package com.LMS.Pages;

import java.net.HttpURLConnection;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.LMS.Utils.ConfigReader;

public class DashboardPage {

	WebDriver driver;
	static String url  = ConfigReader.getHomePageUrl();

	public DashboardPage(WebDriver driver) {

		this.driver = driver;

	}

	By userTextBox     = By.id("username");
	By passwordTextBox = By.id("password");
	By loginButton     = By.id("login");
	By headerText      = By.xpath("//div[text()=' Manage Program']");
	By titleText       = By.xpath("//span[text()=' LMS - Learning Management System ']");
	By programButton   = By.id("program");
	By batchButton	   = By.id("batch");
	By userButton      = By.id("user");
	By logoutButton    = By.id("logout");


	public void getUrl() {

		driver.get(url);

	}

	public void enterUsername() {

		driver.findElement(userTextBox).sendKeys("sdetorganizers@gmail.com");

	}

	public void enterPassword() {

		driver.findElement(passwordTextBox).sendKeys("UIHackathon@02");

	}

	public void clickLogin() {

		driver.findElement(loginButton).click();

	}

	public String dashboardPageTitle() {

		return driver.getTitle();

	}

	public String verifyHeaderText() {

		return driver.findElement(headerText).getText();

	}

	public long getResponseTime() {

		// Measure response time
		long startTime = System.currentTimeMillis();

		// Wait for the next page to load 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlContains("herokuapp.com"));

		long endTime = System.currentTimeMillis();
		long responseTime = endTime - startTime;

		System.out.println("Response time (milliseconds): " + responseTime);
		return responseTime;
	}

	public void verifyLink() {
		try {
			@SuppressWarnings("deprecation")
			URL link = new URL(url);
			HttpURLConnection httpURLConnect = (HttpURLConnection) link.openConnection();
			httpURLConnect.setConnectTimeout(1000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() >= 400) {
				System.out.println(url + " - " + httpURLConnect.getResponseMessage() + " is a broken link");
			} else {
				System.out.println(url + " - " + httpURLConnect.getResponseMessage());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String verifyTitleText() {

		return driver.findElement(titleText).getText();

	}

	public void verifyTitleLeftAlignment() {

		Point lmsTitle = driver.findElement(By.xpath("//span[text()=' LMS - Learning Management System ']")).getLocation();

		int titleX = lmsTitle.getX();
		System.out.println(titleX);
		int titleY = lmsTitle.getY();
		System.out.println(titleY);
		Assert.assertTrue(titleX <= 16 && titleY <= 16,
				"LMS title is on the top-left corner of the page");

	}

	public void verifyNavigationBarText() {

		String[] navigationBarIds = {"program", "batch", "user", "logout"};

		// Define expected navigation bar text
		String[] expectedTexts = {"Program", "Batch", "User", "Logout"};

		// Verify the text of each navigation bar item
		for (int i = 0; i < navigationBarIds.length; i++) {
			WebElement navigationBarItem = driver.findElement(By.id(navigationBarIds[i]));
			String actualText = navigationBarItem.getText().trim();
			System.out.println(actualText);
			Assert.assertEquals(expectedTexts[i], actualText);
		}
	}

	public String verifyLMSTitle() {

		return driver.findElement(titleText).getText();

	}



	public void verifyNavigationBarTextAndAlignment() {
		String[] navigationBarIds = {"program", "batch", "user", "logout"};


		for (int i = 0; i < navigationBarIds.length; i++) {
			WebElement navigationBarItem = driver.findElement(By.id(navigationBarIds[i]));


			int itemX = navigationBarItem.getLocation().getX();
			System.out.println(itemX);
			Assert.assertTrue( itemX > 0,"Navigation bar item is aligned to the right side");
		}
	}

	public void verifyProgramPosition() {

		Point locationProgram = driver.findElement(programButton).getLocation();
		int xProgram = locationProgram.getX();


		Point locationBatch = driver.findElement(batchButton).getLocation();
		int xBatch = locationBatch.getX();


		Point locationUser = driver.findElement(userButton).getLocation();
		int xUser = locationUser.getX();


		Point locationLogout = driver.findElement(logoutButton).getLocation();
		int xLogout = locationLogout.getX();


		if (xProgram < xBatch && xProgram < xUser && xProgram < xLogout) {
			System.out.println("The Program is in the first position");
		} else {
			System.out.println("The Program is not in the first position");
		}
	}

	public void verifyBatchPosition() {

		Point locationProgram = driver.findElement(programButton).getLocation();
		int xProgram = locationProgram.getX();


		Point locationBatch = driver.findElement(batchButton).getLocation();
		int xBatch = locationBatch.getX();


		Point locationUser = driver.findElement(userButton).getLocation();
		int xUser = locationUser.getX();


		Point locationLogout = driver.findElement(logoutButton).getLocation();
		int xLogout = locationLogout.getX();


		if (xProgram < xBatch && xBatch < xUser && xBatch < xLogout) {
			System.out.println("The Batch is in the second position");
		} else {
			System.out.println("The Batch is not in the second position");
		}
	}

	public void verifyUserPosition() {

		Point locationProgram = driver.findElement(programButton).getLocation();
		int xProgram = locationProgram.getX();


		Point locationBatch = driver.findElement(batchButton).getLocation();
		int xBatch = locationBatch.getX();


		Point locationUser = driver.findElement(userButton).getLocation();
		int xUser = locationUser.getX();


		Point locationLogout = driver.findElement(logoutButton).getLocation();
		int xLogout = locationLogout.getX();


		if (xProgram < xBatch && xBatch < xUser && xUser < xLogout) {
			System.out.println("The User is in the third position");
		} else {
			System.out.println("The User is not in the third position");
		}
	}
	public void verifyLogoutPosition() {

		Point locationProgram = driver.findElement(programButton).getLocation();
		int xProgram = locationProgram.getX();


		Point locationBatch = driver.findElement(batchButton).getLocation();
		int xBatch = locationBatch.getX();


		Point locationUser = driver.findElement(userButton).getLocation();
		int xUser = locationUser.getX();


		Point locationLogout = driver.findElement(logoutButton).getLocation();
		int xLogout = locationLogout.getX();
		int yLogout = locationLogout.getY(); 
		System.out.println(xLogout);
		System.out.println(yLogout);

		if (xProgram < xBatch && xBatch < xUser && xUser < xLogout) {
			System.out.println("The Logout is in the fourth position");
		} else {
			System.out.println("The Logout is not in the fourth position");
		}
	}



	public void clickLogout() {

		driver.findElement(logoutButton).click();

	}

	public String getActualUrl() {

		return driver.getCurrentUrl();

	}



}
