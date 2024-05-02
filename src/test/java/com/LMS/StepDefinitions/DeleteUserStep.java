package com.LMS.StepDefinitions;

import org.testng.Assert;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Pages.UserPageValidationPage;
import com.LMS.Utils.LoggerLoad;

import io.cucumber.java.en.*;

public class DeleteUserStep {
	UserPageValidationPage userPage=new UserPageValidationPage(DriverFactory.getdriver());
	
	@When("Admin clicks the delete icon")
	public void admin_clicks_the_delete_icon() {
		userPage.search_userInDataTable("Updatedfirst");
	    userPage.clickRowDeleteBtn();
	}

	@Then("Admin should see a alert open with heading {string} along with <YES> and <NO> button for deletion")
	public void admin_should_see_a_alert_open_with_heading_along_with_yes_and_no_button_for_deletion(String string) {
	    Assert.assertEquals(userPage.validateDeletePopup(),true);
	    LoggerLoad.info("Validate Confirmation Alert.");
	}

	@Given("Admin is on Confirm Deletion alert")
	public void admin_is_on_confirm_deletion_alert() {
		userPage.handle_alert();
	    //Assert.assertEquals(userPage.get_ConfirmDialogTitle(),"Confirm");
	    System.out.println("Admin is on page: "+userPage.get_ConfirmDialogTitle());
	   LoggerLoad.info("Admin is on page: "+userPage.get_ConfirmDialogTitle());
	}

	@When("Admin clicks yes option")
	public void admin_clicks_yes_option() {
	    userPage.click_deleteYes();
	}

	@Then("Admin gets a message {string} alert and do not see that user in the data table")
	public void admin_gets_a_message_alert_and_do_not_see_that_user_in_the_data_table(String string) {
	    userPage.checkmsg_successful();
	    userPage.check_searchedUserInDataTable("Updatedfirst");
	    userPage.clear_serachedText();
	}

	@Given("Admin is on the Confirm Deletion alert")
	public void admin_is_on_the_confirm_deletion_alert() {
		userPage.handle_alert();
	   // Assert.assertEquals(userPage.get_ConfirmDialogTitle(),"Confirm");
	    System.out.println("Admin is on page: "+userPage.get_ConfirmDialogTitle());
	   LoggerLoad.info("Admin is on page: "+userPage.get_ConfirmDialogTitle());
	   userPage.search_userInDataTable("Updatedfirst");
	    userPage.clickRowDeleteBtn();
	}

	@When("Admin clicks No option")
	public void admin_clicks_no_option() {
	    userPage.click_deleteNo();
	}

	@Then("Admin can see the deletion alert disappears without deleting")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting() {
	    Assert.assertEquals(userPage.get_pageTitleName(),"Manage User");
	}

	@When("Admin clicks on close button")
	public void admin_clicks_on_close_button() {
	    userPage.Click_closeBtn();
	}

	@Then("Admin can see the deletion alert disappears without any changes")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes() {
		Assert.assertEquals(userPage.get_pageTitleName(),"Manage User");
		userPage.search_userInDataTable("Updatedfirst");
	    userPage.clear_serachedText();
	}

}