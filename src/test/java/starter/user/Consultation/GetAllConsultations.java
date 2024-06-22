package starter.user.Consultation;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllConsultations {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/consultations";

    @Step("I set the API endpoint to get all consultations in MindEase App")
    public String setAPIEndpointGetAllConsultations(){
        return url;
    }

    @Step("I send a request to get all consultations in MindEase App")
    public void sendRequestGetAllConsultations(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setAPIEndpointGetAllConsultations());
    }

    @Step("I should receive a data confirmation that indicates a successful retrieval of consultations with data")
    public void receiveConfirmMessageSuccessGetAllDataConsultations() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_CONSULTATIONS_SCHEMA);

        restAssuredThat(response -> {
            response.body("status", Matchers.equalTo(true));
            response.body("message", Matchers.equalTo("Success Get Consultation"));

            response.body("data", Matchers.notNullValue());
            response.body("data.id", Matchers.everyItem(Matchers.notNullValue()));

            response.body("data.doctor.id", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.username", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.email", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.name", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.address", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.phone_number", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.gender", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.is_available", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.profile_picture", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.balance", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.experience", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.bachelor_almamater", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.bachelor_graduation_year", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.master_almamater", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.master_graduation_year", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.practice_location", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.practice_city", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.fee", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.specialist", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.amount", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.rating_precentage", Matchers.everyItem(Matchers.notNullValue()));

            response.body("data.status", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.payment_status", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.is_accepted", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.is_active", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.start_date", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.end_date", Matchers.everyItem(Matchers.notNullValue()));

            response.body(matchesJsonSchema(schema));
        });
    }
}
