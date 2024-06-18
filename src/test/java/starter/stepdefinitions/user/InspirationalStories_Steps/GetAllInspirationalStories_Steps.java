package starter.stepdefinitions.InspirationalStories_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.InspirationalStories.GetAllInspirationalStories;

public class GetAllInspirationalStories_Steps {
    @Steps
    GetAllInspirationalStories getAllInspirationalStories;

    @Given("I set the API endpoint to get all inspirational stories in MindEase App")
    public void setAPIEndpointGetAllInspirationalStories(){
        getAllInspirationalStories.setAPIEndpointGetAllInspirationalStories();
    }

    @When("I send a request to get all inspirational stories in MindEase App")
    public void sendRequestGetAllInspirationalStories(){
        getAllInspirationalStories.sendRequestGetAllInspirationalStories();
    }

    @Then("I should receive all valid data about the inspirational stories")
    public void receiveInspirationalStoriesData(){
        getAllInspirationalStories.receiveInspirationalStoriesData();
    }
}
