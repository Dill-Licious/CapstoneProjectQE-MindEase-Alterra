package starter.stepdefinitions.user.Music_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Musics.GetLikedMusics;

public class GetLikedMusics_Steps {
    @Steps
    GetLikedMusics getLikedMusics;

    @Given("I set the API endpoint to get liked musics in MindEase App")
    public void setAPIEndpointGetLikedMusics(){
        getLikedMusics.setAPIEndpointGetLikedMusics();
    }

    @When("I send a request to get liked musics in MindEase App")
    public void sendRequestGetLikedMusics(){
        getLikedMusics.sendRequestGetLikedMusics();
    }

    @Then("I should receive list data of liked musics")
    public void receiveListOfLikedMusics(){
        getLikedMusics.receiveListOfLikedMusics();
    }
}
