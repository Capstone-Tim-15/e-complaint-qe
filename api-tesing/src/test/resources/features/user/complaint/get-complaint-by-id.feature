@Complaint

  @GetComplaintById
  Feature: Get Complaint By Id
    As a user
    I want to get complaint by id
    So that I receive list of complaint by Id

  @PositiveCase
  Scenario: As a user I can get complaint by id with valid credentials
    Given I set "valid" endpoint for get complaint by id
    When I send get request to "valid" get complaint by id endpoint
    Then I receive status code 200
    And I receive list of complaint by Id


  @NegativeCase
  Scenario: As a user I can not get complaint by id with invalid endpoint
     Given I set "invalid" endpoint for get complaint by id
     When I send get request to "invalid" get complaint by id endpoint
     Then I receive status code 404
     And I receive auth error message

