package starter.user.MoodTracker;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetMoodByID {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/moods/";

    @Step("I set the API endpoint to get mood data by user ID in MindEase App")
    public String setAPIEndpointGetMoodByID(){
        return url + "3"; //VALID ID = 3
    }

    @Step("I send a request to get mood data by user ID in MindEase App")
    public void sendRequestGetMoodByID(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setAPIEndpointGetMoodByID());
    }

    @Step("I should receive data about the user's mood")
    public void receiveTheUserMood(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_MOOD_BY_ID_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Get Mood By Id")));
        restAssuredThat(response -> response.body("data.id", Matchers.equalTo(3)));
        restAssuredThat(response -> response.body("data.message", Matchers.equalTo("Hari ini bahagia karena aku bersantai di taman")));
        restAssuredThat(response -> response.body("data.date", Matchers.equalTo("2024-05-30T00:00:00Z")));
        restAssuredThat(response -> response.body("data.image_url", Matchers.equalTo("")));
        restAssuredThat(response -> response.body("data.mood_type.id", Matchers.equalTo(2)));
        restAssuredThat(response -> response.body("data.mood_type.name", Matchers.equalTo("Senang")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
