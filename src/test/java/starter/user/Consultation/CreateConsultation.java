package starter.user.Consultation;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

//TODO:BENARKAN STATUS CODE
public class CreateConsultation {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/consultations";

    @Step("I set the API endpoint to create consultation in MindEase App")
    public String setAPIEndpointCreateConsultation(){
        return url;
    }

    @Step("I send a request to create consultation in MindEase App")
    public void sendRequestCreateConsultation(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("doctor_id", 5);
        requestBody.put("date", "2024-06-15");
        requestBody.put("time", "13:00");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointCreateConsultation());
    }

    @Step("I should receive a data confirmation indicating consultation was created successfully, including the schedule and doctor's details")
    public void receiveDataConfirmConsultationWasCreated() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_CONSULTATION_SCHEMA);

        restAssuredThat(response -> {
            response.body("status", Matchers.equalTo(true));
            response.body("message", Matchers.equalTo("Success Add Consultation"));

            response.body("data.id", Matchers.notNullValue());

            response.body("data.doctor.id", Matchers.notNullValue());
            response.body("data.doctor.username", Matchers.equalTo("mamat1"));
            response.body("data.doctor.email", Matchers.equalTo("mamatsp@gmail.com"));
            response.body("data.doctor.name", Matchers.equalTo("mamat darwin"));
            response.body("data.doctor.address", Matchers.equalTo("jl. kemana"));
            response.body("data.doctor.phone_number", Matchers.equalTo("08321"));
            response.body("data.doctor.gender", Matchers.equalTo("pria"));
            response.body("data.doctor.is_available", Matchers.equalTo(true));
            response.body("data.doctor.profile_picture", Matchers.equalTo("http://gambar.com"));
            response.body("data.doctor.balance", Matchers.equalTo(0));
            response.body("data.doctor.experience", Matchers.equalTo(2));
            response.body("data.doctor.bachelor_almamater", Matchers.equalTo(""));
            response.body("data.doctor.bachelor_graduation_year", Matchers.equalTo(0));
            response.body("data.doctor.master_almamater", Matchers.equalTo(""));
            response.body("data.doctor.master_graduation_year", Matchers.equalTo(0));
            response.body("data.doctor.practice_location", Matchers.equalTo("RS. Bedah Aro"));
            response.body("data.doctor.practice_city", Matchers.equalTo("Pekalongan"));
            response.body("data.doctor.fee", Matchers.equalTo(0));
            response.body("data.doctor.specialist", Matchers.equalTo("Mental"));
            response.body("data.doctor.amount", Matchers.equalTo(0));
            response.body("data.doctor.rating_precentage", Matchers.equalTo(0));

            response.body("data.status", Matchers.equalTo("pending"));
            response.body("data.payment_status", Matchers.equalTo("pending"));
            response.body("data.is_accepted", Matchers.equalTo(false));
            response.body("data.is_active", Matchers.equalTo(false));
            response.body("data.start_date", Matchers.notNullValue());
            response.body("data.end_date", Matchers.notNullValue());

            response.body(matchesJsonSchema(schema));
        });
    }

}
