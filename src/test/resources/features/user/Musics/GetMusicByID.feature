@GetMusicByID
Feature: Get specific music by ID
  As a User
  I want to get music by specific id
  So that i can search the music that i wanted

  @GetMusicByID-Valid
  Scenario: Retrieve music by specific ID successfully
    Given I set the API endpoint to get specific music by ID in MindEase App
    When I send a request to get music by specific ID in MindEase App
    And I should receive a status code of 200 OK
    Then I should receive the music data for the specified ID