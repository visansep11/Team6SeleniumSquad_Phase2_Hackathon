package com.LMS.StepDefinitions;

import com.LMS.DriverFactory.DriverFactory;
import com.LMS.Pages.UserPageValidationPage;
import com.LMS.Utils.LoggerLoad;

import io.cucumber.java.en.*;

public class SortUserStep {
	UserPageValidationPage userpage=new UserPageValidationPage(DriverFactory.getdriver());
	
	@When("Admin clicks on ID sort icon")
	public void admin_clicks_on_id_sort_icon() {
	    userpage.click_userIdSortBtn();
	}

	@Then("Admin should see User details are sorted by id")
	public void admin_should_see_user_details_are_sorted_by_id() {
		userpage.sortByUserIdAscending();
		LoggerLoad.info("User Ids are sorted in ascending order.");
		userpage.sortByUserIdDescending();
		LoggerLoad.info("User Ids are sorted in descending order.");
	}

	@When("Admin clicks on name sort icon")
	public void admin_clicks_on_name_sort_icon() {
		userpage.click_userNameSortBtn();
	}

	@Then("Admin should see User details are sorted by name")
	public void admin_should_see_user_details_are_sorted_by_name() {
		userpage.sortByUserNameAscending();
		LoggerLoad.info("User Names are sorted in ascending order.");
		userpage.sortByUserNameDescending();
		LoggerLoad.info("User Names are sorted in descending order.");
	}

	@When("Admin clicks on location sort icon")
	public void admin_clicks_on_location_sort_icon() {
	    userpage.click_userLocationSortBtn();
	}

	@Then("Admin should see User details are sorted by location")
	public void admin_should_see_user_details_are_sorted_by_location() {
		userpage.sortByUserLocationAscending();
		LoggerLoad.info("User Location are sorted in ascending order.");
		userpage.sortByUserLocationDescending();
		LoggerLoad.info("User Locations are sorted in descending order.");
	}

	@When("Admin clicks on Phone number sort icon")
	public void admin_clicks_on_phone_number_sort_icon() {
	    userpage.click_userPhoneNoSortBtn();
	}

	@Then("Admin should see User details are sorted by Phone number")
	public void admin_should_see_user_details_are_sorted_by_phone_number() {
		userpage.sortByUserPhoneNoAscending();
		LoggerLoad.info("User Phone Numbers are sorted in ascending order.");
		userpage.sortByUserPhoneNoDescending();
		LoggerLoad.info("User Phone Numbers are sorted in descending order.");
	}


}