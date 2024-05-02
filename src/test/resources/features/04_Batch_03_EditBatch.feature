Feature: Edit batch 

Background: Logged on the LMS portal
Given Logged on the LMS portal as Admin
When Admin clicks "Batch" from Navigation bar

@validateEditIcon @edit1
Scenario: Validate row level edit icon
Given The edit icon on row level in data table is enabled
When Admin clicks the edit icon on Manage Batch page
Then A new pop up with Batch details appears

#Scenario Outline: Check if the fields are updated
#Given Admin clicks on the edit icon on Manage Batch page
#When Update the fields with valid values from "<Sheetname>" and <RowNumber> and click save
#Then The updated batch details should appear on the data table
#
#Examples: 
#| Sheetname    | RowNumber |
#| BatchDetails |   10      |

#Scenario Outline: Check if the update throws error with invalid values
#Given Admin clicks on the edit icon on Manage Batch page
#When Update the fields with invalid values from "<Sheetname>" and <RowNumber> and click save
#Then invalid values Error message should appear
#Examples: 
#| Sheetname    | RowNumber |
#| BatchDetails |   4       |

#Scenario: Check if you get error message when mandatory fields are erased
#Given Admin clicks on the edit icon on Manage Batch page
#When Erase data from mandatory field
#Then Error message  for mandatory fields should appear

Scenario: Check if description field is optional in update
Given Admin clicks on the edit icon on Manage Batch page
When Erase data from description field
Then The updated batch details should appear on the data table