@News
Feature: Create News
  As an admin
  I can create news
  So that news can be created

  Background:
    Given I am on home page
    When I click login menu
    And I redirect to login page
    And I input valid username for login
    And I input valid password for login
    And I click login button
    Then I am on dashboard page

  Scenario: As an admin I can create news with valid credentials
    When I click news button
    Then I am on the news page
    When I click add news button
    Then I am on the create news page
    And I enter valid news title
    And I enter valid news content
    And I click save button
    And I am on the news page

  Scenario: As an admin I cant create news with invalid credentials
    And I click news button
    When I click add news button
    And I enter invalid news title
    And I enter invalid news content
    And I click save button
    And I am on the create news page


