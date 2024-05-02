Feature: Delete Batch
#
#Background: Logged on the LMS portal
#Given Logged on the LMS portal as Admin
#When Admin clicks "Batch" from Navigation bar
#
#@delete1
#Scenario: Validate row level delete icon
#Given The delete icon on row level in data table is enabled
#When Admin clicks the delete icon of batch
#Then Alert appears with yes and No option
#
#@delete2
#Scenario: Validate accept alert
#Given Admin clicks the delete icon of batch
#When You click yes option
#Then Batch deleted alert pops and batch is no more available in data table

#@delete3
#Scenario: Validate reject alert
#Given Admin clicks the delete icon of batch
#When you click No option
#Then Batch is still listed in data table
#
#@delete4
#Scenario: Validate the delete icon below the header 
#Given None of the checkboxes in data table are selected
#Then The delete icon under the "Manage Batch" header should be disabled
#
#@delete5
#Scenario: Check for single row delete
#Given One of the checkbox row is selected
#When Click delete icon below "Manage Batch" header
#Then The respective row in the data table is deleted
#
#@delete6
#Scenario: Check for multi row delete
#Given Two or more checkboxes/row is selected
#When Click delete icon below "Manage Batch" header
#Then The respective row in the data table is deleted
#
