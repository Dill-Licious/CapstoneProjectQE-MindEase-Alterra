package starter.stepdefinitions.user.Music_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Musics.LikeMusic;

public class LikeMusic_Steps {
    @Steps
    LikeMusic likeMusic;

    @Given("I set the API endpoint to like a music in MindEase App")
    public void setAPIEndpointLikeMusic(){
        likeMusic.setAPIEndpointLikeMusic();
    }

    @When("I send a request to like a music in MindEase App")
    public void sendRequestLikeMusic(){
        likeMusic.sendRequestLikeMusic();
    }

    @Then("I should receive a data confirmation that indicate like music success")
    public void receiveMessageSuccessLikeMusic(){
        likeMusic.receiveMessageSuccessLikeMusic();
    }
}
