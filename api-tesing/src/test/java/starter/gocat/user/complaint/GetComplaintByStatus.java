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

public class GetComplaintByStatus {

//    private static String getBearerToken() {
//        return  "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdXRob3JpemVkIjp0cnVlLCJlbWFpbCI6ImhydGtzbUBnbWFpbC5jb20iLCJleHAiOjE3MDE2Nzc2MjEsImlkIjoiazc0Tm42IiwibmFtZSI6ImFuZ2d1biJ9.ZfR-ziNeId6ylhFvihGlfrWRA08m0rBZPsf21xpOXCk";
//    }

    private static final RequestSpecification requestSpec;

    static {
        requestSpec = SerenityRest.given()
                .header("Authorization", "Bearer " + tokenUser())
                .header("Content-Type", "application/json");
    }

    @Step("I set {String} endpoint for get all complaint status")
    public String setEndpointGetAllComplaintStatus(String endpointType) {
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

    @Step("I send get request to {String} get all complaint status endpoint")
    public void sendGetBaseTypeGetAllComplaintStatusEndpoint(String baseType) {
        switch (baseType) {
            case "solved":
                requestSpec
                        .queryParam("page", "1")
                        .queryParam("status", "solved")
                        .get(setEndpointGetAllComplaintStatus("valid"));
                break;
            case "invalid":
                SerenityRest.given()
                        .header("Authorization", "Bearer " + tokenUser())
                        .header("Content-Type", "application/json")
                        .queryParam("page", "1")
                        .queryParam("status", "solved")
                        .get(setEndpointGetAllComplaintStatus("invalid"));
                break;
            case "unsolved":
                SerenityRest.given()
                        .header("Authorization", "Bearer " + tokenUser())
                        .header("Content-Type", "application/json")
                        .queryParam("status", "unsolved")
                        .get(setEndpointGetAllComplaintStatus("valid"));
                break;
            default:
                Assert.fail("Unsupported base type: " + baseType);
        }
    }

    @Step("I receive list of unsolved complaint")
    public void receiveListUnsolvedComplaint() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SUCCESS_GET_SOLVED_COMPLAINT_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I receive list of solved complaint")
    public void receiveListSolvedComplaint() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SUCCESS_GET_SOLVED_COMPLAINT_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
