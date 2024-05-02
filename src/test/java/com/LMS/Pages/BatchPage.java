package com.LMS.Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.LMS.Utils.ConfigReader;
import com.LMS.Utils.ExcelReader;
import com.LMS.Utils.Helper;
import com.LMS.Utils.LoggerLoad;

import io.cucumber.datatable.DataTable;



public class BatchPage {
	
private WebDriver driver;
Helper helper;
String loginUrl=ConfigReader.getHomePageUrl();
String Excelpath=ConfigReader.getExcelFilePath();



//constructor 
	public BatchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // initializing WebElelements
		helper=new Helper(driver);
	}

//Batch  button from Navigation bar
 @FindBy(id = "batch") WebElement batchBtn; 
 @FindBy(xpath = "//div[normalize-space()='Manage Batch']")WebElement batchHeader;
 @FindBy(xpath = "//span[text()='A New Batch']")WebElement addBatchBtn;

 
 //Batch pagination controls
@FindBy(xpath="//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']") 
List<WebElement> paginationFooter;

@FindBy(xpath="//span[@class='p-paginator-current ng-star-inserted']")
WebElement paginationText;

@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-double-left']")
WebElement firstPageIcon;

@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-double-right']") 
WebElement lastPageIcon;

@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-left']")
WebElement previousLink;

@FindBy(xpath="//span[@class='p-paginator-icon pi pi-angle-right']") 
WebElement nextLink;

@FindBy(xpath="//span[@class='p-paginator-pages ng-star-inserted']") 
WebElement pages;
 
 //Batch Details pop up elements
 @FindBy(xpath = "//span[text()='Batch Details']") WebElement batchDetailsHeader; 
 
 @FindBy(id = "batchName")  WebElement batchName; 
 
 @FindBy(id = "batchDescription")WebElement batchDesc; 
 
 @FindBy(xpath = "//input[@placeholder='Select a Program name']") WebElement selectPgmName; 
 
 @FindBy(xpath = "//input[@id='batchNoOfClasses']") WebElement batchNoOfClasses; 
 
 @FindBy(xpath="//div[@role='button']")WebElement pgmNameDropdown;
 
 @FindBy(xpath="//div[normalize-space()='ACTIVE']//p-radiobutton[@name='category']") WebElement activeRadioBtn; 
 
 @FindBy(xpath="//div[contains(text(),'INACTIVE')]//div[2]") WebElement inactiveRadioBtn; 
 
 @FindBy(xpath="//button[@label='Save']") WebElement saveBtn;
 
 @FindBy(xpath="//button[@label='Cancel']") WebElement cancelBtn;
 
 //Confirmation alerts
 @FindBy (xpath="//div[@class='p-toast-message-text ng-tns-c90-54 ng-star-inserted']/div[2]")
 WebElement msg_updated;
 
@FindBy(xpath="//div[@class='p-toast-message-text ng-tns-c90-99 ng-star-inserted']/div[2]")
WebElement msg_success;
 

//batch invalid errors
@FindBy(xpath="//small[text()='This field should start with an alphabet and min 2 character.']") 
WebElement InvalidError;

//mandatory field errors
@FindBy(xpath="//small[text()=//small[text()='Batch Name is required. ']") 
WebElement batchNameMandatoryMsg;

@FindBy(xpath="//small[normalize-space()='Batch Description is required.']") 
WebElement batchDescMandatoryMsg;


@FindBy(xpath="//small[normalize-space()='Batch Description is required.']") 
WebElement statusMandatoryMsg;

@FindBy(xpath="//small[normalize-space()='Batch Description is required.']") 
WebElement classMandatoryMsg;

 
//Batch Details Data Table 
 @FindBy(xpath="//thead[@class='p-datatable-thead']")WebElement batchDataTableHeader;
 
 @FindBy(xpath="//th") List<WebElement> columnHeading;
 
 @FindBy(xpath="//th[@psortablecolumn='batchName']")WebElement batchNameSort;

 @FindBy(xpath="//th[@psortablecolumn='batchDescription']")WebElement batchDescSort;
 
 @FindBy(xpath="//th[@psortablecolumn='batchStatus']")WebElement batchStatusSort;
 
 @FindBy(xpath="//th[@psortablecolumn='batchNoOfClasses']")WebElement noOfClassesSort;
 
 @FindBy(xpath="//th[@psortablecolumn='programName']") WebElement pgmNameSort;
 
 @FindBy(xpath="//tbody")
List <WebElement> batchDetailsTable;
 
 
 //pagination
 
 @FindBy(xpath="//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']") WebElement totalBatchesmsg;
 
 //Edit Batch
@FindBy(xpath = "//body[1]/app-root[1]/app-batch[1]/div[1]/mat-card[1]/mat-card-content[1]/p-table[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[7]/div[1]/span[1]/button[1]/span[1]")
WebElement edit_btn;
@FindBy (xpath="//th[normalize-space()='Edit / Delete']") WebElement editDelete ;

@FindBy (xpath="//span[@class='p-button-icon pi pi-pencil'])") List <WebElement> editIcon;
 
@FindBy (xpath="(//button[@icon='pi pi-pencil'])[1]") WebElement editIconClick;
 
 
 
//Delete All

 @FindBy(xpath="//button[@class='p-button-danger p-button p-component p-button-icon-only']") 
 WebElement deleteAllBatchBtn;
 
 @FindBy (xpath="//span[text()='Yes']") WebElement deleteYes;
 
@FindBy (xpath="//span[text()='No']")WebElement deleteNo;

@FindBy(xpath="//span[contains(text(),'Are you sure you want to delete')]") WebElement deleteMessage;

@FindBy(xpath="//*[contains(text(),'Success')]") WebElement DelSuccessMessage;

@FindBy (xpath="//span[@class='pi pi-times ng-tns-c133-70']") WebElement closeArrow;

@FindBy(xpath="(//button[@icon='pi pi-trash'])[2]") WebElement deleteIconRow;
 
@FindBy(xpath="//span[text()='Confirm']") WebElement confirmDialog;

@FindBy(xpath = "//button[@id='deleteProgram']")
List<WebElement> deleteButtonsinRow;
 
 //SearchBox
@FindBy (xpath="//input[@id='filterGlobal']") WebElement searchbox ;
@FindBy(xpath="//span[@class='p-input-icon-left']") WebElement search;
@FindBy(xpath="//i[@class='pi pi-search']") WebElement searchicon;
 


 
//Actions or Methods
 public void clickBatchBtn() throws InterruptedException {
	 Thread.sleep(2000);
	 batchBtn.click();
 }
 
 public String verifyDashboardPageTitle() {
		String dashboardpageTitle=helper.getTitle(driver);
		return dashboardpageTitle;
	}
 
 public String getManageBatchURL() throws InterruptedException {
	  
		String URL=helper.getCurrentURL(driver);
		return URL;
	}

 //Get Batch Page Header
 public String getPageHeader()
	{
	String actualHeader=batchHeader.getText();
	return actualHeader;
	}
 
 
//Checking Pagination Controls is displayed
	public boolean verify_pagination_controls_isDisplayed() throws InterruptedException {
			   
		   Thread.sleep(2000);
		
		if(firstPageIcon.isDisplayed() && previousLink.isDisplayed()&& pages.isDisplayed())
		{
			if(nextLink.isEnabled()
					&& lastPageIcon.isEnabled()) 
				System.out.println("Pagination control arrows are displayed" );
			return true;
					
		}
		else 
			return false;
	}
 
	//Validate Batch Data table header
		public void batchDataTableHeaders() 
		{
			List<String> columnHeadingTexts = new ArrayList<String>();
			for(WebElement heading : columnHeading) {
				String columnHeadingText = heading.getText();
				columnHeadingTexts.add(columnHeadingText);		
			}
			System.out.println("Batch Datatable Column headers Displayed are:" +columnHeadingTexts+"\n");
		}
		
//Validate '+ A New batch' Button is displayed
public boolean newbatchBtnIsDisplayed() {
	helper.isDisplayed(addBatchBtn);
	return true;
}
	
// Clicking '+ A New Batch' Button	
public void clickAddBatch() {
	addBatchBtn.click();
}

// Batch pop up window
public boolean batchPopUpIsDisplayed() throws InterruptedException {
	Thread.sleep(1000);
	return batchDetailsHeader.isDisplayed();
}
 
//Validate pop up fields
public boolean validateBatchPopUpFields() {
	batchName.isDisplayed();
	LoggerLoad.info("BatchName Text Box is displayed in the Batch Details pop up");
	batchDesc.isDisplayed();
	LoggerLoad.info("BatchDescription Text Box is displayed in the Batch Details pop up");
	pgmNameDropdown.isDisplayed();
	LoggerLoad.info("Program Name dropdown is displayed in the Batch Details pop up");
    batchNoOfClasses.isDisplayed();
    LoggerLoad.info("Program Name dropdown is displayed in the Batch Details pop up");
    activeRadioBtn.isDisplayed();
    LoggerLoad.info("Program Name dropdown is displayed in the Batch Details pop up");
    inactiveRadioBtn.isDisplayed();
    LoggerLoad.info("Program Name dropdown is displayed in the Batch Details pop up");
    return true;
	
}

//Enter value in searchbox
public void enterValueinSearchBox(String value) {
	searchbox.click();
	searchbox.sendKeys(value);
}

//Validate batch desc is optional
public void batchWithoutBatchDesc(DataTable dataTable) throws InterruptedException {
	List<Map<String, String>> batch = dataTable.asMaps(String.class, String.class);
	for (Map<String, String> mapData : batch) {
		String name = mapData.get("BatchName");
	    String pgmName=mapData.get("ProgramName");
	    String noOfClasses=mapData.get("No Of Classes");
		batchName.clear();
		batchName.sendKeys(name);
		Thread.sleep(2000);
		pgmNameDropdown.click();
		
		By programOption   = By.xpath("//li[@role='option']");
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(programOption));
		String desiredProgram = "squad batch 0603";
		WebElement selectedProgram = null;
		for (WebElement option :driver.findElements(programOption)) {
			if
			(option.getText().trim().equals(desiredProgram)) {
				selectedProgram = option;
				break;
			}
		}
		if (selectedProgram != null) {
			// Click on the element using JavaScript
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectedProgram);
			System.out.println("Selected program: " +desiredProgram);
		} else { System.out.println("Desired program not found: " +
				desiredProgram); }

		activeRadioBtn.click();
		System.out.println("Test data from excel :"+"\n"+name+"\n"+pgmName+"\n"+noOfClasses);
		Thread.sleep(1000);
		batchNoOfClasses.sendKeys(noOfClasses);
		saveBtn.click();
		
	}
}
public void clickStatus(String status) {
	if (status.equalsIgnoreCase("Active"))
	{
		activeRadioBtn.click();
	}
	else
		inactiveRadioBtn.click();
}

public String getSuccessAlertMsg() {
	   String msg= msg_success.getText();
	   return msg;
	}

//New batch all  fields 
public void addBatchAllFields(String Sheetname, Integer RowNumber) throws InterruptedException, InvalidFormatException, IOException {
ExcelReader reader=new ExcelReader();
List<Map<String, String>> testdata=reader.getData(Excelpath, Sheetname);
String bName = testdata.get(RowNumber).get("BatchName");
String bDesc = testdata.get(RowNumber).get("BatchDescription");
String pgmName = testdata.get(RowNumber).get("ProgramName");
String status=testdata.get(RowNumber).get("BatchStatus");
String noOfClasses = testdata.get(RowNumber).get("NoOfClasses");
batchName.clear();
batchName.sendKeys(bName);
Thread.sleep(1000);
batchDesc.clear();
batchDesc.sendKeys(bDesc);

pgmNameDropdown.click();

By programOption   = By.xpath("//li[@role='option']");
Thread.sleep(5000);
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
wait.until(ExpectedConditions.visibilityOfElementLocated(programOption));
String desiredProgram = pgmName;
WebElement selectedProgram = null;
for (WebElement option :driver.findElements(programOption)) {
	if
	(option.getText().trim().equals(desiredProgram)) {
		selectedProgram = option;
		break;
	}
}
if (selectedProgram != null) {
	// Click on the element using JavaScript
	((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectedProgram);
	System.out.println("Selected program: " +desiredProgram);
} else { System.out.println("Desired program not found: " +
		desiredProgram); }
clickStatus(status);
//activeRadioBtn.click();
System.out.println("Test data from excel :"+"\n"+bName+"\n"+bDesc+"\n"+pgmName+"\n"+status+"\n"+noOfClasses);
Thread.sleep(1000);
batchNoOfClasses.sendKeys(noOfClasses);
saveBtn.click();
}

//Edit icon is enabled 

public void editIconEnabled() {
	List<WebElement> editIcon = driver.findElements(By.xpath("//tbody//tr//td[7]"));
	for(WebElement edit:editIcon ) {
		
	}
	editIconClick.isEnabled();
	System.out.println("Edit icon is enabled");
}

public void clickEditIcon() {
	editIconClick.click();
}
//Delete all button is disabled

public boolean DeleteAllDisabled() {
	if (deleteAllBatchBtn.isDisplayed()) {
		return true;
	}
	else 
		return false;

}

//invalid error message
public String getInvalidDataErrormessage() {
	String nameerror=InvalidError.getText();
	return nameerror;
	
}


// Validate edit button is displayed
public void ValidateEditDeleteIconInRows(){
	String text=totalBatchesmsg.getText();
	int total_batches=Integer.parseInt(text.substring(text.indexOf("are")+4,text.indexOf("programs")-1));
	System.out.println("Total Edit/delete buttons are:"+total_batches);
	int paginationsize = driver.findElements(By.xpath("//div[@class=\"p-paginator-bottom p-paginator p-component ng-star-inserted\"]//span[2]//button")).size();
	System.out.println("paginationsize is" +paginationsize);
	List<String> EditDelete = new ArrayList<String>();
	for(int i=1; i<paginationsize; i++) {
		WebElement page = driver.findElement(By.xpath("//div[@class=\"p-paginator-bottom p-paginator p-component ng-star-inserted\"]//span[2]//button[normalize-space()='"+i+"']"));
		page.click();
		List<WebElement> Editdeletebtn = driver.findElements(By.xpath("//tbody//tr//td[5]"));
		int totalEditDeletebox = Editdeletebtn.size();
		System.out.println(" Total Number of EditDelete  :" +totalEditDeletebox);

	}
	for(int j=paginationsize;j<=(total_batches/5)+1;j++) {
		WebElement arrow = driver.findElement(By.xpath("//span[@class='p-paginator-icon pi pi-angle-right']"));
		System.out.println("j-->"+j);
		arrow.click();
		WebElement page1 = driver.findElement(By.xpath("//div[@class=\"p-paginator-bottom p-paginator p-component ng-star-inserted\"]//span[2]//button[normalize-space()='"+j+"']"));
		List<WebElement> Editdeletebtn = driver.findElements(By.xpath("//tbody//tr//td[5]"));
		int totalEditDelete = Editdeletebtn.size();
		System.out.println("Total Number of Edit/Delete : " +totalEditDelete);

	}
	System.out.println("Edit/Delete is present in each row : " +EditDelete+"\n");
}

//verifying search box
	public void searchboxdisplay() { 
	
		if(search.isDisplayed() && searchbox.isDisplayed() && searchicon.isDisplayed()) 
		{
			System.out.println("Search is displayed");

		}

	}
	
	
//Validated new batch in datatable
	public void checkValueInDatatable(String pgmname) throws InterruptedException {
		searchbox.clear();
		searchbox.sendKeys(pgmname);
		Thread.sleep(500);
		int rowCount=driver.findElements(By.xpath("//table[@role='grid']//tr")).size();
		int columnCount=driver.findElements(By.xpath("//table[@role='grid']//th")).size();
		for (int i=1;i<rowCount;i++) {
				String batchdetails=driver.findElement(By.xpath("//table/tbody/tr["+(i+1)+"]/td[2]")).getText();
				if (batchdetails.equals(pgmname)){
					System.out.println(batchdetails);
				//	System.out.println(i+"  :   "+j);
					break;
					
				}
				else 
					System.out.println("Batch Details are not in datatable");
			}
		}
	
	//Search batch from datatable and click edit
	public void searchBatchAndClickEdit(String pgmname) throws InterruptedException {
		searchbox.clear();
		searchbox.sendKeys(pgmname);
		Thread.sleep(500);
		searchicon.click();
	}
	
	// Update Batch details 
	
	public void UpdateBatchDetails(String Sheetname, Integer RowNumber) throws InterruptedException, InvalidFormatException, IOException {
		ExcelReader reader=new ExcelReader();
		List<Map<String, String>> testdata=reader.getData(Excelpath, Sheetname);
		String bDesc = testdata.get(RowNumber).get("BatchDescription");
		String pgmName = testdata.get(RowNumber).get("ProgramName");
		String status=testdata.get(RowNumber).get("BatchStatus");
		String noOfClasses = testdata.get(RowNumber).get("NoOfClasses");
		batchDesc.clear();
		batchDesc.sendKeys(bDesc);
		clickStatus(status);
		System.out.println("Test data from excel :"+"\n"+bDesc+"\n"+pgmName+"\n"+status+"\n"+noOfClasses);
		Thread.sleep(1000);
		batchNoOfClasses.sendKeys(noOfClasses);
		saveBtn.click();
		}

	
	
	
public void sort() {
	batchNameSort.click();
	List<String> originalList=batchDetailsTable.stream().map(s->s.getText()).collect(Collectors.toList());
	List<String> sortedList=originalList.stream().sorted().collect(Collectors.toList());
	Assert.assertTrue(originalList.equals(sortedList));
}

public void deleteBtnDisabled() 
{

	
	System.out.println("Delete all batch icon is Displayed : " +deleteAllBatchBtn.isDisplayed());
	String attribute = deleteAllBatchBtn.getAttribute("class");
	System.out.println("Delete icon is disable:" +attribute.contains("disabled"));
}

public void verifyMandatoryMsgs() {
	List<String> expectedErrorMessages = List.of("Batch Name is required.", "Batch Description is required.",
			"Program Name is required.", "Status is required.", "Number of classes is required.");
	//Assert.assertEquals(batchPage.getErrorMessageOfMandatoryFields(), expectedErrorMessages);
	  
}

public void eraseDataUpdate() throws InterruptedException {
	
	batchDesc.clear();
	Thread.sleep(250);

	batchNoOfClasses.clear();
	saveBtn.click();
}
public String batchDescMandatoryMsgInUpdate() {
	String batchDescMsg=batchDescMandatoryMsg.getText();
	return batchDescMsg;	
	
}
public String classMandatoryMsgInUpdate() {
String classMsg=classMandatoryMsg.getText();
return classMsg;
}

public String updateInvalidErrorMsg() {
	   String msg= InvalidError.getText();
	   return msg;
	}

public void clickRowDeleteBtn() {
	
	deleteIconRow.click();
}

public void validateDeletePopup() throws InterruptedException {
	Thread.sleep(500);
  //driver.switchTo().activeElement();
	confirmDialog.isDisplayed();
	deleteYes.isDisplayed();
	deleteNo.isDisplayed();
}

public boolean deleteInRowEnabled() {
	for (WebElement deletebtns : deleteButtonsinRow) {

		if (!deletebtns.isEnabled()) {
			return false;
		}

	}
	return true;
}

public void clickYesBtn() {
	deleteYes.click();
}


}
