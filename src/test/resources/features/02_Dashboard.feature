@Dashboard
Feature: Dashboard Functionality

Background: Admin gives correct LMS portal URL
	Given Admin is on the LMS portal page

	
	Scenario: Verify after login admin lands on manage program as dashboard page
		Given Admin is in the Home Page
		When Admin enters valid credentials and clicks login button
		Then Admin should see manage program as header
		
	Scenario: Verify the response time
		Given Admin is in the Home Page
		When Admin enters valid credentials and clicks login button
		Then Maximum navigation time in milliseconds,defaults to 30 seconds
		
	Scenario: Verify the broken link
		Given Admin is in the Home Page
		When Admin enters valid credentials and clicks login button
		Then HTTP response>=400.The link is broken
		 
	Scenario: Verify LMS title
		Given Admin is in the Home Page
		When Admin enters valid credentials and clicks login button
		Then Admin should see LMS -Learning management system as title
		
	Scenario: Verify LMS title alignment
		Given Admin is in the Home Page
		When Admin enters valid credentials and clicks login button
		Then LMS title should be on the top left corner of page
		
	Scenario: Verify navigation bar text
		Given Admin is in the Home Page
		When Admin enters valid credentials and clicks login button
		Then Admin should see correct spelling in navigation bar text
		
	Scenario: Verify LMS title has correct spelling and space
		Given Admin is in the Home Page
		When Admin enters valid credentials and clicks login button
		Then Admin should see correct spelling and space in LMS title
		
	Scenario: Verify alignment for navigation bar
		Given Admin is in the Home Page
		When Admin enters valid credentials and clicks login button
		Then Admin should see the navigation bar text on the top right side
		
	Scenario: Verify navigation bar order 1st Program
		Given Admin is in the Home Page
		When Admin enters valid credentials and clicks login button
		Then Admin should see program in the 1st place
		
	Scenario: Verify navigation bar order 2nd Batch
		Given Admin is in the Home Page
		When Admin enters valid credentials and clicks login button
		Then Admin should see batch in the 2nd place
	
	Scenario: Verify navigation bar order 3rd User
		Given Admin is in the Home Page
		When Admin enters valid credentials and clicks login button
		Then Admin should see user in the 3rd place
	
	Scenario: Verify navigation bar order 4th Logout
		Given Admin is in the Home Page
		When Admin enters valid credentials and clicks login button
		Then Admin should see logout in the 4th place
		
	Scenario: Verify Logout button function
		Given Admin is in dashboard page
		When Admin click Logout button on navigation bar
		Then Admin should land on login page
		
		
		
