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
    public void receiveConfirmMessageSuccessGetAllDataConsultations(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_CONSULTATIONS_SCHEMA);

        restAssuredThat(response -> {
            response.body("status", Matchers.equalTo(true));
            response.body("message", Matchers.equalTo("Success Get Consultation"));

            response.body("data", Matchers.notNullValue());
            response.body("data.size()", Matchers.greaterThan(0));

            response.body("data.id", Matchers.everyItem(Matchers.notNullValue()));

            response.body("data.Doctor.id", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.Doctor.username", Matchers.everyItem(Matchers.equalTo("mamat1")));
            response.body("data.Doctor.email", Matchers.everyItem(Matchers.equalTo("mamatsp@gmail.com")));
            response.body("data.Doctor.name", Matchers.everyItem(Matchers.equalTo("mamat darwin")));
            response.body("data.Doctor.address", Matchers.everyItem(Matchers.equalTo("jl. kemana")));
            response.body("data.Doctor.phone_number", Matchers.everyItem(Matchers.equalTo("08321")));
            response.body("data.Doctor.gender", Matchers.everyItem(Matchers.equalTo("pria")));
            response.body("data.Doctor.is_available", Matchers.everyItem(Matchers.equalTo(true)));
            response.body("data.Doctor.profile_picture", Matchers.everyItem(Matchers.equalTo("http://gambar.com")));
            response.body("data.Doctor.balance", Matchers.everyItem(Matchers.equalTo(0)));
            response.body("data.Doctor.experience", Matchers.everyItem(Matchers.equalTo(2)));
            response.body("data.Doctor.almamater", Matchers.everyItem(Matchers.equalTo("Unissula")));
            response.body("data.Doctor.graduation_year", Matchers.everyItem(Matchers.equalTo(2019)));
            response.body("data.Doctor.practice_location", Matchers.everyItem(Matchers.equalTo("RS. Bedah Aro")));
            response.body("data.Doctor.practice_city", Matchers.everyItem(Matchers.equalTo("Pekalongan")));
            response.body("data.Doctor.practice_province", Matchers.everyItem(Matchers.equalTo("Jawa Tengah")));
            response.body("data.Doctor.str_number", Matchers.everyItem(Matchers.equalTo("")));
            response.body("data.Doctor.fee", Matchers.everyItem(Matchers.equalTo(0)));
            response.body("data.Doctor.specialist", Matchers.everyItem(Matchers.equalTo("Mental")));
            response.body("data.Doctor.amount", Matchers.everyItem(Matchers.equalTo(0)));

            response.body("data.Status", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.PaymentStatus", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.IsAccepted", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.IsActive", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.Date", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.Time", Matchers.everyItem(Matchers.notNullValue()));

            response.body(matchesJsonSchema(schema));
        });
    }
}
