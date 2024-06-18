@GetLikedMusics
Feature: Get Liked Musics
  As a User
  I want to retrieve a list of musics that I have liked
  So that I can easily access and listen to my favorite songs

  @GetLikedMusics-Valid
  Scenario: Successfully retrieve liked musics
    Given I set the API endpoint to get liked musics in MindEase App
    When I send a request to get liked musics in MindEase App
    And I should receive a status code of 200 OK
    Then I should receive list data of liked musics
