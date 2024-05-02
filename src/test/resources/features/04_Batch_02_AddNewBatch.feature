@batch
Feature: Add new Batch

Background: Logged on the LMS portal
Given Logged on the LMS portal as Admin
When Admin clicks "Batch" from Navigation bar
Then Admin clicks on the "+ A New Batch" button

#@validateFieldsInPopUp @add_tc1
#Scenario: Check if the fields exist in the pop up window
#Given A new pop up with Batch details appears
#Then The pop up should include the fields Name, Number of classes and Description as text box,Program Name as drop down Status as radio button

#@batchDescIsOptional @add_tc2
#Scenario: Check if description is optional field
#Given A new pop up with Batch details appears
#When Fill in all the fields except batch description with valid values and click save
 #| BatchName   | ProgramName | No Of Classes |
 #|SDET Batch 01 | squad 0604   |      32       |
#
#Then The newly added batch should be present in the data table in Manage Batch page

#@addValidBatch @add_tc3
#Scenario Outline: Check if the program details are added in data table
#Given A new pop up with Batch details appears
#When Fill in all the fields with valid values "<Sheetname>" and <RowNumber> and click save
#Then The newly added batch should be present in the data table in Manage Batch page
#
#Examples: 
#| Sheetname    | RowNumber |
#| BatchDetails |   0       |


#Scenario Outline: Check for error messages for invalid fields
#Given A new pop up with Batch details appears
#When any of the fields have invalid values "<Sheetname>" and <RowNumber> and click save
#Then Error message should appear Batch
#
#Examples:
#| Sheetname    | RowNumber | 
#| BatchDetails |    4      |


Scenario Outline: Check for error messages for mandatory fields
Given A new pop up with Batch details appears
When Any of the mandatory fields are blank "<Sheetname>" and <RowNumber> and click save
Then Error message for batch mandatory fields should appear
Examples:
| Sheetname    | RowNumber | 
| BatchDetails |   5       |
#| BatchDetails |   6       |
#| BatchDetails |   7       |
#| BatchDetails |   8       |
#| BatchDetails |   9       |




