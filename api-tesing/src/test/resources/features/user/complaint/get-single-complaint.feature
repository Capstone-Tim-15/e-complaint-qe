@Complaint

  @GetSingleComplaint
  Feature: Get Single Complaint
    As a user
    I want to get single complaint
    So that I receive detail complaint

  @PositiveCase
  Scenario: As a user I can get single complaint with valid credentials
    Given I set "valid" endpoint for get single complaint
    When I send get request to "valid" get single complaint endpoint
    Then I receive status code 200
    And I receive detail complaint


  @NegativeCase
  Scenario: As a user I can not get single complaint with invalid endpoint
     Given I set "invalid" endpoint for get single complaint
     When I send get request to "invalid" get single complaint endpoint
     Then I receive status code 404
     And I receive auth error message

