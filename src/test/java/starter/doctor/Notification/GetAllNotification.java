package starter.doctor.Notification;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllNotification {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/doctors/notifications";

    @Step("I set the API endpoint to get all notification in MindEase App")
    public String setAPIEndpointGetAllNotification(){
        return url;
    }

    @Step("I send a request to get all notification in MindEase App")
    public void sendRequestGetAllNotification(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setAPIEndpointGetAllNotification());
    }

    @Step("I should receive a data confirmation about list of notification")
    public void receiveDataConfirmSuccessGetAllNotification(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_NOTIFICATION_SCHEMA);

        restAssuredThat(response -> {
            response.body("status", Matchers.equalTo(true));
            response.body("message", Matchers.equalTo("success get notifications"));

            response.body("metadata.page", Matchers.equalTo(1));
            response.body("metadata.limit", Matchers.equalTo(10));

            response.body("data", Matchers.nullValue());

            response.body(matchesJsonSchema(schema));
        });
    }
}
