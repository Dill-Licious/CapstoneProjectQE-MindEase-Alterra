package starter.stepdefinitions.Authentication_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Authentication.ResetPassword;

public class ResetPassword_Steps {
    @Steps
    ResetPassword resetPassword;

    @Given("I set the API endpoint to reset password in MindEase App")
    public void setAPIEndpointResetPassword(){
        resetPassword.setAPIEndpointResetPassword();
    }

    @When("I send a request to reset password in MindEase App")
    public void sendRequestResetPassword(){
        resetPassword.sendRequestResetPassword();
    }

    @Then("I should receive a data confirmation that indicating reset password success")
    public void receiveMessageSuccessResetPassword(){
        resetPassword.receiveMessageSuccessResetPassword();
    }
}
