Feature: Send OTP
    As a user
    I want to request an OTP
    So that I can verify my identity or complete an action that requires additional security

    Scenario: Successfully request OTP
        Given I set the API endpoint to request OTP in MindEase App
        When I send a request to send a OTP in MindEase App
        And I should receive a status code of 201 Created
        Then I should receive a data confirmation indicate success send OTP