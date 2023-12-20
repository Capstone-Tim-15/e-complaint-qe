package starter.gocat.admin.auth;

import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;


import static starter.Url.adminUrl;
import static starter.Url.invUrl;
import static starter.utils.GenerateToken.tokenAdmin;

public class SearchAdminByName {


    private static final RequestSpecification requestNameSpec;

    static {
        requestNameSpec = SerenityRest.given()
                .header("Authorization", "Bearer " + tokenAdmin())
                .queryParam("name", "Anggun")
                .header("Content-Type", "application/json");
    }



    @Step("I set {String} for search admin by name")
    public String setEndpointSearchAdminByName(String endpointNameType) {
        String endpointName = null;
        switch (endpointNameType) {
            case "valid endpoint":
                endpointName = adminUrl + "search";
                break;
            case "invalid endpoint":
                endpointName = invUrl;
                break;
            default:
                Assert.fail("Unsupported endpoint type: " + endpointNameType);
        }
        return endpointName;
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
