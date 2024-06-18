package starter.user.Musics;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetMusicByID {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/musics/";

    @Step("I set the API endpoint to get specific music by ID in MindEase App")
    public String setAPIEndpointGetMusicByID(){
        return url + "2"; //Example: ID = 2
    }

    @Step("I send a request to get music by specific ID in MindEase App")
    public void sendRequestGetMusicByID(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setAPIEndpointGetMusicByID());
    }

    @Step("I should receive the music data for the specified ID")
    public void receiveMusicDataSpecificID(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_MUSIC_BY_ID);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Get Music By Id")));
        restAssuredThat(response -> response.body("data.id", Matchers.equalTo(2)));
        restAssuredThat(response -> response.body("data.title", Matchers.equalTo("my dream title 2")));
        restAssuredThat(response -> response.body("data.singer", Matchers.equalTo("habubu")));
        restAssuredThat(response -> response.body("data.music_url", Matchers.equalTo("http://music.com")));
        restAssuredThat(response -> response.body("data.image_url", Matchers.equalTo("http://gambar.com")));
        restAssuredThat(response -> response.body("data.view_count", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.is_liked", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
