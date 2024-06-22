Feature: Send chat to patient
    As a Doctor
    I want to send chat messages to patients
    So that I can provide them with real-time support and recommendations

    Scenario: Successfully send a chat message to a patient
        Given I set the API endpoint to send a chat message to patient in MindEase App
        When I send a request to send a chat message in MindEase App
        And I should receive a status code of 201 Created
        Then I should receive a data confirmation indicate success send chat to patient