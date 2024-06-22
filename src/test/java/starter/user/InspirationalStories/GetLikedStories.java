package starter.user.InspirationalStories;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetLikedStories {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/stories/liked";

    @Step("I set the API endpoint to get liked stories in MindEase App")
    public String setAPIEndpointGetLikedStories(){
        return url;
    }

    @Step("I send a request to get liked stories in MindEase App")
    public void sendRequestGetLikedStories(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setAPIEndpointGetLikedStories());
    }

    @Step("I should receive a response containing a list of liked stories")
    public void receiveListOfLikedStories(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_LIKED_STORIES_SCHEMA);

        restAssuredThat(response -> {
            response.body("status", Matchers.equalTo(true));
            response.body("message", Matchers.equalTo("Success Get Liked Stories"));

            response.body("metadata", Matchers.notNullValue());
            response.body("metadata.page", Matchers.equalTo(1));
            response.body("metadata.limit", Matchers.equalTo(10));

            response.body("data", Matchers.notNullValue());

            response.body("data.id", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.title", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.content", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.date", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.image_url", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.is_liked", Matchers.everyItem(Matchers.equalTo(true)));

            response.body("data.doctor.id", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.name", Matchers.everyItem(Matchers.notNullValue()));

            response.body(matchesJsonSchema(schema));
        });
    }
}
