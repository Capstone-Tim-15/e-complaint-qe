@RegisterAdmin
  Feature: Register Admin
    As an admin
    I want to register
    So that I receive my detail account

    @PositiveCase
    Scenario: As an admin I can register with valid credentials
      Given I set "valid" endpoint for admin register
      When I send post request with valid requestBody to "valid" admin register endpoint
      Then I receive status code 201
      And I receive my detail account

    @NegativeCase
    Scenario: As an admin I can not register with invalid endpoint
      Given I set "invalid admin base" endpoint for admin register
      When I send post request with valid requestBody to "invalid" admin register endpoint
      Then I receive status code 404
      And I receive auth error message

    @NegativeCase
    Scenario: As an admin I can not register with username of more than 16 characters
      Given I set "valid" endpoint for admin register
      When I send post request with "username of more than 16 characters" to valid admin register endpoint
      Then I receive status code 400
      And I receive error message

    @NegativeCase
    Scenario: As an admin I can not register with empty name
      Given I set "valid" endpoint for admin register
      When I send post request with "empty name" to valid admin register endpoint
      Then I receive status code 400
      And I receive error message

    @NegativeCase
    Scenario: As an admin I can not register with empty username
      Given I set "valid" endpoint for admin register
      When I send post request with "empty username" to valid admin register endpoint
      Then I receive status code 400
      And I receive error message

    @NegativeCase
    Scenario: As an admin I can not register with empty email
      Given I set "valid" endpoint for admin register
      When I send post request with "empty email" to valid admin register endpoint
      Then I receive status code 400
      And I receive error message

    @NegativeCase
    Scenario: As an admin I can not register with empty phone
      Given I set "valid" endpoint for admin register
      When I send post request with "empty phone" to valid admin register endpoint
      Then I receive status code 400
      And I receive error message

    @NegativeCase
    Scenario: As an admin I can not register with empty password
      Given I set "valid" endpoint for admin register
      When I send post request with "empty password" to valid admin register endpoint
      Then I receive status code 400
      And I receive error message

    @NegativeCase
    Scenario: As an admin I can not register with integer password
      Given I set "valid" endpoint for admin register
      When I send post request with "integer password" to valid admin register endpoint
      Then I receive status code 400
      And I receive error message

    @NegativeCase
    Scenario: As an admin I can not register with registered email
      Given I set "valid" endpoint for admin register
      When I send post request with "registered email" to valid admin register endpoint
      Then I receive status code 409
      And I receive error message

    @NegativeCase
    Scenario: As an admin I can not register with registered username
      Given I set "valid" endpoint for admin register
      When I send post request with "registered username" to valid admin register endpoint
      Then I receive status code 409
      And I receive error message

    @NegativeCase
    Scenario: As an admin I can not register with get request
      Given I set "valid" endpoint for admin register
      When I send "get" request to admin register
      Then I receive status code 401
      And I receive auth error message

    @NegativeCase
    Scenario: As an admin I can not register with put request
      Given I set "valid" endpoint for admin register
      When I send "put" request to admin register
      Then I receive status code 401
      And I receive auth error message

    @NegativeCase
    Scenario: As an admin I can not register with delete request
      Given I set "valid" endpoint for admin register
      When I send "delete" request to admin register
      Then I receive status code 401
      And I receive auth error message