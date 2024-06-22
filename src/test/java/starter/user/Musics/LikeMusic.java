package starter.user.Musics;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class LikeMusic {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/musics/like";

    @Step("I set the API endpoint to like a music in MindEase App")
    public String setAPIEndpointLikeMusic(){
        return url;
    }

    @Step("I send a request to like a music in MindEase App")
    public void sendRequestLikeMusic(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("music_id", 2); //Misal: Like music dengan ID = 3 //NOTES: SETELAH DI TEST BAKAL BERUBAH

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointLikeMusic());
    }

    @Step("I should receive a data confirmation that indicate like music success")
    public void receiveMessageSuccessLikeMusic(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.LIKE_MUSIC_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Like Music")));
        restAssuredThat(response -> response.body("data", Matchers.nullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
