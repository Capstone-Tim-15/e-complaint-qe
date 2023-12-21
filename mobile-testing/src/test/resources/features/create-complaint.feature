@CreateComplaint

  Feature: Create Complaint
    As a user
    I want to create complaint
    So that my complaint will be sent

  @PositiveCase
  Scenario: As a user I can create complaint with valid credentials
    Given I've been logged in
    When I click create complaint
    And I input complaint field
    And I add attachment
    And I choose location
    And I choose category complaint
    And I click posting
    Then I redirect to home page