package starter.stepdefinitions.user.SendMessages_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.SendMessages.SendChatToDoctor;

public class SendChatToDoctor_Steps {
    @Steps
    SendChatToDoctor sendChatToDoctor;

    @Given("I set the API endpoint to send chat to doctor in MindEase App")
    public void setAPIEndpointSendChatToDoctor(){
        sendChatToDoctor.setAPIEndpointSendChatToDoctor();
    }

    @When("I send a request to send chat to doctor in MindEase App")
    public void sendRequestChatToDoctor(){
        sendChatToDoctor.sendRequestChatToDoctor();
    }

    @Then("I should receive a data confirmation that indicate success send message")
    public void receiveMessageSuccessSendMood(){
        sendChatToDoctor.receiveConfirmMessageSendMoodSuccess();
    }
}
