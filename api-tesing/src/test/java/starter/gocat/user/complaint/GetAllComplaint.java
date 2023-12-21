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

public class GetAllComplaint {



    private static final RequestSpecification requestSpec;

    static {
        requestSpec = SerenityRest.given()
                .header("Authorization", "Bearer " + tokenUser())
                .header("Content-Type", "application/json");
    }

    @Step("I set {String} endpoint for get all complaint")
    public String setEndpointGetAllComplaint(String endpointType) {
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

    @Step("I send get request to {String} get all complaint endpoint")
    public void sendGetBaseTypeGetAllComplaintEndpoint(String baseType) {
        switch (baseType) {
            case "valid":
                requestSpec
                        .queryParam("page", "1")
                        .get(setEndpointGetAllComplaint("valid"));
                break;
            case "invalid":
                requestSpec
                        .queryParam("page", "1")
                        .get(setEndpointGetAllComplaint("invalid"));
                break;
            case "non-exist":
                requestSpec
                        .queryParam("page", "10000000")
                        .get(setEndpointGetAllComplaint("valid"));
                break;
            default:
                Assert.fail("Unsupported base type: " + baseType);
        }
    }

    @Step("I receive list of complaint")
    public void receiveListComplaint() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SUCCESS_GET_ALL_COMPLAINT_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I receive null complaint result")
    public void receiveNullComplaintResult() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.NULL_COMPLAINT_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
