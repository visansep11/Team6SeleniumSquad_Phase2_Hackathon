@batch
Feature: Batch Module landing page validation

Background: 
Given Logged on the LMS portal as Admin

@batchLanding @tc1
Scenario: Validate landing in Batch Page
Given Admin is on dashboard page after Login.
When Admin clicks "Batch" from Navigation bar
Then Admin should see "batch" in the URL

@batchHeader @tc2
Scenario: Validate header in the Batch Page
Given Admin is on dashboard page after Login.
When Admin clicks "Batch" from Navigation bar
Then Admin should see the "Manage Batch" in the header

@batchPagination @tc3
Scenario: Validate pagination in the Batch Page
Given Admin is on dashboard page after Login.
When Admin clicks "Batch" from Navigation bar
Then Admin should see the pagination controls under the data table

@batchDatatableHeader @tc4
Scenario: Validate data table headers in the Batch Page
Given Admin is on dashboard page after Login.
When Admin clicks "Batch" from Navigation bar
Then Admin Should see the data table with headers Batch name, Batch Description,Batch Status, No. of classes,Program Name, EditDelete

@batchDeleteButton @tc5
Scenario: Validate Delete button in Batch Page
Given Admin is on dashboard page after Login.
When Admin clicks "Batch" from Navigation bar
Then Admin should be able to see the "Delete" icon button that is disabled

@batchAddButton @tc6
Scenario: Validate "+ A New batch" in Batch Page
Given Admin is on dashboard page after Login.
When Admin clicks "Batch" from Navigation bar
Then Admin should be able to see the "+ A New batch" button

@batchDataRows @tc7
Scenario: Validate data rows
Given Admin is on dashboard page after Login.
When Admin clicks "Batch" from Navigation bar
Then Each row in the data table should have a checkbox

@batchpopup @tc8
Scenario: Validate pop up for adding batch
Given Admin clicks "Batch" from Navigation bar
When Admin clicks on the "+ A New Batch" button
Then A new pop up with Batch details appears




   
