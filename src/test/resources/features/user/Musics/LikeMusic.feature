@LikeMusic
Feature: Like a Music
    As a User
    I want to like a music track
    So that it gets added to my list of liked musics

    @LikeMusic-Valid
    Scenario: Successfully like a music track
        Given I set the API endpoint to like a music in MindEase App
        When I send a request to like a music in MindEase App
        And I should receive a status code of 201 Created
        Then I should receive a data confirmation that indicate like music success