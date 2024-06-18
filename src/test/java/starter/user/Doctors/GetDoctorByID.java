package starter.user.Doctors;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetDoctorByID {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/doctors";

    @Step("I set the API endpoint to get specific doctor information by ID in MindEase App")
    public String setAPIEndpointGetDoctorInfoByID(){
        return url + "/1"; //Valid ID = 1
    }

    @Step("I send a request to get specific doctor information by ID in MindEase App")
    public void sendRequestGetDoctorInfoByID(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setAPIEndpointGetDoctorInfoByID());
    }

    @Step("I receive valid data information of the doctor")
    public void receiveValidDoctorInfo(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_DOCTOR_BY_ID);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Get Doctor By ID")));
        restAssuredThat(response -> response.body("data.id", Matchers.equalTo(1)));
        restAssuredThat(response -> response.body("data.username", Matchers.equalTo("jhondoe1")));
        restAssuredThat(response -> response.body("data.email", Matchers.equalTo("jhondoe1@gmail.com")));
        restAssuredThat(response -> response.body("data.name", Matchers.equalTo("wahyudin")));
        restAssuredThat(response -> response.body("data.address", Matchers.equalTo("ini alamat")));
        restAssuredThat(response -> response.body("data.phone_number", Matchers.equalTo("081123")));
        restAssuredThat(response -> response.body("data.gender", Matchers.equalTo("wanita")));
        restAssuredThat(response -> response.body("data.is_available", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("data.profile_picture", Matchers.equalTo("ini link fotonya")));
        restAssuredThat(response -> response.body("data.balance", Matchers.equalTo(0)));
        restAssuredThat(response -> response.body("data.experience", Matchers.equalTo(5)));
        restAssuredThat(response -> response.body("data.almamater", Matchers.equalTo("ITB")));
        restAssuredThat(response -> response.body("data.graduation_year", Matchers.equalTo(2020)));
        restAssuredThat(response -> response.body("data.practice_location", Matchers.equalTo("RS. Hernia")));
        restAssuredThat(response -> response.body("data.practice_city", Matchers.equalTo("Jakarta")));
        restAssuredThat(response -> response.body("data.practice_province", Matchers.equalTo("Jakarta")));
        restAssuredThat(response -> response.body("data.str_number", Matchers.equalTo("")));
        restAssuredThat(response -> response.body("data.fee", Matchers.equalTo(0)));
        restAssuredThat(response -> response.body("data.specialist", Matchers.equalTo("Jiwa")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
