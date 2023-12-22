@News
Feature: Delete News
  As an admin
  I can delete news
  So that the news can be deleted

  Background:
    Given I am on home page
    When I click login menu
    And I redirect to login page
    And I input valid username for login
    And I input valid password for login
    And I click login button
    Then I am on dashboard page

  Scenario: As an admin I can delete news with valid steps
    When I click news button
    Then I am on the news page
    When I click delete button
    And I click yes button
    Then I redirected to the news page

  Scenario: As an admin I can delete news with valid steps
    When I click news button
    Then I am on the news page
    When I click delete button
    And I click no button
    Then I redirected to the news page


