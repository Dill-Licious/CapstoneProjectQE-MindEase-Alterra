package starter.stepdefinitions.user.Music_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Musics.GetAllMusics;

public class GetAllMusics_Steps {
    @Steps
    GetAllMusics getAllMusics;

    @Given("I set the API endpoint to get all meditation music")
    public void setAPIEndpointGetAllMusics(){
        getAllMusics.setAPIEndpointGetAllMusics();
    }

    @When("I send a request to get all meditation music")
    public void sendRequestGetGetAllMusics(){
        getAllMusics.sendRequestGetGetAllMusics();
    }

    @Then("I should receive all valid data about the musics")
    public void receiveAllMusicData(){
        getAllMusics.receiveAllMusicData();
    }
}
