package starter.user.SendMessages;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllChatMessageByID {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/chats/12/messages?last_message_id=3&page=1&limit=10";

    @Step("I set the API endpoint to get all messages by ID in MindEase App")
    public String setAPIEndpointGetAllMessageByID(){
        return url; //ASUMSI ID TEST = 12
    }

    @Step("I send a request to get all chat messages by ID in MindEase App")
    public void sendRequestGetAllChatMessagesByID(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setAPIEndpointGetAllMessageByID());
    }

    @Step("I should receive a data confirmation that indicate retrieve chat messages by id success")
    public void receiveDataConfirmSuccessRetrieveChatMessagesByID(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_CHAT_MESSAGE_BY_ID_SCHEMA);

        restAssuredThat(response -> {
            response.body("status", Matchers.equalTo(true));
            response.body("message", Matchers.equalTo("Success get all messages"));
            response.body("data", Matchers.notNullValue());
            response.body("data.size()", Matchers.greaterThan(0));

            response.body("data.id", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.message", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.role", Matchers.everyItem(Matchers.notNullValue()));
            response.body("data.date", Matchers.everyItem(Matchers.notNullValue()));

            response.body(matchesJsonSchema(schema));
        });

    }
}
