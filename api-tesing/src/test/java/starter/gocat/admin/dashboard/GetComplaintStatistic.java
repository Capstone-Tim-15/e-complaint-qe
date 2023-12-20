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
import static starter.Url.adminComplaintStatUrl;
import static starter.Url.invUrl;
import static starter.utils.GenerateToken.tokenAdmin;

public class GetComplaintStatistic {
    private static final RequestSpecification requestSpec;

    static {
        requestSpec = SerenityRest.given()
                .header("Authorization", "Bearer " + tokenAdmin())
                .header("Content-Type", "application/json");
    }

    @Step("I set {String} endpoint for get complaint statistic")
    public String setEndpointTypeGetComplaintStatistic(String endpointType) {
        String endpoint = null;
        switch (endpointType) {
            case "valid":
                endpoint = adminComplaintStatUrl;
                break;
            case "invalid":
                endpoint = invUrl;
                break;
            default:
                Assert.fail("Unsupported base type: " + endpointType);
        }
        return endpoint;
    }

    @Step("I send get request to {String} get complaint statistic endpoint")
    public void sendGetBaseTypeGetComplaintStatEndpoint(String baseType) {
        switch (baseType) {
            case "valid":
                requestSpec
                        .get(setEndpointTypeGetComplaintStatistic("valid"));
                break;
            case "invalid":
                requestSpec
                        .get(setEndpointTypeGetComplaintStatistic("invalid"));
                break;
            default:
                Assert.fail("Unsupported base type: " + baseType);
        }
    }

    @Step("I send get request to valid get complaint stat endpoint without token")
    public void getComplaintStatWithoutToken() {
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .get(setEndpointTypeGetComplaintStatistic("valid"));
    }

    @Step("I receive the complaint statistic")
    public void receiveComplaintStat() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SUCCESS_GET_COMPLAINT_STAT_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}

