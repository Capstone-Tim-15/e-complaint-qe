@Dashboard

@UserStatistic
Feature: User Statistic
  As an admin
  I want to get user statistic
  So that I receive the user statistic

  @PositiveCase
  Scenario: As an admin I can get user statistic with valid credentials
    Given I set "valid" endpoint for get user statistic
    When I send get request to "valid" get user statistic endpoint
    Then I receive status code 200
    And I receive the user statistic

  @NegativeCase
  Scenario: As an admin I can not get user statistic with invalid endpoint
    Given I set "invalid" endpoint for get user statistic
    When I send get request to "invalid" get user statistic endpoint
    Then I receive status code 404
    And I receive auth error message

  @NegativeCase
  Scenario: As an admin I can not get user statistic without token
    Given I set "valid" endpoint for get user statistic
    When I send get request to valid get user statistic endpoint without token
    Then I receive status code 401
    And I receive auth error message