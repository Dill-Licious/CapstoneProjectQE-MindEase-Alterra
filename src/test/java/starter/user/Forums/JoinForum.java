package starter.user.Forums;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class JoinForum {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/forums/join";

    @Step("I set the API endpoint to join a forum in MindEase App")
    public String setAPIEndpointJoinForum(){
        return url;
    }

    @Step("I send a request to join a forum in MindEase App")
    public void sendRequestJoinForum(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("forum_id", 3);

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointJoinForum());
    }

    @Step("I should receive a data confirmation that indicate success join forum")
    public void receiveSuccessMessageJoinForum(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.JOIN_FORUM_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Join Forum")));
        restAssuredThat(response -> response.body("data.id", Matchers.nullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
