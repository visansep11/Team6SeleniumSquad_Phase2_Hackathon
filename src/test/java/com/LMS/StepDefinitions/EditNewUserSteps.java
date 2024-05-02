package com.LMS.StepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Pages.EditNewUserPage;
import com.LMS.Pages.UserPage;
import com.LMS.Pages.UserPageValidationPage;
import com.LMS.Utils.LoggerLoad;

import io.cucumber.java.en.*;

public class EditNewUserSteps {
	UserPageValidationPage userpg=new UserPageValidationPage(DriverFactory.getdriver());
	EditNewUserPage editpg=new EditNewUserPage(DriverFactory.getdriver());
		
	@Given("Admin is on ManageUser Page after clicking on User button")
	public void admin_is_on_manage_user_page_after_clicking_on_user_button() {
	    userpg.click_UserBtn();
	    Assert.assertEquals(userpg.get_pageTitleName(), "Manage User");
	}

	@When("Admin clicks on the edit icon on manage user page")
	public void admin_clicks_on_the_edit_icon_on_manage_user_page() {
	    userpg.find_user("Optionalupfirst");
		userpg.click_editIcon();
	}

	@Then("A new pop up with edit User details appears")
	public void a_new_pop_up_with_edit_user_details_appears() {
	   Assert.assertEquals(editpg.get_pageEditUserDetailsTitle(),"User Details");
	   LoggerLoad.info("Admin is on page: "+editpg.get_pageEditUserDetailsTitle());
	}

	@Given("Admin is on edit User details pop up")
	public void admin_is_on_edit_user_details_pop_up() {
		Assert.assertEquals(editpg.get_pageEditUserDetailsTitle(),"User Details");
		LoggerLoad.info("Admin is on page: "+editpg.get_pageEditUserDetailsTitle());
	}

	@When("Update the fields with valid data {string} and {int} click submit on edit user")
	public void update_the_fields_with_valid_data_and_click_submit_on_edit_user(String sheetName, Integer rowNumber) throws InvalidFormatException, InterruptedException, IOException {
	    editpg.EnterData_Fields(sheetName, rowNumber);
	}

	@Then("Admin gets message {string} and see the updated values in data table in edit user {string} and {int}")
	public void admin_gets_message_and_see_the_updated_values_in_data_table_in_edit_user(String string,String sheetName, Integer rowNumber) throws InvalidFormatException, InterruptedException, IOException {
	   editpg.checkmsg_successful();
	   editpg.check_pageUserDetailsPopupDisplay();
	   String searchname=editpg.nameSearch(sheetName, rowNumber);
	   userpg.find_user(searchname);
	   userpg.clear_serachedText();
	}

	@Given("Admin is on edit User details pop up dialog")
	public void admin_is_on_edit_user_details_pop_up_dialog() {
//		 String searchname=editpg.nameSearch();
	userpg.find_user("Squadfirst");
		userpg.click_editIcon();
	}
	
	@When("Update the fields with invalid values {string} and {int} and click submit on edit user popup")
	public void update_the_fields_with_invalid_values_and_and_click_submit_on_edit_user_popup(String sheetName, Integer rowNumber) throws InvalidFormatException, InterruptedException, IOException {
		editpg.EnterData_Fields(sheetName, rowNumber);
	}

	@Then("Admin should get Error message {string} and {int}")
	public void admin_should_get_error_message(String sheetName, Integer rowNumber) throws InvalidFormatException, InterruptedException, IOException {
	    editpg.checkmsg_failed();
	    editpg.check_pageUserDetailsPopupDisplay();
	    String searchname=editpg.nameSearch(sheetName, rowNumber);
		   userpg.find_user(searchname);
		   userpg.clear_serachedText();
	    
	}

	@When("Update the mandatory fields with valid values {string} and {int} and click submit in the edit popup")
	public void update_the_mandatory_fields_with_valid_values_and_click_submit_in_the_edit_popup(String sheetName, Integer rowNumber) throws InvalidFormatException, InterruptedException, IOException {
		editpg.EnterData_Fields(sheetName, rowNumber);
	   
	}

	@When("the values in optional filds updated with valid data {string} and {int} in the edit user popup")
	public void the_values_in_optional_filds_updated_with_valid_data_in_the_edit_user_popup(String sheetName, Integer rowNumber) throws InvalidFormatException, InterruptedException, IOException {
		editpg.EnterData_Fields(sheetName, rowNumber); 
	}

	@When("enters only numbers or special char in the text fields in the edit new User popup {string} and {int}")
	public void enters_only_numbers_or_special_char_in_the_text_fields_in_the_edit_new_user_popup_and(String sheetName, Integer rowNumber) throws InvalidFormatException, InterruptedException, IOException {
		editpg.EnterData_Fields(sheetName, rowNumber);
	}

	@Then("Admin should get Error message for edit user in edit New User {string} and {int}")
	public void admin_should_get_error_message_for_edit_user_in_edit_new_user_and(String sheetName, Integer rowNumber) throws InvalidFormatException, InterruptedException, IOException {
		editpg.checkmsg_failed();
		editpg.check_skippedDatamsg();
//	    
	}
	
	@When("Admin clicks Cancel button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup() {
	    editpg.cancel_userpopup();
	}

	@Then("Admin can see the edit User details popup disappears and can see nothing changed for particular User {string} and {int}")
	public void admin_can_see_the_edit_user_details_popup_disappears_and_can_see_nothing_changed_for_particular_user_and(String sheetName, Integer rowNumber) throws InvalidFormatException, InterruptedException, IOException {
		String searchname=editpg.nameSearch(sheetName, rowNumber);
		   userpg.find_user(searchname);
		   userpg.clear_serachedText();
	   
	}

	
	
	
}