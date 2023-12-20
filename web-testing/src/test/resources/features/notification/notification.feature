@Notification

  Feature: Notification
    As an admin
    I want to see the notification
    So that I know the latest notifications

    Background:
      Given I've been logged in

    @PositiveCase
    Scenario: As an admin I can see notification with valid steps
      When I click notification
      Then I am on notification page
#      And I click detail notification
#      Then I can see detail of complaint

#    @PositiveCase
#    Scenario: As an admin I can see FAQ from notification page
#      When I click notification
#      And I am on notification page
#      And I click FAQ button
#      Then I am on FAQ page
#      And I can see list of FAQ
