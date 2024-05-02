package com.LMS.Utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
	
	WebDriver driver;
	
	
	public Helper(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentURL(WebDriver driver)  {
		return driver.getCurrentUrl();

	}
	
	public boolean isDisplayed(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed()) {				
				flag = true;
				System.out.println("The element is Displayed"+element);

			} else {
				flag = false;
				System.out.println("The element is not Displayed"+element);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return flag;
	}
	
	public void selectRadioButtonValue(WebElement element,String valueToBeSelected) {
		if(element.getText().equalsIgnoreCase(valueToBeSelected)) {
			element.click();
		}
		
	}
	public static WebElement waitForElementClickablity(WebDriver driver, WebElement element, long durationInSeconds) {

		WebElement webElement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			LoggerLoad.error("waitForElementClickablity()::The element " + element.toString()
					+ " may not be clickable. Exception is: " + e.getMessage());
		}
		return webElement;
	}
	
	public static void ScrolltoElementandClick(WebDriver driver, WebElement element, long durationInSeconds) {

		WebElement webElement = null;
		try {
			webElement = waitForElementClickablity(driver, element, durationInSeconds);
			Actions action = new Actions(driver);
			action.moveToElement(webElement).click().perform();
		} catch (Exception e) {
			LoggerLoad.error("actionScrolltoElement::The element " + element.toString()
					+ " may not scrolled to element. Exception is: " + e.getMessage());
		}

	}
		
	public void waitForElement(WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));

	}
	
}