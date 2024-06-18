package starter.user.Musics;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetLikedMusics {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/musics/liked";

    @Step("I set the API endpoint to get liked musics in MindEase App")
    public String setAPIEndpointGetLikedMusics(){
        return url;
    }

    @Step("I send a request to get liked musics in MindEase App")
    public void sendRequestGetLikedMusics(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setAPIEndpointGetLikedMusics());
    }

    @Step("I should receive list data of liked musics")
    public void receiveListOfLikedMusics(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_LIKED_MUSICS_SCHEMA);

        restAssuredThat(response -> {
            response.body("status", Matchers.equalTo(true));
            response.body("message", Matchers.equalTo("Success Get Liked Musics"));

            response.body("metadata", Matchers.notNullValue());
            response.body("metadata.page", Matchers.equalTo(1));
            response.body("metadata.limit", Matchers.equalTo(10));

            response.body("data", Matchers.notNullValue());
            response.body("data.size()", Matchers.greaterThan(0));

            response.body("data.id", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.title", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.singer", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.music_url", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.image_url", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.view_count", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.is_liked", Matchers.everyItem(Matchers.equalTo(true)));

            response.body(matchesJsonSchema(schema));
        });
    }
}
