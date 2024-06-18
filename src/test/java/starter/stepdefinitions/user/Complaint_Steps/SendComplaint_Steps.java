package starter.stepdefinitions.user.Complaint_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Complaint.SendComplaint;

public class SendComplaint_Steps {
    @Steps
    SendComplaint sendComplaint;

    @Given("I set the API endpoint to send a complaint in MindEase App")
    public void setAPIEndpointSendComplaint(){
        sendComplaint.setAPIEndpointSendComplaint();
    }

    @When("I send a request to send a complaint in MindEase App")
    public void sendRequestSendComplaint(){
        sendComplaint.sendRequestSendComplaint();
    }

    @Then("I should receive a data confirmation that indicate success send a complaint")
    public void receiveSendComplaintSuccess(){
        sendComplaint.receiveSendComplaintSuccess();
    }
}
