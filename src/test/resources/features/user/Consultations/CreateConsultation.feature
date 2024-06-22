@CreateConsultation
Feature: Create consultation with doctor
  As a User
  I want to create a consultation with a doctor
  So that I can receive personalized medical advice and support


  @CreateConsultation-Valid
  Scenario: Create consultation with valid credentials
    Given I set the API endpoint to create consultation in MindEase App
    When I send a request to create consultation in MindEase App
    And I should receive a status code of 201 Created
    Then I should receive a data confirmation indicate consultation was created successfully, including the schedule and doctor's details