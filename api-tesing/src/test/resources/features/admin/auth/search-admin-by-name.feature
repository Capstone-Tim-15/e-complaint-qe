@SearchAdmin

  @SearchAdminByName
  Feature: Search Admin By Name
    As an admin
    I want to search admin by name
    So I receive that admin detail account

    @PositiveCase
    Scenario: As an admin I can search admin by name with valid credentials
      Given I set "valid endpoint" for search admin by name
      When I send get request to "valid" search admin by name endpoint
      Then I receive status code 200
      And I receive that admin detail account

    @NegativeCase
    Scenario: As an admin I can not search admin by name with invalid endpoint
      Given I set "invalid endpoint" for search admin by name
      When I send get request to "invalid" search admin by name endpoint
      Then I receive status code 404
      And I receive auth error message

    @NegativeCase
    Scenario: As an admin I can not search admin by name without login
      Given I set "valid endpoint" for search admin by name
      When I send get request to valid search admin by name endpoint without login
      Then I receive status code 401
      And I receive auth error message
