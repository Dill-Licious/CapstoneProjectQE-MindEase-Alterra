package starter.stepdefinitions.user.SendMessages_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.SendMessages.GetAllChatMessageByID;

public class GetAllChatMessageByID_Steps {
    @Steps
    GetAllChatMessageByID getAllChatMessageByID;

    @Given("I set the API endpoint to get all messages by ID in MindEase App")
    public void setAPIEndpointGetAllMessageByID(){
        getAllChatMessageByID.setAPIEndpointGetAllMessageByID();
    }

    @When("I send a request to get all chat messages by ID in MindEase App")
    public void sendRequestGetAllChatMessagesByID(){
        getAllChatMessageByID.sendRequestGetAllChatMessagesByID();
    }

    @Then("I should receive a data confirmation that indicate retrieve chat messages by id success")
    public void receiveDataConfirmSuccessRetrieveChatMessagesByID(){
        getAllChatMessageByID.receiveDataConfirmSuccessRetrieveChatMessagesByID();
    }

}
