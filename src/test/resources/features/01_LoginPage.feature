Feature: To check the homepage verification

Background:
Given  Admin gives the correct LMS portal URL

Scenario: Verify admin is able to land on homepage
Given  Admin launch the browser
When Admin gives the correct LMs portal URL
Then Admin should land on the homepage


Scenario: Verify admin is able to land on homepage with invalid URL
Given  Admin launch the browser
When Admin gives the correct LMs portal URL
Then Admin should receive 404page not found error


Scenario: Verify for broken link
Given  Admin launch the browser
When Admin gives the correct LMs portal URL
Then HTTP response >=400Then the link is broken

Scenario:  Verify the text spelling in the page
Given  Admin launch the browser
When Admin gives  the correct LMS and portal URL
Then Admin should see correct spellings in all fields

Scenario: Verify the company logo
Given Admin launch the browser
When Admin gives the correct LMS portal URL
Then Admin should see logo on the left side

Scenario: Verify the application name
Given Admin launch the browser
When Admin gives the correct LMS portal URL
Then Admin should see LMS Learning Management system

Scenario: Verify the company name
Given Admin launch the browser
When Admin gives  the correct LMS and portal URL
Then Admin should see company name below the app name

Scenario: Validate  signin content
Given Admin launch the browser
When Admin gives the correct LMS portal URL
Then Admin should see please login into LMS application

Scenario: Verify text field is present
Given Admin launch the browser
When Admin gives  the correct LMS and portal URL
Then Admin should see the two text field

Scenario:  Verify text on the first text field
Given Admin launch the browser
When Admin gives  the correct LMS and portal URL
Then Admin should user in the first text field

Scenario:  Verify asterik to  user text
Given Admin launch the browser
When Admin gives  the correct LMS and portal URL
Then Admin should see *symbol next the user text

Scenario:  Verify text on the second text field
Given Admin launch the browser
When Admin gives  the correct LMS and portal URL
Then Admin  should password in the second text field

Scenario: Verify asterik next to password text
Given Admin launch the browser
When Admin gives  the correct LMS and portal URL
Then Admin should see * syombol next to password text


Scenario:  Verify the alignment input field for the login
Given Admin launch the browser
When Admin gives  the correct LMS and portal URL
Then Admin should see input field on the centre of the page


Scenario: Verify login present 
Given Admin launch the browser
When Admin gives  the correct LMS and portal URL
Then Admin sould see login button

Scenario: Verify the alignment of the login button
Given Admin launch the browser
When Admin gives the correct LMS portal URL
Then Admin should see login button on the centre of the page

Scenario: Verify input descriptive test in user field
Given Admin launch the browser
When Admin gives the correct LMS portal URL
Then Admin should see user in gray color

Scenario: Verify input descrikptive test in password field
Given Admin launch the browser
When Admin gives the correct LMS portal URL
Then Admin should see password in gray color

Scenario: Validate login with valid credentials
Given Admin is in homepage
When Admin  enter valid credentials and click login button
Then Admin should land on Dashboard page

Scenario: Validate login with invalid credentials
Given Admin is in homepage
When Admin enter invalid credentials and login button
Then Error messege please check the username/password

Scenario: Validate  login credentials with null username
Given Admin is in homepage
When  Admin enter value only in password and clicks login button
Then Error messege please check the username/password

Scenario: Validate login credentials with null password 
Given Admin is in homepage
When Admin enter value only in username and clicks login button
Then Error messege please check usrname /password


Scenario: Verify login button action through keyboard
Given Admin is in homepage
When Admin enter valid credentials and clicks login button through keyboard
Then Admin should land on dashboardpage


Scenario: Verify login button action through mouse
Given Admin is in homepage
When Admin enter valid credentials and clicks login button through mouse
Then Admin should land on dashboard page




