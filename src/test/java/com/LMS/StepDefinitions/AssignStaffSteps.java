package com.LMS.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Pages.AssignStaffPage;
import com.LMS.Pages.LoginPage;
import com.LMS.Utils.ConfigReader;
import com.LMS.Utils.LoggerLoad;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AssignStaffSteps {
	
	WebDriver driver = DriverFactory.getdriver();
	private LoginPage loginPage=new LoginPage(driver);
	private AssignStaffPage assignStaffPage = new AssignStaffPage(driver);

	@Given("Admin is on the dashboard page after login")
	public void admin_is_on_the_dashboard_page_after_login() {
	    
		driver.get(ConfigReader.getHomePageUrl());
		loginPage.loginUser();
		LoggerLoad.info("Admin logged in successfully");
		
	}

	@When("Admin clicks on the User on the naviagtion bar")
	public void admin_clicks_on_the_user_on_the_naviagtion_bar() {
	    
	   assignStaffPage.clickOnUser();
	   LoggerLoad.info("Admin clicks on the User on the naviagtion bar");
	}

	@Then("Admin is on the User page")
	public void admin_is_on_the_user_page() {
	    
		String expectedUrl = "https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/user";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);
		LoggerLoad.info("Validate User page URL");
	   
	}

	@Given("Admin is on the Manage user page")
	public void admin_is_on_the_manage_user_page() {
	    
		LoggerLoad.info("Admin is on manage user page");
		
	}

	@When("Admin clicks {string} button")
	public void admin_clicks_button(String string) {
	    
		assignStaffPage.clickOnAssignStaff();
	   LoggerLoad.info("Admin clicks on Assign staff");
	}

	@Then("Admin should see a pop up open for assign staff details with empty form along with Save and Cancel button and close \\(X) icon on the top right corner of the window")
	public void admin_should_see_a_pop_up_open_for_assign_staff_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() throws InterruptedException {
	    
		assignStaffPage.verifyEmptyFields();
		assignStaffPage.verifyButton();
		assignStaffPage.verifyDropdownFields();
		LoggerLoad.info("Admin verify empty form");
		
	}

	@Then("Admin should see User Role as R02,and other fields Student Email id,Skill,Program Name,Batch Name and Status with respective input boxes.")
	public void admin_should_see_user_role_as_r02_and_other_fields_student_email_id_skill_program_name_batch_name_and_status_with_respective_input_boxes() throws InterruptedException {
	    
	   assignStaffPage.verifyInputField();
	   LoggerLoad.info("Admin validates all field");
	   
	}

	@Then("Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name in assign staff")
	public void admin_should_see_drop_down_boxes_with_valid_datas_for_student_email_id_program_name_and_batch_name_in_assign_staff() {
	    
		Assert.assertEquals(assignStaffPage.checkDropdnEmailField(), true);
	    Assert.assertEquals(assignStaffPage.checkDropdnProgramField(), true);
	    Assert.assertEquals(assignStaffPage.checkDropdnBatchField(), true);
	    
	    LoggerLoad.info("All the dropdowns are displayed pop up.");
		
	   
	}

	@Then("Admin should see two radio button for Status in assign staff")
	public void admin_should_see_two_radio_button_for_status_in_assign_staff() {
	    
		assignStaffPage.validateStatusRadioButtons();
		LoggerLoad.info("Admin validates radio button");
		
	}

	@Given("Admin is in Assign Staff details pop up page")
	public void admin_is_in_assign_staff_details_pop_up_page() throws InterruptedException {
	    
		Thread.sleep(5000);
		assignStaffPage.clickOnAssignStaff();
		LoggerLoad.info("Admin is in pop up page");
		
	}

	@When("Admin clicks {string} button without entering any data in Assign Staff window")
	public void admin_clicks_button_without_entering_any_data_in_assign_staff_window(String string) {
	    
		assignStaffPage.clickOnSave();
		LoggerLoad.info("Admin clicks on save");
	   
	}

	@Then("Admin gets a Error message alert under each field in Assign Staff window")
	public void admin_gets_a_error_message_alert_under_each_field_in_assign_staff_window() {
	    
	   assignStaffPage.getErrorMessage();
	   LoggerLoad.info("Validates error message");
	   
	}

	@When("Admin clicks {string} button without entering Student Email id in assign popup")
	public void admin_clicks_button_without_entering_student_email_id_in_assign_popup(String string) throws InterruptedException {
	    
	   assignStaffPage.validateWithoutEmail();
	   LoggerLoad.info("Validates without entering email");
	   
	}

	@Then("Admin gets a Error message alert as {string} under email in assign staff popup")
	public void admin_gets_a_error_message_alert_as_under_email_in_assign_staff_popup(String string) {
	    
	   assignStaffPage.emailErrorMessage();
	   LoggerLoad.info("Validates email field error");
	   
	}

	@When("Admin clicks {string} button without entering Skill")
	public void admin_clicks_button_without_entering_skill(String string) throws InterruptedException {
	    
		assignStaffPage.validateWithoutSkill();
		LoggerLoad.info("Validates without entering skill");
	   
	}

	@Then("Admin gets a Error message alert as {string} in assign staff popup")
	public void admin_gets_a_error_message_alert_as_in_assign_staff_popup(String string) {
	    
	   assignStaffPage.skillErrorMessage();
	   LoggerLoad.info("Validates skill field error");
	   
	}

	@When("Admin clicks {string} button without selecting program in assign staff")
	public void admin_clicks_button_without_selecting_program_in_assign_staff(String string) throws InterruptedException {
	    
	   assignStaffPage.validateWithoutProgram();
	   LoggerLoad.info("Validates without entering Program");
	   
	}

	@Then("Admin gets a Error message alert as {string} under program in assign staff")
	public void admin_gets_a_error_message_alert_as_under_program_in_assign_staff(String string) {
	    
	   assignStaffPage.programErrorMessage();
	   LoggerLoad.info("Validates program field error");
	}

	@When("Admin clicks {string} button without selecting batch in assign staff")
	public void admin_clicks_button_without_selecting_batch_in_assign_staff(String string) throws InterruptedException {
	    
		assignStaffPage.validateWithoutBatch();
		LoggerLoad.info("Validates without entering batch");
	   
	}

	@Then("Admin gets a Error message alert as {string} under batch in assign staff")
	public void admin_gets_a_error_message_alert_as_under_batch_in_assign_staff(String string) {
	    
		assignStaffPage.batchErrorMessage();
		LoggerLoad.info("Validates batch field error");
	   
	}

	@When("Admin clicks {string} button without giving status in assign staff")
	public void admin_clicks_button_without_giving_status_in_assign_staff(String string) throws InterruptedException {
	    
	   assignStaffPage.validateWithoutStatus();
	   LoggerLoad.info("Validates without entering status");
	   
	}

	@Then("Admin gets a Error message alert as {string} under status in assign staff")
	public void admin_gets_a_error_message_alert_as_under_status_in_assign_staff(String string) {
	    
	   assignStaffPage.statusErrorMessage();
	   LoggerLoad.info("Validates status field error");
	   
	}

	@When("Admin clicks on Cancel\\/Close X Icon on Assign Staff form")
	public void admin_clicks_on_cancel_close_x_icon_on_assign_staff_form() {
	    
	   assignStaffPage.clickCloseIcon();
	   LoggerLoad.info("Validates close icon");
	}

	@Then("Assign Staff popup window should be closed without saving")
	public void assign_staff_popup_window_should_be_closed_without_saving() throws InterruptedException {
	    
	   assignStaffPage.closePopupWindow();
	   LoggerLoad.info("Assign Staff popup window closed without saving ");
	   
	}

	@When("Enter all the required fields with valid values and click Save button in assign staff")
	public void enter_all_the_required_fields_with_valid_values_and_click_save_button_in_assign_staff() throws InterruptedException {
	    
	   assignStaffPage.verifyWithAllFields();
	   LoggerLoad.info("Validating with all fields");
	}

	@Then("Admin gets a message {string} alert after assigning staff")
	public void admin_gets_a_message_alert_after_assigning_staff(String string) throws InterruptedException {
	    
	   assignStaffPage.successMessage();
	   LoggerLoad.info("Admin sees alert message");
	   
	}

	@When("Admin clicks <Cancel> button in assign staff")
	public void admin_clicks_cancel_button_in_assign_staff() {
	    
	   assignStaffPage.clickCancelButton();
	   LoggerLoad.info("Validates cancel button");
	   
	}

	@Then("Admin can see the Assign Staff popup disappears without assigning")
	public void admin_can_see_the_assign_staff_popup_disappears_without_assigning() throws InterruptedException {
	    
	   assignStaffPage.cancelPopupWindow();
	   LoggerLoad.info("Assign staff popup window disappears");
	   
	}


}
