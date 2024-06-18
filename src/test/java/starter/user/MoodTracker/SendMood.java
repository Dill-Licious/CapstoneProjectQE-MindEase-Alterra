package starter.user.MoodTracker;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class SendMood {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/moods";

    @Step("I set the API endpoint to send mood data in MindEase App")
    public String setAPIEndpointSendMood(){
        return url;
    }

    @Step("I send a request to send mood in MindEase App")
    public void sendRequestSendMood(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("mood_type_id", 3);
        requestBody.put("message", "Hari ini masih nugas seperti biasa, hufyyy!");
        requestBody.put("image", "");
        requestBody.put("date", "2024-05-21");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointSendMood());
    }

    @Step("I should receive a data confirmation that send mood success")
    public void receiveMessageSuccessSendMood(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SEND_MOOD_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Create Mood")));
        restAssuredThat(response -> response.body("data.id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.message", Matchers.equalTo("Hari ini masih nugas seperti biasa, hufyyy!")));
        restAssuredThat(response -> response.body("data.date", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.image_url", Matchers.equalTo("")));
        restAssuredThat(response -> response.body("data.mood_type.id", Matchers.equalTo(3)));
        restAssuredThat(response -> response.body("data.mood_type.name", Matchers.equalTo("Bosan")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
