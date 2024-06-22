package starter.doctor.ConsultationNotes;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateConsultationNotes {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/doctors/consultation-notes";

    @Step("I set the API endpoint to create consultation notes to give recommendation to patient")
    public String setAPIEndpointCreateConsultationNotes(){
        return url;
    }

    @Step("I send a request to create consultation notes to patient")
    public void sendRequestCreateConsultationNotes(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("consultation_id", 28);
        requestBody.put("music_id", 1);
        requestBody.put("forum_id", 6);
        requestBody.put("main_point", "Rasa cemas terus menerus");
        requestBody.put("next_step", "Konsultasi 3 minggu kedepan");
        requestBody.put("additional_note", "Istirahat lebih cepat");
        requestBody.put("mood_tracker_note", "Lacak suasana hati");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointCreateConsultationNotes());
    }

    @Step("I should receive a data confirmation indicating success in adding the consultation note")
    public void receiveDataConfirmSuccessAddConsultationNotes(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_CONSULTATION_NOTES_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Add Consultation Notes")));
        restAssuredThat(response -> response.body("data.id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.consultation_id", Matchers.equalTo(28)));
        restAssuredThat(response -> response.body("data.music_id", Matchers.equalTo(1)));
        restAssuredThat(response -> response.body("data.forum_id", Matchers.equalTo(6)));
        restAssuredThat(response -> response.body("data.main_point", Matchers.equalTo("Rasa cemas terus menerus")));
        restAssuredThat(response -> response.body("data.next_step", Matchers.equalTo("Konsultasi 3 minggu kedepan")));
        restAssuredThat(response -> response.body("data.additional_note", Matchers.equalTo("Istirahat lebih cepat")));
        restAssuredThat(response -> response.body("data.mood_tracker_note", Matchers.equalTo("Lacak suasana hati")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }
}
