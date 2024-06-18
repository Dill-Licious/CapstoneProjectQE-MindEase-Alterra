package starter.stepdefinitions.user.Transaction;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class PayConsultationWithBankTransfer {
    @Steps
    PayConsultationWithBankTransfer payConsultationWithBankTransfer;

    @Given("I set the API endpoint to pay consultation with bank transfer")
    public void setAPIEndpointPayConsultationWithBankTF(){
        payConsultationWithBankTransfer.setAPIEndpointPayConsultationWithBankTF();
    }

    @When("I send a request to pay consultation with bank transfer")
    public void sendRequestPayConsultationWithBankTF(){
        payConsultationWithBankTransfer.sendRequestPayConsultationWithBankTF();
    }

    @Then("I should receive a data confirmation about the transaction details and a link to make the payment")
    public void receiveDataConfirmationTransactionDetail(){
        payConsultationWithBankTransfer.receiveDataConfirmationTransactionDetail();
    }
}
