package starter.stepdefinitions.user.Articles_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Articles.GetArticleByID;

public class GetArticleByID_Steps {
    @Steps
    GetArticleByID getArticleByID;

    @Given("I set the API endpoint to get article by specific ID in MindEase App")
    public void setAPIEndpointGetArticleByID(){
        getArticleByID.setAPIEndpointGetArticleByID();
    }

    @When("I send a request to get article by specific ID in MindEase App")
    public void sendRequestGetArticleByID(){
        getArticleByID.sendRequestGetArticleByID();
    }

    @Then("I should receive the article data for the specified ID")
    public void receiveArticleDataByID(){
        getArticleByID.receiveArticleDataByID();
    }
}
