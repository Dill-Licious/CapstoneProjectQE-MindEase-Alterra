package starter.stepdefinitions.Doctors_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Doctors.GetAllDoctors;

public class GetAllDoctors_Steps {
    @Steps
    GetAllDoctors getAllDoctors;

    @Given("I set the API endpoint to get all doctors in MindEase App")
    public void setAPIEndpointGetAllDoctors(){
        getAllDoctors.setAPIEndpointGetAllDoctors();
    }

    @When("I send a request to get all doctors in MindEase App")
    public void sendRequestGetAllDoctors(){
        getAllDoctors.sendRequestGetAllDoctors();
    }

    @Then("I receive a valid list of doctors data")
    public void receiveListDoctors(){
        getAllDoctors.receiveListDoctors();
    }
}
