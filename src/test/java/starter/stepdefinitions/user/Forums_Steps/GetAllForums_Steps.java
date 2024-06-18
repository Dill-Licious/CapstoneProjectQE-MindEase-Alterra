package starter.stepdefinitions.user.Forums_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Forums.GetAllForums;

public class GetAllForums_Steps {
    @Steps
    GetAllForums getAllForums;

    @Given("I set the API endpoint to get all forums in MindEase App")
    public void setAPIEndpointGetAllForums(){
        getAllForums.setAPIEndpointGetAllForums();
    }

    @When("I send a request to get all forums in MindEase App")
    public void sendRequestGetAllForums(){
        getAllForums.sendRequestGetAllForums();
    }

    @Then("I should receive a data confirmation contain list of forums")
    public void receiveListOfForums(){
        getAllForums.receiveListOfForums();
    }
}
