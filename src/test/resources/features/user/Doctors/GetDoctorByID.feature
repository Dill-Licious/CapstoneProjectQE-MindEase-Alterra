@GetDoctorByID
Feature: Get Doctor By Specific ID
  As a User
  I want to retrieve information about a specific doctor by their ID
  So that I can view their details and contact them if needed

  @GetDoctorByID-Valid
  Scenario: Successfully get information of a doctor by valid ID
    Given I set the API endpoint to get specific doctor information by ID in MindEase App
    When I send a request to get specific doctor information by ID in MindEase App
    And I should receive a status code of 200 OK
    Then I receive valid data information of the doctor
