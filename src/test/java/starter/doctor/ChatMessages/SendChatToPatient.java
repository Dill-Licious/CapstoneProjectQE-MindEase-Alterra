package starter.doctor.ChatMessages;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class SendChatToPatient {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/doctors/chats/messages";

    @Step("I set the API endpoint to send a chat message to patient in MindEase App")
    public String setAPIEndpointSendChatToPatient(){
        return url;
    }

    @Step("I send a request to send a chat message in MindEase App")
    public void sendRequestSendChatToPatient(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("chat_id", 3);
        requestBody.put("message", "sakit apa kak? sakit hati?");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointSendChatToPatient());
    }

    @Step("I should receive a data confirmation indicate success send chat to patient")
    public void receiveDataConfirmSuccessSendChatToPatient(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SEND_CHAT_TO_PATIENT_SCHEMA);

        restAssuredThat(response -> {
            response.body("status", Matchers.equalTo(true));
            response.body("message", Matchers.equalTo("Success send message"));
            response.body("data.id", Matchers.notNullValue());
            response.body("data.message", Matchers.equalTo("sakit apa kak? sakit hati?"));
            response.body("data.role", Matchers.equalTo("doctor"));
            response.body("data.date", Matchers.notNullValue());
            response.body(matchesJsonSchema(schema));
        });
    }
}
