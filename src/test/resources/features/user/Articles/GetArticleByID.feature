@GetArticleByID
Feature: Get all articles by specific ID
  As a User
  I want to get all articles by a specific ID
  So that I can view and read a particular article

  @GetArticleByID-Valid
  Scenario: Retrieve article by specific ID successfully
    Given I set the API endpoint to get article by specific ID in MindEase App
    When I send a request to get article by specific ID in MindEase App
    And I should receive a status code of 200 OK
    Then I should receive the article data for the specified ID