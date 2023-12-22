package starter.gocat.user.category;

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

public class GetCategoryById {



    private static final RequestSpecification requestSpec;

    static {
        requestSpec = SerenityRest.given()
                .header("Authorization", "Bearer " + tokenUser())
                .header("Content-Type", "application/json");
    }

    @Step("I set {String} endpoint for get category by id")
    public String setEndpointGetCategoryById(String endpointType) {
        String endpoint = null;
        switch (endpointType) {
            case "valid":
                endpoint = userCategoryUrl + "/lMJm4r";
                break;
            case "invalid":
                endpoint = invUrl;
                break;
            default:
                Assert.fail("Unsupported base type: " + endpointType);
        }
        return endpoint;
    }

    @Step("I send get request to {String} get category by id endpoint")
    public void sendGetBaseTypeGetCategoryByIdEndpoint(String baseType) {
        switch (baseType) {
            case "valid":
                requestSpec
                        .get(setEndpointGetCategoryById("valid"));
                break;
            case "invalid":
                requestSpec
                        .get(setEndpointGetCategoryById("invalid"));
                break;
            default:
                Assert.fail("Unsupported base type: " + baseType);
        }
    }

    @Step("I send get request to valid get category by idendpoint without token")
    public void  getCategoryByIdWithoutToken() {
        SerenityRest.given()
                .header("Content-Type", "application/json")
                .get(setEndpointGetCategoryById("valid"));
    }

    @Step("I receive detail category")
    public void receiveDetailCategory() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.SUCCESS_GET_CATEGORY_BY_ID_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}

