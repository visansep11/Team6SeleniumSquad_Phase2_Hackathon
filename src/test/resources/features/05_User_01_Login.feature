Feature: Home Page Verification

  Background: Admin gives the correct LMS portal URL
    Given Admin launch the browser

  @Signin_page(valid)
  Scenario Outline: Validate login with valid credentials
    When Admin enter valid "<user>" and valid "<password>" credentials  and clicks login button
    Then Admin should land on dashboard page

    Examples: 
      | user                     | password       |
      | sdetorganizers@gmail.com | UIHackathon@02 |
