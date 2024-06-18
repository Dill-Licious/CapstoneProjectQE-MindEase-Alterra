package starter.stepdefinitions.user.MoodTracker_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.MoodTracker.SendMood;

public class SendMood_Steps {
    @Steps
    SendMood sendMood;

    @Given("I set the API endpoint to send mood data in MindEase App")
    public void setAPIEndpointSendMood(){
        sendMood.setAPIEndpointSendMood();
    }

    @When("I send a request to send mood in MindEase App")
    public void sendRequestSendMood(){
        sendMood.sendRequestSendMood();
    }

    @Then("I should receive a data confirmation that send mood success")
    public void receiveMessageSuccessSendMood(){
        sendMood.receiveMessageSuccessSendMood();
    }
}
