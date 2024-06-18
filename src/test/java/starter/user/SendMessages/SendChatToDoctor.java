package starter.user.SendMessages;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class SendChatToDoctor {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/chats/messages";

    @Step("I set the API endpoint to send chat to doctor in MindEase App")
    public String setAPIEndpointSendChatToDoctor(){
        return url;
    }

    @Step("I send a request to send chat to doctor in MindEase App")
    public void sendRequestChatToDoctor(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("chat_id", 12);
        requestBody.put("message", "dok ak mw mati");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointSendChatToDoctor());
    }

    @Step("I should receive a data confirmation that indicate success send message")
    public void receiveConfirmMessageSendMoodSuccess(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SEND_CHAT_TO_DOCTOR_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success send message")));
        restAssuredThat(response -> response.body("data.id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.message", Matchers.equalTo("dok ak mw mati")));
        restAssuredThat(response -> response.body("data.role", Matchers.equalTo("user")));
        restAssuredThat(response -> response.body("data.date", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
