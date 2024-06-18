package starter.user.Doctors;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllDoctors {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/doctors";

    @Step("I set the API endpoint to get all doctors in MindEase App")
    public String setAPIEndpointGetAllDoctors(){
        return url;
    }

    @Step("I send a request to get all doctors in MindEase App")
    public void sendRequestGetAllDoctors(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setAPIEndpointGetAllDoctors());
    }

    @Step("I receive a valid list of doctors data")
    public void receiveListDoctors(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_DOCTORS);

        restAssuredThat(response -> {
            response.body("status", Matchers.equalTo(true));
            response.body("message", Matchers.equalTo("Success Get All Doctor"));
            response.body("metadata.page", Matchers.equalTo(1));
            response.body("metadata.limit", Matchers.equalTo(10));
            response.body("data", Matchers.notNullValue());
            response.body("data.size()", Matchers.greaterThan(0));
            response.body("data.id", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.username", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.email", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.name", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.address", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.phone_number", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.gender", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.is_available", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.profile_picture", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.balance", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.experience", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.almamater", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.graduation_year", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.practice_location", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.practice_city", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.practice_province", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.str_number", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.fee", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.specialist", Matchers.everyItem(Matchers.notNullValue()));

            response.body(matchesJsonSchema(schema));
        });
    }
}
