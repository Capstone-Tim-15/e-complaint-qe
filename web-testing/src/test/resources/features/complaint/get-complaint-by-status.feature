@Complaint

  @GetComplaintByStatus
  Feature: Get Complaint By Status
    As an admin
    I want to get complaint by status
    So that the complaint will sorted

  @PositiveCase
  Scenario: As an admin I can sorted the complaint by send status with valid credentials
    Given I've been logged in
    When I click complaint menu
    And I click category complaint dropdown
    And I choose category complaint to "SEND"
    Then The complaint will be sorted by "SEND"

  @PositiveCase
  Scenario: As an admin I can sorted the complaint by processed status with valid credentials
    Given I've been logged in
    When I click complaint menu
    And I click category complaint dropdown
    And I choose category complaint to "Diproses"
    Then The complaint will be sorted by "Diproses"

  @PositiveCase
  Scenario: As an admin I can sorted the complaint by send completed with valid credentials
    Given I've been logged in
    When I click complaint menu
    And I click category complaint dropdown
    And I choose category complaint to "Selesai"
    Then The complaint will be sorted by "Selesai"