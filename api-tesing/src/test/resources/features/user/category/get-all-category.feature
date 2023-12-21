@Category

@GetAllCategory
Feature: Get All Category
  As a user
  I want to get all category
  So that I receive list of category

  @PositiveCase
  Scenario: As a user I can get all category with valid credentials
    Given I set "valid" endpoint for get all category
    When I send get request to "valid" get all category endpoint
    Then I receive status code 200
    And I receive list of category

  @NegativeCase
  Scenario: As a user I can not get all category with invalid endpoint
    Given I set "invalid" endpoint for get all category
    When I send get request to "invalid" get all category endpoint
    Then I receive status code 404
    And I receive auth error message


  @NegativeCase
  Scenario: As a user I can not get all category without token
    Given I set "invalid" endpoint for get all category
    When I send get request to valid get all category endpoint without token
    Then I receive status code 401
    And I receive auth error message
