package starter.stepdefinitions.MoodTracker_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.MoodTracker.GetAllMoods;

public class GetAllMoods_Steps {
    @Steps
    GetAllMoods getAllMoods;

    @Given("I set the API endpoint to get all moods data in MindEase App")
    public void setAPIEndpointGetAllMoods(){
        getAllMoods.setAPIEndpointGetAllMoods();
    }

    @When("I send a request to get all moods data in MindEase App")
    public void sendRequestGetAllMoods(){
        getAllMoods.sendRequestGetAllMoods();
    }

    @Then("I should receive all valid data about list of moods")
    public void receiveDataListOfMoods(){
        getAllMoods.receiveDataListOfMoods();
    }
}
