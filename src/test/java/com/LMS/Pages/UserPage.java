package com.LMS.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.LMS.DriverFactory.DriverFactory;

public class UserPage {

	static WebDriver driver = DriverFactory.getdriver();
	By txt_user= By.xpath("//input[@id='username']");
	By txt_password=By.xpath("//input[@id='password']");
	By btn_login=By.xpath("//button[@id='login']");;

	public UserPage(WebDriver driver) {
		this.driver=driver;
		}

	public void enterUsername(String username) {
		driver.findElement(txt_user).sendKeys(username);
		
	}

	public void enterPassword(String password) {
		driver.findElement(txt_password).sendKeys(password);
	}

	public void clickOnLogin() {
		driver.findElement(btn_login).click();
	}

	public String getUrlOfPage() {
		return driver.getCurrentUrl();
	}
}