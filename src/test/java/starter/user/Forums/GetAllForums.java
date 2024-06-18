package starter.user.Forums;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllForums {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/forums";

    @Step("I set the API endpoint to get all forums in MindEase App")
    public String setAPIEndpointGetAllForums(){
        return url;
    }

    @Step("I send a request to get all forums in MindEase App")
    public void sendRequestGetAllForums(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setAPIEndpointGetAllForums());
    }

    @Step("I should receive a data confirmation contain list of forums")
    public void receiveListOfForums(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_FORUMS_SCHEMA);

        restAssuredThat(response -> {
            response.body("status", Matchers.equalTo(true));
            response.body("message", Matchers.equalTo("Success Get Joined Forum"));
            response.body("metadata.page", Matchers.equalTo(1));
            response.body("metadata.limit", Matchers.equalTo(10));
            response.body("data", Matchers.notNullValue());
            response.body("data.size()", Matchers.greaterThan(0));

            response.body("data.forum_id", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.name", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.image_url", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.number_of_members", Matchers.everyItem(Matchers.notNullValue()));

            response.body("data.user.user_id", Matchers.everyItem(Matchers.everyItem(Matchers.notNullValue())));
            response.body("data.user.profile_picture", Matchers.everyItem(Matchers.everyItem(Matchers.notNullValue())));

            response.body(matchesJsonSchema(schema));
        });
    }
}
