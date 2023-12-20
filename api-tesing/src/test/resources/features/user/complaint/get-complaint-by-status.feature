@Complaint

@GetComplaintByStatus
Feature: Get Complaint By Status
  As a user
  I want to get complaint by status
  So that I receive list of complaint by status

  @PositiveCase
  Scenario: As a user I can get solved complaint with valid credentials
    Given I set "valid" endpoint for get complaint by status
    When I send get request to "solved" get complaint by status endpoint
    Then I receive status code 200
    And I receive list of solved complaint

  @PositiveCase
  Scenario: As a user I can get unsolved complaint with valid credentials
    Given I set "valid" endpoint for get complaint by status
    When I send get request to "unsolved" get complaint by status endpoint
    Then I receive status code 200
    And I receive list of unsolved complaint

  @NegativeCase
  Scenario: As a user I can not get complaint by status with invalid endpoint
    Given I set "invalid" endpoint for get complaint by status
    When I send get request to "invalid" get complaint by status endpoint
    Then I receive status code 404
    And I receive auth error message