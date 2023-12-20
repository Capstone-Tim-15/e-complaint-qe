@Complaint

  Feature: Change Complaint Status
    As an admin
    I want to change complaint status
    So the complaint status will be changed

  @PositiveCase
  Scenario: As an admin I can change complaint status to send with valid credentials
    Given I've been logged in
    When I click complaint menu
    And I click change status icon
    And I changed the complaint status to "SEND"
    And I click change button
    Then The status has changed to "SEND"

  @PositiveCase
  Scenario: As an admin I can change complaint status to processed with valid credentials
    Given I've been logged in
    When I click complaint menu
    And I click change status icon
    And I changed the complaint status to "Diproses"
    And I click change button
    Then The status has changed to "Diproses"

  @PositiveCase
  Scenario: As an admin I can change complaint status to completed with valid credentials
    Given I've been logged in
    When I click complaint menu
    And I click change status icon
    And I changed the complaint status to "Selesai"
    And I click change button
    Then The status has changed to "Selesai"

  @NegativeCase
  Scenario: As an admin I can not chang complaint status if I click close button
    Given I've been logged in
    When I click complaint menu
    And I click change status icon
    And I changed the complaint status to "Diproses"
    And I click close button
    Then I am on complaint page