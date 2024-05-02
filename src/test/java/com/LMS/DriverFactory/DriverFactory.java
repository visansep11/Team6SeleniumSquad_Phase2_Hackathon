 package com.LMS.DriverFactory;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.LMS.Utils.ConfigReader;


public class DriverFactory {

		public static WebDriver driver;
		public WebDriverWait wait;

		public WebDriver init_driver(String browser) {
						
			System.out.println("browser value is: " + browser);

			if (browser.equals("chrome")) {
				System.out.println("Testing on chrome browser");
				driver = new ChromeDriver();
				
			} else if (browser.equals("firefox")) {
				System.out.println("Testing on firefox browser");
				driver = new FirefoxDriver();
				
			} else if (browser.equals("safari")) {
				System.out.println("Testing on safari browser");
				driver = new SafariDriver();
				
			}
				
			else if (browser.equals("edge")) {
				System.out.println("Testing on edge browser");
				driver = new EdgeDriver();
					
				}
					else {
				System.out.println("Please pass the correct browser value: " + browser);
			}
			// Set Page load timeout
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
			driver.manage().deleteAllCookies();
			//driver.get(ConfigReader.getHomePageUrl());
			driver.manage().window().maximize();
			return driver;

		}

		public static WebDriver getdriver() {
			return driver;
		}

		public void closeallDriver() {
			driver.close();
		}
	}