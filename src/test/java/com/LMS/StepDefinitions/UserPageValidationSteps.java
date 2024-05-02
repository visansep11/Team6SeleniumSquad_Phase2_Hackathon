package com.LMS.StepDefinitions;

import org.testng.Assert;
import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Pages.UserPageValidationPage;
import com.LMS.Utils.ConfigReader;
import com.LMS.Utils.LoggerLoad;

import io.cucumber.java.en.*;


public class UserPageValidationSteps {
	
	UserPageValidationPage userPgVal=new UserPageValidationPage(DriverFactory.getdriver());

	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
		LoggerLoad.info("Admin is on dashboard page after Login");
		System.out.println("Admin is on dashboard page after Login");
		
	}

	@When("Admin clicks {string} from navigation bar")
	public void admin_clicks_from_navigation_bar(String string) {
	    userPgVal.click_UserBtn();
	    LoggerLoad.info("Admin clicks User button from navigation bar.");
	    System.out.println("User button is clicked.");
	}

	@Then("Admin should see the {string} in the URL")
	public void admin_should_see_the_in_the_url(String string) {
	   String actual_manage_user=userPgVal.get_CurrentPgUrl();
	   String expected_UserUrl=ConfigReader.getManageUserPage();
	   Assert.assertEquals(actual_manage_user, expected_UserUrl);
	}

	@Then("Admin should see a heading with text {string} on the page")
	public void admin_should_see_a_heading_with_text_on_the_page(String expectedMSG) {
		String pdTitleName=userPgVal.get_pageTitleName();
		Assert.assertEquals(pdTitleName, expectedMSG);
	}

	@Then("Admin should see the text as {string} along with Pagination icon below the table in User page")
	public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table_in_user_page(String expected_msgPagination) {
	    String actual_msgPagination=userPgVal.get_msgPagination();
	    String exp_substring=expected_msgPagination.substring(0, 12);
	    String actualMsg;
	    if(actual_msgPagination.contains(exp_substring)) {
	    	 actualMsg="Found";
	    }
	    else
	    		actualMsg="Not Found";
	    Assert.assertEquals(actualMsg,"Found");
	    Assert.assertEquals(userPgVal.check_paginationIcon(), true);
	    
	}

	@Then("Admin Should see the data table with column names Id, Name, location, Phone Number, Edit\\/Delete in User page")
	public void admin_should_see_the_data_table_with_column_names_id_name_location_phone_number_edit_delete_in_user_page() {
		Assert.assertEquals(userPgVal.check_dataTableAllCoumns(), true);
		Assert.assertEquals(userPgVal.getDataTable_ID(), true);
		Assert.assertEquals(userPgVal.getDataTable_Name(), true);
		Assert.assertEquals(userPgVal.getDataTable_Location(), true);
		Assert.assertEquals(userPgVal.getDataTable_PhoneNumber(), true);
		Assert.assertEquals(userPgVal.getDataTable_EditDelete(), true);
		LoggerLoad.info("Validate the data table with column names Id, Name, location, Phone Number, Edit\\\\/Delete in User page");
		
	}

	@Then("Admin should see a Delete button on the top left hand side as Disabled in User page")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled_in_user_page() {
		Assert.assertEquals(userPgVal.Check_DefaultDelete_btn(), true);
	    LoggerLoad.info("Validate a Delete button on the top left hand side as Disabled in User page");
	}

	@Then("Admin should be able to see the {string} button above the data table in User page")
	public void admin_should_be_able_to_see_the_button_above_the_data_table_in_user_page(String string) {
		if(string.equalsIgnoreCase("+ Add New User")) {
		Assert.assertEquals(userPgVal.check_AddNewUser_btn(), true);
		LoggerLoad.info("Validate the "+string+" button above the data table in User page");
		}
		else if(string.equalsIgnoreCase("+ Assign staff")) {
			Assert.assertEquals(userPgVal.check_AssignStaff_btn(), true);
			LoggerLoad.info("Validate the "+string+" button above the data table in User page");
			}
		else if(string.equalsIgnoreCase("+ Assign Student")) {
			Assert.assertEquals(userPgVal.check_AssignStudent_btn(), true);
			LoggerLoad.info("Validate the "+string+" button above the data table in User page");
			}
	}

	@Then("Admin should be able to see the search text box above the data table in User page")
	public void admin_should_be_able_to_see_the_search_text_box_above_the_data_table_in_user_page() {
		Assert.assertEquals(userPgVal.check_SearchBox(), true);
		LoggerLoad.info("Validate the search text box above the data table in User page");
	}

	@Then("Admin should see the records displayed on the data table in User page")
	public void admin_should_see_the_records_displayed_on_the_data_table_in_user_page() {
	    int recordCount=userPgVal.check_NumberOfRecords();
	    System.out.println("Number of records displyed on user page are: "+recordCount);
	    LoggerLoad.info("Number of records displyed on user page are: "+recordCount);
	}

	@Then("Each row in the data table should have a checkbox in User page")
	public void each_row_in_the_data_table_should_have_a_checkbox_in_user_page() {
		 int checkboxCount=userPgVal.check_Checkboxes();
		    System.out.println("Number of checkboxes displyed on user page are: "+checkboxCount);
		    LoggerLoad.info("Number of checkboxes displyed on user page are: "+checkboxCount);
	}

	@Then("Each row in the data table should have a edit icon that is enabled in User page")
	public void each_row_in_the_data_table_should_have_a_edit_icon_that_is_enabled_in_user_page() {
		int editIcons=userPgVal.check_EditIcons();
	    System.out.println("Number of Edit Icons displyed on user page are: "+editIcons+" and all are enabled");
	    LoggerLoad.info("Number of Edit Icons displyed on user page are: "+editIcons+" and all are enabled");
	}

	@Then("Each row in the data table should have a delete icon that is enabled in User page")
	public void each_row_in_the_data_table_should_have_a_delete_icon_that_is_enabled_in_user_page() {
		int deleteIcons=userPgVal.check_DeleteIcons();
	    System.out.println("Number of Delete Icons displyed on user page are: "+deleteIcons+" and all are enabled");
	    LoggerLoad.info("Number of Delete Icons displyed on user page are: "+deleteIcons+" and all are enabled");
	}

	@And("clicks User on the navigation bar")
	public void clicks_user_on_the_navigation_bar() {
		userPgVal.click_UserBtn();
	    LoggerLoad.info("Admin clicks User button from navigation bar.");
	    System.out.println("User button is clicked.");
	}

	@And("Admin is on Manage User Page")
	public void admin_is_on_manage_user_page() {
		String pdTitleName=userPgVal.get_pageTitleName();
		Assert.assertEquals(pdTitleName, "Manage User");
	}

	@When("Admin enters user name into search box in User")
	public void admin_enters_user_name_into_search_box_in_user() {
	    userPgVal.search_validUser();
	}

	@Then("Admin should see user displayed with the entered name in User page")
	public void admin_should_see_user_displayed_with_the_entered_name_in_user_page() {
		//userPgVal.search_validUser();
		int recordCount=userPgVal.check_searchedUserInDataTable(userPgVal.search_validUser());
	    LoggerLoad.info("Number of records displyed on user page are: "+recordCount);
	}

	@When("Admin enters the keywords not present in the data table on the Search box in User")
	public void admin_enters_the_keywords_not_present_in_the_data_table_on_the_search_box_in_user() {
	    userPgVal.search_InvalidUser();
	}

	@Then("Admin should see zero entries on the data table in User Page")
	public void admin_should_see_zero_entries_on_the_data_table_in_user_page() {
		//userPgVal.search_InvalidUser();
		int recordCount=userPgVal.check_searchedUserInDataTable(userPgVal.search_InvalidUser());
		LoggerLoad.info("Number of records displyed on user page are: "+recordCount);
		userPgVal.clear_serachedText();
		userPgVal.click_UserBtn();
	}


	
}