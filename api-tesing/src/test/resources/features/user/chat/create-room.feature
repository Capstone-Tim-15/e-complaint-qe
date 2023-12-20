@Chat

  @CreateRoom
  Feature: Create Room
    As a user
    I want to create room chat
    So the room chat is created

  @PositiveCase
  Scenario: As a user I can create room chat with valid credentials
    Given I set "valid" endpoint for create room chat
    When I send post request to "valid" create room chat endpoint
    Then I receive status code 201
    And I receive message that room chat is created

  @NegativeCase
  Scenario: As a user I can not create room chat with invalid endpoint
    Given I set "invalid" endpoint for create room chat
    When I send post request to "invalid" create room chat endpoint
    Then I receive status code 404
    And I receive auth error message

  @NegativeCase
    Scenario: As a user I can not create room chat without token
      Given I set "valid" endpoint for create room chat
      When I send post request to create room chat endpoint without token
      Then I receive status code 401
      And I receive auth error message