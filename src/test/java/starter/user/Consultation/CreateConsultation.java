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

    @Step("I should receive a data confirmation indicate consultation was created successfully, including the schedule and doctor's details")
    public void receiveDataConfirmConsultationWasCreated(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_CONSULTATION_SCHEMA);

        restAssuredThat(response -> {
            response.body("status", Matchers.equalTo(true));
            response.body("message", Matchers.equalTo("Success Add Consultation"));

            response.body("data.id", Matchers.notNullValue());

            response.body("data.Doctor.id", Matchers.notNullValue());
            response.body("data.Doctor.username", Matchers.equalTo("mamat1"));
            response.body("data.Doctor.email", Matchers.equalTo("mamatsp@gmail.com"));
            response.body("data.Doctor.name", Matchers.equalTo("mamat darwin"));
            response.body("data.Doctor.address", Matchers.equalTo("jl. kemana"));
            response.body("data.Doctor.phone_number", Matchers.equalTo("08321"));
            response.body("data.Doctor.gender", Matchers.equalTo("pria"));
            response.body("data.Doctor.is_available", Matchers.equalTo(true));
            response.body("data.Doctor.profile_picture", Matchers.equalTo("http://gambar.com"));
            response.body("data.Doctor.balance", Matchers.equalTo(0));
            response.body("data.Doctor.experience", Matchers.equalTo(2));
            response.body("data.Doctor.almamater", Matchers.equalTo("Unissula"));
            response.body("data.Doctor.graduation_year", Matchers.equalTo(2019));
            response.body("data.Doctor.practice_location", Matchers.equalTo("RS. Bedah Aro"));
            response.body("data.Doctor.practice_city", Matchers.equalTo("Pekalongan"));
            response.body("data.Doctor.practice_province", Matchers.equalTo("Jawa Tengah"));
            response.body("data.Doctor.str_number", Matchers.equalTo(""));
            response.body("data.Doctor.fee", Matchers.equalTo(0));
            response.body("data.Doctor.specialist", Matchers.equalTo("Mental"));
            response.body("data.Doctor.amount", Matchers.equalTo(0));

            response.body("data.Status", Matchers.equalTo("pending"));
            response.body("data.PaymentStatus", Matchers.equalTo("pending"));
            response.body("data.IsAccepted", Matchers.equalTo(false));
            response.body("data.IsActive", Matchers.equalTo(false));
            response.body("data.Date", Matchers.equalTo("2024-06-15"));
            response.body("data.Time", Matchers.equalTo("13:00"));

            response.body(matchesJsonSchema(schema));
        });
    }
}
