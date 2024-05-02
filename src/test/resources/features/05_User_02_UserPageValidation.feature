@UserPageValidations
Feature: User page validation

Background: Logged on the LMS portal as admin
  Given Admin is on dashboard page after Login
  

  @ValidatingLandingPage_1
  Scenario: Validate landing in User page
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar
    Then Admin should see the "Manage User" in the URL
 
  @ValidatingHeading_2
  Scenario: Validate the heading in User page
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar
    Then Admin should see a heading with text "Manage User" on the page

  @ValidatingPaginationIconAndText_3
  Scenario: Validate the text and pagination icon below the data table in User page
    Given Admin is on dashboard page after Login 
    When Admin clicks "User" from navigation bar
    Then Admin should see the text as "Showing 1 to y of z entries" along with Pagination icon below the table in User page
     
   @ValidatingColumnNamesInDataTable_4
  Scenario: Validate data table headers in the User Page
    Given Admin is on dashboard page after Login 
    When Admin clicks "User" from navigation bar
    Then Admin Should see the data table with column names Id, Name, location, Phone Number, Edit/Delete in User page
   
    @ValidatingDefaultDeleteBtnState_5
  Scenario: Validating the default state of Delete button in User page
    Given Admin is on dashboard page after Login
    When Admin clicks "User" from navigation bar
    Then Admin should see a Delete button on the top left hand side as Disabled in User page
      
	@ValidatingAddNewUserBtn_6
	  Scenario: Validate "+ Add New user" button in User Page
	    Given Admin is on dashboard page after Login 
	    When Admin clicks "User" from navigation bar
	    Then Admin should be able to see the "+ Add New User" button above the data table in User page
	   
	 @ValidatingAssignStaffBtn_7
	  Scenario: Validate "+ Assign staff"  button in User page
	    Given Admin is on dashboard page after Login
	    When Admin clicks "User" from navigation bar
	    Then Admin should be able to see the "+ Assign staff" button above the data table in User page
	    
	 @ValidatingAssignStudentBtn_8
	  Scenario: Validate "+ Assign Student"  button in User page
	    Given Admin is on dashboard page after Login
	    When Admin clicks "User" from navigation bar
	    Then Admin should be able to see the "+ Assign Student" button above the data table in User page
	    
	 @ValidatingSearchBox_9
	  Scenario: Validate search box in User page
	    Given Admin is on dashboard page after Login
	    When Admin clicks "User" from navigation bar
	    Then Admin should be able to see the search text box above the data table in User page
	    
	  @ValidatingRowNumbersInDataTable_10
	  Scenario: Validate number of data rows in the data table in User page
	    Given Admin is on dashboard page after Login
	    When Admin clicks "User" from navigation bar
	    Then Admin should see the records displayed on the data table in User page
	    
	  @VerifyCheckBox_11
	  Scenario: Verify Check box on the data table in User page
	    Given Admin is on dashboard page after Login
	    When Admin clicks "User" from navigation bar
	    Then Each row in the data table should have a checkbox in User page
	    
	  @VerifyEditIcon_12
	  Scenario: Verify edit icon on the data table in User
	    Given Admin is on dashboard page after Login
	    When Admin clicks "User" from navigation bar
	    Then Each row in the data table should have a edit icon that is enabled in User page
	    
	  @VerifyDeleteIcon_13
	  Scenario: Verify delete icon on the data table in User
	    Given Admin is on dashboard page after Login
	    When Admin clicks "User" from navigation bar
	    Then Each row in the data table should have a delete icon that is enabled in User page
	    
	  @SearchUserByName_14
	  Scenario: Search user by name in User page
	    Given Admin is on dashboard page after Login 
	    And clicks User on the navigation bar
	    And Admin is on Manage User Page
	    When Admin enters user name into search box in User
	    Then Admin should see user displayed with the entered name in User page
	    
	  @ValidatingInvalidDataInSearchBox_15
	  Scenario: Validating the Search with unrelated keyword in User Page
	    Given Admin is on dashboard page after Login
 			And clicks User on the navigation bar
 			And Admin is on Manage User Page
	    When Admin enters the keywords not present in the data table on the Search box in User
	    Then Admin should see zero entries on the data table in User Page
	    
	    