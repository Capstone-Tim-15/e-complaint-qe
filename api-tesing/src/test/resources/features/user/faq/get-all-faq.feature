@FAQ

  Feature: FAQ
    As a user
    I want to get all faq
    So that I receive list of faq

  @PositiveCase
  Scenario: As a user I can get all faq with valid credentials
    Given I set "valid" endpoint for get all faq
    When I send get request to "valid" get all faq endpoint
    Then I receive status code 200
    And I receive list of faq

  @NegativeCase
  Scenario: As a user I can not get all faq with invalid endpoint
    Given I set "invalid" endpoint for get all faq
    When I send get request to "invalid" get all faq endpoint
    Then I receive status code 404
    And I receive auth error message

  @NegativeCase
  Scenario: As a user I can not get all faq without token
    Given I set "valid" endpoint for get all faq
    When I send get request to valid get all faq endpoint without token
    Then I receive status code 401
    And I receive auth error message