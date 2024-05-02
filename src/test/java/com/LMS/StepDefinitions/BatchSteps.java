package com.LMS.StepDefinitions;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Pages.BatchPage;
import com.LMS.Pages.LoginPage;
import com.LMS.Utils.LoggerLoad;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;


public class BatchSteps {
	
private LoginPage loginPage=new LoginPage(DriverFactory.getdriver());
private BatchPage batchPage =new BatchPage (DriverFactory.getdriver());

	
@Given("Logged on the LMS portal as Admin")
	public void logged_on_the_lms_portal_as_admin() {

	loginPage.loginUser();
	LoggerLoad.info("****** Admins log in to the LMS portal with valid credentials ******");
}

//landing page manage batch url
@Given("Admin is on dashboard page after Login.")
public void admin_is_on_dashboard_page_after_login() {
	batchPage.verifyDashboardPageTitle();
	LoggerLoad.info("****** Admin is logged in to the dashboard page ******");
   
}

@When("Admin clicks {string} from Navigation bar")
public void admin_clicks_from_navigation_bar(String Batch) throws InterruptedException {
	batchPage.clickBatchBtn();
	LoggerLoad.info("****** Admin clicks on the Batch button from Navigation bar ******");
  
}

@Then("Admin should see {string} in the URL")
public void admin_should_see_in_the_url(String expectedUrlText) throws InterruptedException {
	String actualURL=batchPage.getManageBatchURL();
	System.out.println(actualURL);
	Assert.assertTrue(actualURL.contains(expectedUrlText));
	LoggerLoad.info("****** Validate Manage Batch URL ******");

}

//Manage Batch header
@Then("Admin should see the {string} in the header")
public void admin_should_see_the_in_the_header(String expectedHeader) {
	Assert.assertEquals(expectedHeader, batchPage.getPageHeader());
	LoggerLoad.info("****** Validate Manage Batch Header******");
  
}

@Then("Admin should see the pagination controls under the data table")
public void admin_should_see_the_pagination_controls_under_the_data_table() throws InterruptedException {
	
boolean isDisplayed=batchPage.verify_pagination_controls_isDisplayed();
Assert.assertTrue(isDisplayed);   
LoggerLoad.info("****** The pagination controls are displayed in the manage batch page  ******");
}

@Then("Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes,Program Name, EditDelete")
public void admin_should_see_the_data_table_with_headers_batch_name_batch_description_batch_status_no_of_classes_program_name_edit_delete() {
  batchPage.batchDataTableHeaders();
  LoggerLoad.info("****** Validating Batch Page datatable headers  ******");
}

@Then("Admin should be able to see the {string} icon button that is disabled")
public void admin_should_be_able_to_see_the_icon_button_that_is_disabled(String string) {
   boolean status=batchPage.DeleteAllDisabled();
   Assert.assertEquals(status, true);
   LoggerLoad.info("****** Validating if the Delete All button is disabled in batch landing page ******");
}

@Then("Admin should be able to see the {string} button")
public void admin_should_be_able_to_see_the_button(String button) {
	boolean status=batchPage.newbatchBtnIsDisplayed();
	Assert.assertTrue(status);
	LoggerLoad.info("****** Validating the "+button+"  is displayed ******");
  
}

@Then("Each row in the data table should have a checkbox")
public void each_row_in_the_data_table_should_have_a_checkbox() {
    
}

@When("Admin clicks on the {string} button")
public void admin_clicks_on_the_button(String buttonText) {
   batchPage.clickAddBatch();
   LoggerLoad.info("****** Admin clicks on "+buttonText+"  button ******");
}

//******************************* Add Batch *************************************//

// Batch Details pop up 
@Then("A new pop up with Batch details appears")
public void a_new_pop_up_with_batch_details_appears() throws InterruptedException {
	boolean isdisplayed=batchPage.batchPopUpIsDisplayed();
	Assert.assertTrue(isdisplayed);
	LoggerLoad.info("***** Batch Details pop up window is displayed *****");
   
}

//Batch Details pop up fields validation
@Then("The pop up should include the fields Name, Number of classes and Description as text box,Program Name as drop down Status as radio button")
public void the_pop_up_should_include_the_fields_name_number_of_classes_and_description_as_text_box_program_name_as_drop_down_status_as_radio_button() {
  Assert.assertTrue(batchPage.validateBatchPopUpFields());
  LoggerLoad.info("****** All the fields are displayed in the Batch pop up window ******");
}

//Batch Description is optional
@When("Fill in all the fields except batch description with valid values and click save")
public void fill_in_all_the_fields_except_batch_description_with_valid_values_and_click_save(DataTable dataTable) throws InterruptedException {
    batchPage.batchWithoutBatchDesc(dataTable);
    LoggerLoad.info("****** Create Batch without Batch Description ******");
}

@Then("The newly added batch should be present in the data table in Manage Batch page")
public void the_newly_added_batch_should_be_present_in_the_data_table_in_manage_batch_page() throws InterruptedException {
//	String actual= batchPage.getSuccessAlertMsg();
//	System.out.println(actual);
	batchPage.checkValueInDatatable("squad SDET batch 304");
	
}

// Add valid Batch

@When("Fill in all the fields with valid values {string} and {int} and click save")
public void fill_in_all_the_fields_with_valid_values_and_and_click_save(String Sheetname, Integer RowNumber) throws InvalidFormatException, IOException, InterruptedException {
	batchPage.addBatchAllFields(Sheetname, RowNumber);
	 LoggerLoad.info("******Batch Data for All valid Details is in Sheet "+Sheetname+" and Row no: "+RowNumber);
}


@When("any of the fields have invalid values {string} and {int} and click save")
public void any_of_the_fields_have_invalid_values_and_and_click_save(String Sheetname, Integer RowNumber) throws InvalidFormatException, InterruptedException, IOException {
     batchPage.addBatchAllFields(Sheetname, RowNumber);
	 LoggerLoad.info("******Batch Data  for invalid inputs is in Sheet "+Sheetname+" and Row no: "+RowNumber);
}


// Invalid Batch details error msg
@Then("Error message should appear Batch")
public void error_message_should_appear_batch() {
	 String actual= batchPage.getInvalidDataErrormessage();
	  Assert.assertEquals(actual, "This field should start with an alphabet and min 2 character.");
}

// Mandatory fields error msg

@When("Any of the mandatory fields are blank {string} and {int} and click save")
public void any_of_the_mandatory_fields_are_blank_and_and_click_save(String Sheetname, Integer RowNumber) throws InvalidFormatException, InterruptedException, IOException {
	 batchPage.addBatchAllFields(Sheetname, RowNumber);
	 LoggerLoad.info("******Batch Data for checking mandatory field error is in Sheet "+Sheetname+" and Row no: "+RowNumber);
}

@Then("Error message for batch mandatory fields should appear")
public void error_message_for_batch_mandatory_fields_should_appear() {
    
}


@Then("invalid values Error message should appear")
public void invalid_values_error_message_should_appear() {
  String actual=batchPage.updateInvalidErrorMsg();
  Assert.assertEquals(actual, "This field should start with an alphabet and min 2 character.");
}


//****************************** Edit Batch ***********************************//

// Validate edit icon in row
@Given("The edit icon on row level in data table is enabled")
public void the_edit_icon_on_row_level_in_data_table_is_enabled() {
  batchPage.editIconEnabled();
  LoggerLoad.info("****** Validating if edit icon is enabled ******");
}

@When("Admin clicks the edit icon on Manage Batch page")
public void admin_clicks_the_edit_icon_on_manage_batch_page() {	
batchPage.clickEditIcon();
LoggerLoad.info("****** Admin Clicks on the edit icon in row ******");
}

@Given("Admin clicks on the edit icon on Manage Batch page")
public void admin_clicks_on_the_edit_icon_on_manage_batch_page() throws InterruptedException {
batchPage.searchBatchAndClickEdit("squad SDET batch 301");
batchPage.clickEditIcon();
LoggerLoad.info("****** Admin clicks on the edit icon ******");
}


//Validate Update batch

@When("Update the fields with valid values from {string} and {int} and click save")
public void update_the_fields_with_valid_values_from_and_and_click_save(String Sheetname, Integer RowNumber) throws InvalidFormatException, InterruptedException, IOException {
  
  batchPage.UpdateBatchDetails(Sheetname, RowNumber);
  LoggerLoad.info("****** Admin updates the Batch Details ******");
}

@Then("The updated batch details should appear on the data table")
public void the_updated_batch_details_should_appear_on_the_data_table() {


}


@When("Update the fields with invalid values from {string} and {int} and click save")
public void update_the_fields_with_invalid_values_from_and_and_click_save(String Sheetname, Integer RowNumber) throws InvalidFormatException, InterruptedException, IOException {
  batchPage.UpdateBatchDetails(Sheetname, RowNumber);
  LoggerLoad.info("****** Updating with invalid input values ******");
}

@When("Erase data from mandatory field")
public void erase_data_from_mandatory_field() throws InterruptedException {
   batchPage.eraseDataUpdate();
   LoggerLoad.info("****** Erasing Data from the mandatory fields  ******");
}

@Then("Error message  for mandatory fields should appear")
public void error_message_for_mandatory_fields_should_appear() {
	String actual=batchPage.batchDescMandatoryMsgInUpdate();
	Assert.assertEquals(actual, "Batch Description is required.");
	String actual1=batchPage.classMandatoryMsgInUpdate();
	Assert.assertEquals(actual1, "Number of classes is required.");
 
}

@When("Erase data from description field")
public void erase_data_from_description_field() throws InterruptedException {
   batchPage.eraseDataUpdate();
   LoggerLoad.info("****** Mandatory field values are erased ******");
}

//****************************** Delete Batch ***********************************//

@Given("The delete icon on row level in data table is enabled")
public void the_delete_icon_on_row_level_in_data_table_is_enabled() {
   batchPage.deleteInRowEnabled();
   LoggerLoad.info("Delete icon in the rows are enabled");
  } 

@When("Admin clicks the delete icon")
public void admin_clicks_the_delete_icon() throws InterruptedException {
	
   batchPage.searchBatchAndClickDelete("squad");
   batchPage.clickRowDeleteBtn();
   LoggerLoad.info("****** Admin clicks on the delete button in the row ******");
}

@Then("Alert appears with yes and No option")
public void alert_appears_with_yes_and_no_option() throws InterruptedException {
	batchPage.validateDeletePopup();
	LoggerLoad.info("******  ******");
}

@When("You click yes option")
public void you_click_yes_option() {
	batchPage.clickYesBtn();
	LoggerLoad.info("****** Admin clicks on the yes button in the confirmation box ******");
}

@Then("Batch deleted alert pops and batch is no more available in data table")
public void batch_deleted_alert_pops_and_batch_is_no_more_available_in_data_table() {
	LoggerLoad.info("****** The deleted data is not available in the data table ******");
}

@When("you click No option")
public void you_click_no_option() {
	batchPage.clickNoBtn();
	LoggerLoad.info("****** Clicking on the No button in the confirmation dialog ******"); 
}

@Then("Batch is still listed in data table")
public void batch_is_still_listed_in_data_table() throws InterruptedException {
	batchPage.searchBatchAndClickEdit("squad");
	LoggerLoad.info("****** Batch is listed in the datatble ******");
}

@Given("None of the checkboxes in data table are selected")
public void none_of_the_checkboxes_in_data_table_are_selected() {
	LoggerLoad.info("****** Checkboxes are not selected ******");
}

@Then("The delete icon under the {string} header should be disabled")
public void the_delete_icon_under_the_header_should_be_disabled(String string) {
	Assert.assertFalse(batchPage.getDeleteAllManageBatch().isEnabled());
	LoggerLoad.info("****** Delete all batch icon is disabled ******");
}


@Given("One of the checkbox row is selected")
public void one_of_the_checkbox_row_is_selected() {
	LoggerLoad.info("****** Checking one checkbox in the row ******");
}


@When("Click delete icon below {string} header")
public void click_delete_icon_below_header(String string) {
	LoggerLoad.info("******** Clicking delete all button under hedaer *******");
}

@Then("The respective row in the data table is deleted")
public void the_respective_row_in_the_data_table_is_deleted() {
	LoggerLoad.info("******** Batch is deleted from the datatable ****** ");
}

@Given("Two or more checkboxes\\/row is selected")
public void two_or_more_checkboxes_row_is_selected() {
	LoggerLoad.info("******* checking two or more checkboxes from the datatable ******");
}



}