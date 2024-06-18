package starter.user.Authentication;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class ResetPassword {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/reset-password";

    @Step("I set the API endpoint to reset password in MindEase App")
    public String setAPIEndpointResetPassword(){
        return url;
    }

    @Step("I send a request to reset password in MindEase App")
    public void sendRequestResetPassword(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "Irfanabb@gmail.com");
        requestBody.put("password", "qualityEngineer1"); // Password baru

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .put(setAPIEndpointResetPassword()); // update: method 'put' atau 'patch'
    }

    @Step("I should receive a data confirmation that indicating reset password success")
    public void receiveMessageSuccessResetPassword(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.RESET_PASSWORD_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Reset Password")));
        restAssuredThat(response -> response.body("data", Matchers.equalTo(null)));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
