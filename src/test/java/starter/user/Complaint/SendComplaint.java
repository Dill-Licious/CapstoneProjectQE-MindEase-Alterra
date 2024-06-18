package starter.user.Complaint;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class SendComplaint {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/complaint";

    @Step("I set the API endpoint to send a complaint in MindEase App")
    public String setAPIEndpointSendComplaint(){
        return url;
    }

    @Step("I send a request to send a complaint in MindEase App")
    public void sendRequestSendComplaint(){
        JSONObject requestBody = new JSONObject();

        requestBody.put("consultation_id", 3);
        requestBody.put("name", "Khansa Nur Fathiyah");
        requestBody.put("age", 6);
        requestBody.put("gender", "wanita");
        requestBody.put("message", "setelah minum obat jadi sakit influenza, radang tenggorokan");
        requestBody.put("medical_history", "this medical history");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointSendComplaint());
    }

    @Step("I should receive a data confirmation that indicate success send a complaint")
    public void receiveSendComplaintSuccess(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SEND_COMPLAINT_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Complaint Created")));
        restAssuredThat(response -> response.body("data.id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.name", Matchers.equalTo("Khansa Nur Fathiyah")));
        restAssuredThat(response -> response.body("data.age", Matchers.equalTo(6)));
        restAssuredThat(response -> response.body("data.gender", Matchers.equalTo("wanita")));
        restAssuredThat(response -> response.body("data.message", Matchers.equalTo("setelah minum obat jadi sakit influenza, radang tenggorokan")));
        restAssuredThat(response -> response.body("data.medical_history", Matchers.equalTo("this medical history")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
