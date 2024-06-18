package starter.stepdefinitions.user.Music_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Musics.GetMusicByID;

public class GetMusicByID_Steps {
    @Steps
    GetMusicByID getMusicByID;

    @Given("I set the API endpoint to get specific music by ID in MindEase App")
    public void setAPIEndpointGetMusicByID(){
        getMusicByID.setAPIEndpointGetMusicByID();
    }

    @When("I send a request to get music by specific ID in MindEase App")
    public void sendRequestGetMusicByID(){
        getMusicByID.sendRequestGetMusicByID();
    }

    @Then("I should receive the music data for the specified ID")
    public void receiveMusicDataSpecificID(){
        getMusicByID.receiveMusicDataSpecificID();
    }
}
