Feature: Get All notification
    As a doctor
    I want to retrieve all notifications
    So that I can stay updated with the latest patient activities and system alerts

    Scenario: Successfully retrieve all notifications
        Given I set the API endpoint to get all notification in MindEase App
        When I send a request to get all notification in MindEase App
        And I should receive a status code of 200 OK
        Then I should receive a data confirmation about list of notification