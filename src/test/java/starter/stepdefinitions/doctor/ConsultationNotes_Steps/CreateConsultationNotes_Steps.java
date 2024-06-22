package starter.stepdefinitions.doctor.ConsultationNotes_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.doctor.ConsultationNotes.CreateConsultationNotes;

public class CreateConsultationNotes_Steps {
    @Steps
    CreateConsultationNotes createConsultationNotes;

    @Given("I set the API endpoint to create consultation notes to give recommendation to patient")
    public void setAPIEndpointCreateConsultationNotes(){
        createConsultationNotes.setAPIEndpointCreateConsultationNotes();
    }

    @When("I send a request to create consultation notes to patient")
    public void sendRequestCreateConsultationNotes(){
        createConsultationNotes.sendRequestCreateConsultationNotes();
    }

    @Then("I should receive a data confirmation indicating success in adding the consultation note")
    public void receiveDataConfirmSuccessAddConsultationNotes(){
        createConsultationNotes.receiveDataConfirmSuccessAddConsultationNotes();
    }
}
