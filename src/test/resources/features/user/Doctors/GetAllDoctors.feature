@GetAllDoctors
Feature: Get all doctors data
  As a User
  I want to retrieve a list of all doctors
  So that I can view information about all available doctors

  @GetAllDoctors-Valid
  Scenario: Successfully retrieve all doctors data
    Given I set the API endpoint to get all doctors in MindEase App
    When I send a request to get all doctors in MindEase App
    And I should receive a status code of 200 OK
    Then I receive a valid list of doctors data