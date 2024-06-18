@SendChatToDoctor
Feature: Send Chat to Doctor
    As a User
    I want to send a chat message to a doctor
    So that I can receive medical advice and support

    @SendChatToDoctor-Valid
    Scenario: Successfully send chat to doctor
        Given I set the API endpoint to send chat to doctor in MindEase App
        When I send a request to send chat to doctor in MindEase App
        And I should receive a status code of 201 Created
        Then I should receive a data confirmation that indicate success send message