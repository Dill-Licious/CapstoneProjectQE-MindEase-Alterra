package starter.user.Authentication;

import com.github.javafaker.Faker;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Register {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/register";

    @Step("I set the API endpoint to register MindEase App")
    public String setAPIEndpointRegister(){
        return url;
    }

    @Step("I send a request to register into MindEase App with valid credentials")
    public void sendRequestRegisterValidCredentials(){
        JSONObject requestBody = new JSONObject();

        Faker faker = new Faker();

        // hasil gpt
        String email = faker.internet().emailAddress();
        String username = faker.name().firstName();
        String password = faker.internet().password();

        requestBody.put("email", email);
        requestBody.put("username", username);
        requestBody.put("password", password);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointRegister());
    }

    @Step("I should receive a status code of 201 Created")
    public void statusCode201(){
        restAssuredThat(response -> response.statusCode(201));
    }

    @Step("I should receive a data confirmation that indicating register success")
    public void successRegisterConfirmMessage(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.REGISTER);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Register")));
        restAssuredThat(response -> response.body("data.id", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.token", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //Negatif Scenario: All fields empty
    @Step("I send a request to register into MindEase App with all fields is empty")
    public void sendRequestRegisterFieldsEmpty(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "");
        requestBody.put("username", "");
        requestBody.put("password", "");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointRegister());
    }

    @Step("I should receive an error message indicate fullname, username, email or password cannot be empty")
    public void receiveErrorMessageCantEmpty(){
        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("fullname, username, email or password cannot be empty")));
    }
}
