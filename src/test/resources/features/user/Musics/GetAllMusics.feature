@Get-AllMusic
Feature: Get all meditation music
  As a User
  I want to have access to a comprehensive collection of meditation music
  So that I can easily find and listen to music that helps me relax and meditate effectively

  @Get-AllMusic-Valid
  Scenario:  Get all valid meditation music
    Given I set the API endpoint to get all meditation music
    When I send a request to get all meditation music
    And I should receive a status code of 200 OK
    Then I should receive all valid data about the musics