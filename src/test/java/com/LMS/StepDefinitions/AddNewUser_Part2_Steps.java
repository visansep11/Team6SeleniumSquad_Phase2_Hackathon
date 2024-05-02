package com.LMS.StepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Pages.AddNewUserPage;
import com.LMS.Pages.UserPageValidationPage;
import com.LMS.Utils.ConfigReader;
import com.LMS.Utils.ExcelReader;
import com.LMS.Utils.LoggerLoad;

import io.cucumber.java.en.*;

public class AddNewUser_Part2_Steps {
	AddNewUserPage addUser1=new AddNewUserPage(DriverFactory.getdriver());
	UserPageValidationPage user=new UserPageValidationPage(DriverFactory.getdriver());
	String searchname;
	
	@Given("Admin is on  User details pop up")
	public void admin_is_on_user_details_pop_up() {
		Assert.assertEquals(addUser1.get_pageUserDetailsTitle(), "User Details"); 
    LoggerLoad.info("Admin is on User Details page.");
	}

	@When("Admin enters mandatory fields in the form {string} and {int} and clicks on submit button")
	public void admin_enters_mandatory_fields_in_the_form_and_and_clicks_on_submit_button(String Sheetname, Integer RowNumber) throws InvalidFormatException, InterruptedException, IOException {
	    addUser1.EnterData_Fields(Sheetname, RowNumber);
	}

	@Then("Admin gets message User added Successfully")
	public void admin_gets_message_user_added_successfully() {
		addUser1.checkmsg_successful();
		LoggerLoad.info("Checked the message.");
	}
	
		
	@Given("Admin is on the User details pop up dialogue box")
	public void admin_is_on_the_user_details_pop_up_dialogue_box() {
		addUser1.check_pageUserDetailsPopupDisplay();
	   addUser1.click_AddNewUserBtn();
	    Assert.assertEquals(addUser1.get_pageUserDetailsTitle(), "User Details"); 
	    LoggerLoad.info("Admin is on User Details page.");
	}


	@When("Admin skips to add value in mandatory field {string} and {int}")
	public void admin_skips_to_add_value_in_mandatory_field_and(String Sheetname, Integer RowNumber) throws InvalidFormatException, InterruptedException, IOException {
	    addUser1.EnterData_Fields(Sheetname, RowNumber);
	    LoggerLoad.info("Skips all the mandatory fields values and checking");
	}

	@Then("Admin should see error message below the test field and the field will be highlighed in red color")
	public void admin_should_see_error_message_below_the_test_field_and_the_field_will_be_highlighed_in_red_color() {
	    addUser1.check_skippedDatamsg();
	    LoggerLoad.info("Error messages dispalying below the test field.");
	}

	@When("Admin enters invalid data in all of the  fields in the form {string} and {int} and clicks on submit button")
	public void admin_enters_invalid_data_in_all_of_the_fields_in_the_form_and_clicks_on_submit_button(String Sheetname, Integer RowNumber) throws InvalidFormatException, InterruptedException, IOException {
	   // addUser1.clear_UserDetailsform();
		addUser1.EnterData_Fields(Sheetname, RowNumber);
	    LoggerLoad.info("Entering invalid data in all the fields");
	}

	@Then("Admin gets error message and user is not created")
	public void admin_gets_error_message_and_user_is_not_created() {
	    //addUser1.checkmsg_failed();
	    LoggerLoad.info("Admin gets error msg");
	}

	@When("Admin clicks on submit button without entering data")
	public void admin_clicks_on_submit_button_without_entering_data() {
		addUser1.clear_UserDetailsform();
		 LoggerLoad.info("clicking submit button without entering data in any field.");
		 addUser1.clickBtn_Submit();
	}

	@Then("user will not be created and Admin gets error message")
	public void user_will_not_be_created_and_admin_gets_error_message() {
		 addUser1.check_skippedDatamsg();
		 LoggerLoad.info("Error messages are displayed below the fields on the user details page");
	}

	@When("Admin clicks Cancel or Close Icon on User Details form")
	public void admin_clicks_cancel_or_close_icon_on_user_details_form() {
	    addUser1.close_userpopup();
	}

	@Then("User Details popup window should be closed without saving")
	public void user_details_popup_window_should_be_closed_without_saving() {
	    Assert.assertEquals(addUser1.get_pageTitleName(),"Manage User");
	    LoggerLoad.info("User Details popup is closed and user is on page: "+addUser1.get_pageTitleName());
	    }

	@Given("Admin is on the User details pop up dialogue box with cancel button")
	public void admin_is_on_the_user_details_pop_up_dialogue_box_with_cancel_button() {
	    addUser1.click_AddNewUserBtn();
	    System.out.println("User is on page: "+addUser1.get_pageUserDetailsTitle());
	}

	
	@When("Admin clicks Cancel button")
	public void admin_clicks_cancel_button() {
		addUser1.cancel_userpopup();
	}

	@Then("Admin can see the User details popup disappears without adding any user")
	public void admin_can_see_the_user_details_popup_disappears_without_adding_any_user() {
		Assert.assertEquals(addUser1.get_pageTitleName(),"Manage User");
	    LoggerLoad.info("User Details popup is closed and user is on page: "+addUser1.get_pageTitleName());
	    
	}

	@When("Fill in all the fields with valid values {string} and {int} and click submit")
	public void fill_in_all_the_fields_with_valid_values_and_and_click_submit(String Sheetname, Integer RowNumber) throws InvalidFormatException, InterruptedException, IOException {
		addUser1.click_AddNewUserBtn();
		addUser1.EnterData_Fields(Sheetname, RowNumber);
		addUser1.checkmsg_successful();
	    LoggerLoad.info("Entering valid data in all the fields");
	    //searchname=addUser1.nameSearch();
	    
	}

	@Then("The newly added user should be present in the data table in Manage User page")
	public void the_newly_added_user_should_be_present_in_the_data_table_in_manage_user_page() {
		
	  String searchname=addUser1.nameSearch();
	  user.find_user(searchname);
	    user.click_UserBtn();
	}

	
}
