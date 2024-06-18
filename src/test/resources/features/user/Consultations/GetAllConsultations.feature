@GetAllConsultations
Feature: Get All Consultation in MindEase App
    As a User
    I want to be able to view all my consultations
    So that I can keep track of my consultation history

    @GetAllConsultations-Valid
    Scenario: Successfully get all consultations
        Given I set the API endpoint to get all consultations in MindEase App
        When I send a request to get all consultations in MindEase App
        And I should receive a status code of 200 OK
        Then I should receive a data confirmation that indicates a successful retrieval of consultations with data