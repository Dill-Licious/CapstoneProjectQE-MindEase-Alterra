package starter.stepdefinitions.user.Feedbacks_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Feedbacks.CreateFeedback;

public class CreateFeedback_Steps {
    @Steps
    CreateFeedback createFeedback;

    @Given("I set the API endpoint to create doctor feedback with valid credentials")
    public void setAPIEndpointCreateFeedback(){
        createFeedback.setAPIEndpointCreateFeedback();
    }

    @When("I send a request to create doctor feedback with valid credentials")
    public void sendRequestCreateFeedback(){
        createFeedback.sendRequestCreateFeedback();
    }

    @Then("I should receive data confirmation that indicate success create feedback")
    public void receiveDataConfirmSuccessCreateFeedback(){
        createFeedback.receiveDataConfirmSuccessCreateFeedback();
    }
}
