@Auth

  @Logout
  Feature: Logout
    As an admin
    I want to logout
    So that I redirect to login page

    Background:
      Given I've been logged in

    @PositiveCase
    Scenario: As an admin I can logout with valid steps
      When I click logout menu
      And I click logout
      Then I redirect to login page

    @NegativeCase
    Scenario: As an admin I can not logout if I click cancel
      When I click logout menu
      And I click cancel
      Then I am on dashboard page