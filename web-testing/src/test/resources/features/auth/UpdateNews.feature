@News
Feature: Update News
  As an admin
  I can update news
  So that news can be updated

  Background:
    Given I am on home page
    When I click login menu
    And I redirect to login page
    And I input valid username for login
    And I input valid password for login
    And I click login button
    Then I am on dashboard page

  Scenario: As an admin I can update news with valid steps
    When I click news button
    Then I am on the news page
    When I click icon edit
    Then I am on the create news page
    And I delete date before
    And I enter valid date
    And I delete news title before
    And I enter valid news title
    And I delete news content
    And I enter valid news content
    And I click save button
    Then I am on the news page


  Scenario: As an admin I cannot update news with invalid steps
    When I click news button
    Then I am on the news page
    When I click icon edit
    Then I am on the create news page
    And I delete date before
    And I enter invalid date
    And I delete news title before
    And I enter invalid news title
    And I delete news content
    And I enter invalid news content
    And I click save button
    Then I redirected to the news page



