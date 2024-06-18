package starter.user.Transaction;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PayConsultationWithBankTransfer {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/payments/bank-transfer?";

    @Step("I set the API endpoint to pay consultation with bank transfer")
    public String setAPIEndpointPayConsultationWithBankTF(){
        return url + "bank=bca"; //Bank dipilih: BCA
    }

    //TODO:SESUAIKAN DATA BARU
    @Step("I send a request to pay consultation with bank transfer")
    public void sendRequestPayConsultationWithBankTF(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("consultation_id", 31);
        requestBody.put("price", 50000);

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointPayConsultationWithBankTF());
    }

    @Step("I should receive a data confirmation about the transaction details and a link to make the payment")
    public void receiveDataConfirmationTransactionDetail(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.PAY_CONSULTATION_WITH_BANK_TRANSFER);

        restAssuredThat(response -> {
            response.body("status", Matchers.equalTo(true));
            response.body("message", Matchers.equalTo("Transaction created"));

            response.body("data.id", Matchers.notNullValue());
            response.body("data.consultation.id", Matchers.equalTo(31));

            response.body("data.consultation.Doctor.id", Matchers.equalTo(5));
            response.body("data.consultation.Doctor.username", Matchers.equalTo("mamat1"));
            response.body("data.consultation.Doctor.email", Matchers.equalTo("mamatsp@gmail.com"));
            response.body("data.consultation.Doctor.name", Matchers.equalTo("mamat darwin"));
            response.body("data.consultation.Doctor.address", Matchers.equalTo("jl. kemana"));
            response.body("data.consultation.Doctor.phone_number", Matchers.equalTo("08321"));
            response.body("data.consultation.Doctor.gender", Matchers.equalTo("pria"));
            response.body("data.consultation.Doctor.is_available", Matchers.equalTo(true));
            response.body("data.consultation.Doctor.profile_picture", Matchers.equalTo("http://gambar.com"));
            response.body("data.consultation.Doctor.balance", Matchers.equalTo(0));
            response.body("data.consultation.Doctor.experience", Matchers.equalTo(2));
            response.body("data.consultation.Doctor.almamater", Matchers.equalTo("Unissula"));
            response.body("data.consultation.Doctor.graduation_year", Matchers.equalTo(2019));
            response.body("data.consultation.Doctor.practice_location", Matchers.equalTo("RS. Bedah Aro"));
            response.body("data.consultation.Doctor.practice_city", Matchers.equalTo("Pekalongan"));
            response.body("data.consultation.Doctor.practice_province", Matchers.equalTo("Jawa Tengah"));
            response.body("data.consultation.Doctor.str_number", Matchers.equalTo(""));
            response.body("data.consultation.Doctor.fee", Matchers.equalTo(0));
            response.body("data.consultation.Doctor.specialist", Matchers.equalTo("Mental"));
            response.body("data.consultation.Doctor.amount", Matchers.equalTo(0));

            response.body("data.consultation.Status", Matchers.equalTo("rejected"));
            response.body("data.consultation.PaymentStatus", Matchers.equalTo("pending"));
            response.body("data.consultation.IsAccepted", Matchers.equalTo(false));
            response.body("data.consultation.IsActive", Matchers.equalTo(false));
            response.body("data.consultation.Date", Matchers.equalTo("2024-06-15"));
            response.body("data.consultation.Time", Matchers.equalTo("14:00"));

            response.body("data.price", Matchers.equalTo(50000));
            response.body("data.payment_type", Matchers.equalTo("bank_transfer"));
            response.body("data.payment_link", Matchers.notNullValue());
            response.body("data.bank", equalTo("bca"));
            response.body("data.status", equalTo("pending"));
            response.body("data.point_spend", equalTo(0));
            response.body("data.created_at", notNullValue());
            response.body("data.updated_at", notNullValue());
        });
    }
}
