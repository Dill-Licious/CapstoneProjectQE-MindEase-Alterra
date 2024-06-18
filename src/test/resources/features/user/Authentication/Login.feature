@Login
Feature: Login into MindEase Application
  As a User
  I want to login into MindE

  @Login-Valid
  Scenario: Login into MindEase App with valid credentials
    Given I set the API endpoint to login into MindEase App
    When I send a request to login into MindEase App with valid credentials
    And I should receive a status code of 200 OK
    Then I should receive a data confirmation that indicating success login

  @Login-InvalidUsername
  Scenario: Login into MindEase App with invalid username
    Given I set the API endpoint to login into MindEase App
    When I send a request to login into MindEase App with invalid username
    And I should receive a status code of 404 Not Found
    Then I should receive an error message indicate user not found

  @Login-EmptyUsernamePassword
  Scenario: Login into MindEase App with empty username and password
    Given I set the API endpoint to login into MindEase App
    When I send a request to login into MindEase App with empty username and password
    And I should receive a status code of 400 Bad Request
    Then I should receive an error message indicate username or password cannot be empty