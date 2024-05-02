package com.LMS.StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Pages.UserPage;
import com.LMS.Utils.LoggerLoad;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class UserSteps {
	private UserPage user;
		@Given("Admin launch the browser")
	public void admin_launch_the_browser() {
		LoggerLoad.info("User enter the url");
		LoggerLoad.info("User is on LMS login page");
		System.out.println("Inside step-User is on Login page.");
		this.user=new UserPage(DriverFactory.getdriver());
		
		
	}
	@When("Admin enter valid {string} and valid {string} credentials  and clicks login button")
	public void admin_enter_valid_and_valid_credentials_and_clicks_login_button(String username, String password) {
		System.out.println("User enters Username and Password.");
		LoggerLoad.info("User enters the username and password on Login page.");
		this.user.enterUsername(username);
		this.user.enterPassword(password);
	   
	   System.out.println("User clicks on the login button.");
		LoggerLoad.info("User clicks a Login button.");
	   this.user.clickOnLogin();
	}
	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() throws Exception {
		this.user=new UserPage(DriverFactory.getdriver());
		Thread.sleep(1000);
		String dashboard_url="https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/";
		String url=this.user.getUrlOfPage();
		Assert.assertEquals(dashboard_url,url);
		//System.out.println("User is redirected to "+url+" page");
		//LoggerLoad.info("User is redirected to "+url+" page.");
			
	}

}
