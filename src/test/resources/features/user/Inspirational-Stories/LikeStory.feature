@LikeStory
Feature: Like a Story
    As a User
    I want to like a story
    So that I can save it to my liked stories list for future reference

    @LikeStory-Valid
    Scenario: Successfully like a story
        Given I set the API endpoint to like a story in MindEase App
        When I send a request to like a story in MindEase App
        And I should receive a status code of 201 Created
        Then I should receive a data confirmation that indicate like story success