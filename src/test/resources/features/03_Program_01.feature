@ProgramModule
Feature: Validate Program functionality

  Background: 
  Given Logged on the LMS portal as Admin
  
@ManageProgram-01
  Scenario: Validate landing in Program page
  	Given Admin is on dashboard page of program module after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see URL with "Manage Program"
    
@ManageProgram-02
  Scenario: Validate the heading
  	Given Admin is on dashboard page of program module after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see a heading with text "Manage+ Program" on the page
    

@ManageProgram-03
  Scenario: Validate the text and pagination icon below the data table
  	Given Admin is on dashboard page of program module after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see the text as "Showing x to y of z entries" along with Pagination icon below the table.x starting record number on that page y ending record number on that page z Total number of records
#				
#@ManageProgram-04
  #Scenario: Validate the footer
  #	Given Admin is on dashboard page of program module after Login
    #When Admin clicks "Program" on the navigation bar
    #Then Admin should see the footer as "In total there are z programs".z Total number of records
#
#@ManageProgram-05
  #Scenario: Validating the default state of Delete button
  #	Given Admin is on dashboard page of program module after Login
    #When Admin clicks "Program" on the navigation bar
    #Then Admin should see a Delete button on the top left hand side as Disabled
    #
#@ManageProgram-06
  #Scenario: Validate Add New Program
  #	Given Admin is on dashboard page of program module after Login
    #When Admin clicks "Program" on the navigation bar
    #Then Admin should see a "+A New Program" button on the program page above the data table
    #
#@ManageProgram-07
  #Scenario: Validate that number of records (rows of data in the table) displayed
  #	Given Admin is on dashboard page of program module after Login
    #When Admin clicks "Program" on the navigation bar
    #Then Admin should see the number of records (rows of data in the table) displayed on the page are 5
#
#@ManageProgram-08
  #Scenario Outline: Verify data table on the Program page
  #	Given Admin is on dashboard page of program module after Login
    #When Admin clicks "Program" on the navigation bar
    #Then Admin should see data table on the Manage Program Page with following column headers (Program Name, Program Description, Program Status, Edit,Delete)
        #
#@ManageProgram-09
  #Scenario: Verify Sort arrow icon on the data table
  #	Given Admin is on dashboard page of program module after Login
    #When Admin clicks "Program" on the navigation bar
    #Then Admin should see the sort arrow icon beside to each column header except Edit and Delete
    #
#@ManageProgram-10
  #Scenario: Verify Check box on the data table
  #	Given Admin is on dashboard page of program module after Login
    #When Admin clicks "Program" on the navigation bar
    #Then Admin should see check box on the left side in all rows of the data table
    #
#@ManageProgram-11
  #Scenario: Verify Edit and Delete buttons
  #	Given Admin is on dashboard page of program module after Login
    #When Admin clicks "Program" on the navigation bar
    #Then Admin should see the Edit and Delete buttons on each row of the data table
    #
 #@ManageProgram-12
  #Scenario: Verify Search bar on the Program page
  #	Given Admin is on dashboard page of program module after Login
    #When Admin clicks "Program" on the navigation bar
    #Then Admin should see Search bar with text as "Search..."
    #
  #@Sorting(DataOrdering)Validation-01
#Scenario: Validates Sorting(data ordering) on the Program Data table
  #	Given Admin is on Manage Program page
    #When Admin clicks the sort icon of program name column
    #Then The data get sorted on the table based on the program name column values in ascending order
    #
  #@Sorting(DataOrdering)Validation-02
  #Scenario: Verify Search bar on the Program page
  #	Given The data is in the ascending order on the table based on Program Name column
    #When Admin clicks the sort icon of programname column
    #Then The data get sorted on the table based on the program name column values in descending order
    #
#	  
  #@Sorting(DataOrdering)Validation-03
  #Scenario: Verify Search bar on the Program page
  #	Given Admin is on Manage Program page
    #When Admin clicks the sort icon of program Desc column
    #Then The data get sorted on the table based on the program description column values in ascending order
#
    #@Sorting(DataOrdering)Validation-04
  #Scenario: Verify Search bar on the Program page
  #	Given The data is in the ascending order on the table based on Program Description column
    #When Admin clicks the sort icon of program Desccolumn
    #Then The data get sorted on the table based on the program description column values in descending order
    #
     #@Sorting(DataOrdering)Validation-05
  #Scenario: Verify Search bar on the Program page
  #	Given Admin is on Manage Program page
    #When Admin clicks the sort icon of program Status column
    #Then The data get sorted on the table based on the program status column values in ascending order
    #
    #@Sorting(DataOrdering)Validation-06
  #Scenario: Verify Search bar on the Program page
  #	Given The data is in the ascending order on the table based on Program Status column
    #When Admin clicks the sort icon of programStatus1 column
    #Then The data get sorted on the table based on the program status column values in descending order
    #
    #@Pagination-01
    #Scenario: Verify Next page link
  #	Given Admin is on Manage Program page
    #When Admin clicks Next page link on the program table 
    #Then Admin should see the Pagination has "Next" active link
    #
    #@Pagination-02
    #Scenario: Verify Last page link
  #	Given Admin is on Manage Program page
    #When Admin clicks Last page link 
    #Then Admin should see the last page record on the table with Next page link are disabled
    
    #@Pagination-03
    #Scenario: Verify First page link
  #	Given Admin is on last page of Program table
    #When Admin clicks First page link
    #Then Admin should see the previous page record on the table with pagination has previous page link
    #
    #@Pagination-04
    #Scenario: Verify Start page link
  #	Given Admin is on Previous Program page 
    #When Admin clicks Start page link 
    #Then Admin should see the very first page record on the table with Previous page link are disabled
    #
    #@Navigation_Validation_from_Manage_Program_to_other_Pages-01
    #Scenario: Batch link on navigation bar
  #	Given Admin is on Manage Program page 
    #When Admin clicks on Batch link on Manage Program page 
    #Then Admin is re-directed to Batch page
    #
    #@Navigation_Validation_from_Manage_Program_to_other_Pages-02
    #Scenario: User link on navigation bar
  #	Given Admin is on Manage Program page 
    #When Admin clicks on User link on Manage Program page 
    #Then Admin is re-directed to User page
    #
    #@Navigation_Validation_from_Manage_Program_to_other_Pages-03
    #Scenario: Logout link on navigation bar
  #	Given Admin is on Manage Program page 
    #When Admin clicks on Logout link on Manage Program page
    #Then Admin is re-directed to Login page
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    #
    
    	
    
    
    
    
    
    
    
    
    
    