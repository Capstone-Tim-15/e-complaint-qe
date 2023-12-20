package starter.gocat.user.faq;

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

public class GetAllFaq {

//    private static String getBearerToken() {
//       return  "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJlbWFpbCI6ImhydGtzbUBnbWFpbC5jb20iLCJleHAiOjE3MDE2Nzc2MjEsImlkIjoiazc0Tm42IiwibmFtZSI6ImFuZ2d1biJ9.ZfR-ziNeId6ylhFvihGlfrWRA08m0rBZPsf21xpOXCk";
//    }

    private static final RequestSpecification requestSpec;

    static {
        requestSpec = SerenityRest.given()
                .header("Authorization", "Bearer " + tokenUser())
                .header("Content-Type", "application/json");
    }

    @Step("I set {String} endpoint for get all faq")
    public String setEndpointGetAllFaq(String endpointType) {
        String endpoint = null;
        switch (endpointType) {
            case "valid":
                endpoint = userFaqUrl;
                break;
            case "invalid":
                endpoint = invUrl;
                break;
            default:
                Assert.fail("Unsupported base type: " + endpointType);
        }
        return endpoint;
    }

    @Step("I send get request to {String} get all faq endpoint")
    public void sendGetBaseTypeGetAllFaqEndpoint(String baseType) {
        switch (baseType) {
            case "valid":
                requestSpec
                        .get(setEndpointGetAllFaq("valid"));
                break;
            case "invalid":
                requestSpec
                        .get(setEndpointGetAllFaq("invalid"));
                break;
            default:
                Assert.fail("Unsupported base type: " + baseType);
        }
    }

    @Step("I send get request to valid get all faq endpoint without token")
    public void sendGetAllFaqWithoutToken() {
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .get(setEndpointGetAllFaq("valid"));
    }

    @Step("I receive list of faq")
    public void receiveListFaq() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SUCCESS_GET_ALL_FAQ_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
