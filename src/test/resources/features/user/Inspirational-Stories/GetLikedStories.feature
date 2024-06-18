@GetLikedStories
Feature: Get liked stories
  As a user
  I want to retrieve a list of stories that I have liked
  So that I can easily access and read my favorite stories again

  @GetLikedStories-Valid
  Scenario: Successfully retrieve liked stories
    Given I set the API endpoint to get liked stories in MindEase App
    When I send a request to get liked stories in MindEase App
    And I should receive a status code of 200 OK
    Then I should receive a response containing a list of liked stories