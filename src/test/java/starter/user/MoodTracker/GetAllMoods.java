package starter.user.MoodTracker;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllMoods {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/moods";

    @Step("I set the API endpoint to get all moods data in MindEase App")
    public String setAPIEndpointGetAllMoods(){
        return url + "?start_date=2024-05-01&end_date=2024-05-31"; //Set start + end date
    }

    @Step("I send a request to get all moods data in MindEase App")
    public void sendRequestGetAllMoods(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setAPIEndpointGetAllMoods());
    }

    @Step("I should receive all valid data about list of moods")
    public void receiveDataListOfMoods(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_MOODS_SCHEMA);

        restAssuredThat(response -> {
            response.body("status", Matchers.equalTo(true));
            response.body("message", Matchers.equalTo("Success Get All Moods"));
            response.body("data", Matchers.notNullValue());
            response.body("data.size()", Matchers.greaterThan(0));

            response.body("data.id", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.date", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.mood_type.id", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.mood_type.name", Matchers.everyItem(Matchers.notNullValue()));

            response.body(matchesJsonSchema(schema));
        });
    }
}
