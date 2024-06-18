package starter.user.Articles;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllArticles {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/articles";

    @Step("I set the API endpoint to get all articles in MindEase App")
    public String setAPIEndpointGetAllArticles(){
        return url;
    }

    @Step("I send a request to get all articles in MindEase App")
    public void sendRequestGetAllArticles(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setAPIEndpointGetAllArticles());
    }

    @Step("I should receive all valid data about the articles")
    public void receiveValidDataArticles(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_ARTICLES_SCHEMA);

        restAssuredThat(response -> {
            response.body("status", Matchers.equalTo(true));
            response.body("message", Matchers.equalTo("Success Get All Articles"));
            response.body("data", Matchers.notNullValue());
            response.body("data.size()", Matchers.greaterThan(0));

            response.body("data.id", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor_id", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.title", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.content", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.image_url", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.date", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.view_count", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.is_liked", Matchers.everyItem(Matchers.notNullValue()));

            response.body("data.Doctor.id", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.Doctor.name", Matchers.everyItem(Matchers.notNullValue()));

            response.body(matchesJsonSchema(schema));
        });
    }
}

