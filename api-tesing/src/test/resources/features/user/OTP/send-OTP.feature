@OTP

  Feature: OTP
    As a user
    I want to send otp
    So that I receive otp

  @PositiveCase
  Scenario: As a user I can send otp with valid credentials
    Given I set "valid" endpoint for send otp user
    When I send post request to "valid" send otp user endpoint
    Then I receive status code 201
    And I receive otp user

  @NegativeCase
  Scenario: As a user I can not send otp with invalid endpoint
    Given I set "invalid" endpoint for send otp user
    When I send post request to "invalid" send otp user endpoint
    Then I receive status code 404
    And I receive auth error message