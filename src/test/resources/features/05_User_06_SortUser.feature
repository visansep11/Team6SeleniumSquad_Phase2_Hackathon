@SortUser
Feature: Sort User
  
Background: Admin is on dashboard page after Login and clicks User on the navigation bar
  
  @SortUserByID
  Scenario: Sort user by id
    Given Admin is on Manage User Page
    When Admin clicks on ID sort icon
    Then Admin should see User details are sorted by id
    

  @SortUserByName
  Scenario: Sort user by name
    Given Admin is on Manage User Page
    When Admin clicks on name sort icon
    Then Admin should see User details are sorted by name

@SortUserByName
  Scenario: Sort user by location
    Given Admin is on Manage User Page
    When Admin clicks on location sort icon
    Then Admin should see User details are sorted by location
    
   @SortUserByPhoneNumber
  Scenario: Sort user by Phone number
    Given Admin is on Manage User Page
    When Admin clicks on Phone number sort icon
    Then Admin should see User details are sorted by Phone number
    
    
