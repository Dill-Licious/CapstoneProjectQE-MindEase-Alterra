package starter.stepdefinitions.user.MoodTracker_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.MoodTracker.GetMoodByID;

public class GetMoodByID_Steps {
    @Steps
    GetMoodByID getMoodByID;

    @Given("I set the API endpoint to get mood data by user ID in MindEase App")
    public void setAPIEndpointGetMoodByID(){
        getMoodByID.setAPIEndpointGetMoodByID();
    }

    @When("I send a request to get mood data by user ID in MindEase App")
    public void sendRequestGetMoodByID(){
        getMoodByID.sendRequestGetMoodByID();
    }

    @Then("I should receive data about the user's mood")
    public void receiveTheUserMood(){
        getMoodByID.receiveTheUserMood();
    }
}
