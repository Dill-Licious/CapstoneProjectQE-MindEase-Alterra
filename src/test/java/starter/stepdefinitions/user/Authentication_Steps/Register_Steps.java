package starter.stepdefinitions.Authentication_Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Authentication.Register;

public class Register_Steps {

    @Steps
    Register register;

    @Given("I set the API endpoint to register MindEase App")
    public void setAPIEndpointRegister(){
        register.setAPIEndpointRegister();
    }

    @When("I send a request to register into MindEase App with valid credentials")
    public void sendRequestRegisterValidCredentials(){
        register.sendRequestRegisterValidCredentials();
    }

    @And("I should receive a status code of 201 Created")
    public void statusCode201(){
        register.statusCode201();
    }

    @Then("I should receive a data confirmation that indicating register success")
    public void successRegisterConfirmMessage(){
        register.successRegisterConfirmMessage();
    }

    //Negatif Scenario
    @Given("I send a request to register into MindEase App with all fields is empty")
    public void sendRequestRegisterFieldsEmpty(){
        register.sendRequestRegisterFieldsEmpty();
    }

    @Then("I should receive an error message indicate fullname, username, email or password cannot be empty")
    public void receiveErrorMessageCantEmpty(){
        register.receiveErrorMessageCantEmpty();
    }
}
