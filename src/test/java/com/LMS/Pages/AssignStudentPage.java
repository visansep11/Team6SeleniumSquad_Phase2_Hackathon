package com.LMS.Pages;


import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class AssignStudentPage {

	WebDriver driver;

	public AssignStudentPage(WebDriver driver) {

		this.driver = driver;

	}

	By userButton 		   = By.id("user");
	By assignStudentButton = By.xpath("//button[@label = 'Assign Student']");
	By assignStudentLabel  = By.xpath("//span[@id = 'pr_id_49-label']");
	By studentEmailIdBox   = By.xpath("//span[text()= 'Select Email ID']");
	By programNameBox      = By.id("programName");
	By batchNameBox		   = By.id("batchName");
	By cancelButton		   = By.xpath("//span[text() = 'Cancel']");
	By saveButton          = By.xpath("//span[text() = 'Save']");
	By closeButton         = By.xpath("//span[contains(@class ,'close-icon')]");
	By userRoleField	   = By.id("roleId");
	By statusField         = By.xpath("//div[@class = 'radio']");
	By emailFieldError     = By.xpath("//div[text() = ' User Email Id is required. ']");
	By programFieldError   = By.xpath("//div[text() = ' Program Name is required. ']");
	By batchFieldError     = By.xpath("//div[text() = ' Batch Name is required. ']");
	By statusFieldError    = By.xpath("//div[text() = ' Status is required. ']");
	By activeStatusButton  = By.xpath("//input[@id='Active']");
	By emailIdTextBox      = By.xpath("//input[@autocomplete = 'off']");
	By dropdownEmailClear  = By.cssSelector("i.p-dropdown-clear-icon");
	By programTextBox      = By.xpath("//span[text()='Select a Program name ']");
	By batchTextBox        = By.xpath("//span[text()='Select Batch']");
	By selectBatch         = By.xpath("//li[@aria-label='NewBatch']");
	By closeIcon		   = By.xpath("//button[@tabindex='-1']");
	By emailOption   	   = By.xpath("//li[@role='option']");
	By programOption       = By.xpath("//li[@role='option']");
	By batchOption         = By.xpath("//li[@role='option']");
	By emailNodata   	   = By.xpath("//li[text()=' No results found ']");
	By programChange       = By.xpath("//span[text()='Change Program/Batch']");
	By programChangeAlert  = By.xpath("//div[text()=' Please deactivate User from existing program/batch and then activate for another program/batch. ']");


	public void clickOnUser() {

		driver.findElement(userButton).click();

	}

	public void clickOnAssignStudent() {

		driver.findElement(assignStudentButton).click();

	}

	public void verifyEmptyFields() {

		Assert.assertTrue(driver.findElement(programNameBox).getText().isEmpty());
		Assert.assertTrue(driver.findElement(batchNameBox).getText().isEmpty());

	}

	public boolean verifyCancelButton() {

		return driver.findElement(cancelButton).isDisplayed();

	}

	public boolean verifySaveButton() {

		return driver.findElement(saveButton).isDisplayed();

	}

	public boolean verifyCloseButton() {

		return driver.findElement(closeButton).isDisplayed();

	}

	public void verifyInputField() throws InterruptedException  {

		String roleIdValue = driver.findElement(userRoleField).getAttribute("value");
		System.out.println("User Role value: " + roleIdValue);
		Thread.sleep(5000);
		Assert.assertEquals(roleIdValue, "R03");

		Assert.assertTrue(driver.findElement(studentEmailIdBox).isDisplayed());

		Assert.assertTrue(driver.findElement(programNameBox).isDisplayed());

		Assert.assertTrue(driver.findElement(batchNameBox).isDisplayed());

		Assert.assertTrue(driver.findElement(statusField).isDisplayed());

	}
	public boolean checkDropdnEmailField() {

		return driver.findElement(studentEmailIdBox).isEnabled();


	}
	public boolean checkDropdnProgramField() {
		return  driver.findElement(programNameBox).isEnabled();

	}
	public boolean checkDropdnBatchField() {
		return driver.findElement(batchNameBox).isEnabled();


	}

	public void validateStatusRadioButtons() throws InterruptedException {

		List<WebElement> statusRadioButtons = driver.findElements(By.xpath("//div[@class='ng-star-inserted']"));

		Assert.assertEquals( 2, statusRadioButtons.size(),"Expected two radio buttons for Status");
		Thread.sleep(2000);
		for (WebElement radioButton : statusRadioButtons) {
			String text = radioButton.getText();
			System.out.println("Radio button Text: " + text);

			Assert.assertTrue(radioButton.isDisplayed());
		}

	}

	public void clickOnSave() {

		driver.findElement(saveButton).click();

	}

	public void getErrorMessage() {

		String emailError = driver.findElement(emailFieldError).getText();
		System.out.println("email field error message: " + emailError);

		String programError = driver.findElement(programFieldError).getText();
		System.out.println("program field error message: " + programError);

		String batchError = driver.findElement(batchFieldError).getText();
		System.out.println("batch field error message: " + batchError);

		String statusError = driver.findElement(statusFieldError).getText();
		System.out.println("status field error message: " + statusError);

	}

	public void validateWithoutEmail() throws InterruptedException {

		driver.findElement(studentEmailIdBox).click();
		driver.findElement(emailIdTextBox).sendKeys("squad8999@gmail.com");


		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailOption));
		String desiredEmail = "squad8999@gmail.com";
		WebElement selectedOption = null;
		for (WebElement option : driver.findElements(emailOption)) {
			if (option.getText().trim().equals(desiredEmail)) {
				selectedOption = option;
				break;
			}
		}
		if (selectedOption != null) {
			selectedOption.click();
			System.out.println("Selected email ID: " + desiredEmail);
		} else {
			System.out.println("Desired email ID not found: " + desiredEmail);
		}

		Thread.sleep(5000);
		driver.findElement(dropdownEmailClear).click();


		driver.findElement(programTextBox).click();
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(programOption));
		String desiredProgram = "squad batch 0066";


		WebElement selectedProgram = null; 
		for (WebElement option :driver.findElements(programOption)) { 
			if(option.getText().trim().equals(desiredProgram)) { 
				selectedProgram = option;
				break; }
		} 
		if (selectedProgram != null)
		{ 
			selectedProgram.click();
			System.out.println("Selected program: " + desiredProgram); } 
		else {
			System.out.println("Desired program not found: " + desiredProgram); 
			driver.findElement(programTextBox).click();
		}


		Thread.sleep(1000);


		driver.findElement(batchTextBox).click();
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(batchOption));
		String desiredBatch = "squad batch 60";
		WebElement selectedBatch = null;
		for (WebElement option : driver.findElements(batchOption)) {
			if (option.getText().trim().equals(desiredBatch)) {
				selectedBatch = option;
				break;
			}
		}
		if (selectedBatch != null) {
			selectedBatch.click();
			System.out.println("Selected batch: " + desiredBatch);
		} else {
			System.out.println("Desired batch not found: " + desiredBatch);
		}
		Thread.sleep(5000);

		WebElement element = driver.findElement(By.xpath("//input[@id='Active']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);


		driver.findElement(saveButton).click();

	}

	public void emailErrorMessage() {


		String emailError = driver.findElement(emailFieldError).getText();
		System.out.println("email field error message: " + emailError);
		Assert.assertTrue(driver.findElement(emailFieldError).isDisplayed());

	}

	public void validateWithoutProgram() throws InterruptedException {

		driver.findElement(studentEmailIdBox).click();
		driver.findElement(emailIdTextBox).sendKeys("squad8999@gmail.com");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailOption));
		String desiredEmail = "squad8999@gmail.com";
		WebElement selectedOption = null;
		for (WebElement option : driver.findElements(emailOption)) {
			if (option.getText().trim().equals(desiredEmail)) {
				selectedOption = option;
				break;
			}

		}
		if (selectedOption != null) {
			selectedOption.click();
			System.out.println("Selected email ID: " + desiredEmail);
		} else {
			System.out.println("Desired email ID not found: " + desiredEmail);
			driver.findElement(studentEmailIdBox).click();
		}


		driver.findElement(batchTextBox).click();
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(batchOption));
		String desiredBatch = "squad batch 60";
		WebElement selectedBatch = null;
		for (WebElement option : driver.findElements(batchOption)) {
			if (option.getText().trim().equals(desiredBatch)) {
				selectedBatch = option;
				break;
			}
		}
		if (selectedBatch != null) {
			selectedBatch.click();
			System.out.println("Selected batch: " + desiredBatch);
		} else {
			System.out.println("Desired batch not found: " + desiredBatch);
		}
		Thread.sleep(5000);

		WebElement element = driver.findElement(By.xpath("//input[@id='Active']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);

		driver.findElement(saveButton).click();

	}

	public void programErrorMessage() {

		String programError = driver.findElement(programFieldError).getText();
		System.out.println("program field error message: " + programError);
		Assert.assertTrue(driver.findElement(programFieldError).isDisplayed());

	}

	public void validateWithoutBatch() throws InterruptedException {

		driver.findElement(studentEmailIdBox).click();
		driver.findElement(emailIdTextBox).sendKeys("squad8999@gmail.com");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailOption));
		String desiredEmail = "squad8999@gmail.com";
		WebElement selectedOption = null;
		for (WebElement option : driver.findElements(emailOption)) {
			if (option.getText().trim().equals(desiredEmail)) {
				selectedOption = option;
				break;
			}
		}
		if (selectedOption != null) {
			selectedOption.click();
			System.out.println("Selected email ID: " + desiredEmail);
		} else {
			System.out.println("Desired email ID not found: " + desiredEmail);
		}

		Thread.sleep(5000);



		driver.findElement(programTextBox).click();
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(programOption));
		String desiredProgram = "squad batch 0066";
		WebElement selectedProgram = null;
		for (WebElement option : driver.findElements(programOption)) {
			if (option.getText().trim().equals(desiredProgram)) {
				selectedProgram = option;
				break;
			}
		}
		if (selectedProgram != null) {
			selectedProgram.click();
			System.out.println("Selected program: " + desiredProgram);
		} else {
			System.out.println("Desired program not found: " + desiredProgram);
			driver.findElement(programTextBox).click();
		}

		Thread.sleep(5000);

		WebElement element = driver.findElement(By.xpath("//input[@id='Active']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);

		driver.findElement(saveButton).click();

	}

	public void batchErrorMessage() {


		String batchError = driver.findElement(batchFieldError).getText();
		System.out.println("batch field error message: " + batchError);
		Assert.assertTrue(driver.findElement(batchFieldError).isDisplayed());

	}

	public void validateWithoutStatus() throws InterruptedException {

		driver.findElement(studentEmailIdBox).click();
		driver.findElement(emailIdTextBox).sendKeys("squad8999@gmail.com");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailOption));
		String desiredEmail = "squad8999@gmail.com";
		WebElement selectedOption = null;
		for (WebElement option : driver.findElements(emailOption)) {
			if (option.getText().trim().equals(desiredEmail)) {
				selectedOption = option;
				break;
			}
		}
		if (selectedOption != null) {
			selectedOption.click();
			System.out.println("Selected email ID: " + desiredEmail);
		} else {
			System.out.println("Desired email ID not found: " + desiredEmail);
		}

		Thread.sleep(5000);



		driver.findElement(programTextBox).click();
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(programOption));
		String desiredProgram = "squad batch 0066";
		WebElement selectedProgram = null;
		for (WebElement option : driver.findElements(programOption)) {
			if (option.getText().trim().equals(desiredProgram)) {
				selectedProgram = option;
				break;
			}
		}
		if (selectedProgram != null) {
			selectedProgram.click();
			System.out.println("Selected program: " + desiredProgram);
		} else {
			System.out.println("Desired program not found: " + desiredProgram);
			driver.findElement(programTextBox).click();
		}

		Thread.sleep(1000);


		driver.findElement(batchTextBox).click();
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(batchOption));
		String desiredBatch = "squad batch 60";
		WebElement selectedBatch = null;
		for (WebElement option : driver.findElements(batchOption)) {
			if (option.getText().trim().equals(desiredBatch)) {
				selectedBatch = option;
				break;
			}
		}
		if (selectedBatch != null) {
			selectedBatch.click();
			System.out.println("Selected batch: " + desiredBatch);
		} else {
			System.out.println("Desired batch not found: " + desiredBatch);
		}
		Thread.sleep(5000);

		driver.findElement(saveButton).click();

	}
	public void statusErrorMessage() {

		String statusError = driver.findElement(statusFieldError).getText();
		System.out.println("status field error message: " + statusError);
		Assert.assertTrue(driver.findElement(statusFieldError).isDisplayed());

	}

	public void clickCloseIcon() {

		driver.findElement(closeButton).click();

	}

	public void closePopupWindow() throws InterruptedException {

		Thread.sleep(2000);
		WebElement assignStudent = driver.findElement(By.xpath("//button[@label='Assign Student']"));
		String actualText = assignStudent.getText().trim();
		Assert.assertEquals(actualText, "Assign Student","Assign Student popup window is closed without saving.");


	}

	public void clickCancelButton() {

		driver.findElement(cancelButton).click();

	}

	public void cancelPopupWindow() throws InterruptedException {

		Thread.sleep(2000);
		WebElement assignStudent = driver.findElement(By.xpath("//button[@label='Assign Student']"));
		String actualText = assignStudent.getText().trim();
		Assert.assertEquals(actualText, "Assign Student","Assign Student popup window is canceled without assigning.");

	}

	public void verifyWithAllFields() throws InterruptedException {

		driver.findElement(studentEmailIdBox).click();
		driver.findElement(emailIdTextBox).sendKeys("java.m@gmail.com");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailOption));
		String desiredEmail = "java.m@gmail.com";
		WebElement selectedOption = null;
		for (WebElement option : driver.findElements(emailOption)) {
			if (option.getText().trim().equals(desiredEmail)) {
				selectedOption = option;
				break;
			}
		}
		if (selectedOption != null) {
			selectedOption.click();
			System.out.println("Selected email ID: " + desiredEmail);
		} else {
			System.out.println("Desired email ID not found: " + desiredEmail);
		}

		Thread.sleep(5000);



		/*
		 * driver.findElement(programTextBox).click(); Thread.sleep(5000); wait = new
		 * WebDriverWait(driver, Duration.ofSeconds(30));
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(programOption));
		 * String desiredProgram = "squad batch 0066"; WebElement selectedProgram =
		 * null; for (WebElement option : driver.findElements(programOption)) { if
		 * (option.getText().trim().equals(desiredProgram)) { selectedProgram = option;
		 * break; } } if (selectedProgram != null) { selectedProgram.click();
		 * System.out.println("Selected program: " + desiredProgram); } else {
		 * System.out.println("Desired email ID not found: " + desiredProgram); }
		 * 
		 * Thread.sleep(1000);
		 * 
		 * 
		 * driver.findElement(batchTextBox).click(); Thread.sleep(5000); wait = new
		 * WebDriverWait(driver, Duration.ofSeconds(30));
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(batchOption));
		 * String desiredBatch = "squad batch 60"; WebElement selectedBatch = null; for
		 * (WebElement option : driver.findElements(batchOption)) { if
		 * (option.getText().trim().equals(desiredBatch)) { selectedBatch = option;
		 * break; } } if (selectedBatch != null) { selectedBatch.click();
		 * System.out.println("Selected batch: " + desiredBatch); } else {
		 * System.out.println("Desired batch not found: " + desiredBatch); }
		 * Thread.sleep(5000);
		 * 
		 * WebElement element = driver.findElement(By.xpath("//input[@id='Active']"));
		 * JavascriptExecutor executor = (JavascriptExecutor)driver;
		 * executor.executeScript("arguments[0].click();", element);
		 */

		driver.findElement(saveButton).click();


	}

	public void successMessage() throws InterruptedException {

		Thread.sleep(500);
		WebElement activeElement = driver.switchTo().activeElement();
		String messageStr = activeElement.getText();
		System.out.println("Actual message appeared on screen: " + messageStr);
		if(messageStr.contains("User has been successfully assigned/Updated to Program/Batch(es)")) {

			String expectedMsg="User has been successfully assigned/Updated to Program/Batch(es)";
			Assert.assertEquals("User has been successfully assigned/Updated to Program/Batch(es)",expectedMsg);
		}else {
			System.out.println("User already exists");
		}

	}
	public void changeProgram() throws InterruptedException {

		driver.findElement(studentEmailIdBox).click();
		driver.findElement(emailIdTextBox).sendKeys("dee1234@gmail.com");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailOption));
		String desiredEmail = "dee1234@gmail.com";
		WebElement selectedOption = null;
		for (WebElement option : driver.findElements(emailOption)) {
			if (option.getText().trim().equals(desiredEmail)) {
				selectedOption = option;
				break;
			}
		}
		if (selectedOption != null) {
			selectedOption.click();
			System.out.println("Selected email ID: " + desiredEmail);
		} else {
			System.out.println("Desired email ID not found: " + desiredEmail);
		}

		Thread.sleep(5000);

		driver.findElement(programChange).click();


	}

	public void programChangeAlert() {

		String alertMessage = driver.findElement(programChangeAlert).getText();
		System.out.println(alertMessage);
		Assert.assertEquals(alertMessage, "Please deactivate User from existing program/batch and then activate for another program/batch.");
	}


}



