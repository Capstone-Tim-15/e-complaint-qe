@Complaint

  @GetAllComplaint
  Feature: Get All Complaint
    As a user
    I want to get all complaint
    So that I receive list of complaint

  @PositiveCase
  Scenario: As a user I can get all complaint with valid credentials
    Given I set "valid" endpoint for get all complaint
    When I send get request to "valid" get all complaint endpoint
    Then I receive status code 200
    And I receive list of complaint

  @NegativeCase
  Scenario: As a user I can not get all complaint with invalid endpoint
    Given I set "invalid" endpoint for get all complaint
    When I send get request to "invalid" get all complaint endpoint
    Then I receive status code 404
    And I receive auth error message


