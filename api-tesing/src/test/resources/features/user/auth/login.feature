@UserLogin

  Feature: User Login
    As a user
    I want to login
    So that I receive my token account

    @PositiveCase
    Scenario: As a user I can login with valid credentials
      Given I set "valid" endpoint for user login
      When I send post request with valid requestBody to "valid" user login endpoint
      Then I receive status code 200
      And I receive my token account

    @NegativeCase
    Scenario: As a user I can not login with unregistered username
      Given I set "valid" endpoint for user login
      When I send post request with "unregistered username" to valid user login endpoint
      Then I receive status code 400
      And I receive error message

    @NegativeCase
    Scenario: As a user I can not login with integer password
      Given I set "valid" endpoint for user login
      When I send post request with "integer password" to valid user login endpoint
      Then I receive status code 400
      And I receive error message

    @NegativeCase
    Scenario: As a user I can not login with empty username
      Given I set "valid" endpoint for user login
      When I send post request with "empty username" to valid user login endpoint
      Then I receive status code 400
      And I receive error message

    @NegativeCase
    Scenario: As a user I can not login with empty password
      Given I set "valid" endpoint for user login
      When I send post request with "empty password" to valid user login endpoint
      Then I receive status code 400
      And I receive error message

    @NegativeCase
    Scenario: As a user I can not login with get request
      Given I set "valid" endpoint for user login
      When I send "get" request to user login
      Then I receive status code 401
      And I receive auth error message

    @NegativeCase
    Scenario: As a user I can not login with put request
      Given I set "valid" endpoint for user login
      When I send "put" request to user login
      Then I receive status code 401
      And I receive auth error message
