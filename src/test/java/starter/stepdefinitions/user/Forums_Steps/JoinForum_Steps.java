package starter.stepdefinitions.user.Forums_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Forums.JoinForum;

public class JoinForum_Steps {
    @Steps
    JoinForum joinForum;

    @Given("I set the API endpoint to join a forum in MindEase App")
    public void setAPIEndpointJoinForum(){
        joinForum.setAPIEndpointJoinForum();
    }

    @When("I send a request to join a forum in MindEase App")
    public void sendRequestJoinForum(){
        joinForum.sendRequestJoinForum();
    }

    @Then("I should receive a data confirmation that indicate success join forum")
    public void receiveSuccessMessageJoinForum(){
        joinForum.receiveSuccessMessageJoinForum();
    }
}
