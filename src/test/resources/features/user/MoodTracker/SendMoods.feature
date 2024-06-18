@SendMood
Feature: Record Daily Moods in MindEase App
    As a User
    I want to record and send my mood everyday
    So that I can track my emotional well-being over time

    @SendMood-Valid
    Scenario: Successfully send mood
        Given I set the API endpoint to send mood data in MindEase App
        When I send a request to send mood in MindEase App
        And I should receive a status code of 201 Created
        Then I should receive a data confirmation that send mood success