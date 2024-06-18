package starter.user.Forums;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class LeaveForum {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/forums/";

    @Step("I set the API endpoint to leave a forum in MindEase App")
    public String setAPIEndpointLeaveForum(){
        return url + "5"; //Asumsi ID = 5
    }

    @Step("I send a request to leave a forum in MindEase App")
    public void sendRequestLeaveForum(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .delete(setAPIEndpointLeaveForum());
    }

    @Step("I should receive a data confirmation that indicate success leave forum")
    public void receiveDataConfirmSuccessLeaveForum(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.LEAVE_FORUM_SCHEMA);

        restAssuredThat(response -> {
            response.body("status", Matchers.equalTo(true));
            response.body("message", Matchers.equalTo("Success Leave Forum"));
            response.body("data", Matchers.nullValue());

            response.body(matchesJsonSchema(schema));
        });
    }
}
