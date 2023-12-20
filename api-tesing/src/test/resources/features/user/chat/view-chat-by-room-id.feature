@Chat

@GetChatByRoomId
Feature: Get Chat By Room Id
  As a user
  I want to get chat by room id
  So that I receive the chat

  @PositiveCase
  Scenario: As a user I can get chat by room id with valid credentials
    Given I set "valid" endpoint for get chat by room id
    When I send get request to "valid" get chat by room id endpoint
    Then I receive status code 200
    And I receive detail chat

  @NegativeCase
  Scenario: As a user I can not get chat by room id with invalid endpoint
    Given I set "invalid" endpoint for get chat by room id
    When I send get request to "invalid" get chat by room id endpoint
    Then I receive status code 404
    And I receive auth error message

  @NegativeCase
  Scenario: As a user I can not get chat by room id without token
    Given I set "valid" endpoint for get chat by room id
    When I send get request to valid get chat by room id endpoint without token
    Then I receive status code 401
    And I receive auth error message