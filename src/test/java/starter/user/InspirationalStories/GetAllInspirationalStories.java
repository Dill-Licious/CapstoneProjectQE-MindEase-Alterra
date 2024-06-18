package starter.user.InspirationalStories;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllInspirationalStories {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/stories";

    @Step("I set the API endpoint to get all inspirational stories in MindEase App")
    public String setAPIEndpointGetAllInspirationalStories(){
        return url;
    }

    @Step("I send a request to get all inspirational stories in MindEase App")
    public void sendRequestGetAllInspirationalStories(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setAPIEndpointGetAllInspirationalStories());
    }

    @Step("I should receive all valid data about the inspirational stories")
    public void receiveInspirationalStoriesData(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_INSPIRATIONAL_STORIES);

        restAssuredThat(response -> {
            response.body("status", Matchers.equalTo(true));
            response.body("message", Matchers.equalTo("Success Get All Stories"));
            response.body("metadata.page", Matchers.equalTo(1));
            response.body("metadata.limit", Matchers.equalTo(10));
            response.body("data", Matchers.notNullValue());
            response.body("data.size()", Matchers.greaterThan(0));

            response.body("data.id", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.title", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.content", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.date", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.image_url", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.view_count", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.is_liked", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.id", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.name", Matchers.everyItem(Matchers.notNullValue()));

            response.body(matchesJsonSchema(schema));
        });
    }
}
