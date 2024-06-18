package starter.stepdefinitions.user.OTP_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.OTP.SendOTP;

public class SendOTP_Steps {
    @Steps
    SendOTP sendOTP;

    @Given("I set the API endpoint to request OTP in MindEase App")
    public void setAPIEndpointRequestOTP(){
        sendOTP.setAPIEndpointRequestOTP();
    }

    @When("I send a request to send a OTP in MindEase App")
    public void sendRequestToSendOTP(){
        sendOTP.sendRequestToSendOTP();
    }

    @Then("I should receive a data confirmation indicate success send OTP")
    public void receiveDataConfirmSuccessSendOTP(){
        sendOTP.receiveDataConfirmSuccessSendOTP();
    }
}
