package com.LMS.Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Utils.ConfigReader;
import com.LMS.Utils.ExcelReader;

public class EditNewUserPage {

private static WebDriver driver = DriverFactory.getdriver();
	
	By pg_ManageUser = By.xpath("//div[1][@class='box']");
	By btn_AddNewUser=By.xpath("//button[@id='new']"); 
	By btn_Edit=By.xpath("//div[@class='action']/span/button[1]");
	By btn_Delete=By.xpath("//div[@class='action']/span/button[2]");
	By txtBx_FirstName=By.xpath("//input[@formcontrolname='userFirstName']"); 
	By txtBx_MiddleName=By.xpath("//input[@formcontrolname='userMiddleName']");
	By field_pgGraduate=By.xpath("//span[@class='mat-form-field-label-wrapper ng-tns-c78-64']/label/span"); 
	By txtBx_LastName=By.xpath("//input[@formcontrolname='userLastName']");
	By txtBx_Location=By.xpath("//input[@formcontrolname='userLocation']");
	By txtBx_PhoneNumber=By.xpath("//input[@formcontrolname='userPhoneNumber']");
	By txtBx_LinkedInUrl=By.xpath("//input[@formcontrolname='userLinkedinUrl']");
	By txtbx_EmailAddress=By.xpath("//input[@formcontrolname='userLoginEmail']");
	By txtBx_UnderGraduate=By.xpath("//input[@formcontrolname='userEduUg']");
	By txtBx_PostGraduate=By.xpath("//input[@formcontrolname='userEduPg']");
	By txtBx_TimeZone=By.xpath("//input[@formcontrolname='userTimeZone']");
	By txtBx_UserComments=By.xpath("//input[@formcontrolname='userComments']");
	By btn_Cancel=By.xpath("//button[@color='warn' and @class= 'mat-focus-indicator mat-raised-button mat-button-base mat-warn']");
	By btn_Submit=By.xpath("//button[@class='mat-focus-indicator mat-raised-button mat-button-base mat-primary']");
	By btn_CloseX=By.xpath("//button[@class='ng-tns-c132-6 p-dialog-header-icon p-dialog-header-close p-link p-ripple ng-star-inserted']");
	By pg_UserDetails=By.xpath("//div/span[@id='pr_id_5-label']");
	By field_UserRole=By.xpath("//label[@for='userRole']");
	By field_UserRoleStatus=By.xpath("//label[@for='userRoleStatus']");
	By field_UserVisaStatus=By.xpath("//label[@for='userVisaStatus']");
	By dropdn_UserRole=By.xpath("//p-dropdown[@id='roleId']");
	By dropdn_UserRoleStatus=By.xpath("//p-dropdown[@id='userRoleStatus']");
	By dropdn_UserVisaStatus=By.xpath("//p-dropdown[@id='userVisaStatus']");
	By frameUserDetails=By.xpath("//p-dialog/div/div");
	By msg_updated=By.xpath("//div[@class='p-toast-message-text ng-tns-c90-54 ng-star-inserted']/div[2]");
	By msg_successful=By.xpath("//div[@class='p-toast-message-text ng-tns-c90-99 ng-star-inserted']/div[2]");
	By msg_Failed=By.xpath("//div[@class='p-toast-message-text ng-tns-c90-54 ng-star-inserted']/div");
	By msg_alert=By.xpath("//mat-card-content[@class='mat-card-content']//mat-error[@role='alert']");
	By pg_titleHeading=By.xpath("//span[@id='pr_id_5-label']");
	String nametosearch="";
	WebDriverWait wait;
	
//----------------------------------------------------------------------------------------------------------------------------------------------	
	 //Constructor
		public EditNewUserPage(WebDriver driver) {
			this.driver=driver;
		}
	
	public String get_pageTitleName() {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String pageTitle=driver.findElement(pg_ManageUser).getText();
		return pageTitle;
	}
	
	public String get_pageEditUserDetailsTitle() {
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String pageTitle=driver.findElement(pg_UserDetails).getText();
		return pageTitle;
	}
	
	
	
	public void check_pageUserDetailsPopupDisplay() {
		try {
		boolean status=driver.findElement(pg_UserDetails).isDisplayed();
		if(status)
		{
			driver.findElement(btn_CloseX).click();
		}}
		catch(Exception e) {
			
		}
	}
	
//---------------------------------------------------------------------------------------------------------------------------------------
		
	public void EnterData_Fields(String Sheetname, Integer RowNumber) throws InterruptedException, InvalidFormatException, IOException{
			ExcelReader reader=new ExcelReader();
			String Excelpath=ConfigReader.getExcelFilePath();
			List<Map<String, String>> testdata=reader.getData(Excelpath, Sheetname);
			//String FirstName=driver.findElement(txtBx_FirstName).getText();
			String FirstName = testdata.get(RowNumber).get("FirstName");
			String MiddleName = testdata.get(RowNumber).get("MiddleName");
			String LastName = testdata.get(RowNumber).get("LastName");
			String Location = testdata.get(RowNumber).get("Location");
			String Phone_no = testdata.get(RowNumber).get("Phone_no");
			String LinkedInUrl = testdata.get(RowNumber).get("LinkedInUrl");
			String EmailAddress = testdata.get(RowNumber).get("EmailAddress");
			String UnderGraduate = testdata.get(RowNumber).get("UnderGraduate");
			String PostGraduate = testdata.get(RowNumber).get("PostGraduate");
			String TimeZone = testdata.get(RowNumber).get("TimeZone");
			String UserComments = testdata.get(RowNumber).get("UserComments");
			String UserRole=testdata.get(RowNumber).get("UserRole");
			String UserRoleStatus=testdata.get(RowNumber).get("UserRoleStatus");
			String UserVisaStatus=testdata.get(RowNumber).get("UserVisaStatus");
			nametosearch=FirstName;
			driver.findElement(txtBx_FirstName).clear();
			driver.findElement(txtBx_MiddleName).clear();
			driver.findElement(txtBx_LastName).clear();
			driver.findElement(txtBx_Location).clear();
			driver.findElement(txtBx_PhoneNumber).clear();
			driver.findElement(txtBx_LinkedInUrl).clear();
			driver.findElement(txtbx_EmailAddress).clear();
			driver.findElement(txtBx_UnderGraduate).clear();
			driver.findElement(txtBx_PostGraduate).clear();
			driver.findElement(txtBx_TimeZone).clear();
			driver.findElement(txtBx_UserComments).clear();
			
			driver.findElement(txtBx_FirstName).sendKeys(FirstName);
			driver.findElement(txtBx_MiddleName).sendKeys(MiddleName);
			driver.findElement(txtBx_LastName).sendKeys(LastName);
			driver.findElement(txtBx_Location).sendKeys(Location);
			driver.findElement(txtBx_PhoneNumber).sendKeys(Phone_no);
			driver.findElement(txtBx_LinkedInUrl).sendKeys(LinkedInUrl);
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			//selecting User role dropdown value
			driver.findElement(dropdn_UserRole).click();
			if(UserRole.equalsIgnoreCase("R01")) {
			driver.findElement(By.xpath("//ul[@role='listbox']/p-dropdownitem[1]/li")).click();
			//Thread.sleep(1000);
			}
			else if(UserRole.equalsIgnoreCase("R02")) {
				driver.findElement(By.xpath("//ul[@role='listbox']/p-dropdownitem[2]/li")).click();
				Thread.sleep(1000);
				}
			else if(UserRole.equalsIgnoreCase("R03")) {
				driver.findElement(By.xpath("//ul[@role='listbox']/p-dropdownitem[3]/li")).click();
				Thread.sleep(1000);
				}
			else
				System.out.println("User Id is Invalid");
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			//selecting User Role Status dropdown value
			driver.findElement(dropdn_UserRoleStatus).click();
			if(UserRoleStatus.equalsIgnoreCase("Active")) {
			driver.findElement(By.xpath("//ul[@role='listbox']/p-dropdownitem[1]/li")).click();
			//Thread.sleep(1000);
			}
			else if(UserRoleStatus.equalsIgnoreCase("Inactive")) {
				driver.findElement(By.xpath("//ul[@role='listbox']/p-dropdownitem[2]/li")).click();
				Thread.sleep(1000);
				}
			else
				System.out.println("User Role Status is Invalid");
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
			//Selecting User Visa Status dropdown value
			driver.findElement(dropdn_UserVisaStatus).click();
			if(UserVisaStatus.equalsIgnoreCase("Not-Specified") ){
				driver.findElement(By.xpath("//ul[@role='listbox']/p-dropdownitem[1]/li")).click();
				Thread.sleep(1000);
			}
			else if(UserVisaStatus.equalsIgnoreCase("NA") ){
				driver.findElement(By.xpath("//ul[@role='listbox']/p-dropdownitem[2]/li")).click();
				Thread.sleep(1000);
			}
			else if(UserVisaStatus.equalsIgnoreCase("GC-EAD") ){
				driver.findElement(By.xpath("//ul[@role='listbox']/p-dropdownitem[3]/li")).click();
				Thread.sleep(1000);
			}
			else if(UserVisaStatus.equalsIgnoreCase("H4-EAD") ){
				driver.findElement(By.xpath("//ul[@role='listbox']/p-dropdownitem[4]/li")).click();
				Thread.sleep(1000);
			}
			else if(UserVisaStatus.equalsIgnoreCase("H4") ){
				driver.findElement(By.xpath("//ul[@role='listbox']/p-dropdownitem[5]/li")).click();
				Thread.sleep(1000);
			}
			else if(UserVisaStatus.equalsIgnoreCase("H1B") ){
				driver.findElement(By.xpath("//ul[@role='listbox']/p-dropdownitem[6]/li")).click();
				Thread.sleep(1000);
			}
			else if(UserVisaStatus.equalsIgnoreCase("Canada-EAD") ){
				driver.findElement(By.xpath("//ul[@role='listbox']/p-dropdownitem[7]/li")).click();
				Thread.sleep(1000);
			}
			else if(UserVisaStatus.equalsIgnoreCase("Indian-Citizen") ){
				driver.findElement(By.xpath("//ul[@role='listbox']/p-dropdownitem[8]/li")).click();
				Thread.sleep(1000);
			}
			else if(UserVisaStatus.equalsIgnoreCase("US-Citizen") ){
				driver.findElement(By.xpath("//ul[@role='listbox']/p-dropdownitem[9]/li")).click();
				Thread.sleep(1000);
			}
			else if(UserVisaStatus.equalsIgnoreCase("Canada-Citizen") ){
				driver.findElement(By.xpath("//ul[@role='listbox']/p-dropdownitem[10]/li")).click();
				Thread.sleep(1000);
			}	
			else
				System.out.println("User Visa Status is Invalid");
			
			driver.findElement(txtbx_EmailAddress).sendKeys(EmailAddress);
			driver.findElement(txtBx_UnderGraduate).sendKeys(UnderGraduate);
			driver.findElement(txtBx_PostGraduate).sendKeys(PostGraduate);
			driver.findElement(txtBx_TimeZone).sendKeys(TimeZone);
			driver.findElement(txtBx_UserComments).sendKeys(UserComments);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
			//clicking submit button		
			driver.findElement(btn_Submit).click();
			Thread.sleep(500);
			
			
		}
		public void clickBtn_Submit() {
			 driver.findElement(btn_Submit).click();
		}
		
		
		public void checkmsg_successful() {
			try{
				wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			
				 //wait for the modal box be visible
			     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Successful')]")));
			      //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Failed')]")));
			}catch(Throwable e){
			    System.err.println("Error while waiting for the notification to appear: "+ e.getMessage());
			}
			
		}
		public void checkmsg_failed() {
			try{
				wait = new WebDriverWait(driver, Duration.ofSeconds(3));
				
				 //wait for the modal box be visible
			     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Failed')]")));
			}catch(Throwable e){
			    System.err.println("Error while waiting for the notification to appear: "+ e.getMessage());
			}
		}
		
		public void check_skippedDatamsg() {
			List<WebElement> alertmsg=driver.findElements(msg_alert);
			int alertmsgsize=alertmsg.size();
			boolean alert_display;
			int i=0;
			for (WebElement count : alertmsg) { 
				alert_display=count.isDisplayed();
				 if(alert_display==true ) {
					i++;
				}
			}
			System.out.println(i+" fields are showing errors..");
			
		}
	
		public String nameSearch(String Sheetname, Integer RowNumber) throws InterruptedException, InvalidFormatException, IOException{
			ExcelReader reader=new ExcelReader();
			String Excelpath=ConfigReader.getExcelFilePath();
			List<Map<String, String>> testdata=reader.getData(Excelpath, Sheetname);
			String FirstName = testdata.get(RowNumber).get("FirstName");
			
			if(!FirstName.isEmpty()) 
			return FirstName;
			else 
				return "empty";
		}
	
		public void cancel_userpopup() {
			new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='mat-focus-indicator mat-raised-button mat-button-base mat-warn']"))).click();
			driver.findElement(btn_Cancel).click();
			}
		
}