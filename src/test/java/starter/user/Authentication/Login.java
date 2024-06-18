package starter.user.Authentication;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Login {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/login";

    @Step("I set the API endpoint to login into MindEase App")
    public String setAPIEndpointLogin(){
        return url;
    }

    @Step("I send a request to login into MindEase App with valid credentials")
    public void sendRequestLoginValidCredentials(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "IrfanQEAlta");
        requestBody.put("password", "qualityengineer");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointLogin());
    }

    @Step("I should receive a status code of 200 OK")
    public void statusCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I should receive a data confirmation that indicating success login")
    public void successLoginConfirmMessage(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.LOGIN);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Login")));
        restAssuredThat(response -> response.body("data.id", Matchers.equalTo(14)));
        restAssuredThat(response -> response.body("data.token", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //Negatif Scenario: invalid email
    @Step("I send a request to login into MindEase App with invalid username")
    public void sendRequestLoginInvalidUsername(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "FakeIrfanUsername");
        requestBody.put("password", "qualityengineer");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointLogin());
    }

    @Step("I should receive a status code of 404 Not Found")
    public void statusCode404(){
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("I should receive an error message indicate user not found")
    public void receiveErrorMessageUserNotFound(){
        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("user not found")));
    }

    //Negatif Scenario: empty data
    @Step("I send a request to login into MindEase App with empty username and password")
    public void sendRequestLoginEmptyData(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("username", "");
        requestBody.put("password", "");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointLogin());
    }
    @Step("I should receive a status code of 400 Bad Request")
    public void statusCode400(){
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("I should receive an error message indicate username or password cannot be empty")
    public void receiveErrorMessageCantEmpty(){
        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("username or password cannot be empty")));
    }
}
