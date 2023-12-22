package starter.gocat.admin.dashboard;

import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import org.junit.Assert;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static starter.Url.adminUserStatUrl;
import static starter.Url.invUrl;
import static starter.utils.GenerateToken.tokenAdmin;

public class GetUserStatistic {
    private static final RequestSpecification requestSpec;

    static {
        requestSpec = SerenityRest.given()
                .header("Authorization", "Bearer " + tokenAdmin())
                .header("Content-Type", "application/json");
    }

    @Step("I set {String} endpoint for get user statistic")
    public String setEndpointTypeGetUserStatistic(String endpointType) {
        String endpoint = null;
        switch (endpointType) {
            case "valid":
                endpoint = adminUserStatUrl;
                break;
            case "invalid":
                endpoint = invUrl;
                break;
            default:
                Assert.fail("Unsupported base type: " + endpointType);
        }
        return endpoint;
    }

    @Step("I send get request to {String} get user statistic endpoint")
    public void sendGetBaseTypeGetUserStatEndpoint(String baseType) {
        switch (baseType) {
            case "valid":
                requestSpec
                        .get(setEndpointTypeGetUserStatistic("valid"));
                break;
            case "invalid":
                requestSpec
                        .get(setEndpointTypeGetUserStatistic("invalid"));
                break;
            default:
                Assert.fail("Unsupported base type: " + baseType);
        }
    }

    @Step("I send get request to valid get user stat endpoint without token")
    public void getUserStatWithoutToken() {
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .get(setEndpointTypeGetUserStatistic("valid"));
    }

    @Step("I receive the user statistic")
    public void receiveUserStat() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SUCCESS_GET_USER_STAT_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}
