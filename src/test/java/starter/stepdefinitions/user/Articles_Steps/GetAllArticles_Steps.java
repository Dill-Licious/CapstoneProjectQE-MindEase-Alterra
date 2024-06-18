package starter.stepdefinitions.Articles_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Articles.GetAllArticles;

public class GetAllArticles_Steps {
    @Steps
    GetAllArticles getAllArticles;

    @Given("I set the API endpoint to get all articles in MindEase App")
    public void setAPIEndpointGetAllArticles(){
        getAllArticles.setAPIEndpointGetAllArticles();
    }

    @When("I send a request to get all articles in MindEase App")
    public void sendRequestGetAllArticles(){
        getAllArticles.sendRequestGetAllArticles();
    }

    @Then("I should receive all valid data about the articles")
    public void receiveValidDataArticles(){
        getAllArticles.receiveValidDataArticles();
    }
}
