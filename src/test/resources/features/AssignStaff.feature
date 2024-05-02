@AssignStaff
Feature: Assign Staff

Background: Admin is on Manage User Page
	Given Admin is on the dashboard page after login
	When Admin clicks on the User on the naviagtion bar
	Then Admin is on the User page
	
	Scenario: Validate Assign Staff Popup window
		Given Admin is on the Manage user page
		When Admin clicks "Assign Staff" button
		Then Admin should see a pop up open for assign staff details with empty form along with Save and Cancel button and close (X) icon on the top right corner of the window
		
	Scenario: Validate input fields and their text boxes in Assign Staff form 
		Given Admin is on the Manage user page
		When Admin clicks "Assign Staff" button
		Then Admin should see User Role as R02,and other fields Student Email id,Skill,Program Name,Batch Name and Status with respective input boxes.
		
	Scenario: Validate Dropdown in Assign Staff Form
		Given Admin is on the Manage user page
		When Admin clicks "Assign Staff" button
		Then Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name in assign staff
		
	Scenario: Validate radio button in Assign Staff Form
  	Given Admin is on the Manage user page
		When Admin clicks "Assign Staff" button
		Then Admin should see two radio button for Status in assign staff
		
  Scenario: Empty Form Submission
  	Given Admin is in Assign Staff details pop up page
  	When Admin clicks "Save" button without entering any data in Assign Staff window
  	Then Admin gets a Error message alert under each field in Assign Staff window
  	
  Scenario: Validate the Assign Staff form page without giving Student Email id
  	Given Admin is in Assign Staff details pop up page
  	When Admin clicks "Save" button without entering Student Email id in assign popup
  	Then Admin gets a Error message alert as "Student Email id is required" under email in assign staff popup
  	
  Scenario: Validate the Assign Staff form page without giving Skill
  	Given Admin is in Assign Staff details pop up page
  	When Admin clicks "Save" button without entering Skill
  	Then Admin gets a Error message alert as "Skill is required" in assign staff popup
  	
  Scenario: Validate the Assign Staff form page without selecting Program
  	Given Admin is in Assign Staff details pop up page
  	When Admin clicks "Save" button without selecting program in assign staff
  	Then Admin gets a Error message alert as "Program is required" under program in assign staff
  	
  Scenario: Validate the Assign Staff form page without selecting batch
  	Given Admin is in Assign Staff details pop up page
  	When Admin clicks "Save" button without selecting batch in assign staff
  	Then Admin gets a Error message alert as "Batch is required" under batch in assign staff
  	
  Scenario: Validate the Assign Staff form page without giving Status
 		Given Admin is in Assign Staff details pop up page
 		When Admin clicks "Save" button without giving status in assign staff
 		Then Admin gets a Error message alert as "Status is required" under status in assign staff
 		
  Scenario: Validate Cancel/Close(X) icon on Assign Staff form
  	Given Admin is in Assign Staff details pop up page
  	When Admin clicks on Cancel/Close X Icon on Assign Staff form 
  	Then Assign Staff popup window should be closed without saving
  	
  Scenario: Validate Save button on Assign Staff form
  	Given Admin is in Assign Staff details pop up page
  	When Enter all the required fields with valid values and click Save button in assign staff
  	Then Admin gets a message "Successfully Staff Assigned" alert after assigning staff
  	
  Scenario: Validate Cancel button on Assign Staff form
  	Given Admin is in Assign Staff details pop up page
  	When Admin clicks <Cancel> button in assign staff
  	Then Admin can see the Assign Staff popup disappears without assigning 