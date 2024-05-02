package com.LMS.StepDefinitions;

import org.testng.Assert;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Pages.UserPageValidationPage;
import com.LMS.Utils.LoggerLoad;

import io.cucumber.java.en.*;

public class DeleteMultipleUserStep {
	UserPageValidationPage userPage=new UserPageValidationPage(DriverFactory.getdriver());
	
	@Given("Admin is in Manage User page")
	public void admin_is_in_manage_user_page() {
	   System.out.println("Admin is on page: "+userPage.get_pageTitleName());
	}

	@When("Admin clicks any checkbox in the data table of user")
	public void admin_clicks_any_checkbox_in_the_data_table_of_user() {
		userPage.search_userInDataTable("Checkmefirst");
	    userPage.select_checkbox();
	}

	@Then("Admin should see common delete option enabled under header Manage User")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_user() {
	    Assert.assertEquals(userPage.check_commonDeleteBtnStatus(),true);
	}

	@Given("Admin is on Confirm Deletion alert in User")
	public void admin_is_on_confirm_deletion_alert_in_user() {
	    userPage.clickRowDeleteBtn();
	    Assert.assertEquals(userPage.validateDeletePopup(),true);
	    LoggerLoad.info("Validate Confirmation Alert.");
	}

	@When("Admin clicks <NO> button on the alert in User")
	public void admin_clicks_no_button_on_the_alert_in_user() {
		userPage.handle_alert();
		userPage.click_deleteNo();
	}

	@Then("Admin should land on Manage User page and can see the selected users is not deleted from the data table")
	public void admin_should_land_on_manage_user_page_and_can_see_the_selected_users_is_not_deleted_from_the_data_table() {
		Assert.assertEquals(userPage.get_pageTitleName(),"Manage User");
		System.out.println("Show "+userPage.check_Checkboxes()+" Checkboxs");
		userPage.check_searchedUserInDataTable("Checkmefirst");
	    userPage.clear_serachedText();
	}

	@When("Admin clicks <YES> button on the alert in User")
	public void admin_clicks_yes_button_on_the_alert_in_user() {
		userPage.click_deleteYes();
	}

	@Then("Admin should land on Manage User page and can see the selected users are deleted from the data table")
	public void admin_should_land_on_manage_user_page_and_can_see_the_selected_users_are_deleted_from_the_data_table() {
		Assert.assertEquals(userPage.get_pageTitleName(),"Manage User");
		userPage.checkmsg_successful();
	    userPage.check_searchedUserInDataTable("Checkmefirst");
	    userPage.clear_serachedText();
	}

	


}