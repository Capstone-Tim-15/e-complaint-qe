package starter.gocat.user.complaint;

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

public class GetComplaintById {


//    private static String getBearerToken() {
//        return  "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJlbWFpbCI6ImhydGtzbUBnbWFpbC5jb20iLCJleHAiOjE3MDE2Nzc2MjEsImlkIjoiazc0Tm42IiwibmFtZSI6ImFuZ2d1biJ9.ZfR-ziNeId6ylhFvihGlfrWRA08m0rBZPsf21xpOXCk";
//    }

    private static final RequestSpecification requestSpec;

    static {
        requestSpec = SerenityRest.given()
                .header("Authorization", "Bearer " + tokenUser())
                .header("Content-Type", "application/json");
    }

    @Step("I set {String} endpoint for get single complaint")
    public String setEndpointGetSingleComplaint (String endpointType){
            String endpoint = null;
            switch (endpointType) {
                case "valid":
                    endpoint = userComplaintUrl;
                    break;
                case "invalid":
                    endpoint = invUrl;
                    break;
                default:
                    Assert.fail("Unsupported base type: " + endpointType);
            }
            return endpoint;
    }

    @Step("I send get request to {String} get single complaint endpoint")
    public void sendGetBaseTypeGetSingleComplaintEndpoint(String baseType) {
        switch (baseType) {
            case "valid":
                requestSpec
                        .queryParam("id", "k74Nn6")
                        .get(setEndpointGetSingleComplaint("valid"));
                break;
            case "invalid":
                requestSpec
                        .get(setEndpointGetSingleComplaint("invalid"));
                break;
            case "non-exist":
                requestSpec
                        .queryParam("page", "10000000")
                        .get(setEndpointGetSingleComplaint("valid"));
                break;
            default:
                Assert.fail("Unsupported base type: " + baseType);
        }
    }

    @Step("I receive detail complaint")
    public void receiveDetailComplaint() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SUCCESS_GET_COMPLAINT_BY_ID_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}

