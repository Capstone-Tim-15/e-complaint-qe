@OTP

Feature: OTP Admin
  As an admin
  I want to send otp
  So that I receive otp

  @PositiveCase
  Scenario: As an admin I can send otp with valid credentials
    Given I set "valid" endpoint for send otp admin
    When I send post request to "valid" send otp admin endpoint
    Then I receive status code 201
    And I receive otp admin

  @NegativeCase
  Scenario: As an admin I can not send otp with invalid endpoint
    Given I set "invalid" endpoint for send otp admin
    When I send post request to "invalid" send otp admin endpoint
    Then I receive status code 404
    And I receive auth error message