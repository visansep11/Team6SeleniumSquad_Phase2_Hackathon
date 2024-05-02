#
#
@tag
Feature: Title of your feature
 I want to use this template for my feature file
  #
 #
    #
  #@login
  #Scenario: Validate login with valid credentials
    #Given Admin is in Home Page
    #When  Admin enter valid credentials  and clicks login button 
    #Then  Admin should land on dashboard page
 #
  #
#
  
 Background: 
 Scenario: Validate landing in Program page
 Given Admin is on dashboard page after Login
 
  #When  Admin clicks "Program" on the navigation bar 
  #Then  Admin should see URL with "Manage Program"
#
#
  #@tag2
  #Scenario: Validate Program Details Popup window
    #Given Admin is on Manage Program Page
    #When Admin clicks <A New Program>button
    #Then Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window
 #
 #
  #@tag3
  #Scenario: Validate input fields and their text boxes in Program details form 
    #Given Admin is on Manage Program Page
    #When Admin clicks <A New Program>button
    #Then Admin should see two input fields and their respective text boxes in the program details window
    #
   #@tag4
  #Scenario: Validate radio button for Program Status  
    #Given Admin is on Manage Program Page
    #When Admin clicks <A New Program>button
    #Then Admin should see two radio button for Program Status
    #
    #@tag5
  #Scenario: Empty form submission 
    #Given Admin is on "Program Details" Popup window
    #When Admin clicks <Save>button without entering any data
    #Then Admin gets a Error message alert 
    #
    #
    #@tag6
  #Scenario: Enter only Program Name
    #Given Admin is on "Program Details" Popup window
    #When Admin enters only<Program Name> in text box and clicks Save button
    #Then Admin gets a message alert 'Description is required'
    #
    #
    #@tag7
    #Scenario: Enter only Program Description
    #Given Admin is on "Program Details" Popup window
    #When Admin enters only<Program description> in text box and clicks Save button
    #Then Admin gets a message alert 'Name is required'
    #
    #
    #@tag8
    #Scenario: Select Status only
    #Given Admin is on "Program Details" Popup window
    #When Admin selects only Status and clicks Save button
    #Then Admin gets a message alert 'Name and Description required'
    #
    #
    #@tag9
    #Scenario: Validate invalid values on the text column
    #Given Admin is on "Program Details" Popup window
    #When  Admin enters only numbers or special char in name and desc column
    #Then Admin gets a Error message alert 
    #
    #
    #@tag10
    #Scenario: Validate Cancel/Close(X) icon on Program Details form
    #Given  Admin is on "Program Details" Popup window
    #When   Admin clicks Cancel Close(X) Icon on Program Details form
    #Then   Program Details popup window should be closed without saving
    #
    #
    #@tag11
    #Scenario Outline: Validate Save button on Program Details form
    #Given    Admin is on "Program Details" Popup window
    #When    Enter "<Program Name>","<Program Description>" and Status with valid values and click Save button
    #Then    Admin gets a message "Successful Program Created" alert and able to see the new program added in the data table
 #
    #Examples:
    #| Program Name | Program Description |
    #| Program SDET6 |   Testing6         |
                                          
    #
    #@tag12
    #Scenario: Validate Cancel button on Program Details form
    #Given    Admin is on "Program Details" Popup window
    #When     Admin clicks <Cancel>button 
    #Then     Admin can see the Program details popup disappears without creating any program
    #done
    
    
    #@tag13
    #Scenario:  Validate Edit Feature
    #Given   Admin is on Manage Program Page 
    #When    Admin clicks <Edit> button on the data table for any row
    #Then    Admin should see a popup open for Program details to edit
    #done
    
    #@tag14
    #Scenario: Edit Program Name
     #Given   Admin is on Program Details Popup window to Edit
     #When    Admin edits the Name column and clicks save button
     #Then    Admin gets a message "Successful Program Updated" alert and able to see the updated name in the table for the particular program
    # xpath of edit not working
    
    #@tag15
    #Scenario:  Edit Program description
    #Given   Admin is on Program Details Popup window to Edit
    #When   Admin edits the Description column and clicks save button  
    #Then   Admin gets a message "Successful Program Updated" alert and able to see the updated description in the table for the particular program
     # xpath of edit not working
     #
    #@tag16
    #Scenario: Change Program Status
    #Given  Admin is on Program Details Popup window to Edit 
    #When   Admin changes the Status and clicks save button  
    #Then   Admin gets a message "Successful Program Updated" alert and able to see the updated status in the table for the particular program
    #Done
    #
     #@tag17
    #Scenario: Validate invalid values on the text column
    #Given  Admin is on Program Details Popup window to Edit 
    #When   Admin enters only numbers or special char in name and desc column 
    #Then   Admin gets a Error message alert 
    #Done
    #
     #@tag18
    #Scenario: Validate Cancel button on Edit popup
    #Given   Admin is on Program Details Popup window to Edit
    #When    Admin clicks <Cancel>button on edit popup
    #Then    Admin can see the Program details popup disappears and can see nothing changed for particular program
    #Done
    
     #@tag19
    #Scenario: Validate Save button on Edit popup
    #Given   Admin is on Program Details Popup window to Edit
    #When    Admin clicks <Save>button on edit popup 
    #Then    Admin gets a message "Successful Program Updated" alert and able to see the updated details in the table for the particular program
    #Done
    
     #@tag20
     #Scenario: Validate Common Delete button enabled after clicking on any checkbox
     #Given Admin is in Manage Program page
     #When  Admin clicks any checkbox in the data table
     #Then  Admin should see common delete option enabled under header Manage Program
     #----check box xpath is giving error
     #
     @tag21
     Scenario: Validate multiple program deletion by selecting Single checkbox
     Given Admin is on Confirm Deletion alert
     When Admin clicks <NO> button on the alert
     Then Admin should land on Manage Program page and can see the selected program is not deleted from the data table
    
    
    
    #@tag22
     #Scenario: Validate multiple program deletion by selecting Single checkbox
     #Given Admin is on Confirm Deletion alert
     #When Admin clicks <YES> button on the alert
     #Then Admin should land on Manage Program page and can see the selected program is deleted from the data table
     #done
    
  
     #@tag23
     #Scenario: Validate multiple program deletion by selecting multiple check boxes
     #Given Admin is on Confirm Deletion alert
     #When Admin clicks <YES> button on the alert
     #Then Admin should land on Manage Program page and can see the selected programs are deleted from the data table
     #---------multiple delete not happening 
     #
     #@tag24
     #Scenario: Validate multiple program deletion by selecting multiple check boxes
     #Given Admin is on Confirm Deletion alert
     #When Admin clicks <NO> button on the alert 
     #Then Admin should land on Manage Program page and can see the selected programs are not deleted from the data table
   #
