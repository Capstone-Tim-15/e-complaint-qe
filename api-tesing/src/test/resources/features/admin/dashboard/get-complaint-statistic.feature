@Dashboard

@ComplaintStatistic
Feature: Complaint Statistic
  As an admin
  I want to get complaint statistic
  So that I receive the complaint statistic

  @PositiveCase
  Scenario: As an admin I can get complaint statistic with valid credentials
    Given I set "valid" endpoint for get complaint statistic
    When I send get request to "valid" get complaint statistic endpoint
    Then I receive status code 200
    And I receive the complaint statistic

  @NegativeCase
  Scenario: As an admin I can not get complaint statistic with invalid endpoint
    Given I set "invalid" endpoint for get complaint statistic
    When I send get request to "invalid" get complaint statistic endpoint
    Then I receive status code 404
    And I receive auth error message

  @NegativeCase
  Scenario: As an admin I can not get complaint statistic without token
    Given I set "valid" endpoint for get complaint statistic
    When I send get request to valid get complaint statistic endpoint without token
    Then I receive status code 401
    And I receive auth error message