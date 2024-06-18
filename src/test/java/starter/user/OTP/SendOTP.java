package starter.user.OTP;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class SendOTP {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/otp/send";

    @Step("I set the API endpoint to request OTP in MindEase App")
    public String setAPIEndpointRequestOTP(){
        return url;
    }

    @Step("I send a request to send a OTP in MindEase App")
    public void sendRequestToSendOTP(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "QualityEngineerTester@gmail.com");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointRequestOTP());
    }

    @Step("I should receive a data confirmation indicate success send OTP")
    public void receiveDataConfirmSuccessSendOTP(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SEND_OTP_SCHEMA);

        restAssuredThat(response -> {
            response.body("status", Matchers.equalTo(true));
            response.body("message", Matchers.equalTo("Success send otp"));
            response.body("data", Matchers.nullValue());

            response.body(matchesJsonSchema(schema));
        });
    }
}