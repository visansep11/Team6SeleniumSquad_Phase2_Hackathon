package com.LMS.Pages;

import java.time.Duration;
import java.util.logging.Level;
import java.util.Iterator;


import org.json.JSONException;
import org.json.JSONObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;




import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Utils.ConfigReader;


 public class LoginPage1 {
	
	 public static WebDriver driver = DriverFactory.getdriver();
	public String baseUrl = null;
	
	By userNameLabel = By.xpath("//span[@class='ng-tns-c78-0 ng-star-inserted']");
	By passwordLabel = By.xpath("//span[@class='ng-tns-c78-1 ng-star-inserted']");
	By requiredserastrik  =By.xpath("//span[@class='mat-placeholder-required mat-form-field-required-marker ng-tns-c78-0 ng-star-inserted']");
	By requiredPasswordastrik  =By.xpath("//span[@class='mat-placeholder-required mat-form-field-required-marker ng-tns-c78-1 ng-star-inserted']");
	
	By username=By.xpath("//input[@id='username']");
	By password=By.xpath("//input[@id='password']");
	By errorMessage=By.xpath("//*[@id='errormessage']");
	By login=By.xpath("//span[text()='Login']");
	By logo=By.xpath("//*[@src='assets/img/LMS-logo.jpg']");
	By LMS =By.xpath("//p[text()='Please login to LMS application']");
	By loginLMS=By.xpath("//p[text()='Please login to LMS application']");
	By invalidUserNameError = By.xpath("//*[@id='mat-form-field-label-1']");
	By invalidPasswordError = By.xpath("//*[@id='mat-form-field-label-3']");
	By manageProgram = By.xpath("//div[@class='box' and text() = ' Manage Program']");
	
	
	public LoginPage1(WebDriver driver) {
		this.driver = driver;
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void register() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }	
    
	public void clickLogin() {
		//Call the Login click button()
//		driver.findElement(username).sendKeys(null);
		driver.findElement(login).click();
	}
	
	public void loadLoginPage() {
		//ConfigReader.init_prop();
	    baseUrl = ConfigReader.getHomePageUrl();
	    System.out.print("BaseUrl " + baseUrl);
	    System.out.print("Driver " + driver);
		driver.get(baseUrl);
		
	}
	
	public void enterUserName(String uName) {
		driver.findElement(username).sendKeys(uName);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void loginButtonClicked() {
		driver.findElement(login).click();
	}
	
	public String getUserNameLabel() {
		return driver.findElement(userNameLabel).getText();
	}
	
	public String getPasswordLabel() {
		return driver.findElement(passwordLabel).getText();
	}
	
	public boolean isLogoDisplayed() {
		return driver.findElement(logo).isDisplayed();
	}
	
	public boolean isLMSDisplayed() {
		return driver.findElement(LMS).isDisplayed();
	}
	
	public boolean isTextFieldsVisible() {
		return (driver.findElement(username).isDisplayed() && driver.findElement(password).isDisplayed());
	}
	
	public boolean isUserLabelDisplayed() {
		return driver.findElement(userNameLabel).isDisplayed();
	}
	public boolean isPasswordLabelDisplayed() {
		return driver.findElement(passwordLabel).isDisplayed();
	}
	
	
	public boolean isLoginButtonDisplayed() {
		return driver.findElement(login).isDisplayed();
	}
	
	public String getDashboardPage() {
		return driver.getCurrentUrl();
	}
	
	public boolean isDashboadPageLoaded() {
		return driver.findElement(manageProgram).isDisplayed();
	}
	
	public boolean isUserAsterikVisible() {
		return driver.findElement(requiredserastrik).isDisplayed();
	}
	
	public boolean isPasswordAsterickVisible() {
		return driver.findElement(requiredPasswordastrik).isDisplayed();
	}
	
	public void passwordFieldEnterPressed() {
		driver.findElement(password).sendKeys(Keys.ENTER);;
	}
	
	public boolean isErrorMessageDisplayed() {
		return driver.findElement(errorMessage).isDisplayed();
	}
	
	public boolean isErrorUserNameDisplayed() {
		return driver.findElement(invalidUserNameError).isDisplayed();
	}
	
	public boolean isErroPasswordDisplayed() {
		return driver.findElement(invalidPasswordError).isDisplayed();
	}
	
	
	public String getUserFontColor() {
		return driver.findElement(userNameLabel).getCssValue("color");
	}
	
	public String getPasswordFontColor() {
		return driver.findElement(passwordLabel).getCssValue("color");
	}
 public int loadLoginPage(String url) {
		
		String returnStatus = null;
		ChromeOptions options = new ChromeOptions();
         // add whatever extensions you need
         // for example I needed one of adding proxy, and one for blocking
         // images
         // options.addExtensions(new File(file, "proxy.zip"));
         // options.addExtensions(new File("extensions",
         // "Block-image_v1.1.crx"));

         DesiredCapabilities cap = new DesiredCapabilities();
         
         cap.setCapability(ChromeOptions.CAPABILITY, options);
         
         

         // set performance logger
         // this sends Network.enable to chromedriver
         LoggingPreferences logPrefs = new LoggingPreferences();
         logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
         cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, logPrefs);

         ChromeDriver cDriver = new ChromeDriver();
         
         	
         // navigate to the page
         System.out.println("Navigate to " + url);
         driver.navigate().to(url);

         // and capture the last recorded url (it may be a redirect, or the
         // original url)
         String currentURL = driver.getCurrentUrl();

         // then ask for all the performance logs from this request
         // one of them will contain the Network.responseReceived method
         // and we shall find the "last recorded url" response
         LogEntries logs = driver.manage().logs().get("performance");

         int status = -1;

         System.out.println("\nList of log entries:\n");

         for (Iterator<LogEntry> it = logs.iterator(); it.hasNext();)
         {
             LogEntry entry = it.next();

             try
             {
                 JSONObject json = new JSONObject(entry.getMessage());

                 System.out.println(json.toString());

                 JSONObject message = json.getJSONObject("message");
                 String method = message.getString("method");

                 if (method != null
                         && "Network.responseReceived".equals(method))
                 {
                     JSONObject params = message.getJSONObject("params");

                     JSONObject response = params.getJSONObject("response");
                     String messageUrl = response.getString("url");

                     if (currentURL.equals(messageUrl))
                     {
                         status = response.getInt("status");

                         System.out.println(
                                 "---------- bingo !!!!!!!!!!!!!! returned response for "
                                         + messageUrl + ": " + status);

                         System.out.println(
                                 "---------- bingo !!!!!!!!!!!!!! headers: "
                                         + response.get("headers"));
                     }
                 }
             } catch (JSONException e)
             {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
                 status = 404;
             }
      finally
     {
         if (driver != null)
         {
             driver.quit();
         }
     }
   }
      return status;   
  }
}
	
	
 
	
	
		
	 


