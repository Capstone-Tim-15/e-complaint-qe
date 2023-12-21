@Category

@GetCategoryById
Feature: Get Complaint By Id
  As a user
  I want to get category by id
  So that I receive list of category by Id

  @PositiveCase
  Scenario: As a user I can get category by id with valid credentials
    Given I set "valid" endpoint for get category by id
    When I send get request to "valid" get category by id endpoint
    Then I receive status code 200
    And I receive detail category


  @NegativeCase
  Scenario: As a user I can not get category by id with invalid endpoint
    Given I set "invalid" endpoint for get category by id
    When I send get request to "invalid" get category by id endpoint
    Then I receive status code 404
    And I receive auth error message

  @NegativeCase
  Scenario: As a user I can not get category by id without token
    Given I set "invalid" endpoint for get category by id
    When I send get request to valid get category by id endpoint without token
    Then I receive status code 401
    And I receive auth error message