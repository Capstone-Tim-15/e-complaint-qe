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

public class CreateRoomChat {

    private static final RequestSpecification requestSpec;

    static {
        requestSpec = SerenityRest.given()
                .header("Authorization", "Bearer " + tokenUser());
    }

    @Step("I set {String} endpoint for create room chat")
    public String setEndpointCreateRoomChat (String endpointType){
        String endpoint = null;
        switch (endpointType) {
            case "valid":
                endpoint = userCreateRoomChatUrl;
                break;
            case "invalid":
                endpoint = invUrl;
                break;
            default:
                Assert.fail("Unsupported base type: " + endpointType);
        }
        return endpoint;
    }

    @Step("I send post request to {String} create room chat endpoint")
    public void sendPostBaseTypeCreateRoomChatEndpoint(String baseType) {

        switch (baseType) {
            case "valid":
                requestSpec
                        .post(setEndpointCreateRoomChat("valid"));
                break;
            case "invalid":
                requestSpec
                        .post(setEndpointCreateRoomChat("invalid"));
                break;
            default:
                Assert.fail("Unsupported credential type: " + baseType);
        }

    }

    @Step("I send post request to create room chat endpoint without token")
    public void createRoomChatWithoutLogin() {
        SerenityRest.given()
                .header("Content-Type", "aplication/json")
                .post(setEndpointCreateRoomChat("valid"));
    }

    @Step("I receive my detail room chat")
    public void receiveDetailRoomChat() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SUCCESS_CREATE_ROOM_CHAT_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}

