@GetMoodByID
Feature: Get Mood By ID
  As a User
  I want to retrieve the mood associated with a specific ID
  so that I can understand the emotional context of that ID

  @GetMoodByID-Valid
  Scenario: Successfully retrieve mood by valid ID
    Given I set the API endpoint to get mood data by user ID in MindEase App
    When I send a request to get mood data by user ID in MindEase App
    And I should receive a status code of 200 OK
    Then I should receive data about the user's mood