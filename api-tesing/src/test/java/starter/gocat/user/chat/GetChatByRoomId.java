package starter.gocat.user.chat;

import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static starter.Url.*;
import static starter.utils.GenerateToken.tokenUser;

public class GetChatByRoomId {



    private static final RequestSpecification requestSpec;

    static {
        requestSpec = SerenityRest.given()
                .header("Authorization", "Bearer " + tokenUser())
                .pathParam("room_id", "VQ0fXT");
    }

    @Step("I set {String} endpoint for get chat by room id")
    public String setEndpointGetChatByRoomId(String endpointType) {
        String endpoint = null;
        switch (endpointType) {
            case "valid":
                endpoint = userGetChatByRoomIdUrl;
                break;
            case "invalid":
                endpoint = invChatRoomUrl;
                break;
            default:
                Assert.fail("Unsupported base type: " + endpointType);
        }
        return endpoint;
    }

    @Step("I send get request to {String} get chat by room id endpoint")
    public void sendGetBaseTypeGetChatByRoomIdEndpoint(String baseType) {
        switch (baseType) {
            case "valid":
                requestSpec
                        .get(setEndpointGetChatByRoomId("valid"));
                break;
            case "invalid":
                requestSpec
                        .get(setEndpointGetChatByRoomId("invalid"));
                break;
            default:
                Assert.fail("Unsupported base type: " + baseType);
        }
    }

    @Step("I send get request to valid get chat by room id endpoint without token")
    public void  getChatByRoomIdWithoutToken() {
        SerenityRest.given()
                .pathParam("room_id", "VQ0fXT")
                .get(setEndpointGetChatByRoomId("valid"));
    }

    @Step("I receive detail chat")
    public void receiveDetailChat() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SUCCESS_GET_CHAT_BY_ID_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}

