@Dashboard

  Feature: Dashboard
    As an admin
    I wan to get statistic data
    So that I up to date

  Background:
    Given I've been logged in

  @PositiveCase
  Scenario: As an admin I can get user statistic with valid steps
    When I am on dashboard page
    Then I can see the user statistic

  @PositiveCase
  Scenario: As an admin I can get complaint statistic with valid steps
    When I am on dashboard page
    Then I can see the complaint statistic

  @PositiveCase
  Scenario: As an admin I can get resolved category statistic with valid steps
    When I am on dashboard page
    Then I can see the resolved category statistic