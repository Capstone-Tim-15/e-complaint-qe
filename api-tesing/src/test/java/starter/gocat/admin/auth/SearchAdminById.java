package starter.gocat.admin.auth;

import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;
import static starter.utils.GenerateToken.tokenAdmin;

public class SearchAdminById {


    private static RequestSpecification requestSpec;

    static {
        requestSpec = SerenityRest.given()
                .header("Authorization", "Bearer " + tokenAdmin())
                .queryParam("id", "asVTYs")
                .header("Content-Type", "application/json");
    }

    private static String url = "http://34.128.69.15:8000";

    @Step("I set {String} for search admin by id")
    public String setEndpointSearchAdminById(String endpointType) {
        String endpoint = null;
        switch (endpointType) {
            case "valid endpoint":
                endpoint = "/admin/search" ;
                break;
            case "invalid endpoint":
                endpoint = "/invalid/" ;
                break;
            default:
                Assert.fail("Unsupported endpoint type: " + endpointType);
        }
        return url + endpoint;
    }

    @Step("I send get request to {String} search admin by id endpoint")
    public void sendGetSearchAdminByIdToBaseTypeEndpoint(String baseType) {

        switch (baseType) {
            case "valid":
                requestSpec
                        .get(setEndpointSearchAdminById("valid endpoint"));
                break;
            case "invalid":
                requestSpec
                       .get(setEndpointSearchAdminById("invalid endpoint"));
                break;
            case "double query params":
                requestSpec
                        .queryParam("name", "Anggun")
                        .get(setEndpointSearchAdminById("valid endpoint"));
                break;
            default:
                Assert.fail("Unsupported base type: " + baseType);
                break;
        }
    }

    @Step("I send get request to valid search admin by id endpoint without login")
    public void sendGetToSearchAdminByIdWithoutLogin() {
        SerenityRest.given()
                .queryParam("id", "asVTYs")
                .get(setEndpointSearchAdminById("valid endpoint"));
    }

    @Step("I receive that admin detail account")
    public void receiveAdminDetailAccount() {
        JsonSchemaHelper helper = new JsonSchemaHelper();

        String schema = helper.getResponseSchema(JsonSchema.SUCCESS_SEARCH_ADMIN_RESPONSE_SCHEMA);

        restAssuredThat(response -> response.body("meta", notNullValue()));
        restAssuredThat(response -> response.body("results", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }


}
