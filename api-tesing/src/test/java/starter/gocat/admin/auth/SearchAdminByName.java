package starter.gocat.admin.auth;

import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;


import static starter.utils.GenerateToken.tokenAdmin;

public class SearchAdminByName {


    private static RequestSpecification requestNameSpec;

    static {
        requestNameSpec = SerenityRest.given()
                .header("Authorization", "Bearer " + tokenAdmin())
                .queryParam("name", "Anggun")
                .header("Content-Type", "application/json");
    }

    private static String url = "http://34.128.69.15:8000";

    @Step("I set {String} for search admin by name")
    public String setEndpointSearchAdminByName(String endpointNameType) {
        String endpointName = null;
        switch (endpointNameType) {
            case "valid endpoint":
                endpointName = "/admin/search";
                break;
            case "invalid endpoint":
                endpointName = "/adm/";
                break;
            default:
                Assert.fail("Unsupported endpoint type: " + endpointNameType);
        }
        return url + endpointName;
    }

    @Step("I send get request to {String} search admin by name endpoint")
    public void sendGetSearchAdminByNameToBaseTypeEndpoint(String baseType) {

        switch (baseType) {
            case "valid":
                requestNameSpec
                        .get(setEndpointSearchAdminByName("valid endpoint"));
                break;
            case "invalid":
                requestNameSpec
                        .get(setEndpointSearchAdminByName("invalid endpoint"));
                break;
            default:
                Assert.fail("Unsupported base type: " + baseType);
                break;
        }
    }

    @Step("I send get request to valid search admin by name endpoint without login")
    public void sendGetToSearchAdminByNameWithoutLogin() {
        SerenityRest.given()
                .queryParam("name", "try")
                .get(setEndpointSearchAdminByName("valid endpoint"));
    }
}
