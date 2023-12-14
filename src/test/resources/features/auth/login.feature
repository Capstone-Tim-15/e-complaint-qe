@Auth

  @Login
  Feature: Login
    As an admin
    I want to login
    So that I redirect to dashboard


  Background:
    Given I am on home page
    When I click login menu

  @PositiveCase
  Scenario: As an admin I can login with valid credentials
     And I redirect to login page
     And I input valid username for login
     And I input valid password for login
     And I click login button
     Then I am on dashboard page

  @NegativeCase
  Scenario: As an admin I can not login with invalid username
     And I redirect to login page
     And I input invalid username for login
     And I input valid password for login
     And I click login button
     Then I receive error message "Username or Password Incorrect!"

  @NegativeCase
  Scenario: As an admin I can not login with invalid password
     And I redirect to login page
     And I input valid username for login
     And I input invalid password for login
     And I click login button
     Then I receive error message "Username or Password Incorrect!"

  @NegativeCase
  Scenario: As an admin I can not login without username
     And I redirect to login page
     And I empty username for login
     And I input valid password for login
     And I click login button
     Then I receive error message "Missing Username or Password"

  @NegativeCase
  Scenario: As an admin I can not login without password
     And I redirect to login page
     And I input valid username for login
     And I empty password for login
     And I click login button
     Then I receive error message "Missing Username or Password"