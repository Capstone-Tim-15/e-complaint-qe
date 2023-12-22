@Complaint

  @GetComplaintByCategory
  Feature: Get Complaint By Category
    As a user
    I want to get complaint by category
    So that I receive list of complaint by category

  @PositiveCase
  Scenario: As a user I can complaint by category with valid credentials
    Given I set "valid" endpoint for get complaint by category
    When I send get request to "valid" get complaint by category endpoint
    Then I receive status code 200
    And I receive list of complaint by category


  @NegativeCase
  Scenario: As a user I can not get complaint by category with invalid endpoint
     Given I set "invalid" endpoint for get complaint by category
     When I send get request to "invalid" get complaint by category endpoint
     Then I receive status code 404
     And I receive auth error message

