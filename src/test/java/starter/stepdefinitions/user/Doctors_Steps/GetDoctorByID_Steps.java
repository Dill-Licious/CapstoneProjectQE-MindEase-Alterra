package starter.stepdefinitions.Doctors_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Doctors.GetDoctorByID;

public class GetDoctorByID_Steps {
    @Steps
    GetDoctorByID getDoctorByID;

    @Given("I set the API endpoint to get specific doctor information by ID in MindEase App")
    public void setAPIEndpointGetDoctorInfoByID(){
        getDoctorByID.setAPIEndpointGetDoctorInfoByID();
    }

    @When("I send a request to get specific doctor information by ID in MindEase App")
    public void sendRequestGetDoctorInfoByID(){
        getDoctorByID.sendRequestGetDoctorInfoByID();
    }

    @Then("I receive valid data information of the doctor")
    public void receiveValidDoctorInfo(){
        getDoctorByID.receiveValidDoctorInfo();
    }
}
