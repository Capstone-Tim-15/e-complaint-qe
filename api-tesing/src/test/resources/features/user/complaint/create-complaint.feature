@Complaint

  @CreateComplaint
  Feature: Create Complaint
    As a user
    I want to create complaint
    So that my complaint will be sent to admin

    @PositiveCase
    Scenario: As a user I can create complaint with valid credentials
      Given I set "valid" endpoint for create complaint
      When I send post request with "valid requestBody" to valid create complaint endpoint
      Then I receive status code 201
      And I receive my detail complaint

    @NegativeCase
    Scenario: As a user I can not create complaint with invalid endpoint
      Given I set "invalid" endpoint for create complaint
      When I send post request with valid requestBody to invalid create complaint endpoint
      Then I receive status code 404
      And I receive auth error message

    @NegativeCase
    Scenario: As a user I can not create complaint without invalid ID
      Given I set "valid" endpoint for create complaint
      When I send post request with "invalid categoryId" to valid create complaint endpoint
      Then I receive status code 400
      And I receive error message

    @NegativeCase
    Scenario: As a user I can not create complaint without title
      Given I set "valid" endpoint for create complaint
      When I send post request with "empty title" to valid create complaint endpoint
      Then I receive status code 400
      And I receive error message

    @NegativeCase
    Scenario: As a user I can not create complaint without content
      Given I set "valid" endpoint for create complaint
      When I send post request with "empty content" to valid create complaint endpoint
      Then I receive status code 400
      And I receive error message

    @NegativeCase
    Scenario: As a user I can not create complaint without attachment
      Given I set "valid" endpoint for create complaint
      When I send post request with "empty attachment" to valid create complaint endpoint
      Then I receive status code 400
      And I receive error message

    @NegativeCase
    Scenario: As a user I can not create complaint without login
      Given I set "valid" endpoint for create complaint
      When I send post request with valid requestBody to create complaint endpoint without login
      Then I receive status code 401
      And I receive auth error message