package starter.user.Feedbacks;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateFeedback {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/feedbacks";

    @Step("I set the API endpoint to create doctor feedback with valid credentials")
    public String setAPIEndpointCreateFeedback(){
        return url;
    }

    @Step("I send a request to create doctor feedback with valid credentials")
    public void sendRequestCreateFeedback(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("doctor_id", 3);
        requestBody.put("rate", 5);
        requestBody.put("message", "B aja dehhh");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointCreateFeedback());
    }

    @Step("I should receive data confirmation that indicate success create feedback")
    public void receiveDataConfirmSuccessCreateFeedback(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_FEEDBACK_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Send Feedback")));
        restAssuredThat(response -> response.body("data.id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.user_id", Matchers.equalTo(47)));
        restAssuredThat(response -> response.body("data.doctor_id", Matchers.equalTo(3)));
        restAssuredThat(response -> response.body("data.rate", Matchers.equalTo(5)));
        restAssuredThat(response -> response.body("data.message", Matchers.equalTo("B aja dehhh")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
