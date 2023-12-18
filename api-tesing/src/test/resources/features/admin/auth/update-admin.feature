@UpdateAdmin
  Feature: Update Admin
    As an admin
    I want to update my account
    So my account will be updated

    @PositiveCase
    Scenario: As an admin I can update admin with valid credentials
      Given I set "valid" endpoint for update admin
      When I send put request with "valid requestBody" to valid update admin endpoint
      Then I receive status code 200
      And I receive my detail account

    @NegativeCase
    Scenario: As an admin I can not update admin with invalid endpoint
      Given I set "invalid" endpoint for update admin
      When I send put request with valid requestBody to "invalid" update admin endpoint
      Then I receive status code 404
      And I receive auth error message

    @NegativeCase
    Scenario: As an admin I can not update admin with invalid id
      Given I set "invalid id" endpoint for update admin
      When I send put request with valid requestBody to "invalid id" update admin endpoint
      Then I receive status code 404
      And I receive error message

    @NegativeCase
    Scenario: As an admin I can not update admin with username of more than 16 characters
      Given I set "valid" endpoint for update admin
      When I send put request with "username of more than 16 characters" to valid update admin endpoint
      Then I receive status code 400
      And I receive error message

    @PositiveCase
    Scenario: As an admin I can not update admin with empty name
      Given I set "valid" endpoint for update admin
      When I send put request with "empty name" to valid update admin endpoint
      Then I receive status code 200
      And I receive my detail account

    @PositiveCase
    Scenario: As an admin I can not update admin with empty username
      Given I set "valid" endpoint for update admin
      When I send put request with "empty username" to valid update admin endpoint
      Then I receive status code 200
      And I receive my detail account

    @PositiveCase
    Scenario: As an admin I can not update admin with empty email
      Given I set "valid" endpoint for update admin
      When I send put request with "empty email" to valid update admin endpoint
      Then I receive status code 200
      And I receive my detail account

    @PositiveCase
    Scenario: As an admin I can not register with empty phone
      Given I set "valid" endpoint for update admin
      When I send put request with "empty phone" to valid update admin endpoint
      Then I receive status code 200
      And I receive my detail account

    @PositiveCase
    Scenario: As an admin I can not update admin with empty password
      Given I set "valid" endpoint for update admin
      When I send put request with "empty password" to valid update admin endpoint
      Then I receive status code 200
      And I receive my detail account

    @PositiveCase
    Scenario: As an admin I can not update admin with integer password
      Given I set "valid" endpoint for update admin
      When I send put request with "integer password" to valid update admin endpoint
      Then I receive status code 400
      And I receive error message

    @NegativeCase
    Scenario: As an admin I can not update admin with registered email
      Given I set "valid" endpoint for update admin
      When I send put request with "registered email" to valid update admin endpoint
      Then I receive status code 409
      And I receive error message

    @NegativeCase
    Scenario: As an admin I can not update admin with registered username
      Given I set "valid" endpoint for update admin
      When I send put request with "registered username" to valid update admin endpoint
      Then I receive status code 409
      And I receive error message

    @NegativeCase
    Scenario: As an admin I can not update admin with post request
      Given I set "valid" endpoint for update admin
      When I send "post" request to update admin
      Then I receive status code 404
      And I receive auth error message