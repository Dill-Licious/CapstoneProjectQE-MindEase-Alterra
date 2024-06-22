package starter.stepdefinitions.doctor.ChatMessages_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.doctor.ChatMessages.SendChatToPatient;

public class SendChatToPatient_Steps {
    @Steps
    SendChatToPatient sendChatToPatient;

    @Given("I set the API endpoint to send a chat message to patient in MindEase App")
    public void setAPIEndpointSendChatToPatient(){
        sendChatToPatient.setAPIEndpointSendChatToPatient();
    }

    @When("I send a request to send a chat message in MindEase App")
    public void sendRequestSendChatToPatient(){
        sendChatToPatient.sendRequestSendChatToPatient();
    }

    @Then("I should receive a data confirmation indicate success send chat to patient")
    public void receiveDataConfirmSuccessSendChatToPatient(){
        sendChatToPatient.receiveDataConfirmSuccessSendChatToPatient();
    }
}
