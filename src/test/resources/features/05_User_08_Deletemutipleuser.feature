@multipleDeleteUser
Feature: Delete mutiple user
  
  @ValidateDeleteBtnEnable
     Scenario: Validate Common Delete button enabled after clicking on any checkbox in User
     Given Admin is in Manage User page
     When  Admin clicks any checkbox in the data table of user
     Then  Admin should see common delete option enabled under header Manage User

      @ValidateDeleteNoBtnSingleCkbx
     Scenario: Validate multiple User deletion by selecting Single Checkbox
     Given Admin is on Confirm Deletion alert in User
     When Admin clicks <NO> button on the alert in User
     Then Admin should land on Manage User page and can see the selected users is not deleted from the data table
     
     @ValidateDeleteYesBtnSingleCkbx
     Scenario: Validate multiple user deletion by selecting Single checkbox
     Given Admin is on Confirm Deletion alert in User
     When Admin clicks <YES> button on the alert in User
     Then Admin should land on Manage User page and can see the selected users are deleted from the data table
     
     @ValidateMultiplechbxYes
     Scenario: Validate multiple user deletion by selecting multiple check boxes
     Given Admin is on Confirm Deletion alert in User
     When Admin clicks <YES> button on the alert in User
     Then Admin should land on Manage User page and can see the selected users are deleted from the data table
     
     @ValidateMultiplechbxNo
     Scenario: Validate multiple user deletion by selecting multiple check boxes
     Given Admin is on Confirm Deletion alert in User
     When Admin clicks <NO> button on the alert in User
     Then Admin should land on Manage User page and can see the selected users is not deleted from the data table
     
     
     
     
     