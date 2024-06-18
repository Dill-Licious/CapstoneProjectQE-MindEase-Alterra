@GetAllForums
Feature: Get All Forums
  As a user
  I want to view a list of all forums
  So that I can find and join forums that interest me

  @GetAllForums-Valid
  Scenario: Successfully retrieve a list of all forums
    Given I set the API endpoint to get all forums in MindEase App
    When I send a request to get all forums in MindEase App
    And I should receive a status code of 200 OK
    Then I should receive a data confirmation contain list of forums