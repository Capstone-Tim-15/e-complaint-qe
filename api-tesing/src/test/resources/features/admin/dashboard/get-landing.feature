@Dashboard

  @TotalData(Landing)
  Feature: Get Total Data (Landing)
    As an admin
    I want to get total data
    So that I receive the total data

  @PositiveCase
  Scenario: As an admin I can get total data with valid credentials
    Given I set "valid" endpoint for get total data
    When I send get request to "valid" get total data endpoint
    Then I receive status code 200
    And I receive the total data

  @NegativeCase
  Scenario: As an admin I can not get total data with invalid endpoint
    Given I set "invalid" endpoint for get total data
    When I send get request to "invalid" get total data endpoint
    Then I receive status code 404
    And I receive auth error message

  @NegativeCase
  Scenario: As an admin I can not get total data without token
    Given I set "valid" endpoint for get total data
    When I send get request to valid get total data endpoint without token
    Then I receive status code 401
    And I receive auth error message