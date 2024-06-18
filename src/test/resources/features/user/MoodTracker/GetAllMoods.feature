@GetAllMoods
Feature: Get All Moods Data
    As a User
    I want to retrieve all moods
    So that I can see the range of emotions shared by the community

    @GetAllMoods-Valid
    Scenario: Successfully retrieves all moods data
        Given I set the API endpoint to get all moods data in MindEase App
        When I send a request to get all moods data in MindEase App
        And I should receive a status code of 200 OK
        Then I should receive all valid data about list of moods