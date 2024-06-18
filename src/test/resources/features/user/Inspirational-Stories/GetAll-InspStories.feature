@GetAllInspirationalStories
Feature: Get all inspirational stories
  As a User
  I want to get all inspirational stories
  So that I can view and read various inspirational stories

  @GetAllInspirationalStories-Valid
  Scenario: Successfully retrieve all inspirational stories
    Given I set the API endpoint to get all inspirational stories in MindEase App
    When I send a request to get all inspirational stories in MindEase App
    And I should receive a status code of 200 OK
    Then I should receive all valid data about the inspirational stories
