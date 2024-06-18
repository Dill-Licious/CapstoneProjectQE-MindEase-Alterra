package starter.user.Music;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
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
        SerenityRest.given()
                .get(setAPIEndpointGetAllMusics());
    }

    @Step("I should receive all valid data about the musics")
    public void receiveAllMusicData(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_MUSICS);



        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
    /*
        Given I set the API endpoint to get all meditation music
    When I send a request to get all meditation music
    And I should receive a status code of 200 OK
    Then I should receive all valid data about the musics
    */
}
