@GetInspirationalStoriesByID
Feature: Get inspirational stories by ID
  As a User
  I want to retrieve all inspirational stories by their unique IDs
  So that I can easily access and read specific inspirational stories

  @GetInspirationalStoriesByID-Valid
  Scenario: Retrieve inspirational story by specific ID successfully
    Given I set the API endpoint to get specific inspirational story by ID in MindEase App
    When I send a request to get specific inspirational story by ID in MindEase App
    And I should receive a status code of 200 OK
    Then I should receive the inspirational story for the specified ID