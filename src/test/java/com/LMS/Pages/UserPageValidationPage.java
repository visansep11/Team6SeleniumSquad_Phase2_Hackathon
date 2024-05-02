package com.LMS.Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Utils.ConfigReader;

public class UserPageValidationPage {
	 static WebDriver driver = DriverFactory.getdriver();
	By pg_titleName= By.xpath("//div[1][@class='box']");
	By btnMenu_User=By.xpath("//button[@id='user']");
	By icon_pagination=By.xpath("//p-paginator");
	By msg_pagination=By.xpath("//p-paginator/div/span[1]");
	By data_table=By.xpath("//p-table/div/div/table");
	By dataTable_ID=By.xpath("//p-table/div/div/table/thead/tr/th[@psortablecolumn='userId']");
	By dataTable_Name=By.xpath("//p-table/div/div/table/thead/tr/th[@psortablecolumn='userFirstName']");
	By dataTable_Location=By.xpath("//p-table/div/div/table/thead/tr/th[@psortablecolumn='userLocation']");
	By dataTable_PhoneNumber=By.xpath("//p-table/div/div/table/thead/tr/th[@psortablecolumn='userPhoneNumber']");
	By dataTable_EditDelete=By.xpath("//p-table/div/div/table/thead/tr/th[6]");
	By btn_defaultDeleteOnLeft= By.xpath("//div[2][@class='box']/div/button[@icon='pi pi-trash'and @disabled]");
	By btn_AddNewUser= By.xpath("//div[2][@class='box']/div/button[@id='new']");
	By btn_AssignStaff= By.xpath("//div[2][@class='box']/div/button[@label='Assign Student']");
	By btn_AssignStudent= By.xpath("//div[2][@class='box']/div/button[@label='Assign Staff']");
	By searchBox=By.xpath("//input[@id='filterGlobal']");
	By msg_numberOfRecords=By.xpath("//div[@class='p-datatable-footer ng-star-inserted']/div");
	By checkboxes_dataTable=By.xpath("//div[@role='checkbox']");
	By icons_edit=By.xpath("//button[@icon='pi pi-pencil']");
	By icons_delete=By.xpath("//button[@class='p-button-rounded p-button-danger p-button p-component p-button-icon-only']");
	By enteredNameDisplayed_inDataTable=By.xpath("//tbody/tr/td[3]");
	String dataValue;
	By dynamic_UserId=By.xpath("//tbody//tr//td[2]");
	By dynamic_UserName=By.xpath("//tbody//tr//td[3]");
	By dynamic_UserLocation=By.xpath("//tbody//tr//td[4]");
	By dynamic_UserPhoneNo=By.xpath("//tbody//tr//td[5]");
	//Delete All
	By deleteAllBatchBtn= By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']") ;	 
	By deleteYes= By.xpath("//button[@class='ng-tns-c133-711 p-confirm-dialog-accept p-ripple p-button p-component ng-star-inserted']"); 	 
	By deleteNo= By.xpath("//button[@class='ng-tns-c133-711 p-confirm-dialog-reject p-ripple p-button p-component ng-star-inserted']");
	By deleteMessage= By.xpath("//div[@class='p-dialog-content ng-tns-c133-711']/span"); 

	By DelSuccessMessage= By.xpath("//*[contains(text(),'Success')]"); 

	By closeArrow= By.xpath("//button[@class='ng-tns-c133-711 p-dialog-header-icon p-dialog-header-close p-link ng-star-inserted']");

	By deleteIconRow= By.xpath("");
	 
	By confirmDialog= By.xpath("//div[@class='p-dialog-header ng-tns-c133-711 ng-star-inserted']/span");
	WebDriverWait wait;
	
	
	
	public UserPageValidationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String get_pageTitleName() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String pageTitle=driver.findElement(pg_titleName).getText();
		return pageTitle;
	}
	
	public void click_UserBtn() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(btnMenu_User).click();
	}
	
	public String get_CurrentPgUrl() {
		return driver.getCurrentUrl();
	}
	
	public String get_msgPagination() {
		return driver.findElement(msg_pagination).getText();
	}

	public boolean check_paginationIcon() {
		boolean pagination_iconStatus=driver.findElement(icon_pagination).isDisplayed();
		return pagination_iconStatus;
	}
	
	public boolean check_dataTableAllCoumns() {
		if(driver.findElement(data_table).isDisplayed()) {
			return true;
		}
		else
			return false;
	}
	

	public boolean getDataTable_ID() {
		return driver.findElement(dataTable_ID).isDisplayed();
	}

	public boolean getDataTable_Name() {
		return driver.findElement(dataTable_Name).isDisplayed();
	}

	public boolean getDataTable_Location() {
		return driver.findElement(dataTable_Location).isDisplayed();
	}

	public boolean getDataTable_PhoneNumber() {
		return driver.findElement(dataTable_PhoneNumber).isDisplayed();
	}

	public boolean getDataTable_EditDelete() {
		return driver.findElement(dataTable_EditDelete).isDisplayed();
	}

	public boolean Check_DefaultDelete_btn() {
		boolean btn_display=driver.findElement(btn_defaultDeleteOnLeft).isDisplayed();
		boolean btn_disable=driver.findElement(btn_defaultDeleteOnLeft).isEnabled();
		if(btn_disable==false && btn_display==true) {
			return true;
		}
		else
			return false;
	}

	public boolean check_AddNewUser_btn() {
		return driver.findElement(btn_AddNewUser).isDisplayed();
	}

	public boolean check_AssignStaff_btn() {
		return driver.findElement(btn_AssignStaff).isDisplayed();
	}
	
	public boolean check_AssignStudent_btn() {
		return driver.findElement(btn_AssignStudent).isDisplayed();
	}

	public boolean check_SearchBox() {
		return driver.findElement(searchBox).isDisplayed();
	}

	public int check_NumberOfRecords() {
		List<WebElement> rows= driver.findElements(By.xpath("//p-table/div/div/table/tbody/tr"));
		int rowCount = rows.size();
		int i=0;
		boolean status;
		System.out.println("No of rows in this table : " + rowCount);
		for (WebElement row : rows) { 
			 status=row.isDisplayed();
			if(status==true) {
				i++;
			}
		}
		if(rowCount==i) {
			System.out.println("All records are displayed.");
		}
		return rowCount;
	}
	
	public void select_checkbox() {
		driver.findElement(checkboxes_dataTable).click();
	}
	
	public boolean check_commonDeleteBtnStatus() {
		return driver.findElement(btn_defaultDeleteOnLeft).isEnabled();
	}
	
	public int check_Checkboxes() {
		List<WebElement> Totalcheckboxes= driver.findElements(checkboxes_dataTable);
		int TotalcheckboxesCount = Totalcheckboxes.size();
		int i=0;
		boolean status;
		for (WebElement count : Totalcheckboxes) { 
			 status=count.isDisplayed();
			if(status==true) {
				i++;
			}
		}
		if(TotalcheckboxesCount==i) {
			System.out.println("All checkboxes are displayed.");
		}
		return TotalcheckboxesCount;
	}
	
	public int check_EditIcons() {
		List<WebElement> editIcons= driver.findElements(icons_edit);
		int editIconsCount = editIcons.size();
		int i=0;
		boolean status_display;
		boolean status_enable;
		for (WebElement count : editIcons) { 
			 status_display=count.isDisplayed();
			 status_enable=count.isEnabled();
			if(status_display==true && status_enable==true) {
				i++;
			}
		}
		if(editIconsCount==i) {
			System.out.println("All Edit icons are displayed and enabled.");
		}
		return editIconsCount;
	}
	
	public int check_DeleteIcons() {
		List<WebElement> deleteIcons= driver.findElements(icons_delete);
		int deleteIconsCount = deleteIcons.size();
		int i=0;
		boolean status_display;
		boolean status_enable;
		for (WebElement count : deleteIcons) { 
			 status_display=count.isDisplayed();
			 status_enable=count.isEnabled();
			if(status_display==true && status_enable==true) {
				i++;
			}
		}
		if(deleteIconsCount==i) {
			System.out.println("All Delete icons are displayed and enabled.");
		}
		return deleteIconsCount;
	}
	
	public void search_userInDataTable(String value) {
		driver.findElement(searchBox).clear();
		driver.findElement(searchBox).sendKeys(value);
	}

	public String search_validUser() {
		dataValue="John";
//		driver.findElement(searchBox).clear();
//		driver.findElement(searchBox).sendKeys(dataValue);
		return dataValue;
	}

	public String search_InvalidUser() {
		dataValue="fdfhgfjg";
//		driver.findElement(searchBox).clear();
//		driver.findElement(searchBox).sendKeys(dataValue);
		//driver.findElement(btn_AddNewUser).click();
		return dataValue;
	}

	
	public int check_searchedUserInDataTable(String value) {
		
		driver.findElement(searchBox).clear();
		int rowCount=0;
		int i=0;
		String name;
		if(!value.isEmpty()) {
			driver.findElement(searchBox).sendKeys(value);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		List<WebElement> rows= driver.findElements(By.xpath("//p-table/div/div/table/tbody/tr"));
		rowCount = rows.size();
		System.out.println("No of Records displayed are : " + rowCount);
		for (WebElement row : rows) { 
			 name=row.getText();
			if(name.contains(dataValue)) {
				System.out.println("Records are: "+ name);
				i++;
			}
	
		}}
//		if(rowCount==i) {
//			System.out.println("All records are displayed.");
//		}
		return rowCount;
	}
	
	public void clear_serachedText() {
		driver.findElement(searchBox).clear();
	}
	
	public void click_editIcon() {
		driver.findElement(icons_edit).isDisplayed();
		driver.findElement(icons_edit).click();
	}
	
	public void find_user(String value) {
		//List<WebElement> rows=driver.findElements(By.xpath("//tbody/tr[@class='ng-star-inserted']/td[3]"));
		driver.findElement(searchBox).clear();
		int rowCount=0;
		
		if(!value.isEmpty()) {
			driver.findElement(searchBox).sendKeys(value);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		List<WebElement> rows= driver.findElements(By.xpath("//p-table/div/div/table/tbody/tr"));
		rowCount = rows.size();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("No of Records displayed are : " + rowCount);
		

	  for (int i=0;i<rowCount;i++) {
			  
		  String userdetails=driver.findElement(By.xpath("//table/tbody/tr["+(i+1)+"]/td[3]")).getText();
			  System.out.println("Records: "+userdetails );
		    if (userdetails.contains(value)){
		    	System.out.println("Record details are: "+userdetails);
		    // System.out.println(i+"  :   "+j);
		     break;
		     
		    }
		   
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	}
//-------------------------------------------------------------------------------------------------------------------------------
	//Before sorting of the User Ids and click on ID btn
	public void click_userIdSortBtn() {
		List<WebElement> userIds=driver.findElements(dynamic_UserId);
		String[] beforesort=new String[userIds.size()];
		System.out.println("Before Sort Value of User Id is : ");
		for(int i=0;i<userIds.size();i++) {
			beforesort[i]=userIds.get(i).getText().trim();
			System.out.println("					"+beforesort[i]);
		}
		for(int i=0;i<userIds.size();i++) {
			Arrays.sort(beforesort);
		}
		driver.findElement(dataTable_ID).click();
	}
	
	
	//Sorting User Ids Ascending
	public void sortByUserIdAscending() {
		List<WebElement> userIds=driver.findElements(dynamic_UserId);
		String[] aftersort=new String[userIds.size()];
		System.out.println("After ascending Sort Value of User Id is : ");
		for(int i=0;i<userIds.size();i++) {
			aftersort[i]=userIds.get(i).getText().trim();
			System.out.println("					"+aftersort[i]);
		}	
	}
//	//Sorting User Ids Descending
	public void sortByUserIdDescending() {
		driver.findElement(dataTable_ID).click();
		List<WebElement> userIds=driver.findElements(dynamic_UserId);
		String[] aftersort=new String[userIds.size()];
		System.out.println("After decending Sort Value of User Id is : ");
		for(int i=0;i<userIds.size();i++) {
			aftersort[i]=userIds.get(i).getText().trim();
			System.out.println("					"+aftersort[i]);
		}

	}

//-------------------------------------------------------------------------------------------------------------------------------------------

	//Before sorting of the User Names and click on ID btn
		public void click_userNameSortBtn() {
			List<WebElement> userNames=driver.findElements(dynamic_UserName);
			String[] beforesort=new String[userNames.size()];
			System.out.println("Before Sort Value of User Name is : ");
			for(int i=0;i<userNames.size();i++) {
				beforesort[i]=userNames.get(i).getText().trim();
				System.out.println("					"+beforesort[i]);
			}
			for(int i=0;i<userNames.size();i++) {
				Arrays.sort(beforesort);
			}
			driver.findElement(dataTable_Name).click();
		}
		
		
		//Sorting User Names Ascending
		public void sortByUserNameAscending() {
			List<WebElement> userNames=driver.findElements(dynamic_UserName);
			String[] aftersort=new String[userNames.size()];
			System.out.println("After ascending Sort Value of User Name is : ");
			for(int i=0;i<userNames.size();i++) {
				aftersort[i]=userNames.get(i).getText().trim();
				System.out.println("					"+aftersort[i]);
			}	
		}
//		//Sorting User Names Descending
		public void sortByUserNameDescending() {
			driver.findElement(dataTable_Name).click();
			List<WebElement> userNames=driver.findElements(dynamic_UserName);
			String[] aftersort=new String[userNames.size()];
			System.out.println("After decending Sort Value of User Name is : ");
			for(int i=0;i<userNames.size();i++) {
				aftersort[i]=userNames.get(i).getText().trim();
				System.out.println("					"+aftersort[i]);
			}

		}

//-------------------------------------------------------------------------------------------------------------------------------
		//Before sorting of the User Locations and click on ID btn
		public void click_userLocationSortBtn() {
			List<WebElement> userLocations=driver.findElements(dynamic_UserLocation);
			String[] beforesort=new String[userLocations.size()];
			System.out.println("Before Sort Value of User Location is : ");
			for(int i=0;i<userLocations.size();i++) {
				beforesort[i]=userLocations.get(i).getText().trim();
				System.out.println("					"+beforesort[i]);
			}
			for(int i=0;i<userLocations.size();i++) {
				Arrays.sort(beforesort);
			}
			driver.findElement(dataTable_Location).click();
		}
		
		
		//Sorting User Ids Ascending
		public void sortByUserLocationAscending() {
			List<WebElement> userLocations=driver.findElements(dynamic_UserLocation);
			String[] aftersort=new String[userLocations.size()];
			System.out.println("After ascending Sort Value of User Location is : ");
			for(int i=0;i<userLocations.size();i++) {
				aftersort[i]=userLocations.get(i).getText().trim();
				System.out.println("					"+aftersort[i]);
			}	
		}
//		//Sorting User Ids Descending
		public void sortByUserLocationDescending() {
			driver.findElement(dataTable_Location).click();
			List<WebElement> userLocations=driver.findElements(dynamic_UserLocation);
			String[] aftersort=new String[userLocations.size()];
			System.out.println("After decending Sort Value of User Location is : ");
			for(int i=0;i<userLocations.size();i++) {
				aftersort[i]=userLocations.get(i).getText().trim();
				System.out.println("					"+aftersort[i]);
			}

		}

//-------------------------------------------------------------------------------------------------------------------------------
		//Before sorting of the User Phone No and click on Phone no btn
				public void click_userPhoneNoSortBtn() {
					List<WebElement> userPhoneNos=driver.findElements(dynamic_UserPhoneNo);
					String[] beforesort=new String[userPhoneNos.size()];
					System.out.println("Before Sort Value of User Phone number is : ");
					for(int i=0;i<userPhoneNos.size();i++) {
						beforesort[i]=userPhoneNos.get(i).getText().trim();
						System.out.println("					"+beforesort[i]);
					}
					for(int i=0;i<userPhoneNos.size();i++) {
						Arrays.sort(beforesort);
					}
					driver.findElement(dataTable_PhoneNumber).click();
				}
				
				
				//Sorting User Phone no Ascending
				public void sortByUserPhoneNoAscending() {
					List<WebElement> userPhoneNos=driver.findElements(dynamic_UserPhoneNo);
					String[] aftersort=new String[userPhoneNos.size()];
					System.out.println("After ascending Sort Value of User Phone number is : ");
					for(int i=0;i<userPhoneNos.size();i++) {
						aftersort[i]=userPhoneNos.get(i).getText().trim();
						System.out.println("					"+aftersort[i]);
					}	
				}
//				//Sorting User Phone no Descending
				public void sortByUserPhoneNoDescending() {
					driver.findElement(dataTable_PhoneNumber).click();
					List<WebElement> userPhoneNos=driver.findElements(dynamic_UserPhoneNo);
					String[] aftersort=new String[userPhoneNos.size()];
					System.out.println("After decending Sort Value of User Phone number is : ");
					for(int i=0;i<userPhoneNos.size();i++) {
						aftersort[i]=userPhoneNos.get(i).getText().trim();
						System.out.println("					"+aftersort[i]);
					}

				}
//----------------------------------------------------------------------------------------------------------------------------------------------
				
				public void clickRowDeleteBtn() {
					if(driver.findElement(icons_delete).isDisplayed())
					driver.findElement(icons_delete).click();
					else
						System.out.println("User is not exist.");
				}

				public boolean validateDeletePopup() {
					if(driver.findElement(confirmDialog).isDisplayed() && 
					driver.findElement(deleteYes).isDisplayed() &&
					driver.findElement(deleteNo).isDisplayed())
					{
						return true;
					}
					else 
						return false;
				
				}

				public boolean deleteInRowEnabled() {
					boolean status=driver.findElement(deleteIconRow).isDisplayed();
					return status;
				}
				
				public String get_ConfirmDialogTitle() {
					return driver.switchTo().alert().getText();
				}

				public void click_deleteYes() {
					driver.switchTo().alert().accept();
				}
				public void click_deleteNo() {
					driver.switchTo().alert().dismiss();
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
				
				public void Click_closeBtn() {
					if(driver.findElement(closeArrow).isDisplayed())
					driver.findElement(closeArrow).click();
					else
					System.out.println("Close Button is not displayed.");
				}
				
				public void handle_alert() {
					driver.switchTo().alert();
				}
}
