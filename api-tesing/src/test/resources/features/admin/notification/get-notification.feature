@Notification

  Feature: Notification
    As an admin
    I want to get notification
    So that I receive the notification

  @PositiveCase
  Scenario: As an admin I can get notif with valid credentials
    Given I set "valid" endpoint for get notif
    When I send get request to "valid" get notif endpoint
    Then I receive status code 200
    And I receive the notif

  @NegativeCase
  Scenario: As an admin I can not get notif with invalid endpoint
    Given I set "invalid" endpoint for get notif
    When I send get request to "invalid" get notif endpoint
    Then I receive status code 404
    And I receive auth error message

  @NegativeCase
  Scenario: As an admin I can not get notif without token
    Given I set "valid" endpoint for get notif
    When I send get request to valid get notif endpoint without token
    Then I receive status code 401
    And I receive auth error message