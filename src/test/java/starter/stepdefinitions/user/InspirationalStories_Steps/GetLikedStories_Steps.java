package starter.stepdefinitions.user.InspirationalStories_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.InspirationalStories.GetLikedStories;

public class GetLikedStories_Steps {
    @Steps
    GetLikedStories getLikedStories;

    @Given("I set the API endpoint to get liked stories in MindEase App")
    public void setAPIEndpointGetLikedStories(){
        getLikedStories.setAPIEndpointGetLikedStories();
    }

    @When("I send a request to get liked stories in MindEase App")
    public void sendRequestGetLikedStories(){
        getLikedStories.sendRequestGetLikedStories();
    }

    @Then("I should receive a response containing a list of liked stories")
    public void receiveListOfLikedStories(){
        getLikedStories.receiveListOfLikedStories();
    }
}
