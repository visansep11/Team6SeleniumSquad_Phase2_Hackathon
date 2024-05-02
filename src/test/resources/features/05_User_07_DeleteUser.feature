@deleteUser
Feature: Delete User
  
Background: Admin is on dashboard page after Login and clicks User on the navigation bar
  @rowLevelDeleteIcon
  Scenario: Validate row level delete icon
    Given Admin is on Manage User Page
    When Admin clicks the delete icon
    Then Admin should see a alert open with heading "Confirm" along with <YES> and <NO> button for deletion
    

  @clickYesOnDeletionWindow
  Scenario: Click Yes on deletion window
    Given Admin is on Confirm Deletion alert
    When Admin clicks yes option
    Then Admin gets a message "Successful User Deleted" alert and do not see that user in the data table

	@clickNoOnDeletionWindow
  Scenario: Click No on deletion window
    Given Admin is on the Confirm Deletion alert
    When Admin clicks No option
    Then Admin can see the deletion alert disappears without deleting
    
    @clickCancelOnDeletionWindow
  Scenario: Validate CloseX icon on Confirm Deletion alert
    Given Admin is on Confirm Deletion alert
    When Admin clicks on close button
    Then Admin can see the deletion alert disappears without any changes
    

    
