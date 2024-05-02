package com.LMS.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Utils.ConfigReader;

public class LoginPage {
	
	public static WebDriver driver = DriverFactory.getdriver();
	By UserName = By.xpath("//input[@id='username']");
	By Password = By.xpath("//input[@id='password']");
	By Login = By.xpath("//span[@class='mat-button-wrapper']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void loginUser() {
		driver.get(ConfigReader.getHomePageUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.findElement(UserName).clear();
		driver.findElement(UserName).sendKeys("sdetorganizers@gmail.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.findElement(Password).clear();
		driver.findElement(Password).sendKeys("UIHackathon@02");
		loginclick();
		
	}

	public void loginclick() {
		driver.findElement(Login).click();
}
}
