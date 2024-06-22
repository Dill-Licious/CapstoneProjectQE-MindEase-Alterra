Feature: Create Consultation Notes
    As a Doctor
    I want to create consultation notes
    So that I can document patient consultations effectively

    Scenario: Successfully create a consultation notes
        Given I set the API endpoint to create consultation notes to give recommendation to patient
        When I send a request to create consultation notes to patient
        And I should receive a status code of 201 Created
        Then I should receive a data confirmation indicating success in adding the consultation note