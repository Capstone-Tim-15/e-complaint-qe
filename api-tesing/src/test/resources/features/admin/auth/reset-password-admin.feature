@ResetPasswordAdmin

  Feature: Reset Password Admin
    As an admin
    I want to reset my password
    So that my password will be changed

    Background:
      Given I set valid endpoint for reset password admin

    @PositiveCase
    Scenario: As an admin I can reset password with valid credentials
      When I send post request with "valid requestBody" to valid reset password admin endpoint
      Then I receive status code 200
      And I receive my detail account

    @NegativeCase
    Scenario: As an admin I can not reset password with empty new password
      When I send post request with "empty new password" to valid reset password admin endpoint
      Then I receive status code 400
      And I receive error message

    @NegativeCase
    Scenario: As an admin I can not reset password with empty confirm password
      When I send post request with "empty confirm password" to valid reset password admin endpoint
      Then I receive status code 400
      And I receive error message

    @NegativeCase
    Scenario: As an admin I can not reset password with empty invalid password
      When I send post request with "invalid confirm password" to valid reset password admin endpoint
      Then I receive status code 400
      And I receive error message

    @NegativeCase
    Scenario: As an admin I can not reset password without login
      When I send post request to valid reset password admin endpoint without login
      Then I receive status code 401
      And I receive auth error message