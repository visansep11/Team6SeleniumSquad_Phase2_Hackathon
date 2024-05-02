@AssignStudent
Feature: Assign Student

Background: Admin is on Manage User Page
	Given Admin is on dashboard page after login
	When Admin clicks on User on the naviagtion bar
	Then Admin is on User page
	
	Scenario: Validate Assign Student Popup window
		Given Admin is in the manage user page
		When Admin clicks on "Assign Student" button
		Then Admin should see a pop up open for assign student details with empty form along with Save and Cancel button and close (X) icon on the top right corner of the window
		
	Scenario: Validate input fields and their text boxes
		Given Admin is in the manage user page
		When Admin clicks on "Assign Student" button
		Then Admin should see User Role as R03,and other fields Student Email id,Program Name,Batch Name and Status with respective input boxes
	
	Scenario: Validate Dropdown in Assign Student Form
		Given Admin is in the manage user page
		When Admin clicks on "Assign Student" button
		Then Admin should see drop down boxes with valid datas for Student Email id,Program Name and Batch Name
	
	Scenario: Validate radio button in Assign Student
		Given Admin is in the manage user page
		When Admin clicks on "Assign Student" button
		Then Admin should see two radio button for Status for assign student popup
		
	Scenario: Empty Form Submission
		Given Admin is in Assign Student details pop up page
		When Admin clicks "Save" button without entering any data on assign student
		Then Admin gets a Error message alert on assign student popoup
		
	Scenario: Validate the Assign Student form page without giving Student Email id
		Given Admin is in Assign Student details pop up page
		When Admin clicks "Save" button without entering Student Email id
		Then Admin gets a Error message alert as "Student Email id is required" under email 
		
	Scenario: Validate the Assign Student form page without selecting Program
		Given Admin is in Assign Student details pop up page
		When Admin clicks "Save" button without selecting program on assign student
		Then Admin gets a Error message alert as "Program is required" under prrogram
		
	Scenario: Validate the Assign Student form page without selecting batch
		Given Admin is in Assign Student details pop up page
		When Admin clicks "Save" button without selecting batch on assign student
		Then Admin gets a Error message alert as "Batch is required" under batch
		
	Scenario: Validate the Assign Student form page without giving Status
	 	Given Admin is in Assign Student details pop up page
	 	When Admin clicks "Save" button without giving status on assign student
	 	Then Admin gets a Error message alert as "Status is required" under status
	 	
	Scenario: Validate Cancel/Close(X) icon on Assign Student form
		Given Admin is in Assign Student details pop up page
		When  Admin clicks Cancel or Close(X) Icon on Assign Student form
		Then Assign Student popup window should be closed without saving
		
	Scenario: Validate Save button on Assign Student form
		Given Admin is in Assign Student details pop up page
		When Enter all the required fields with valid values and click Save button on assign student
		Then Admin gets a message "Successfully Student Assigned" alert 
		
	Scenario: Validate Cancel button on Assign Student form
		Given Admin is in Assign Student details pop up page
		When Admin clicks <Cancel> button on Assign student
		Then Admin can see the Assign Student popup disappears without assigning 
		
	Scenario: Validate Change Program/Batch
		Given Admin is in Assign Student details pop up page
		When Admin enters email id ,clicks "Change Program/Batch" under assign student popup
		Then Admin can see alert message in assign student popup "Please deactivate User from existing program/batch and then activate for another program/batch"

