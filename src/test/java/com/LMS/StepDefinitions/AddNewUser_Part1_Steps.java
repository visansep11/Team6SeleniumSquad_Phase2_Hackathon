package com.LMS.StepDefinitions;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Pages.AddNewUserPage;
import com.LMS.Utils.ConfigReader;
import com.LMS.Utils.LoggerLoad;

import io.cucumber.java.en.*;

public class AddNewUser_Part1_Steps {

	AddNewUserPage addUser=new AddNewUserPage(DriverFactory.getdriver());
	
	@Given("Admin is on Manage User Page after clicking on User")
	public void admin_is_on_manage_user_page_after_clicking_on_user() {
		//String url=ConfigReader.getManageUserPage();
		addUser=new AddNewUserPage(DriverFactory.getdriver());
		String pdTitleName=addUser.get_pageTitleName();
		Assert.assertEquals(pdTitleName, "Manage User");
	}

	
	@When("Admin clicks {string} button on Manage User")
	public void admin_clicks_button_on_manage_user(String string) {
		addUser.click_AddNewUserBtn();
		LoggerLoad.info("Admin clicked Add New User button on the Manage User page.");
	    System.out.println("Add New User button is clicked.");
	}

	@Then("Admin should see pop up open for user details with First Name,Middle name, Last Name, Location, phone, email, linkedin url, User Role, Role status, visa status,Undergraduate, postgraduate,time zone ,user comments and user fields along with Cancel , Submit and close buttons")
	public void admin_should_see_pop_up_open_for_user_details_with_first_name_middle_name_last_name_location_phone_email_linkedin_url_user_role_role_status_visa_status_undergraduate_postgraduate_time_zone_user_comments_and_user_fields_along_with_cancel_submit_and_close_buttons() {
		addUser.switch_to_popup();
		Assert.assertEquals(addUser.get_modalHeading(), "User Details"); ;
		
		Assert.assertEquals(addUser.checkField_FirstName(), true);
		Assert.assertEquals(addUser.checkField_MiddleName(), true);
  	    Assert.assertEquals(addUser.checkField_LastName(), true);
	    Assert.assertEquals(addUser.checkField_Location(), true);
	    Assert.assertEquals(addUser.checkField_PhoneNumber(), true);
	    Assert.assertEquals(addUser.checkField_Email(), true);
	    Assert.assertEquals(addUser.checkField_LinkedInUrl(), true);
	    Assert.assertEquals(addUser.checkField_UserRole(), true);
	    Assert.assertEquals(addUser.checkField_RoleStatus(), true);
	    Assert.assertEquals(addUser.checkField_VisaStatus(), true);
	    Assert.assertEquals(addUser.checkField_Undergraduate(), true);
	    Assert.assertEquals(addUser.checkField_PostGraduate(), true);
	    Assert.assertEquals(addUser.checkField_Timezone(), true);
	    Assert.assertEquals(addUser.checkField_UserComments(), true);
	    Assert.assertEquals(addUser.checkBtn_Cancel(), true);
	    Assert.assertEquals(addUser.checkBtn_Submit(), true);
	    Assert.assertEquals(addUser.checkBtn_Close(), true);
	    LoggerLoad.info("All the fields and buttons are displayed on the User Details pop up.");
	}

	@When("Admin clicks AddNewUser button")
	public void admin_clicks_addnewuser_button() {
		LoggerLoad.info("Admin clicked Add New User button on the Manage User page.");
	    System.out.println("Add New User button is clicked.");
	}
	
	@Then("Admin should see  text boxes for the fields First Name, Middle name, Last Name, Location, phone, email, linkedin url, Undergraduate, postgraduate,time zone ,user comments")
	public void admin_should_see_text_boxes_for_the_fields_first_name_middle_name_last_name_location_phone_email_linkedin_url_undergraduate_postgraduate_time_zone_user_comments() {
		Assert.assertEquals(addUser.checkTxtbx_FirstName(), true);
		Assert.assertEquals(addUser.checkTxtbx_MiddleName(), true);
  	    Assert.assertEquals(addUser.checkTxtbx_LastName(), true);
	    Assert.assertEquals(addUser.checkTxtbx_Location(), true);
	    Assert.assertEquals(addUser.checkTxtbx_PhoneNumber(), true);
	    Assert.assertEquals(addUser.checkTxtbx_Email(), true);
	    Assert.assertEquals(addUser.checkTxtbx_LinkedInUrl(), true);
	    Assert.assertEquals(addUser.checkTxtbx_Undergraduate(), true);
	    Assert.assertEquals(addUser.checkTxtbx_PostGraduate(), true);
	    Assert.assertEquals(addUser.checkTxtbx_Timezone(), true);
	    Assert.assertEquals(addUser.checkTxtbx_UserComments(), true);
	    
	    LoggerLoad.info("All the text boxes are displayed on the User Details pop up.");
	}

	@Then("Admin should see drop downs for the fields User Role, Role status, visa status on user details pop up")
	public void admin_should_see_drop_downs_for_the_fields_user_role_role_status_visa_status_on_user_details_pop_up() {
		 	Assert.assertEquals(addUser.checkDropdn_UserRole(), true);
		    Assert.assertEquals(addUser.checkDropdn_RoleStatus(), true);
		    Assert.assertEquals(addUser.checkDropdn_VisaStatus(), true);
		    
		    LoggerLoad.info("All the dropdowns are displayed on the User Details pop up.");
	}
	
}
