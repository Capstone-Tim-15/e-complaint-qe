@GetAllUser
  Feature: Get All User
    As a user
    I want to get all user
    So that I can get list of user

    @PositiveCase
    Scenario: As a user I can get all user with valid credentials
      Given I set "valid" endpoint for get all user
      When I send get request to "valid" get all user endpoint
      Then I receive status code 200
      And I receive list of user

    @NegativeCase
    Scenario: As a user I can not get all user with invalid endpoint
      Given I set "invalid" endpoint for get all user
      When I send get request to "invalid" get all user endpoint
      Then I receive status code 404
      And I receive auth error message

    @NegativeCase
    Scenario: As a user I can not get all user with post request
      Given I set "valid" endpoint for get all user
      When I send "post" request to get all user
      Then I receive status code 404
      And I receive auth error message

    @NegativeCase
    Scenario: As a user I can not get all user with put request
      Given I set "valid" endpoint for get all user
      When I send "put" request to get all user
      Then I receive status code 404
      And I receive auth error message

    @NegativeCase
    Scenario: As a user I can not get all user with delete request
      Given I set "valid" endpoint for get all user
      When I send "delete" request to get all user
      Then I receive status code 404
      And I receive auth error message