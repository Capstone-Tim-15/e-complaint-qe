package starter.gocat.user.auth;

import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;
import static starter.Url.invUrl;
import static starter.Url.userUrl;
import static starter.utils.GenerateToken.tokenUser;

public class GetAllUser {



    private static final RequestSpecification requestSpec;

    static {
        requestSpec = SerenityRest.given()
                .header("Authorization", "Bearer " + tokenUser())
                .header("Content-Type", "application/json");
    }



    @Step("I set {String} endpoint for get all user")
    public String setEndpointGetAllUser(String endpointType) {
        String endpoint = null;
        switch (endpointType) {
            case "valid":
                endpoint = userUrl;
                break;
            case "invalid":
                endpoint = invUrl;
                break;
            default:
                Assert.fail("Unsupported endpoint type: " + endpointType);
                break;
        }
        return endpoint;
    }

    @Step("I send get request to {String} get all user endpoint")
    public void sendGetAllPostToBaseTypeEndpoint(String baseType) {

        switch (baseType) {
            case "valid":
                requestSpec.get(setEndpointGetAllUser("valid"));
                break;
            case "invalid":
                requestSpec.get(setEndpointGetAllUser("invalid"));
                break;
            default:
                Assert.fail("Unsupported base type: " + baseType);
                break;
        }
    }

    @Step("I send {String} request to get all user")
    public void sendOtherMethodToGetAllUser(String methodType) {

        switch (methodType) {
            case "post":
                requestSpec.post(setEndpointGetAllUser("valid"));
                break;
            case "put":
                requestSpec.put(setEndpointGetAllUser("valid"));
                break;
            case "delete":
                requestSpec.delete(setEndpointGetAllUser("valid"));
                break;
            default:
                Assert.fail("Unsupported method: " + methodType);
                break;
        }
    }

    @Step("I receive list of user")
    public void receiveListOfUser() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SUCCESS_GET_ALL_USER_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body("meta", notNullValue()));
        restAssuredThat(response -> response.body("results", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
