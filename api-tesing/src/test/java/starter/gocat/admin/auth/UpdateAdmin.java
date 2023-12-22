package starter.gocat.admin.auth;

import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.json.JSONObject;
import org.junit.Assert;

import static starter.Url.adminUrl;
import static starter.Url.invUrl;
import static starter.utils.GenerateToken.tokenAdmin;

public class UpdateAdmin {


    private static final RequestSpecification requestSpec;

    static {
        requestSpec = SerenityRest.given()
                .header("Authorization", "Bearer " + tokenAdmin())
                .header("Content-Type", "application/json");
    }

    @Step("I set {String} endpoint for update admin")
    public String setEndpointUpdateAdmin(String endpointType) {
        String endpoint = null;
        switch (endpointType) {
            case "valid":
                endpoint = adminUrl + "asVTYs";
                break;
            case "invalid id":
                endpoint = adminUrl + "inv";
                break;
            case "invalid":
                endpoint = invUrl;
                break;
            default:
                Assert.fail("Unsupported base type: " + endpointType);
        }
        return endpoint;
    }

    @Step("I send put request with {String} to valid update admin endpoint")
    public void sendPostValidUpdateAdminEndpoint(String credentialType) {
        JSONObject requestBody = new JSONObject();


        switch (credentialType) {
            case "valid requestBody":
                requestBody.put("name", "Anggun");
                requestBody.put("username", "anggun");
                requestBody.put("email", "qealta@gmail.com");
                requestBody.put("phone", "081234567890");
                requestBody.put("password", "1234567890");
                break;
            case "username of more than 16 characters":
                requestBody.put("name", "Anggun");
                requestBody.put("username", "morethan16character");
                requestBody.put("email", "qealta@gmail.com");
                requestBody.put("phone", "081234567890");
                requestBody.put("password", "1234567890");
                break;
            case "registered username":
                requestBody.put("name", "Anggun");
                requestBody.put("username", "anggun");
                requestBody.put("email", "qealta@gmail.com");
                requestBody.put("phone", "081234567896");
                requestBody.put("password", "1234567890");
                break;
            case "registered email":
                requestBody.put("name", "Anggun");
                requestBody.put("username", "anggun");
                requestBody.put("email", "qealta@gmail.com");
                requestBody.put("phone", "081234567894");
                requestBody.put("password", "1234567890");
                break;
            case "integer password":
                requestBody.put("name", "zara");
                requestBody.put("username", "anggun");
                requestBody.put("email", "qealta@gmail.com");
                requestBody.put("phone", "081234567890");
                requestBody.put("password", 1234567890);
                break;
            case "empty name":
                requestBody.put("name", "");
                requestBody.put("username", "anggun");
                requestBody.put("email", "qealta@gmail.com");
                requestBody.put("phone", "081234567890");
                requestBody.put("password", "1234567890");
                break;
            case "empty username":
                requestBody.put("name", "Anggun");
                requestBody.put("username", "");
                requestBody.put("email", "qealta@gmail.com");
                requestBody.put("phone", "081234567890");
                requestBody.put("password", "1234567890");
                break;
            case "empty email":
                requestBody.put("name", "Anggun");
                requestBody.put("username", "anggun");
                requestBody.put("email", "");
                requestBody.put("phone", "081234567890");
                requestBody.put("password", "1234567890");
                break;
            case "empty phone":
                requestBody.put("name", "Anggun");
                requestBody.put("username", "anggun");
                requestBody.put("email", "qealta@gmail.com");
                requestBody.put("phone", "");
                requestBody.put("password", "1234567890");
                break;
            case "empty password":
                requestBody.put("name", "Anggun");
                requestBody.put("username", "anggun");
                requestBody.put("email", "qealta@gmail.com");
                requestBody.put("phone", "081234567890");
                requestBody.put("password", "");
                break;
            default:
                requestBody.put("invalidField", "InvalidValue");
                break;
        }

        requestSpec
                .body(requestBody.toString())
                .put(setEndpointUpdateAdmin("valid"));
    }

    @Step("I send put request with valid requestBody to {String} update admin endpoint")
    public void sendPostBaseTypeUpdateAdminEndpoint(String baseType) {
        JSONObject requestBody = new JSONObject();

        requestBody.put("name", "Anggun");
        requestBody.put("username", "anggun");
        requestBody.put("email", "qealta@gmail.com");
        requestBody.put("phone", "081234567890");
        requestBody.put("password", "1234567890");

        switch (baseType) {
            case "invalid id":
                requestSpec
                        .body(requestBody.toString())
                        .put(setEndpointUpdateAdmin("invalid id"));
                break;
            case "invalid":
                requestSpec
                        .body(requestBody.toString())
                        .put(setEndpointUpdateAdmin("invalid"));
                break;
            default:
                Assert.fail("Unsupported base type: " + baseType);

        }
    }

    @Step("I send {String} request to update admin")
    public void sendOtherMethodToUpdateAdmin(String methodType) {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Anggun");
        requestBody.put("username", "anggun");
        requestBody.put("email", "qealta@gmail.com");
        requestBody.put("phone", "081234567890");
        requestBody.put("password", "1234567890");

        switch (methodType) {
            case "get":
                requestSpec
                        .body(requestBody.toString())
                        .get(setEndpointUpdateAdmin("valid"));
                break;
            case "post":
                requestSpec
                        .body(requestBody.toString())
                        .post(setEndpointUpdateAdmin("valid"));
                break;
            default:
                Assert.fail("Unsupported base type: " + methodType);
        }
    }

}
