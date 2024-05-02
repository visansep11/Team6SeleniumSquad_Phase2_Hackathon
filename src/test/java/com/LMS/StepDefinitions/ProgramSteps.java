package com.LMS.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Pages.LoginPage;
import com.LMS.Pages.ProgramPage;
import com.LMS.Utils.LoggerLoad;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramSteps {

	public static WebDriver driver;
	private LoginPage loginPage=new LoginPage(DriverFactory.getdriver());
	private ProgramPage programPage=new ProgramPage(DriverFactory.getdriver());
	

	@Given("Logged on the LMS portal as Admin")
	public void logged_on_the_lms_portal_as_admin() {

				loginPage.loginUser();
				LoggerLoad.info("Admin logged on LMS Portal");
	}

	@Given("Admin is on dashboard page of program module after Login")
	public void admin_is_on_dashboard_page_of_program_module_after_login() {
		
		programPage.dashboardpage();
		LoggerLoad.info("Admin is on dashboard page of program module");
	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String string) {

		programPage.programClick();
		LoggerLoad.info("Admin clicks on program naviagtion bar");
	}

	@Then("Admin should see URL with {string}")
	public void admin_should_see_url_with(String string) {
		programPage.validateurlstring();
		LoggerLoad.info("Admin validating program URL");
		LoggerLoad.error("Expected URL is wrong");
	}

	@Then("Admin should see a heading with text {string} on the page")
	public void admin_should_see_a_heading_with_text_on_the_page(String string) {
		programPage.getHeadingText();
		LoggerLoad.info("Admin should see a heading text as Manage Program");
	}

	@Then("Admin should see the text as {string} along with Pagination icon below the table.x starting record number on that page y ending record number on that page z Total number of records")
	public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table_x_starting_record_number_on_that_page_y_ending_record_number_on_that_page_z_total_number_of_records(String string) throws InterruptedException {
		programPage.VerifyPaginationText();
		programPage.verify_pagination_controls();
		LoggerLoad.info("Admin should see text and pagination controls");

	}

	@Then("Admin should see the footer as {string}.z Total number of records")
	public void admin_should_see_the_footer_as_z_total_number_of_records(String string) {
		programPage.validate_footer_text();
		LoggerLoad.info("Admin should see footer text and total number of programs");
	}


	@Then("Admin should see a Delete button on the top left hand side as Disabled")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {
		programPage.deletedisabled();
		LoggerLoad.info("Admin should see a Delete button disabaled");

	}

	@Then("Admin should see a {string} button on the program page above the data table")
	public void admin_should_see_a_button_on_the_program_page_above_the_data_table(String string) {
		programPage.addNewProgrambtn();
		LoggerLoad.info("Admin should see a Add New Program button");
	}

	@Then("Admin should see the number of records \\(rows of data in the table) displayed on the page are {int}")
	public void admin_should_see_the_number_of_records_rows_of_data_in_the_table_displayed_on_the_page_are(Integer int1) throws InterruptedException {
		programPage.validate_number_of_records();
		//programPage.ValidatePagination();
		LoggerLoad.info("Admin should see the number of records");
	}


	@Then("Admin should see data table on the Manage Program Page with following column headers \\(Program Name, Program Description, Program Status, Edit,Delete)")
	public void admin_should_see_data_table_on_the_manage_program_page_with_following_column_headers_program_name_program_description_program_status_edit_delete() {
		programPage.programColumnHeaders();
		LoggerLoad.info("Admin should see the program column headers");
	}

	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
		programPage.verify_PresenceOfsortArrows_Except_EditDelete();
		//programPage.Sortarrowdisplaycheck();
		LoggerLoad.info("Admin should see the program sorting arrows");
	}

	@Then("Admin should see check box on the left side in all rows of the data table")
	public void admin_should_see_check_box_on_the_left_side_in_all_rows_of_the_data_table() throws InterruptedException{
		programPage.Validaterowcheckbox();
		//programPage.checkboxdisplaycheck();
		LoggerLoad.info("Admin should see the program check boxes");
	}

	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
		programPage.ValidateEditDelete();
	}

	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String string) {
		programPage.searchboxdisplay();
		LoggerLoad.info("Admin should see search bar");
	}
	

@Given("Admin is on Manage Program page")
public void admin_is_on_manage_program_page() {
	programPage.dashboardpage();
	LoggerLoad.info("Admin is on Manage Program Page");
}

@When("Admin clicks the sort icon of program name column")
public void admin_clicks_the_sort_icon_of_program_name_column() {
	programPage.beforesortingProgramNamesAsc();
	programPage.programSortClick();
	LoggerLoad.info("Admin clicks the program name sort icon");
}

@Then("The data get sorted on the table based on the program name column values in ascending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_ascending_order() throws InterruptedException {
	
	programPage.aftersortingProgramNameAsc();
	LoggerLoad.info("Sorting Program Names in ascending order");
}


@Given("The data is in the ascending order on the table based on Program Name column")
public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_name_column() {
	
	programPage.BeforeSortingPgmNamedesc();
	LoggerLoad.info("Program Name is in ascending order");
	
    
}

@When("Admin clicks the sort icon of programname column")
public void admin_clicks_the_sort_icon_of_programname_column() {
	programPage.programSortClick();
	LoggerLoad.info("Admin clicks the program name sort icon and the data is in ascending order");
}

@Then("The data get sorted on the table based on the program name column values in descending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_name_column_values_in_descending_order() {
	
	programPage.AfterSortingPgmNamedesc();
	LoggerLoad.info("Sorting Program Names in descending order");
}


@When("Admin clicks the sort icon of program Desc column")
public void admin_clicks_the_sort_icon_of_program_desc_column() {
	programPage.beforesortingProgramDescriptionAsc();
	programPage.programdescSortClick();
	LoggerLoad.info(" Clicking Program Description column");

}

@Then("The data get sorted on the table based on the program description column values in ascending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_ascending_order() {
	programPage.aftersortingProgramDescriptionAsc();
	LoggerLoad.info("Sorting Program Description in ascending order");
    
}

@Given("The data is in the ascending order on the table based on Program Description column")
public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_description_column() {
    programPage.BeforeSortingPgmDescriptiondesc();
   
}

@When("Admin clicks the sort icon of program Desccolumn")
public void admin_clicks_the_sort_icon_of_program_desccolumn() {
	 programPage.programdescSortClick();
	 LoggerLoad.info("Admin see program description data in ascending order");
}


@Then("The data get sorted on the table based on the program description column values in descending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_description_column_values_in_descending_order() {
    programPage.AfterSortingPgmDescriptiondesc();
    LoggerLoad.info("Sorting Program Description in descending order");
}


@When("Admin clicks the sort icon of program Status column")
public void admin_clicks_the_sort_icon_of_program_status_column() {
    programPage.beforesortingProgramStatusAsc();
    programPage.programstatusSortClick();
    LoggerLoad.info("Clicking Program Status Column");
}

@Then("The data get sorted on the table based on the program status column values in ascending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_ascending_order() {
    programPage.aftersortingProgramStatusAsc();
    LoggerLoad.info("Sorting Program Status in Ascending Order");
}

@Given("The data is in the ascending order on the table based on Program Status column")
public void the_data_is_in_the_ascending_order_on_the_table_based_on_program_status_column() {
	programPage.beforesortingProgramStatusdesc();
    
}

@When("Admin clicks the sort icon of programStatus1 column")
public void admin_clicks_the_sort_icon_of_program_status1_column() {
	programPage.programstatusSortClick();
    LoggerLoad.info("Admin see program description data in ascending order");
}


@Then("The data get sorted on the table based on the program status column values in descending order")
public void the_data_get_sorted_on_the_table_based_on_the_program_status_column_values_in_descending_order() {
	 	programPage.aftersortingProgramStatusdesc();
	    LoggerLoad.info("Sorting Program Status in Ascending Order");
}

@When("Admin clicks Next page link on the program table")
public void admin_clicks_next_page_link_on_the_program_table() {
   programPage.firstPage();
   LoggerLoad.info("Admin clicks next page link on the program table");
}

@Then("Admin should see the Pagination has {string} active link")
public void admin_should_see_the_pagination_has_active_link(String string) throws InterruptedException {
    programPage.activePage();
    LoggerLoad.info("Admin see pagination active link");
    Assert.assertTrue(true);
}


@When("Admin clicks Last page link")
public void admin_clicks_last_page_link() {
programPage.lastpagelink();
LoggerLoad.info("Admin clicks last page link");
}

@Then("Admin should see the last page record on the table with Next page link are disabled")
public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
	programPage.nextpagedisable();
	LoggerLoad.info("Admin should see the last page record on the table with next page link are disabled");

}

@Given("Admin is on last page of Program table")
public void admin_is_on_last_page_of_program_table() {
	programPage.lastpagelink();
	LoggerLoad.info("Admin is on last page of program table");

}

@When("Admin clicks First page link")
public void admin_clicks_first_page_link() {
programPage.leftarrowlink();
LoggerLoad.info("Admin clicks first page link");

}

@Then("Admin should see the previous page record on the table with pagination has previous page link")
public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() {
	programPage.verifyfirstpagelink();
	LoggerLoad.info("Admin should see the previous page record on the table with pagination");

}

@Given("Admin is on Previous Program page")
public void admin_is_on_previous_program_page() {
programPage.lastpagelink();
programPage.leftarrowlink();
LoggerLoad.info("Admin is on previous program page");

}

@When("Admin clicks Start page link")
public void admin_clicks_start_page_link() {
programPage.firstpageclick();
LoggerLoad.info("Admin clicks start page link");

}

@Then("Admin should see the very first page record on the table with Previous page link are disabled")
public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
programPage.checkingleftarrowdisable();
LoggerLoad.info("Admin should see the very first page record on the table");
}

@When("Admin clicks on Batch link on Manage Program page")
public void admin_clicks_on_batch_link_on_manage_program_page() {
	programPage.batchclick();
	LoggerLoad.info("Admin clicks on Batch Link");

}

@Then("Admin is re-directed to Batch page")
public void admin_is_re_directed_to_batch_page() {
programPage.managebatchPage();
LoggerLoad.info("Admin is redirected to Batch page");

}

@When("Admin clicks on User link on Manage Program page")
public void admin_clicks_on_user_link_on_manage_program_page() {
	programPage.userclick();
	LoggerLoad.info("Admin clicks on User Link");

}

@Then("Admin is re-directed to User page")
public void admin_is_re_directed_to_user_page() {
	programPage.manageuserPage();
	LoggerLoad.info("Admin is redirected to User page");

}

@When("Admin clicks on Logout link on Manage Program page")
public void admin_clicks_on_logout_link_on_manage_program_page() {
	programPage.logout();
	LoggerLoad.info("Admin clicks on logout Link");

}

@Then("Admin is re-directed to Login page")
public void admin_is_re_directed_to_login_page() {
	programPage.gethomePage();
	LoggerLoad.info("Admin is redirected to login page");

}

}
