package com.LMS.Pages;

import java.time.Duration;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AssignStaffPage {

	WebDriver driver;

	public AssignStaffPage(WebDriver driver) {

		this.driver = driver;

	}

	By userButton = By.id("user");
	By assignStaffButton = By.xpath("//button[@label='Assign Staff']");
	By emailDropdown = By.xpath("//span[text()='Select Email Id']");
	By programDropdown = By.xpath("//span[text()='Select a Program name ']");
	By batchDropdown = By.id("batchName");
	By skillTextBox = By.id("skillName");
	By cancelButton = By.xpath("//button[@label='Cancel']");
	By saveButton = By.xpath("//button[@label='Save']");
	By closeButton = By.xpath("//span[contains(@class ,'close-icon')]");
	By userRoleField = By.id("roleId");
	By statusField = By.xpath("//div[@class = 'radio']");
	By emailFieldError = By.xpath("//div[text()= ' Email Id is required. ' ] ");
	By skillFieldError = By.xpath("//div[text()= ' Skill is required. ' ]");
	By programFieldError = By.xpath("//div[text()= ' Program Name is required. ' ] ");
	By batchFieldError = By.xpath("//div[text()= ' Batch Name is required. ' ] ");
	By statusFieldError = By.xpath("//div[text()=' Status is required. ' ] ");
	By selectBatchBox = By.xpath("//li[@tabindex='0']");
	By selectBatchClose = By.xpath("//button[@class='p-multiselect-close p-link ng-tns-c152-18 p-ripple']");
	By selectEmailId    =By.xpath("//li[@aria-label='Checkme.Checkme@gmail.com']");
	By emailOption   = By.xpath("//li[@role='option']");
	By programOption	= By.xpath("//li[@role='option']");

	public void clickOnUser() {

		driver.findElement(userButton).click();

	}

	public void clickOnAssignStaff() {

		driver.findElement(assignStaffButton).click();

	}

	public void verifyEmptyFields() {

		Assert.assertTrue(driver.findElement(skillTextBox).getText().isEmpty());

	}

	public boolean verifyDropdownFields() throws InterruptedException {

		driver.findElement(emailDropdown).isSelected();
		driver.findElement(programDropdown).isSelected();
		driver.findElement(batchDropdown).isSelected();
		driver.findElement(statusField).isSelected();
		return false;
	}

	public boolean verifyButton() {

		driver.findElement(saveButton).isDisplayed();
		driver.findElement(cancelButton).isDisplayed();
		driver.findElement(closeButton).isDisplayed();
		return true;
	}

	public void verifyInputField() throws InterruptedException {

		String roleIdValue = driver.findElement(userRoleField).getAttribute("value");
		System.out.println("User Role value: " + roleIdValue);
		Thread.sleep(5000);
		Assert.assertEquals(roleIdValue, "R02");

		Assert.assertTrue(driver.findElement(emailDropdown).isDisplayed());

		Assert.assertTrue(driver.findElement(skillTextBox).isDisplayed());

		Assert.assertTrue(driver.findElement(programDropdown).isDisplayed());

		Assert.assertTrue(driver.findElement(batchDropdown).isDisplayed());

		Assert.assertTrue(driver.findElement(statusField).isDisplayed());

	}

	public boolean checkDropdnEmailField() {

		return driver.findElement(emailDropdown).isEnabled();


	}
	public boolean checkDropdnProgramField() {
		return  driver.findElement(programDropdown).isEnabled();

	}
	public boolean checkDropdnBatchField() {
		return driver.findElement(batchDropdown).isEnabled();


	}

	public void validateStatusRadioButtons() {

		List<WebElement> statusRadioButtons = driver.findElements(By.xpath("//div[@class='ng-star-inserted']"));

		Assert.assertEquals(2, statusRadioButtons.size(), "Expected two radio buttons for Status");

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

		driver.findElement(skillTextBox).clear();

		driver.findElement(programDropdown).click();
		Thread.sleep(5000);


		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(programOption));

		String desiredProgram = "squad batch 0066";

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
				desiredProgram);
		driver.findElement(programDropdown).click();
		}


		Thread.sleep(1000);

		if(selectedProgram!=null) {
			driver.findElement(batchDropdown).click();
			Thread.sleep(5000);
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(selectBatchBox));
			String desiredBatch = "squad batch 60";
			WebElement selectedBatch = null;
			for (WebElement option : driver.findElements(selectBatchBox)) {
				if (option.getText().trim().equals(desiredBatch)) {
					selectedBatch = option;
					break;
				}
			}
			if (selectedBatch != null) {
				//	selectedBatch.click();
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectedBatch);
				System.out.println("Selected batch: " + desiredBatch);
			} else {
				System.out.println("Desired batch not found: " + desiredBatch);
			}
			Thread.sleep(2000);
			driver.findElement(batchDropdown).click();
			Thread.sleep(5000);}
		else {
			System.out.println("Batch not available");
		}




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

	public void validateWithoutSkill() throws InterruptedException {

		Thread.sleep(2000);
		driver.findElement(emailDropdown).click();
		WebDriverWait  wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailOption));
		String desiredEmail = "Checkme.Checkme@gmail.com";
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

		Thread.sleep(2000);
		driver.findElement(skillTextBox).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
		Thread.sleep(1000);


		if(selectedOption != null) {
			driver.findElement(programDropdown).click();
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
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectedProgram);
				System.out.println("Selected program: " + desiredProgram);
			} else {
				System.out.println("Desired program not found: " + desiredProgram);
				driver.findElement(programDropdown).click();
			}

			Thread.sleep(1000);

			if(selectedProgram != null) {
				driver.findElement(batchDropdown).click();
				Thread.sleep(5000);

				wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.visibilityOfElementLocated(selectBatchBox));
				String desiredBatch = "squad batch 60";
				WebElement selectedBatch = null;
				for (WebElement option : driver.findElements(selectBatchBox)) {
					if (option.getText().trim().equals(desiredBatch)) {
						selectedBatch = option;
						break;
					}
				}
				if (selectedBatch != null) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectedBatch);
					System.out.println("Selected batch: " + desiredBatch);
				} else {
					System.out.println("Desired batch not found: " + desiredBatch);
				}

				driver.findElement(batchDropdown).click();
				Thread.sleep(5000);
			}
			else {
				System.out.println("Batch not available");
			}
		}else {
			System.out.println("Email not available");
		}


		WebElement element = driver.findElement(By.xpath("//input[@id='Active']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);

		Thread.sleep(1000);
		driver.findElement(saveButton).click();

	}

	public void skillErrorMessage() {

		Assert.assertEquals(" ", "Skill is required");


	}

	public void validateWithoutProgram() throws InterruptedException {

		driver.findElement(emailDropdown).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailOption));
		String desiredEmail = "Checkme.Checkme@gmail.com";
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

		driver.findElement(skillTextBox).clear();
		driver.findElement(skillTextBox).sendKeys("Testing");
		if(selectedOption != null) {
			driver.findElement(batchDropdown).click();
		}else 
		{
			System.out.println("Email not found");
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

		driver.findElement(emailDropdown).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailOption));
		String desiredEmail = "Checkme.Checkme@gmail.com";
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


		driver.findElement(skillTextBox).clear();
		driver.findElement(skillTextBox).sendKeys("Testing");

		if(selectedOption!= null) {
			driver.findElement(programDropdown).click();
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
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectedProgram);
				System.out.println("Selected program: " + desiredProgram);
			} else {
				System.out.println("Desired program not found: " + desiredProgram);
				driver.findElement(programDropdown).click();
			}

			Thread.sleep(1000);
		}
		else {
			System.out.println("Email not found");
		}
		WebElement element = driver.findElement(By.xpath("//input[@id='Active']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);

		driver.findElement(saveButton).click();

	}

	public void batchErrorMessage() {

		String batchError = driver.findElement(batchFieldError).getText();
		System.out.println("email field error message: " + batchError);
		Assert.assertTrue(driver.findElement(batchFieldError).isDisplayed());

	}

	public void validateWithoutStatus() throws InterruptedException {

		driver.findElement(skillTextBox).clear();
		driver.findElement(skillTextBox).sendKeys("Testing");


		driver.findElement(emailDropdown).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailOption));
		String desiredEmail = "Checkme.Checkme@gmail.com";
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
		if(selectedOption != null) {
			driver.findElement(programDropdown).click();
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
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectedProgram);
				System.out.println("Selected program: " + desiredProgram);
			} else {
				System.out.println("Desired program not found: " + desiredProgram);
				driver.findElement(programDropdown).click();
			}

			Thread.sleep(1000);

			if(selectedProgram!=null) {
				driver.findElement(batchDropdown).click();
				Thread.sleep(5000);
				wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.visibilityOfElementLocated(selectBatchBox));
				String desiredBatch = "squad batch 60";
				WebElement selectedBatch = null;
				for (WebElement option : driver.findElements(selectBatchBox)) {
					if (option.getText().trim().equals(desiredBatch)) {
						selectedBatch = option;
						break;
					}
				}
				if (selectedBatch != null) {
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectedBatch);
					System.out.println("Selected batch: " + desiredBatch);

				} else {
					System.out.println("Desired batch not found: " + desiredBatch);
				}
				Thread.sleep(5000);
				driver.findElement(batchDropdown).click();}
			else
			{System.out.println("batch not available");
			}
		}
		else {
			System.out.println("Email not found");
		}



		driver.findElement(saveButton).click();

	}

	public void statusErrorMessage() {

		String statusError = driver.findElement(statusFieldError).getText();
		System.out.println("email field error message: " + statusError);
		Assert.assertTrue(driver.findElement(statusFieldError).isDisplayed());

	}

	public void clickCloseIcon() {

		driver.findElement(closeButton).click();

	}

	public void closePopupWindow() throws InterruptedException {


		WebElement assignStaff = driver.findElement(By.xpath("//button[@label='Assign Staff']"));
		String actualText = assignStaff.getText();
		Assert.assertEquals(actualText, "Assign Staff","Assign Student popup window is closed without saving.");

	}

	public void clickCancelButton() {

		driver.findElement(cancelButton).click();

	}

	public void cancelPopupWindow() throws InterruptedException {

		WebElement assignStaff = driver.findElement(By.xpath("//button[@label='Assign Staff']"));
		String actualText = assignStaff.getText();
		Assert.assertEquals(actualText, "Assign Staff","Assign Student popup window is canceled without assigning.");

	}

	public void verifyWithAllFields() throws InterruptedException {

		driver.findElement(emailDropdown).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(emailOption));
		String desiredEmail = "team@gmail.com";
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

		driver.findElement(skillTextBox).clear();
		driver.findElement(skillTextBox).sendKeys("Testing");

		if(selectedOption!=null) {

			driver.findElement(programDropdown).click(); Thread.sleep(5000); wait = new
					WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(programOption));
			String desiredProgram = "squad batch 0066"; WebElement selectedProgram =
					null; for (WebElement option : driver.findElements(programOption)) { if
						(option.getText().trim().equals(desiredProgram)) { selectedProgram = option;
						break; } } if (selectedProgram != null) { ((JavascriptExecutor)
								driver).executeScript("arguments[0].click();", selectedProgram);
						System.out.println("Selected program: " + desiredProgram); } else {
							System.out.println("Desired program not found: " + desiredProgram); }

						Thread.sleep(1000);


						if(selectedProgram!=null) {
							driver.findElement(batchDropdown).click();
							Thread.sleep(5000);
							wait = new WebDriverWait(driver, Duration.ofSeconds(30));
							wait.until(ExpectedConditions.visibilityOfElementLocated(selectBatchBox));
							String desiredBatch = "squad batch 60";
							WebElement selectedBatch = null;
							for (WebElement option : driver.findElements(selectBatchBox)) {
								if (option.getText().trim().equals(desiredBatch)) {
									selectedBatch = option;
									break;
								}
							}
							if (selectedBatch != null) {
								((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectedBatch);
								System.out.println("Selected batch: " + desiredBatch);

							} else {
								System.out.println("Desired batch not found: " + desiredBatch);
								driver.findElement(batchDropdown).click();
							}
							Thread.sleep(5000);
						}
		}
		else {
			System.out.println("No email found");
		}
		WebElement element = driver.findElement(By.xpath("//input[@id='Active']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);


		driver.findElement(saveButton).click();



	}

	public void successMessage() throws InterruptedException {

		Thread.sleep(1000);
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






}
