@Register
Feature: Register into MindEase Application
  As a User
  I want to register into MindEase Application
  So that I can use all the feature to improve my mental health

  @Register-Valid
  Scenario: Register with valid credentials
    Given I set the API endpoint to register MindEase App
    When I send a request to register into MindEase App with valid credentials
    And I should receive a status code of 201 Created
    Then I should receive a data confirmation that indicating register success

  @Register-AllFieldsEmpty
  Scenario: Register with all fields empty
    Given I set the API endpoint to register MindEase App
    When I send a request to register into MindEase App with all fields is empty
    And I should receive a status code of 400 Bad Request
    Then I should receive an error message indicate fullname, username, email or password cannot be empty