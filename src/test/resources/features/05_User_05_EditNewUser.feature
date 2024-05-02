@EditNewUser
Feature: Verifying Edit New User

  Background: Admin is on dashboard page after Login and clicks User on the navigation bar

   @ValidatingUserDetailsPopup_edit1
  Scenario: Validate row level edit icon
    Given Admin is on ManageUser Page after clicking on User button
    When Admin clicks on the edit icon on manage user page
    Then A new pop up with edit User details appears

  @UpdateFielsWithValidData_edit
  Scenario Outline: Check if the fields are updated with valid data
    Given Admin is on edit User details pop up
    When Update the fields with valid data "<Sheetname>" and <RowNumber> click submit on edit user
    Then Admin gets message "User updated Successfully " and see the updated values in data table in edit user "<Sheetname>" and <RowNumber>
	Examples: 
      | Sheetname | RowNumber |
      | UserAdd   |         4 |
	
  @VerifyFielsWithInvalidData_edit
  Scenario Outline: Check if the fields are updated with invalid values
    Given Admin is on edit User details pop up dialog
    When Update the fields with invalid values "<Sheetname>" and <RowNumber> and click submit on edit user popup
    Then Admin should get Error message "<Sheetname>" and <RowNumber>
    Examples: 
      | Sheetname | RowNumber |
      | UserAdd   |         5 |

  @VerifyMandatoryFielsWithValidData_edit
  Scenario Outline: Check if the mandatory fields are updated with valid data
    Given Admin is on edit User details pop up dialog
    When Update the mandatory fields with valid values "<Sheetname>" and <RowNumber> and click submit in the edit popup
    Then Admin gets message "User updated Successfully " and see the updated values in data table in edit user "<Sheetname>" and <RowNumber>
	Examples: 
      | Sheetname | RowNumber |
      | UserAdd   |         6 |
	
  @VerifyOptionalField_ValidData_edit
  Scenario Outline: Check if the optional fields are updated with valid data
    Given Admin is on edit User details pop up dialog
    When the values in optional filds updated with valid data "<Sheetname>" and <RowNumber> in the edit user popup
    Then Admin gets message "User updated Successfully " and see the updated values in data table in edit user "<Sheetname>" and <RowNumber>
    Examples: 
      | Sheetname | RowNumber |
      | UserAdd   |         7 |
    
    @VerifyFieldsWithSpecialchars_edit
  Scenario Outline: Check if enters invalid values in the text fields of the Edit User popup
    Given Admin is on edit User details pop up dialog
    When enters only numbers or special char in the text fields in the edit new User popup "<Sheetname>" and <RowNumber>
    Then Admin should get Error message for edit user in edit New User "<Sheetname>" and <RowNumber>
    Examples: 
      | Sheetname | RowNumber |
      | UserAdd   |         8 |
      
    @VerifyCancelButton_edit
  Scenario Outline: Validate Cancel button on the Edit popup
    Given Admin is on edit User details pop up
    When Admin clicks Cancel button on edit popup
    Then Admin can see the edit User details popup disappears and can see nothing changed for particular User "<Sheetname>" and <RowNumber>
	 Examples: 
      | Sheetname | RowNumber |
      | UserAdd   |         7 |
 