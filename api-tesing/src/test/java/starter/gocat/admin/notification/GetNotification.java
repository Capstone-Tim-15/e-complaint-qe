package starter.gocat.admin.notification;

import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static starter.Url.adminNotifUrl;
import static starter.Url.invUrl;
import static starter.utils.GenerateToken.tokenAdmin;

public class GetNotification {
    private static final RequestSpecification requestSpec;

    static {
        requestSpec = SerenityRest.given()
                .header("Authorization", "Bearer " + tokenAdmin())
                .header("Content-Type", "application/json");
    }

    @Step("I set {String} endpoint for get notif")
    public String setEndpointTypeGetNotifistic(String endpointType) {
        String endpoint = null;
        switch (endpointType) {
            case "valid":
                endpoint = adminNotifUrl;
                break;
            case "invalid":
                endpoint = invUrl;
                break;
            default:
                Assert.fail("Unsupported base type: " + endpointType);
        }
        return endpoint;
    }

    @Step("I send get request to {String} get notif endpoint")
    public void sendGetBaseTypeGetNotifEndpoint(String baseType) {
        switch (baseType) {
            case "valid":
                requestSpec
                        .get(setEndpointTypeGetNotifistic("valid"));
                break;
            case "invalid":
                requestSpec
                        .get(setEndpointTypeGetNotifistic("invalid"));
                break;
            default:
                Assert.fail("Unsupported base type: " + baseType);
        }
    }

    @Step("I send get request to valid get notif endpoint without token")
    public void getNotifWithoutToken() {
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .get(setEndpointTypeGetNotifistic("valid"));
    }

    @Step("I receive the notif")
    public void receiveNotif() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SUCCESS_GET_NOTIF_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}

