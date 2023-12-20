@SearchAdmin

  Feature: Search Admin By Id
    As an admin
    I want to search admin
    So I receive that admin detail account

    @PositiveCase
    Scenario: As an admin I can search admin by id with valid credentials
      Given I set "valid endpoint" for search admin by id
      When I send get request to "valid" search admin by id endpoint
      Then I receive status code 200
      And I receive that admin detail account

    @NegativeCase
    Scenario: As an admin I can not search admin by id with invalid endpoint
      Given I set "invalid endpoint" for search admin by id
      When I send get request to "invalid" search admin by id endpoint
      Then I receive status code 404
      And I receive auth error message

    @NegativeCase
    Scenario: As an admin I can not search admin by id without login
      Given I set "valid endpoint" for search admin by id
      When I send get request to valid search admin by id endpoint without login
      Then I receive status code 401
      And I receive auth error message

    @NegativeCase
    Scenario: As an admin I can not search admin with query params id&name
      Given I set "valid endpoint" for search admin by id
      When I send get request to "double query params" search admin by id endpoint
      Then I receive status code 400
      And I receive error message
