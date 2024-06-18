@CreateFeedback
Feature: Create Feedback
    As a user
    I want to create a doctor feedback
    So that I can share my experience and help others in their decision-making

    @CreateFeedback-Valid
    Scenario: Submit feedback with valid credentials
        Given I set the API endpoint to create doctor feedback with valid credentials
        When I send a request to create doctor feedback with valid credentials
        And I should receive a status code of 201 Created
        Then I should receive data confirmation that indicate success create feedback