package starter.stepdefinitions.user.Consultation_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Consultation.CreateConsultation;

public class CreateConsultation_Steps {
    @Steps
    CreateConsultation createConsultation;

    @Given("I set the API endpoint to create consultation in MindEase App")
    public void setAPIEndpointCreateConsultation(){
        createConsultation.setAPIEndpointCreateConsultation();
    }

    @When("I send a request to create consultation in MindEase App")
    public void sendRequestCreateConsultation(){
        createConsultation.sendRequestCreateConsultation();
    }

    @Then("I should receive a data confirmation indicate consultation was created successfully, including the schedule and doctor's details")
    public void receiveDataConfirmConsultationWasCreated(){
        createConsultation.receiveDataConfirmConsultationWasCreated();
    }
}
