package com.LMS.Pages;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Utils.ConfigReader;

public class ProgramPage {

	private static final WebElement PaginationText = null;
	public static WebDriver driver = DriverFactory.getdriver();

	//By dashboardPage = By.xpath("//div[@class='signin-content']");
	By dashboardPage = By.xpath("//div[normalize-space()='Manage Program']");
	By programButton = By.xpath("//span[normalize-space()='Program']");
	By pageHeader = By.xpath("//div[normalize-space()='Manage Program']");
	By paginationText = By.xpath("//span[@class='p-paginator-current ng-star-inserted']");
	//By rightArrow = By.xpath("//span[@class='p-paginator-icon pi pi-angle-right']");
	By rightArrow = By.xpath("//button[@class='p-paginator-next p-paginator-element p-link p-ripple']");
	//button[@class='p-paginator-next p-paginator-element p-link p-ripple']
	By lastArrow = By.xpath("//button[@class='p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted']");
	//By doubleleftArrow = By.xpath("//span[@class='p-paginator-icon pi pi-angle-double-left']");
	//By doubleleftArrow = By.xpath("//button[@class='p-paginator-first p-paginator-element p-link p-disabled p-ripple ng-star-inserted']");
	By doubleleftArrow = By.xpath("//button[@class='p-paginator-first p-paginator-element p-link p-ripple ng-star-inserted']");
	By leftArrow = By.xpath("//span[@class='p-paginator-icon pi pi-angle-left']");
	//By leftArrow = By.xpath("//button[@class='p-paginator-prev p-paginator-element p-link p-disabled p-ripple']");
	By Pages = By.xpath("//span[@class='p-paginator-pages ng-star-inserted']");
	By totalPrograms = By.xpath("//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']");
	By deletedisable = By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
	//pagination
	By leftarrowdisable = By.xpath("//button[@class='p-paginator-prev p-paginator-element p-link p-ripple p-disabled']");
	By nextpagedisable = By.xpath("//button[@class='p-paginator-next p-paginator-element p-link p-ripple p-disabled']");
	By newProgram = By.xpath("//button[@id='new']");
	By programName = By.xpath("//th[normalize-space()='Program Name']");
	By programDescription = By.xpath("//th[normalize-space()='Program Description']");
	By programStatus = By.xpath("//th[normalize-space()='Program Status']");
	By editDelete = By.xpath("//th[normalize-space()='Edit / Delete']");
	By programSort = By.xpath("//p-sorticon[@field='programName']");
	By programDescSort = By.xpath("//p-sorticon[@field='description']");
	By programStatusSort = By.xpath("//p-sorticon[@field='status']");
	By Datatable = By.xpath("//div[@class='p-datatable-wrapper ng-star-inserted']");
	By checkbox = By.xpath("//tbody/tr[2]/td[1]/p-tablecheckbox[1]/div[1]/div[1]");
	By programEditdelete = By.xpath("//th[normalize-space()='Edit / Delete']");
	By programCheckbox = By.xpath("//tr[@class='ng-star-inserted']//th//p-tableheadercheckbox");
	By searchbox = By.xpath("//input[@id='filterGlobal']");
	By search = By.xpath("//div[@class='box']//div[2]");
	//By search = By.xpath("//span[@class='p-input-icon-left']");
	By searchicon = By.xpath("//i[@class='pi pi-search']");
	By tableHeader = By.xpath("//thead[@class='p-datatable-thead']");
	By tableBody = By.xpath("//tbody");
	By paginator = By.xpath("//div[@class='p-paginator-bottom p-paginator p-component ng-star-inserted']");
	By activePage = By.xpath("//div[@class=\"p-paginator-bottom p-paginator p-component ng-star-inserted\"]//span[2]//button");
	By noofRows = By.xpath("//table[@role='grid']//tbody/tr");
	By sorticon = By.xpath("//thead//tr//th//p-sorticon");
	By chkBox = By.xpath("//tbody//tr//td[1]");
	By angleRight = By.xpath("//button[@class='p-paginator-next p-paginator-element p-link p-ripple']");
//	By angleRight = By.xpath("//span[@class='p-paginator-icon pi pi-angle-right']");
	By editdelbtn = By.xpath("//tbody//tr//td[5]");
	By PgmNames= By.xpath("//tbody//tr//td[2]");
	By rightarrowdynamic = By.xpath("//button[contains(@class,'p-paginator-next p-paginator-element p-link p-ripple')]");
	By PgmDesc = By.xpath("//tbody//tr//td[3]");
	By PgmStatus = By.xpath("//tbody//tr//td[4]");
	//By firstPagelink = By.xpath("//button[normalize-space()='2']");
	By firstpage = By.xpath("//button[normalize-space()='1']");
	By batch = By.xpath("//button[@id='batch']");
	By user = By.xpath("//button[@id='user']");
	By logout = By.xpath("//button[@id='logout']");
//ProgramName Ascending Declaration
	public List<String> names = new ArrayList<String>();
	public String[] beforesort;
//ProgramName Descending Declaration
	public List<String> namesDecBefore = new ArrayList<String>();
	public List<String> namesDecAfter = new ArrayList<String>();
	public String[] beforesortPgmDesc1;
	
//ProgramDescription Ascending Declaration
	public List<String> pgmDescnames = new ArrayList<String>();
	public String[] beforesortPgmdesAsc;
//ProgramDescription Descending Declaration	
	public List<String> pgmdescDescnames = new ArrayList<String>();
	public List<String> programdescDescnames = new ArrayList<String>();
	public String[] beforesortpgmdescdesc;
//ProgramStatus Ascending Declaration
	public List<String> pgmstatusnames = new ArrayList<String>();
	public String[] beforesortPgmstatusAsc;
//ProgramStatus Descending Declaration	
	public List<String> pgmstatusdescnames = new ArrayList<String>();
	public String[] beforesortPgmstatusdesc;
	
	public ProgramPage(WebDriver driver) {
		this.driver = driver;
	}

	public void dashboardpage() {
		driver.findElement(dashboardPage).isDisplayed();
	}

	public void programClick() {
		driver.findElement(programButton).click();
	}

	//Asserting actual and expected URL
	public void validateurlstring() {
		String expectedurl=ConfigReader.getManageProgramUrl();
		String Actualurl=driver.getCurrentUrl();
		Assert.assertEquals(Actualurl, expectedurl);

	}

	//Checking Page Header as Manage Program
	public String getHeadingText() {
		String pagetext = driver.findElement(pageHeader).getText();
		System.out.println("Pagetext is : " +pagetext);
		return pagetext;
	}

	//Checking Pagination Text and x, y and z values
	public void VerifyPaginationText(){ //PaginationText
		{
			WebElement PaginationText=driver.findElement(paginationText);
			if (PaginationText.isDisplayed()) {
				String paginationText1=PaginationText.getText();
				System.out.println("PaginationText Present:"+ paginationText1);
			}

			String[] parts = PaginationText.getText().split(" ");
			int x = Integer.parseInt(parts[1]);
			int y = Integer.parseInt(parts[3]);
			int z = Integer.parseInt(parts[5]);
			System.out.println("X Y and Z Value is:" +x+" "+y+" "+z);
		}
	}

	//Checking Pagination Controls is displayed
	public boolean verify_pagination_controls() throws InterruptedException {

		WebElement doubleleftarrow1=driver.findElement(doubleleftArrow);
		WebElement leftArrow1=driver.findElement(leftArrow);
		WebElement rightArrow1=driver.findElement(rightArrow);
		WebElement lastArrow1=driver.findElement(lastArrow);
		WebElement Pages1 = driver.findElement(Pages);
		Thread.sleep(3);
		if(doubleleftarrow1.isDisplayed() && leftArrow1.isDisplayed()&& Pages1.isDisplayed()) 
		{
			if(rightArrow1.isEnabled()
					&& lastArrow1.isEnabled()) 
				System.out.println("paginationarrows present is " );
			return true;
		}
		else 
			return false;
	}

	//Validating footer text and total number of programs
	public void validate_footer_text()
	{
		String text=driver.findElement(totalPrograms).getText();
		System.out.println(text);
		int total_Programs=Integer.parseInt(text.substring(text.indexOf("are")+4,text.indexOf("programs")-1));
		System.out.println("total programs are:"+total_Programs);

	}

	//Validating the default state of Delete button
	public void deletedisabled() 
	{

		WebElement deletebtn = driver.findElement(deletedisable);
		System.out.println("Delete icon is displayed : " +deletebtn.isDisplayed());
		String attribute = deletebtn.getAttribute("class");
		System.out.println("Delete icon is disable:" +attribute.contains("disabled"));
	}

	//Validate Add New Program 
	public void addNewProgrambtn() { 
		Boolean newProgrambtn = driver.findElement(newProgram).isDisplayed();
		if(newProgrambtn) {
			System.out.println("AddNewProgram button is present");
		}
		else {
			System.out.println("No AddNewProgram");
		}

	}

	//Validate that number of records
	public void validate_number_of_records() throws InterruptedException
	{
		String text=driver.findElement(totalPrograms).getText();
		int total_Programs=Integer.parseInt(text.substring(text.indexOf("are")+4,text.indexOf("programs")-1));
		System.out.println("total programs are:"+total_Programs);
		int totalPages = total_Programs/5;
		if(totalPages>1)
		{
			//getting active page
			WebElement active_page=driver.findElement(activePage);
			System.out.println("active page is: "+active_page.getText());
			active_page.click();
		}

		//getting no. of rows on active page
		int rows=driver.findElements(noofRows).size();
		System.out.println("no.of rows are: "+rows);

	}

	//Verifying column headers
	public void programColumnHeaders() 
	{
		WebElement columnTable = driver.findElement(tableHeader);
		List<WebElement> columnHeadings = columnTable.findElements(By.xpath("//th"));
		List<String> columnHeadingTexts = new ArrayList<String>();
		for(WebElement heading : columnHeadings) {
			String columnHeadingText = heading.getText();
			columnHeadingTexts.add(columnHeadingText);	

		}
		System.out.println("Column header is " +columnHeadingTexts);
	}

	public Boolean verify_PresenceOfsortArrows_Except_EditDelete()
	{
		WebElement tableHeader1 = driver.findElement(tableHeader);
		List<WebElement> tableSorting = tableHeader1.findElements(sorticon);
		List<String> tableSortingTexts = new ArrayList<String>();
		boolean result=false;

		for(WebElement header:tableSorting)
		{				
			String tableHeadingSortingText = header.getText();
			tableSortingTexts.addAll(tableSortingTexts);

			if(header.isDisplayed()) {
				System.out.println("Sorting arrows are present" +tableSortingTexts);
			}
			else {
				System.out.println("Sorting arrows are not present");
			}
			if(!header.getText().trim().equals(" Edit / Delete "))
			{
				if(!tableSorting.isEmpty())
				{
					System.out.println("SortArrows is not there in Edit/Delete Icon");
					result=true;
				}
			}
			System.out.println("Header Name is :" +tableHeadingSortingText);
		}
		return result;
	}


	public void Validaterowcheckbox(){
		WebElement programCheckbox1 = driver.findElement(programCheckbox);
		String text=driver.findElement(totalPrograms).getText();
		int total_Programs=Integer.parseInt(text.substring(text.indexOf("are")+4,text.indexOf("programs")-1));
		System.out.println("total checkboxes are:"+total_Programs);
		int paginationsize = driver.findElements(activePage).size();
		System.out.println("paginationsize is" +paginationsize);
		List<String> checkbox1 = new ArrayList<String>();
		for(int i=1; i<paginationsize; i++) {
			WebElement page = driver.findElement(By.xpath("//div[@class=\"p-paginator-bottom p-paginator p-component ng-star-inserted\"]//span[2]//button[normalize-space()='"+i+"']"));
			page.click();
			List<WebElement> checkboxes = driver.findElements(chkBox);
			for(WebElement checkbox :checkboxes ) {
				checkbox1.add(checkbox.getText());
			}
			if(programCheckbox1.isDisplayed())
			{

				System.out.println("Checkbox in Header is displayed");
			}
			int totalcheckbox = checkbox1.size();
			System.out.println(" Total Number of checkboxes  :" +totalcheckbox);

		}
		for(int j=paginationsize;j<=(total_Programs/5)+1;j++) {
			WebElement arrow = driver.findElement(angleRight);
			System.out.println("j-->"+j);
			arrow.click();
			WebElement page1 = driver.findElement(By.xpath("//div[@class=\"p-paginator-bottom p-paginator p-component ng-star-inserted\"]//span[2]//button[normalize-space()='"+j+"']"));
			List<WebElement> checkboxes = driver.findElements(chkBox);
			for(WebElement checkbox :checkboxes ) {
				checkbox1.add(checkbox.getText());
			}
			if(programCheckbox1.isDisplayed())
			{

				System.out.println("Checkbox in Header is displayed");
			}
			int totalCheckBoxes = checkbox1.size();
			System.out.println("Total Number of Checkboxes : " +totalCheckBoxes);

		}System.out.println("Checkbox is present in each row : " +checkbox1+"\n");
	}

	public void ValidateEditDelete(){

		String text=driver.findElement(totalPrograms).getText();
		int total_Programs=Integer.parseInt(text.substring(text.indexOf("are")+4,text.indexOf("programs")-1));
		System.out.println("total Edit/delete butons are:"+total_Programs);
		int paginationsize = driver.findElements(activePage).size();
		System.out.println("paginationsize is" +paginationsize);
		List<String> EditDelete = new ArrayList<String>();
		for(int i=1; i<paginationsize; i++) {
			WebElement page = driver.findElement(By.xpath("//div[@class=\"p-paginator-bottom p-paginator p-component ng-star-inserted\"]//span[2]//button[normalize-space()='"+i+"']"));
			page.click();
			List<WebElement> Editdeletebtn = driver.findElements(editdelbtn);
			int totalEditDeletebox = Editdeletebtn.size();
			System.out.println(" Total Number of EditDelete  :" +totalEditDeletebox);

		}
		for(int j=paginationsize;j<=(total_Programs/5)+1;j++) {
			WebElement arrow = driver.findElement(angleRight);
			System.out.println("j-->"+j);
			arrow.click();
			WebElement page1 = driver.findElement(By.xpath("//div[@class=\"p-paginator-bottom p-paginator p-component ng-star-inserted\"]//span[2]//button[normalize-space()='"+j+"']"));
			List<WebElement> Editdeletebtn = driver.findElements(editdelbtn);
			int totalEditDelete = Editdeletebtn.size();
			System.out.println("Total Number of Edit/Delete : " +totalEditDelete);

		}System.out.println("Edit/Delete is present in each row : " +EditDelete+"\n");
	}


	public void ValidatePagination() throws InterruptedException{

		String text=driver.findElement(totalPrograms).getText();
		int total_Programs=Integer.parseInt(text.substring(text.indexOf("are")+4,text.indexOf("programs")-1));
		System.out.println("total programs are:"+total_Programs);
		List<WebElement> namesElements = driver.findElements(PgmNames);
		List<String> names = new ArrayList<String>();

		for(WebElement namesElement :namesElements ) {
			names.add(namesElement.getText());
		}
		String nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		while(!nextbuttonclassName.contains("disabled")) {
			driver.findElement(rightarrowdynamic).click();
			namesElements = driver.findElements(PgmNames);
			Thread.sleep(2000);
			for(WebElement namesElement :namesElements ) {
				names.add(namesElement.getText());
			}
			nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		}
		for(String name : names ) {
			System.out.println(name);
		}
		int totalNames = names.size();
		System.out.println(" Total Number of names  :" +totalNames);
		Assert.assertEquals(total_Programs, String.valueOf(totalNames));
		Thread.sleep(1000);
	}

//	public void beforesorting(){
//
//		List<WebElement> namesElements = driver.findElements(PgmNames);
//
//		for(WebElement namesElement :namesElements ) {
//			names.add(namesElement.getText().trim());
//		}
//		String nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
//		while(!nextbuttonclassName.contains("disabled")) {
//			driver.findElement(rightarrowdynamic).click();
//			namesElements = driver.findElements(PgmNames);
//			for(WebElement namesElement :namesElements ) {
//				names.add(namesElement.getText());
//			}
//			nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
//		}
//		for(String name : names ) {
//			System.out.println(name);
//		}
//		Collections.sort(names);
//
//	}



	public void beforesortingProgramNamesAsc(){

		List<WebElement> programNames = driver.findElements(PgmNames);

		for(WebElement programName :programNames ) {
			names.add(programName.getText().trim());
		}
		String nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		while(!nextbuttonclassName.contains("disabled")) {
			driver.findElement(rightarrowdynamic).click();
			programNames = driver.findElements(PgmNames);
			for(WebElement programName :programNames ) {
				names.add(programName.getText().trim());
			}

			nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		}
		for(String name : names ) {
			System.out.println(name);
		}
		beforesort = new String[names.size()];
		System.out.println("before sorting.." +names.size());
		for (int i = 0; i < names.size(); i++) { 
			beforesort[i] = names.get(i).trim();
		}
		System.out.println("Sorting....");
		Arrays.sort(beforesort);
	
	}

	public void aftersortingProgramNameAsc(){

		List<WebElement> programNames = driver.findElements(PgmNames);
		List<String> afternames = new ArrayList<String>();

		for(WebElement programName :programNames ) {
			afternames.add(programName.getText().trim());
		}
		String nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		while(!nextbuttonclassName.contains("disabled")) {
			driver.findElement(rightarrowdynamic).click();
			programNames = driver.findElements(PgmNames);
			for(WebElement programName :programNames ) {
				afternames.add(programName.getText().trim());
			}
			nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		}
		String[] aftersort = new String[afternames.size()];
		System.out.println("After sorting.." +afternames.size());
		for (int i = 0; i < afternames.size(); i++) {
			aftersort[i] = afternames.get(i).trim();
		}	
		for (String x : aftersort) 
		{				
			System.out.print(x + "\n");
		}
		Assert.assertEqualsNoOrder(beforesort, aftersort);
	}

	//verifying search box
	public void searchboxdisplay() { 
		WebElement searchbox1 = driver.findElement(searchbox);
		WebElement search1 = driver.findElement(search);
		WebElement searchicon1 = driver.findElement(searchicon);
		if(search1.isDisplayed() && searchbox1.isDisplayed() && searchicon1.isDisplayed()) 
		{
			System.out.println("Search is displayed");

		}

	}
	//Sorting Program Name Descending
	public void BeforeSortingPgmNamedesc() {
		List<WebElement> namesElements = driver.findElements(PgmNames);

		for(WebElement namesElement :namesElements ) {
			namesDecBefore.add(namesElement.getText().trim());
		}
		String nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		while(!nextbuttonclassName.contains("disabled")) {
			driver.findElement(rightarrowdynamic).click();
			namesElements = driver.findElements(PgmNames);
			for(WebElement namesElement :namesElements ) {
				namesDecBefore.add(namesElement.getText());
			}
			nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		}
		for(String namesDecBefore1 : namesDecBefore ) {
			System.out.println(namesDecBefore1);
		}
		beforesortPgmDesc1 = new String[namesDecBefore.size()];
		System.out.println("Before sorting.." +namesDecBefore.size());
		for (int i = 0; i < namesDecBefore.size(); i++) {
			beforesortPgmDesc1[i] = namesDecBefore.get(i).trim();
		}
		Collections.sort(namesDecBefore);
		Collections.reverse(namesDecBefore);
		System.out.println("Sorting....");
		}
	
	//Sorting AfterSort Program Name Descending
	public void AfterSortingPgmNamedesc() {
		List<WebElement> namesElementdesc = driver.findElements(PgmNames);

		for(WebElement namesElement :namesElementdesc ) {
			namesDecAfter.add(namesElement.getText().trim());
		}
		String nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		while(!nextbuttonclassName.contains("disabled")) {
			driver.findElement(rightarrowdynamic).click();
			namesElementdesc = driver.findElements(PgmNames);
			for(WebElement namesElement :namesElementdesc ) {
				namesDecAfter.add(namesElement.getText());
			}
			nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		}
		String[] aftersortPgmDesc = new String[namesDecAfter.size()];
		System.out.println("After sorting.." +namesDecAfter.size());
		for (int i = 0; i < namesDecAfter.size(); i++) {
			aftersortPgmDesc[i] = namesDecAfter.get(i).trim();
		}
		for (String x : aftersortPgmDesc) 
		{				
			System.out.print(x + "\n");
		}
		Assert.assertEqualsNoOrder(beforesortPgmDesc1, aftersortPgmDesc);
	}

	public void beforesortingProgramDescriptionAsc(){

		List<WebElement> namesElements = driver.findElements(PgmDesc);
		for(WebElement namesElement :namesElements ) {
			pgmDescnames.add(namesElement.getText().trim());
		}
		String nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		while(!nextbuttonclassName.contains("disabled")) {
			driver.findElement(rightarrowdynamic).click();
			namesElements = driver.findElements(PgmDesc);
			for(WebElement namesElement :namesElements ) {
				pgmDescnames.add(namesElement.getText());
			}
			nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		}
		
		for(String pgmDescname : pgmDescnames ) {
			System.out.println(pgmDescname);
		}
		Collections.sort(pgmDescnames);
		beforesortPgmdesAsc = new String[pgmDescnames.size()];
		System.out.println("before sorting.." +pgmDescnames.size());
		for (int i = 0; i < pgmDescnames.size(); i++) { 
			beforesortPgmdesAsc[i] = pgmDescnames.get(i).trim();
		}
		System.out.println("Sorting....");
	}
	public void aftersortingProgramDescriptionAsc(){

		List<WebElement> programdescNames = driver.findElements(PgmDesc);
		List<String> pgmDescnameafternames = new ArrayList<String>();
		
		for(WebElement programdescName :programdescNames ) {
			pgmDescnameafternames.add(programdescName.getText().trim());
		}
		String nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		while(!nextbuttonclassName.contains("disabled")) {
			driver.findElement(rightarrowdynamic).click();
			programdescNames = driver.findElements(PgmDesc);
			for(WebElement programdescName :programdescNames ) {
				pgmDescnameafternames.add(programdescName.getText());
			}
			nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		}
		
		String[] afterpgmDescnamessort = new String[pgmDescnameafternames.size()];
		System.out.println("After sorting.." +pgmDescnameafternames.size());
		for (int i = 0; i < pgmDescnameafternames.size(); i++) {
			afterpgmDescnamessort[i] = pgmDescnameafternames.get(i).trim();
		}	
		for (String x : afterpgmDescnamessort) 
		{				
			System.out.print(x + "\n");
		}
		Assert.assertEqualsNoOrder(beforesortPgmdesAsc, afterpgmDescnamessort);
		
	}
	
	//Sorting Program Description Descending
	public void BeforeSortingPgmDescriptiondesc() {
		List<WebElement> namesElements = driver.findElements(PgmDesc);

		for(WebElement namesElement :namesElements ) {
			pgmdescDescnames.add(namesElement.getText().trim());
		}
		String nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		while(!nextbuttonclassName.contains("disabled")) {
			driver.findElement(rightarrowdynamic).click();
			namesElements = driver.findElements(PgmDesc);
			for(WebElement namesElement :namesElements ) {
				pgmdescDescnames.add(namesElement.getText());
			}
			nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		}
		for(String pgmdescDescname : pgmdescDescnames ) {
			System.out.println(pgmdescDescnames);
		}
		beforesortpgmdescdesc = new String[pgmdescDescnames.size()];
		System.out.println("Before sorting.." +pgmdescDescnames.size());
		for (int i = 0; i < pgmdescDescnames.size(); i++) {
			beforesortpgmdescdesc[i] = pgmdescDescnames.get(i).trim();
		}
		Collections.sort(pgmdescDescnames);
		Collections.reverse(pgmdescDescnames);
		System.out.println("Sorting....");
		}
			
	//Sorting AfterSort Program Description Descending
	public void AfterSortingPgmDescriptiondesc() {
		List<WebElement> namesElements = driver.findElements(PgmNames);
		List<String> descendingnames = new ArrayList<String>();
		for(WebElement namesElement :namesElements ) {
			descendingnames.add(namesElement.getText().trim());
		}
		String nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		while(!nextbuttonclassName.contains("disabled")) {
			driver.findElement(rightarrowdynamic).click();
			namesElements = driver.findElements(PgmNames);
			for(WebElement namesElement :namesElements ) {
				descendingnames.add(namesElement.getText());
			}
			nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		}
		String[] aftersortprogramDescDescend = new String[descendingnames.size()];
		System.out.println("After sorting.." +descendingnames.size());
		for (int i = 0; i < descendingnames.size(); i++) {
			aftersortprogramDescDescend[i] = descendingnames.get(i).trim();
		}
		for(String descendingname : descendingnames ) {
			System.out.println(descendingnames);
		}
		//Assert.assertEqualsNoOrder(beforesortpgmdescdesc, aftersortprogramDescDescend);
		Assert.assertEquals(descendingnames.size(), pgmdescDescnames.size());

	}
	
	
	public void beforesortingProgramStatusAsc(){

		List<WebElement> namesElements = driver.findElements(PgmStatus);

		for(WebElement namesElement :namesElements ) {
			pgmstatusnames.add(namesElement.getText().trim());
		}
		String nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		while(!nextbuttonclassName.contains("disabled")) {
			driver.findElement(rightarrowdynamic).click();
			namesElements = driver.findElements(PgmStatus);
			for(WebElement namesElement :namesElements ) {
				pgmstatusnames.add(namesElement.getText());
			}
			nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		}
//		for(String pgmstatusname : pgmstatusnames ) {
//			System.out.println(pgmstatusnames);
//		}
		beforesortPgmstatusAsc = new String[pgmstatusnames.size()];
		System.out.println("before sorting.." +pgmstatusnames.size());
		for (int i = 0; i < pgmstatusnames.size(); i++) { 
			beforesortPgmstatusAsc[i] = pgmstatusnames.get(i).trim();
		}
		System.out.println("Sorting....");
		Arrays.sort(beforesortPgmstatusAsc);

	}
			
	public void aftersortingProgramStatusAsc(){

		List<WebElement> namesElements = driver.findElements(PgmStatus);
		List<String> status = new ArrayList<String>();
		for(WebElement namesElement :namesElements ) {
			status.add(namesElement.getText().trim());
		}
		String nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		while(!nextbuttonclassName.contains("disabled")) {
			driver.findElement(rightarrowdynamic).click();
			namesElements = driver.findElements(PgmStatus);
			for(WebElement namesElement :namesElements ) {
				status.add(namesElement.getText());
			}
			nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		}
		String[] aftersortprogramStatus = new String[status.size()];
		System.out.println("After sorting.." +status.size());
		for (int i = 0; i < status.size(); i++) {
			aftersortprogramStatus[i] = status.get(i).trim();
		}	
//		for (String x : aftersortprogramStatus) 
//		{				
//			System.out.print(x + "\n");
//		}
		Assert.assertEquals(status.size(), pgmstatusnames.size());

	}
	
	
	public void beforesortingProgramStatusdesc(){

		List<WebElement> namesElements = driver.findElements(PgmStatus);

		for(WebElement namesElement :namesElements ) {
			pgmstatusdescnames.add(namesElement.getText().trim());
		}
		String nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		while(!nextbuttonclassName.contains("disabled")) {
			driver.findElement(rightarrowdynamic).click();
			namesElements = driver.findElements(PgmStatus);
			for(WebElement namesElement :namesElements ) {
				pgmstatusdescnames.add(namesElement.getText());
			}
			nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		}
		String[] beforesortPgmstatusdesc = new String[pgmstatusdescnames.size()];
		System.out.println("Before sorting.." +pgmstatusdescnames.size());
		Collections.sort(pgmstatusdescnames);
		Collections.reverse(pgmstatusdescnames);
		System.out.println("Sorting....");
//		for (String y : beforesortPgmstatusdesc) 
//		{	System.out.print(y + "\n");				
//
//		}
	}
	public void aftersortingProgramStatusdesc(){

		List<WebElement> namesElements = driver.findElements(PgmStatus);
		List<String> statusdesc = new ArrayList<String>();
		for(WebElement namesElement :namesElements ) {
			statusdesc.add(namesElement.getText().trim());
		}
		String nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		while(!nextbuttonclassName.contains("disabled")) {
			driver.findElement(rightarrowdynamic).click();
			namesElements = driver.findElements(PgmStatus);
			for(WebElement namesElement :namesElements ) {
				statusdesc.add(namesElement.getText());
			}
			nextbuttonclassName = driver.findElement(rightarrowdynamic).getAttribute("class");
		}
		String[] aftersortprogramstatusDescend = new String[statusdesc.size()];
		for (int i = 0; i < statusdesc.size(); i++) {
			aftersortprogramstatusDescend[i] = statusdesc.get(i).trim();
		}
		System.out.println("After sorting.." +statusdesc.size());
//		for(String status : statusdesc ) {
//			System.out.println(statusdesc);
//		}
		Assert.assertEquals(pgmstatusnames.size(), pgmstatusnames.size());
	}


	public void programSortClick() {
		driver.findElement(programSort).click();
	}

	public void programdescSortClick() {
		driver.findElement(programDescSort).click();
	}

	public void programstatusSortClick() {
		driver.findElement(programStatusSort).click();
	}

	public void sortingasc() {

		List<WebElement> elementList = driver.findElements(By.xpath("//tbody//tr//td[2]"));
		List<String> originalList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println(originalList);
		//Sorting Using Sorted Method without clicking sort button
		List<String>sortedList = originalList.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList);
		driver.findElement(programSort).click();
		List<String> AfterSortingList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
		System.out.println(AfterSortingList);
		Assert.assertTrue(sortedList.equals(AfterSortingList));

	}

	//Pagination

	public void firstPage() {
		driver.findElement(firstpage).click();
	}
	public boolean activePage() throws InterruptedException {
		driver.findElement(activePage).click();
		WebElement active = driver.findElement(activePage);
		Thread.sleep(1000);
		if(active.isDisplayed()) {
			return true;
		}
		return false;

	}

	public void nextpagelink() {
		driver.findElement(activePage).click();
		driver.findElement(firstpage).isDisplayed();
	}

	public void lastpagelink() {
		driver.findElement(lastArrow).click();
	}
	public void nextpagedisable() {
		WebElement nextpage = driver.findElement(nextpagedisable);
		System.out.println("Disable nextpage is displayed : " +nextpage.isDisplayed());
		String attribute = nextpage.getAttribute("class");
		System.out.println("Nextpage is disable:" +attribute.contains("disabled"));
	}

	public void leftarrowlink() {
		driver.findElement(leftArrow).click();
	}
	public void verifyfirstpagelink() {
		if (driver.findElement(doubleleftArrow).isDisplayed()) {
			String text=driver.findElement(Pages).getText();
			System.out.println(text);

		}
	}
	public void firstpageclick() {
		driver.findElement(doubleleftArrow).click();
	}

	public void checkingleftarrowdisable() {
		driver.findElement(leftarrowdisable).isDisplayed();
		driver.findElement(firstpage).isSelected();
	}

	public void batchclick() {
		driver.findElement(batch).click();
	}
	public void userclick() {
		driver.findElement(user).click();

	}
	public void logout() {
		driver.findElement(logout).click();

	}
	public void managebatchPage() {
		String batchURL = ConfigReader.getBatchUrl();
		driver.navigate().to(batchURL);
	}
	
	public void manageuserPage() {
		String userURL = ConfigReader.getUserUrl();
		driver.navigate().to(userURL);
	}
	
	public void gethomePage() {
		String login = ConfigReader.getHomePageUrl();
		driver.navigate().to(login);
	}

			
}
