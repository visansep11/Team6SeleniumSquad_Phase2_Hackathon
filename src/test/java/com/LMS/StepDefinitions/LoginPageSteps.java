package com.LMS.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Pages.LoginPage1;
import com.LMS.Pages.LoginPage;
import com.aventstack.extentreports.util.Assert;

public class LoginPageSteps {


	public static WebDriver driver = new ChromeDriver();
//	private LoginPage loginPage=new LoginPage(DriverFactory.getdriver());
	private LoginPage1 loginPage=new LoginPage1(driver);
		public static final String userName = "sdetorganizers@gmail.com";
		public static final String password = "UIHackathon@02";
		
		public static final String invalidUserName = "testAdmin@gmail.com";
		public static final String invalidPassword = "admin@02";
		
		public static int httpStatus = 200;
		public static String invalidURL = "https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/FindCustomer"; 
		public static String invalidURL400 = "https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp12345.com/FindCustomer";
		public static String dashboadUrl = "https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/";
		
		public static final String grayColor = "rgba(0, 0, 0, 0.54)";
		
		
		
		@Given("User on a homepage")
		public void user_on_a_homepage() {

			driver.get(loginPage.baseUrl);
		}
		    
		
	
@Given("Admin launch the browser")
public void admin_launch_the_browser() {
   loginPage.loadLoginPage();
}

@When("Admin gives the correct LMs portal URL")
public void admin_gives_the_correct_l_ms_portal_url() {
   loginPage.loadLoginPage();
}

@Then("Admin should land on the homepage")
public void admin_should_land_on_the_homepage() {

    }

@Then("Admin should receive 404page not found error")
public void admin_should_receive_404page_not_found_error() {
	int httpStatus = 200;
	String invalidURL = "https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/FindCustomer";
//	httpStatus = loginPage.loadLoginPage(invalidURL);
   if(httpStatus == 404 )
	   System.out.println("Invalid URL: Status received:" + httpStatus);
}

@Then("HTTP response >=400Then the link is broken")
public void http_response_400then_the_link_is_broken() {
	int httpStatus = 200;
	String invalidURL = "https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp12345.com/FindCustomer";
//	httpStatus = loginPage.loadLoginPage(invalidURL);
   if(httpStatus > 404 )
	   System.out.println("Invalid URL: Status received:" + httpStatus);

	
}


@Then("Admin should see correct spellings in all fields")
public void admin_should_see_correct_spellings_in_all_fields() {
	
   String userNameLabel = "User";
   String passwordLabel = "Password";
   
   org.testng.Assert.assertEquals(userNameLabel.equals(loginPage.getUserNameLabel()) && passwordLabel.equals(loginPage.getPasswordLabel()),true);
   
}

@When("Admin gives the correct LMS portal URL")
public void admin_gives_the_correct_lms_portal_url() {
   
}

@Then("Admin should see logo on the left side")
public void admin_should_see_logo_on_the_left_side() {
	org.testng.Assert.assertEquals(loginPage.isLogoDisplayed(),true);
   
}

@Then("Admin should see LMS Learning Management system")
public void admin_should_see_lms_learning_management_system() {
	org.testng.Assert.assertEquals(loginPage.isLMSDisplayed(),true);
	
}

@Then("Admin should see company name below the app name")
public void admin_should_see_company_name_below_the_app_name() {
	org.testng.Assert.assertEquals(loginPage.isLMSDisplayed(),true);
	
}

@Then("Admin should see please login into LMS application")
public void admin_should_see_please_login_into_lms_application() {
	org.testng.Assert.assertEquals(loginPage.isLMSDisplayed(),true);
   }

@Then("Admin should see the two text field")
public void admin_should_see_the_two_text_field() {
	org.testng.Assert.assertEquals(loginPage.isTextFieldsVisible(),true);
}

@Then("Admin should user in the first text field")
public void admin_should_user_in_the_first_text_field() {
	org.testng.Assert.assertEquals(loginPage.isUserLabelDisplayed(),true);
}

@Then("Admin should see *symbol next the user text")
public void admin_should_see_symbol_next_the_user_text() {
	org.testng.Assert.assertEquals(loginPage.isUserAsterikVisible(),true);

}


@Then("Admin  should password in the second text field")
public void admin_should_password_in_the_second_text_field() {
	org.testng.Assert.assertEquals(loginPage.isPasswordLabelDisplayed(),true);
}

@Then("Admin should see * syombol next to password text")
public void admin_should_see_syombol_next_to_password_text() {
	org.testng.Assert.assertEquals(loginPage.isPasswordAsterickVisible(),true);
}

@Then("Admin should see input field on the centre of the page")
public void admin_should_see_input_field_on_the_centre_of_the_page() {
	org.testng.Assert.assertEquals(loginPage.isTextFieldsVisible(),true);
}

@Then("Admin sould see login button")
public void admin_sould_see_login_button() {
	org.testng.Assert.assertEquals(loginPage.isLoginButtonDisplayed(),true);
}

@Then("Admin should see login button on the centre of the page")
public void admin_should_see_login_button_on_the_centre_of_the_page() {
	org.testng.Assert.assertEquals(loginPage.isLoginButtonDisplayed(),true);
}

@Then("Admin should see user in gray color")
public void admin_should_see_user_in_gray_color() {
	org.testng.Assert.assertEquals(loginPage.getUserFontColor().equals(grayColor),true);
}

@Then("Admin should see password in gray color")
public void admin_should_see_password_in_gray_color() {
	System.out.print("Gray Color from Selenium" + loginPage.getPasswordFontColor());
	org.testng.Assert.assertEquals(loginPage.getPasswordFontColor().equals(grayColor),true);
}

@Given("Admin is in homepage")
public void admin_is_in_homepage() {
    loginPage.loadLoginPage();
}

@When("Admin  enter valid credentials and click login button")
public void admin_enter_valid_credentials_and_click_login_button() {
	loginPage.enterUserName(userName);
	loginPage.enterPassword(password);
	loginPage.clickLogin();
   
}

@Then("Admin should land on Dashboard page")
public void admin_should_land_on_Dashboard_page() {
	org.testng.Assert.assertEquals(loginPage.isDashboadPageLoaded(),true);
}

@When("Admin enter invalid credentials and login button")
public void admin_enter_invalid_credentials_and_login_button() {
	loginPage.enterUserName(invalidUserName);
	loginPage.enterPassword(invalidPassword);
	loginPage.clickLogin();
}

@Then("Error messege please check the username\\/password")
public void error_messege_please_check_the_username_password() {
	org.testng.Assert.assertEquals(loginPage.isErrorMessageDisplayed(),true);
   }

@When("Admin enter value only in password and clicks login button")
public void admin_enter_value_only_in_password_and_clicks_login_button() {
	
	loginPage.enterPassword(password);
	loginPage.clickLogin();
}

@Then("Error messege please check username\\/ password")
public void error_messege_please_check_username_password() {
	org.testng.Assert.assertEquals(loginPage.isErrorUserNameDisplayed(),true);
}

@When("Admin enter value only in username and clicks login button")
public void admin_enter_value_only_in_username_and_clicks_login_button() {
	loginPage.enterUserName(userName);
	loginPage.clickLogin();
}

@Then("Error messege please check usrname \\/password")
public void error_messege_please_check_usrname_password() {
	org.testng.Assert.assertEquals(loginPage.isErroPasswordDisplayed(),true);
}

@When("Admin enter valid credentials and clicks login button through keyboard")
public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() {
	loginPage.enterUserName(userName);
	loginPage.enterPassword(password);
	loginPage.passwordFieldEnterPressed();
}

@Then("Admin should land on dashboardpage")
public void admin_should_land_on_dashboardpage() {
	org.testng.Assert.assertEquals(loginPage.isDashboadPageLoaded(),true);
}

@When("Admin enter valid credentials and clicks login button through mouse")
public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() {
	loginPage.enterUserName(userName);
	loginPage.enterPassword(password);
	loginPage.clickLogin();
}

@When("Admin gives  the correct LMS and portal URL")
public void admin_gives_the_correct_lms_and_portal_url() {
	loginPage.enterUserName(userName);
	loginPage.enterPassword(password);
	loginPage.clickLogin();
}


@Then("Admin should land on dashboard page")
public void admin_should_land_on_dashboard_page() {
	org.testng.Assert.assertEquals(loginPage.isDashboadPageLoaded(),true);
}
}


