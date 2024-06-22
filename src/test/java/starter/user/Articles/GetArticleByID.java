package starter.user.Articles;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetArticleByID {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/articles/";

    @Step("I set the API endpoint to get article by specific ID in MindEase App")
    public String setAPIEndpointGetArticleByID(){
        return url + "11";
    }

    @Step("I send a request to get article by specific ID in MindEase App")
    public void sendRequestGetArticleByID(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setAPIEndpointGetArticleByID());
    }

    @Step("I should receive the article data for the specified ID")
    public void receiveArticleDataByID(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ARTICLE_BY_ID_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Get Article By Id")));

        restAssuredThat(response -> response.body("data.id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.doctor_id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.title", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.content", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.image_url", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.date", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.is_liked", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.reading_time", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.doctor.id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.doctor.name", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
