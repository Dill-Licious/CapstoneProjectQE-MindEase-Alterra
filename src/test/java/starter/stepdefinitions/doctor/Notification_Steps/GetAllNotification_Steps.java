package starter.stepdefinitions.doctor.Notification_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.doctor.Notification.GetAllNotification;

public class GetAllNotification_Steps {
    @Steps
    GetAllNotification getAllNotification;

    @Given("I set the API endpoint to get all notification in MindEase App")
    public void setAPIEndpointGetAllNotification(){
        getAllNotification.setAPIEndpointGetAllNotification();
    }

    @When("I send a request to get all notification in MindEase App")
    public void sendRequestGetAllNotification(){
        getAllNotification.sendRequestGetAllNotification();
    }

    @Then("I should receive a data confirmation about list of notification")
    public void receiveDataConfirmSuccessGetAllNotification(){
        getAllNotification.receiveDataConfirmSuccessGetAllNotification();
    }
}
