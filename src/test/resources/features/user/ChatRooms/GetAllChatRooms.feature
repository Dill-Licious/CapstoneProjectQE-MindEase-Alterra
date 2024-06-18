@GetAllChatRooms
Feature: Get all chat rooms
  As a User
  I want to view all available chat rooms
  So that I can engage in conversations with other users

  @GetAllChatRooms-Valid
  Scenario: Successfully retrieve all chat rooms
    Given I set the API endpoint to get all chat rooms in MindEase App
    When I send a request to get all chat rooms in MindEase App
    And I should receive a status code of 200 OK
    Then I should receive a data confirmation about success message and list data about the chat