package com.LMS.Pages;

import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Utils.ConfigReader;
import com.LMS.Utils.ExcelReader;
import io.cucumber.messages.types.Duration;

public class ProgramAddPage {
	
	
	
	public static WebDriver driver = DriverFactory.getdriver();
	String URL = ConfigReader.getDashboardPageUrl();
	//String Excelpath=ConfigReader.getExcelFilePath();
	//private final static String Excelpath="./src/test/resources/config/config.properties";
	
	public ProgramAddPage(WebDriver driver) {
		this.driver = driver;
	}
 
	public WebDriver wait;
	
	By Program = By.xpath("//span[normalize-space()='Program']");
	By ANewProgram = By.xpath("//body");
	By ProgramDetails = By.xpath("//body");
	By ProgramName = By.xpath("//input[@id='programName']");
	By ProgramDescription = By.xpath("//input[@id='programDescription']");
	By Active =By.xpath("//div[contains(text(),'Active')]//div[2]");
	By Inactive = By.xpath("//div[@class='p-radiobutton-box p-highlight']");
	By Save = By.xpath("//button[@id='saveProgram']");
	By Error1 = By.xpath("//small[@class='p-invalid ng-star-inserted']");
	By Error2 = By.xpath("//small[normalize-space()='Description is required.']");
	By Error3 = By.xpath("//small[@class='p-invalid ng-star-inserted']");
	By CloseCross = By.xpath("//button[@class='ng-tns-c132-3 p-dialog-header-icon p-dialog-header-close p-link p-ripple ng-star-inserted']");
	By Edit = By.xpath("//tbody/tr[1]/td[5]/div[1]/span[1]/button[1]/span[1]");
	By Edit2 = By.xpath("//tbody/tr[2]/td[5]/div[1]/span[1]/button[1]");
	By Edit3 = By.xpath("//body[1]/app-root[1]/app-program[1]/div[1]/mat-card[1]/mat-card-content[1]/p-table[1]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[5]/div[1]/span[1]/button[1]/span[1]");
	By EditCloseCross = By.xpath("//button[@class='ng-tns-c132-8 p-dialog-header-icon p-dialog-header-close p-link p-ripple ng-star-inserted']");
	By DeleteIcon1 = By.xpath("//tbody/tr[1]/td[5]/div[1]/span[1]/button[2]/span[1]");
	By DeleteIcon2 = By.xpath("//tbody/tr[2]/td[5]/div[1]/span[1]/button[2]");
	By DeleteIcon3 = By.xpath("//body[1]/app-root[1]/app-program[1]/div[1]/mat-card[1]/mat-card-content[1]/p-table[1]/div[1]/div[1]/table[1]/tbody[1]/tr[3]/td[5]/div[1]/span[1]/button[2]/span[1]");
	By InvalidPNError = By.xpath("//small[contains(text(),'This field should start with an alphabet, no speci')]");
	By InvalidPDError = By.xpath("//small[contains(text(),'This field should start with an alphabet and min 2')]");
	By Search = By.xpath("//input[@id='filterGlobal']");
    By NoButton = By.xpath("//div[@class='p-dialog-footer ng-tns-c133-4 ng-star-inserted']");
	By Checkbox1 = By.xpath("//span[@class='p-checkbox-icon pi pi-check']");
	By Checkbox2 = By.xpath("//div[@class='p-checkbox-box p-component p-highlight']");
	By CommonDeleteOption = By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']//span[@class='p-button-icon pi pi-trash']");
	By YesButton = By.xpath("//button[@class='ng-tns-c133-4 p-confirm-dialog-accept p-ripple p-button p-component ng-star-inserted']");
	
	public void admin_clicks_program_tab() throws InterruptedException
	{
		driver.findElement(Program).click();
		Thread.sleep(2000);
	}
	
	public void click_NO_button() throws InterruptedException
	{
		driver.findElement(NoButton).click();
		Thread.sleep(2000);
	}
	
	public void click_YES_button() throws InterruptedException
	{
		driver.findElement(YesButton);
		Thread.sleep(2000);
	}
	
	
	public void click_check_box1 () 
	{    
		driver.findElement(Checkbox1).click();
		
	}
	
	public void click_check_box2 () 
	{    
		driver.findElement(Checkbox2).click();
		
	}
	
	public void comman_delete_icon () 
	{    
		driver.findElement(CommonDeleteOption).click();
		
	}
	public void add_new_program()
	{
		driver.findElement(ANewProgram).click();
	}
	
	public void search_new_program() {
		
    	driver.findElement(Search).click();
				
	}
	public void enter_program_name()
	{
		driver.findElement(ProgramName).click();
	}
	
	public void enter_program_description()
	{
		driver.findElement(ProgramDescription).click();
	}

	public void admin_see_program_details()
	{
		driver.findElement(ProgramDetails).click();
	}
	
	public void clicks_newprogram_popup()
	{
		driver.findElement(ANewProgram).click();
	}
	
	public void clicks_save_button()
	{
		driver.findElement(Save).click();
	}
	
	public void add_new_prog(String programName,String programDescription) throws InterruptedException {
		
		driver.findElement(ProgramName).clear();
		driver.findElement(ProgramName).sendKeys(programName);
		driver.findElement(ProgramDescription).clear();
		driver.findElement(ProgramDescription).sendKeys(programDescription);
		select_active_status();
		clicks_save_button();
	}
	
	public String get_error1_message()
	{
		//String expectederror1message = "Program name is required.";
		String programdetailserror1 = driver.findElement(Error1).getText();
		System.out.println("You are getting program name error message :"+programdetailserror1);
		Assert.assertEquals(programdetailserror1,"Program name is required.");
		return programdetailserror1;
		
	}
	
	public String invalid_prog_name_description()
	{
		
		String inpgnerror = driver.findElement(InvalidPNError).getText();
		System.out.println("You are getting program name error message :"+inpgnerror);
		Assert.assertEquals(inpgnerror, "This field should start with an alphabet, no special char and min 2 char.");
		
		String inpgnerror1 = driver.findElement(InvalidPDError).getText();
		System.out.println("You are getting program descrption error message :"+inpgnerror1);
		Assert.assertEquals(inpgnerror1, "This field should start with an alphabet and min 2 char.");
		return inpgnerror;
	}
	

	
	
	public String get_error2_message()
	{
		
		String programdetailserror2 = driver.findElement(Error2).getText();
		System.out.println("You are getting program name error message :"+programdetailserror2);
		Assert.assertEquals(programdetailserror2, "Description is required.");
		return programdetailserror2;
		
		
		
	}
	
	
	
	public void update_program_details_failed_alert() {
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
			
			 //wait for the modal box be visible
		     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Failed')]")));
		}catch(Throwable e){
		    System.err.println("Error while waiting for the notification to appear: "+ e.getMessage());
		}
	}
	 

	public void update_program_success_alert() {
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
			
			 //wait for the modal box be visible
		     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Success')]")));
		}catch(Throwable e){
		    System.err.println("Error while waiting for the notification to appear: "+ e.getMessage());
		}
	}
//	public void confirm_deletion_alert {
//		try{
//			
//			WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(20));
//			
//			 //wait for the modal box be visible
//		     wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Success')]")));
//		}catch(Throwable e){
//		    System.err.println("Error while waiting for the notification to appear: "+ e.getMessage());
//		}
//	}
	public void gets_error3_message()
	{
		driver.findElement(Error3).click();
	}
	
	public void admin_see_two_inputs()
	{
		driver.findElement(ProgramName).click();
		driver.findElement(ProgramDescription).click();
	}
//	
//	public void admin_select_active_status()
//	{
//		 driver.findElement(Active).click();	
//		 System.out.println("Admin selected active status");
//	}
//	
//	public void admin_select_inactive_status()
//	{
//    	driver.findElement(Inactive).click();
//    	 System.out.println("Admin selected inactive status");
//	}
	
	public void select_active_status() throws InterruptedException
	{
     	
     	WebElement act = driver.findElement(Active);
     	act.click();
     	Thread.sleep(2000);
       System.out.println("Admin selected active status");	
     
	}
	
	public void select_inactive_status() throws InterruptedException
	{
     	WebElement inact =  driver.findElement(Inactive);
     	inact.click();
     	Thread.sleep(2000);
     	System.out.println("Admin selected active status");	
     
	}
	
	public void enter_programname_description() throws InterruptedException {
		driver.findElement(ProgramName).sendKeys("123");
		Thread.sleep(2000);
		System.out.println("Admin enters ProgramName");	
		driver.findElement(ProgramDescription).sendKeys("@#$");
		Thread.sleep(2000);
		System.out.println("Admin enters ProgramDescription");	
		
	}
	    	
	
	
	public void clicks_edit_cross_button()
	{
		driver.findElement(EditCloseCross).click();
	}
	
	public void clicks_cross_button()
	{
		driver.findElement(CloseCross).click();
	}
	
	public void clicks_edit_button() throws InterruptedException
	{
		driver.findElement(Edit).click();
		Thread.sleep(2000);
	}
	
	public void clicks_edit_description_button() throws InterruptedException
	{
		driver.findElement(Edit3).click();
		driver.findElement(ProgramDescription).sendKeys("$%^");
		Thread.sleep(2000);
	}
	
	
	public void clicks_edit_name_button() throws InterruptedException
	{
		driver.findElement(Edit2).click();
		driver.findElement(ProgramName).sendKeys("osu");
		Thread.sleep(2000);
	}
	
	public void clicks_delete_button1() throws InterruptedException
	{
		driver.findElement(DeleteIcon1).click();
		Thread.sleep(2000);
		
	}
	
	public void clicks_multiple_delete_button1() throws InterruptedException
	{
		driver.findElement(DeleteIcon1).click();
		Thread.sleep(2000);
		System.out.println("1st Delete");	
		driver.findElement(DeleteIcon2).click();
		Thread.sleep(2000);
		System.out.println("2nd Delete");
		driver.findElement(DeleteIcon3).click();
		Thread.sleep(2000);
		System.out.println("2nd Delete");
	}
	
	public void validateStatusRadioButtons()
	{
		List<WebElement> statusRadioButtons = driver.findElements(By.xpath("//div[@class='ng-star-inserted']"));

		Assert.assertEquals( 2, statusRadioButtons.size(),"Expected two radio buttons for Status");

		for (WebElement radioButton : statusRadioButtons) {
			String text = radioButton.getText();
			System.out.println("Radio button Text: " + text);

			Assert.assertTrue(radioButton.isDisplayed());
		}


	}
	
//	
//	public void addBatchAllFields(String Sheetname, Integer RowNumber) throws InterruptedException, InvalidFormatException, IOException 
//	{
//		ExcelReader reader=new ExcelReader();
//		List<Map<String, String>> testdata=reader.getData(Excelpath, Sheetname);
//	
//		String pgmName = testdata.get(RowNumber).get("ProgramName");
//		String pgmDesc = testdata.get(RowNumber).get("ProgramDescription");
//		String pgmStatus = testdata.get(RowNumber).get("ProgramStatus");
//		
//		
//		
//	}
}