@ResetPassword
Feature: Reset Password
    As a User
    I want to reset my password if I forget it
    So that I can regain access to my account

    @ResetPassword-Valid
    Scenario: Successfully reset password with valid credentials
        Given I set the API endpoint to reset password in MindEase App
        When I send a request to reset password in MindEase App
        And I should receive a status code of 200 OK
        Then I should receive a data confirmation that indicating reset password success