package starter.stepdefinitions.user.InspirationalStories_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.InspirationalStories.GetInspirationalStoryByID;

public class GetInspirationalStoryByID_Steps {
    @Steps
    GetInspirationalStoryByID getInspirationalStoryByID;

    @Given("I set the API endpoint to get specific inspirational story by ID in MindEase App")
    public void setAPIEndpointGetSpecificInspStoryByID(){
        getInspirationalStoryByID.setAPIEndpointGetSpecificInspStoryByID();
    }

    @When("I send a request to get specific inspirational story by ID in MindEase App")
    public void sendRequestGetSpecificInspStoryByID(){
        getInspirationalStoryByID.sendRequestGetSpecificInspStoryByID();
    }

    @Then("I should receive the inspirational story for the specified ID")
    public void receiveInspStoryValidDataByID(){
        getInspirationalStoryByID.receiveInspStoryValidDataByID();
    }
}
