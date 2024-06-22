package starter.user.InspirationalStories;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetInspirationalStoryByID {
    public static String url = "https://dev-capstone.practiceproject.tech/v1/users/stories/";

    @Step("I set the API endpoint to get specific inspirational story by ID in MindEase App")
    public String setAPIEndpointGetSpecificInspStoryByID(){
        return url + "1"; // ID VALID = 1
    }

    @Step("I send a request to get specific inspirational story by ID in MindEase App")
    public void sendRequestGetSpecificInspStoryByID(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE3MTkyMTEwOTIsInJvbGUiOiJ1c2VyIiwidXNlcklkIjo0N30.BXb4uEmcFQbbDc-slP7YpdffVpbNhoCpWbsvBuI-p2M";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setAPIEndpointGetSpecificInspStoryByID());
    }

    @Step("I should receive the inspirational story for the specified ID")
    public void receiveInspStoryValidDataByID(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_INSPIRATIONAL_STORY_BY_ID_SCHEMA);

        restAssuredThat(response -> response.body("status", Matchers.equalTo(true)));
        restAssuredThat(response -> response.body("message", Matchers.equalTo("Success Get Story By Id")));
        restAssuredThat(response -> response.body("data.id", Matchers.equalTo(1)));
        restAssuredThat(response -> response.body("data.title", Matchers.equalTo("Kisah Kupu-Kupu")));
        restAssuredThat(response -> response.body("data.content", Matchers.equalTo("Suatu hari, seorang anak menemukan seekor kepompong yang hampir pecah. Ia memutuskan untuk membantu kupu-kupu itu dengan membuka kepompongnya sedikit. Namun, kupu-kupu itu keluar dengan sayap yang lemah dan tidak bisa terbang. Tanpa perjuangan keluar dari kepompong, otot sayapnya tidak berkembang sepenuhnya. Anak itu belajar bahwa proses perjuangan itu penting untuk memperkuat kita.")));
        restAssuredThat(response -> response.body("data.date", Matchers.equalTo("2024-01-28T05:56:52.341Z")));
        restAssuredThat(response -> response.body("data.image_url", Matchers.equalTo("https://res.cloudinary.com/dy2fwknbn/image/upload/v1718515300/uewlr4tmzaspdzf74tqk.jpg")));
        restAssuredThat(response -> response.body("data.is_liked", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.doctor.id", Matchers.equalTo(1)));
        restAssuredThat(response -> response.body("data.doctor.name", Matchers.equalTo("wahyudin")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
