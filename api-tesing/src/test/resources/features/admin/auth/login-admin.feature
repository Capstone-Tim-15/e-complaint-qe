@AdminLogin
  Feature: Admin Login
    As an admin
    I want to login
    So that I receive my token account

    @PositiveCase
    Scenario: As an admin I can login with valid credentials
      Given I set "valid" endpoint for admin login
      When I send post request with valid requestBody to "valid" admin login endpoint
      Then I receive status code 200
      And I receive my token account

    @NegativeCase
    Scenario: As an admin I can not login with invalid endpoint
      Given I set "valid" endpoint for admin login
      When I send post request with valid requestBody to "invalid" admin login endpoint
      Then I receive status code 404
      And I receive auth error message

    @NegativeCase
    Scenario: As an admin I can not login with invalid username
      Given I set "valid" endpoint for admin login
      When I send post request with "invalid username" to valid admin login endpoint
      Then I receive status code 400
      And I receive error message

    @NegativeCase
    Scenario: As an admin I can not login with invalid password
      Given I set "valid" endpoint for admin login
      When I send post request with "invalid password" to valid admin login endpoint
      Then I receive status code 400
      And I receive error message

    @NegativeCase
    Scenario: As an admin I can not login with empty username
      Given I set "valid" endpoint for admin login
      When I send post request with "empty username" to valid admin login endpoint
      Then I receive status code 400
      And I receive error message

    @NegativeCase
    Scenario: As an admin I can not login with empty password
      Given I set "valid" endpoint for admin login
      When I send post request with "empty password" to valid admin login endpoint
      Then I receive status code 400
      And I receive error message

    @NegativeCase
    Scenario: As an admin I can not login with integer password
      Given I set "valid" endpoint for admin login
      When I send post request with "integer password" to valid admin login endpoint
      Then I receive status code 400
      And I receive error message

    @NegativeCase
    Scenario: As an admin I can not login with get request
      Given I set "valid" endpoint for admin login
      When I send "get" request to admin login
      Then I receive status code 401
      And I receive auth error message

    @NegativeCase
    Scenario: As an admin I can not login with put request
      Given I set "valid" endpoint for admin login
      When I send "put" request to admin login
      Then I receive status code 401
      And I receive auth error message

    @NegativeCase
    Scenario: As an admin I can not login with delete request
      Given I set "valid" endpoint for admin login
      When I send "delete" request to admin login
      Then I receive status code 401
      And I receive auth error message
