@GetAllChatMessagesByID
Feature: Get all chat messages by chat_id
    As a User
    I want to retrieve all chat messages by chat ID
    So that I can view the entire conversation history with the doctor

  @GetAllChatMessagesByID-Valid
  Scenario: Successfully retrieve chat messages to the doctor by ID
    Given I set the API endpoint to get all messages by ID in MindEase App
    When I send a request to get all chat messages by ID in MindEase App
    And I should receive a status code of 200 OK
    Then I should receive a data confirmation that indicate retrieve chat messages by id success