package starter.stepdefinitions.user.Forums_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Forums.LeaveForum;

public class LeaveForum_Steps {
    @Steps
    LeaveForum leaveForum;

    @Given("I set the API endpoint to leave a forum in MindEase App")
    public void setAPIEndpointLeaveForum(){
        leaveForum.setAPIEndpointLeaveForum();
    }

    @When("I send a request to leave a forum in MindEase App")
    public void sendRequestLeaveForum(){
        leaveForum.sendRequestLeaveForum();
    }

    @Then("I should receive a data confirmation that indicate success leave forum")
    public void receiveDataConfirmSuccessLeaveForum(){
        leaveForum.receiveDataConfirmSuccessLeaveForum();
    }
}
