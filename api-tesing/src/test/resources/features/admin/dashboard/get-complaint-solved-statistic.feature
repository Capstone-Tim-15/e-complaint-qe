@Dashboard

@ComplaintSolvedStatistic
Feature: Complaint Solved Statistic
  As an admin
  I want to get complaint solved statistic
  So that I receive the complaint statistic

  @PositiveCase
  Scenario: As an admin I can get complaint solved statistic with valid credentials
    Given I set "valid" endpoint for get solved statistic
    When I send get request to "valid" get solved statistic endpoint
    Then I receive status code 200
    And I receive the complaint statistic

  @NegativeCase
  Scenario: As an admin I can not get complaint solved statistic with invalid endpoint
    Given I set "invalid" endpoint for get solved statistic
    When I send get request to "invalid" get solved statistic endpoint
    Then I receive status code 404
    And I receive auth error message

  @NegativeCase
  Scenario: As an admin I can not get complaint solved statistic without token
    Given I set "valid" endpoint for get solved statistic
    When I send get request to valid get solved statistic endpoint without token
    Then I receive status code 401
    And I receive auth error message