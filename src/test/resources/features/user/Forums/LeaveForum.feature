@LeaveForum
Feature: Leave forum
    As a user
    I want to leave a forum
    So that I can stop receiving notifications and updates from that forum

    @LeaveForum-Valid
    Scenario: Successfully leave a forum
        Given I set the API endpoint to leave a forum in MindEase App
        When I send a request to leave a forum in MindEase App
        And I should receive a status code of 200 OK
        Then I should receive a data confirmation that indicate success leave forum