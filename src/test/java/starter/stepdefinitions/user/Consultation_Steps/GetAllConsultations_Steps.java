package starter.stepdefinitions.user.Consultation_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Consultation.GetAllConsultations;

public class GetAllConsultations_Steps {
    @Steps
    GetAllConsultations getAllConsultations;

    @Given("I set the API endpoint to get all consultations in MindEase App")
    public void setAPIEndpointGetAllConsultations(){
        getAllConsultations.setAPIEndpointGetAllConsultations();
    }

    @When("I send a request to get all consultations in MindEase App")
    public void sendRequestGetAllConsultations(){
        getAllConsultations.sendRequestGetAllConsultations();
    }

    @Then("I should receive a data confirmation that indicates a successful retrieval of consultations with data")
    public void receiveConfirmMessageSuccessGetAllDataConsultations(){
        getAllConsultations.receiveConfirmMessageSuccessGetAllDataConsultations();
    }
}
