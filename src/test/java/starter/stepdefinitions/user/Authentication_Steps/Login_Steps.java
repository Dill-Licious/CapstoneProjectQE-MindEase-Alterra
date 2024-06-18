package starter.stepdefinitions.user.Authentication_Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Authentication.Login;

public class Login_Steps {
    @Steps
    Login login;

    @Given("I set the API endpoint to login into MindEase App")
    public void setAPIEndpointLogin(){
        login.setAPIEndpointLogin();
    }

    @When("I send a request to login into MindEase App with valid credentials")
    public void sendRequestLoginValidCredentials(){
        login.sendRequestLoginValidCredentials();
    }

    @And("I should receive a status code of 200 OK")
    public void statusCode200(){
        login.statusCode200();
    }

    @Then("I should receive a data confirmation that indicating success login")
    public void successLoginConfirmMessage(){
        login.successLoginConfirmMessage();
    }

    //Negative Scenario
    @When("I send a request to login into MindEase App with invalid username")
    public void sendRequestLoginInvalidUsername(){
        login.sendRequestLoginInvalidUsername();
    }

    @And("I should receive a status code of 404 Not Found")
    public void statusCode404(){
        login.statusCode404();
    }

    @Then("I should receive an error message indicate user not found")
    public void receiveErrorMessageUserNotFound(){
        login.receiveErrorMessageUserNotFound();
    }

    @When("I send a request to login into MindEase App with empty username and password")
    public void sendRequestLoginEmptyData(){
        login.sendRequestLoginEmptyData();
    }

    @And("I should receive a status code of 400 Bad Request")
    public void statusCode400(){
        login.statusCode400();
    }

    @Then("I should receive an error message indicate username or password cannot be empty")
    public void receiveErrorMessageCantEmpty(){
        login.receiveErrorMessageCantEmpty();
    }
}
