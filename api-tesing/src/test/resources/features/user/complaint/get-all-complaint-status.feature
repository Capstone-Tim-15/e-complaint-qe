@Complaint

@GetAllComplaintStatus
Feature: Get All Complaint Status
  As a user
  I want to get all complaint status
  So that I receive list of complaint status

  @PositiveCase
  Scenario: As a user I can get all complaint status with valid credentials
    Given I set "valid" endpoint for get all complaint status
    When I send get request to "valid" get all complaint status endpoint
    Then I receive status code 200
    And I receive list of complaint status

  @NegativeCase
  Scenario: As a user I can not get all complaint status with invalid endpoint
    Given I set "invalid" endpoint for get all complaint status
    When I send get request to "invalid" get all complaint status endpoint
    Then I receive status code 404
    And I receive auth error message