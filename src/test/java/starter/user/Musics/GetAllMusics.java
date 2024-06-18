package starter.user.Musics;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllMusics {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/musics";

    @Step("I set the API endpoint to get all meditation music")
    public String setAPIEndpointGetAllMusics(){
        return url;
    }

    @Step("I send a request to get all meditation music")
    public void sendRequestGetGetAllMusics(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setAPIEndpointGetAllMusics());
    }

    @Step("I should receive all valid data about the musics")
    public void receiveAllMusicData(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_MUSICS);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Get All Musics")));
        restAssuredThat(response -> response.body("metadata.page", Matchers.equalTo(1)));
        restAssuredThat(response -> response.body("metadata.limit", Matchers.equalTo(10)));
        restAssuredThat(response -> response.body("data", Matchers.notNullValue())); //TODO: BENERIN FORMAT INI SESUAI DGN RESPONSE TERBARU

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
