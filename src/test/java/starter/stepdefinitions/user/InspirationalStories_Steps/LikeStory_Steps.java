package starter.stepdefinitions.user.InspirationalStories_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.InspirationalStories.LikeStory;

public class LikeStory_Steps {
    @Steps
    LikeStory likeStory;

    @Given("I set the API endpoint to like a story in MindEase App")
    public void setAPIEndpointLikeStory(){
        likeStory.setAPIEndpointLikeStory();
    }

    @When("I send a request to like a story in MindEase App")
    public void sendRequestLikeStory(){
        likeStory.sendRequestLikeStory();
    }

    @Then("I should receive a data confirmation that indicate like story success")
    public void receiveMessageLikeStorySuccess(){
        likeStory.receiveMessageLikeStorySuccess();
    }
}
