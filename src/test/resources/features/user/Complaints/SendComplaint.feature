@SendRequest
Feature: Send Complaint
    As a User
    I want to submit a complaint
    So that I can report an issue or provide feedback to improve the service

    @SendRequest-Valid
    Scenario: Successfully send complaint
        Given I set the API endpoint to send a complaint in MindEase App
        When I send a request to send a complaint in MindEase App
        And I should receive a status code of 201 Created
        Then I should receive a data confirmation that indicate success send a complaint