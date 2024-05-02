package com.LMS.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Pages.DashboardPage;
import com.LMS.Utils.LoggerLoad;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardSteps {

	WebDriver driver;
	DashboardPage dashboardPage;

	@Given("Admin is on the LMS portal page")
	public void admin_is_on_the_lms_portal_page() {

		driver = DriverFactory.getdriver();
		dashboardPage = new DashboardPage(driver); 
		dashboardPage.getUrl();
		LoggerLoad.info("Admin lands on LMS portal page");

	}

	@Given("Admin is in the Home Page")
	public void admin_is_in_the_home_page() throws InterruptedException  {

		String actualURL   = driver.getCurrentUrl();
		Assert.assertEquals(actualURL, "https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/login");
		LoggerLoad.info("Validating home page");

	}

	@When("Admin enters valid credentials and clicks login button")
	public void admin_enters_valid_credentials_and_clicks_login_button() throws InterruptedException {


		dashboardPage.enterUsername();
		dashboardPage.enterPassword();
		dashboardPage.clickLogin();
		LoggerLoad.info("Admin enters valid credentials and clicks login button");

	}

	@Then("Admin should see manage program as header")
	public void admin_should_see_manage_program_as_header() throws InterruptedException {

		Thread.sleep(1000);
		String DashPageHeader = dashboardPage.verifyHeaderText();
		System.out.println(DashPageHeader);
		Assert.assertEquals(DashPageHeader, "Manage Program");
		LoggerLoad.info("Validating header text");

	}

	@Then("Maximum navigation time in milliseconds,defaults to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer int1) {

		long responseTime = dashboardPage.getResponseTime();
		Assert.assertTrue(responseTime<=int1, "Response time is less than expected");
		LoggerLoad.info("Validating navigation time");

	}

	@Then("HTTP response>={int}.The link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) {

		dashboardPage.verifyLink();
		LoggerLoad.info("Verifying HTTP response for links");

	}

	@Then("Admin should see LMS -Learning management system as title")
	public void admin_should_see_lms_learning_management_system_as_title() throws InterruptedException {

		Thread.sleep(1000);
		String DashBoradTitle = dashboardPage.verifyTitleText();
		System.out.println(DashBoradTitle);
		Assert.assertEquals(DashBoradTitle, "LMS - Learning Management System");
		LoggerLoad.info("Validating Title of the page");

	}

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() throws InterruptedException {

		Thread.sleep(1000);
		dashboardPage.verifyTitleLeftAlignment();
		LoggerLoad.info("Validating LMS title on top left corner");

	}

	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() throws InterruptedException {

		Thread.sleep(1000);
		dashboardPage.verifyNavigationBarText();
	}

	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() throws InterruptedException {

		Thread.sleep(1000);
		String actualtitle = dashboardPage.verifyLMSTitle();
		Assert.assertEquals(actualtitle, "LMS - Learning Management System");
		LoggerLoad.info("Admin sees correct spelling");

	}

	@Then("Admin should see the navigation bar text on the top right side")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side() throws InterruptedException {

		Thread.sleep(1000);
		dashboardPage.verifyNavigationBarTextAndAlignment();
		LoggerLoad.info("Admin see the navigation bar text on the top right side");

	}

	@Then("Admin should see program in the 1st place")
	public void admin_should_see_program_in_the_1st_place() throws InterruptedException {

		Thread.sleep(1000);
		dashboardPage.verifyProgramPosition();	 
		LoggerLoad.info("Program is in 1st place");

	}

	@Then("Admin should see batch in the 2nd place")
	public void admin_should_see_batch_in_the_2nd_place() throws InterruptedException {

		Thread.sleep(1000);
		dashboardPage.verifyBatchPosition();	
		LoggerLoad.info("Batch is in 2nd place");

	}

	@Then("Admin should see user in the 3rd place")
	public void admin_should_see_user_in_the_3rd_place() throws InterruptedException {

		Thread.sleep(1000);
		dashboardPage.verifyUserPosition();	 
		LoggerLoad.info("User is in 3rd place");

	}

	@Then("Admin should see logout in the 4th place")
	public void admin_should_see_logout_in_the_4th_place() throws InterruptedException {

		Thread.sleep(1000);
		dashboardPage.verifyLogoutPosition();
		LoggerLoad.info("Logout is in 4th place");

	}

	@Given("Admin is in dashboard page")
	public void admin_is_in_dashboard_page() {

		dashboardPage.enterUsername();
		dashboardPage.enterPassword();
		dashboardPage.clickLogin();
		LoggerLoad.info("Admin lands on dashborad page");

	}

	@When("Admin click Logout button on navigation bar")
	public void admin_click_logout_button_on_navigation_bar() throws InterruptedException {

		Thread.sleep(1000);
		dashboardPage.clickLogout();
		LoggerLoad.info("Validating logout button");

	}

	@Then("Admin should land on login page")
	public void admin_should_land_on_login_page() {

		String actualUrl = dashboardPage.getActualUrl();
		String expectedUrl = "https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/login";
		Assert.assertEquals(actualUrl,expectedUrl);
		LoggerLoad.info("Admin logouts successfully");

	}

}