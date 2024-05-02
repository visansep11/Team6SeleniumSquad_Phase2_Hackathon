@AddNewUserPart2
Feature: Add new user Part2

  Background: Admin is on the Manage User Page after clicking on User on the navigation bar
    
  @ValidDataInOnlyMandatoryFields_4
  Scenario Outline: Check if user is created when only mandatory fields are entered with valid data
    Given Admin is on  User details pop up
    When Admin enters mandatory fields in the form "<Sheetname>" and <RowNumber> and clicks on submit button
    Then Admin gets message User added Successfully

    Examples: 
      | Sheetname | RowNumber |
    | UserAdd   |         0 |
   
      

  @ValidDataInOnlyOptionalFields_5
  Scenario Outline: Check if user is created when only optional fields are entered with valid data
    Given Admin is on the User details pop up dialogue box
    When Admin skips to add value in mandatory field "<Sheetname>" and <RowNumber>
    Then Admin should see error message below the test field and the field will be highlighed in red color

    Examples: 
      | Sheetname | RowNumber |
      | UserAdd   |         1 |

  @InvalidDataInAllFields_6
  Scenario Outline: check if user is created when invalid data is entered in all of the fields
    Given Admin is on  User details pop up
    When Admin enters invalid data in all of the  fields in the form "<Sheetname>" and <RowNumber> and clicks on submit button
    Then Admin gets error message and user is not created

    Examples: 
      | Sheetname | RowNumber |
      | UserAdd   |         2 |

  @EmptySubmissionForm_7
  Scenario: Empty form submission
    Given Admin is on  User details pop up
    When Admin clicks on submit button without entering data
    Then user will not be created and Admin gets error message

  @ValidCancel/CloseIcon_8
  Scenario: Validate Cancel/Close(X) icon on User Details form
    Given Admin is on  User details pop up
    When Admin clicks Cancel or Close Icon on User Details form
    Then User Details popup window should be closed without saving

  @ValidatingCancelBtn_9
  Scenario: Validate Cancel button on User Details form
    Given Admin is on the User details pop up dialogue box with cancel button
    When Admin clicks Cancel button
    Then Admin can see the User details popup disappears without adding any user

  @ValidatingValidDataEntryInDataTable_10
  Scenario Outline: Check if the user details are added in data table
    Given Admin is on  User details pop up
    When Fill in all the fields with valid values "<Sheetname>" and <RowNumber> and click submit
    Then The newly added user should be present in the data table in Manage User page

    Examples: 
      | Sheetname | RowNumber |
      | UserAdd   |         3 |
