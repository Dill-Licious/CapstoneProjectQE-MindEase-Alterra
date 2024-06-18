@JoinForum
Feature: Join Forum
  As a user
  I want to join a forum
  So that I can participate in discussions and access forum content

  @JoinForum-Valid
  Scenario: Successfully join a forum
    Given I set the API endpoint to join a forum in MindEase App
    When I send a request to join a forum in MindEase App
    And I should receive a status code of 201 Created
    Then I should receive a data confirmation that indicate success join forum