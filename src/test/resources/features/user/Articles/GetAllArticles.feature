@GetAllArticles
Feature: Get all data articles
  As a user
  I want to get all data articles
  So that I can view and read all available articles

  @GetAllArticles-Valid
  Scenario: Retrieve all articles successfully
    Given I set the API endpoint to get all articles in MindEase App
    When I send a request to get all articles in MindEase App
    And I should receive a status code of 200 OK
    Then I should receive all valid data about the articles