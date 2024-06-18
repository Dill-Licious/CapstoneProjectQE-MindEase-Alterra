package starter.stepdefinitions.user.ChatRooms;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.ChatRooms.GetAllChatRooms;

public class GetAllChatRooms_Steps {
    @Steps
    GetAllChatRooms getAllChatRooms;

    @Given("I set the API endpoint to get all chat rooms in MindEase App")
    public void setAPIEndpointGetAllChatRooms(){
        getAllChatRooms.setAPIEndpointGetAllChatRooms();
    }

    @When("I send a request to get all chat rooms in MindEase App")
    public void sendRequestGetAllChatRooms(){
        getAllChatRooms.sendRequestGetAllChatRooms();
    }

    @Then("I should receive a data confirmation about success message and list data about the chat")
    public void receiveListChatRooms(){
        getAllChatRooms.receiveListChatRooms();
    }
}
