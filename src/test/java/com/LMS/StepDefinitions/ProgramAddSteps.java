package com.LMS.StepDefinitions;



import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Pages.LoginPage;
import com.LMS.Pages.ProgramAddPage;
import com.LMS.Utils.ConfigReader;
import com.LMS.Utils.LoggerLoad;
import io.cucumber.core.logging.Logger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramAddSteps {
	
	
	public static WebDriver driver;
	private ProgramAddPage programAddPage = new ProgramAddPage(DriverFactory.getdriver());
	private LoginPage loginPage=new LoginPage(DriverFactory.getdriver());
	
	
	
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() throws InterruptedException {
		loginPage.loginUser();
		LoggerLoad.info("Admin logged on LMS Portal");
		programAddPage.admin_clicks_program_tab();
		LoggerLoad.info("Admin is on dashboard page of program module");
		
	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String string) {
		programAddPage.add_new_program();
	}

	@Then("Admin should see URL with {string}")
	public void admin_should_see_url_with(String string) {
	    
	}


	@Given("Admin is on Manage Program Page")
	public void admin_is_on_manage_program_page() throws InterruptedException {
		loginPage.loginUser();
		LoggerLoad.info("Admin logged on LMS Portal");
		programAddPage.admin_clicks_program_tab();
		LoggerLoad.info("Admin is on dashboard page of program module");
		//programAddPage.admin_on_dashboard_page(driver);
		LoggerLoad.info("Admin has logged in and on manage program");
		
	}

	@When("Admin clicks <A New Program>button")
	public void admin_clicks_a_new_program_button() {
		programAddPage.add_new_program();
		LoggerLoad.info("Admin is creating  new program ");
		
	}

	@Then("Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_program_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
		programAddPage.admin_see_program_details();
		System.out.println("You are on Program Details Page ");
		LoggerLoad.info("Admin is on program details page");
	}
		
	@Then("Admin should see two input fields and their respective text boxes in the program details window")
	public void admin_should_see_two_input_fields_and_their_respective_text_boxes_in_the_program_details_window() {
		programAddPage.admin_see_two_inputs();
		LoggerLoad.info("Admin sees two input fields and their respective boxes");
	}

	@Then("Admin should see two radio button for Program Status")
	public void admin_should_see_two_radio_button_for_program_status() {
		programAddPage.validateStatusRadioButtons();
	   
	}

	@Given("Admin is on {string} Popup window")
	public void admin_is_on_popup_window(String string) {
		programAddPage.clicks_newprogram_popup();
		LoggerLoad.info("Admin is on program details page pop up");
	}

	@When("Admin clicks <Save>button without entering any data")
	public void admin_clicks_save_button_without_entering_any_data() {
		programAddPage.clicks_save_button();
		LoggerLoad.info("Admin clicks on Save Button");
	}

	@Then("Admin gets a Error message alert")
	public void admin_gets_a_error_message_alert() {
		programAddPage.invalid_prog_name_description();
		
	    
	}

	@When("Admin enters only<Program Name> in text box and clicks Save button")
	public void admin_enters_only_program_name_in_text_box_and_clicks_save_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin gets a message alert {string}")
	public void admin_gets_a_message_alert(String string) {
		programAddPage.get_error1_message();
		programAddPage.get_error2_message();
		LoggerLoad.info("Program name is required");
		LoggerLoad.info("Program description is required");
	}

	@When("Admin enters only<Program description> in text box and clicks Save button")
	public void admin_enters_only_program_description_in_text_box_and_clicks_save_button() {
		programAddPage.enter_program_description();
		programAddPage.clicks_save_button();
		LoggerLoad.info("Admin enters program description and saved it");
	}

	@When("Admin selects only Status and clicks Save button")
	public void admin_selects_only_status_and_clicks_save_button() throws InterruptedException {
		programAddPage.select_active_status();
		//programAddPage.select_inactive_status();
		programAddPage.clicks_save_button();
		LoggerLoad.info("Admin selects either of the status and saved it");
	}

	@When("Admin enters only numbers or special char in name and desc column")
	public void admin_enters_only_numbers_or_special_char_in_name_and_desc_column() throws InterruptedException {
		programAddPage.enter_programname_description();
		programAddPage.clicks_save_button();
	}



    @When("Admin clicks Cancel Close\\(X) Icon on Program Details form")
    public void admin_clicks_cancel_close_x_icon_on_program_details_form() {
	programAddPage.clicks_cross_button();
	LoggerLoad.info("Admin clicks Cancel Close Icon");
    }



	@Then("Program Details popup window should be closed without saving")
	public void program_details_popup_window_should_be_closed_without_saving() {
		programAddPage.clicks_cross_button();
		LoggerLoad.info("Admin closes program details popup window");
	}

	@When("Enter all the required fields with valid values and click Save button")
	public void enter_all_the_required_fields_with_valid_values_and_click_save_button() {
		
		programAddPage.clicks_save_button();
	   
	}
	
//	@When("Enter <Program Name>,<Program Description> and <Status>with valid values and click Save button")
//	public void enter_program_name_program_description_and_status_with_valid_values_and_click_save_button() {
//	    
//	}
	

//    @When("Enter Program SDET,Testing and <Status>with valid values and click Save button")
//    public void enter_program_sdet_testing_and_status_with_valid_values_and_click_save_button() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//    }



	@When("Enter {string},{string} and Status with valid values and click Save button")
	public void enter_and_status_with_valid_values_and_click_save_button(String programName, String programDescription) throws InterruptedException {
		programAddPage.add_new_prog(programName, programDescription);
	}

    
	@Then("Admin gets a message {string} alert and able to see the new program added in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_the_new_program_added_in_the_data_table(String string) {
		programAddPage.update_program_success_alert();
		LoggerLoad.info("Program created successfully");
	}

	@When("Admin clicks <Cancel>button")
	public void admin_clicks_cancel_button() {
		programAddPage.clicks_cross_button();
		LoggerLoad.info("Admin clicks cancel button");
	}

	@Then("Admin can see the Program details popup disappears without creating any program")
	public void admin_can_see_the_program_details_popup_disappears_without_creating_any_program() {
		
		LoggerLoad.info("Admin can see Program details popup disappears ");
	    
	}

	@When("Admin clicks <Edit> button on the data table for any row")
	public void admin_clicks_edit_button_on_the_data_table_for_any_row() throws InterruptedException {
		programAddPage.clicks_edit_button();
		LoggerLoad.info("Admin clicks Edit button on data table for selected row");
	}

	@Then("Admin should see a popup open for Program details to edit")
	public void admin_should_see_a_popup_open_for_program_details_to_edit() {
	   
		LoggerLoad.info("Admin sees a popup open for Program details");
		
	}

	@Given("Admin is on Program Details Popup window to Edit")
	public void admin_is_on_program_details_popup_window_to_edit() throws InterruptedException {
		programAddPage.clicks_edit_button();
		LoggerLoad.info("Admin clicks Edit button on data table for selected row");
		programAddPage.admin_see_program_details();
	}

	@When("Admin edits the Name column and clicks save button")
	public void admin_edits_the_name_column_and_clicks_save_button() throws InterruptedException {
		programAddPage.clicks_edit_name_button();
		LoggerLoad.info("Admin clicks Edit button and edits Name");
		programAddPage.clicks_save_button();
		LoggerLoad.info("Admin clicks Save");
	   
	}

	@Then("Admin gets a message {string} alert and able to see the updated name in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_name_in_the_table_for_the_particular_program(String string) {
		
	     
	}

	@When("Admin edits the Description column and clicks save button")
	public void admin_edits_the_description_column_and_clicks_save_button() throws InterruptedException {
		programAddPage.clicks_edit_description_button();
		programAddPage.clicks_save_button();
	   
	}

	@Then("Admin gets a message {string} alert and able to see the updated description in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_description_in_the_table_for_the_particular_program(String string) {
		programAddPage.update_program_success_alert();
		LoggerLoad.info("Admin gets alert Successful Updated ");
	}

	@When("Admin changes the Status and clicks save button")
	public void admin_changes_the_status_and_clicks_save_button() throws InterruptedException {
		programAddPage.select_active_status();
		programAddPage.clicks_save_button();
	    
	}

	@Then("Admin gets a message {string} alert and able to see the updated status in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_status_in_the_table_for_the_particular_program(String string) {
		programAddPage.update_program_success_alert();
		LoggerLoad.info("Admin gets alert Successful Updated ");
	  
	}

	@When("Admin clicks <Cancel>button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup() {
		programAddPage.clicks_edit_cross_button();
		LoggerLoad.info("Admin clicks <Cancel>button on edit popup ");
	}

	@Then("Admin can see the Program details popup disappears and can see nothing changed for particular program")
	public void admin_can_see_the_program_details_popup_disappears_and_can_see_nothing_changed_for_particular_program() {
		programAddPage.clicks_edit_cross_button();
		LoggerLoad.info("Admin sees Program details popup disappears  ");
	}

	@When("Admin clicks <Save>button on edit popup")
	public void admin_clicks_save_button_on_edit_popup() {
		programAddPage.clicks_save_button();
	}

	@Then("Admin gets a message {string} alert and able to see the updated details in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_details_in_the_table_for_the_particular_program(String string) {
		programAddPage.update_program_success_alert();
	}

	@Given("Admin is in Manage Program page")
	public void admin_is_in_manage_program_page() {
		LoggerLoad.info("Admin is on manage program");
	}

	@When("Admin clicks any checkbox in the data table")
	public void admin_clicks_any_checkbox_in_the_data_table() {
		programAddPage.click_check_box1();
	}

	@Then("Admin should see common delete option enabled under header Manage Program")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_program() {
		programAddPage.comman_delete_icon();
	}

	@Given("Admin is on Confirm Deletion alert")
	public void admin_is_on_confirm_deletion_alert() throws InterruptedException {
		   programAddPage.clicks_multiple_delete_button1();
		 
		   LoggerLoad.info("Admin clicks confirm deletion alert");
	    
	}

	@When("Admin clicks <NO> button on the alert")
	public void admin_clicks_no_button_on_the_alert() throws InterruptedException {
		   programAddPage.click_NO_button();
		   LoggerLoad.info("Admin clicks NO button alert ");
	}

	@Then("Admin should land on Manage Program page and can see the selected program is not deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_not_deleted_from_the_data_table() throws InterruptedException {
		
		LoggerLoad.info("Admin should land on Manage Program page");
	}

	@When("Admin clicks <YES> button on the alert")
	public void admin_clicks_yes_button_on_the_alert() throws InterruptedException {
		programAddPage.click_YES_button();
	}

	@Then("Admin should land on Manage Program page and can see the selected program is deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_program_is_deleted_from_the_data_table() {
		LoggerLoad.info("Admin lands on Manage Program Page and selected program is deleted");
	}

	@Then("Admin should land on Manage Program page and can see the selected programs are deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_deleted_from_the_data_table() {
		LoggerLoad.info("Admin lands on Manage Program Page and multiple programs are deleted");
	}

	@Then("Admin should land on Manage Program page and can see the selected programs are not deleted from the data table")
	public void admin_should_land_on_manage_program_page_and_can_see_the_selected_programs_are_not_deleted_from_the_data_table() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	

}

	
	
