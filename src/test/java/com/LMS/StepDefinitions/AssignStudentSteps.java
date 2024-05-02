package com.LMS.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Pages.AssignStudentPage;
import com.LMS.Pages.LoginPage;
import com.LMS.Utils.ConfigReader;
import com.LMS.Utils.LoggerLoad;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssignStudentSteps {

	WebDriver driver = DriverFactory.getdriver();
	private LoginPage loginPage=new LoginPage(driver);
	private AssignStudentPage assignStudentPage = new AssignStudentPage(driver);

	@Given("Admin is on dashboard page after login")
	public void admin_is_on_dashboard_page_after_login() {

		driver.get(ConfigReader.getHomePageUrl());
		loginPage.loginUser();
		LoggerLoad.info("Admin logged in successfully");

	}

	@When("Admin clicks on User on the naviagtion bar")
	public void admin_clicks_on_user_on_the_naviagtion_bar() {

		assignStudentPage.clickOnUser();
		LoggerLoad.info("Admin clicks on the User on the naviagtion bar");

	}

	@Then("Admin is on User page")
	public void admin_is_on_user_page() throws InterruptedException {

		String expectedUrl = "https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/user";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		LoggerLoad.info("Validate User page URL");
	}

	@Given("Admin is in the manage user page")
	public void admin_is_in_the_manage_user_page() {

		LoggerLoad.info("Admin is on manage user page");

	}

	@When("Admin clicks on {string} button")
	public void admin_clicks_on_button(String string) throws InterruptedException {

		assignStudentPage.clickOnAssignStudent();
		LoggerLoad.info("Admin clicks on Assign student");

	}

	@Then("Admin should see a pop up open for assign student details with empty form along with Save and Cancel button and close \\(X) icon on the top right corner of the window")
	public void admin_should_see_a_pop_up_open_for_assign_student_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() throws InterruptedException {

		assignStudentPage.verifyEmptyFields();
		assignStudentPage.verifyCancelButton();
		assignStudentPage.verifySaveButton();
		assignStudentPage.verifyCloseButton();
		LoggerLoad.info("Admin verify empty form");

	}

	@Then("Admin should see User Role as R03,and other fields Student Email id,Program Name,Batch Name and Status with respective input boxes")
	public void admin_should_see_user_role_as_r03_and_other_fields_student_email_id_program_name_batch_name_and_status_with_respective_input_boxes() throws InterruptedException  {

		assignStudentPage.verifyInputField();
		LoggerLoad.info("Admin validates all field");

	}

	@Then("Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name")
	public void admin_should_see_drop_down_boxes_with_valid_datas_for_student_email_id_program_name_and_batch_name() {

		Assert.assertEquals(assignStudentPage.checkDropdnEmailField(), true);
		Assert.assertEquals(assignStudentPage.checkDropdnProgramField(), true);
		Assert.assertEquals(assignStudentPage.checkDropdnBatchField(), true);

		LoggerLoad.info("All the dropdowns are displayed pop up.");

	}

	@Then("Admin should see two radio button for Status for assign student popup")
	public void admin_should_see_two_radio_button_for_status() throws InterruptedException {

		assignStudentPage.validateStatusRadioButtons();
		LoggerLoad.info("Admin validates radio button");

	}

	@Given("Admin is in Assign Student details pop up page")
	public void admin_is_in_assign_student_details_pop_up_page() throws InterruptedException {

		Thread.sleep(5000);
		assignStudentPage.clickOnAssignStudent();
		LoggerLoad.info("Admin is in pop up page");

	}

	@When("Admin clicks {string} button without entering any data on assign student")
	public void admin_clicks_button_without_entering_any_data_on_assign_student(String string) {

		assignStudentPage.clickOnSave();
		LoggerLoad.info("Admin clicks on save");

	}

	@Then("Admin gets a Error message alert on assign student popoup")
	public void admin_gets_a_error_message_alert_on_assign_student_popoup() {

		assignStudentPage.getErrorMessage();
		LoggerLoad.info("Validates error message");


	}

	@When("Admin clicks {string} button without entering Student Email id")
	public void admin_clicks_button_without_entering_student_email_id(String string) throws InterruptedException {

		Thread.sleep(5000);
		assignStudentPage.validateWithoutEmail();
		LoggerLoad.info("Validates without entering email");
	}

	@Then("Admin gets a Error message alert as {string} under email")
	public void admin_gets_a_error_message_alert_as_under_email(String string) {

		assignStudentPage.emailErrorMessage();
		LoggerLoad.info("Validates email field error");

	}


	@When("Admin clicks {string} button without selecting program on assign student")
	public void admin_clicks_button_without_selecting_program_on_assign_student(String string) throws InterruptedException {

		assignStudentPage.validateWithoutProgram();
		LoggerLoad.info("Validates without entering Program");

	}

	@Then("Admin gets a Error message alert as {string} under prrogram")
	public void admin_gets_a_error_message_alert_as_under_prrogram(String string) {

		assignStudentPage.programErrorMessage();
		LoggerLoad.info("Validates program field error");

	}

	@When("Admin clicks {string} button without selecting batch on assign student")
	public void admin_clicks_button_without_selecting_batch_on_assign_student(String string) throws InterruptedException {

		assignStudentPage.validateWithoutBatch();
		LoggerLoad.info("Validates without entering batch");

	}

	@Then("Admin gets a Error message alert as {string} under batch")
	public void admin_gets_a_error_message_alert_as_under_batch(String string) {

		assignStudentPage.batchErrorMessage();
		LoggerLoad.info("Validates batch field error");

	}

	@When("Admin clicks {string} button without giving status on assign student")
	public void admin_clicks_button_without_giving_status_on_assign_student(String string) throws InterruptedException {

		assignStudentPage.validateWithoutStatus();
		LoggerLoad.info("Validates without entering status");

	}

	@Then("Admin gets a Error message alert as {string} under status")
	public void admin_gets_a_error_message_alert_as_under_status(String string) {

		assignStudentPage.statusErrorMessage();
		LoggerLoad.info("Validates status field error");

	}

	@When("Admin clicks Cancel or Close\\(X) Icon on Assign Student form")
	public void admin_clicks_cancel_or_close_x_icon_on_assign_student_form() {

		assignStudentPage.clickCloseIcon();
		LoggerLoad.info("Validates close icon");

	}


	@Then("Assign Student popup window should be closed without saving")
	public void assign_student_popup_window_should_be_closed_without_saving() throws InterruptedException {

		assignStudentPage.closePopupWindow();
		LoggerLoad.info("Assign Student popup window closed without saving ");

	}

	@When("Enter all the required fields with valid values and click Save button on assign student")
	public void enter_all_the_required_fields_with_valid_values_and_click_save_button_on_assign_student() throws InterruptedException {

		assignStudentPage.verifyWithAllFields();
		LoggerLoad.info("Validating with all fields");

	}

	@Then("Admin gets a message {string} alert")
	public void admin_gets_a_message_alert(String string) throws InterruptedException {

		assignStudentPage.successMessage();
		LoggerLoad.info("Admin sees alert message");

	}

	@When("Admin clicks <Cancel> button on Assign student")
	public void admin_clicks_cancel_button_on_Assign_student() {

		assignStudentPage.clickCancelButton();
		LoggerLoad.info("Validates cancel button");

	}

	@Then("Admin can see the Assign Student popup disappears without assigning")
	public void admin_can_see_the_assign_student_popup_disappears_without_assigning() throws InterruptedException {

		assignStudentPage.cancelPopupWindow();
		LoggerLoad.info("Assign student popup window disappears");

	}
	@When("Admin enters email id ,clicks {string} under assign student popup")
	public void admin_enters_email_id_clicks_under_assign_student_popup(String string) throws InterruptedException {

		assignStudentPage.changeProgram();
	}

	@Then("Admin can see alert message in assign student popup {string}")
	public void admin_can_see_alert_message_in_assign_student_popup(String string) {

		assignStudentPage.programChangeAlert();

	}

}