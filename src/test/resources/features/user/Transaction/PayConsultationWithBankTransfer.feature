#@PayConsultationBankTF
#Feature: Pay Consultation with bank transfer
#  As a User
#  I want to be able to pay for my consultations using bank transfer
#  So that I can choose the most convenient option for me
#
#  @PayConsultationBankTF-Valid
#  Scenario: Successfully pay consultation with bank transfer
#    Given I set the API endpoint to pay consultation with bank transfer
#    When I send a request to pay consultation with bank transfer
#    And I should receive a status code of 201 Created
#    Then I should receive a data confirmation about the transaction details and a link to make the payment