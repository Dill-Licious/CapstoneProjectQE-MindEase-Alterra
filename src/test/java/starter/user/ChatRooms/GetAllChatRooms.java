package starter.user.ChatRooms;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllChatRooms {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/chats";

    @Step("I set the API endpoint to get all chat rooms in MindEase App")
    public String setAPIEndpointGetAllChatRooms(){
        return url;
    }

    @Step("I send a request to get all chat rooms in MindEase App")
    public void sendRequestGetAllChatRooms(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setAPIEndpointGetAllChatRooms());
    }

    @Step("I should receive a data confirmation about success message and list data about the chat")
    public void receiveListChatRooms(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_CHAT_ROOMS_SCHEMA);

        restAssuredThat(response -> {
            response.body("status", Matchers.equalTo(true));
            response.body("message", Matchers.equalTo("Success get all chat"));

            response.body("data", Matchers.notNullValue());
            response.body("data.size()", Matchers.greaterThan(0));

            response.body("data.id", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.status", Matchers.everyItem(Matchers.equalTo("completed")));
            response.body("data.isrejected", Matchers.everyItem(Matchers.equalTo(true)));

            response.body("data.latest_message.id", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.latest_message.message", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.latest_message.date", Matchers.everyItem(Matchers.notNullValue()));

            response.body("data.doctor.id", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.name", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.username", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.image_url", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.doctor.specialist", Matchers.everyItem(Matchers.notNullValue()));

            response.body(matchesJsonSchema(schema));
        });
    }
}
